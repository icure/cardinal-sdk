// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.CustomEntityOwningEntity
import kotlin.Any
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun <T : Any, T_JS : Any> customEntityOwningEntity_toJs(obj: CustomEntityOwningEntity<T>, convertT: (T) -> T_JS): CustomEntityOwningEntityJs<T_JS> {
	val entity = convertT(obj.entity)
	val entityType = entityWithEncryptionMetadataTypeName_toJs(obj.entityType)
	val secretId = secretIdUseOption_toJs(obj.secretId)
	return CustomEntityOwningEntityJs<T_JS>(js("{" +
		"entity:entity," +
		"entityType:entityType," +
		"secretId:secretId" +
	"}"))
}

public fun <T : Any, T_KT : Any> customEntityOwningEntity_fromJs(obj: CustomEntityOwningEntityJs<T>, convertT: (T) -> T_KT): CustomEntityOwningEntity<T_KT> {
	val entity = convertT(obj.entity)
	val entityType = entityWithEncryptionMetadataTypeName_fromJs(obj.entityType)
	val secretId = secretIdUseOption_fromJs(obj.secretId)
	return CustomEntityOwningEntity<T_KT>(
		entity = entity,
		entityType = entityType,
		secretId = secretId,
	)
}
