package com.icure.cardinal.sdk.utils

import kotlin.time.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock

/**
 * Get the epoch timestamp in milliseconds (since midnight, January 1, 1970 UTC).
 */
fun currentEpochMs(): Long =
	currentEpochInstant().toEpochMilliseconds()

/**
 * Get the current epoch timestamp.

 */
fun currentEpochInstant(): Instant =
	Clock.System.now()

fun currentFuzzyDateTime(timeZone: TimeZone): Long =
	Clock.System.now().toLocalDateTime(timeZone).format(LocalDateTime.Format {
		year()
		monthNumber()
		day()
		hour()
		minute()
		second()
	}).toLong()
