// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
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
data class PatientByHcPartyGenderEducationProfession(
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
) : AbstractFilter<Patient> {
	// region PatientByHcPartyGenderEducationProfession-PatientByHcPartyGenderEducationProfession

	// endregion
}
