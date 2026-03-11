// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.contact

import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 * Filter that matches contacts containing services with the specified identifiers.
 * /
 */
@SerialName("ContactByServiceIdsFilter")
@Serializable
data class ContactByServiceIdsFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The list of service identifiers to match.
	 */
	public val ids: List<String>? = null,
) : AbstractFilter<Contact> {
	// region ContactByServiceIdsFilter-ContactByServiceIdsFilter

	// endregion
}
