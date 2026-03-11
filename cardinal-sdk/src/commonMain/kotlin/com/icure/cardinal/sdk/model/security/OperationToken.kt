// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.security

import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

/**
 * Represents a short-lived token that authorizes a single privileged operation (e.g. group
 * transfer).
 * The token is stored as a hash rather than in plain text.
 * /
 */
@Serializable
data class OperationToken(
	/**
	 * The hash of the operation token.
	 */
	public val tokenHash: String,
	/**
	 * The epoch-millisecond timestamp at which the token was created.
	 */
	public val creationTime: Long,
	/**
	 * The duration in seconds for which the token remains valid after creation.
	 */
	public val validity: Long,
	/**
	 * The specific operation this token is intended to authorize.
	 */
	public val operation: Operation,
	/**
	 * An optional human-readable description of the token's purpose.
	 */
	public val description: String? = null,
) {
	// region OperationToken-OperationToken

	// endregion
}
