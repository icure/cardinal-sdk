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
import com.icure.cardinal.sdk.js.model.embed.DelegationJs
import com.icure.cardinal.sdk.js.model.embed.MessageReadStatusJs
import com.icure.cardinal.sdk.js.model.embed.delegation_fromJs
import com.icure.cardinal.sdk.js.model.embed.delegation_toJs
import com.icure.cardinal.sdk.js.model.embed.messageReadStatus_fromJs
import com.icure.cardinal.sdk.js.model.embed.messageReadStatus_toJs
import com.icure.cardinal.sdk.js.model.embed.securityMetadata_fromJs
import com.icure.cardinal.sdk.js.model.embed.securityMetadata_toJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.DecryptedMessage
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.EncryptedMessage
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.MessageReadStatus
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Set

@Suppress("UNUSED_VARIABLE")
public fun message_toJs(obj: DecryptedMessage): DecryptedMessageJs {
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
	val fromAddress = nullToUndefined(
		obj.fromAddress
	)
	val fromHealthcarePartyId = nullToUndefined(
		obj.fromHealthcarePartyId
	)
	val recipients = setToArray(
		obj.recipients,
		{ x1: String ->
			x1
		},
	)
	val toAddresses = setToArray(
		obj.toAddresses,
		{ x1: String ->
			x1
		},
	)
	val received = nullToUndefined(
		longToNumber(obj.received)
	)
	val sent = nullToUndefined(
		longToNumber(obj.sent)
	)
	val metas = mapToObject(
		obj.metas,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val readStatus = mapToObject(
		obj.readStatus,
		{ x1: String ->
			x1
		},
		{ x1: MessageReadStatus ->
			messageReadStatus_toJs(x1)
		},
	)
	val transportGuid = nullToUndefined(
		obj.transportGuid
	)
	val remark = nullToUndefined(
		obj.remark
	)
	val conversationGuid = nullToUndefined(
		obj.conversationGuid
	)
	val subject = nullToUndefined(
		obj.subject
	)
	val invoiceIds = setToArray(
		obj.invoiceIds,
		{ x1: String ->
			x1
		},
	)
	val parentId = nullToUndefined(
		obj.parentId
	)
	val properties = setToArray(
		obj.properties,
		{ x1: DecryptedPropertyStub ->
			propertyStub_toJs(x1)
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
	return DecryptedMessageJs(js("{" +
		"id:id," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"tags:tags," +
		"codes:codes," +
		"deletionDate:deletionDate," +
		"fromAddress:fromAddress," +
		"fromHealthcarePartyId:fromHealthcarePartyId," +
		"recipients:recipients," +
		"toAddresses:toAddresses," +
		"received:received," +
		"sent:sent," +
		"metas:metas," +
		"readStatus:readStatus," +
		"transportGuid:transportGuid," +
		"remark:remark," +
		"conversationGuid:conversationGuid," +
		"subject:subject," +
		"invoiceIds:invoiceIds," +
		"parentId:parentId," +
		"properties:properties," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata" +
	"}"))
}

public fun message_fromJs(obj: DecryptedMessageJs): DecryptedMessage {
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
	val fromAddress = undefinedToNull(obj.fromAddress)
	val fromHealthcarePartyId = undefinedToNull(obj.fromHealthcarePartyId)
	val recipients = arrayToSet(
		obj.recipients,
		"obj.recipients",
		{ x1: String ->
			x1
		},
	)
	val toAddresses = arrayToSet(
		obj.toAddresses,
		"obj.toAddresses",
		{ x1: String ->
			x1
		},
	)
	val received = numberToLong(obj.received, "obj.received")
	val sent = numberToLong(obj.sent, "obj.sent")
	val metas = objectToMap(
		obj.metas,
		"obj.metas",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val readStatus = objectToMap(
		obj.readStatus,
		"obj.readStatus",
		{ x1: String ->
			x1
		},
		{ x1: MessageReadStatusJs ->
			messageReadStatus_fromJs(x1)
		},
	)
	val transportGuid = undefinedToNull(obj.transportGuid)
	val remark = undefinedToNull(obj.remark)
	val conversationGuid = undefinedToNull(obj.conversationGuid)
	val subject = undefinedToNull(obj.subject)
	val invoiceIds = arrayToSet(
		obj.invoiceIds,
		"obj.invoiceIds",
		{ x1: String ->
			x1
		},
	)
	val parentId = undefinedToNull(obj.parentId)
	val properties = arrayToSet(
		obj.properties,
		"obj.properties",
		{ x1: DecryptedPropertyStubJs ->
			propertyStub_fromJs(x1)
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
	return DecryptedMessage(
		id = id,
		rev = rev,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		tags = tags,
		codes = codes,
		deletionDate = deletionDate,
		fromAddress = fromAddress,
		fromHealthcarePartyId = fromHealthcarePartyId,
		recipients = recipients,
		toAddresses = toAddresses,
		received = received,
		sent = sent,
		metas = metas,
		readStatus = readStatus,
		transportGuid = transportGuid,
		remark = remark,
		conversationGuid = conversationGuid,
		subject = subject,
		invoiceIds = invoiceIds,
		parentId = parentId,
		properties = properties,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun message_toJs(obj: EncryptedMessage): EncryptedMessageJs {
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
	val fromAddress = nullToUndefined(
		obj.fromAddress
	)
	val fromHealthcarePartyId = nullToUndefined(
		obj.fromHealthcarePartyId
	)
	val recipients = setToArray(
		obj.recipients,
		{ x1: String ->
			x1
		},
	)
	val toAddresses = setToArray(
		obj.toAddresses,
		{ x1: String ->
			x1
		},
	)
	val received = nullToUndefined(
		longToNumber(obj.received)
	)
	val sent = nullToUndefined(
		longToNumber(obj.sent)
	)
	val metas = mapToObject(
		obj.metas,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val readStatus = mapToObject(
		obj.readStatus,
		{ x1: String ->
			x1
		},
		{ x1: MessageReadStatus ->
			messageReadStatus_toJs(x1)
		},
	)
	val transportGuid = nullToUndefined(
		obj.transportGuid
	)
	val remark = nullToUndefined(
		obj.remark
	)
	val conversationGuid = nullToUndefined(
		obj.conversationGuid
	)
	val subject = nullToUndefined(
		obj.subject
	)
	val invoiceIds = setToArray(
		obj.invoiceIds,
		{ x1: String ->
			x1
		},
	)
	val parentId = nullToUndefined(
		obj.parentId
	)
	val properties = setToArray(
		obj.properties,
		{ x1: EncryptedPropertyStub ->
			propertyStub_toJs(x1)
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
	return EncryptedMessageJs(js("{" +
		"id:id," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"tags:tags," +
		"codes:codes," +
		"deletionDate:deletionDate," +
		"fromAddress:fromAddress," +
		"fromHealthcarePartyId:fromHealthcarePartyId," +
		"recipients:recipients," +
		"toAddresses:toAddresses," +
		"received:received," +
		"sent:sent," +
		"metas:metas," +
		"readStatus:readStatus," +
		"transportGuid:transportGuid," +
		"remark:remark," +
		"conversationGuid:conversationGuid," +
		"subject:subject," +
		"invoiceIds:invoiceIds," +
		"parentId:parentId," +
		"properties:properties," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata" +
	"}"))
}

public fun message_fromJs(obj: EncryptedMessageJs): EncryptedMessage {
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
	val fromAddress = undefinedToNull(obj.fromAddress)
	val fromHealthcarePartyId = undefinedToNull(obj.fromHealthcarePartyId)
	val recipients = arrayToSet(
		obj.recipients,
		"obj.recipients",
		{ x1: String ->
			x1
		},
	)
	val toAddresses = arrayToSet(
		obj.toAddresses,
		"obj.toAddresses",
		{ x1: String ->
			x1
		},
	)
	val received = numberToLong(obj.received, "obj.received")
	val sent = numberToLong(obj.sent, "obj.sent")
	val metas = objectToMap(
		obj.metas,
		"obj.metas",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val readStatus = objectToMap(
		obj.readStatus,
		"obj.readStatus",
		{ x1: String ->
			x1
		},
		{ x1: MessageReadStatusJs ->
			messageReadStatus_fromJs(x1)
		},
	)
	val transportGuid = undefinedToNull(obj.transportGuid)
	val remark = undefinedToNull(obj.remark)
	val conversationGuid = undefinedToNull(obj.conversationGuid)
	val subject = undefinedToNull(obj.subject)
	val invoiceIds = arrayToSet(
		obj.invoiceIds,
		"obj.invoiceIds",
		{ x1: String ->
			x1
		},
	)
	val parentId = undefinedToNull(obj.parentId)
	val properties = arrayToSet(
		obj.properties,
		"obj.properties",
		{ x1: EncryptedPropertyStubJs ->
			propertyStub_fromJs(x1)
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
	return EncryptedMessage(
		id = id,
		rev = rev,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		tags = tags,
		codes = codes,
		deletionDate = deletionDate,
		fromAddress = fromAddress,
		fromHealthcarePartyId = fromHealthcarePartyId,
		recipients = recipients,
		toAddresses = toAddresses,
		received = received,
		sent = sent,
		metas = metas,
		readStatus = readStatus,
		transportGuid = transportGuid,
		remark = remark,
		conversationGuid = conversationGuid,
		subject = subject,
		invoiceIds = invoiceIds,
		parentId = parentId,
		properties = properties,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun message_toJs(obj: Message): MessageJs = when (obj) {
	is EncryptedMessage -> message_toJs(obj)
	is DecryptedMessage -> message_toJs(obj)
}

public fun message_fromJs(obj: MessageJs): Message = if (obj.isEncrypted) {
	message_fromJs(obj as EncryptedMessageJs)
} else {
	message_fromJs(obj as DecryptedMessageJs)
}
