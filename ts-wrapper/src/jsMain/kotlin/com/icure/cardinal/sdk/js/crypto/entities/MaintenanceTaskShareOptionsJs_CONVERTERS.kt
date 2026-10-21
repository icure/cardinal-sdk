// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.MaintenanceTaskShareOptions
import com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.cardinal.sdk.model.requests.RequestedPermission
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun maintenanceTaskShareOptions_toJs(obj: MaintenanceTaskShareOptions): MaintenanceTaskShareOptionsJs {
	val requestedPermissions = obj.requestedPermissions.name
	val shareEncryptionKey = obj.shareEncryptionKey.name
	val shareSecretIds = secretIdShareOptions_toJs(obj.shareSecretIds)
	return MaintenanceTaskShareOptionsJs(js("{" +
		"requestedPermissions:requestedPermissions," +
		"shareEncryptionKey:shareEncryptionKey," +
		"shareSecretIds:shareSecretIds," +
	"}"))
}

public fun maintenanceTaskShareOptions_fromJs(obj: MaintenanceTaskShareOptionsJs): MaintenanceTaskShareOptions {
	val requestedPermissions = RequestedPermission.valueOf(obj.requestedPermissions)
	val shareEncryptionKey = ShareMetadataBehaviour.valueOf(obj.shareEncryptionKey)
	val shareSecretIds = secretIdShareOptions_fromJs(obj.shareSecretIds)
	return MaintenanceTaskShareOptions(
		requestedPermissions = requestedPermissions,
		shareEncryptionKey = shareEncryptionKey,
		shareSecretIds = shareSecretIds,
	)
}
