// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.CalendarItemType
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun calendarItemType_toJs(obj: CalendarItemType): CalendarItemTypeJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	val agendaId = nullToUndefined(
		obj.agendaId
	)
	val defaultCalendarItemType = obj.defaultCalendarItemType
	val name = nullToUndefined(
		obj.name
	)
	val color = nullToUndefined(
		obj.color
	)
	val duration = intToNumber(obj.duration)
	val extraDurationsConfig = nullToUndefined(
		obj.extraDurationsConfig?.let { nonNull1 ->
			calendarItemType_DurationConfig_toJs(nonNull1)
		}
	)
	val externalRef = nullToUndefined(
		obj.externalRef
	)
	val mikronoId = nullToUndefined(
		obj.mikronoId
	)
	val docIds = setToArray(
		obj.docIds,
		{ x1: String ->
			x1
		},
	)
	val otherInfos = mapToObject(
		obj.otherInfos,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val subjectByLanguage = mapToObject(
		obj.subjectByLanguage,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	return CalendarItemTypeJs(js("{" +
		"id:id," +
		"rev:rev," +
		"deletionDate:deletionDate," +
		"healthcarePartyId:healthcarePartyId," +
		"agendaId:agendaId," +
		"defaultCalendarItemType:defaultCalendarItemType," +
		"name:name," +
		"color:color," +
		"duration:duration," +
		"extraDurationsConfig:extraDurationsConfig," +
		"externalRef:externalRef," +
		"mikronoId:mikronoId," +
		"docIds:docIds," +
		"otherInfos:otherInfos," +
		"subjectByLanguage:subjectByLanguage" +
	"}"))
}

public fun calendarItemType_fromJs(obj: CalendarItemTypeJs): CalendarItemType {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	val agendaId = undefinedToNull(obj.agendaId)
	val defaultCalendarItemType = obj.defaultCalendarItemType
	val name = undefinedToNull(obj.name)
	val color = undefinedToNull(obj.color)
	val duration = numberToInt(obj.duration, "obj.duration")
	val extraDurationsConfig = obj.extraDurationsConfig?.let { nonNull1 ->
		calendarItemType_DurationConfig_fromJs(nonNull1)
	}
	val externalRef = undefinedToNull(obj.externalRef)
	val mikronoId = undefinedToNull(obj.mikronoId)
	val docIds = arrayToSet(
		obj.docIds,
		"obj.docIds",
		{ x1: String ->
			x1
		},
	)
	val otherInfos = objectToMap(
		obj.otherInfos,
		"obj.otherInfos",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val subjectByLanguage = objectToMap(
		obj.subjectByLanguage,
		"obj.subjectByLanguage",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	return CalendarItemType(
		id = id,
		rev = rev,
		deletionDate = deletionDate,
		healthcarePartyId = healthcarePartyId,
		agendaId = agendaId,
		defaultCalendarItemType = defaultCalendarItemType,
		name = name,
		color = color,
		duration = duration,
		extraDurationsConfig = extraDurationsConfig,
		externalRef = externalRef,
		mikronoId = mikronoId,
		docIds = docIds,
		otherInfos = otherInfos,
		subjectByLanguage = subjectByLanguage,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun calendarItemType_DurationConfig_toJs(obj: CalendarItemType.DurationConfig):
		CalendarItemTypeJs_DurationConfigJs = when (obj) {
	is CalendarItemType.DurationConfig.Set -> calendarItemType_DurationConfig_Set_toJs(obj)
	is CalendarItemType.DurationConfig.Formula -> calendarItemType_DurationConfig_Formula_toJs(obj)
}

public fun calendarItemType_DurationConfig_fromJs(obj: CalendarItemTypeJs_DurationConfigJs):
		CalendarItemType.DurationConfig = when {
	obj is CalendarItemTypeJs_DurationConfigJs_SetJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.CalendarItemType.DurationConfig.Set" ->calendarItemType_DurationConfig_Set_fromJs(obj
			as com.icure.cardinal.sdk.js.model.CalendarItemTypeJs_DurationConfigJs_SetJs)
	obj is CalendarItemTypeJs_DurationConfigJs_FormulaJs || obj.ktClass ==
			"com.icure.cardinal.sdk.model.CalendarItemType.DurationConfig.Formula" ->calendarItemType_DurationConfig_Formula_fromJs(obj
			as com.icure.cardinal.sdk.js.model.CalendarItemTypeJs_DurationConfigJs_FormulaJs)
	else -> throw
			IllegalArgumentException("""Unknown concrete implementation for com.icure.cardinal.sdk.model.CalendarItemType.DurationConfig: $obj""")
}

@Suppress("UNUSED_VARIABLE")
public fun calendarItemType_DurationConfig_Set_toJs(obj: CalendarItemType.DurationConfig.Set):
		CalendarItemTypeJs_DurationConfigJs_SetJs {
	val durations = setToArray(
		obj.durations,
		{ x1: Int ->
			intToNumber(x1)
		},
	)
	return CalendarItemTypeJs_DurationConfigJs_SetJs(js("{" +
		"durations:durations" +
	"}"))
}

public
		fun calendarItemType_DurationConfig_Set_fromJs(obj: CalendarItemTypeJs_DurationConfigJs_SetJs):
		CalendarItemType.DurationConfig.Set {
	val durations = arrayToSet(
		obj.durations,
		"obj.durations",
		{ x1: Double ->
			numberToInt(x1, "x1")
		},
	)
	return CalendarItemType.DurationConfig.Set(
		durations = durations,
	)
}

@Suppress("UNUSED_VARIABLE")
public
		fun calendarItemType_DurationConfig_Formula_toJs(obj: CalendarItemType.DurationConfig.Formula):
		CalendarItemTypeJs_DurationConfigJs_FormulaJs {
	val min = intToNumber(obj.min)
	val max = intToNumber(obj.max)
	val step = intToNumber(obj.step)
	return CalendarItemTypeJs_DurationConfigJs_FormulaJs(js("{" +
		"min:min," +
		"max:max," +
		"step:step" +
	"}"))
}

public
		fun calendarItemType_DurationConfig_Formula_fromJs(obj: CalendarItemTypeJs_DurationConfigJs_FormulaJs):
		CalendarItemType.DurationConfig.Formula {
	val min = numberToInt(obj.min, "obj.min")
	val max = numberToInt(obj.max, "obj.max")
	val step = numberToInt(obj.step, "obj.step")
	return CalendarItemType.DurationConfig.Formula(
		min = min,
		max = max,
		step = step,
	)
}
