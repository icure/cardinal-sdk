// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.model.base.ParticipantType
import com.icure.cardinal.sdk.model.embed.ContactParticipant
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun contactParticipant_toJs(obj: ContactParticipant): ContactParticipantJs {
	val type = obj.type.name
	val hcpId = obj.hcpId
	return ContactParticipantJs(js("{" +
		"type:type," +
		"hcpId:hcpId" +
	"}"))
}

public fun contactParticipant_fromJs(obj: ContactParticipantJs): ContactParticipant {
	val type = ParticipantType.valueOf(obj.type)
	val hcpId = obj.hcpId
	return ContactParticipant(
		type = type,
		hcpId = hcpId,
	)
}
