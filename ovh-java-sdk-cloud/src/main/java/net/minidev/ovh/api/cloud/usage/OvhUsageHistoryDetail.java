package net.minidev.ovh.api.cloud.usage;

import java.util.Date;
import net.minidev.ovh.api.cloud.billingview.OvhHourlyResources;
import net.minidev.ovh.api.cloud.billingview.OvhMonthlyResources;

/**
 * UsageHistoryDetail
 */
public class OvhUsageHistoryDetail {
	/**
	 * Usage dates (from/to)
	 *
	 * canBeNull && readOnly
	 */
	public OvhPeriod period;

	/**
	 * Monthly usage
	 *
	 * canBeNull && readOnly
	 */
	public OvhMonthlyResources monthlyUsage;

	/**
	 * Entry last update
	 *
	 * canBeNull && readOnly
	 */
	public Date lastUpdate;

	/**
	 * Usage id
	 *
	 * canBeNull && readOnly
	 */
	public String id;

	/**
	 * Hourly usage
	 *
	 * canBeNull && readOnly
	 */
	public OvhHourlyResources hourlyUsage;
}
