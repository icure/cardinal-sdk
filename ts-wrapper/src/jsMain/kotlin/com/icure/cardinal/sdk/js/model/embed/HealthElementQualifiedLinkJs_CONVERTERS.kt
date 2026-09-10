// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.embed.HealthElementQualifiedLink
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun healthElementQualifiedLink_toJs(obj: HealthElementQualifiedLink):
		HealthElementQualifiedLinkJs {
	val type = obj.type
	val associationId = nullToUndefined(
		obj.associationId
	)
	val healthElementId = obj.healthElementId
	return HealthElementQualifiedLinkJs(js("{" +
		"type:type," +
		"associationId:associationId," +
		"healthElementId:healthElementId" +
	"}"))
}

public fun healthElementQualifiedLink_fromJs(obj: HealthElementQualifiedLinkJs):
		HealthElementQualifiedLink {
	val type = obj.type
	val associationId = undefinedToNull(obj.associationId)
	val healthElementId = obj.healthElementId
	return HealthElementQualifiedLink(
		type = type,
		associationId = associationId,
		healthElementId = healthElementId,
	)
}
