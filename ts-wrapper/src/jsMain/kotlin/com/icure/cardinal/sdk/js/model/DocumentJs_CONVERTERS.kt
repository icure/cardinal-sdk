// auto-generated file
package com.icure.cardinal.sdk.js.model

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
import com.icure.cardinal.sdk.js.model.base.codeStub_fromJs
import com.icure.cardinal.sdk.js.model.base.codeStub_toJs
import com.icure.cardinal.sdk.js.model.embed.DataAttachmentJs
import com.icure.cardinal.sdk.js.model.embed.DelegationJs
import com.icure.cardinal.sdk.js.model.embed.DeletedAttachmentJs
import com.icure.cardinal.sdk.js.model.embed.dataAttachment_fromJs
import com.icure.cardinal.sdk.js.model.embed.dataAttachment_toJs
import com.icure.cardinal.sdk.js.model.embed.delegation_fromJs
import com.icure.cardinal.sdk.js.model.embed.delegation_toJs
import com.icure.cardinal.sdk.js.model.embed.deletedAttachment_fromJs
import com.icure.cardinal.sdk.js.model.embed.deletedAttachment_toJs
import com.icure.cardinal.sdk.js.model.embed.securityMetadata_fromJs
import com.icure.cardinal.sdk.js.model.embed.securityMetadata_toJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.EncryptedDocument
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.embed.DataAttachment
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.DeletedAttachment
import com.icure.cardinal.sdk.model.embed.DocumentStatus
import com.icure.cardinal.sdk.model.embed.DocumentType
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Set

@Suppress("UNUSED_VARIABLE")
public fun document_toJs(obj: DecryptedDocument): DecryptedDocumentJs {
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
	val documentType = nullToUndefined(
		obj.documentType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val documentStatus = nullToUndefined(
		obj.documentStatus?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val externalUri = nullToUndefined(
		obj.externalUri
	)
	val name = nullToUndefined(
		obj.name
	)
	val version = nullToUndefined(
		obj.version
	)
	val size = nullToUndefined(
		longToNumber(obj.size)
	)
	val hash = nullToUndefined(
		obj.hash
	)
	val openingContactId = nullToUndefined(
		obj.openingContactId
	)
	val attachmentId = nullToUndefined(
		obj.attachmentId
	)
	val objectStoreReference = nullToUndefined(
		obj.objectStoreReference
	)
	val mainUti = nullToUndefined(
		obj.mainUti
	)
	val otherUtis = setToArray(
		obj.otherUtis,
		{ x1: String ->
			x1
		},
	)
	val secondaryAttachments = mapToObject(
		obj.secondaryAttachments,
		{ x1: String ->
			x1
		},
		{ x1: DataAttachment ->
			dataAttachment_toJs(x1)
		},
	)
	val deletedAttachments = listToArray(
		obj.deletedAttachments,
		{ x1: DeletedAttachment ->
			deletedAttachment_toJs(x1)
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
	return DecryptedDocumentJs(js("{" +
		"id:id," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"tags:tags," +
		"codes:codes," +
		"deletionDate:deletionDate," +
		"documentType:documentType," +
		"documentStatus:documentStatus," +
		"externalUri:externalUri," +
		"name:name," +
		"version:version," +
		"size:size," +
		"hash:hash," +
		"openingContactId:openingContactId," +
		"attachmentId:attachmentId," +
		"objectStoreReference:objectStoreReference," +
		"mainUti:mainUti," +
		"otherUtis:otherUtis," +
		"secondaryAttachments:secondaryAttachments," +
		"deletedAttachments:deletedAttachments," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata" +
	"}"))
}

public fun document_fromJs(obj: DecryptedDocumentJs): DecryptedDocument {
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
	val documentType = obj.documentType?.let { nonNull1 ->
		DocumentType.valueOf(nonNull1)
	}
	val documentStatus = obj.documentStatus?.let { nonNull1 ->
		DocumentStatus.valueOf(nonNull1)
	}
	val externalUri = undefinedToNull(obj.externalUri)
	val name = undefinedToNull(obj.name)
	val version = undefinedToNull(obj.version)
	val size = numberToLong(obj.size, "obj.size")
	val hash = undefinedToNull(obj.hash)
	val openingContactId = undefinedToNull(obj.openingContactId)
	val attachmentId = undefinedToNull(obj.attachmentId)
	val objectStoreReference = undefinedToNull(obj.objectStoreReference)
	val mainUti = undefinedToNull(obj.mainUti)
	val otherUtis = arrayToSet(
		obj.otherUtis,
		"obj.otherUtis",
		{ x1: String ->
			x1
		},
	)
	val secondaryAttachments = objectToMap(
		obj.secondaryAttachments,
		"obj.secondaryAttachments",
		{ x1: String ->
			x1
		},
		{ x1: DataAttachmentJs ->
			dataAttachment_fromJs(x1)
		},
	)
	val deletedAttachments = arrayToList(
		obj.deletedAttachments,
		"obj.deletedAttachments",
		{ x1: DeletedAttachmentJs ->
			deletedAttachment_fromJs(x1)
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
	return DecryptedDocument(
		id = id,
		rev = rev,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		tags = tags,
		codes = codes,
		deletionDate = deletionDate,
		documentType = documentType,
		documentStatus = documentStatus,
		externalUri = externalUri,
		name = name,
		version = version,
		size = size,
		hash = hash,
		openingContactId = openingContactId,
		attachmentId = attachmentId,
		objectStoreReference = objectStoreReference,
		mainUti = mainUti,
		otherUtis = otherUtis,
		secondaryAttachments = secondaryAttachments,
		deletedAttachments = deletedAttachments,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun document_toJs(obj: EncryptedDocument): EncryptedDocumentJs {
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
	val documentType = nullToUndefined(
		obj.documentType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val documentStatus = nullToUndefined(
		obj.documentStatus?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val externalUri = nullToUndefined(
		obj.externalUri
	)
	val name = nullToUndefined(
		obj.name
	)
	val version = nullToUndefined(
		obj.version
	)
	val size = nullToUndefined(
		longToNumber(obj.size)
	)
	val hash = nullToUndefined(
		obj.hash
	)
	val openingContactId = nullToUndefined(
		obj.openingContactId
	)
	val attachmentId = nullToUndefined(
		obj.attachmentId
	)
	val objectStoreReference = nullToUndefined(
		obj.objectStoreReference
	)
	val mainUti = nullToUndefined(
		obj.mainUti
	)
	val otherUtis = setToArray(
		obj.otherUtis,
		{ x1: String ->
			x1
		},
	)
	val secondaryAttachments = mapToObject(
		obj.secondaryAttachments,
		{ x1: String ->
			x1
		},
		{ x1: DataAttachment ->
			dataAttachment_toJs(x1)
		},
	)
	val deletedAttachments = listToArray(
		obj.deletedAttachments,
		{ x1: DeletedAttachment ->
			deletedAttachment_toJs(x1)
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
	return EncryptedDocumentJs(js("{" +
		"id:id," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"tags:tags," +
		"codes:codes," +
		"deletionDate:deletionDate," +
		"documentType:documentType," +
		"documentStatus:documentStatus," +
		"externalUri:externalUri," +
		"name:name," +
		"version:version," +
		"size:size," +
		"hash:hash," +
		"openingContactId:openingContactId," +
		"attachmentId:attachmentId," +
		"objectStoreReference:objectStoreReference," +
		"mainUti:mainUti," +
		"otherUtis:otherUtis," +
		"secondaryAttachments:secondaryAttachments," +
		"deletedAttachments:deletedAttachments," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata" +
	"}"))
}

public fun document_fromJs(obj: EncryptedDocumentJs): EncryptedDocument {
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
	val documentType = obj.documentType?.let { nonNull1 ->
		DocumentType.valueOf(nonNull1)
	}
	val documentStatus = obj.documentStatus?.let { nonNull1 ->
		DocumentStatus.valueOf(nonNull1)
	}
	val externalUri = undefinedToNull(obj.externalUri)
	val name = undefinedToNull(obj.name)
	val version = undefinedToNull(obj.version)
	val size = numberToLong(obj.size, "obj.size")
	val hash = undefinedToNull(obj.hash)
	val openingContactId = undefinedToNull(obj.openingContactId)
	val attachmentId = undefinedToNull(obj.attachmentId)
	val objectStoreReference = undefinedToNull(obj.objectStoreReference)
	val mainUti = undefinedToNull(obj.mainUti)
	val otherUtis = arrayToSet(
		obj.otherUtis,
		"obj.otherUtis",
		{ x1: String ->
			x1
		},
	)
	val secondaryAttachments = objectToMap(
		obj.secondaryAttachments,
		"obj.secondaryAttachments",
		{ x1: String ->
			x1
		},
		{ x1: DataAttachmentJs ->
			dataAttachment_fromJs(x1)
		},
	)
	val deletedAttachments = arrayToList(
		obj.deletedAttachments,
		"obj.deletedAttachments",
		{ x1: DeletedAttachmentJs ->
			deletedAttachment_fromJs(x1)
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
	return EncryptedDocument(
		id = id,
		rev = rev,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		tags = tags,
		codes = codes,
		deletionDate = deletionDate,
		documentType = documentType,
		documentStatus = documentStatus,
		externalUri = externalUri,
		name = name,
		version = version,
		size = size,
		hash = hash,
		openingContactId = openingContactId,
		attachmentId = attachmentId,
		objectStoreReference = objectStoreReference,
		mainUti = mainUti,
		otherUtis = otherUtis,
		secondaryAttachments = secondaryAttachments,
		deletedAttachments = deletedAttachments,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun document_toJs(obj: Document): DocumentJs = when (obj) {
	is EncryptedDocument -> document_toJs(obj)
	is DecryptedDocument -> document_toJs(obj)
}

public fun document_fromJs(obj: DocumentJs): Document = if (obj.isEncrypted) {
	document_fromJs(obj as EncryptedDocumentJs)
} else {
	document_fromJs(obj as DecryptedDocumentJs)
}
