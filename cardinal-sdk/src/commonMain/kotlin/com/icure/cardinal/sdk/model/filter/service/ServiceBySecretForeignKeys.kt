// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

/**
 * Filter that matches services by healthcare party and patient secret foreign keys.
 * /
 */
@SerialName("ServiceBySecretForeignKeys")
@Serializable
data class ServiceBySecretForeignKeys(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String? = null,
	/**
	 * The set of patient secret foreign keys to match.
	 */
	public val patientSecretForeignKeys: Set<String>,
) : AbstractFilter<Service> {
	// region ServiceBySecretForeignKeys-ServiceBySecretForeignKeys

	// endregion
}
