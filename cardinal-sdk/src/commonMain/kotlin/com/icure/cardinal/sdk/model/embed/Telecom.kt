// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.String

sealed interface Telecom : Encryptable {
	public val telecomType: TelecomType?

	public val telecomNumber: String?

	public val telecomDescription: String?

	override val encryptedSelf: Base64String?
	// region Telecom-Telecom

	// endregion
}

@Serializable
data class DecryptedTelecom(
	override val telecomType: TelecomType? = null,
	override val telecomNumber: String? = null,
	override val telecomDescription: String? = null,
	override val encryptedSelf: Base64String? = null,
) : Telecom {
	// region Telecom-DecryptedTelecom

	// endregion
}

@Serializable
data class EncryptedTelecom(
	override val telecomType: TelecomType? = null,
	override val telecomNumber: String? = null,
	override val telecomDescription: String? = null,
	override val encryptedSelf: Base64String? = null,
) : Telecom {
	// region Telecom-EncryptedTelecom

	// endregion
}
