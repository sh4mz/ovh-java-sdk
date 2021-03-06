package net.minidev.ovh.api.registry;

import java.util.Date;
import net.minidev.ovh.api.registry.permission.OvhStatus;

/**
 * Permissions of a user over a namespace
 */
public class OvhPermissions {
	/**
	 * Date of the resource creation
	 *
	 * canBeNull && readOnly
	 */
	public Date createdAt;

	/**
	 * Whether a user can read images on the namespace
	 *
	 * canBeNull && readOnly
	 */
	public Boolean canRead;

	/**
	 * Whether a user can create images on the namespace
	 *
	 * canBeNull && readOnly
	 */
	public Boolean canWrite;

	/**
	 * Whether a user can delete images on the namespace
	 *
	 * canBeNull && readOnly
	 */
	public Boolean isAdmin;

	/**
	 * Permission Id
	 *
	 * canBeNull && readOnly
	 */
	public String id;

	/**
	 * User Id
	 *
	 * canBeNull && readOnly
	 */
	public String userId;

	/**
	 * Date of the resource last update
	 *
	 * canBeNull && readOnly
	 */
	public Date updatedAt;

	/**
	 * The status of the permission
	 *
	 * canBeNull && readOnly
	 */
	public OvhStatus status;
}
