package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Long

public sealed interface EmploymentInfo : Encryptable {
	public val startDate: Long?

	public val endDate: Long?

	public val professionType: CodeStub?

	public val employer: Employer?

	override val encryptedSelf: Base64String?
}

@Serializable
public data class DecryptedEmploymentInfo(
	override val startDate: Long? = null,
	override val endDate: Long? = null,
	override val professionType: CodeStub? = null,
	override val employer: Employer? = null,
	override val encryptedSelf: Base64String?,
) : EmploymentInfo

@Serializable
public data class EncryptedEmploymentInfo(
	override val startDate: Long? = null,
	override val endDate: Long? = null,
	override val professionType: CodeStub? = null,
	override val employer: Employer? = null,
	override val encryptedSelf: Base64String?,
) : EmploymentInfo
