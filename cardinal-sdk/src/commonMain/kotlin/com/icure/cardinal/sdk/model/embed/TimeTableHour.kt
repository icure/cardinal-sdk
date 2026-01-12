package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Long

@Serializable
public data class TimeTableHour(
	public val startHour: Long? = null,
	public val endHour: Long? = null,
)
