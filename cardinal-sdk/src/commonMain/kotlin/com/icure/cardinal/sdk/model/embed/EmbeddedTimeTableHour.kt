package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Int

@Serializable
public data class EmbeddedTimeTableHour(
	public val startHour: Int,
	public val endHour: Int,
)
