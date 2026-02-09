// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.codeStub_fromJs
import com.icure.cardinal.sdk.js.model.base.codeStub_toJs
import com.icure.cardinal.sdk.js.model.embed.TimeTableItemJs
import com.icure.cardinal.sdk.js.model.embed.timeTableItem_fromJs
import com.icure.cardinal.sdk.js.model.embed.timeTableItem_toJs
import com.icure.cardinal.sdk.model.TimeTable
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.embed.TimeTableItem
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun timeTable_toJs(obj: TimeTable): TimeTableJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val created = nullToUndefined(
		longToNumber(obj.created)
	)
	val modified = nullToUndefined(
		longToNumber(obj.modified)
	)
	val author = nullToUndefined(
		obj.author
	)
	val responsible = nullToUndefined(
		obj.responsible
	)
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val codes = setToArray(
		obj.codes,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val endOfLife = nullToUndefined(
		longToNumber(obj.endOfLife)
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val name = nullToUndefined(
		obj.name
	)
	val agendaId = nullToUndefined(
		obj.agendaId
	)
	val startTime = nullToUndefined(
		longToNumber(obj.startTime)
	)
	val endTime = nullToUndefined(
		longToNumber(obj.endTime)
	)
	val items = listToArray(
		obj.items,
		{ x1: TimeTableItem ->
			timeTableItem_toJs(x1)
		},
	)
	return TimeTableJs(js("{" +
		"id:id," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"tags:tags," +
		"codes:codes," +
		"endOfLife:endOfLife," +
		"deletionDate:deletionDate," +
		"name:name," +
		"agendaId:agendaId," +
		"startTime:startTime," +
		"endTime:endTime," +
		"items:items" +
	"}"))
}

public fun timeTable_fromJs(obj: TimeTableJs): TimeTable {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val author = undefinedToNull(obj.author)
	val responsible = undefinedToNull(obj.responsible)
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val codes = arrayToSet(
		obj.codes,
		"obj.codes",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val endOfLife = numberToLong(obj.endOfLife, "obj.endOfLife")
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val name = undefinedToNull(obj.name)
	val agendaId = undefinedToNull(obj.agendaId)
	val startTime = numberToLong(obj.startTime, "obj.startTime")
	val endTime = numberToLong(obj.endTime, "obj.endTime")
	val items = arrayToList(
		obj.items,
		"obj.items",
		{ x1: TimeTableItemJs ->
			timeTableItem_fromJs(x1)
		},
	)
	return TimeTable(
		id = id,
		rev = rev,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		tags = tags,
		codes = codes,
		endOfLife = endOfLife,
		deletionDate = deletionDate,
		name = name,
		agendaId = agendaId,
		startTime = startTime,
		endTime = endTime,
		items = items,
	)
}
