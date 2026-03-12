// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.code

import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 * Filter that matches codes by region, multiple types, language, label, and version.
 * /
 */
@SerialName("CodeByRegionTypesLanguageLabelVersionFilters")
@Serializable
data class CodeByRegionTypesLanguageLabelVersionFilters(
	/**
	 * The region to filter codes by.
	 */
	public val region: String? = null,
	/**
	 * The list of code types to match.
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
	 * The code version to match.
	 */
	public val version: String? = null,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Code> {
	// region CodeByRegionTypesLanguageLabelVersionFilters-CodeByRegionTypesLanguageLabelVersionFilters

	// endregion
}
