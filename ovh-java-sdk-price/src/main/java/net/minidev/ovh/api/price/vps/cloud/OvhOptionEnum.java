package net.minidev.ovh.api.price.vps.cloud;

/**
 * Enum of Options
 */
public enum OvhOptionEnum {
	ftpbackup("ftpbackup"),
	ip("ip"),
	snapshot("snapshot"),
	veeam("veeam");

	final String value;

	OvhOptionEnum(String s) {
		this.value = s;
	}

	public String toString() {
		return this.value;
	}
}
