package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches the latest message for a healthcare party and transport guid combination.
 * /
 */
@SerialName("LatestMessageByHcPartyTransportGuidFilter")
@Serializable
public data class LatestMessageByHcPartyTransportGuidFilter(
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String,
	/**
	 * The transport guid to match.
	 */
	public val transportGuid: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Message>
