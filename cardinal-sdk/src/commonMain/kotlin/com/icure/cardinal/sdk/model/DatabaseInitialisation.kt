// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 * DTO containing the initial data required to set up a new database environment, including
 * seed users, healthcare parties, and replication configuration.
 * /
 */
@Serializable
data class DatabaseInitialisation(
	/**
	 * The list of initial users to create during database initialisation.
	 */
	@param:DefaultValue("emptyList()")
	public val users: List<User>? = emptyList(),
	/**
	 * The list of initial healthcare parties to create during database initialisation.
	 */
	@param:DefaultValue("emptyList()")
	public val healthcareParties: List<HealthcareParty>? = emptyList(),
	/**
	 * The replication configuration to apply during database initialisation.
	 */
	public val replication: Replication? = null,
	/**
	 * The minimum required Kraken version for this database configuration.
	 */
	public val minimumKrakenVersion: String? = null,
) {
	// region DatabaseInitialisation-DatabaseInitialisation

	// endregion
}
