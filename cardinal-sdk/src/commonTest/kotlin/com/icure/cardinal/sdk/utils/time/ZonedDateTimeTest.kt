package com.icure.cardinal.sdk.utils.time

import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ZonedDateTimeTest : StringSpec({
	"Full zoned date time test".config(enabled = DEFAULT_ENABLED) {
		listOf(
			Triple("2025-02-24T15:07:01.564571","-05:00", "America/New_York"),
			Triple("2025-02-24T15:07:01","Z", "UTC"),
			Triple("2025-02-24T15:07:01.564571","+01:00", "UT+01:00"),
		).forEach { (time, offset, zone) ->
			val format = "$time$offset[$zone]"
			val parsed = ZonedDateTime.fromIso8601AndZoneString(format)
			parsed.toIso8601AndZoneString() shouldBe format
		}
	}

	"Offset only zone test".config(enabled = DEFAULT_ENABLED) {
		listOf(
			Pair("2025-02-24T15:06:08.886342","+01:00"),
			Pair("2025-02-24T15:06:08.886342","-02:30"),
			Pair("2025-02-24T12:00:01", "Z")
		).forEach { (time, offset) ->
			val format = "$time$offset"
			val parsed = ZonedDateTime.fromIso8601AndZoneString(format)
			parsed.toIso8601AndZoneString() shouldBe format
			parsed.zoneId.id shouldBe offset
		}
	}

	"Invalid input test".config(enabled = DEFAULT_ENABLED) {
		listOf(
			"2025-02-24T12:00:12",
			"2025-02-24T12:00:12UTC",
			"2025-02-24T12:00:12-02:30[Europe/New_York]",
			"[America/New_York]",
			"-02:30",
		).forEach {
			shouldThrow<IllegalArgumentException> { ZonedDateTime.fromIso8601AndZoneString(it) }
		}
	}
})