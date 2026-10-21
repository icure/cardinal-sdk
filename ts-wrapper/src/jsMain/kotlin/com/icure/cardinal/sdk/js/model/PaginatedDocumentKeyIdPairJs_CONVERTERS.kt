// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe
import com.icure.cardinal.sdk.js.model.CheckedConverters.jsonToDynamic
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.PaginatedDocumentKeyIdPair
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun paginatedDocumentKeyIdPair_toJs(obj: PaginatedDocumentKeyIdPair): PaginatedDocumentKeyIdPairJs {
	val startKey = nullToUndefined(
		jsonToDynamic(obj.startKey)
	)
	val startKeyDocId = nullToUndefined(
		obj.startKeyDocId
	)
	return PaginatedDocumentKeyIdPairJs(js("{" +
		"startKey:startKey," +
		"startKeyDocId:startKeyDocId" +
	"}"))
}

public fun paginatedDocumentKeyIdPair_fromJs(obj: PaginatedDocumentKeyIdPairJs): PaginatedDocumentKeyIdPair {
	val startKey = dynamicToJsonNullsafe(obj.startKey, "obj.startKey")
	val startKeyDocId = undefinedToNull(obj.startKeyDocId)
	return PaginatedDocumentKeyIdPair(
		startKey = startKey,
		startKeyDocId = startKeyDocId,
	)
}
