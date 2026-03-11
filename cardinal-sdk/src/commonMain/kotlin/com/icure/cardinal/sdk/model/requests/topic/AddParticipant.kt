package com.icure.cardinal.sdk.model.requests.topic

import com.icure.cardinal.sdk.model.TopicRole
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Request payload to add a new participant to a topic with a specified role.
 */
@Serializable
public data class AddParticipant(
	/**
	 * The identifier of the data owner (user or healthcare party) to add as a participant.
	 */
	public val dataOwnerId: String,
	/**
	 * The role to assign to the new participant within the topic.
	 */
	public val topicRole: TopicRole,
)
