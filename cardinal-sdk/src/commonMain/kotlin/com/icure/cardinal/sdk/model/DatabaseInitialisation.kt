package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class DatabaseInitialisation(
	@param:DefaultValue("emptyList()")
	public val users: List<User>? = emptyList(),
	@param:DefaultValue("emptyList()")
	public val healthcareParties: List<HealthcareParty>? = emptyList(),
	public val replication: Replication? = null,
	public val minimumKrakenVersion: String? = null,
) {
	// region DatabaseInitialisation-DatabaseInitialisation

	// endregion
}
