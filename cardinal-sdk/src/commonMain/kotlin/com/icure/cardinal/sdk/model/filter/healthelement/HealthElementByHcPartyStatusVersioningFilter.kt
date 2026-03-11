// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.VersionFiltering
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

/**
 * Filter that matches health elements by healthcare party, status, and version filtering.
 * /
 */
@SerialName("HealthElementByHcPartyStatusVersioningFilter")
@Serializable
data class HealthElementByHcPartyStatusVersioningFilter(
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
	/**
	 * Optional version filtering criteria.
	 */
	public val versionFiltering: VersionFiltering? = null,
) : AbstractFilter<HealthElement> {
	// region HealthElementByHcPartyStatusVersioningFilter-HealthElementByHcPartyStatusVersioningFilter

	// endregion
}
