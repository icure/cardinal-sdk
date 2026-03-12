// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
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
data class HealthcarePartyByTypeSpecialtyPostCodeFilter(
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
) : AbstractFilter<HealthcareParty> {
	// region HealthcarePartyByTypeSpecialtyPostCodeFilter-HealthcarePartyByTypeSpecialtyPostCodeFilter

	// endregion
}
