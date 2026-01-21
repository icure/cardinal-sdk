package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@SerialName("MessageByParentIdsFilter")
@Serializable
public data class MessageByParentIdsFilter(
	public val parentIds: List<String>,
	override val desc: String? = null,
) : AbstractFilter<Message>
