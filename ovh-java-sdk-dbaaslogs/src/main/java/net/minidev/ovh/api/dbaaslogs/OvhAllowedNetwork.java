package net.minidev.ovh.api.dbaaslogs;

/**
 * Network allowed to join input
 */
public class OvhAllowedNetwork {
	/**
	 * Network UUID
	 *
	 * canBeNull && readOnly
	 */
	public String allowedNetworkId;

	/**
	 * IP block
	 *
	 * canBeNull && readOnly
	 */
	public String network;
}
