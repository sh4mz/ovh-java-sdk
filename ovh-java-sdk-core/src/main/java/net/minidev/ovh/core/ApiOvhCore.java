package net.minidev.ovh.core;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;

//import net.minidev.ovh.api.ApiOvh;
import net.minidev.ovh.api.ApiOvhAuth;
import net.minidev.ovh.api.auth.OvhAccessRule;
import net.minidev.ovh.api.auth.OvhCredential;
import net.minidev.ovh.api.auth.OvhMethodEnum;

public class ApiOvhCore {
	private String[] DEFAULT_ACCESS_RULES = new String[] { "DELETE /*", "GET /*", "POST /*", "PUT /*" };
	/**
	 * Optional Handlers
	 */
	private TreeMap<String, TreeMap<String, OphApiHandler>> mtdHandler;
	private String[] accessRules = DEFAULT_ACCESS_RULES;
	/**
	 * optional cache manager
	 */
	private CacheManager cacheManager;

	/**
	 * register and handlet linked to a method
	 * 
	 * @param method
	 *            GET PUT POST DELETE or ALL
	 * @param url
	 * @param handler
	 */
	public void registerHandler(String method, String url, OphApiHandler handler) {
		if (mtdHandler == null)
			mtdHandler = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

		TreeMap<String, OphApiHandler> reg;
		if (method == null)
			method = "ALL";
		reg = mtdHandler.get(method);
		if (reg == null) {
			reg = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
			mtdHandler.put(method, reg);
		}
		reg.put(url, handler);
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	private ApiOvhConfig config;
	/**
	 * log
	 */
	private final static Logger log = LoggerFactory.getLogger(ApiOvhCore.class);
	/**
	 * encoding
	 */
	private final static Charset UTF8 = Charset.forName("UTF-8");
	/**
	 * Store authenticated ApiOvhCore
	 */
	private final static HashMap<String, ApiOvhCore> cache = new HashMap<String, ApiOvhCore>();
	/**
	 * consumerKey
	 */
	private String consumerKey = null;

	public String getConsumerKey() {
		if (consumerKey == null)
			consumerKey = config.getConsumerKey();
		if (consumerKey == null)
			throw new NullPointerException("ConsumerKey can not be null");
		return consumerKey;
	}

	// nic / passwor auth
	private String nic;
	private String password;
	//
	private int timeInSec;
	/**
	 * user to Synchronize timeStamp
	 */
	private Long timeOffset;

	/**
	 * Overwrite Default accessRules (DELETE /*, GET /*, POST /*, PUT /*) If called
	 * with no parameter the Default Rules will be used.
	 * 
	 * @param accessRules
	 */
	public void setAccessRules(String... accessRules) {
		if (accessRules == null)
			this.accessRules = DEFAULT_ACCESS_RULES;
		else
			this.accessRules = accessRules;
	}

	/**
	 * create a new APIOVH
	 */
	public ApiOvhCore() {
		this(ApiOvhConfig.config);
	}

	/**
	 * create a new APIOVH
	 */
	public ApiOvhCore(ApiOvhConfig config) {
		this.config = config;
	}

	/**
	 * Connect to OVH using nic/password
	 * 
	 * @param nic
	 * @param password
	 */
	public ApiOvhCore(String nic, String password) {
		this();
		this.nic = nic;
		this.password = password;
	}

	/**
	 * Connect to OVH using nic/password
	 * 
	 * @param nic
	 * @param password
	 */
	public ApiOvhCore(ApiOvhConfig config, String nic, String password) {
		this(config);
		this.nic = nic;
		this.password = password;
	}

	public static ApiOvhCore getInstance(String ac, String password) {
		return getInstance(ac, password, 900);
	}

	/**
	 * Connect to the OVH API using a consumerKey contains in your ovh config file
	 * or environment variable
	 * 
	 * @return an ApiOvhCore authenticate by consumerKey
	 */
	public static ApiOvhCore getInstance() {
		ApiOvhCore core = new ApiOvhCore();
		core.consumerKey = core.config.getConsumerKey();
		if (core.consumerKey == null) {
			log.error("no consumerKey present in your ovh.cong (consumer_key) or environement (OVH_CONSUMER_KEY)");
			return null;
		}
		return core;
	}

	/**
	 * Connect to the OVH API using a consumerKey
	 * 
	 * @param consumerKey
	 *            the consumerKey
	 * @return an ApiOvhCore authenticate by consumerKey
	 */
	public static ApiOvhCore getInstance(String consumerKey) {
		ApiOvhCore core = new ApiOvhCore();
		core.consumerKey = consumerKey;
		return core;
	}

	public static ApiOvhCore getInstance(String ac, String password, int timeInSec) {
		ApiOvhCore core = cache.get(ac);
		if (core != null)
			return core;
		synchronized (cache) {
			// double check instance availability
			core = cache.get(ac);
			if (core != null)
				return core;
			core = new ApiOvhCore();
			try {
				core.login(ac, password, timeInSec);
			} catch (Exception e) {
				log.error("login account {} failure", ac, e);
				return null;
			}
			cache.put(ac, core);
		}
		return core;
	}

	private HttpURLConnection getRequest(String method, URL url) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod(method);
		connection.setReadTimeout(60000);
		connection.setConnectTimeout(60000);
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setRequestProperty("X-Ovh-Application", config.getApplicationKey());
		return connection;
	}

	public String getNic() {
		return nic;
	}

	public ApiOvhCore clone() {
		ApiOvhCore api = new ApiOvhCore();
		api.consumerKey = this.consumerKey;
		api.nic = this.nic;
		api.password = this.password;
		api.timeInSec = this.timeInSec;
		api.timeOffset = this.timeOffset;
		api.mtdHandler = this.mtdHandler;
		return api;
	}

	/**
	 * sync local and remote time
	 */
	private void syncTime() {
		try {
			Long ovhTime = new ApiOvhAuth(this).time_GET();
			long myTime = System.currentTimeMillis() / 1000L;
			timeOffset = myTime - ovhTime;
		} catch (Exception e) {
			log.error("Failed syncronized Ovh Clock");
			timeOffset = 0L;
		}
	}

	private String getTimestamp() {
		if (timeOffset == null)
			syncTime();
		long now = System.currentTimeMillis() / 1000L;
		now -= timeOffset;
		return Long.toString(now);
	}

	/**
	 * Create a new CK from a nic/password
	 */
	public boolean login(String nic, String password, int timeInSec) throws IOException {
		if (password == null) {
			// using CK only, no autologin
			return false;
		}
		nic = nic.toLowerCase();
		this.nic = nic;
		this.password = password;
		this.timeInSec = timeInSec;
		int retry = 10;

		String lastKey = config.getConsumerKey(nic);
		if (lastKey != null) {
			this.consumerKey = lastKey;
			return true;
		}
		// CK;
		while (!loginInternal(nic, password, timeInSec)) {
			retry--;
			if (retry <= 0) {
				log.error("LOGIN failure to {} after 10 retry", nic);
				return false;
			}
			ApiOvhUtils.sleep(2000);
		}
		return true;
	}

	/**
	 * Try to create a new CK from a nic/password
	 * 
	 * @param nic
	 * @param password
	 * @param timeInSec
	 * @return
	 * @throws IOException
	 */
	private boolean loginInternal(String nic, String password, int timeInSec) throws IOException {
		synchronized (nic.intern()) {
			String oldCK = config.getConsumerKey(nic);
			if (oldCK != null && consumerKey != null && !oldCK.equals(consumerKey)) {
				// a new CK is available try it first.
				consumerKey = oldCK;
				return true;
			}
			OvhCredential token = requestToken(null);
			log.info("validationUrl Url:{}", token.validationUrl);

			Document doc = Jsoup.connect(token.validationUrl).get();
			String html = doc.toString();
			if (html.contains("Too much requests"))
				return false;
			// <input type="hidden" name="sT" id="sT" value="XXXXX">
			Element st = doc.getElementById("sT");
			FormElement form = null;
			// get Parent Form
			for (Element elm : st.parents()) {
				// "form".equalsIgnoreCase(elm.tagName())
				if (elm instanceof FormElement) {
					form = (FormElement) elm;
					break;
				}
			}
			Elements inputs = form.select("input");
			Connection validForm = Jsoup.connect(token.validationUrl);
			validForm.followRedirects(false);
			// fill user and password field
			for (Element e : inputs) {
				String value = e.attr("value");
				String type = e.attr("type");
				if ("text".equals(type))
					value = nic;
				else if ("password".equals(type))
					value = password;
				validForm.data(e.attr("name"), value);
			}
			// set Expiration Date
			validForm.data("duration", Integer.toString(timeInSec));
			Document doc2 = validForm.post();
			Elements p = doc2.select("p");
			String pText = p.text();
			if ("The document has moved here.".equals(pText)) {
				consumerKey = token.consumerKey;
				config.setConsumerKey(nic, consumerKey);
				return true;
			}
			if ("Your token is now valid, you can use it in your application".equals(pText)) {
				consumerKey = token.consumerKey;
				config.setConsumerKey(nic, consumerKey);
				return true;
			}
			String error = doc2.select("div.error").text();
			if (error != null && error.length() > 0)
				log.error("Login Error:{}", error);
			else
				log.error("Error missing redirect in body:{}", doc2.toString());
			return false;
		}
	}

	/**
	 * Request for a new Token with full access
	 * 
	 * @param redirection
	 * @return a new OvhCredential
	 */
	public OvhCredential requestToken(String redirection) throws IOException {
		OvhAccessRule[] accessRules = new OvhAccessRule[this.accessRules.length];

		for (int i = 0; i < this.accessRules.length; i++) {
			String rule = this.accessRules[i];
			int p = rule.indexOf(" ");
			if (p == -1)
				throw new IOException("Invalid rule " + rule);
			String mtd = rule.substring(0, p);
			String path = rule.substring(p + 1);
			accessRules[i] = new OvhAccessRule();
			// GET POST PUT DELETE
			accessRules[i].method = OvhMethodEnum.valueOf(mtd.toUpperCase());
			// /*
			accessRules[i].path = path;
		}
		ApiOvhAuth auth = new ApiOvhAuth(this);
		return auth.credential_POST(accessRules, redirection);
	}

	/**
	 * Call REST entry point and handle errors
	 * 
	 * @param method
	 * @param query
	 * @param payload
	 * @param needAuth
	 * @return Full response as String
	 * @throws IOException
	 */
	public String exec(String apiPath, String method, String query, Object payload, boolean needAuth)
			throws IOException {
		if (payload == null)
			payload = "";

		String responseText = null;

		boolean cached = false;
		if (cacheManager != null) {
			responseText = cacheManager.getCache(apiPath, method, query, payload);
			if (responseText != null)
				cached = true;
		}

		if (responseText == null)
			try {
				responseText = execInternal(method, query, payload, needAuth);
			} catch (OvhException e0) {
				throw e0;
			} catch (OvhServiceException e0) {
				throw e0;
			} catch (SocketTimeoutException e1) {
				log.error("CNX TIME OUT");
				responseText = execInternal(method, query, payload, needAuth);
			} catch (IOException e2) {
				log.error("API OVH ERROR", e2);
				throw e2;
			}
		if (cacheManager != null && !cached)
			cacheManager.setCache(apiPath, method, query, payload, responseText);

		if (mtdHandler != null) {
			for (String mtd : new String[] { method, "ALL" }) {
				TreeMap<String, OphApiHandler> handlers = null;
				OphApiHandler handler = null;
				handlers = mtdHandler.get(mtd);
				if (handlers == null)
					continue;
				handler = handlers.get(apiPath);
				if (handler == null)
					continue;
				try {
					handler.accept(method, method, payload, responseText);
				} catch (Exception e) {
					log.warn("Handler throw exeption on {} {} : {}", method, method, e);
				}
			}
		}
		return responseText;
	}

	private String execInternal(final String method, final String query, final Object payload, boolean needAuth)
			throws IOException {
		String txt = ApiOvhUtils.objectJsonBody(payload);
		URL url = new URL(config.getEndpoint() + query);
		int failure = 0;
		String response = "";
		// retry loop
		String CK = null;
		while (true) {

			HttpURLConnection connection = getRequest(method, url);
			if (needAuth) {
				CK = this.getConsumerKey();
				String timestamp = getTimestamp();
				String toHash = config.getAppSecret() + "+" + CK + "+" + method + "+" + url + "+" + txt + "+"
						+ timestamp;
				String sig = "$1$" + ApiOvhUtils.digestSha1(toHash.getBytes(UTF8));
				connection.setRequestProperty("X-Ovh-Timestamp", timestamp);
				connection.setRequestProperty("X-Ovh-Signature", sig);
				connection.setRequestProperty("X-Ovh-Consumer", CK);
			}
			if (txt != null && txt.length() > 0) {
				connection.setDoOutput(true);
				DataOutputStream out = new DataOutputStream(connection.getOutputStream());
				out.writeBytes(txt);
				out.flush();
				out.close();
			}

			String inputLine;
			int responseCode = connection.getResponseCode();
			InputStream stream = (responseCode == 200) ? connection.getInputStream() : connection.getErrorStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(stream));
			// build response
			StringBuilder responseSb = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				responseSb.append(inputLine);
			}
			in.close();
			response = responseSb.toString();
			// XML response
			if (response.startsWith("<") && response.contains("<title>500 Internal Server Error</title>")) {
				ApiOvhUtils.sleep(500);
				failure++;
				if (failure >= 5)
					throw new IOException(method + " " + query + " " + txt + " return: 500 Internal Server Error after "
							+ failure + " retry TS: " + new Date());
				continue;
			}

			if (response.startsWith("{\"errorCode\":")) {
				// errorCode=INVALID_CREDENTIAL, httpCode=403 Forbidden, message=This credential
				// is not valid
				OvhErrorMessage err = ApiOvhUtils.mapper.readValue(response, OvhErrorMessage.class);

				boolean credentialError = err.isErrorCode(OvhErrorMessage.INVALID_CREDENTIAL,
						OvhErrorMessage.NOT_CREDENTIAL);

				if (credentialError && failure < 5) {
					if (nic == null) {
						log.error("{} and no nic/password provided, reconnection aboard", err.errorCode);
					} else {
						this.consumerKey.equals(CK);
						config.invalidateConsumerKey(nic, CK);
						failure++;
						login(this.nic, this.password, this.timeInSec);
						continue;
					}
				}
				if (err.isErrorCode(OvhErrorMessage.QUERY_TIME_OUT) && failure < 5) {
					ApiOvhUtils.sleep(100);
					failure++;
					continue;
				}
				// NOT_CREDENTIAL error ?
				String queryId = connection.getHeaderField("X-OVH-QUERYID");
				if (err.isErrorCode(OvhErrorMessage.NOT_GRANTED_CALL)) {
					throw new OvhException(method, query, err, queryId);
				}
				throw new OvhException(method, query, err, queryId);
			}
			break;
		}

		if (response.startsWith("{\"message\":")) {
			LinkedHashMap<String, Object> obj = ApiOvhUtils.mapper.readValue(response, t1);
			Object message1 = obj.get("message");
			String message = (String) message1;
			if ("This service is expired".equals(message))
				throw new OvhServiceException(url.toString(), message);
			if ("This service does not exist".equals(message))
				throw new OvhServiceException(url.toString(), message);
			if (message.startsWith("The requested object"))
				// The requested object (id = 10884320) does not exist
				throw new OvhServiceException(url.toString(), message);
			throw new OvhServiceException(url.toString(), message);
			// throw new IOException(method + " " + url + " " + txt + " return: " +
			// message);
		}
		return response;
	}

	private final static TypeReference<LinkedHashMap<String, Object>> t1 = new TypeReference<LinkedHashMap<String, Object>>() {
	};

	// private final static TypeReference<Map<String, Object>> t2 = new
	// TypeReference<Map<String, Object>>() {
	// };
}
