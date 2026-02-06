package com.icure.cardinal.sdk.model.filter.topic

import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("TopicByParticipantFilter")
@Serializable
public data class TopicByParticipantFilter(
	public val participantId: String,
	override val desc: String? = null,
) : AbstractFilter<Topic>
