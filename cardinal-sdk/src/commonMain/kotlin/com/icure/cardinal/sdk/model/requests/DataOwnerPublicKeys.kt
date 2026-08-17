// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.requests

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 *
 *  The public keys of a data owner, each with the encryption algorithm it must be used with.
 */
@Serializable
data class DataOwnerPublicKeys(
	public val dataOwnerId: String,
	public val publicKeys: List<PublicKeyInfo>,
) {
	// region DataOwnerPublicKeys-DataOwnerPublicKeys
	// endregion
}
