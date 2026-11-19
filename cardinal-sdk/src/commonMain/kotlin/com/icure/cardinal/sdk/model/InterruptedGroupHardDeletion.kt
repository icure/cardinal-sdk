// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

/**
 *
 *  A group whose hard deletion was interrupted: hard deleting the group again resumes it.
 */
@Serializable
data class InterruptedGroupHardDeletion(
	/**
	 * The id of the group.
	 */
	public val groupId: String,
	/**
	 * When the group was soft deleted.
	 */
	public val deletionDate: Long? = null,
	/**
	 * When the hard deletion started, null for a group hard deleted before group tombstones existed.
	 */
	public val hardDeletionStartedAt: Long? = null,
) {
	// region InterruptedGroupHardDeletion-InterruptedGroupHardDeletion

	// endregion
}
