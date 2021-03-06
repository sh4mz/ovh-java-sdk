package net.minidev.ovh.api.billing.order.associatedobject;

/**
 * Type of objects an order can be linked to
 */
public enum OvhTypeEnum {
	Bill("Bill"),
	Deposit("Deposit"),
	Refund("Refund"),
	Withdrawal("Withdrawal");

	final String value;

	OvhTypeEnum(String s) {
		this.value = s;
	}

	public String toString() {
		return this.value;
	}
}
