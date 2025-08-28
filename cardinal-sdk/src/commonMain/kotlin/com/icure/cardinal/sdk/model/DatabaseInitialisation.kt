package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@Serializable
public data class DatabaseInitialisation(
	public val users: List<User>? = null,
	public val healthcareParties: List<HealthcareParty>? = null,
	public val replication: Replication? = null,
	public val minimumKrakenVersion: String? = null,
)
