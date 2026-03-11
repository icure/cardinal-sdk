package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.ParticipantType
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Represents a healthcare party participating in a contact, along with their participation type.
 * /
 */
@Serializable
public data class ContactParticipant(
	/**
	 * The type of participation in the contact.
	 */
	public val type: ParticipantType,
	/**
	 * The identifier of the participating healthcare party.
	 */
	public val hcpId: String,
)
