// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.codeStub_fromJs
import com.icure.cardinal.sdk.js.model.base.codeStub_toJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedCalendarItemTagJs
import com.icure.cardinal.sdk.js.model.embed.DelegationJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedCalendarItemTagJs
import com.icure.cardinal.sdk.js.model.embed.address_fromJs
import com.icure.cardinal.sdk.js.model.embed.address_toJs
import com.icure.cardinal.sdk.js.model.embed.calendarItemTag_fromJs
import com.icure.cardinal.sdk.js.model.embed.calendarItemTag_toJs
import com.icure.cardinal.sdk.js.model.embed.delegation_fromJs
import com.icure.cardinal.sdk.js.model.embed.delegation_toJs
import com.icure.cardinal.sdk.js.model.embed.securityMetadata_fromJs
import com.icure.cardinal.sdk.js.model.embed.securityMetadata_toJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.embed.DecryptedCalendarItemTag
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.EncryptedCalendarItemTag
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Set

@Suppress("UNUSED_VARIABLE")
public fun calendarItem_toJs(obj: DecryptedCalendarItem): DecryptedCalendarItemJs {
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
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val title = nullToUndefined(
		obj.title
	)
	val calendarItemTypeId = nullToUndefined(
		obj.calendarItemTypeId
	)
	val masterCalendarItemId = nullToUndefined(
		obj.masterCalendarItemId
	)
	val important = nullToUndefined(
		obj.important
	)
	val homeVisit = nullToUndefined(
		obj.homeVisit
	)
	val placeId = nullToUndefined(
		obj.placeId
	)
	val address = nullToUndefined(
		obj.address?.let { nonNull1 ->
			address_toJs(nonNull1)
		}
	)
	val addressText = nullToUndefined(
		obj.addressText
	)
	val startTime = nullToUndefined(
		longToNumber(obj.startTime)
	)
	val endTime = nullToUndefined(
		longToNumber(obj.endTime)
	)
	val details = nullToUndefined(
		obj.details
	)
	val wasMigrated = nullToUndefined(
		obj.wasMigrated
	)
	val agendaId = nullToUndefined(
		obj.agendaId
	)
	val resourceGroup = nullToUndefined(
		obj.resourceGroup?.let { nonNull1 ->
			codeStub_toJs(nonNull1)
		}
	)
	val availabilitiesAssignmentStrategy = nullToUndefined(
		obj.availabilitiesAssignmentStrategy?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val recurrenceId = nullToUndefined(
		obj.recurrenceId
	)
	val meetingTags = setToArray(
		obj.meetingTags,
		{ x1: DecryptedCalendarItemTag ->
			calendarItemTag_toJs(x1)
		},
	)
	val secretForeignKeys = setToArray(
		obj.secretForeignKeys,
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = mapToObject(
		obj.cryptedForeignKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val delegations = mapToObject(
		obj.delegations,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptionKeys = mapToObject(
		obj.encryptionKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	val securityMetadata = nullToUndefined(
		obj.securityMetadata?.let { nonNull1 ->
			securityMetadata_toJs(nonNull1)
		}
	)
	return DecryptedCalendarItemJs(js("{" +
		"id:id," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"tags:tags," +
		"codes:codes," +
		"deletionDate:deletionDate," +
		"title:title," +
		"calendarItemTypeId:calendarItemTypeId," +
		"masterCalendarItemId:masterCalendarItemId," +
		"important:important," +
		"homeVisit:homeVisit," +
		"placeId:placeId," +
		"address:address," +
		"addressText:addressText," +
		"startTime:startTime," +
		"endTime:endTime," +
		"details:details," +
		"wasMigrated:wasMigrated," +
		"agendaId:agendaId," +
		"resourceGroup:resourceGroup," +
		"availabilitiesAssignmentStrategy:availabilitiesAssignmentStrategy," +
		"recurrenceId:recurrenceId," +
		"meetingTags:meetingTags," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata" +
	"}"))
}

public fun calendarItem_fromJs(obj: DecryptedCalendarItemJs): DecryptedCalendarItem {
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
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val title = undefinedToNull(obj.title)
	val calendarItemTypeId = undefinedToNull(obj.calendarItemTypeId)
	val masterCalendarItemId = undefinedToNull(obj.masterCalendarItemId)
	val important = undefinedToNull(obj.important)
	val homeVisit = undefinedToNull(obj.homeVisit)
	val placeId = undefinedToNull(obj.placeId)
	val address = obj.address?.let { nonNull1 ->
		address_fromJs(nonNull1)
	}
	val addressText = undefinedToNull(obj.addressText)
	val startTime = numberToLong(obj.startTime, "obj.startTime")
	val endTime = numberToLong(obj.endTime, "obj.endTime")
	val details = undefinedToNull(obj.details)
	val wasMigrated = undefinedToNull(obj.wasMigrated)
	val agendaId = undefinedToNull(obj.agendaId)
	val resourceGroup = obj.resourceGroup?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val availabilitiesAssignmentStrategy = obj.availabilitiesAssignmentStrategy?.let { nonNull1 ->
		CalendarItem.AvailabilitiesAssignmentStrategy.valueOf(nonNull1)
	}
	val recurrenceId = undefinedToNull(obj.recurrenceId)
	val meetingTags = arrayToSet(
		obj.meetingTags,
		"obj.meetingTags",
		{ x1: DecryptedCalendarItemTagJs ->
			calendarItemTag_fromJs(x1)
		},
	)
	val secretForeignKeys = arrayToSet(
		obj.secretForeignKeys,
		"obj.secretForeignKeys",
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = objectToMap(
		obj.cryptedForeignKeys,
		"obj.cryptedForeignKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val delegations = objectToMap(
		obj.delegations,
		"obj.delegations",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptionKeys = objectToMap(
		obj.encryptionKeys,
		"obj.encryptionKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_fromJs(nonNull1)
	}
	return DecryptedCalendarItem(
		id = id,
		rev = rev,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		tags = tags,
		codes = codes,
		deletionDate = deletionDate,
		title = title,
		calendarItemTypeId = calendarItemTypeId,
		masterCalendarItemId = masterCalendarItemId,
		important = important,
		homeVisit = homeVisit,
		placeId = placeId,
		address = address,
		addressText = addressText,
		startTime = startTime,
		endTime = endTime,
		details = details,
		wasMigrated = wasMigrated,
		agendaId = agendaId,
		resourceGroup = resourceGroup,
		availabilitiesAssignmentStrategy = availabilitiesAssignmentStrategy,
		recurrenceId = recurrenceId,
		meetingTags = meetingTags,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun calendarItem_toJs(obj: EncryptedCalendarItem): EncryptedCalendarItemJs {
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
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val title = nullToUndefined(
		obj.title
	)
	val calendarItemTypeId = nullToUndefined(
		obj.calendarItemTypeId
	)
	val masterCalendarItemId = nullToUndefined(
		obj.masterCalendarItemId
	)
	val important = nullToUndefined(
		obj.important
	)
	val homeVisit = nullToUndefined(
		obj.homeVisit
	)
	val placeId = nullToUndefined(
		obj.placeId
	)
	val address = nullToUndefined(
		obj.address?.let { nonNull1 ->
			address_toJs(nonNull1)
		}
	)
	val addressText = nullToUndefined(
		obj.addressText
	)
	val startTime = nullToUndefined(
		longToNumber(obj.startTime)
	)
	val endTime = nullToUndefined(
		longToNumber(obj.endTime)
	)
	val details = nullToUndefined(
		obj.details
	)
	val wasMigrated = nullToUndefined(
		obj.wasMigrated
	)
	val agendaId = nullToUndefined(
		obj.agendaId
	)
	val resourceGroup = nullToUndefined(
		obj.resourceGroup?.let { nonNull1 ->
			codeStub_toJs(nonNull1)
		}
	)
	val availabilitiesAssignmentStrategy = nullToUndefined(
		obj.availabilitiesAssignmentStrategy?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val recurrenceId = nullToUndefined(
		obj.recurrenceId
	)
	val meetingTags = setToArray(
		obj.meetingTags,
		{ x1: EncryptedCalendarItemTag ->
			calendarItemTag_toJs(x1)
		},
	)
	val secretForeignKeys = setToArray(
		obj.secretForeignKeys,
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = mapToObject(
		obj.cryptedForeignKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val delegations = mapToObject(
		obj.delegations,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptionKeys = mapToObject(
		obj.encryptionKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	val securityMetadata = nullToUndefined(
		obj.securityMetadata?.let { nonNull1 ->
			securityMetadata_toJs(nonNull1)
		}
	)
	return EncryptedCalendarItemJs(js("{" +
		"id:id," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"tags:tags," +
		"codes:codes," +
		"deletionDate:deletionDate," +
		"title:title," +
		"calendarItemTypeId:calendarItemTypeId," +
		"masterCalendarItemId:masterCalendarItemId," +
		"important:important," +
		"homeVisit:homeVisit," +
		"placeId:placeId," +
		"address:address," +
		"addressText:addressText," +
		"startTime:startTime," +
		"endTime:endTime," +
		"details:details," +
		"wasMigrated:wasMigrated," +
		"agendaId:agendaId," +
		"resourceGroup:resourceGroup," +
		"availabilitiesAssignmentStrategy:availabilitiesAssignmentStrategy," +
		"recurrenceId:recurrenceId," +
		"meetingTags:meetingTags," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata" +
	"}"))
}

public fun calendarItem_fromJs(obj: EncryptedCalendarItemJs): EncryptedCalendarItem {
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
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val title = undefinedToNull(obj.title)
	val calendarItemTypeId = undefinedToNull(obj.calendarItemTypeId)
	val masterCalendarItemId = undefinedToNull(obj.masterCalendarItemId)
	val important = undefinedToNull(obj.important)
	val homeVisit = undefinedToNull(obj.homeVisit)
	val placeId = undefinedToNull(obj.placeId)
	val address = obj.address?.let { nonNull1 ->
		address_fromJs(nonNull1)
	}
	val addressText = undefinedToNull(obj.addressText)
	val startTime = numberToLong(obj.startTime, "obj.startTime")
	val endTime = numberToLong(obj.endTime, "obj.endTime")
	val details = undefinedToNull(obj.details)
	val wasMigrated = undefinedToNull(obj.wasMigrated)
	val agendaId = undefinedToNull(obj.agendaId)
	val resourceGroup = obj.resourceGroup?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val availabilitiesAssignmentStrategy = obj.availabilitiesAssignmentStrategy?.let { nonNull1 ->
		CalendarItem.AvailabilitiesAssignmentStrategy.valueOf(nonNull1)
	}
	val recurrenceId = undefinedToNull(obj.recurrenceId)
	val meetingTags = arrayToSet(
		obj.meetingTags,
		"obj.meetingTags",
		{ x1: EncryptedCalendarItemTagJs ->
			calendarItemTag_fromJs(x1)
		},
	)
	val secretForeignKeys = arrayToSet(
		obj.secretForeignKeys,
		"obj.secretForeignKeys",
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = objectToMap(
		obj.cryptedForeignKeys,
		"obj.cryptedForeignKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val delegations = objectToMap(
		obj.delegations,
		"obj.delegations",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptionKeys = objectToMap(
		obj.encryptionKeys,
		"obj.encryptionKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_fromJs(nonNull1)
	}
	return EncryptedCalendarItem(
		id = id,
		rev = rev,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		tags = tags,
		codes = codes,
		deletionDate = deletionDate,
		title = title,
		calendarItemTypeId = calendarItemTypeId,
		masterCalendarItemId = masterCalendarItemId,
		important = important,
		homeVisit = homeVisit,
		placeId = placeId,
		address = address,
		addressText = addressText,
		startTime = startTime,
		endTime = endTime,
		details = details,
		wasMigrated = wasMigrated,
		agendaId = agendaId,
		resourceGroup = resourceGroup,
		availabilitiesAssignmentStrategy = availabilitiesAssignmentStrategy,
		recurrenceId = recurrenceId,
		meetingTags = meetingTags,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun calendarItem_toJs(obj: CalendarItem): CalendarItemJs = when (obj) {
	is EncryptedCalendarItem -> calendarItem_toJs(obj)
	is DecryptedCalendarItem -> calendarItem_toJs(obj)
}

public fun calendarItem_fromJs(obj: CalendarItemJs): CalendarItem = if (obj.isEncrypted) {
	calendarItem_fromJs(obj as EncryptedCalendarItemJs)
} else {
	calendarItem_fromJs(obj as DecryptedCalendarItemJs)
}
