package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.embed.Gender
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("PatientByHcPartyGenderEducationProfession")
@Serializable
data class PatientByHcPartyGenderEducationProfession(
	desc: String? = null,
	healthcarePartyId: String? = null,
	gender: Gender? = null,
	education: String? = null,
	profession: String? = null,
) : AbstractFilter<Patient> {
	// region PatientByHcPartyGenderEducationProfession-PatientByHcPartyGenderEducationProfession

	// endregion
}
