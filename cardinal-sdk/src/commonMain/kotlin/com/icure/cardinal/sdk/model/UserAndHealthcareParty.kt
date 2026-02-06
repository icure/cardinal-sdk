package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable

@Serializable
public data class UserAndHealthcareParty(
	public val user: User,
	public val healthcareParty: HealthcareParty,
)
