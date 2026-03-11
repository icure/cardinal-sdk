// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Represents a relationship between a patient and another person (contact person or another
 * patient).
 * /
 */
@Serializable
data class Partnership(
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
) {
	// region Partnership-Partnership

	// endregion
}
