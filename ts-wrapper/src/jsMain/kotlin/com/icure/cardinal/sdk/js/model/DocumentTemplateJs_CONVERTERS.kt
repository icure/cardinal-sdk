// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.codeStub_fromJs
import com.icure.cardinal.sdk.js.model.base.codeStub_toJs
import com.icure.cardinal.sdk.js.model.embed.documentGroup_fromJs
import com.icure.cardinal.sdk.js.model.embed.documentGroup_toJs
import com.icure.cardinal.sdk.model.DocumentTemplate
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.ReportVersion
import com.icure.cardinal.sdk.model.embed.DocumentType
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun documentTemplate_toJs(obj: DocumentTemplate): DocumentTemplateJs {
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
	val attachment = nullToUndefined(
		obj.attachment
	)
	val documentType = nullToUndefined(
		obj.documentType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val mainUti = nullToUndefined(
		obj.mainUti
	)
	val name = nullToUndefined(
		obj.name
	)
	val otherUtis = setToArray(
		obj.otherUtis,
		{ x1: String ->
			x1
		},
	)
	val attachmentId = nullToUndefined(
		obj.attachmentId
	)
	val version = nullToUndefined(
		obj.version?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val owner = nullToUndefined(
		obj.owner
	)
	val guid = nullToUndefined(
		obj.guid
	)
	val group = nullToUndefined(
		obj.group?.let { nonNull1 ->
			documentGroup_toJs(nonNull1)
		}
	)
	val descr = nullToUndefined(
		obj.descr
	)
	val disabled = nullToUndefined(
		obj.disabled
	)
	val specialty = nullToUndefined(
		obj.specialty?.let { nonNull1 ->
			codeStub_toJs(nonNull1)
		}
	)
	return DocumentTemplateJs(js("{" +
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
		"attachment:attachment," +
		"documentType:documentType," +
		"mainUti:mainUti," +
		"name:name," +
		"otherUtis:otherUtis," +
		"attachmentId:attachmentId," +
		"version:version," +
		"owner:owner," +
		"guid:guid," +
		"group:group," +
		"descr:descr," +
		"disabled:disabled," +
		"specialty:specialty" +
	"}"))
}

public fun documentTemplate_fromJs(obj: DocumentTemplateJs): DocumentTemplate {
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
	val attachment = undefinedToNull(obj.attachment)
	val documentType = obj.documentType?.let { nonNull1 ->
		DocumentType.valueOf(nonNull1)
	}
	val mainUti = undefinedToNull(obj.mainUti)
	val name = undefinedToNull(obj.name)
	val otherUtis = arrayToSet(
		obj.otherUtis,
		"obj.otherUtis",
		{ x1: String ->
			x1
		},
	)
	val attachmentId = undefinedToNull(obj.attachmentId)
	val version = obj.version?.let { nonNull1 ->
		ReportVersion.valueOf(nonNull1)
	}
	val owner = undefinedToNull(obj.owner)
	val guid = undefinedToNull(obj.guid)
	val group = obj.group?.let { nonNull1 ->
		documentGroup_fromJs(nonNull1)
	}
	val descr = undefinedToNull(obj.descr)
	val disabled = undefinedToNull(obj.disabled)
	val specialty = obj.specialty?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	return DocumentTemplate(
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
		attachment = attachment,
		documentType = documentType,
		mainUti = mainUti,
		name = name,
		otherUtis = otherUtis,
		attachmentId = attachmentId,
		version = version,
		owner = owner,
		guid = guid,
		group = group,
		descr = descr,
		disabled = disabled,
		specialty = specialty,
	)
}
