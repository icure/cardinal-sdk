// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
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
data class HealthcarePartyByNameFilter(
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
) : AbstractFilter<HealthcareParty> {
	// region HealthcarePartyByNameFilter-HealthcarePartyByNameFilter

	// endregion
}
