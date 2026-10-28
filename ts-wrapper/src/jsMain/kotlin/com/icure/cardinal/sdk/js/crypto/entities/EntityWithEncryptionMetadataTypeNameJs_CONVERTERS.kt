// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun entityWithEncryptionMetadataTypeName_toJs(obj: EntityWithEncryptionMetadataTypeName): EntityWithEncryptionMetadataTypeNameJs = when (obj) {
	is EntityWithEncryptionMetadataTypeName.Custom -> entityWithEncryptionMetadataTypeName_Custom_toJs(obj)
}

public fun entityWithEncryptionMetadataTypeName_fromJs(obj: EntityWithEncryptionMetadataTypeNameJs): EntityWithEncryptionMetadataTypeName = when {
	obj is EntityWithEncryptionMetadataTypeNameJs_CustomJs || obj.ktClass == "com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName.Custom" ->entityWithEncryptionMetadataTypeName_Custom_fromJs(obj as com.icure.cardinal.sdk.js.crypto.entities.EntityWithEncryptionMetadataTypeNameJs_CustomJs)
	else -> throw IllegalArgumentException("""Unknown concrete implementation for com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName: $obj""")
}

@Suppress("UNUSED_VARIABLE")
public fun entityWithEncryptionMetadataTypeName_Custom_toJs(obj: EntityWithEncryptionMetadataTypeName.Custom): EntityWithEncryptionMetadataTypeNameJs_CustomJs {
	val entityTypeId = obj.entityTypeId
	return EntityWithEncryptionMetadataTypeNameJs_CustomJs(js("{" +
		"entityTypeId:entityTypeId," +
	"}"))
}

public fun entityWithEncryptionMetadataTypeName_Custom_fromJs(obj: EntityWithEncryptionMetadataTypeNameJs_CustomJs): EntityWithEncryptionMetadataTypeName.Custom {
	val entityTypeId = obj.entityTypeId
	return EntityWithEncryptionMetadataTypeName.Custom(
		entityTypeId = entityTypeId,
	)
}
