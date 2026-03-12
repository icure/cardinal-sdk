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
public data class ServiceBySecretForeignKeys(
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
) : AbstractFilter<Service>
