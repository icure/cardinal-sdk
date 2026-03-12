package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches messages associated with a specific healthcare party.
 * /
 */
@SerialName("MessageByHcPartyFilter")
@Serializable
public data class MessageByHcPartyFilter(
	/**
	 * The identifier of the healthcare party.
	 */
	override val hcpId: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Message>, Filter.ByHcpartyFilter<Message>
