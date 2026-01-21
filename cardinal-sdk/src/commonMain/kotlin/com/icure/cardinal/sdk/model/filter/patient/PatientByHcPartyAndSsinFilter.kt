package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("PatientByHcPartyAndSsinFilter")
@Serializable
data class PatientByHcPartyAndSsinFilter(
	desc: String? = null,
	ssin: String,
	healthcarePartyId: String? = null,
) : AbstractFilter<Patient> {
	// region PatientByHcPartyAndSsinFilter-PatientByHcPartyAndSsinFilter

	// endregion
}
