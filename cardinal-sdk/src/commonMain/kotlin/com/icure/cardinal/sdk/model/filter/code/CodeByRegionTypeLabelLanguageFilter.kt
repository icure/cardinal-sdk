// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.code

import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches codes by region, type, label, and language.
 * /
 */
@SerialName("CodeByRegionTypeLabelLanguageFilter")
@Serializable
data class CodeByRegionTypeLabelLanguageFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The region to filter codes by.
	 */
	public val region: String? = null,
	/**
	 * The code type to match.
	 */
	public val type: String,
	/**
	 * The language of the label to match.
	 */
	public val language: String,
	/**
	 * The label text to match.
	 */
	public val label: String? = null,
) : AbstractFilter<Code> {
	// region CodeByRegionTypeLabelLanguageFilter-CodeByRegionTypeLabelLanguageFilter

	// endregion
}
