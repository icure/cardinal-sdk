package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Int

/**
 * Represents a time range within a time table, defined by a start and end hour.
 * /
 */
@Serializable
public data class EmbeddedTimeTableHour(
	/**
	 * The start hour encoded as an integer.
	 */
	public val startHour: Int,
	/**
	 * The end hour encoded as an integer.
	 */
	public val endHour: Int,
)
