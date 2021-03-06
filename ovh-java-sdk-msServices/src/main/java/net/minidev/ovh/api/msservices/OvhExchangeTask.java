package net.minidev.ovh.api.msservices;

import java.util.Date;

/**
 * Exchange task details
 */
public class OvhExchangeTask {
	/**
	 * Function name
	 *
	 * canBeNull && readOnly
	 */
	public String function;

	/**
	 * Creation date
	 *
	 * canBeNull && readOnly
	 */
	public Date todoDate;

	/**
	 * Completion date
	 *
	 * canBeNull && readOnly
	 */
	public Date finishDate;

	/**
	 * Task id
	 *
	 * canBeNull && readOnly
	 */
	public Long id;

	/**
	 * Task status
	 *
	 * canBeNull && readOnly
	 */
	public OvhTaskStatusEnum status;
}
