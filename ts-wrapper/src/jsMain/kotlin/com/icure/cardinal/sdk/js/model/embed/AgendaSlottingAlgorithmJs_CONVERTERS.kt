// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.model.embed.AgendaSlottingAlgorithm
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun agendaSlottingAlgorithm_toJs(obj: AgendaSlottingAlgorithm): AgendaSlottingAlgorithmJs = when (obj) {
	is AgendaSlottingAlgorithm.FixedIntervals -> agendaSlottingAlgorithm_FixedIntervals_toJs(obj)
}

public fun agendaSlottingAlgorithm_fromJs(obj: AgendaSlottingAlgorithmJs): AgendaSlottingAlgorithm = when {
	obj is AgendaSlottingAlgorithmJs_FixedIntervalsJs || obj.ktClass == "com.icure.cardinal.sdk.model.embed.AgendaSlottingAlgorithm.FixedIntervals" ->agendaSlottingAlgorithm_FixedIntervals_fromJs(obj as com.icure.cardinal.sdk.js.model.embed.AgendaSlottingAlgorithmJs_FixedIntervalsJs)
	else -> throw IllegalArgumentException("""Unknown concrete implementation for com.icure.cardinal.sdk.model.embed.AgendaSlottingAlgorithm: $obj""")
}

@Suppress("UNUSED_VARIABLE")
public fun agendaSlottingAlgorithm_FixedIntervals_toJs(obj: AgendaSlottingAlgorithm.FixedIntervals): AgendaSlottingAlgorithmJs_FixedIntervalsJs {
	val intervalMinutes = intToNumber(obj.intervalMinutes)
	return AgendaSlottingAlgorithmJs_FixedIntervalsJs(js("{" +
		"intervalMinutes:intervalMinutes" +
	"}"))
}

public fun agendaSlottingAlgorithm_FixedIntervals_fromJs(obj: AgendaSlottingAlgorithmJs_FixedIntervalsJs): AgendaSlottingAlgorithm.FixedIntervals {
	val intervalMinutes = numberToInt(obj.intervalMinutes, "obj.intervalMinutes")
	return AgendaSlottingAlgorithm.FixedIntervals(
		intervalMinutes = intervalMinutes,
	)
}
