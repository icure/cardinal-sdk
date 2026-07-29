// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.relatedperson

import com.icure.cardinal.sdk.model.RelatedPerson
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

/**
 * Filter that matches related persons by their unique identifiers.
 * /
 */
@SerialName("RelatedPersonByIdsFilter")
@Serializable
data class RelatedPersonByIdsFilter(
	/**
	 * The set of related person identifiers to match.
	 */
	override val ids: Set<String>,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<RelatedPerson>, Filter.IdsFilter<String, RelatedPerson> {
	// region RelatedPersonByIdsFilter-RelatedPersonByIdsFilter
	// endregion
}
