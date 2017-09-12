package net.minidev.ovh.api.dedicated;

/**
 * A structure describing the availabilities of dedicated server
 */
public class OvhAvailabilitiesRaw {
	/**
	 * Product reference
	 *
	 * canBeNull
	 */
	public String reference;

	/**
	 * Last availability rule applied
	 *
	 * canBeNull
	 */
	public String lastRule;

	/**
	 * Ordered count
	 *
	 * canBeNull
	 */
	public Long ordered;

	/**
	 * Validating order count
	 *
	 * canBeNull
	 */
	public Long orderedCheck;

	/**
	 * 4H count
	 *
	 * canBeNull
	 */
	public Long trueAvailable4H;

	/**
	 * Region where is located the product
	 *
	 * canBeNull
	 */
	public OvhAvailabilityRegionEnum zone;

	/**
	 * 24H count
	 *
	 * canBeNull
	 */
	public Long trueAvailable24H;

	/**
	 * Real stock (considering order in validating)
	 *
	 * canBeNull
	 */
	public Long trueAvailable;

	/**
	 * Real stock in database
	 *
	 * canBeNull
	 */
	public Long available;

	/**
	 * Blockbuster stock count
	 *
	 * canBeNull
	 */
	public Long parentAvailable;

	/**
	 * Stock in datacenter
	 *
	 * canBeNull
	 */
	public Long incomingDatacenter;

	/**
	 * The availability
	 *
	 * canBeNull
	 */
	public OvhAvailabilityEnum availability;
}
