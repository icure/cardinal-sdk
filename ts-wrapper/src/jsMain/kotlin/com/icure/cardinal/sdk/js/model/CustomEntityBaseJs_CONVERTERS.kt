// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.dynamicToJsonObjectNullsafe
import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.jsonToDynamic
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
import com.icure.cardinal.sdk.js.model.embed.DataAttachmentJs
import com.icure.cardinal.sdk.js.model.embed.DelegationJs
import com.icure.cardinal.sdk.js.model.embed.dataAttachment_fromJs
import com.icure.cardinal.sdk.js.model.embed.dataAttachment_toJs
import com.icure.cardinal.sdk.js.model.embed.delegation_fromJs
import com.icure.cardinal.sdk.js.model.embed.delegation_toJs
import com.icure.cardinal.sdk.js.model.embed.securityMetadata_fromJs
import com.icure.cardinal.sdk.js.model.embed.securityMetadata_toJs
import com.icure.cardinal.sdk.model.CustomEntityBase
import com.icure.cardinal.sdk.model.DecryptedCustomEntityBase
import com.icure.cardinal.sdk.model.EncryptedCustomEntityBase
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.embed.DataAttachment
import com.icure.cardinal.sdk.model.embed.Delegation
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Set

@Suppress("UNUSED_VARIABLE")
public fun customEntityBase_toJs(obj: DecryptedCustomEntityBase): DecryptedCustomEntityBaseJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
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
	val securityMetadata = nullToUndefined(
		obj.securityMetadata?.let { nonNull1 ->
			securityMetadata_toJs(nonNull1)
		}
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
	val endOfLife = nullToUndefined(
		longToNumber(obj.endOfLife)
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
	val customisedModelVersion = nullToUndefined(
		intToNumber(obj.customisedModelVersion)
	)
	val extensions = nullToUndefined(
		jsonToDynamic(obj.extensions)
	)
	val dataAttachments = mapToObject(
		obj.dataAttachments,
		{ x1: String ->
			x1
		},
		{ x1: DataAttachment ->
			dataAttachment_toJs(x1)
		},
	)
	val deletedAttachments = listToArray<_, dynamic>(
		obj.deletedAttachments,
		{ _ -> throw IllegalArgumentException("List<Nothing> can't have any values") })
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf
	)
	return DecryptedCustomEntityBaseJs(js("{" +
		"id:id," +
		"rev:rev," +
		"deletionDate:deletionDate," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"securityMetadata:securityMetadata," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"endOfLife:endOfLife," +
		"tags:tags," +
		"codes:codes," +
		"customisedModelVersion:customisedModelVersion," +
		"extensions:extensions," +
		"dataAttachments:dataAttachments," +
		"deletedAttachments:deletedAttachments," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun customEntityBase_fromJs(obj: DecryptedCustomEntityBaseJs): DecryptedCustomEntityBase {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
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
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_fromJs(nonNull1)
	}
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val author = undefinedToNull(obj.author)
	val responsible = undefinedToNull(obj.responsible)
	val endOfLife = numberToLong(obj.endOfLife, "obj.endOfLife")
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
	val customisedModelVersion = numberToInt(obj.customisedModelVersion, "obj.customisedModelVersion")
	val extensions = dynamicToJsonObjectNullsafe(obj.extensions, "obj.extensions")
	val dataAttachments = objectToMap(
		obj.dataAttachments,
		"obj.dataAttachments",
		{ x1: String ->
			x1
		},
		{ x1: DataAttachmentJs ->
			dataAttachment_fromJs(x1)
		},
	)
	val deletedAttachments = arrayToList<_, dynamic>(
		obj.deletedAttachments,
		"obj.deletedAttachments",
		{ _ -> throw IllegalArgumentException("Array 'obj.deletedAttachments' can't have any values") })
	val encryptedSelf = obj.encryptedSelf
	return DecryptedCustomEntityBase(
		id = id,
		rev = rev,
		deletionDate = deletionDate,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		securityMetadata = securityMetadata,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		endOfLife = endOfLife,
		tags = tags,
		codes = codes,
		customisedModelVersion = customisedModelVersion,
		extensions = extensions,
		dataAttachments = dataAttachments,
		deletedAttachments = deletedAttachments,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun customEntityBase_toJs(obj: EncryptedCustomEntityBase): EncryptedCustomEntityBaseJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
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
	val securityMetadata = nullToUndefined(
		obj.securityMetadata?.let { nonNull1 ->
			securityMetadata_toJs(nonNull1)
		}
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
	val endOfLife = nullToUndefined(
		longToNumber(obj.endOfLife)
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
	val customisedModelVersion = nullToUndefined(
		intToNumber(obj.customisedModelVersion)
	)
	val extensions = nullToUndefined(
		jsonToDynamic(obj.extensions)
	)
	val dataAttachments = mapToObject(
		obj.dataAttachments,
		{ x1: String ->
			x1
		},
		{ x1: DataAttachment ->
			dataAttachment_toJs(x1)
		},
	)
	val deletedAttachments = listToArray<_, dynamic>(
		obj.deletedAttachments,
		{ _ -> throw IllegalArgumentException("List<Nothing> can't have any values") })
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf
	)
	return EncryptedCustomEntityBaseJs(js("{" +
		"id:id," +
		"rev:rev," +
		"deletionDate:deletionDate," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"securityMetadata:securityMetadata," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"endOfLife:endOfLife," +
		"tags:tags," +
		"codes:codes," +
		"customisedModelVersion:customisedModelVersion," +
		"extensions:extensions," +
		"dataAttachments:dataAttachments," +
		"deletedAttachments:deletedAttachments," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun customEntityBase_fromJs(obj: EncryptedCustomEntityBaseJs): EncryptedCustomEntityBase {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
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
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_fromJs(nonNull1)
	}
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val author = undefinedToNull(obj.author)
	val responsible = undefinedToNull(obj.responsible)
	val endOfLife = numberToLong(obj.endOfLife, "obj.endOfLife")
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
	val customisedModelVersion = numberToInt(obj.customisedModelVersion, "obj.customisedModelVersion")
	val extensions = dynamicToJsonObjectNullsafe(obj.extensions, "obj.extensions")
	val dataAttachments = objectToMap(
		obj.dataAttachments,
		"obj.dataAttachments",
		{ x1: String ->
			x1
		},
		{ x1: DataAttachmentJs ->
			dataAttachment_fromJs(x1)
		},
	)
	val deletedAttachments = arrayToList<_, dynamic>(
		obj.deletedAttachments,
		"obj.deletedAttachments",
		{ _ -> throw IllegalArgumentException("Array 'obj.deletedAttachments' can't have any values") })
	val encryptedSelf = obj.encryptedSelf
	return EncryptedCustomEntityBase(
		id = id,
		rev = rev,
		deletionDate = deletionDate,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		securityMetadata = securityMetadata,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		endOfLife = endOfLife,
		tags = tags,
		codes = codes,
		customisedModelVersion = customisedModelVersion,
		extensions = extensions,
		dataAttachments = dataAttachments,
		deletedAttachments = deletedAttachments,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun customEntityBase_toJs(obj: CustomEntityBase): CustomEntityBaseJs = when (obj) {
	is EncryptedCustomEntityBase -> customEntityBase_toJs(obj)
	is DecryptedCustomEntityBase -> customEntityBase_toJs(obj)
}

public fun customEntityBase_fromJs(obj: CustomEntityBaseJs): CustomEntityBase = if (obj.isEncrypted) {
	customEntityBase_fromJs(obj as EncryptedCustomEntityBaseJs)
} else {
	customEntityBase_fromJs(obj as DecryptedCustomEntityBaseJs)
}
