package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface SchoolingInfo : Encryptable {
	public val startDate: Long?

	public val endDate: Long?

	public val school: String?

	public val typeOfEducation: CodeStub?

	override val encryptedSelf: Base64String?
	// region SchoolingInfo-SchoolingInfo

	// endregion
}

@Serializable
data class DecryptedSchoolingInfo(
	override val startDate: Long? = null,
	override val endDate: Long? = null,
	override val school: String? = null,
	override val typeOfEducation: CodeStub? = null,
	override val encryptedSelf: Base64String? = null,
) : SchoolingInfo {
	// region SchoolingInfo-DecryptedSchoolingInfo

	// endregion
}

@Serializable
data class EncryptedSchoolingInfo(
	override val startDate: Long? = null,
	override val endDate: Long? = null,
	override val school: String? = null,
	override val typeOfEducation: CodeStub? = null,
	override val encryptedSelf: Base64String? = null,
) : SchoolingInfo {
	// region SchoolingInfo-EncryptedSchoolingInfo

	// endregion
}
