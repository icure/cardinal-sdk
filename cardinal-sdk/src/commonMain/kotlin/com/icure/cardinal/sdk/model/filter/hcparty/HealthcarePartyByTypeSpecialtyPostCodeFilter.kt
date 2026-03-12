package com.icure.cardinal.sdk.model.filter.hcparty

import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches healthcare parties by specialty type and postal code range.
 * /
 */
@SerialName("HealthcarePartyByTypeSpecialtyPostCodeFilter")
@Serializable
public data class HealthcarePartyByTypeSpecialtyPostCodeFilter(
	/**
	 * The specialty category to match.
	 */
	public val specialty: String,
	/**
	 * The specialty code to match.
	 */
	public val specCode: String,
	/**
	 * The start of the postal code range (inclusive).
	 */
	public val startPostCode: String,
	/**
	 * The end of the postal code range (inclusive).
	 */
	public val endPostCode: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<HealthcareParty>
