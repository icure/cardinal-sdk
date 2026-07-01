// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.model.CalendarItemOccupancy
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun calendarItemOccupancy_toJs(obj: CalendarItemOccupancy): CalendarItemOccupancyJs {
	val timestamp = longToNumber(obj.timestamp)
	val occupancy = longToNumber(obj.occupancy)
	return CalendarItemOccupancyJs(js("{" +
		"timestamp:timestamp," +
		"occupancy:occupancy" +
	"}"))
}

public fun calendarItemOccupancy_fromJs(obj: CalendarItemOccupancyJs): CalendarItemOccupancy {
	val timestamp = numberToLong(obj.timestamp, "obj.timestamp")
	val occupancy = numberToLong(obj.occupancy, "obj.occupancy")
	return CalendarItemOccupancy(
		timestamp = timestamp,
		occupancy = occupancy,
	)
}
