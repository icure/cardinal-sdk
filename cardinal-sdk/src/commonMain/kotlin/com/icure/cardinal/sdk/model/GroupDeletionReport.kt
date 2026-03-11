package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  DTO representing a report generated after a group deletion operation.
 */
@Serializable
public data class GroupDeletionReport(
	/**
	 * The type of the deleted resource.
	 */
	public val type: String,
	/**
	 * The unique identifier of the deleted group.
	 */
	public val id: String,
	/**
	 * The server on which the group was deleted.
	 */
	public val server: String,
)
