// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.EntityAccessInformation
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel_fromJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel_toJs
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun entityAccessInformation_toJs(obj: EntityAccessInformation): EntityAccessInformationJs {
	val permissionsByDataOwnerId = EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel_toJs(obj.permissionsByDataOwnerId)
	val hasUnknownAnonymousDataOwners = obj.hasUnknownAnonymousDataOwners
	return EntityAccessInformationJs(js("{" +
		"permissionsByDataOwnerId:permissionsByDataOwnerId," +
		"hasUnknownAnonymousDataOwners:hasUnknownAnonymousDataOwners" +
	"}"))
}

public fun entityAccessInformation_fromJs(obj: EntityAccessInformationJs): EntityAccessInformation {
	val permissionsByDataOwnerId = EntityReferenceInGroupToAccessLevelMapObject_delegate_accessLevel_fromJs(obj.permissionsByDataOwnerId)
	val hasUnknownAnonymousDataOwners = obj.hasUnknownAnonymousDataOwners
	return EntityAccessInformation(
		permissionsByDataOwnerId = permissionsByDataOwnerId,
		hasUnknownAnonymousDataOwners = hasUnknownAnonymousDataOwners,
	)
}
