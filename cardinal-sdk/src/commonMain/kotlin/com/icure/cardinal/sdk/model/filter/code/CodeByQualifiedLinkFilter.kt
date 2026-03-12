// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.code

import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches codes by their qualified link type and optionally by linked entity
 * identifier.
 * /
 */
@SerialName("CodeByQualifiedLinkFilter")
@Serializable
data class CodeByQualifiedLinkFilter(
	/**
	 * The type of qualified link to match.
	 */
	public val linkType: String,
	/**
	 * The optional identifier of the linked entity.
	 */
	public val linkedId: String? = null,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Code> {
	// region CodeByQualifiedLinkFilter-CodeByQualifiedLinkFilter

	// endregion
}
