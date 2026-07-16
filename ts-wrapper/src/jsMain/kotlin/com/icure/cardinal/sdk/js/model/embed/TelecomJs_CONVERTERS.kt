// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.dynamicToJsonObjectNullsafe
import com.icure.cardinal.sdk.js.model.CheckedConverters.jsonToDynamic
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.embed.DecryptedTelecom
import com.icure.cardinal.sdk.model.embed.EncryptedTelecom
import com.icure.cardinal.sdk.model.embed.Telecom
import com.icure.cardinal.sdk.model.embed.TelecomType
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun telecom_toJs(obj: DecryptedTelecom): DecryptedTelecomJs {
	val telecomType = nullToUndefined(
		obj.telecomType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val telecomNumber = nullToUndefined(
		obj.telecomNumber
	)
	val telecomDescription = nullToUndefined(
		obj.telecomDescription
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	val extensions = nullToUndefined(
		jsonToDynamic(obj.extensions)
	)
	return DecryptedTelecomJs(js("{" +
		"telecomType:telecomType," +
		"telecomNumber:telecomNumber," +
		"telecomDescription:telecomDescription," +
		"encryptedSelf:encryptedSelf," +
		"extensions:extensions" +
	"}"))
}

public fun telecom_fromJs(obj: DecryptedTelecomJs): DecryptedTelecom {
	val telecomType = obj.telecomType?.let { nonNull1 ->
		TelecomType.valueOf(nonNull1)
	}
	val telecomNumber = undefinedToNull(obj.telecomNumber)
	val telecomDescription = undefinedToNull(obj.telecomDescription)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val extensions = dynamicToJsonObjectNullsafe(obj.extensions, "obj.extensions")
	return DecryptedTelecom(
		telecomType = telecomType,
		telecomNumber = telecomNumber,
		telecomDescription = telecomDescription,
		encryptedSelf = encryptedSelf,
		extensions = extensions,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun telecom_toJs(obj: EncryptedTelecom): EncryptedTelecomJs {
	val telecomType = nullToUndefined(
		obj.telecomType?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val telecomNumber = nullToUndefined(
		obj.telecomNumber
	)
	val telecomDescription = nullToUndefined(
		obj.telecomDescription
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	val extensions = nullToUndefined(
		jsonToDynamic(obj.extensions)
	)
	return EncryptedTelecomJs(js("{" +
		"telecomType:telecomType," +
		"telecomNumber:telecomNumber," +
		"telecomDescription:telecomDescription," +
		"encryptedSelf:encryptedSelf," +
		"extensions:extensions" +
	"}"))
}

public fun telecom_fromJs(obj: EncryptedTelecomJs): EncryptedTelecom {
	val telecomType = obj.telecomType?.let { nonNull1 ->
		TelecomType.valueOf(nonNull1)
	}
	val telecomNumber = undefinedToNull(obj.telecomNumber)
	val telecomDescription = undefinedToNull(obj.telecomDescription)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val extensions = dynamicToJsonObjectNullsafe(obj.extensions, "obj.extensions")
	return EncryptedTelecom(
		telecomType = telecomType,
		telecomNumber = telecomNumber,
		telecomDescription = telecomDescription,
		encryptedSelf = encryptedSelf,
		extensions = extensions,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun telecom_toJs(obj: Telecom): TelecomJs = when (obj) {
	is EncryptedTelecom -> telecom_toJs(obj)
	is DecryptedTelecom -> telecom_toJs(obj)
}

public fun telecom_fromJs(obj: TelecomJs): Telecom = if (obj.isEncrypted) {
	telecom_fromJs(obj as EncryptedTelecomJs)
} else {
	telecom_fromJs(obj as DecryptedTelecomJs)
}
