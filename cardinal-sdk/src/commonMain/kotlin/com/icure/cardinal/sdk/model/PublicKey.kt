// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * DTO representing the public key of a healthcare party, used for end-to-end encryption.
 * /
 */
@Serializable
data class PublicKey(
	/**
	 * The identifier of the healthcare party that owns this public key.
	 */
	public val hcPartyId: String? = null,
	/**
	 * The public key encoded as a hexadecimal string.
	 */
	public val hexString: String? = null,
) {
	// region PublicKey-PublicKey

	// endregion
}
