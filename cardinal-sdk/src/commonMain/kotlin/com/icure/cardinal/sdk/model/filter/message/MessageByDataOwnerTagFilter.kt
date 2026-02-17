package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("MessageByDataOwnerTagFilter")
@Serializable
public data class MessageByDataOwnerTagFilter(
	public val dataOwnerId: String,
	public val tagType: String,
	public val tagCode: String? = null,
	override val desc: String? = null,
) : AbstractFilter<Message>
