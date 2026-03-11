// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

/**
 * Filter that matches messages associated with specific invoice identifiers.
 * /
 */
@SerialName("MessageByInvoiceIdsFilter")
@Serializable
data class MessageByInvoiceIdsFilter(
	/**
	 * The set of invoice identifiers to match.
	 */
	public val invoiceIds: Set<String>,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Message> {
	// region MessageByInvoiceIdsFilter-MessageByInvoiceIdsFilter

	// endregion
}
