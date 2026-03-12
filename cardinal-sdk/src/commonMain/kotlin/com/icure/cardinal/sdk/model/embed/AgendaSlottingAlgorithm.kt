package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int

@Serializable
public sealed interface AgendaSlottingAlgorithm {
	/**
	 *
	 *  The appointments can be taken at fixed intervals of [intervalMinutes] starting from the
	 * beginning of the
	 *  scheduled working hours for the available timetable item.
	 *  # Example
	 *  - Time table item scheduled 09:30-12:00, 12:45-14:00
	 *  - Time table item availabilities 10:03-10:50, 13:00-13:30,
	 *  - [intervalMinutes] = 10
	 *  - Calendar item type duration = 15
	 *  The returned slots for that time table item are 10:10, 10:20, 10:30, 13:05, 13:15
	 */
	@Serializable
	@SerialName("FixedIntervals")
	public data class FixedIntervals(
		public val intervalMinutes: Int,
	) : AgendaSlottingAlgorithm
}
