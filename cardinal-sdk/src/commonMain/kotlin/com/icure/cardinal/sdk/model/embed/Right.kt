// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

/**
 * Represents the access rights of a user, specifying read, write, and administration permissions.
 * /
 */
@Serializable
data class Right(
	/**
	 * The identifier of the user these rights apply to.
	 */
	public val userId: String? = null,
	/**
	 * Whether the user has read permission.
	 */
	@param:DefaultValue("false")
	public val read: Boolean = false,
	/**
	 * Whether the user has write permission.
	 */
	@param:DefaultValue("false")
	public val write: Boolean = false,
	/**
	 * Whether the user has administration permission.
	 */
	@param:DefaultValue("false")
	public val administration: Boolean = false,
) {
	// region Right-Right

	// endregion
}
