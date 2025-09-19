package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

@SerialName("MessageByHcPartyTransportGuidReceivedFilter")
@Serializable
public data class MessageByHcPartyTransportGuidReceivedFilter(
	public val healthcarePartyId: String,
	public val transportGuid: String,
	public val descending: Boolean? = null,
	override val desc: String? = null,
) : AbstractFilter<Message>
