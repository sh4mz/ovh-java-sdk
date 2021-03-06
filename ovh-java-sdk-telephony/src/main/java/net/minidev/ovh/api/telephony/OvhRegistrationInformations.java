package net.minidev.ovh.api.telephony;

import java.util.Date;

/**
 * Informations about a SIP registration (i.e. IP, port, User-Agent...)
 */
public class OvhRegistrationInformations {
	/**
	 * SIP registration's date
	 *
	 * canBeNull
	 */
	public Date datetime;

	/**
	 * SIP registration's local device port
	 *
	 * canBeNull
	 */
	public Long localPort;

	/**
	 * SIP registration's port
	 *
	 * canBeNull
	 */
	public Long port;

	/**
	 * SIP registration's IP
	 *
	 * canBeNull
	 */
	public String ip;

	/**
	 * SIP registration's domain
	 *
	 * canBeNull
	 */
	public String domain;

	/**
	 * SIP registration's local device IP
	 *
	 * canBeNull
	 */
	public String localIp;

	/**
	 * SIP registration's User-Agent
	 *
	 * canBeNull
	 */
	public String userAgent;
}
