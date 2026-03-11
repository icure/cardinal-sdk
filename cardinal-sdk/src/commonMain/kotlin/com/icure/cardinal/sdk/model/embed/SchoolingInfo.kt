package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

/**
 * Represents schooling information for a patient, including the period, school name, and type of
 * education.
 * /
 */
public sealed interface SchoolingInfo : Encryptable {
	/**
	 * The start date (unix epoch in ms) of the schooling period.
	 */
	public val startDate: Long?

	/**
	 * The end date (unix epoch in ms) of the schooling period.
	 */
	public val endDate: Long?

	/**
	 * The name of the school.
	 */
	public val school: String?

	/**
	 * A code describing the type of education.
	 */
	public val typeOfEducation: CodeStub?

	/**
	 * The base64-encoded encrypted content of this schooling info.
	 */
	override val encryptedSelf: Base64String?
}

/**
 * Represents schooling information for a patient, including the period, school name, and type of
 * education.
 * /
 */
@Serializable
public data class DecryptedSchoolingInfo(
	/**
	 * The start date (unix epoch in ms) of the schooling period.
	 */
	override val startDate: Long? = null,
	/**
	 * The end date (unix epoch in ms) of the schooling period.
	 */
	override val endDate: Long? = null,
	/**
	 * The name of the school.
	 */
	override val school: String? = null,
	/**
	 * A code describing the type of education.
	 */
	override val typeOfEducation: CodeStub? = null,
	/**
	 * The base64-encoded encrypted content of this schooling info.
	 */
	override val encryptedSelf: Base64String? = null,
) : SchoolingInfo

/**
 * Represents schooling information for a patient, including the period, school name, and type of
 * education.
 * /
 */
@Serializable
public data class EncryptedSchoolingInfo(
	/**
	 * The start date (unix epoch in ms) of the schooling period.
	 */
	override val startDate: Long? = null,
	/**
	 * The end date (unix epoch in ms) of the schooling period.
	 */
	override val endDate: Long? = null,
	/**
	 * The name of the school.
	 */
	override val school: String? = null,
	/**
	 * A code describing the type of education.
	 */
	override val typeOfEducation: CodeStub? = null,
	/**
	 * The base64-encoded encrypted content of this schooling info.
	 */
	override val encryptedSelf: Base64String? = null,
) : SchoolingInfo
