// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.embed.DecryptedPartnership
import com.icure.cardinal.sdk.model.embed.EncryptedPartnership
import com.icure.cardinal.sdk.model.embed.Partnership
import com.icure.cardinal.sdk.model.embed.PartnershipStatus
import com.icure.cardinal.sdk.model.embed.PartnershipType
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun partnership_toJs(obj: DecryptedPartnership): DecryptedPartnershipJs {
	val type = nullToUndefined(
		obj.type?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val status = nullToUndefined(
		obj.status?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val partnerId = nullToUndefined(
		obj.partnerId
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return DecryptedPartnershipJs(js("{" +
		"type:type," +
		"status:status," +
		"partnerId:partnerId," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun partnership_fromJs(obj: DecryptedPartnershipJs): DecryptedPartnership {
	val type = obj.type?.let { nonNull1 ->
		PartnershipType.valueOf(nonNull1)
	}
	val status = obj.status?.let { nonNull1 ->
		PartnershipStatus.valueOf(nonNull1)
	}
	val partnerId = undefinedToNull(obj.partnerId)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedPartnership(
		type = type,
		status = status,
		partnerId = partnerId,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun partnership_toJs(obj: EncryptedPartnership): EncryptedPartnershipJs {
	val type = nullToUndefined(
		obj.type?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val status = nullToUndefined(
		obj.status?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val partnerId = nullToUndefined(
		obj.partnerId
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return EncryptedPartnershipJs(js("{" +
		"type:type," +
		"status:status," +
		"partnerId:partnerId," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun partnership_fromJs(obj: EncryptedPartnershipJs): EncryptedPartnership {
	val type = obj.type?.let { nonNull1 ->
		PartnershipType.valueOf(nonNull1)
	}
	val status = obj.status?.let { nonNull1 ->
		PartnershipStatus.valueOf(nonNull1)
	}
	val partnerId = undefinedToNull(obj.partnerId)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedPartnership(
		type = type,
		status = status,
		partnerId = partnerId,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun partnership_toJs(obj: Partnership): PartnershipJs = when (obj) {
	is EncryptedPartnership -> partnership_toJs(obj)
	is DecryptedPartnership -> partnership_toJs(obj)
}

public fun partnership_fromJs(obj: PartnershipJs): Partnership = if (obj.isEncrypted) {
	partnership_fromJs(obj as EncryptedPartnershipJs)
} else {
	partnership_fromJs(obj as DecryptedPartnershipJs)
}
