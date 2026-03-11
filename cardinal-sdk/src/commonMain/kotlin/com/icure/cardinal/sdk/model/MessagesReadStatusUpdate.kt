package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List

/**
 *
 *  DTO used to update the read status of one or more messages for a specific user.
 */
@Serializable
public data class MessagesReadStatusUpdate(
	/**
	 * The list of message identifiers to update.
	 */
	public val ids: List<String>? = null,
	/**
	 * The timestamp in epoch milliseconds when the messages were read.
	 */
	public val time: Long? = null,
	/**
	 * The new read status to set (true for read, false for unread).
	 */
	public val status: Boolean? = null,
	/**
	 * The identifier of the user whose read status is being updated.
	 */
	public val userId: String? = null,
)
