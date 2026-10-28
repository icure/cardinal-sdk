// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.CustomEntityShareOptions
import com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.cardinal.sdk.model.requests.RequestedPermission
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun customEntityShareOptions_toJs(obj: CustomEntityShareOptions): CustomEntityShareOptionsJs {
	val requestedPermissions = obj.requestedPermissions.name
	val shareEncryptionKey = obj.shareEncryptionKey.name
	val shareOwningEntityIds = obj.shareOwningEntityIds.name
	val shareSecretIds = secretIdShareOptions_toJs(obj.shareSecretIds)
	return CustomEntityShareOptionsJs(js("{" +
		"requestedPermissions:requestedPermissions," +
		"shareEncryptionKey:shareEncryptionKey," +
		"shareOwningEntityIds:shareOwningEntityIds," +
		"shareSecretIds:shareSecretIds" +
	"}"))
}

public fun customEntityShareOptions_fromJs(obj: CustomEntityShareOptionsJs): CustomEntityShareOptions {
	val requestedPermissions = RequestedPermission.valueOf(obj.requestedPermissions)
	val shareEncryptionKey = ShareMetadataBehaviour.valueOf(obj.shareEncryptionKey)
	val shareOwningEntityIds = ShareMetadataBehaviour.valueOf(obj.shareOwningEntityIds)
	val shareSecretIds = secretIdShareOptions_fromJs(obj.shareSecretIds)
	return CustomEntityShareOptions(
		requestedPermissions = requestedPermissions,
		shareEncryptionKey = shareEncryptionKey,
		shareOwningEntityIds = shareOwningEntityIds,
		shareSecretIds = shareSecretIds,
	)
}
