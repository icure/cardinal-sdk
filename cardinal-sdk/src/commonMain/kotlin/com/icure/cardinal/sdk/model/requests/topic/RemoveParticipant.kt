package com.icure.cardinal.sdk.model.requests.topic

import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class RemoveParticipant(
	public val dataOwnerId: String,
)
