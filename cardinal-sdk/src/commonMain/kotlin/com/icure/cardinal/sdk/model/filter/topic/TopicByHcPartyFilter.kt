package com.icure.cardinal.sdk.model.filter.topic

import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches topics associated with a specific healthcare party.
 * /
 */
@SerialName("TopicByHcPartyFilter")
@Serializable
public data class TopicByHcPartyFilter(
	/**
	 * The identifier of the healthcare party.
	 */
	override val hcpId: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Topic>, Filter.ByHcpartyFilter<Topic>
