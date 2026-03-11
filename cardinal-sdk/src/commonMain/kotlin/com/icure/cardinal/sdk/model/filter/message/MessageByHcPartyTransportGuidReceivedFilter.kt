package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

/**
 * Filter that matches messages by healthcare party and transport guid, ordered by received date.
 * /
 */
@SerialName("MessageByHcPartyTransportGuidReceivedFilter")
@Serializable
public data class MessageByHcPartyTransportGuidReceivedFilter(
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String,
	/**
	 * The transport guid to match.
	 */
	public val transportGuid: String,
	/**
	 * Whether to return results in descending order.
	 */
	public val descending: Boolean? = null,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Message>
