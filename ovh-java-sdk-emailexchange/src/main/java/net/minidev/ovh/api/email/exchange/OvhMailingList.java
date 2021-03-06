package net.minidev.ovh.api.email.exchange;

import java.util.Date;

/**
 * Mailing list
 */
public class OvhMailingList {
	/**
	 * Account was sending spam
	 *
	 * canBeNull && readOnly
	 */
	public Boolean spamDetected;

	/**
	 * Maximum receive email size in MB
	 *
	 * canBeNull && readOnly
	 */
	public Long maxReceiveSize;

	/**
	 * Ticket number of spam detection
	 *
	 * canBeNull && readOnly
	 */
	public Long spamTicketNumber;

	/**
	 * Name displayed in Global Access List
	 *
	 * canBeNull && readOnly
	 */
	public String displayName;

	/**
	 * Update date
	 *
	 * canBeNull && readOnly
	 */
	public Date lastUpdateDate;

	/**
	 * If true sender has to authenticate
	 *
	 * canBeNull && readOnly
	 */
	public Boolean senderAuthentification;

	/**
	 * Creation date
	 *
	 * canBeNull && readOnly
	 */
	public Date creationDate;

	/**
	 * Task pending id
	 *
	 * canBeNull && readOnly
	 */
	public Long taskPendingId;

	/**
	 * Maximum send email size in MB
	 *
	 * canBeNull && readOnly
	 */
	public Long maxSendSize;

	/**
	 * The mailing list address
	 *
	 * canBeNull && readOnly
	 */
	public String mailingListAddress;

	/**
	 * If true mailing list is hiddend in Global Address List
	 *
	 * canBeNull && readOnly
	 */
	public Boolean hiddenFromGAL;

	/**
	 * Join restriction policy
	 *
	 * canBeNull && readOnly
	 */
	public OvhMailingListJoinRestrictionEnum joinRestriction;

	/**
	 * Mailing list state
	 *
	 * canBeNull && readOnly
	 */
	public OvhObjectStateEnum state;

	/**
	 * Depart restriction policy
	 *
	 * canBeNull && readOnly
	 */
	public OvhMailingListDepartRestrictionEnum departRestriction;
}
