// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.embed.FlowItem
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun flowItem_toJs(obj: FlowItem): FlowItemJs {
	val id = nullToUndefined(
		obj.id
	)
	val title = nullToUndefined(
		obj.title
	)
	val comment = nullToUndefined(
		obj.comment
	)
	val receptionDate = nullToUndefined(
		longToNumber(obj.receptionDate)
	)
	val processingDate = nullToUndefined(
		longToNumber(obj.processingDate)
	)
	val processer = nullToUndefined(
		obj.processer
	)
	val cancellationDate = nullToUndefined(
		longToNumber(obj.cancellationDate)
	)
	val canceller = nullToUndefined(
		obj.canceller
	)
	val cancellationReason = nullToUndefined(
		obj.cancellationReason
	)
	val cancellationNote = nullToUndefined(
		obj.cancellationNote
	)
	val status = nullToUndefined(
		obj.status
	)
	val homeVisit = nullToUndefined(
		obj.homeVisit
	)
	val municipality = nullToUndefined(
		obj.municipality
	)
	val town = nullToUndefined(
		obj.town
	)
	val zipCode = nullToUndefined(
		obj.zipCode
	)
	val street = nullToUndefined(
		obj.street
	)
	val building = nullToUndefined(
		obj.building
	)
	val buildingNumber = nullToUndefined(
		obj.buildingNumber
	)
	val doorbellName = nullToUndefined(
		obj.doorbellName
	)
	val floor = nullToUndefined(
		obj.floor
	)
	val letterBox = nullToUndefined(
		obj.letterBox
	)
	val notesOps = nullToUndefined(
		obj.notesOps
	)
	val notesContact = nullToUndefined(
		obj.notesContact
	)
	val latitude = nullToUndefined(
		obj.latitude
	)
	val longitude = nullToUndefined(
		obj.longitude
	)
	val type = nullToUndefined(
		obj.type
	)
	val emergency = nullToUndefined(
		obj.emergency
	)
	val phoneNumber = nullToUndefined(
		obj.phoneNumber
	)
	val patientId = nullToUndefined(
		obj.patientId
	)
	val patientLastName = nullToUndefined(
		obj.patientLastName
	)
	val patientFirstName = nullToUndefined(
		obj.patientFirstName
	)
	val description = nullToUndefined(
		obj.description
	)
	val interventionCode = nullToUndefined(
		obj.interventionCode
	)
	return FlowItemJs(js("{" +
		"id:id," +
		"title:title," +
		"comment:comment," +
		"receptionDate:receptionDate," +
		"processingDate:processingDate," +
		"processer:processer," +
		"cancellationDate:cancellationDate," +
		"canceller:canceller," +
		"cancellationReason:cancellationReason," +
		"cancellationNote:cancellationNote," +
		"status:status," +
		"homeVisit:homeVisit," +
		"municipality:municipality," +
		"town:town," +
		"zipCode:zipCode," +
		"street:street," +
		"building:building," +
		"buildingNumber:buildingNumber," +
		"doorbellName:doorbellName," +
		"floor:floor," +
		"letterBox:letterBox," +
		"notesOps:notesOps," +
		"notesContact:notesContact," +
		"latitude:latitude," +
		"longitude:longitude," +
		"type:type," +
		"emergency:emergency," +
		"phoneNumber:phoneNumber," +
		"patientId:patientId," +
		"patientLastName:patientLastName," +
		"patientFirstName:patientFirstName," +
		"description:description," +
		"interventionCode:interventionCode" +
	"}"))
}

public fun flowItem_fromJs(obj: FlowItemJs): FlowItem {
	val id = undefinedToNull(obj.id)
	val title = undefinedToNull(obj.title)
	val comment = undefinedToNull(obj.comment)
	val receptionDate = numberToLong(obj.receptionDate, "obj.receptionDate")
	val processingDate = numberToLong(obj.processingDate, "obj.processingDate")
	val processer = undefinedToNull(obj.processer)
	val cancellationDate = numberToLong(obj.cancellationDate, "obj.cancellationDate")
	val canceller = undefinedToNull(obj.canceller)
	val cancellationReason = undefinedToNull(obj.cancellationReason)
	val cancellationNote = undefinedToNull(obj.cancellationNote)
	val status = undefinedToNull(obj.status)
	val homeVisit = undefinedToNull(obj.homeVisit)
	val municipality = undefinedToNull(obj.municipality)
	val town = undefinedToNull(obj.town)
	val zipCode = undefinedToNull(obj.zipCode)
	val street = undefinedToNull(obj.street)
	val building = undefinedToNull(obj.building)
	val buildingNumber = undefinedToNull(obj.buildingNumber)
	val doorbellName = undefinedToNull(obj.doorbellName)
	val floor = undefinedToNull(obj.floor)
	val letterBox = undefinedToNull(obj.letterBox)
	val notesOps = undefinedToNull(obj.notesOps)
	val notesContact = undefinedToNull(obj.notesContact)
	val latitude = undefinedToNull(obj.latitude)
	val longitude = undefinedToNull(obj.longitude)
	val type = undefinedToNull(obj.type)
	val emergency = undefinedToNull(obj.emergency)
	val phoneNumber = undefinedToNull(obj.phoneNumber)
	val patientId = undefinedToNull(obj.patientId)
	val patientLastName = undefinedToNull(obj.patientLastName)
	val patientFirstName = undefinedToNull(obj.patientFirstName)
	val description = undefinedToNull(obj.description)
	val interventionCode = undefinedToNull(obj.interventionCode)
	return FlowItem(
		id = id,
		title = title,
		comment = comment,
		receptionDate = receptionDate,
		processingDate = processingDate,
		processer = processer,
		cancellationDate = cancellationDate,
		canceller = canceller,
		cancellationReason = cancellationReason,
		cancellationNote = cancellationNote,
		status = status,
		homeVisit = homeVisit,
		municipality = municipality,
		town = town,
		zipCode = zipCode,
		street = street,
		building = building,
		buildingNumber = buildingNumber,
		doorbellName = doorbellName,
		floor = floor,
		letterBox = letterBox,
		notesOps = notesOps,
		notesContact = notesContact,
		latitude = latitude,
		longitude = longitude,
		type = type,
		emergency = emergency,
		phoneNumber = phoneNumber,
		patientId = patientId,
		patientLastName = patientLastName,
		patientFirstName = patientFirstName,
		description = description,
		interventionCode = interventionCode,
	)
}
