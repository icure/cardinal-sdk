package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long

/**
 * Represents the read status of a message for a specific user, tracking whether it has been read
 * and when.
 * /
 */
@Serializable
public data class MessageReadStatus(
	/**
	 * The timestamp (unix epoch in ms) when the message was read.
	 */
	public val time: Long? = null,
	/**
	 * Whether the message has been read.
	 */
	@param:DefaultValue("false")
	public val read: Boolean = false,
)
