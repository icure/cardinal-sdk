package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Long

/**
 * Represents employment information for a patient, including the period, profession type, and
 * employer details.
 * /
 */
public sealed interface EmploymentInfo : Encryptable {
	/**
	 * The start date (unix epoch in ms) of the employment.
	 */
	public val startDate: Long?

	/**
	 * The end date (unix epoch in ms) of the employment.
	 */
	public val endDate: Long?

	/**
	 * A code describing the profession type.
	 */
	public val professionType: CodeStub?

	/**
	 * The employer details.
	 */
	public val employer: Employer?

	/**
	 * The base64-encoded encrypted content of this employment info.
	 */
	override val encryptedSelf: Base64String?
}

/**
 * Represents employment information for a patient, including the period, profession type, and
 * employer details.
 * /
 */
@Serializable
public data class DecryptedEmploymentInfo(
	/**
	 * The start date (unix epoch in ms) of the employment.
	 */
	override val startDate: Long? = null,
	/**
	 * The end date (unix epoch in ms) of the employment.
	 */
	override val endDate: Long? = null,
	/**
	 * A code describing the profession type.
	 */
	override val professionType: CodeStub? = null,
	/**
	 * The employer details.
	 */
	override val employer: Employer? = null,
	/**
	 * The base64-encoded encrypted content of this employment info.
	 */
	override val encryptedSelf: Base64String? = null,
) : EmploymentInfo

/**
 * Represents employment information for a patient, including the period, profession type, and
 * employer details.
 * /
 */
@Serializable
public data class EncryptedEmploymentInfo(
	/**
	 * The start date (unix epoch in ms) of the employment.
	 */
	override val startDate: Long? = null,
	/**
	 * The end date (unix epoch in ms) of the employment.
	 */
	override val endDate: Long? = null,
	/**
	 * A code describing the profession type.
	 */
	override val professionType: CodeStub? = null,
	/**
	 * The employer details.
	 */
	override val employer: Employer? = null,
	/**
	 * The base64-encoded encrypted content of this employment info.
	 */
	override val encryptedSelf: Base64String? = null,
) : EmploymentInfo
