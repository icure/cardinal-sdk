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

@SerialName("HealthElementByHcPartyCodeFilter")
@Serializable
data class HealthElementByHcPartyCodeFilter(
	override val desc: String? = null,
	public val healthcarePartyId: String,
	public val codeType: String,
	public val codeCode: String,
	public val startOfHealthElementDate: Long? = null,
	public val endOfHealthElementDate: Long? = null,
	public val versionFiltering: VersionFiltering? = null,
) : AbstractFilter<HealthElement> {
	// region HealthElementByHcPartyCodeFilter-HealthElementByHcPartyCodeFilter

	// endregion
}
