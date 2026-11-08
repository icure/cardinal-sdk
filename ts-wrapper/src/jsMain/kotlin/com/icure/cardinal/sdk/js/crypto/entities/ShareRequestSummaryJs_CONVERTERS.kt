// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.cardinal.sdk.crypto.entities.ShareRequestSummary
import com.icure.cardinal.sdk.crypto.entities.SharedSecretIdsSource
import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.model.requests.RequestedPermission
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun shareRequestSummary_toJs(obj: ShareRequestSummary): ShareRequestSummaryJs {
	val requestedPermissions = obj.requestedPermissions.name
	val secretIdsSource = obj.secretIdsSource.name
	val sharedSecretIdsCount = intToNumber(obj.sharedSecretIdsCount)
	val encryptionKeysBehaviour = obj.encryptionKeysBehaviour.name
	val sharedEncryptionKeysCount = intToNumber(obj.sharedEncryptionKeysCount)
	val owningEntityIdsBehaviour = obj.owningEntityIdsBehaviour.name
	val sharedOwningEntityIdsCount = intToNumber(obj.sharedOwningEntityIdsCount)
	return ShareRequestSummaryJs(js("{" +
		"requestedPermissions:requestedPermissions," +
		"secretIdsSource:secretIdsSource," +
		"sharedSecretIdsCount:sharedSecretIdsCount," +
		"encryptionKeysBehaviour:encryptionKeysBehaviour," +
		"sharedEncryptionKeysCount:sharedEncryptionKeysCount," +
		"owningEntityIdsBehaviour:owningEntityIdsBehaviour," +
		"sharedOwningEntityIdsCount:sharedOwningEntityIdsCount" +
	"}"))
}

public fun shareRequestSummary_fromJs(obj: ShareRequestSummaryJs): ShareRequestSummary {
	val requestedPermissions = RequestedPermission.valueOf(obj.requestedPermissions)
	val secretIdsSource = SharedSecretIdsSource.valueOf(obj.secretIdsSource)
	val sharedSecretIdsCount = numberToInt(obj.sharedSecretIdsCount, "obj.sharedSecretIdsCount")
	val encryptionKeysBehaviour = ShareMetadataBehaviour.valueOf(obj.encryptionKeysBehaviour)
	val sharedEncryptionKeysCount = numberToInt(obj.sharedEncryptionKeysCount, "obj.sharedEncryptionKeysCount")
	val owningEntityIdsBehaviour = ShareMetadataBehaviour.valueOf(obj.owningEntityIdsBehaviour)
	val sharedOwningEntityIdsCount = numberToInt(obj.sharedOwningEntityIdsCount, "obj.sharedOwningEntityIdsCount")
	return ShareRequestSummary(
		requestedPermissions = requestedPermissions,
		secretIdsSource = secretIdsSource,
		sharedSecretIdsCount = sharedSecretIdsCount,
		encryptionKeysBehaviour = encryptionKeysBehaviour,
		sharedEncryptionKeysCount = sharedEncryptionKeysCount,
		owningEntityIdsBehaviour = owningEntityIdsBehaviour,
		sharedOwningEntityIdsCount = sharedOwningEntityIdsCount,
	)
}
