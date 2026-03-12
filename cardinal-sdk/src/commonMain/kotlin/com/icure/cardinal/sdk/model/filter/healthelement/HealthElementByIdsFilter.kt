package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

/**
 * Filter that matches health elements by their unique identifiers.
 * /
 */
@SerialName("HealthElementByIdsFilter")
@Serializable
public data class HealthElementByIdsFilter(
	/**
	 * The set of health element identifiers to match.
	 */
	override val ids: Set<String>,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<HealthElement>, Filter.IdsFilter<String, HealthElement>
