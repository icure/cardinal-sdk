package com.icure.cardinal.sdk.model.filter.message

import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches messages by data owner and sender address.
 * /
 */
@SerialName("MessageByDataOwnerFromAddressFilter")
@Serializable
public data class MessageByDataOwnerFromAddressFilter(
	/**
	 * The identifier of the data owner.
	 */
	public val dataOwnerId: String,
	/**
	 * The sender address to match.
	 */
	public val fromAddress: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Message>
