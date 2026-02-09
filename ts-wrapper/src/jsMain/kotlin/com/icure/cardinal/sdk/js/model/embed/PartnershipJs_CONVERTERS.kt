// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.embed.Partnership
import com.icure.cardinal.sdk.model.embed.PartnershipStatus
import com.icure.cardinal.sdk.model.embed.PartnershipType
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun partnership_toJs(obj: Partnership): PartnershipJs {
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
	return PartnershipJs(js("{" +
		"type:type," +
		"status:status," +
		"partnerId:partnerId" +
	"}"))
}

public fun partnership_fromJs(obj: PartnershipJs): Partnership {
	val type = obj.type?.let { nonNull1 ->
		PartnershipType.valueOf(nonNull1)
	}
	val status = obj.status?.let { nonNull1 ->
		PartnershipStatus.valueOf(nonNull1)
	}
	val partnerId = undefinedToNull(obj.partnerId)
	return Partnership(
		type = type,
		status = status,
		partnerId = partnerId,
	)
}
