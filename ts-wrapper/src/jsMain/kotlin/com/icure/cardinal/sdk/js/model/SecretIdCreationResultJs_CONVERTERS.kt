// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.model.SecretIdCreationResult
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun <E, E_JS> secretIdCreationResult_toJs(obj: SecretIdCreationResult<E>,
		convertE: (E) -> E_JS): SecretIdCreationResultJs<E_JS> {
	val updatedEntity = convertE(obj.updatedEntity)
	val newSecretId = obj.newSecretId
	return SecretIdCreationResultJs<E_JS>(js("{" +
		"updatedEntity:updatedEntity," +
		"newSecretId:newSecretId" +
	"}"))
}

public fun <E, E_KT> secretIdCreationResult_fromJs(obj: SecretIdCreationResultJs<E>,
		convertE: (E) -> E_KT): SecretIdCreationResult<E_KT> {
	val updatedEntity = convertE(obj.updatedEntity)
	val newSecretId = obj.newSecretId
	return SecretIdCreationResult<E_KT>(
		updatedEntity = updatedEntity,
		newSecretId = newSecretId,
	)
}
