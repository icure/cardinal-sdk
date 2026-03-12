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
public data class ReplicationInfo(
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
)
