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
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMembership
import com.icure.cardinal.sdk.model.embed.DecryptedPlanOfAction
import com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMembership
import com.icure.cardinal.sdk.model.embed.EncryptedPlanOfAction
import com.icure.cardinal.sdk.model.embed.PlanOfAction
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun planOfAction_toJs(obj: DecryptedPlanOfAction): DecryptedPlanOfActionJs {
	val id = obj.id
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
	val prescriberId = nullToUndefined(
		obj.prescriberId
	)
	val valueDate = nullToUndefined(
		longToNumber(obj.valueDate)
	)
	val openingDate = nullToUndefined(
		longToNumber(obj.openingDate)
	)
	val closingDate = nullToUndefined(
		longToNumber(obj.closingDate)
	)
	val deadlineDate = nullToUndefined(
		longToNumber(obj.deadlineDate)
	)
	val name = nullToUndefined(
		obj.name
	)
	val descr = nullToUndefined(
		obj.descr
	)
	val note = nullToUndefined(
		obj.note
	)
	val idOpeningContact = nullToUndefined(
		obj.idOpeningContact
	)
	val idClosingContact = nullToUndefined(
		obj.idClosingContact
	)
	val careTeamMemberships = listToArray(
		obj.careTeamMemberships,
		{ x1: DecryptedCareTeamMembership ->
			careTeamMembership_toJs(x1)
		},
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return DecryptedPlanOfActionJs(js("{" +
		"id:id," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"tags:tags," +
		"codes:codes," +
		"endOfLife:endOfLife," +
		"prescriberId:prescriberId," +
		"valueDate:valueDate," +
		"openingDate:openingDate," +
		"closingDate:closingDate," +
		"deadlineDate:deadlineDate," +
		"name:name," +
		"descr:descr," +
		"note:note," +
		"idOpeningContact:idOpeningContact," +
		"idClosingContact:idClosingContact," +
		"careTeamMemberships:careTeamMemberships," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun planOfAction_fromJs(obj: DecryptedPlanOfActionJs): DecryptedPlanOfAction {
	val id = obj.id
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
	val prescriberId = undefinedToNull(obj.prescriberId)
	val valueDate = numberToLong(obj.valueDate, "obj.valueDate")
	val openingDate = numberToLong(obj.openingDate, "obj.openingDate")
	val closingDate = numberToLong(obj.closingDate, "obj.closingDate")
	val deadlineDate = numberToLong(obj.deadlineDate, "obj.deadlineDate")
	val name = undefinedToNull(obj.name)
	val descr = undefinedToNull(obj.descr)
	val note = undefinedToNull(obj.note)
	val idOpeningContact = undefinedToNull(obj.idOpeningContact)
	val idClosingContact = undefinedToNull(obj.idClosingContact)
	val careTeamMemberships = arrayToList(
		obj.careTeamMemberships,
		"obj.careTeamMemberships",
		{ x1: DecryptedCareTeamMembershipJs ->
			careTeamMembership_fromJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedPlanOfAction(
		id = id,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		tags = tags,
		codes = codes,
		endOfLife = endOfLife,
		prescriberId = prescriberId,
		valueDate = valueDate,
		openingDate = openingDate,
		closingDate = closingDate,
		deadlineDate = deadlineDate,
		name = name,
		descr = descr,
		note = note,
		idOpeningContact = idOpeningContact,
		idClosingContact = idClosingContact,
		careTeamMemberships = careTeamMemberships,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun planOfAction_toJs(obj: EncryptedPlanOfAction): EncryptedPlanOfActionJs {
	val id = obj.id
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
	val prescriberId = nullToUndefined(
		obj.prescriberId
	)
	val valueDate = nullToUndefined(
		longToNumber(obj.valueDate)
	)
	val openingDate = nullToUndefined(
		longToNumber(obj.openingDate)
	)
	val closingDate = nullToUndefined(
		longToNumber(obj.closingDate)
	)
	val deadlineDate = nullToUndefined(
		longToNumber(obj.deadlineDate)
	)
	val name = nullToUndefined(
		obj.name
	)
	val descr = nullToUndefined(
		obj.descr
	)
	val note = nullToUndefined(
		obj.note
	)
	val idOpeningContact = nullToUndefined(
		obj.idOpeningContact
	)
	val idClosingContact = nullToUndefined(
		obj.idClosingContact
	)
	val careTeamMemberships = listToArray(
		obj.careTeamMemberships,
		{ x1: EncryptedCareTeamMembership ->
			careTeamMembership_toJs(x1)
		},
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return EncryptedPlanOfActionJs(js("{" +
		"id:id," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"tags:tags," +
		"codes:codes," +
		"endOfLife:endOfLife," +
		"prescriberId:prescriberId," +
		"valueDate:valueDate," +
		"openingDate:openingDate," +
		"closingDate:closingDate," +
		"deadlineDate:deadlineDate," +
		"name:name," +
		"descr:descr," +
		"note:note," +
		"idOpeningContact:idOpeningContact," +
		"idClosingContact:idClosingContact," +
		"careTeamMemberships:careTeamMemberships," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun planOfAction_fromJs(obj: EncryptedPlanOfActionJs): EncryptedPlanOfAction {
	val id = obj.id
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
	val prescriberId = undefinedToNull(obj.prescriberId)
	val valueDate = numberToLong(obj.valueDate, "obj.valueDate")
	val openingDate = numberToLong(obj.openingDate, "obj.openingDate")
	val closingDate = numberToLong(obj.closingDate, "obj.closingDate")
	val deadlineDate = numberToLong(obj.deadlineDate, "obj.deadlineDate")
	val name = undefinedToNull(obj.name)
	val descr = undefinedToNull(obj.descr)
	val note = undefinedToNull(obj.note)
	val idOpeningContact = undefinedToNull(obj.idOpeningContact)
	val idClosingContact = undefinedToNull(obj.idClosingContact)
	val careTeamMemberships = arrayToList(
		obj.careTeamMemberships,
		"obj.careTeamMemberships",
		{ x1: EncryptedCareTeamMembershipJs ->
			careTeamMembership_fromJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedPlanOfAction(
		id = id,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		tags = tags,
		codes = codes,
		endOfLife = endOfLife,
		prescriberId = prescriberId,
		valueDate = valueDate,
		openingDate = openingDate,
		closingDate = closingDate,
		deadlineDate = deadlineDate,
		name = name,
		descr = descr,
		note = note,
		idOpeningContact = idOpeningContact,
		idClosingContact = idClosingContact,
		careTeamMemberships = careTeamMemberships,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun planOfAction_toJs(obj: PlanOfAction): PlanOfActionJs = when (obj) {
	is EncryptedPlanOfAction -> planOfAction_toJs(obj)
	is DecryptedPlanOfAction -> planOfAction_toJs(obj)
}

public fun planOfAction_fromJs(obj: PlanOfActionJs): PlanOfAction = if (obj.isEncrypted) {
	planOfAction_fromJs(obj as EncryptedPlanOfActionJs)
} else {
	planOfAction_fromJs(obj as DecryptedPlanOfActionJs)
}
