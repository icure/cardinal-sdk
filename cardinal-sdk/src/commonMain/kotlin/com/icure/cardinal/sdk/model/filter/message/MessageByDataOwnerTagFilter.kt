// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches messages by data owner and tag.
 * /
 */
@SerialName("MessageByDataOwnerTagFilter")
@Serializable
data class MessageByDataOwnerTagFilter(
	/**
	 * The identifier of the data owner.
	 */
	public val dataOwnerId: String,
	/**
	 * The type of the tag to match.
	 */
	public val tagType: String,
	/**
	 * The tag code value to match.
	 */
	public val tagCode: String? = null,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Message> {
	// region MessageByDataOwnerTagFilter-MessageByDataOwnerTagFilter

	// endregion
}
