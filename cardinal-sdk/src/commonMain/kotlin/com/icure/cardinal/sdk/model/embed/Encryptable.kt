package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String

/**
 *
 *  Interface for DTOs that support end-to-end encryption. Implementing classes carry an encrypted
 * payload
 *  that can be decrypted using the appropriate encryption keys.
 */
public interface Encryptable {
	public val encryptedSelf: Base64String?
}
