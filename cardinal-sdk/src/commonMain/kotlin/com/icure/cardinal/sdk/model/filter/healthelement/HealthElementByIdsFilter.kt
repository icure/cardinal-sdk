package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

@SerialName("HealthElementByIdsFilter")
@Serializable
public data class HealthElementByIdsFilter(
	override val ids: Set<String>,
	override val desc: String? = null,
) : AbstractFilter<HealthElement>, Filter.IdsFilter<String, HealthElement>
