// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.contact

import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

/**
 * Filter that matches contacts by data owner and associated form identifiers.
 * /
 */
@SerialName("ContactByDataOwnerFormIdsFilter")
@Serializable
data class ContactByDataOwnerFormIdsFilter(
	/**
	 * The identifier of the data owner.
	 */
	public val dataOwnerId: String,
	/**
	 * The set of form identifiers to match.
	 */
	public val formIds: Set<String>,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Contact> {
	// region ContactByDataOwnerFormIdsFilter-ContactByDataOwnerFormIdsFilter

	// endregion
}
