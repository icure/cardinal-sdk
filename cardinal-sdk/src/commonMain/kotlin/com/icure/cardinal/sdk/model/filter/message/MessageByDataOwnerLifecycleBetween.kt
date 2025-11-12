package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String

@SerialName("MessageByDataOwnerLifecycleBetween")
@Serializable
public data class MessageByDataOwnerLifecycleBetween(
	public val dataOwnerId: String,
	public val startTimestamp: Long? = null,
	public val endTimestamp: Long? = null,
	@DefaultValue("false")
	public val descending: Boolean = false,
	override val desc: String? = null,
) : AbstractFilter<Message>
