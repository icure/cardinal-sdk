// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.contact

import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches contacts by data owner and service code.
 * /
 */
@SerialName("ContactByDataOwnerServiceCodeFilter")
@Serializable
data class ContactByDataOwnerServiceCodeFilter(
	/**
	 * The identifier of the data owner.
	 */
	public val dataOwnerId: String,
	/**
	 * The type of the service code.
	 */
	public val codeType: String,
	/**
	 * The code value to match.
	 */
	public val codeCode: String?,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Contact> {
	// region ContactByDataOwnerServiceCodeFilter-ContactByDataOwnerServiceCodeFilter

	// endregion
}
