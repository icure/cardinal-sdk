// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.service

import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 * Filter that matches services by healthcare party and associated health element identifiers.
 * /
 */
@SerialName("ServiceByHcPartyHealthElementIdsFilter")
@Serializable
data class ServiceByHcPartyHealthElementIdsFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String? = null,
	/**
	 * The list of health element identifiers to match.
	 */
	@param:DefaultValue("emptyList()")
	public val healthElementIds: List<String> = emptyList(),
) : AbstractFilter<Service> {
	// region ServiceByHcPartyHealthElementIdsFilter-ServiceByHcPartyHealthElementIdsFilter

	// endregion
}
