// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 * Filter that matches healthcare elements having a qualified link towards one of the provided
 * healthcare element ids.
 * /
 */
@SerialName("HealthElementByQualifiedLinkFilter")
@Serializable
data class HealthElementByQualifiedLinkFilter(
	/**
	 * The ids of the linked healthcare elements to match.
	 */
	public val linkedIds: List<String>,
	/**
	 * The optional qualification type of the links to consider.
	 */
	public val type: String? = null,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<HealthElement> {
	// region HealthElementByQualifiedLinkFilter-HealthElementByQualifiedLinkFilter

	// endregion
}
