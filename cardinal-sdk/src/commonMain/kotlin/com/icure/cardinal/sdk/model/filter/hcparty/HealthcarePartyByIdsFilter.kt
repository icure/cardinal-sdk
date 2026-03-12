package com.icure.cardinal.sdk.model.filter.hcparty

import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

/**
 * Filter that matches healthcare parties by their unique identifiers.
 * /
 */
@SerialName("HealthcarePartyByIdsFilter")
@Serializable
public data class HealthcarePartyByIdsFilter(
	/**
	 * The set of healthcare party identifiers to match.
	 */
	override val ids: Set<String>,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<HealthcareParty>, Filter.IdsFilter<String, HealthcareParty>
