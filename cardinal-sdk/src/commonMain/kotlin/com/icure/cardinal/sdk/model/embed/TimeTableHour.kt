package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Long

/**
 * Represents a time range within a time table, defined by start and end hours.
 * /
 */
@Serializable
public data class TimeTableHour(
	/**
	 * The start hour encoded as a long (hh:mm:ss).
	 */
	public val startHour: Long? = null,
	/**
	 * The end hour encoded as a long (hh:mm:ss).
	 */
	public val endHour: Long? = null,
)
