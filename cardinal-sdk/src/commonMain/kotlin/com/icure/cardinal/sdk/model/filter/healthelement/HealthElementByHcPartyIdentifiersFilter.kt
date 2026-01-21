package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List
import com.icure.cardinal.sdk.utils.DefaultValue

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("HealthElementByHcPartyIdentifiersFilter")
@Serializable
data class HealthElementByHcPartyIdentifiersFilter(
	desc: String? = null,
	hcPartyId: String,
	identifiers: List<Identifier> = emptyList(),
) : AbstractFilter<HealthElement> {
	// region HealthElementByHcPartyIdentifiersFilter-HealthElementByHcPartyIdentifiersFilter

	// endregion
}
