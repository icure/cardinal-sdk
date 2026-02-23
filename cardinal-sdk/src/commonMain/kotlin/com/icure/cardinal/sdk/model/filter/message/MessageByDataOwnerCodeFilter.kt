package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("MessageByDataOwnerCodeFilter")
@Serializable
public data class MessageByDataOwnerCodeFilter(
	public val dataOwnerId: String,
	public val codeType: String,
	public val codeCode: String? = null,
	override val desc: String? = null,
) : AbstractFilter<Message>
