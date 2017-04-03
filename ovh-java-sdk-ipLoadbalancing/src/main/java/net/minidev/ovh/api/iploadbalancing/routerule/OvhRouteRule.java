package net.minidev.ovh.api.iploadbalancing.routerule;

import net.minidev.ovh.api.iploadbalancing.OvhRouteRuleMatchesEnum;

/**
 * Rule of a route
 */
public class OvhRouteRule {
	/**
	 * Name of the field to match like "protocol" or "host". See "/ipLoadbalancing/{serviceName}/route/availableRules" for a list of available rules
	 *
	 * canBeNull && readOnly
	 */
	public String field;

	/**
	 * Invert the matching operator effect
	 *
	 * canBeNull && readOnly
	 */
	public Boolean negate;

	/**
	 * Value to match against this match. Interpretation if this field depends on the match and field
	 *
	 * canBeNull && readOnly
	 */
	public String pattern;

	/**
	 * Matching operator. Not all operators are available for all fields. See "/availableRules"
	 *
	 * canBeNull && readOnly
	 */
	public OvhRouteRuleMatchesEnum match;

	/**
	 * Name of sub-field, if applicable. This may be a Cookie or Header name for instance
	 *
	 * canBeNull && readOnly
	 */
	public String subField;

	/**
	 * Id of your rule
	 *
	 * canBeNull && readOnly
	 */
	public Long ruleId;
}
