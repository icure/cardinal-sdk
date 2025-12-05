package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("MessageByDataOwnerFromAddressFilter")
@Serializable
public data class MessageByDataOwnerFromAddressFilter(
	public val dataOwnerId: String,
	public val fromAddress: String,
	override val desc: String? = null,
) : AbstractFilter<Message>
