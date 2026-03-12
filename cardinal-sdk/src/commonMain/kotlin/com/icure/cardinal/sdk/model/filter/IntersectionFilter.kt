package com.icure.cardinal.sdk.model.filter

import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 * Filter that returns only elements that match all of the provided sub-filters (logical AND).
 * /
 */
@SerialName("IntersectionFilter")
@Serializable
public data class IntersectionFilter<O : Identifiable<String>>(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The list of filters whose results are intersected.
	 */
	@param:DefaultValue("emptyList()")
	override val filters: List<AbstractFilter<O>> = emptyList(),
) : AbstractFilter<O>, Filter.IntersectionFilter<O>
