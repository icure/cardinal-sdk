package com.icure.cardinal.sdk.model.filter.pricing

import com.icure.cardinal.sdk.model.Tarification
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 * Filter that matches pricing entries by region, types, language, and label.
 * /
 */
@SerialName("PricingByRegionTypesLanguageLabelFilter")
@Serializable
public data class PricingByRegionTypesLanguageLabelFilter(
	/**
	 * The region to filter pricing entries by.
	 */
	public val region: String? = null,
	/**
	 * The list of pricing types to match.
	 */
	public val types: List<String>,
	/**
	 * The language of the label to match.
	 */
	public val language: String,
	/**
	 * The label text to match.
	 */
	public val label: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Tarification>
