package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String
import kotlin.collections.Map

@Serializable
public data class IndexingInfo(
	public val statuses: Map<String, Int>? = null,
)
