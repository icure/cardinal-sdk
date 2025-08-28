package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List

@Serializable
public data class MessagesReadStatusUpdate(
	public val ids: List<String>? = null,
	public val time: Long? = null,
	public val status: Boolean? = null,
	public val userId: String? = null,
)
