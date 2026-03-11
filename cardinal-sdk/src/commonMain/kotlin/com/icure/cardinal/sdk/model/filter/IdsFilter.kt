// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter

import com.icure.cardinal.sdk.model.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

/**
 * Filter that matches entities by their unique identifiers.
 * /
 */
@SerialName("IdsFilter")
@Serializable
data class IdsFilter<O : Identifiable<String>>(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The set of entity identifiers to match.
	 */
	override val ids: Set<String>,
) : AbstractFilter<O>, Filter.IdsFilter<String, O> {
	// region IdsFilter-IdsFilter

	// endregion
}
