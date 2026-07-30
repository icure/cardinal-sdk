// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.relatedperson

import com.icure.cardinal.sdk.model.RelatedPerson
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 * Filter that matches related persons with a delegation for a data owner and at least one of the
 * provided identifiers.
 * /
 */
@SerialName("RelatedPersonByDataOwnerIdentifiersFilter")
@Serializable
data class RelatedPersonByDataOwnerIdentifiersFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The identifier of the data owner. When null, the current data owner is used.
	 */
	public val dataOwnerId: String? = null,
	/**
	 * The list of identifiers to match.
	 */
	@param:DefaultValue("emptyList()")
	public val identifiers: List<Identifier> = emptyList(),
) : AbstractFilter<RelatedPerson> {
	// region RelatedPersonByDataOwnerIdentifiersFilter-RelatedPersonByDataOwnerIdentifiersFilter
	// endregion
}
