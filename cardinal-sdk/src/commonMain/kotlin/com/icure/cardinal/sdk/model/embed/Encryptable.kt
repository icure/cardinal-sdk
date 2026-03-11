// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String

/**
 *
 *  Interface for DTOs that support end-to-end encryption. Implementing classes carry an encrypted
 * payload
 *  that can be decrypted using the appropriate encryption keys.
 */

interface Encryptable {
	public val encryptedSelf: Base64String?
	// region Encryptable-Encryptable

	// endregion
}
