package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.crypto.CryptoStrategies
import com.icure.cardinal.sdk.crypto.ExchangeDataManager
import com.icure.cardinal.sdk.crypto.ExchangeDataMapManager
import com.icure.cardinal.sdk.crypto.SecureDelegationsEncryption
import com.icure.cardinal.sdk.crypto.SecureDelegationsManager
import com.icure.cardinal.sdk.crypto.UserEncryptionKeysManager
import com.icure.cardinal.sdk.crypto.entities.CardinalKeyInfo
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataWithUnencryptedContent
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.crypto.entities.VerifiedRsaEncryptionKeysSet
import com.icure.cardinal.sdk.crypto.entities.toPublicKeyInfo
import com.icure.cardinal.sdk.model.ExchangeDataMapCreationBatch
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.SecureDelegation
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import com.icure.cardinal.sdk.model.requests.EntityShareOrMetadataUpdateRequest
import com.icure.cardinal.sdk.model.requests.EntityShareRequest
import com.icure.cardinal.sdk.model.requests.EntitySharedMetadataUpdateRequest
import com.icure.cardinal.sdk.model.requests.EntryUpdateType
import com.icure.cardinal.sdk.model.requests.RequestedPermission
import com.icure.cardinal.sdk.model.specializations.AccessControlKeyHexString
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.cardinal.sdk.utils.SynchronisedLruCache
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.PublicRsaKey
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.utils.InternalIcureApi

@InternalIcureApi
class SecureDelegationsManagerImpl (
	private val exchangeDataManager: ExchangeDataManager,
	private val exchangeDataMapManager: ExchangeDataMapManager,
	private val secureDelegationsEncryption: SecureDelegationsEncryption,
	private val userKeys: UserEncryptionKeysManager,
	private val cryptoService: CryptoService,
	private val dataOwnerApi: DataOwnerApi,
	private val cryptoStrategies: CryptoStrategies,
	private val boundGroup: SdkBoundGroup?
) : SecureDelegationsManager {
	// Data owner id -> (is anonymous, verified keys if needed)
	private val dataOwnerAnonymityCache = SynchronisedLruCache<
		EntityReferenceInGroup,
		Pair<Boolean, List<CardinalKeyInfo<PublicRsaKey<RsaAlgorithm.RsaEncryptionAlgorithm>>>?>
	>(1000)

	override suspend fun <T : HasEncryptionMetadata> entityWithInitializedEncryptedMetadata(
		entityGroupId: String?,
		entity: T,
		entityType: EntityWithEncryptionMetadataTypeName,
		secretIds: Set<String>,
		owningEntityIds: Set<String>,
		owningEntitySecretIds: Set<String>,
		encryptionKeys: Set<HexString>,
		autoDelegations: Map<EntityReferenceInGroup, AccessLevel>,
		alternateRootDataOwnerReference: EntityReferenceInGroup?
	): T {
		if (userKeys.delegatorActorVerifiedKeys().isEmpty()) { //isKeyless
			require (alternateRootDataOwnerReference != null) {
				"Cannot initialize encrypted metadata without an alternate root delegation when running in keyless mode."
			}
		} else {
			require (alternateRootDataOwnerReference == null) {
				"Cannot specify an alternate root delegation when not running in keyless mode."
			}
		}
		val rootDelegationReference = alternateRootDataOwnerReference ?: EntityReferenceInGroup(userKeys.delegatorActorId(), null)
		val rootDelegationInfo = makeSecureDelegationInfo(
			entityGroupId = entityGroupId,
			entityType = entityType,
			delegateReference = rootDelegationReference,
			shareSecretIds = secretIds,
			shareOwningEntityIds = owningEntityIds,
			shareEncryptionKeys = encryptionKeys,
			permissions = AccessLevel.Write,
			parentDelegationKey = null
		)
		val otherDelegationsInfo = autoDelegations.filterNot { it.key == rootDelegationReference }.map { (delegateId, permissions) ->
			makeSecureDelegationInfo(
				entityGroupId = entityGroupId,
				entityType = entityType,
				delegateReference = delegateId,
				shareSecretIds = secretIds,
				shareOwningEntityIds = owningEntityIds,
				shareEncryptionKeys = encryptionKeys,
				permissions = permissions,
				parentDelegationKey = rootDelegationInfo.canonicalDelegationKey
			)
		}
		exchangeDataMapManager.createExchangeDataMaps(
			entityGroupId,
			ExchangeDataMapCreationBatch(
				(otherDelegationsInfo + rootDelegationInfo).mapNotNull { info -> info.encryptedExchangeDataId?.let { info.canonicalAccessControlKey to it } }.toMap()
			)
		)
		@Suppress("UNCHECKED_CAST")
		return entity.copyWithSecurityMetadata(
			securityMetadata = SecurityMetadata(
				secureDelegations = (listOf(rootDelegationInfo) + otherDelegationsInfo).associate { it.canonicalDelegationKey to it.delegation },
			),
			secretForeignKeys = owningEntitySecretIds.toSet(),
		) as T
	}

	override suspend fun makeShareOrUpdateRequestParams(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		delegate: EntityReferenceInGroup,
		shareSecretIds: Set<String>,
		shareEncryptionKeys: Set<HexString>,
		shareOwningEntityIds: Set<String>,
		newDelegationPermissions: RequestedPermission
	): EntityShareOrMetadataUpdateRequest? {
		val exchangeData = exchangeDataManager.getOrCreateEncryptionDataTo(
			groupId = entityGroupId,
			delegateReference = delegate,
			allowCreationWithoutDelegateKey = false,
			allowCreationWithoutDelegatorKey = false
		)
		val accessControlKey = exchangeData.unencryptedContent.accessControlSecret.toAccessControlKeyStringFor(
			entityType,
			cryptoService
		)
		val secureDelegationKey = accessControlKey.toSecureDelegationKeyString(cryptoService)
		val existingDelegation = entity.securityMetadata?.secureDelegations?.get(secureDelegationKey)
		return if (existingDelegation != null) {
			makeUpdateRequestParams(
				canonicalKey = secureDelegationKey,
				existingDelegation = existingDelegation,
				exchangeDataInfo = exchangeData,
				shareSecretIds = shareSecretIds,
				shareEncryptionKeys = shareEncryptionKeys,
				shareOwningEntityIds = shareOwningEntityIds
			)?.wrap()
		} else {
			makeShareRequestParams(
				exchangeDataInfo = exchangeData,
				accessControlKey = accessControlKey,
				delegate = delegate,
				shareSecretIds = shareSecretIds,
				shareEncryptionKeys = shareEncryptionKeys,
				shareOwningEntityIds = shareOwningEntityIds,
				newDelegationPermissions = newDelegationPermissions,
				entityGroupId = entityGroupId
			).wrap()
		}
	}

	override suspend fun clearCachedDataOwnersInfo() {
		dataOwnerAnonymityCache.clear()
	}

	private suspend fun makeSecureDelegationInfo(
		entityGroupId: String?,
		entityType: EntityWithEncryptionMetadataTypeName,
		delegateReference: EntityReferenceInGroup,
		shareSecretIds: Set<String>,
		shareEncryptionKeys: Set<HexString>,
		shareOwningEntityIds: Set<String>,
		permissions: AccessLevel,
		parentDelegationKey: SecureDelegationKeyString?
	): SecureDelegationInfo {
		val exchangeDataInfo = exchangeDataManager.getOrCreateEncryptionDataTo(
			groupId = entityGroupId,
			delegateReference = delegateReference,
			allowCreationWithoutDelegateKey = false,
			allowCreationWithoutDelegatorKey = false
		)
		val accessControlKey = exchangeDataInfo.unencryptedContent.accessControlSecret.toAccessControlKeyStringFor(
			entityType,
			cryptoService
		)
		val secureDelegationKey = accessControlKey.toSecureDelegationKeyString(cryptoService)
		val encryptedDelegationInfo = makeSecureDelegationEncryptedData(
			exchangeDataInfo = exchangeDataInfo,
			delegate = delegateReference,
			shareSecretIds = shareSecretIds,
			shareEncryptionKeys = shareEncryptionKeys,
			shareOwningEntityIds = shareOwningEntityIds,
			entityGroupId = entityGroupId
		)
		val delegation = SecureDelegation(
			delegator = encryptedDelegationInfo.idInfo.explicitDelegator,
			delegate = encryptedDelegationInfo.idInfo.explicitDelegate,
			secretIds = encryptedDelegationInfo.secretIds,
			encryptionKeys = encryptedDelegationInfo.encryptionKeys,
			owningEntityIds = encryptedDelegationInfo.owningEntityIds,
			parentDelegations = setOfNotNull(parentDelegationKey),
			exchangeDataId = encryptedDelegationInfo.idInfo.exchangeDataId,
			permissions = permissions
		)
		return SecureDelegationInfo(
			canonicalDelegationKey = secureDelegationKey,
			canonicalAccessControlKey = accessControlKey,
			delegation = delegation,
			encryptedExchangeDataId = encryptedDelegationInfo.idInfo.encryptedExchangeDataId
		)
	}

	private suspend fun makeUpdateRequestParams(
		canonicalKey: SecureDelegationKeyString,
		existingDelegation: SecureDelegation,
		exchangeDataInfo: ExchangeDataWithUnencryptedContent,
		shareSecretIds: Set<String>,
		shareEncryptionKeys: Set<HexString>,
		shareOwningEntityIds: Set<String>
	): EntitySharedMetadataUpdateRequest? {
		val existingSecretIds = secureDelegationsEncryption.decryptSecretIds(existingDelegation, exchangeDataInfo.unencryptedContent.exchangeKey)
		val existingEncryptionKeys = secureDelegationsEncryption.decryptEncryptionKeys(existingDelegation, exchangeDataInfo.unencryptedContent.exchangeKey)
		val existingOwningEntityIds = secureDelegationsEncryption.decryptOwningEntityIds(existingDelegation, exchangeDataInfo.unencryptedContent.exchangeKey)

		val newSecretIds = shareSecretIds.filterTo(mutableSetOf()) { !existingSecretIds.contains(it) }
		val newEncryptionKeys = shareEncryptionKeys.filterTo(mutableSetOf()) { !existingEncryptionKeys.contains(it) }
		val newOwningEntityIds = shareOwningEntityIds.filterTo(mutableSetOf()) { !existingOwningEntityIds.contains(it) }

		return if (newSecretIds.isNotEmpty() || newEncryptionKeys.isNotEmpty() || newOwningEntityIds.isNotEmpty()) {
			val encryptedNewSecretIds = secureDelegationsEncryption.encryptSecretIds(newSecretIds, exchangeDataInfo.unencryptedContent.exchangeKey)
			val encryptedNewEncryptionKeys = secureDelegationsEncryption.encryptEncryptionKeys(newEncryptionKeys, exchangeDataInfo.unencryptedContent.exchangeKey)
			val encryptedNewOwningEntityIds = secureDelegationsEncryption.encryptOwningEntityIds(newOwningEntityIds, exchangeDataInfo.unencryptedContent.exchangeKey)

			EntitySharedMetadataUpdateRequest(
				metadataAccessControlHash = canonicalKey,
				secretIds = encryptedNewSecretIds.associateWith { EntryUpdateType.Create },
				encryptionKeys = encryptedNewEncryptionKeys.associateWith { EntryUpdateType.Create },
				owningEntityIds = encryptedNewOwningEntityIds.associateWith { EntryUpdateType.Create }
			)
		} else null
	}

	private suspend fun makeShareRequestParams(
		entityGroupId: String?,
		exchangeDataInfo: ExchangeDataWithUnencryptedContent,
		accessControlKey: AccessControlKeyHexString,
		delegate: EntityReferenceInGroup,
		shareSecretIds: Set<String>,
		shareEncryptionKeys: Set<HexString>,
		shareOwningEntityIds: Set<String>,
		newDelegationPermissions: RequestedPermission
	): EntityShareRequest {
		val secureDelegationInfo = makeSecureDelegationEncryptedData(
			entityGroupId,
			exchangeDataInfo,
			delegate,
			shareSecretIds,
			shareEncryptionKeys,
			shareOwningEntityIds
		)
		return EntityShareRequest(
			explicitDelegator = secureDelegationInfo.idInfo.explicitDelegator,
			explicitDelegate = secureDelegationInfo.idInfo.explicitDelegate,
			accessControlKeys = setOf(accessControlKey),
			secretIds = secureDelegationInfo.secretIds,
			encryptionKeys = secureDelegationInfo.encryptionKeys,
			owningEntityIds = secureDelegationInfo.owningEntityIds,
			exchangeDataId = secureDelegationInfo.idInfo.exchangeDataId,
			encryptedExchangeDataId = secureDelegationInfo.idInfo.encryptedExchangeDataId ?: emptyMap(),
			requestedPermissions = newDelegationPermissions,
		)
	}

	private suspend fun makeSecureDelegationEncryptedData(
		entityGroupId: String?,
		exchangeDataInfo: ExchangeDataWithUnencryptedContent,
		delegate: EntityReferenceInGroup,
		shareSecretIds: Set<String>,
		shareEncryptionKeys: Set<HexString>,
		shareOwningEntityIds: Set<String>
	): EncryptedExchangeDataInfo {
		val delegatorReference = EntityReferenceInGroup(this.userKeys.delegatorActorId(), null)
		val exchangeDataIdInfo = if (delegate == delegatorReference) {
			makeExchangeDataIdInfoForEncryptionActor(entityGroupId, delegatorReference, exchangeDataInfo)
		} else {
			makeExchangeDataIdInfoForDelegate(entityGroupId, delegatorReference, delegate, exchangeDataInfo)
		}
		val encryptedSecretIds = secureDelegationsEncryption.encryptSecretIds(shareSecretIds.toSet(), exchangeDataInfo.unencryptedContent.exchangeKey)
		val encryptedEncryptionKeys = secureDelegationsEncryption.encryptEncryptionKeys(shareEncryptionKeys.toSet(), exchangeDataInfo.unencryptedContent.exchangeKey)
		val encryptedOwningEntityIds = secureDelegationsEncryption.encryptOwningEntityIds(shareOwningEntityIds.toSet(), exchangeDataInfo.unencryptedContent.exchangeKey)
		return EncryptedExchangeDataInfo(
			secretIds = encryptedSecretIds,
			encryptionKeys = encryptedEncryptionKeys,
			owningEntityIds = encryptedOwningEntityIds,
			idInfo = exchangeDataIdInfo
		)
	}

	private fun makeExchangeDataIdInfoForEncryptionActor(
		entityGroupId: String?,
		delegatorReference: EntityReferenceInGroup,
		exchangeDataInfo: ExchangeDataWithUnencryptedContent
	): EncryptedExchangeDataIdInfo =
		if (userKeys.delegatorActorIsAnonymous()) {
			EncryptedExchangeDataIdInfo(null, null, null, null)
		} else {
			EncryptedExchangeDataIdInfo(
				explicitDelegator = delegatorReference.asReferenceStringInGroup(entityGroupId, boundGroup),
				explicitDelegate = delegatorReference.asReferenceStringInGroup(entityGroupId, boundGroup),
				exchangeDataId = exchangeDataInfo.exchangeData.id,
				encryptedExchangeDataId = null
			)
		}

	private suspend fun makeExchangeDataIdInfoForDelegate(
		entityGroupId: String?,
		delegatorReference: EntityReferenceInGroup,
		delegateReference: EntityReferenceInGroup,
		verifiedExchangeData: ExchangeDataWithUnencryptedContent
	): EncryptedExchangeDataIdInfo {
		val delegatorActorIsAnonymous = userKeys.delegatorActorIsAnonymous()
		val (delegateIsAnonymous, verifiedDelegateKeys) = dataOwnerAnonymityCache.get(delegateReference) ?: dataOwnerApi.getCryptoActorStubInGroup(delegateReference).let { delegate ->
			val delegateIsAnonymous = cryptoStrategies.dataOwnerRequiresAnonymousDelegation(
				dataOwner = delegate,
				groupId = delegateReference.normalized(boundGroup).groupId
			)
			if (delegatorActorIsAnonymous && !delegateIsAnonymous) {
				// Important: this requires that the exchange data signature also validates the authenticity of the public keys included in there.
				val allDelegateKeys = cryptoService.loadEncryptionKeysForDataOwner(delegate.stub)
				val verifiedExchangeDataFingerprints = verifiedExchangeData.exchangeData.exchangeKey.keys
				val verifiedDelegateKeys = allDelegateKeys.filter { it.pubSpkiHexString.fingerprintV2() in verifiedExchangeDataFingerprints }
				Pair(delegateIsAnonymous, verifiedDelegateKeys).also { dataOwnerAnonymityCache.set(delegateReference, it) }
			} else Pair(delegateIsAnonymous, null)
		}
		return when {
			!delegateIsAnonymous && !delegatorActorIsAnonymous ->
				EncryptedExchangeDataIdInfo(
					explicitDelegator = delegatorReference.asReferenceStringInGroup(entityGroupId, boundGroup),
					explicitDelegate = delegateReference.asReferenceStringInGroup(entityGroupId, boundGroup),
					exchangeDataId = verifiedExchangeData.exchangeData.id,
					encryptedExchangeDataId = null
				)
			delegateIsAnonymous && !delegatorActorIsAnonymous ->
				EncryptedExchangeDataIdInfo(
					explicitDelegator = delegatorReference.asReferenceStringInGroup(entityGroupId, boundGroup),
					explicitDelegate = null,
					exchangeDataId = null,
					encryptedExchangeDataId = secureDelegationsEncryption.encryptExchangeDataId(
						verifiedExchangeData.exchangeData.id,
						VerifiedRsaEncryptionKeysSet(
							userKeys.delegatorActorVerifiedKeys().also {
								check(it.isNotEmpty()) {
									"Keyless mode doesn't support sharing from explicit delegator to anonymous delegate."
								}
							}.map {
								it.toPublicKeyInfo()
							}
						)
					)
				)
			!delegateIsAnonymous && delegatorActorIsAnonymous ->
				EncryptedExchangeDataIdInfo(
					explicitDelegator = null,
					explicitDelegate = delegateReference.asReferenceStringInGroup(entityGroupId, boundGroup),
					exchangeDataId = null,
					encryptedExchangeDataId = secureDelegationsEncryption.encryptExchangeDataId(
						verifiedExchangeData.exchangeData.id,
						VerifiedRsaEncryptionKeysSet(ensureNonNull(verifiedDelegateKeys) {
							"Didn't cache / load verified encryption keys for explicit delegate as anonymous delegator"
						})
					)
				)
			else -> //Both anonymous
				EncryptedExchangeDataIdInfo(
					explicitDelegator = null,
					explicitDelegate = null,
					exchangeDataId = null,
					encryptedExchangeDataId = null
				)
		}
	}

	data class EncryptedExchangeDataInfo(
		val secretIds: Set<Base64String>,
		val encryptionKeys: Set<Base64String>,
		val owningEntityIds: Set<Base64String>,
		val idInfo: EncryptedExchangeDataIdInfo
	)

	data class EncryptedExchangeDataIdInfo(
		val explicitDelegator: String?,
		val explicitDelegate: String?,
		val exchangeDataId: String?,
		val encryptedExchangeDataId: Map<KeypairFingerprintV2String, Base64String>?,
	)

	data class SecureDelegationInfo(
		val canonicalDelegationKey: SecureDelegationKeyString,
		val canonicalAccessControlKey: AccessControlKeyHexString,
		val delegation: SecureDelegation,
		val encryptedExchangeDataId: Map<KeypairFingerprintV2String, Base64String>?
	)
}
