package net.minidev.ovh.api.dbaas.logs;

/**
 * Cluster
 */
public class OvhCluster {
	/**
	 * Cluster type
	 *
	 * canBeNull && readOnly
	 */
	public OvhClusterClusterTypeEnum clusterType;

	/**
	 * Is the default cluster?
	 *
	 * canBeNull && readOnly
	 */
	public Boolean isDefault;

	/**
	 * Hostname
	 *
	 * canBeNull && readOnly
	 */
	public String hostname;

	/**
	 * PEM for dedicated inputs
	 *
	 * canBeNull && readOnly
	 */
	public String dedicatedInputPEM;

	/**
	 * Cluster UUID
	 *
	 * canBeNull && readOnly
	 */
	public String clusterId;

	/**
	 * Data center localization
	 *
	 * canBeNull && readOnly
	 */
	public OvhClusterRegionEnum region;

	/**
	 * PEM for direct inputs
	 *
	 * canBeNull && readOnly
	 */
	public String directInputPEM;
}
