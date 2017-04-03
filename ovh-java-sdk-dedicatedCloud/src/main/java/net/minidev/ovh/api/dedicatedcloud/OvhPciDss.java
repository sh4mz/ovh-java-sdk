package net.minidev.ovh.api.dedicatedcloud;

import net.minidev.ovh.api.dedicatedcloud.pcidss.OvhStateEnum;

/**
 * The Private Cloud PCI-DSS option
 */
public class OvhPciDss {
	/**
	 * State of the option
	 *
	 * canBeNull && readOnly
	 */
	public OvhStateEnum state;
}
