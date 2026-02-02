package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("MessageByDataOwnerLifecycleBetween")
@Serializable
data class MessageByDataOwnerLifecycleBetween(
	public val dataOwnerId: String,
	public val startTimestamp: Long? = null,
	public val endTimestamp: Long? = null,
	@param:DefaultValue("false")
	public val descending: Boolean = false,
	override val desc: String? = null,
) : AbstractFilter<Message> {
	// region MessageByDataOwnerLifecycleBetween-MessageByDataOwnerLifecycleBetween

	// endregion
}
