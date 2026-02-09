// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("TimeTableItem")
public external class TimeTableItemJs(
	partial: dynamic,
) {
	public val rruleStartDate: Double?

	public val rrule: String?

	public val notBeforeInMinutes: Double?

	public val notAfterInMinutes: Double?

	public val zoneId: String?

	public val hours: Array<TimeTableHourJs>

	public val calendarItemTypeId: String?

	public val homeVisit: Boolean

	public val placeId: String?

	public val publicTimeTableItem: Boolean

	public val acceptsNewPatient: Boolean

	public val unavailable: Boolean

	public val reservingRights: Array<String>
}
