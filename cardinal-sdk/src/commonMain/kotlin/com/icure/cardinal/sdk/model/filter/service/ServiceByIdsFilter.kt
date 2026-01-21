package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("ServiceByIdsFilter")
@Serializable
data class ServiceByIdsFilter(
	ids: Set<String>,
	desc: String? = null,
) : AbstractFilter<Service>, Filter.IdsFilter<String, Service> {
	// region ServiceByIdsFilter-ServiceByIdsFilter

	// endregion
}
