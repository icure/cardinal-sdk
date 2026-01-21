package com.icure.cardinal.sdk.model.filter.patient

import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("PatientByDataOwnerTagFilter")
@Serializable
data class PatientByDataOwnerTagFilter(
	desc: String? = null,
	dataOwnerId: String,
	tagType: String,
	tagCode: String? = null,
) : AbstractFilter<Patient> {
	// region PatientByDataOwnerTagFilter-PatientByDataOwnerTagFilter

	// endregion
}
