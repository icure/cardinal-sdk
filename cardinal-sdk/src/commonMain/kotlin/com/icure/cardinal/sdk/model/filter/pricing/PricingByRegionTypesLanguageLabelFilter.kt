package com.icure.cardinal.sdk.model.filter.pricing

import com.icure.cardinal.sdk.model.Tarification
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("PricingByRegionTypesLanguageLabelFilter")
@Serializable
data class PricingByRegionTypesLanguageLabelFilter(
	public val region: String? = null,
	public val types: List<String>,
	public val language: String,
	public val label: String,
	override val desc: String? = null,
) : AbstractFilter<Tarification> {
	// region PricingByRegionTypesLanguageLabelFilter-PricingByRegionTypesLanguageLabelFilter

	// endregion
}
