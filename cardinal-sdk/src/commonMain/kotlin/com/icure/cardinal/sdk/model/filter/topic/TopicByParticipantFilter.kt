package com.icure.cardinal.sdk.model.filter.topic

import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches topics by a specific participant.
 * /
 */
@SerialName("TopicByParticipantFilter")
@Serializable
public data class TopicByParticipantFilter(
	/**
	 * The identifier of the participant.
	 */
	public val participantId: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Topic>
