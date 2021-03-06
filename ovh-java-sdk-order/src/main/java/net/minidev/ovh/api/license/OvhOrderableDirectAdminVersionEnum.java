package net.minidev.ovh.api.license;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * All versions available for DirectAdmin products
 */
public enum OvhOrderableDirectAdminVersionEnum {
	DIRECTADMIN_1("DIRECTADMIN_1"),
	@JsonProperty("directadmin-license")
	directadmin_license("directadmin-license");

	final String value;

	OvhOrderableDirectAdminVersionEnum(String s) {
		this.value = s;
	}

	public String toString() {
		return this.value;
	}
}
