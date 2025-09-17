package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Double

@Serializable
public data class Range(
	public val low: Double? = null,
	public val high: Double? = null,
)
