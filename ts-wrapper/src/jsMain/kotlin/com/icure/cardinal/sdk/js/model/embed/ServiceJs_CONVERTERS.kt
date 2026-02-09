// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.IdentifierJs
import com.icure.cardinal.sdk.js.model.base.codeStub_fromJs
import com.icure.cardinal.sdk.js.model.base.codeStub_toJs
import com.icure.cardinal.sdk.js.model.base.identifier_fromJs
import com.icure.cardinal.sdk.js.model.base.identifier_toJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.base.LinkQualification
import com.icure.cardinal.sdk.model.embed.Annotation
import com.icure.cardinal.sdk.model.embed.DecryptedContent
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.EncryptedContent
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.model.embed.Service
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Map
import kotlin.collections.Set

@Suppress("UNUSED_VARIABLE")
public fun service_toJs(obj: DecryptedService): DecryptedServiceJs {
	val id = obj.id
	val transactionId = nullToUndefined(
		obj.transactionId
	)
	val identifier = listToArray(
		obj.identifier,
		{ x1: Identifier ->
			identifier_toJs(x1)
		},
	)
	val subContactIds = nullToUndefined(
		setToArray(
			obj.subContactIds,
			{ x1: String ->
				x1
			},
		)
	)
	val plansOfActionIds = nullToUndefined(
		setToArray(
			obj.plansOfActionIds,
			{ x1: String ->
				x1
			},
		)
	)
	val healthElementsIds = nullToUndefined(
		setToArray(
			obj.healthElementsIds,
			{ x1: String ->
				x1
			},
		)
	)
	val formIds = nullToUndefined(
		setToArray(
			obj.formIds,
			{ x1: String ->
				x1
			},
		)
	)
	val secretForeignKeys = nullToUndefined(
		setToArray(
			obj.secretForeignKeys,
			{ x1: String ->
				x1
			},
		)
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
	val label = nullToUndefined(
		obj.label
	)
	val index = nullToUndefined(
		longToNumber(obj.index)
	)
	val content = mapToObject(
		obj.content,
		{ x1: String ->
			x1
		},
		{ x1: DecryptedContent ->
			content_toJs(x1)
		},
	)
	val textIndexes = mapToObject(
		obj.textIndexes,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
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
	val created = nullToUndefined(
		longToNumber(obj.created)
	)
	val modified = nullToUndefined(
		longToNumber(obj.modified)
	)
	val endOfLife = nullToUndefined(
		longToNumber(obj.endOfLife)
	)
	val author = nullToUndefined(
		obj.author
	)
	val responsible = nullToUndefined(
		obj.responsible
	)
	val comment = nullToUndefined(
		obj.comment
	)
	val invoicingCodes = setToArray(
		obj.invoicingCodes,
		{ x1: String ->
			x1
		},
	)
	val notes = listToArray(
		obj.notes,
		{ x1: Annotation ->
			annotation_toJs(x1)
		},
	)
	val qualifiedLinks = mapToObject(
		obj.qualifiedLinks,
		{ x1: LinkQualification ->
			x1.name
		},
		{ x1: Map<String, String> ->
			mapToObject(
				x1,
				{ x2: String ->
					x2
				},
				{ x2: String ->
					x2
				},
			)
		},
	)
	val codes = setToArray(
		obj.codes,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
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
	return DecryptedServiceJs(js("{" +
		"id:id," +
		"transactionId:transactionId," +
		"identifier:identifier," +
		"subContactIds:subContactIds," +
		"plansOfActionIds:plansOfActionIds," +
		"healthElementsIds:healthElementsIds," +
		"formIds:formIds," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"label:label," +
		"index:index," +
		"content:content," +
		"textIndexes:textIndexes," +
		"valueDate:valueDate," +
		"openingDate:openingDate," +
		"closingDate:closingDate," +
		"created:created," +
		"modified:modified," +
		"endOfLife:endOfLife," +
		"author:author," +
		"responsible:responsible," +
		"comment:comment," +
		"invoicingCodes:invoicingCodes," +
		"notes:notes," +
		"qualifiedLinks:qualifiedLinks," +
		"codes:codes," +
		"tags:tags," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata" +
	"}"))
}

public fun service_fromJs(obj: DecryptedServiceJs): DecryptedService {
	val id = obj.id
	val transactionId = undefinedToNull(obj.transactionId)
	val identifier = arrayToList(
		obj.identifier,
		"obj.identifier",
		{ x1: IdentifierJs ->
			identifier_fromJs(x1)
		},
	)
	val subContactIds = arrayToSet(
		obj.subContactIds,
		"obj.subContactIds",
		{ x1: String ->
			x1
		},
	)
	val plansOfActionIds = arrayToSet(
		obj.plansOfActionIds,
		"obj.plansOfActionIds",
		{ x1: String ->
			x1
		},
	)
	val healthElementsIds = arrayToSet(
		obj.healthElementsIds,
		"obj.healthElementsIds",
		{ x1: String ->
			x1
		},
	)
	val formIds = arrayToSet(
		obj.formIds,
		"obj.formIds",
		{ x1: String ->
			x1
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
	val label = undefinedToNull(obj.label)
	val index = numberToLong(obj.index, "obj.index")
	val content = objectToMap(
		obj.content,
		"obj.content",
		{ x1: String ->
			x1
		},
		{ x1: DecryptedContentJs ->
			content_fromJs(x1)
		},
	)
	val textIndexes = objectToMap(
		obj.textIndexes,
		"obj.textIndexes",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val valueDate = numberToLong(obj.valueDate, "obj.valueDate")
	val openingDate = numberToLong(obj.openingDate, "obj.openingDate")
	val closingDate = numberToLong(obj.closingDate, "obj.closingDate")
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val endOfLife = numberToLong(obj.endOfLife, "obj.endOfLife")
	val author = undefinedToNull(obj.author)
	val responsible = undefinedToNull(obj.responsible)
	val comment = undefinedToNull(obj.comment)
	val invoicingCodes = arrayToSet(
		obj.invoicingCodes,
		"obj.invoicingCodes",
		{ x1: String ->
			x1
		},
	)
	val notes = arrayToList(
		obj.notes,
		"obj.notes",
		{ x1: AnnotationJs ->
			annotation_fromJs(x1)
		},
	)
	val qualifiedLinks = objectToMap(
		obj.qualifiedLinks,
		"obj.qualifiedLinks",
		{ x1: String ->
			LinkQualification.valueOf(x1)
		},
		{ x1: Record<String, String> ->
			objectToMap(
				x1,
				"x1",
				{ x2: String ->
					x2
				},
				{ x2: String ->
					x2
				},
			)
		},
	)
	val codes = arrayToSet(
		obj.codes,
		"obj.codes",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_fromJs(nonNull1)
	}
	return DecryptedService(
		id = id,
		transactionId = transactionId,
		identifier = identifier,
		subContactIds = subContactIds,
		plansOfActionIds = plansOfActionIds,
		healthElementsIds = healthElementsIds,
		formIds = formIds,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		label = label,
		index = index,
		content = content,
		textIndexes = textIndexes,
		valueDate = valueDate,
		openingDate = openingDate,
		closingDate = closingDate,
		created = created,
		modified = modified,
		endOfLife = endOfLife,
		author = author,
		responsible = responsible,
		comment = comment,
		invoicingCodes = invoicingCodes,
		notes = notes,
		qualifiedLinks = qualifiedLinks,
		codes = codes,
		tags = tags,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun service_toJs(obj: EncryptedService): EncryptedServiceJs {
	val id = obj.id
	val transactionId = nullToUndefined(
		obj.transactionId
	)
	val identifier = listToArray(
		obj.identifier,
		{ x1: Identifier ->
			identifier_toJs(x1)
		},
	)
	val subContactIds = nullToUndefined(
		setToArray(
			obj.subContactIds,
			{ x1: String ->
				x1
			},
		)
	)
	val plansOfActionIds = nullToUndefined(
		setToArray(
			obj.plansOfActionIds,
			{ x1: String ->
				x1
			},
		)
	)
	val healthElementsIds = nullToUndefined(
		setToArray(
			obj.healthElementsIds,
			{ x1: String ->
				x1
			},
		)
	)
	val formIds = nullToUndefined(
		setToArray(
			obj.formIds,
			{ x1: String ->
				x1
			},
		)
	)
	val secretForeignKeys = nullToUndefined(
		setToArray(
			obj.secretForeignKeys,
			{ x1: String ->
				x1
			},
		)
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
	val label = nullToUndefined(
		obj.label
	)
	val index = nullToUndefined(
		longToNumber(obj.index)
	)
	val content = mapToObject(
		obj.content,
		{ x1: String ->
			x1
		},
		{ x1: EncryptedContent ->
			content_toJs(x1)
		},
	)
	val textIndexes = mapToObject(
		obj.textIndexes,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
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
	val created = nullToUndefined(
		longToNumber(obj.created)
	)
	val modified = nullToUndefined(
		longToNumber(obj.modified)
	)
	val endOfLife = nullToUndefined(
		longToNumber(obj.endOfLife)
	)
	val author = nullToUndefined(
		obj.author
	)
	val responsible = nullToUndefined(
		obj.responsible
	)
	val comment = nullToUndefined(
		obj.comment
	)
	val invoicingCodes = setToArray(
		obj.invoicingCodes,
		{ x1: String ->
			x1
		},
	)
	val notes = listToArray(
		obj.notes,
		{ x1: Annotation ->
			annotation_toJs(x1)
		},
	)
	val qualifiedLinks = mapToObject(
		obj.qualifiedLinks,
		{ x1: LinkQualification ->
			x1.name
		},
		{ x1: Map<String, String> ->
			mapToObject(
				x1,
				{ x2: String ->
					x2
				},
				{ x2: String ->
					x2
				},
			)
		},
	)
	val codes = setToArray(
		obj.codes,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
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
	return EncryptedServiceJs(js("{" +
		"id:id," +
		"transactionId:transactionId," +
		"identifier:identifier," +
		"subContactIds:subContactIds," +
		"plansOfActionIds:plansOfActionIds," +
		"healthElementsIds:healthElementsIds," +
		"formIds:formIds," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"label:label," +
		"index:index," +
		"content:content," +
		"textIndexes:textIndexes," +
		"valueDate:valueDate," +
		"openingDate:openingDate," +
		"closingDate:closingDate," +
		"created:created," +
		"modified:modified," +
		"endOfLife:endOfLife," +
		"author:author," +
		"responsible:responsible," +
		"comment:comment," +
		"invoicingCodes:invoicingCodes," +
		"notes:notes," +
		"qualifiedLinks:qualifiedLinks," +
		"codes:codes," +
		"tags:tags," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata" +
	"}"))
}

public fun service_fromJs(obj: EncryptedServiceJs): EncryptedService {
	val id = obj.id
	val transactionId = undefinedToNull(obj.transactionId)
	val identifier = arrayToList(
		obj.identifier,
		"obj.identifier",
		{ x1: IdentifierJs ->
			identifier_fromJs(x1)
		},
	)
	val subContactIds = arrayToSet(
		obj.subContactIds,
		"obj.subContactIds",
		{ x1: String ->
			x1
		},
	)
	val plansOfActionIds = arrayToSet(
		obj.plansOfActionIds,
		"obj.plansOfActionIds",
		{ x1: String ->
			x1
		},
	)
	val healthElementsIds = arrayToSet(
		obj.healthElementsIds,
		"obj.healthElementsIds",
		{ x1: String ->
			x1
		},
	)
	val formIds = arrayToSet(
		obj.formIds,
		"obj.formIds",
		{ x1: String ->
			x1
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
	val label = undefinedToNull(obj.label)
	val index = numberToLong(obj.index, "obj.index")
	val content = objectToMap(
		obj.content,
		"obj.content",
		{ x1: String ->
			x1
		},
		{ x1: EncryptedContentJs ->
			content_fromJs(x1)
		},
	)
	val textIndexes = objectToMap(
		obj.textIndexes,
		"obj.textIndexes",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val valueDate = numberToLong(obj.valueDate, "obj.valueDate")
	val openingDate = numberToLong(obj.openingDate, "obj.openingDate")
	val closingDate = numberToLong(obj.closingDate, "obj.closingDate")
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val endOfLife = numberToLong(obj.endOfLife, "obj.endOfLife")
	val author = undefinedToNull(obj.author)
	val responsible = undefinedToNull(obj.responsible)
	val comment = undefinedToNull(obj.comment)
	val invoicingCodes = arrayToSet(
		obj.invoicingCodes,
		"obj.invoicingCodes",
		{ x1: String ->
			x1
		},
	)
	val notes = arrayToList(
		obj.notes,
		"obj.notes",
		{ x1: AnnotationJs ->
			annotation_fromJs(x1)
		},
	)
	val qualifiedLinks = objectToMap(
		obj.qualifiedLinks,
		"obj.qualifiedLinks",
		{ x1: String ->
			LinkQualification.valueOf(x1)
		},
		{ x1: Record<String, String> ->
			objectToMap(
				x1,
				"x1",
				{ x2: String ->
					x2
				},
				{ x2: String ->
					x2
				},
			)
		},
	)
	val codes = arrayToSet(
		obj.codes,
		"obj.codes",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_fromJs(nonNull1)
	}
	return EncryptedService(
		id = id,
		transactionId = transactionId,
		identifier = identifier,
		subContactIds = subContactIds,
		plansOfActionIds = plansOfActionIds,
		healthElementsIds = healthElementsIds,
		formIds = formIds,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		label = label,
		index = index,
		content = content,
		textIndexes = textIndexes,
		valueDate = valueDate,
		openingDate = openingDate,
		closingDate = closingDate,
		created = created,
		modified = modified,
		endOfLife = endOfLife,
		author = author,
		responsible = responsible,
		comment = comment,
		invoicingCodes = invoicingCodes,
		notes = notes,
		qualifiedLinks = qualifiedLinks,
		codes = codes,
		tags = tags,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun service_toJs(obj: Service): ServiceJs = when (obj) {
	is EncryptedService -> service_toJs(obj)
	is DecryptedService -> service_toJs(obj)
}

public fun service_fromJs(obj: ServiceJs): Service = if (obj.isEncrypted) {
	service_fromJs(obj as EncryptedServiceJs)
} else {
	service_fromJs(obj as DecryptedServiceJs)
}
