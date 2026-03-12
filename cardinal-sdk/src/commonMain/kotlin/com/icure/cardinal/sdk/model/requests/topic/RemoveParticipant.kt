package com.icure.cardinal.sdk.model.requests.topic

import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Request payload to remove an existing participant from a topic.
 */
@Serializable
public data class RemoveParticipant(
	/**
	 * The identifier of the data owner to remove from the topic.
	 */
	public val dataOwnerId: String,
)
