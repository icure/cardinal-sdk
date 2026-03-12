package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable

/**
 * DTO that embeds a user and its linked healthcare party, used when both entities
 * need to be returned together.
 * /
 */
@Serializable
public data class UserAndHealthcareParty(
	/**
	 * The user entity.
	 */
	public val user: User,
	/**
	 * The healthcare party linked to the user.
	 */
	public val healthcareParty: HealthcareParty,
)
