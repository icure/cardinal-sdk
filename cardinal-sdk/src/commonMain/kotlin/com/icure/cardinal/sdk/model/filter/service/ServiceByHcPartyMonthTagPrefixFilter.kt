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
	healthcarePartyId: String,
	year: Int? = null,
	month: Int? = null,
	tagType: String,
	tagCodePrefix: String,
	startValueDate: Long? = null,
	endValueDate: Long? = null,
	desc: String? = null,
) : AbstractFilter<Service> {
	// region ServiceByHcPartyMonthTagPrefixFilter-ServiceByHcPartyMonthTagPrefixFilter

	// endregion
}
