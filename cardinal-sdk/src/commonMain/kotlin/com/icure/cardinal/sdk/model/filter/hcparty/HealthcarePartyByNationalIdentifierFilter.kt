package com.icure.cardinal.sdk.model.filter.hcparty

import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("HealthcarePartyByNationalIdentifierFilter")
@Serializable
data class HealthcarePartyByNationalIdentifierFilter(
	searchValue: String,
	descending: Boolean? = null,
	desc: String? = null,
) : AbstractFilter<HealthcareParty> {
	// region HealthcarePartyByNationalIdentifierFilter-HealthcarePartyByNationalIdentifierFilter

	// endregion
}
