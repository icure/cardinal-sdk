// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

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
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.embed.EmbeddedTimeTableItem
import com.icure.cardinal.sdk.model.embed.ResourceGroupAllocationSchedule
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun resourceGroupAllocationSchedule_toJs(obj: ResourceGroupAllocationSchedule): ResourceGroupAllocationScheduleJs {
	val resourceGroup = nullToUndefined(
		obj.resourceGroup?.let { nonNull1 ->
			codeStub_toJs(nonNull1)
		}
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
	val name = nullToUndefined(
		obj.name
	)
	val startDateTime = nullToUndefined(
		longToNumber(obj.startDateTime)
	)
	val endDateTime = nullToUndefined(
		longToNumber(obj.endDateTime)
	)
	val items = listToArray(
		obj.items,
		{ x1: EmbeddedTimeTableItem ->
			embeddedTimeTableItem_toJs(x1)
		},
	)
	return ResourceGroupAllocationScheduleJs(js("{" +
		"resourceGroup:resourceGroup," +
		"tags:tags," +
		"codes:codes," +
		"name:name," +
		"startDateTime:startDateTime," +
		"endDateTime:endDateTime," +
		"items:items" +
	"}"))
}

public fun resourceGroupAllocationSchedule_fromJs(obj: ResourceGroupAllocationScheduleJs): ResourceGroupAllocationSchedule {
	val resourceGroup = obj.resourceGroup?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
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
	val name = undefinedToNull(obj.name)
	val startDateTime = numberToLong(obj.startDateTime, "obj.startDateTime")
	val endDateTime = numberToLong(obj.endDateTime, "obj.endDateTime")
	val items = arrayToList(
		obj.items,
		"obj.items",
		{ x1: EmbeddedTimeTableItemJs ->
			embeddedTimeTableItem_fromJs(x1)
		},
	)
	return ResourceGroupAllocationSchedule(
		resourceGroup = resourceGroup,
		tags = tags,
		codes = codes,
		name = name,
		startDateTime = startDateTime,
		endDateTime = endDateTime,
		items = items,
	)
}
