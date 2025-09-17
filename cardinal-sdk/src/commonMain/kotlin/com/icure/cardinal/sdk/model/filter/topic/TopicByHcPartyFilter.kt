package com.icure.cardinal.sdk.model.filter.topic

import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("TopicByHcPartyFilter")
@Serializable
public data class TopicByHcPartyFilter(
	override val hcpId: String,
	override val desc: String? = null,
) : AbstractFilter<Topic>, Filter.ByHcpartyFilter<Topic>
