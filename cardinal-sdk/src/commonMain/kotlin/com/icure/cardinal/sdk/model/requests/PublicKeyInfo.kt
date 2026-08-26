// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.requests

import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import kotlinx.serialization.Serializable

/**
 *
 *  A public key of a data owner and the encryption algorithm it must be used with. A key appears at
 * most once in a
 *  [DataOwnerPublicKeysDto]: a keypair is generated for one scheme, so a key that a data owner
 * happens to have
 *  declared for both is reported as the sha256 one.
 */
@Serializable
data class PublicKeyInfo(
	public val publicKey: SpkiHexString,
	public val algorithm: RsaEncryptionAlgorithm,
) {
	// region PublicKeyInfo-PublicKeyInfo
	// endregion
}
