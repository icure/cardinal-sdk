// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.security

import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Associates a JWT or authentication token with the group context in which it is valid.
 */
@Serializable
data class TokenWithGroup(
	/**
	 * The authentication token string.
	 */
	public val token: String,
	/**
	 * The identifier of the group this token is scoped to.
	 */
	public val groupId: String,
	/**
	 * The human-readable name of the group, if available.
	 */
	public val groupName: String? = null,
) {
	// region TokenWithGroup-TokenWithGroup

	// endregion
}
