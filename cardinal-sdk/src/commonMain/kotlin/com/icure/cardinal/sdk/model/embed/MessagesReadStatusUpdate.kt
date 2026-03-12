package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List

/**
 * Represents a batch update request for the read status of multiple messages.
 * /
 */
@Serializable
public data class MessagesReadStatusUpdate(
	/**
	 * The list of message identifiers to update.
	 */
	public val ids: List<String>? = null,
	/**
	 * The identifier of the user whose read status is being updated.
	 */
	public val userId: String? = null,
	/**
	 * The timestamp (unix epoch in ms) of the status update.
	 */
	public val time: Long? = null,
	/**
	 * The new read status (true for read, false for unread).
	 */
	public val status: Boolean? = null,
)
