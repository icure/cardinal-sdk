package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Represents a relationship between a patient and another person (contact person or another
 * patient).
 * /
 */
@Serializable
public data class Partnership(
	/**
	 * The type of relationship (from CD-CONTACT-PERSON codes).
	 */
	public val type: PartnershipType? = null,
	/**
	 * The status of the relationship.
	 */
	public val status: PartnershipStatus? = null,
	/**
	 * The UUID of the contact person or patient in this relationship.
	 */
	public val partnerId: String? = null,
)
