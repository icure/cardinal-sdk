package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("HealthElementByHcPartyFilter")
@Serializable
data class HealthElementByHcPartyFilter(
	hcpId: String,
	desc: String? = null,
) : AbstractFilter<HealthElement>, Filter.ByHcpartyFilter<HealthElement> {
	// region HealthElementByHcPartyFilter-HealthElementByHcPartyFilter

	// endregion
}
