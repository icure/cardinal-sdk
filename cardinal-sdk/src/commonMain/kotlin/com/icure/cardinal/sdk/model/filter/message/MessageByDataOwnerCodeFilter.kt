// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches messages by data owner and code.
 * /
 */
@SerialName("MessageByDataOwnerCodeFilter")
@Serializable
data class MessageByDataOwnerCodeFilter(
	/**
	 * The identifier of the data owner.
	 */
	public val dataOwnerId: String,
	/**
	 * The type of the code to match.
	 */
	public val codeType: String,
	/**
	 * The code value to match.
	 */
	public val codeCode: String? = null,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Message> {
	// region MessageByDataOwnerCodeFilter-MessageByDataOwnerCodeFilter

	// endregion
}
