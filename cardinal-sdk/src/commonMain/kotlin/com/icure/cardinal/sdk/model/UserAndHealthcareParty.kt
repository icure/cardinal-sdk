// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable

/**
 * DTO that embeds a user and its linked healthcare party, used when both entities
 * need to be returned together.
 * /
 */
@Serializable
data class UserAndHealthcareParty(
	/**
	 * The user entity.
	 */
	public val user: User,
	/**
	 * The healthcare party linked to the user.
	 */
	public val healthcareParty: HealthcareParty,
) {
	// region UserAndHealthcareParty-UserAndHealthcareParty

	// endregion
}
