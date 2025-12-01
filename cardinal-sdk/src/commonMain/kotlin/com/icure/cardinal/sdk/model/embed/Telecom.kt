package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.String

public sealed interface Telecom : Encryptable {
	public val telecomType: TelecomType?

	public val telecomNumber: String?

	public val telecomDescription: String?

	override val encryptedSelf: Base64String?
}

@Serializable
public data class DecryptedTelecom(
	override val telecomType: TelecomType? = null,
	override val telecomNumber: String? = null,
	override val telecomDescription: String? = null,
	override val encryptedSelf: Base64String? = null,
) : Telecom

@Serializable
public data class EncryptedTelecom(
	override val telecomType: TelecomType? = null,
	override val telecomNumber: String? = null,
	override val telecomDescription: String? = null,
	override val encryptedSelf: Base64String? = null,
) : Telecom
