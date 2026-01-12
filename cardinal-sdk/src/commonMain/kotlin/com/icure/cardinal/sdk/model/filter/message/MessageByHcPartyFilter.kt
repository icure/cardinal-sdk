package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("MessageByHcPartyFilter")
@Serializable
public data class MessageByHcPartyFilter(
	override val hcpId: String,
	override val desc: String? = null,
) : AbstractFilter<Message>, Filter.ByHcpartyFilter<Message>
