package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("ServiceByHcPartyHealthElementIdsFilter")
@Serializable
data class ServiceByHcPartyHealthElementIdsFilter(
	override val desc: String? = null,
	public val healthcarePartyId: String? = null,
	@param:DefaultValue("emptyList()")
	public val healthElementIds: List<String> = emptyList(),
) : AbstractFilter<Service> {
	// region ServiceByHcPartyHealthElementIdsFilter-ServiceByHcPartyHealthElementIdsFilter

	// endregion
}
