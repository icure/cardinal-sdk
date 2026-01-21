package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("HealthElementByHcPartyStatusFilter")
@Serializable
data class HealthElementByHcPartyStatusFilter(
	desc: String? = null,
	hcPartyId: String,
	status: Int,
) : AbstractFilter<HealthElement> {
	// region HealthElementByHcPartyStatusFilter-HealthElementByHcPartyStatusFilter

	// endregion
}
