package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List
import com.icure.cardinal.sdk.utils.DefaultValue

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("ServiceByHcPartyHealthElementIdsFilter")
@Serializable
data class ServiceByHcPartyHealthElementIdsFilter(
	desc: String? = null,
	healthcarePartyId: String? = null,
	healthElementIds: List<String> = emptyList(),
) : AbstractFilter<Service> {
	// region ServiceByHcPartyHealthElementIdsFilter-ServiceByHcPartyHealthElementIdsFilter

	// endregion
}
