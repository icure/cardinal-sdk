// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.security

import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

/**
 * Represents an authentication token associated with a user, including its creation time and
 * validity period.
 * The token value is stored in encrypted form.
 * /
 */
@Serializable
data class AuthenticationToken(
	/**
	 * The encrypted token string.
	 */
	public val token: String? = null,
	/**
	 * The epoch-millisecond timestamp at which the token became valid.
	 */
	public val creationTime: Long,
	/**
	 * The duration in seconds for which the token remains valid after creation.
	 */
	public val validity: Long,
	/**
	 * The epoch-millisecond timestamp of a hard deletion, if the token has been marked for deletion.
	 */
	public val deletionDate: Long? = null,
) {
	// region AuthenticationToken-AuthenticationToken

	// endregion
}
