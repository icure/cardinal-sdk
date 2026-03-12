package com.icure.cardinal.sdk.model.filter.hcparty

import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

/**
 * Filter that matches healthcare parties by name.
 * /
 */
@SerialName("HealthcarePartyByNameFilter")
@Serializable
public data class HealthcarePartyByNameFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The name to search for.
	 */
	public val name: String,
	/**
	 * Whether to return results in descending order.
	 */
	public val descending: Boolean? = null,
) : AbstractFilter<HealthcareParty>
