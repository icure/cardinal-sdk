package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable

/**
 * Data transfer object representing the security configuration of a CouchDB database, defining
 * admin and member access rights.
 * /
 */
@Serializable
public data class Security(
	/**
	 * The access rights for database administrators.
	 */
	@param:DefaultValue("Right()")
	public val admins: Right = Right(),
	/**
	 * The access rights for database members.
	 */
	@param:DefaultValue("Right()")
	public val members: Right = Right(),
)
