package com.icure.sdk.model.filter.hcparty

import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("HealthcarePartyByIdsFilter")
@Serializable
data class HealthcarePartyByIdsFilter(
    override val ids: Set<String> = emptySet(),
    override val desc: String? = null,
) : AbstractFilter<HealthcareParty>, Filter.IdsFilter<String, HealthcareParty> {
    // region HealthcarePartyByIdsFilter-HealthcarePartyByIdsFilter

    // endregion
}
