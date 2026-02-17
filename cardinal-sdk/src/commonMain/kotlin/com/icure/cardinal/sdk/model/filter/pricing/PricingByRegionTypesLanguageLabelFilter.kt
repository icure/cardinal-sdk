package com.icure.cardinal.sdk.model.filter.pricing

import com.icure.cardinal.sdk.model.Tarification
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@SerialName("PricingByRegionTypesLanguageLabelFilter")
@Serializable
public data class PricingByRegionTypesLanguageLabelFilter(
	public val region: String? = null,
	public val types: List<String>,
	public val language: String,
	public val label: String,
	override val desc: String? = null,
) : AbstractFilter<Tarification>
