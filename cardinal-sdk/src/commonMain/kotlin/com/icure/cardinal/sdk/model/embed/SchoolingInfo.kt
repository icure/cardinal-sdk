package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

public sealed interface SchoolingInfo : Encryptable {
	public val startDate: Long?

	public val endDate: Long?

	public val school: String?

	public val typeOfEducation: CodeStub?

	override val encryptedSelf: Base64String?
}

@Serializable
public data class DecryptedSchoolingInfo(
	override val startDate: Long? = null,
	override val endDate: Long? = null,
	override val school: String? = null,
	override val typeOfEducation: CodeStub? = null,
	override val encryptedSelf: Base64String?,
) : SchoolingInfo

@Serializable
public data class EncryptedSchoolingInfo(
	override val startDate: Long? = null,
	override val endDate: Long? = null,
	override val school: String? = null,
	override val typeOfEducation: CodeStub? = null,
	override val encryptedSelf: Base64String?,
) : SchoolingInfo
