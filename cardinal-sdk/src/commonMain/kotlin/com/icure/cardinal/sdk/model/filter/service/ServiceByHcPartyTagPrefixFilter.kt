package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("ServiceByHcPartyTagPrefixFilter")
@Serializable
data class ServiceByHcPartyTagPrefixFilter(
	public val healthcarePartyId: String,
	public val tagType: String,
	public val tagCodePrefix: String,
	override val desc: String? = null,
) : AbstractFilter<Service> {
	// region ServiceByHcPartyTagPrefixFilter-ServiceByHcPartyTagPrefixFilter
	// endregion
}
