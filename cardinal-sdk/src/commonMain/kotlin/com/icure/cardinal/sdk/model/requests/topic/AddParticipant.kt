package com.icure.cardinal.sdk.model.requests.topic

import com.icure.cardinal.sdk.model.TopicRole
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class AddParticipant(
	public val dataOwnerId: String,
	public val topicRole: TopicRole,
)
