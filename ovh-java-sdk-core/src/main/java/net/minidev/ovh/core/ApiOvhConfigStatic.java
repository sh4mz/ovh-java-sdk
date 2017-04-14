package net.minidev.ovh.core;

import java.io.IOException;

public class ApiOvhConfigStatic extends ApiOvhConfig {
	String endPoint;
	String applicationKey;
	String appSecret;
	String consumerKey;

	public ApiOvhConfigStatic(String endPoint, String applicationKey, String appSecret, String consumerKey) {
		if (consumerKey == null)
			throw new NullPointerException("consumerKey can not be null");
		if (applicationKey == null)
			throw new NullPointerException("applicationKey can not be null");
		if (appSecret == null)
			throw new NullPointerException("appSecret can not be null");
		if (endPoint == null)
			throw new NullPointerException("endPoint can not be null");
		this.endPoint = endPoint;
		this.applicationKey = applicationKey;
		this.appSecret = appSecret;
		this.consumerKey = consumerKey;
	}

	@Override
	protected String getEndpoint() {
		return endPoint;
	}

	@Override
	protected String getApplicationKey() {
		return applicationKey;
	}

	@Override
	protected String getAppSecret() {
		return appSecret;
	}

	@Override
	protected String getConsumerKey() {
		return consumerKey;
	}

	@Override
	protected String getConsumerKey(String nic) throws IOException {
		return consumerKey;
	}

	@Override
	protected void setConsumerKey(String nic, String CK) throws IOException {
	}

	@Override
	protected boolean invalidateConsumerKey(String nic, String CK) throws IOException {
		return false;
	}

}
