package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.model.embed.Measure
import kotlinx.serialization.Serializable

@Serializable
public data class MeasurePair(
	public val first: Measure? = null,
	public val second: Measure? = null,
)
