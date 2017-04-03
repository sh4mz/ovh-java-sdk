package net.minidev.ovh.api.hosting.web.database;

/**
 * Database capabitities type enum
 */
public enum OvhDatabaseCapabilitiesTypeEnum {
	extraSqlPerso("extraSqlPerso"),
	privateDatabase("privateDatabase"),
	sqlPerso("sqlPerso"),
	sqlPro("sqlPro");

	final String value;

	OvhDatabaseCapabilitiesTypeEnum(String s) {
		this.value = s;
	}

	public String toString() {
		return this.value;
	}
}
