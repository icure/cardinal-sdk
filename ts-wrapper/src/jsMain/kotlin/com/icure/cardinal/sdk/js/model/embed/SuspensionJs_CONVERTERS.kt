// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.embed.Suspension
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun suspension_toJs(obj: Suspension): SuspensionJs {
	val beginMoment = nullToUndefined(
		longToNumber(obj.beginMoment)
	)
	val endMoment = nullToUndefined(
		longToNumber(obj.endMoment)
	)
	val suspensionReason = nullToUndefined(
		obj.suspensionReason
	)
	val lifecycle = nullToUndefined(
		obj.lifecycle
	)
	return SuspensionJs(js("{" +
		"beginMoment:beginMoment," +
		"endMoment:endMoment," +
		"suspensionReason:suspensionReason," +
		"lifecycle:lifecycle" +
	"}"))
}

public fun suspension_fromJs(obj: SuspensionJs): Suspension {
	val beginMoment = numberToLong(obj.beginMoment, "obj.beginMoment")
	val endMoment = numberToLong(obj.endMoment, "obj.endMoment")
	val suspensionReason = undefinedToNull(obj.suspensionReason)
	val lifecycle = undefinedToNull(obj.lifecycle)
	return Suspension(
		beginMoment = beginMoment,
		endMoment = endMoment,
		suspensionReason = suspensionReason,
		lifecycle = lifecycle,
	)
}
