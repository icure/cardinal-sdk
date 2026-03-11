// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.ParticipantType
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Represents a healthcare party participating in a contact, along with their participation type.
 * /
 */
@Serializable
data class ContactParticipant(
	/**
	 * The type of participation in the contact.
	 */
	public val type: ParticipantType,
	/**
	 * The identifier of the participating healthcare party.
	 */
	public val hcpId: String,
) {
	// region ContactParticipant-ContactParticipant

	// endregion
}
