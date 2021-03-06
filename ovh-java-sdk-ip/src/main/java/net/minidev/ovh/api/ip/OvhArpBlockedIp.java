package net.minidev.ovh.api.ip;

import java.util.Date;

/**
 * ARP blocked IP information
 */
public class OvhArpBlockedIp {
	/**
	 * your IP
	 *
	 * canBeNull && readOnly
	 */
	public String ipBlocked;

	/**
	 * The last blocking date
	 *
	 * canBeNull && readOnly
	 */
	public Date blockedSince;

	/**
	 * this IP address state
	 *
	 * canBeNull && readOnly
	 */
	public OvhArpStateEnum state;

	/**
	 * Time (in seconds) remaining before you can request your IP to be unblocked
	 *
	 * canBeNull && readOnly
	 */
	public Long time;

	/**
	 * ARP logs
	 *
	 * canBeNull && readOnly
	 */
	public String logs;
}
