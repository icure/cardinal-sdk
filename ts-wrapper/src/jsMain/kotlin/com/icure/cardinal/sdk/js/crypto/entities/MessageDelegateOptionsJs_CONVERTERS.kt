// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.MessageDelegateOptions
import com.icure.cardinal.sdk.model.embed.AccessLevel
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun messageDelegateOptions_toJs(obj: MessageDelegateOptions): MessageDelegateOptionsJs {
	val accessLevel = obj.accessLevel.name
	val shareEncryptionKey = obj.shareEncryptionKey
	val shareSecretId = obj.shareSecretId
	val sharePatientId = obj.sharePatientId
	return MessageDelegateOptionsJs(js("{" +
		"accessLevel:accessLevel," +
		"shareEncryptionKey:shareEncryptionKey," +
		"shareSecretId:shareSecretId," +
		"sharePatientId:sharePatientId," +
	"}"))
}

public fun messageDelegateOptions_fromJs(obj: MessageDelegateOptionsJs): MessageDelegateOptions {
	val accessLevel = AccessLevel.valueOf(obj.accessLevel)
	val shareEncryptionKey = obj.shareEncryptionKey
	val shareSecretId = obj.shareSecretId
	val sharePatientId = obj.sharePatientId
	return MessageDelegateOptions(
		accessLevel = accessLevel,
		shareEncryptionKey = shareEncryptionKey,
		shareSecretId = shareSecretId,
		sharePatientId = sharePatientId,
	)
}
