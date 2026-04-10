// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

/**
 * Filter that matches services by healthcare party and code prefix.
 * /
 */
@SerialName("ServiceByHcPartyCodePrefixFilter")
@Serializable
data class ServiceByHcPartyCodePrefixFilter(
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String,
	/**
	 * The type of the code to match.
	 */
	public val codeType: String,
	/**
	 * The code prefix to match.
	 */
	public val codeCodePrefix: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * Optional start of a range of date for the value date of the service
	 */
	public val startValueDate: Long? = null,
	/**
	 * Optional end of a range of date for the value date of the service
	 */
	public val endValueDate: Long? = null,
) : AbstractFilter<Service> {
	// region ServiceByHcPartyCodePrefixFilter-ServiceByHcPartyCodePrefixFilter

	// endregion
}
