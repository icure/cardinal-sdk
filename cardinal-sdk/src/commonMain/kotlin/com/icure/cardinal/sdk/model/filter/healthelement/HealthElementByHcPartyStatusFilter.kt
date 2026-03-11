// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

/**
 * Filter that matches health elements by healthcare party and status.
 * /
 */
@SerialName("HealthElementByHcPartyStatusFilter")
@Serializable
data class HealthElementByHcPartyStatusFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The identifier of the healthcare party.
	 */
	public val hcPartyId: String,
	/**
	 * The status value to match.
	 */
	public val status: Int,
) : AbstractFilter<HealthElement> {
	// region HealthElementByHcPartyStatusFilter-HealthElementByHcPartyStatusFilter

	// endregion
}
