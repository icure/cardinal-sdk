package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("PatientByHcPartyAndAddressFilter")
@Serializable
data class PatientByHcPartyAndAddressFilter(
	desc: String? = null,
	searchString: String? = null,
	healthcarePartyId: String? = null,
	postalCode: String? = null,
	houseNumber: String? = null,
) : AbstractFilter<Patient> {
	// region PatientByHcPartyAndAddressFilter-PatientByHcPartyAndAddressFilter

	// endregion
}
