package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.serialization.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

@SerialName("MessageByDataOwnerTransportGuidSentDateFilter")
@Serializable
public data class MessageByDataOwnerTransportGuidSentDateFilter(
	public val dataOwnerId: String,
	public val transportGuid: String,
	@Serializable(with = InstantSerializer::class)
	public val fromDate: Instant?,
	@Serializable(with = InstantSerializer::class)
	public val toDate: Instant?,
	public val descending: Boolean? = null,
	override val desc: String? = null,
) : AbstractFilter<Message>
