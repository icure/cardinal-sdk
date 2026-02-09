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
import com.icure.cardinal.sdk.model.embed.DecryptedSubContact
import com.icure.cardinal.sdk.model.embed.EncryptedSubContact
import com.icure.cardinal.sdk.model.embed.ServiceLink
import com.icure.cardinal.sdk.model.embed.SubContact
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun subContact_toJs(obj: DecryptedSubContact): DecryptedSubContactJs {
	val id = nullToUndefined(
		obj.id
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
	val descr = nullToUndefined(
		obj.descr
	)
	val protocol = nullToUndefined(
		obj.protocol
	)
	val formId = nullToUndefined(
		obj.formId
	)
	val planOfActionId = nullToUndefined(
		obj.planOfActionId
	)
	val healthElementId = nullToUndefined(
		obj.healthElementId
	)
	val services = listToArray(
		obj.services,
		{ x1: ServiceLink ->
			serviceLink_toJs(x1)
		},
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return DecryptedSubContactJs(js("{" +
		"id:id," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"tags:tags," +
		"codes:codes," +
		"descr:descr," +
		"protocol:protocol," +
		"formId:formId," +
		"planOfActionId:planOfActionId," +
		"healthElementId:healthElementId," +
		"services:services," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun subContact_fromJs(obj: DecryptedSubContactJs): DecryptedSubContact {
	val id = undefinedToNull(obj.id)
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
	val descr = undefinedToNull(obj.descr)
	val protocol = undefinedToNull(obj.protocol)
	val formId = undefinedToNull(obj.formId)
	val planOfActionId = undefinedToNull(obj.planOfActionId)
	val healthElementId = undefinedToNull(obj.healthElementId)
	val services = arrayToList(
		obj.services,
		"obj.services",
		{ x1: ServiceLinkJs ->
			serviceLink_fromJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedSubContact(
		id = id,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		tags = tags,
		codes = codes,
		descr = descr,
		protocol = protocol,
		formId = formId,
		planOfActionId = planOfActionId,
		healthElementId = healthElementId,
		services = services,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun subContact_toJs(obj: EncryptedSubContact): EncryptedSubContactJs {
	val id = nullToUndefined(
		obj.id
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
	val descr = nullToUndefined(
		obj.descr
	)
	val protocol = nullToUndefined(
		obj.protocol
	)
	val formId = nullToUndefined(
		obj.formId
	)
	val planOfActionId = nullToUndefined(
		obj.planOfActionId
	)
	val healthElementId = nullToUndefined(
		obj.healthElementId
	)
	val services = listToArray(
		obj.services,
		{ x1: ServiceLink ->
			serviceLink_toJs(x1)
		},
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return EncryptedSubContactJs(js("{" +
		"id:id," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"tags:tags," +
		"codes:codes," +
		"descr:descr," +
		"protocol:protocol," +
		"formId:formId," +
		"planOfActionId:planOfActionId," +
		"healthElementId:healthElementId," +
		"services:services," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun subContact_fromJs(obj: EncryptedSubContactJs): EncryptedSubContact {
	val id = undefinedToNull(obj.id)
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
	val descr = undefinedToNull(obj.descr)
	val protocol = undefinedToNull(obj.protocol)
	val formId = undefinedToNull(obj.formId)
	val planOfActionId = undefinedToNull(obj.planOfActionId)
	val healthElementId = undefinedToNull(obj.healthElementId)
	val services = arrayToList(
		obj.services,
		"obj.services",
		{ x1: ServiceLinkJs ->
			serviceLink_fromJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedSubContact(
		id = id,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		tags = tags,
		codes = codes,
		descr = descr,
		protocol = protocol,
		formId = formId,
		planOfActionId = planOfActionId,
		healthElementId = healthElementId,
		services = services,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun subContact_toJs(obj: SubContact): SubContactJs = when (obj) {
	is EncryptedSubContact -> subContact_toJs(obj)
	is DecryptedSubContact -> subContact_toJs(obj)
}

public fun subContact_fromJs(obj: SubContactJs): SubContact = if (obj.isEncrypted) {
	subContact_fromJs(obj as EncryptedSubContactJs)
} else {
	subContact_fromJs(obj as DecryptedSubContactJs)
}
