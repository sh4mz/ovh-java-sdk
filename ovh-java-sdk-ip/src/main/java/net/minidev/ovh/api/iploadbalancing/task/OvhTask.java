package net.minidev.ovh.api.iploadbalancing.task;

import java.util.Date;
import net.minidev.ovh.api.iploadbalancing.OvhTaskActionEnum;
import net.minidev.ovh.api.iploadbalancing.OvhTaskStatusEnum;

/**
 * IP Load Balancing Operations
 */
public class OvhTask {
	/**
	 * Operation type
	 *
	 * canBeNull && readOnly
	 */
	public OvhTaskActionEnum action;

	/**
	 * Operation progress percentage
	 *
	 * canBeNull && readOnly
	 */
	public Long progress;

	/**
	 * Id of the operation
	 *
	 * canBeNull && readOnly
	 */
	public Long id;

	/**
	 * Creation date of your operation
	 *
	 * canBeNull && readOnly
	 */
	public Date creationDate;

	/**
	 * Zone of your Load Balancer which are updated by current Task
	 *
	 * canBeNull && readOnly
	 */
	public String[] zones;

	/**
	 * Done date of your operation
	 *
	 * canBeNull && readOnly
	 */
	public Date doneDate;

	/**
	 * Current status of your operation
	 *
	 * canBeNull && readOnly
	 */
	public OvhTaskStatusEnum status;
}
