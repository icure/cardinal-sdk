package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.crypto.EntityValidationService
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.utils.InternalIcureApi

@InternalIcureApi
class EntityValidationServiceImpl : EntityValidationService {
	override suspend fun <E> validateEncryptedEntities(encryptedEntities: List<E>): List<E> where E : Encryptable, E : HasEncryptionMetadata {
		return encryptedEntities
	}
}
