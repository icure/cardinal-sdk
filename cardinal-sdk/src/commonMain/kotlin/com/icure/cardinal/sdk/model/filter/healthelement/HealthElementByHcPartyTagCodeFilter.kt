package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("HealthElementByHcPartyTagCodeFilter")
@Serializable
data class HealthElementByHcPartyTagCodeFilter(
	desc: String? = null,
	healthcarePartyId: String,
	codeType: String? = null,
	codeCode: String? = null,
	tagType: String? = null,
	tagCode: String? = null,
	status: Int? = null,
) : AbstractFilter<HealthElement> {
	// region HealthElementByHcPartyTagCodeFilter-HealthElementByHcPartyTagCodeFilter

	// endregion
}
