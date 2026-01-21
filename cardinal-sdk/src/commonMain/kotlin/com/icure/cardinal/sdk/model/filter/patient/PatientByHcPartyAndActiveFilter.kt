package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String
import com.icure.cardinal.sdk.utils.DefaultValue

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("PatientByHcPartyAndActiveFilter")
@Serializable
data class PatientByHcPartyAndActiveFilter(
	desc: String? = null,
	active: Boolean = false,
	healthcarePartyId: String? = null,
) : AbstractFilter<Patient> {
	// region PatientByHcPartyAndActiveFilter-PatientByHcPartyAndActiveFilter

	// endregion
}
