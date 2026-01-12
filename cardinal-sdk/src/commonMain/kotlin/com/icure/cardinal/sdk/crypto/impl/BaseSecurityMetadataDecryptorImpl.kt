package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.crypto.BaseSecurityMetadataDecryptor
import com.icure.cardinal.sdk.crypto.ExchangeDataManager
import com.icure.cardinal.sdk.crypto.ExchangeDataMapManager
import com.icure.cardinal.sdk.crypto.ExchangeKeysManager
import com.icure.cardinal.sdk.crypto.SecureDelegationsEncryption
import com.icure.cardinal.sdk.crypto.UserEncryptionKeysManager
import com.icure.cardinal.sdk.crypto.entities.DecryptedMetadataDetails
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataWithPotentiallyDecryptedContent
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataWithUnencryptedContent
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.crypto.entities.SecureDelegationMembersDetails
import com.icure.cardinal.sdk.crypto.entities.SecurityMetadataType
import com.icure.cardinal.sdk.crypto.entities.resolve
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.SecureDelegation
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class BaseSecurityMetadataDecryptorImpl(
	private val boundGroup: SdkBoundGroup?,
	private val cryptoService: CryptoService,
	private val exchangeKeysManager: ExchangeKeysManager,
	private val exchangeDataManager: ExchangeDataManager,
	private val secureDelegationsEncryption: SecureDelegationsEncryption,
	private val exchangeDataMap: ExchangeDataMapManager,
	private val encryptionKeysManager: UserEncryptionKeysManager
) : BaseSecurityMetadataDecryptor {
	override suspend fun <T : Any> decryptLegacyDelegations(
		entitiesGroupId: String?,
		entities: Collection<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>,
		metadataType: SecurityMetadataType<T>
	): Map<String, Set<T>> {
		require(dataOwnersHierarchySubset.isNotEmpty()) { "Data owners hierarchy subset can't be empty" }
		// Legacy delegations use only cached data, no need to operate in bulk
		return entities.associate { e ->
			e.id to extractFromLegacyDelegations(
				entitiesGroupId,
				e,
				dataOwnersHierarchySubset,
				metadataType
			).map {
				it.value
			}.toSet()
		}
	}

	private suspend fun <T : Any> extractFromLegacyDelegations(
		entitiesGroupId: String?,
		entity: HasEncryptionMetadata,
		dataOwnersHierarchySubset: Set<String>,
		metadataType: SecurityMetadataType<T>
	): List<DecryptedMetadataDetails<T>> = if (boundGroup.resolve(entitiesGroupId) != null) {
		// Legacy delegations don't support inter-group sharing
		emptyList()
	} else {
		metadataType.extractLegacyDelegations(entity).flatMap { (delegateId, delegations) ->
			populateLegacyDelegationDelegate(
				delegateId,
				if (delegateId in dataOwnersHierarchySubset) {
					delegations
				} else {
					delegations.filterTo(mutableSetOf()) { it.owner in dataOwnersHierarchySubset }
				}
			)
		}.mapNotNull { delegation ->
			tryDecryptLegacyDelegation(delegation, metadataType)?.let { decryptedValue ->
				DecryptedMetadataDetails(
					metadataType.mapLegacyDecrypted(decryptedValue),
					setOfNotNull(
						delegation.delegatedTo,
						delegation.owner,
					).mapTo(mutableSetOf()) {
						EntityReferenceInGroup(it, null)
					}
				)
			}
		}
	}

	private fun populateLegacyDelegationDelegate(delegateId: String, delegations: Set<Delegation>): Set<Delegation> {
		return delegations.mapTo(mutableSetOf()) {
			if (it.delegatedTo == delegateId) it else it.copy(delegatedTo = delegateId)
		}
	}

	private suspend fun tryDecryptLegacyDelegation(
		delegation: Delegation,
		metadataType: SecurityMetadataType<*>
	): String? {
		if (delegation.key == null) {
			return null
		}
		if (delegation.owner == null || delegation.delegatedTo == null) {
			return null
		}
		val exchangeKeys = exchangeKeysManager.getDecryptionExchangeKeysFor(
			delegatorId = delegation.owner,
			delegateId = delegation.delegatedTo,
		)
		return exchangeKeys.firstNotNullOfOrNull {
			kotlin.runCatching {
				// Format of encrypted key for any delegation should be entityId:key, but with the merging of entities the entityId might not match the
				// current id. As a checksum we are only verifying that the decrypted bytes can be represented as a string with exactly one ':'.
				// Additionally, we also have a validator that is specific for each type of delegation content (encryption key, secret id, ...)
				cryptoService.aes.decrypt(delegation.key.decodedBytes(), it)
					.decodeToString().split(":").takeIf { it.size == 2 }?.last()
					?.takeIf { metadataType.validateLegacyDecrypted(it) }
			}.getOrNull()
		}
	}

	override suspend fun <T : Any> decryptSecureDelegationsUsingCache(
		entitiesGroupId: String?,
		entities: Collection<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>,
		metadataType: SecurityMetadataType<T>
	): Map<String, Set<T>> {
		val dataOwnersHierarchyReferences = selfHierarchyIdsAsReferenceStrings(
			dataOwnersHierarchySubset,
			entitiesGroupId
		)
		val toSearchById = mutableSetOf<String>()
		val toSearchByDelegationKey = mutableSetOf<SecureDelegationKeyString>()
		entities.forEach { e ->
			e.securityMetadata?.secureDelegations?.forEach { (delegationKey, delegation) ->
				if (
					delegation.delegator == null ||
					delegation.delegate == null ||
					delegation.delegator in dataOwnersHierarchyReferences ||
					delegation.delegate in dataOwnersHierarchyReferences
				) {
					if (delegation.exchangeDataId != null) {
						toSearchById.add(delegation.exchangeDataId)
					} else {
						toSearchByDelegationKey.add(delegationKey)
					}
				}
			}
		}
		val cachedByExchangeDataId = exchangeDataManager.getDecryptionDataByIds(
			entitiesGroupId,
			toSearchById,
			false
		)
		val cachedByDelegationKey = exchangeDataManager.getCachedDecryptionDataKeyByAccessControlHash(
			entitiesGroupId,
			toSearchByDelegationKey
		)
		return entities.associate { entity ->
			entity.id to entity.securityMetadata?.secureDelegations?.flatMapTo(mutableSetOf()) { (delegationKey, delegation) ->
				val cached =
					if (delegation.exchangeDataId != null)
						cachedByExchangeDataId[delegation.exchangeDataId]
					else
						cachedByDelegationKey[delegationKey]
				val exchangeKey = cached?.unencryptedContent?.exchangeKey
				if (
					exchangeKey != null && (
						cached.exchangeData.delegate in dataOwnersHierarchyReferences ||
							cached.exchangeData.delegator in dataOwnersHierarchyReferences
					)
				) {
					metadataType.decryptSecureDelegation(delegation, exchangeKey, secureDelegationsEncryption)
				} else emptySet()
			}.orEmpty()
		}
	}

	override suspend fun <T : Any> decryptSecureDelegationsUsingKnownExchangeData(
		entitiesGroupId: String?,
		entities: Collection<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>,
		metadataType: SecurityMetadataType<T>
	): Map<String, Set<T>> {
		val dataOwnersHierarchyReferences = selfHierarchyIdsAsReferenceStrings(
			dataOwnersHierarchySubset,
			entitiesGroupId
		)
		val toSearchById = entities.flatMapTo(mutableSetOf()) { e ->
			e.securityMetadata?.secureDelegations?.values?.mapNotNull { delegation ->
				if (
					(
						delegation.delegate in dataOwnersHierarchyReferences ||
						delegation.delegator in dataOwnersHierarchyReferences
					) && delegation.exchangeDataId != null && metadataType.hasValueIn(delegation)
				) {
					delegation.exchangeDataId
				} else null
			}.orEmpty()
		}
		val retrievedByExchangeDataId = if (toSearchById.isNotEmpty()) exchangeDataManager.getDecryptionDataByIds(
			entitiesGroupId,
			toSearchById,
			true
		) else emptyMap()
		return entities.associate { entity ->
			entity.id to entity.securityMetadata?.secureDelegations?.values?.flatMapTo(mutableSetOf()) { delegation ->
				val cached =
					if (delegation.exchangeDataId != null)
						retrievedByExchangeDataId[delegation.exchangeDataId]
					else
						null
				val exchangeKey = cached?.unencryptedContent?.exchangeKey
				if (exchangeKey != null) {
					metadataType.decryptSecureDelegation(delegation, exchangeKey, secureDelegationsEncryption)
				} else emptySet()
			}.orEmpty()
		}
	}

	override suspend fun <T : Any> decryptSecureDelegationsUsingExchangeDataMap(
		entitiesGroupId: String?,
		entities: Collection<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>,
		metadataType: SecurityMetadataType<T>
	): Map<String, Set<T>> {
		val dataOwnersHierarchyReferences = selfHierarchyIdsAsReferenceStrings(
			dataOwnersHierarchySubset,
			entitiesGroupId
		)
		val toSearchByDelegationKey = entities.flatMapTo(mutableSetOf()) { e ->
			e.securityMetadata?.secureDelegations?.mapNotNull { (delegationKey, delegation) ->
				if (
					(
						delegation.delegate in dataOwnersHierarchyReferences ||
							delegation.delegator in dataOwnersHierarchyReferences
					) && delegation.exchangeDataId == null && metadataType.hasValueIn(delegation)
				) {
					// Note: if the data owner was anonymous we already got the data before.
					delegationKey
				} else null
			}.orEmpty()
		}
		// Note cached could have more than what was cached at decryptSecureDelegationsUsingCache in case of parallel requests
		val alreadyCached = exchangeDataManager.getCachedDecryptionDataKeyByAccessControlHash(
			entitiesGroupId,
			toSearchByDelegationKey
		)
		val exchangeDataIdByDelegationKey = getExchangeDataMapsAndDecrypt(
			entitiesGroupId,
			toSearchByDelegationKey.filterTo(mutableSetOf()) { it !in alreadyCached }
		)
		val retrievedByExchangeDataId = if (exchangeDataIdByDelegationKey.isNotEmpty()) exchangeDataManager.getDecryptionDataByIds(
			entitiesGroupId,
			exchangeDataIdByDelegationKey.values.toSet(),
			true
		) else emptyMap()
		return entities.associate { entity ->
			entity.id to entity.securityMetadata?.secureDelegations?.flatMapTo(mutableSetOf()) { (delegationKey, delegation) ->
				val cached = alreadyCached[delegationKey] ?:
					exchangeDataIdByDelegationKey[delegationKey]?.let { retrievedByExchangeDataId[it] }
				val exchangeKey = cached?.unencryptedContent?.exchangeKey
				if (exchangeKey != null) {
					metadataType.decryptSecureDelegation(delegation, exchangeKey, secureDelegationsEncryption)
				} else emptySet()
			}.orEmpty()
		}
	}

	override suspend fun <T : Any> decryptAll(
		entitiesGroupId: String?,
		entities: List<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>,
		metadataType: SecurityMetadataType<T>
	): Map<String, List<DecryptedMetadataDetails<T>>> {
		val fromLegacyDelegations = decryptAllLegacyDelegations(
			entitiesGroupId,
			entities,
			entitiesType,
			dataOwnersHierarchySubset,
			metadataType
		)
		val fromSecureDelegations = decryptAllSecureDelegations(
			entitiesGroupId,
			entities,
			entitiesType,
			dataOwnersHierarchySubset,
			metadataType
		)
		return (fromSecureDelegations.toList() + fromLegacyDelegations.toList()).groupingBy {
			it.first
		}.aggregate { _, accumulator, element, _ ->
			if (accumulator == null) element.second else accumulator + element.second
		}
	}

	override suspend fun <T : Any> decryptAllLegacyDelegations(
		entitiesGroupId: String?,
		entities: List<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>,
		metadataType: SecurityMetadataType<T>
	): Map<String, List<DecryptedMetadataDetails<T>>> =
		entities.associate {
			it.id to extractFromLegacyDelegations(
				entitiesGroupId,
				it,
				dataOwnersHierarchySubset,
				metadataType
			)
		}

	override suspend fun <T : Any> decryptAllSecureDelegations(
		entitiesGroupId: String?,
		entities: List<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>,
		metadataType: SecurityMetadataType<T>
	): Map<String, List<DecryptedMetadataDetails<T>>> {
		val loadedExchangeData = loadAllExchangeDataForEntitiesSecureDelegations(
			entitiesGroupId,
			entities,
			dataOwnersHierarchySubset
		) {
			metadataType.hasValueIn(it)
		}
		return entities.associate { e ->
			e.id to e.securityMetadata?.secureDelegations?.flatMap { (delegationKey, delegation) ->
				val exchangeDataToUse = loadedExchangeData.getExchangeDataFor(delegationKey, delegation)
				exchangeDataToUse?.unencryptedContent?.exchangeKey?.let {
					metadataType.decryptSecureDelegation(delegation, it, secureDelegationsEncryption)
				}?.let { decrypted ->
					val plainMembers = setOf(
						exchangeDataToUse.exchangeData.delegate,
						exchangeDataToUse.exchangeData.delegator,
					).mapTo(mutableSetOf()) { dataOwnerReferenceString ->
						EntityReferenceInGroup.parse(
							dataOwnerReferenceString,
							entitiesGroupId,
							boundGroup
						)
					}
					decrypted.map {
						DecryptedMetadataDetails(it, plainMembers)
					}
				}.orEmpty()
			}.orEmpty()
		}
	}

	override suspend fun getSecureDelegationMemberDetails(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
	): Map<SecureDelegationKeyString, SecureDelegationMembersDetails> {
		val loadedExchangeData = loadAllExchangeDataForEntitiesSecureDelegations(
			entityGroupId,
			listOf(entity),
			encryptionKeysManager.delegatorActorHierarchy().toSet()
		) {
			it.delegate == null || it.delegator == null
		}
		return entity.securityMetadata?.secureDelegations?.mapValues { (delegationKey, delegation) ->
			if (delegation.delegate != null && delegation.delegator != null) {
				SecureDelegationMembersDetails(
					delegator = EntityReferenceInGroup.parse(delegation.delegator, entityGroupId, boundGroup),
					delegate = EntityReferenceInGroup.parse(delegation.delegate, entityGroupId, boundGroup),
					fullyExplicit = true,
					accessControlSecret = null,
					accessLevel = delegation.permissions
				)
			} else {
				val exchangeData = loadedExchangeData.getExchangeDataFor(delegationKey, delegation)
				SecureDelegationMembersDetails(
					delegator = (delegation.delegator ?: exchangeData?.exchangeData?.delegator)?.let {
						EntityReferenceInGroup.parse(it, entityGroupId, boundGroup)
					},
					delegate = (delegation.delegate ?: exchangeData?.exchangeData?.delegate)?.let {
						EntityReferenceInGroup.parse(it, entityGroupId, boundGroup)
					},
					fullyExplicit = false,
					accessControlSecret = exchangeData?.unencryptedContent?.accessControlSecret,
					accessLevel = delegation.permissions
				)
			}
		}.orEmpty()
	}

	override suspend fun getEntityAccessLevel(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>
	): AccessLevel? {
		val legacyAccess = getEntityLegacyDelegationAccessLevel(entityGroupId, entity, entityType, dataOwnersHierarchySubset)
		if (legacyAccess != null) return legacyAccess // Legacy access is always max access.
		return getEntitySecureDelegationsAccessLevel(entityGroupId, entity, entityType, dataOwnersHierarchySubset)
	}

	override suspend fun getEntityLegacyDelegationAccessLevel(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>
	): AccessLevel? = if (
		boundGroup.resolve(entityGroupId) == null
		&& dataOwnersHierarchySubset.any { entity.delegations.containsKey(it) }
	) AccessLevel.Write else null

	override suspend fun getEntitySecureDelegationsAccessLevel(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>
	): AccessLevel? {
		require(dataOwnersHierarchySubset.isNotEmpty()) { "`dataOwnersHierarchySubset` can't be empty" }
		val dataOwnersHierarchyReferences = selfHierarchyIdsAsReferenceStrings(
			dataOwnersHierarchySubset,
			entityGroupId
		)
		val securityMetadata = entity.securityMetadata
		if (securityMetadata == null || securityMetadata.secureDelegations.isEmpty()) return null
		// If the data owner is explicit all delegations he can access has his id. If the delegator is anonymous all delegations he can access are
		// accessible by hash. No mixed scenario possible.
		val accessibleDelegations = securityMetadata.secureDelegations.values.filter {
			it.delegate in dataOwnersHierarchyReferences || it.delegator in dataOwnersHierarchyReferences
		}.takeIf { it.isNotEmpty() } ?: exchangeDataManager.getCachedDecryptionDataKeyByAccessControlHash(
			entityGroupId,
			securityMetadata.secureDelegations.keys
		).keys.let { accessibleDelegationKeys ->
			securityMetadata.secureDelegations.mapNotNull { if (it.key in accessibleDelegationKeys) it.value else null }
		}
		return when {
			accessibleDelegations.isEmpty() -> null
			accessibleDelegations.any { it.permissions == AccessLevel.Write } -> AccessLevel.Write
			else -> AccessLevel.Read
		}
	}

	override fun hasAnyEncryptionKeys(entity: HasEncryptionMetadata): Boolean =
		entity.securityMetadata?.secureDelegations?.values?.any { it.encryptionKeys.isNotEmpty() } == true
			|| entity.encryptionKeys.any { it.value.isNotEmpty() }

	private fun selfHierarchyIdsAsReferenceStrings(
		dataOwnerHierarchyIds: Set<String>,
		entityGroupId: String?
	) = boundGroup.resolve(entityGroupId)?.let {
		dataOwnerHierarchyIds.mapTo(mutableSetOf()) { "${boundGroup!!.groupId}/$it"}
	} ?: dataOwnerHierarchyIds

	private suspend fun getExchangeDataMapsAndDecrypt(
		entitiesGroupId: String?,
		delegationKeys: Set<SecureDelegationKeyString>
	): Map<SecureDelegationKeyString, String> {
		if (delegationKeys.isEmpty()) return emptyMap()
		val exchangeDataMaps = exchangeDataMap.getExchangeDataMapBatch(
			entitiesGroupId,
			delegationKeys
		)
		return exchangeDataMaps.mapNotNull { exchangeDataMap ->
			secureDelegationsEncryption.decryptExchangeDataId(exchangeDataMap.encryptedExchangeDataIds)?.let {
				SecureDelegationKeyString(exchangeDataMap.id) to it
			}
		}.toMap()
	}

	private suspend fun loadAllExchangeDataForEntitiesSecureDelegations(
		entitiesGroupId: String?,
		entities: List<HasEncryptionMetadata>,
		dataOwnersHierarchySubset: Set<String>,
		secureDelegationFilter: (SecureDelegation) -> Boolean
	): LoadedExchangeData {
		val dataOwnersHierarchyReferences = selfHierarchyIdsAsReferenceStrings(
			dataOwnersHierarchySubset,
			entitiesGroupId
		)
		val toSearchByDelegationKey = entities.flatMapTo(mutableSetOf()) { e ->
			e.securityMetadata?.secureDelegations?.mapNotNull {
				if (it.value.exchangeDataId == null && secureDelegationFilter(it.value)) it.key else null
			}.orEmpty()
		}
		val exchangeDataByDelegationKey = exchangeDataManager.getCachedDecryptionDataKeyByAccessControlHash(
			entitiesGroupId,
			toSearchByDelegationKey
		)
		val toSearchWithExchangeDataMap = entities.flatMapTo(mutableSetOf()) { e ->
			e.securityMetadata?.secureDelegations?.mapNotNull { (delegationKey, delegation) ->
				if (
					delegation.exchangeDataId == null
					&& (delegation.delegate in dataOwnersHierarchyReferences || delegation.delegator in dataOwnersHierarchyReferences)
					&& !exchangeDataByDelegationKey.containsKey(delegationKey)
					&& secureDelegationFilter(delegation)
				) delegationKey else null
			}.orEmpty()
		}
		val exchangeDataIdByDelegationKey = getExchangeDataMapsAndDecrypt(entitiesGroupId, toSearchWithExchangeDataMap)
		val toSearchDirectlyById = entities.flatMapTo(mutableSetOf()) { e ->
			e.securityMetadata?.secureDelegations?.mapNotNull { (delegationKey, delegation) ->
				if (
					delegation.exchangeDataId != null
					&& (delegation.delegate in dataOwnersHierarchyReferences || delegation.delegator in dataOwnersHierarchyReferences)
					&& !exchangeDataByDelegationKey.containsKey(delegationKey)
					&& secureDelegationFilter(delegation)
				) delegation.exchangeDataId else null
			}.orEmpty()
		}
		val exchangeDataById = (toSearchDirectlyById + exchangeDataIdByDelegationKey.values).takeIf { it.isNotEmpty() }?.let {
			exchangeDataManager.getDecryptionDataByIds(entitiesGroupId, it, true)
		}.orEmpty()
		return LoadedExchangeData(exchangeDataByDelegationKey, exchangeDataIdByDelegationKey, exchangeDataById)
	}

	private class LoadedExchangeData(
		private val exchangeDataByDelegationKey: Map<SecureDelegationKeyString, ExchangeDataWithUnencryptedContent>,
		private val exchangeDataIdByDelegationKey: Map<SecureDelegationKeyString, String>,
		private val exchangeDataById: Map<String, ExchangeDataWithPotentiallyDecryptedContent>,
	) {
		fun getExchangeDataFor(
			delegationKey: SecureDelegationKeyString,
			delegation: SecureDelegation
		): ExchangeDataWithPotentiallyDecryptedContent? =
			exchangeDataByDelegationKey[delegationKey]
				?: delegation.exchangeDataId?.let { exchangeDataById[it] }
				?: exchangeDataIdByDelegationKey[delegationKey]?.let { exchangeDataById[it] }
	}
}