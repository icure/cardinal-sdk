package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long

@Serializable
public data class MessageReadStatus(
	public val time: Long? = null,
	@DefaultValue("false")
	public val read: Boolean = false,
)
