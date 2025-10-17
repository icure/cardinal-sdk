package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int

@Serializable
public data class ReplicationInfo(
	@DefaultValue("false")
	public val active: Boolean = false,
	@DefaultValue("false")
	public val running: Boolean = false,
	public val pendingFrom: Int? = null,
	public val pendingTo: Int? = null,
)
