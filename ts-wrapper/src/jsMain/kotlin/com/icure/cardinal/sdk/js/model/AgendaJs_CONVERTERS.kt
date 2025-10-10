// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.codeStub_fromJs
import com.icure.cardinal.sdk.js.model.base.codeStub_toJs
import com.icure.cardinal.sdk.js.model.embed.ResourceGroupAllocationScheduleJs
import com.icure.cardinal.sdk.js.model.embed.RightJs
import com.icure.cardinal.sdk.js.model.embed.agendaSlottingAlgorithm_fromJs
import com.icure.cardinal.sdk.js.model.embed.agendaSlottingAlgorithm_toJs
import com.icure.cardinal.sdk.js.model.embed.resourceGroupAllocationSchedule_fromJs
import com.icure.cardinal.sdk.js.model.embed.resourceGroupAllocationSchedule_toJs
import com.icure.cardinal.sdk.js.model.embed.right_fromJs
import com.icure.cardinal.sdk.js.model.embed.right_toJs
import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.embed.ResourceGroupAllocationSchedule
import com.icure.cardinal.sdk.model.embed.Right
import com.icure.cardinal.sdk.model.embed.UserAccessLevel
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun agenda_toJs(obj: Agenda): AgendaJs {
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
	val medicalLocationId = nullToUndefined(
		obj.medicalLocationId
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
	val daySplitHour = nullToUndefined(
		intToNumber(obj.daySplitHour)
	)
	val unpublished = obj.unpublished
	val name = nullToUndefined(
		obj.name
	)
	val userId = nullToUndefined(
		obj.userId
	)
	val zoneId = nullToUndefined(
		obj.zoneId
	)
	val rights = listToArray(
		obj.rights,
		{ x1: Right ->
			right_toJs(x1)
		},
	)
	val userRights = mapToObject(
		obj.userRights,
		{ x1: String ->
			x1
		},
		{ x1: UserAccessLevel ->
			x1.name
		},
	)
	val slottingAlgorithm = nullToUndefined(
		obj.slottingAlgorithm?.let { nonNull1 ->
			agendaSlottingAlgorithm_toJs(nonNull1)
		}
	)
	val publicBookingQuota = nullToUndefined(
		intToNumber(obj.publicBookingQuota)
	)
	val properties = setToArray(
		obj.properties,
		{ x1: DecryptedPropertyStub ->
			propertyStub_toJs(x1)
		},
	)
	val schedules = listToArray(
		obj.schedules,
		{ x1: ResourceGroupAllocationSchedule ->
			resourceGroupAllocationSchedule_toJs(x1)
		},
	)
	return AgendaJs(js("{" +
		"id:id," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"medicalLocationId:medicalLocationId," +
		"tags:tags," +
		"codes:codes," +
		"endOfLife:endOfLife," +
		"deletionDate:deletionDate," +
		"daySplitHour:daySplitHour," +
		"unpublished:unpublished," +
		"name:name," +
		"userId:userId," +
		"zoneId:zoneId," +
		"rights:rights," +
		"userRights:userRights," +
		"slottingAlgorithm:slottingAlgorithm," +
		"publicBookingQuota:publicBookingQuota," +
		"properties:properties," +
		"schedules:schedules" +
	"}"))
}

public fun agenda_fromJs(obj: AgendaJs): Agenda {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val author = undefinedToNull(obj.author)
	val responsible = undefinedToNull(obj.responsible)
	val medicalLocationId = undefinedToNull(obj.medicalLocationId)
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
	val daySplitHour = numberToInt(obj.daySplitHour, "obj.daySplitHour")
	val unpublished = obj.unpublished
	val name = undefinedToNull(obj.name)
	val userId = undefinedToNull(obj.userId)
	val zoneId = undefinedToNull(obj.zoneId)
	val rights = arrayToList(
		obj.rights,
		"obj.rights",
		{ x1: RightJs ->
			right_fromJs(x1)
		},
	)
	val userRights = objectToMap(
		obj.userRights,
		"obj.userRights",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			UserAccessLevel.valueOf(x1)
		},
	)
	val slottingAlgorithm = obj.slottingAlgorithm?.let { nonNull1 ->
		agendaSlottingAlgorithm_fromJs(nonNull1)
	}
	val publicBookingQuota = numberToInt(obj.publicBookingQuota, "obj.publicBookingQuota")
	val properties = arrayToSet(
		obj.properties,
		"obj.properties",
		{ x1: DecryptedPropertyStubJs ->
			propertyStub_fromJs(x1)
		},
	)
	val schedules = arrayToList(
		obj.schedules,
		"obj.schedules",
		{ x1: ResourceGroupAllocationScheduleJs ->
			resourceGroupAllocationSchedule_fromJs(x1)
		},
	)
	return Agenda(
		id = id,
		rev = rev,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		medicalLocationId = medicalLocationId,
		tags = tags,
		codes = codes,
		endOfLife = endOfLife,
		deletionDate = deletionDate,
		daySplitHour = daySplitHour,
		unpublished = unpublished,
		name = name,
		userId = userId,
		zoneId = zoneId,
		rights = rights,
		userRights = userRights,
		slottingAlgorithm = slottingAlgorithm,
		publicBookingQuota = publicBookingQuota,
		properties = properties,
		schedules = schedules,
	)
}
