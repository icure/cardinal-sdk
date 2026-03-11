// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.healthelement

import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.VersionFiltering
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

/**
 * Filter that matches health elements by healthcare party, code, and date range.
 * /
 */
@SerialName("HealthElementByHcPartyCodeFilter")
@Serializable
data class HealthElementByHcPartyCodeFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String,
	/**
	 * The type of the code to match.
	 */
	public val codeType: String,
	/**
	 * The code value to match.
	 */
	public val codeCode: String,
	/**
	 * The start of the health element date range.
	 */
	public val startOfHealthElementDate: Long? = null,
	/**
	 * The end of the health element date range.
	 */
	public val endOfHealthElementDate: Long? = null,
	/**
	 * Optional version filtering criteria.
	 */
	public val versionFiltering: VersionFiltering? = null,
) : AbstractFilter<HealthElement> {
	// region HealthElementByHcPartyCodeFilter-HealthElementByHcPartyCodeFilter

	// endregion
}
