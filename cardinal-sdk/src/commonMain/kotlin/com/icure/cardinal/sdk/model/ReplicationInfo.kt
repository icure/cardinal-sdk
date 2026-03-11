// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int

/**
 * DTO providing status information about an ongoing or configured database replication.
 * /
 */
@Serializable
data class ReplicationInfo(
	/**
	 * Whether the replication is currently active.
	 */
	@param:DefaultValue("false")
	public val active: Boolean = false,
	/**
	 * Whether the replication process is currently running.
	 */
	@param:DefaultValue("false")
	public val running: Boolean = false,
	/**
	 * The number of pending changes to replicate from the source.
	 */
	public val pendingFrom: Int? = null,
	/**
	 * The number of pending changes to replicate to the target.
	 */
	public val pendingTo: Int? = null,
) {
	// region ReplicationInfo-ReplicationInfo

	// endregion
}
