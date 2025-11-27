package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.ParticipantType
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class ContactParticipant(
	public val type: ParticipantType,
	public val hcpId: String,
)
