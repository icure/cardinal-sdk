package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List
import com.icure.cardinal.sdk.utils.DefaultValue

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class DatabaseInitialisation(
	public val users: List<User>? = null,
	public val healthcareParties: List<HealthcareParty>? = null,
	public val replication: Replication? = null,
	public val minimumKrakenVersion: String? = null,
) {
	// region DatabaseInitialisation-DatabaseInitialisation

	// endregion
}
