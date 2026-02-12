package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@Serializable
public data class DatabaseInitialisation(
	@param:DefaultValue("emptyList()")
	public val users: List<User>? = emptyList(),
	@param:DefaultValue("emptyList()")
	public val healthcareParties: List<HealthcareParty>? = emptyList(),
	public val replication: Replication? = null,
	public val minimumKrakenVersion: String? = null,
)
