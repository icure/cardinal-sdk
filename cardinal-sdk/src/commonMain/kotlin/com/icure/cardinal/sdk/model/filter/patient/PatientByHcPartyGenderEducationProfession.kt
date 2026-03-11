package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.embed.Gender
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches patients by healthcare party, gender, education, and profession.
 * /
 */
@SerialName("PatientByHcPartyGenderEducationProfession")
@Serializable
public data class PatientByHcPartyGenderEducationProfession(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String? = null,
	/**
	 * The gender to match.
	 */
	public val gender: Gender? = null,
	/**
	 * The education level to match.
	 */
	public val education: String? = null,
	/**
	 * The profession to match.
	 */
	public val profession: String? = null,
) : AbstractFilter<Patient>
