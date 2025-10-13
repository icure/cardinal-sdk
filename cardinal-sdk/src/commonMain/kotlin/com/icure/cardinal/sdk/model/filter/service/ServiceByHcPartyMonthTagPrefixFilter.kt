package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("ServiceByHcPartyMonthTagPrefixFilter")
@Serializable
data class ServiceByHcPartyMonthTagPrefixFilter(
	public val healthcarePartyId: String,
	public val year: Int? = null,
	public val month: Int? = null,
	public val tagType: String,
	public val tagCodePrefix: String,
	public val startValueDate: Long? = null,
	public val endValueDate: Long? = null,
	override val desc: String? = null,
) : AbstractFilter<Service> {
	// region ServiceByHcPartyMonthTagPrefixFilter-ServiceByHcPartyMonthTagPrefixFilter
	// endregion
}
