package com.icure.cardinal.sdk.model.filter.pricing

import com.icure.cardinal.sdk.model.Tarification
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("AllPricingFilter")
@Serializable
public data class AllPricingFilter(
	override val desc: String? = null,
) : AbstractFilter<Tarification>, Filter.AllFilter<Tarification>
