// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.CalendarItemDelegateOptions
import com.icure.cardinal.sdk.model.embed.AccessLevel
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun calendarItemDelegateOptions_toJs(obj: CalendarItemDelegateOptions):
		CalendarItemDelegateOptionsJs {
	val accessLevel = obj.accessLevel.name
	val shareEncryptionKey = obj.shareEncryptionKey
	val shareSecretId = obj.shareSecretId
	val sharePatientId = obj.sharePatientId
	return CalendarItemDelegateOptionsJs(js("{" +
		"accessLevel:accessLevel," +
		"shareEncryptionKey:shareEncryptionKey," +
		"shareSecretId:shareSecretId," +
		"sharePatientId:sharePatientId," +
	"}"))
}

public fun calendarItemDelegateOptions_fromJs(obj: CalendarItemDelegateOptionsJs):
		CalendarItemDelegateOptions {
	val accessLevel = AccessLevel.valueOf(obj.accessLevel)
	val shareEncryptionKey = obj.shareEncryptionKey
	val shareSecretId = obj.shareSecretId
	val sharePatientId = obj.sharePatientId
	return CalendarItemDelegateOptions(
		accessLevel = accessLevel,
		shareEncryptionKey = shareEncryptionKey,
		shareSecretId = shareSecretId,
		sharePatientId = sharePatientId,
	)
}
