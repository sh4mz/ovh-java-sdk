package net.minidev.ovh.api.cdn.webstorage;

/**
 * Type of statistics related to cache
 */
public enum OvhStatsTypeEnum {
	backend("backend"),
	cdn("cdn"),
	quota("quota");

	final String value;

	OvhStatsTypeEnum(String s) {
		this.value = s;
	}

	public String toString() {
		return this.value;
	}
}
