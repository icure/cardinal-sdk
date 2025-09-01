package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface EmploymentInfo : Encryptable {
	public val startDate: Long?

	public val endDate: Long?

	public val professionType: CodeStub?

	public val employer: Employer?

	override val encryptedSelf: Base64String?
	// region EmploymentInfo-EmploymentInfo

	// endregion
}

@Serializable
data class DecryptedEmploymentInfo(
	override val startDate: Long? = null,
	override val endDate: Long? = null,
	override val professionType: CodeStub? = null,
	override val employer: Employer? = null,
	override val encryptedSelf: Base64String? = null,
) : EmploymentInfo {
	// region EmploymentInfo-DecryptedEmploymentInfo

	// endregion
}

@Serializable
data class EncryptedEmploymentInfo(
	override val startDate: Long? = null,
	override val endDate: Long? = null,
	override val professionType: CodeStub? = null,
	override val employer: Employer? = null,
	override val encryptedSelf: Base64String? = null,
) : EmploymentInfo {
	// region EmploymentInfo-EncryptedEmploymentInfo

	// endregion
}
