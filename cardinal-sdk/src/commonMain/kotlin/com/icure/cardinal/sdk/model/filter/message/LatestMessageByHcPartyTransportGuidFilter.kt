package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("LatestMessageByHcPartyTransportGuidFilter")
@Serializable
public data class LatestMessageByHcPartyTransportGuidFilter(
	public val healthcarePartyId: String,
	public val transportGuid: String,
	override val desc: String? = null,
) : AbstractFilter<Message>
