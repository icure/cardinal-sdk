package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.VersionFiltering
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("HealthElementByHcPartyTagFilter")
@Serializable
data class HealthElementByHcPartyTagFilter(
	desc: String? = null,
	healthcarePartyId: String,
	tagType: String,
	tagCode: String,
	startOfHealthElementDate: Long? = null,
	endOfHealthElementDate: Long? = null,
	versionFiltering: VersionFiltering? = null,
) : AbstractFilter<HealthElement> {
	// region HealthElementByHcPartyTagFilter-HealthElementByHcPartyTagFilter
	// endregion
}
