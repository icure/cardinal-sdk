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
import com.icure.cardinal.sdk.js.model.embed.DelegationJs
import com.icure.cardinal.sdk.js.model.embed.delegation_fromJs
import com.icure.cardinal.sdk.js.model.embed.delegation_toJs
import com.icure.cardinal.sdk.js.model.embed.securityMetadata_fromJs
import com.icure.cardinal.sdk.js.model.embed.securityMetadata_toJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.DecryptedSecureDelegationKeyMap
import com.icure.cardinal.sdk.model.EncryptedSecureDelegationKeyMap
import com.icure.cardinal.sdk.model.SecureDelegationKeyMap
import com.icure.cardinal.sdk.model.embed.Delegation
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Set

@Suppress("UNUSED_VARIABLE")
public fun secureDelegationKeyMap_toJs(obj: DecryptedSecureDelegationKeyMap): DecryptedSecureDelegationKeyMapJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val delegationKey = obj.delegationKey
	val delegator = nullToUndefined(
		obj.delegator
	)
	val delegate = nullToUndefined(
		obj.delegate
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
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	return DecryptedSecureDelegationKeyMapJs(js("{" +
		"id:id," +
		"rev:rev," +
		"delegationKey:delegationKey," +
		"delegator:delegator," +
		"delegate:delegate," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata," +
		"deletionDate:deletionDate" +
	"}"))
}

public fun secureDelegationKeyMap_fromJs(obj: DecryptedSecureDelegationKeyMapJs): DecryptedSecureDelegationKeyMap {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val delegationKey = obj.delegationKey
	val delegator = undefinedToNull(obj.delegator)
	val delegate = undefinedToNull(obj.delegate)
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
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	return DecryptedSecureDelegationKeyMap(
		id = id,
		rev = rev,
		delegationKey = delegationKey,
		delegator = delegator,
		delegate = delegate,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
		deletionDate = deletionDate,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun secureDelegationKeyMap_toJs(obj: EncryptedSecureDelegationKeyMap): EncryptedSecureDelegationKeyMapJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val delegationKey = obj.delegationKey
	val delegator = nullToUndefined(
		obj.delegator
	)
	val delegate = nullToUndefined(
		obj.delegate
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
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	return EncryptedSecureDelegationKeyMapJs(js("{" +
		"id:id," +
		"rev:rev," +
		"delegationKey:delegationKey," +
		"delegator:delegator," +
		"delegate:delegate," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata," +
		"deletionDate:deletionDate" +
	"}"))
}

public fun secureDelegationKeyMap_fromJs(obj: EncryptedSecureDelegationKeyMapJs): EncryptedSecureDelegationKeyMap {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val delegationKey = obj.delegationKey
	val delegator = undefinedToNull(obj.delegator)
	val delegate = undefinedToNull(obj.delegate)
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
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	return EncryptedSecureDelegationKeyMap(
		id = id,
		rev = rev,
		delegationKey = delegationKey,
		delegator = delegator,
		delegate = delegate,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
		deletionDate = deletionDate,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun secureDelegationKeyMap_toJs(obj: SecureDelegationKeyMap): SecureDelegationKeyMapJs = when (obj) {
	is EncryptedSecureDelegationKeyMap -> secureDelegationKeyMap_toJs(obj)
	is DecryptedSecureDelegationKeyMap -> secureDelegationKeyMap_toJs(obj)
}

public fun secureDelegationKeyMap_fromJs(obj: SecureDelegationKeyMapJs): SecureDelegationKeyMap = if (obj.isEncrypted) {
	secureDelegationKeyMap_fromJs(obj as EncryptedSecureDelegationKeyMapJs)
} else {
	secureDelegationKeyMap_fromJs(obj as DecryptedSecureDelegationKeyMapJs)
}
