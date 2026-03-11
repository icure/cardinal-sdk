// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

/**
 * Filter that matches messages by healthcare party and transport guid, ordered by received date.
 * /
 */
@SerialName("MessageByHcPartyTransportGuidReceivedFilter")
@Serializable
data class MessageByHcPartyTransportGuidReceivedFilter(
	/**
	 * The identifier of the healthcare party.
	 */
	public val healthcarePartyId: String,
	/**
	 * The transport guid to match.
	 */
	public val transportGuid: String,
	/**
	 * Whether to return results in descending order.
	 */
	public val descending: Boolean? = null,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Message> {
	// region MessageByHcPartyTransportGuidReceivedFilter-MessageByHcPartyTransportGuidReceivedFilter

	// endregion
}
