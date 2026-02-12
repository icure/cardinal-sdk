package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("MessageByDataOwnerTagFilter")
@Serializable
data class MessageByDataOwnerTagFilter(
	public val dataOwnerId: String,
	public val tagType: String,
	public val tagCode: String? = null,
	override val desc: String? = null,
) : AbstractFilter<Message> {
	// region MessageByDataOwnerTagFilter-MessageByDataOwnerTagFilter
	// endregion
}
