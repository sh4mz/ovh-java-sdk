package net.minidev.ovh.api.hosting.web;

import net.minidev.ovh.api.complextype.OvhUnitAndValue;
import net.minidev.ovh.api.hosting.web.database.OvhCreationDatabaseCapabilities;

/**
 * Struct which describs an offer
 */
public class OvhCapabilities {
	/**
	 * Describe all databases type you can have
	 *
	 * canBeNull
	 */
	public OvhCreationDatabaseCapabilities[] databases;

	/**
	 * Language available for cron script
	 *
	 * canBeNull
	 */
	public OvhCronLanguageAvailable languages;

	/**
	 * Does the offer allow 1-click modules?
	 *
	 * canBeNull
	 */
	public Boolean moduleOneClick;

	/**
	 * Does the offer allow crontab
	 *
	 * canBeNull
	 */
	public Boolean crontab;

	/**
	 * Number of domains you can attach to your hosting
	 *
	 * canBeNull
	 */
	public Long attachedDomains;

	/**
	 * Number of environment variables allowed for your hosting
	 *
	 * canBeNull
	 */
	public Long envVars;

	/**
	 * Does the offer allow SSH access
	 *
	 * canBeNull
	 */
	public Boolean ssh;

	/**
	 * Describe all privateDatabases type you can have
	 *
	 * canBeNull
	 */
	public OvhCreationDatabaseCapabilities[] privateDatabases;

	/**
	 * Number of sites recommended for your hosting ( -1 for unlimited )
	 *
	 * canBeNull
	 */
	public Long sitesRecommended;

	/**
	 * Describe all email offer you can have
	 *
	 * canBeNull
	 */
	public OvhCreationEmailCapabilities emails;

	/**
	 * Marketing information about the current offer
	 *
	 * canBeNull
	 */
	public OvhHighLightEnum highlight;

	/**
	 * Disk capacity and type available for your hosting ( null for unlimited )
	 *
	 * canBeNull
	 */
	public OvhDiskType disk;

	/**
	 * Number of runtimes allowed for your hosting
	 *
	 * canBeNull
	 */
	public Long runtimes;

	/**
	 * Number of database engines allowed for your hosting
	 *
	 * canBeNull
	 */
	public Long databaseEngines;

	/**
	 * Number of ftp user you can create
	 *
	 * canBeNull
	 */
	public Long extraUsers;

	/**
	 * Does the offer allow access to web files browser?
	 *
	 * canBeNull
	 */
	public Boolean filesBrowser;

	/**
	 * Traffic quota size for your hosting ( null for unlimited )
	 *
	 * canBeNull
	 */
	public OvhUnitAndValue<Double> traffic;
}
