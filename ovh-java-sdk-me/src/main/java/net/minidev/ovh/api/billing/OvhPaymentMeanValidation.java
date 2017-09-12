package net.minidev.ovh.api.billing;

/**
 * A validation required to add a payment mean
 */
public class OvhPaymentMeanValidation {
	/**
	 * canBeNull
	 */
	public OvhPaymentMeanValidationType validationType;

	/**
	 * canBeNull
	 */
	public Long id;

	/**
	 * canBeNull
	 */
	public String finalizeUrl;

	/**
	 * canBeNull
	 */
	public String url;
}
