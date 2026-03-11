package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.serialization.InstantSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String
import kotlin.time.Instant

/**
 * Filter that matches messages by data owner, transport guid, and sent date range.
 * /
 */
@SerialName("MessageByDataOwnerTransportGuidSentDateFilter")
@Serializable
public data class MessageByDataOwnerTransportGuidSentDateFilter(
	/**
	 * The identifier of the data owner.
	 */
	public val dataOwnerId: String,
	/**
	 * The transport guid to match.
	 */
	public val transportGuid: String,
	/**
	 * The start of the sent date range (inclusive).
	 */
	@Serializable(with = InstantSerializer::class)
	public val fromDate: Instant?,
	/**
	 * The end of the sent date range (inclusive).
	 */
	@Serializable(with = InstantSerializer::class)
	public val toDate: Instant?,
	/**
	 * Whether to return results in descending order.
	 */
	public val descending: Boolean? = null,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Message>
