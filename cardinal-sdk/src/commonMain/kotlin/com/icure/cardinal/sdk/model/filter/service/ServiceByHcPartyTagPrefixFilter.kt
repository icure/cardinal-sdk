// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches services by healthcare party and tag prefix.
 * /
 */
@SerialName("ServiceByHcPartyTagPrefixFilter")
@Serializable
data class ServiceByHcPartyTagPrefixFilter(
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String,
	/**
	 * The type of the tag to match.
	 */
	public val tagType: String,
	/**
	 * The tag code prefix to match.
	 */
	public val tagCodePrefix: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Service> {
	// region ServiceByHcPartyTagPrefixFilter-ServiceByHcPartyTagPrefixFilter

	// endregion
}
