// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.relatedperson

import com.icure.cardinal.sdk.model.RelatedPerson
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches related persons with a delegation for a data owner, where the concatenation
 * of last name and
 * first name contains the provided (sanitized) name.
 * /
 */
@SerialName("RelatedPersonByDataOwnerNameFilter")
@Serializable
data class RelatedPersonByDataOwnerNameFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The name to search.
	 */
	public val name: String? = null,
	/**
	 * The identifier of the data owner. When null, the current data owner is used.
	 */
	public val dataOwnerId: String? = null,
) : AbstractFilter<RelatedPerson> {
	// region RelatedPersonByDataOwnerNameFilter-RelatedPersonByDataOwnerNameFilter

	// endregion
}
