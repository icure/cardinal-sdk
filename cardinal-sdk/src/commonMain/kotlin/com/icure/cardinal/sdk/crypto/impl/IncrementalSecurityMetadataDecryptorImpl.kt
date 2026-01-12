package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.crypto.BaseSecurityMetadataDecryptor
import com.icure.cardinal.sdk.crypto.IncrementalSecurityMetadataDecryptor
import com.icure.cardinal.sdk.crypto.UserEncryptionKeysManager
import com.icure.cardinal.sdk.crypto.entities.EntityEncryptionKeyDetails
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.SecurityMetadataType
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi

@InternalIcureApi
class IncrementalSecurityMetadataDecryptorImpl(
	private val base: BaseSecurityMetadataDecryptor,
	private val userEncryptionKeysManager: UserEncryptionKeysManager,
	private val cryptoService: CryptoService
) : IncrementalSecurityMetadataDecryptor {
	override suspend fun <E : HasEncryptionMetadata, T : Any> doIncrementallyDecryptingKeys(
		entityGroupId: String?,
		entity: E,
		entityType: EntityWithEncryptionMetadataTypeName,
		action: suspend (entity: E, entityType: EntityWithEncryptionMetadataTypeName, keys: List<EntityEncryptionKeyDetails>) -> Result<T>
	): Result<T>? =
		doManyIncrementallyDecryptingKeys(
			entityGroupId,
			listOf(entity),
			entityType,
			action
		)[entity.id]

	override suspend fun <E : HasEncryptionMetadata, T : Any> doManyIncrementallyDecryptingKeys(
		entitiesGroupId: String?,
		entities: List<E>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		action: suspend (entity: E, entityType: EntityWithEncryptionMetadataTypeName, keys: List<EntityEncryptionKeyDetails>) -> Result<T>
	): Map<String, Result<T>> {
		if (entities.isEmpty()) return emptyMap()
		val remainingEntitiesById = entities.associateByTo(mutableMapOf()) { it.id }
		require (remainingEntitiesById.size == entities.size) {
			"Duplicate entries for entities ${entities.groupBy { it.id }.filter { it.value.size > 1 }.keys}"
		}
		val hierarchy = userEncryptionKeysManager.delegatorActorHierarchy().toSet()
		val allExtractedKeysForEntities = entities.associate { it.id to mutableSetOf<HexString>() }
		val newlyExtractedKeysForEntities = entities.associate { it.id to mutableSetOf<HexString>() }
		val latestResults = mutableMapOf<String, Result<T>>()
		val importedKeysByRaw = mutableMapOf<HexString, AesKey<AesAlgorithm.CbcWithPkcs7Padding>>()

		suspend fun updateExtractedKeysAndDoActionIfNecessary(
			newKeys: Map<String, Set<HexString>>,
			forceUpdateOnEntitiesWithNewExtractedKeys: Boolean
		) {
			newKeys.forEach { (entityId, keys) ->
				val newlyExtractedSet = newlyExtractedKeysForEntities.getValue(entityId)
				val alreadyExtractedSet = allExtractedKeysForEntities.getValue(entityId)
				keys.forEach { k ->
					if (k !in alreadyExtractedSet) {
						newlyExtractedSet.add(k)
						if (k !in importedKeysByRaw) {
							importedKeysByRaw[k] = cryptoService.aes.loadKey(AesAlgorithm.CbcWithPkcs7Padding, k.decodedBytes())
						}
					}
				}
			}
			// If we still have some entities that have no keys extracted and we aren't at the last incremental step we
			// will likely have to do a call to the backend anyway.
			// At this point, it is better to wait to do the action also with any keys that could be found by doing
			// additional incremental decryption steps on the entity.
			if (
				forceUpdateOnEntitiesWithNewExtractedKeys ||
				remainingEntitiesById.keys.all { newlyExtractedKeysForEntities.getValue(it).isNotEmpty() }
			) {
				val successes = remainingEntitiesById.mapNotNullTo(mutableSetOf()) { (currId, e) ->
					val currNewlyExtracted = newlyExtractedKeysForEntities.getValue(currId)
					if (currNewlyExtracted.isNotEmpty()) {
						val currAllExtracted = allExtractedKeysForEntities.getValue(currId).also {
							it.addAll(currNewlyExtracted)
						}
						currNewlyExtracted.clear()
						val actionResult = action(
							e,
							entitiesType,
							currAllExtracted.map { EntityEncryptionKeyDetails(importedKeysByRaw.getValue(it), it) }
						)
						latestResults[currId] = actionResult
						if (actionResult.isSuccess) currId else null
					} else null
				}
				remainingEntitiesById -= successes
			}
		}


		updateExtractedKeysAndDoActionIfNecessary(
			newKeys = base.decryptLegacyDelegations(
				entitiesGroupId,
				remainingEntitiesById.values,
				entitiesType,
				hierarchy,
				SecurityMetadataType.EncryptionKey
			),
			forceUpdateOnEntitiesWithNewExtractedKeys = false,
		)
		if (remainingEntitiesById.isEmpty()) return latestResults
		updateExtractedKeysAndDoActionIfNecessary(
			newKeys = base.decryptSecureDelegationsUsingCache(
				entitiesGroupId,
				remainingEntitiesById.values,
				entitiesType,
				hierarchy,
				SecurityMetadataType.EncryptionKey
			),
			forceUpdateOnEntitiesWithNewExtractedKeys = false,
		)
		if (remainingEntitiesById.isEmpty()) return latestResults
		updateExtractedKeysAndDoActionIfNecessary(
			newKeys = base.decryptSecureDelegationsUsingKnownExchangeData(
				entitiesGroupId,
				remainingEntitiesById.values,
				entitiesType,
				hierarchy,
				SecurityMetadataType.EncryptionKey
			),
			forceUpdateOnEntitiesWithNewExtractedKeys = false,
		)
		if (remainingEntitiesById.isEmpty()) return latestResults
		updateExtractedKeysAndDoActionIfNecessary(
			newKeys = base.decryptSecureDelegationsUsingExchangeDataMap(
				entitiesGroupId,
				remainingEntitiesById.values,
				entitiesType,
				hierarchy,
				SecurityMetadataType.EncryptionKey
			),
			forceUpdateOnEntitiesWithNewExtractedKeys = true, // Force use all extracted at last step
		)
		return latestResults
	}
}