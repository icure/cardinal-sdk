package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Set
import com.icure.cardinal.sdk.utils.DefaultValue

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("HealthElementByDataOwnerPatientOpeningDate")
@Serializable
data class HealthElementByDataOwnerPatientOpeningDate(
	desc: String? = null,
	healthcarePartyId: String,
	patientSecretForeignKeys: Set<String> = emptySet(),
	startDate: Long? = null,
	endDate: Long? = null,
	descending: Boolean = false,
) : AbstractFilter<HealthElement> {
	// region HealthElementByDataOwnerPatientOpeningDate-HealthElementByDataOwnerPatientOpeningDate

	// endregion
}
