// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.FormDelegateOptions
import com.icure.cardinal.sdk.model.embed.AccessLevel
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun formDelegateOptions_toJs(obj: FormDelegateOptions): FormDelegateOptionsJs {
	val accessLevel = obj.accessLevel.name
	val shareEncryptionKey = obj.shareEncryptionKey
	val shareSecretId = obj.shareSecretId
	val sharePatientId = obj.sharePatientId
	return FormDelegateOptionsJs(js("{" +
		"accessLevel:accessLevel," +
		"shareEncryptionKey:shareEncryptionKey," +
		"shareSecretId:shareSecretId," +
		"sharePatientId:sharePatientId," +
	"}"))
}

public fun formDelegateOptions_fromJs(obj: FormDelegateOptionsJs): FormDelegateOptions {
	val accessLevel = AccessLevel.valueOf(obj.accessLevel)
	val shareEncryptionKey = obj.shareEncryptionKey
	val shareSecretId = obj.shareSecretId
	val sharePatientId = obj.sharePatientId
	return FormDelegateOptions(
		accessLevel = accessLevel,
		shareEncryptionKey = shareEncryptionKey,
		shareSecretId = shareSecretId,
		sharePatientId = sharePatientId,
	)
}
