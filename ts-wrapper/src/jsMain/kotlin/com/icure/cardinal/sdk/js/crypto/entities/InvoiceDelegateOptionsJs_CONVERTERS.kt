// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.InvoiceDelegateOptions
import com.icure.cardinal.sdk.model.embed.AccessLevel
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun invoiceDelegateOptions_toJs(obj: InvoiceDelegateOptions): InvoiceDelegateOptionsJs {
	val accessLevel = obj.accessLevel.name
	val shareEncryptionKey = obj.shareEncryptionKey
	val shareSecretId = obj.shareSecretId
	val sharePatientId = obj.sharePatientId
	return InvoiceDelegateOptionsJs(js("{" +
		"accessLevel:accessLevel," +
		"shareEncryptionKey:shareEncryptionKey," +
		"shareSecretId:shareSecretId," +
		"sharePatientId:sharePatientId," +
	"}"))
}

public fun invoiceDelegateOptions_fromJs(obj: InvoiceDelegateOptionsJs): InvoiceDelegateOptions {
	val accessLevel = AccessLevel.valueOf(obj.accessLevel)
	val shareEncryptionKey = obj.shareEncryptionKey
	val shareSecretId = obj.shareSecretId
	val sharePatientId = obj.sharePatientId
	return InvoiceDelegateOptions(
		accessLevel = accessLevel,
		shareEncryptionKey = shareEncryptionKey,
		shareSecretId = shareSecretId,
		sharePatientId = sharePatientId,
	)
}
