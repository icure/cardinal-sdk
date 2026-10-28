// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.CustomEntityDelegateOptions
import com.icure.cardinal.sdk.model.embed.AccessLevel
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun customEntityDelegateOptions_toJs(obj: CustomEntityDelegateOptions): CustomEntityDelegateOptionsJs {
	val accessLevel = obj.accessLevel.name
	val shareEncryptionKey = obj.shareEncryptionKey
	val shareSecretId = obj.shareSecretId
	val shareOwningEntityId = obj.shareOwningEntityId
	return CustomEntityDelegateOptionsJs(js("{" +
		"accessLevel:accessLevel," +
		"shareEncryptionKey:shareEncryptionKey," +
		"shareSecretId:shareSecretId," +
		"shareOwningEntityId:shareOwningEntityId" +
	"}"))
}

public fun customEntityDelegateOptions_fromJs(obj: CustomEntityDelegateOptionsJs): CustomEntityDelegateOptions {
	val accessLevel = AccessLevel.valueOf(obj.accessLevel)
	val shareEncryptionKey = obj.shareEncryptionKey
	val shareSecretId = obj.shareSecretId
	val shareOwningEntityId = obj.shareOwningEntityId
	return CustomEntityDelegateOptions(
		accessLevel = accessLevel,
		shareEncryptionKey = shareEncryptionKey,
		shareSecretId = shareSecretId,
		shareOwningEntityId = shareOwningEntityId,
	)
}
