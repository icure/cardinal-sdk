// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.ContactDelegateOptions
import com.icure.cardinal.sdk.model.embed.AccessLevel
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun contactDelegateOptions_toJs(obj: ContactDelegateOptions): ContactDelegateOptionsJs {
	val accessLevel = obj.accessLevel.name
	val shareEncryptionKey = obj.shareEncryptionKey
	val shareSecretId = obj.shareSecretId
	val sharePatientId = obj.sharePatientId
	return ContactDelegateOptionsJs(js("{" +
		"accessLevel:accessLevel," +
		"shareEncryptionKey:shareEncryptionKey," +
		"shareSecretId:shareSecretId," +
		"sharePatientId:sharePatientId," +
	"}"))
}

public fun contactDelegateOptions_fromJs(obj: ContactDelegateOptionsJs): ContactDelegateOptions {
	val accessLevel = AccessLevel.valueOf(obj.accessLevel)
	val shareEncryptionKey = obj.shareEncryptionKey
	val shareSecretId = obj.shareSecretId
	val sharePatientId = obj.sharePatientId
	return ContactDelegateOptions(
		accessLevel = accessLevel,
		shareEncryptionKey = shareEncryptionKey,
		shareSecretId = shareSecretId,
		sharePatientId = sharePatientId,
	)
}
