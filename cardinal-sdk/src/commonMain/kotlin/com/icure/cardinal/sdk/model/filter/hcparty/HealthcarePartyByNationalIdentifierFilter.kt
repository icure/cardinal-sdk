package com.icure.cardinal.sdk.model.filter.hcparty

import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

/**
 * Filter that matches healthcare parties by their national identifier (e.g., NIHII, INAMI).
 * /
 */
@SerialName("HealthcarePartyByNationalIdentifierFilter")
@Serializable
public data class HealthcarePartyByNationalIdentifierFilter(
	/**
	 * The national identifier value to search for.
	 */
	public val searchValue: String,
	/**
	 * Whether to return results in descending order.
	 */
	public val descending: Boolean? = null,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<HealthcareParty>
