package net.minidev.ovh.api.email.pro;

/**
 * Domain type
 */
public enum OvhDomainTypeEnum {
	authoritative("authoritative"),
	nonAuthoritative("nonAuthoritative");

	final String value;

	OvhDomainTypeEnum(String s) {
		this.value = s;
	}

	public String toString() {
		return this.value;
	}
}
