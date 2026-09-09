// auto-generated file
package com.icure.cardinal.sdk.js.model.base

import com.icure.cardinal.sdk.model.base.DataOwnerGroupLink
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun dataOwnerGroupLink_toJs(obj: DataOwnerGroupLink): DataOwnerGroupLinkJs {
	val dataOwnerId = obj.dataOwnerId
	return DataOwnerGroupLinkJs(js("{" +
		"dataOwnerId:dataOwnerId" +
	"}"))
}

public fun dataOwnerGroupLink_fromJs(obj: DataOwnerGroupLinkJs): DataOwnerGroupLink {
	val dataOwnerId = obj.dataOwnerId
	return DataOwnerGroupLink(
		dataOwnerId = dataOwnerId,
	)
}
