// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches the latest message for a healthcare party and transport guid combination.
 * /
 */
@SerialName("LatestMessageByHcPartyTransportGuidFilter")
@Serializable
data class LatestMessageByHcPartyTransportGuidFilter(
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String,
	/**
	 * The transport guid to match.
	 */
	public val transportGuid: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Message> {
	// region LatestMessageByHcPartyTransportGuidFilter-LatestMessageByHcPartyTransportGuidFilter

	// endregion
}
