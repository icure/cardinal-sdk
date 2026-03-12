// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  DTO representing a report generated after a group deletion operation.
 */
@Serializable
data class GroupDeletionReport(
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
) {
	// region GroupDeletionReport-GroupDeletionReport

	// endregion
}
