package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.crypto.BaseExchangeDataManager
import com.icure.cardinal.sdk.crypto.CryptoStrategies
import com.icure.cardinal.sdk.crypto.ExchangeDataManager
import com.icure.cardinal.sdk.crypto.UserEncryptionKeysManager
import com.icure.cardinal.sdk.crypto.entities.CardinalKeyInfo
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataInjectionDetails
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataWithPotentiallyDecryptedContent
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataWithUnencryptedContent
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.crypto.entities.SelfVerifiedKeysSet
import com.icure.cardinal.sdk.crypto.entities.UnencryptedExchangeDataContent
import com.icure.cardinal.sdk.crypto.entities.VerifiedRsaEncryptionKeysSet
import com.icure.cardinal.sdk.crypto.entities.resolve
import com.icure.cardinal.sdk.crypto.entities.toPrivateKeyInfo
import com.icure.cardinal.sdk.crypto.entities.toPublicKeyInfo
import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.ExchangeData
import com.icure.cardinal.sdk.model.base.DataOwnerGroupLinkType
import com.icure.cardinal.sdk.model.extensions.algorithmOfEncryptionKey
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.utils.ensure
import com.icure.cardinal.sdk.utils.getLogger
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.PublicRsaKey
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.concurrent.Volatile

@InternalIcureApi
abstract class AbstractExchangeDataManager(
	override val base: BaseExchangeDataManager,
	protected val userEncryptionKeys: UserEncryptionKeysManager,
	protected val cryptoStrategies: CryptoStrategies,
	protected val dataOwnerApi: DataOwnerApi,
	protected val cryptoService: CryptoService,
	protected val sdkScope: CoroutineScope,
	protected val sdkBoundGroup: SdkBoundGroup?
) : ExchangeDataManager {
	// TODO No limit to the amount of groupBoundManagers, currently should be fine for most applications
	@Volatile
	private var groupBoundManagers: Map<String?, AbstractExchangeDataManagerInGroup> = mapOf()
	private val createMutex = Mutex()

	override suspend fun giveAccessBackTo(otherDataOwner: String, newDataOwnerPublicKey: SpkiHexString) {
		// TODO we are also using parent key for decryption, but we are only getting exchange data between self and other; should we allow also getting exchange data between parent and other?
		val self = dataOwnerApi.getCurrentDataOwnerId()
		val other = dataOwnerApi.getCryptoActorStub(otherDataOwner)
		val importedNewKey = cryptoService.rsa.loadPublicKeySpki(
			other.stub.algorithmOfEncryptionKey(newDataOwnerPublicKey),
			newDataOwnerPublicKey.bytes()
		)
		val decryptionKeys = userEncryptionKeys.getAllDecryptionKeys()
		val acceptedRecipients = userEncryptionKeys.delegatorActorParentHierarchy()
			.flattened(setOf(DataOwnerGroupLinkType.Parent))
			.mapTo(mutableSetOf()) { EntityReferenceInGroup(it, null) }
		val allExchangeDataToUpdate = if (self == otherDataOwner) {
			base.getExchangeDataByDelegatorDelegatePair(
				null,
				EntityReferenceInGroup(self),
				EntityReferenceInGroup(self),
				acceptedRecipients,
			)
		} else {
			base.getExchangeDataByDelegatorDelegatePair(
				null,
				EntityReferenceInGroup(self),
				EntityReferenceInGroup(otherDataOwner),
				acceptedRecipients,
			) + base.getExchangeDataByDelegatorDelegatePair(
				null,
				EntityReferenceInGroup(otherDataOwner),
				EntityReferenceInGroup(self),
				acceptedRecipients,
			)
		}
		// Can improve with batch but there should not be many anyway and it is a rare operation
		allExchangeDataToUpdate.forEach {
			base.tryUpdateExchangeData(
				exchangeData = it,
				decryptionKeys = decryptionKeys,
				newEncryptionKeys = VerifiedRsaEncryptionKeysSet(listOf(CardinalKeyInfo(newDataOwnerPublicKey, importedNewKey))),
				delegatorSignatureKeys = null,
			)
		}
	}

	override suspend fun clearOrRepopulateCache() =
		createMutex.withLock {
			groupBoundManagers.also {
				// Always pre-emptively start loading of keys for this group; they will always be used
				groupBoundManagers = mapOf(null to createManagerForGroup(null))
			}
		}.values.forEach { it.dispose() }

	override suspend fun getOrCreateEncryptionDataTo(
		groupId: String?,
		delegateReference: EntityReferenceInGroup,
		allowCreationWithoutDelegateKey: Boolean,
		allowCreationWithoutDelegatorKey: Boolean
	): ExchangeDataWithUnencryptedContent =
		getOrCreateManagerInGroup(groupId).getOrCreateEncryptionDataTo(
			delegateReference,
			allowCreationWithoutDelegateKey,
			allowCreationWithoutDelegatorKey
		)

	override suspend fun getCachedDecryptionDataKeyByAccessControlHash(
		groupId: String?,
		hashes: Set<SecureDelegationKeyString>
	): Map<SecureDelegationKeyString, ExchangeDataWithUnencryptedContent> =
		getOrCreateManagerInGroup(groupId).getCachedDecryptionDataKeyByAccessControlHash(hashes)

	override suspend fun getDecryptionDataByExchangeDataGroupIds(
		groupId: String?,
		ids: Set<String>,
		waitOrRetrieveUncached: Boolean
	): Map<String, ExchangeDataWithPotentiallyDecryptedContent> =
		getOrCreateManagerInGroup(groupId).getDecryptionDataByExchangeDataGroupIds(ids, waitOrRetrieveUncached)

	override suspend fun getEncodedAccessControlKeysValue(
		groupId: String?,
		entityType: EntityWithEncryptionMetadataTypeName
	): List<Base64String>? =
		getOrCreateManagerInGroup(groupId).getEncodedAccessControlKeysValue(entityType)

	override suspend fun injectDecryptedExchangeData(
		groupId: String?,
		exchangeDataDetails: List<ExchangeDataInjectionDetails>,
		reEncryptWithOwnKeys: Boolean,
	) {
		val selfReference = dataOwnerApi.getCurrentDataOwnerReference()
		val self = selfReference.asReferenceStringInGroup(groupId, sdkBoundGroup)
		val retrievedExchangeData = base.getExchangeDataByIds(
			groupId,
			exchangeDataDetails.mapTo(mutableSetOf()) { it.exchangeDataId }
		)
		if (retrievedExchangeData.any { it.delegator != self && it.delegate != self }) {
			throw IllegalArgumentException("Should only inject exchange data from/to the current user")
		}
		val exchangeDataById = retrievedExchangeData.associateBy { it.id }

		if (reEncryptWithOwnKeys) {
			if (userEncryptionKeys.delegatorActorId() != selfReference.entityId) throw UnsupportedOperationException(
				"Currently re-encryption of injected exchange data is not supported in ParentDelegator mode" // TODO is there a case for supporting this?
			)
			val selfVerifiedKeys = userEncryptionKeys.delegatorActorVerifiedKeys()
			check(selfVerifiedKeys.isNotEmpty()) { "Can't re-encrypt injected exchange data with own keys if in keyless mode" }

			val encryptionKeys = VerifiedRsaEncryptionKeysSet(selfVerifiedKeys.map { k -> CardinalKeyInfo(k.pubSpkiHexString, k.toPublicKeyInfo().key) })
			val signatureKeys = SelfVerifiedKeysSet(selfVerifiedKeys.map { k -> CardinalKeyInfo(k.pubSpkiHexString, k.toPrivateKeyInfo().key) })
			exchangeDataDetails.forEach { details ->
				val exchangeData = exchangeDataById[details.exchangeDataId]
				if (exchangeData != null) {
					base.updateExchangeDataWithRawDecryptedContent(
						exchangeData = exchangeData,
						newEncryptionKeys = encryptionKeys,
						delegatorSignatureKeys =
							if (details.verified) Pair(
								EntityReferenceInGroup(userEncryptionKeys.delegatorActorId(), null),
								signatureKeys
							) else null,
						rawExchangeKey = details.exchangeKey,
						rawAccessControlSecret = details.accessControlSecret,
						rawSharedSignatureKey = details.sharedSignatureKey,
					)
				}
			}
		}

		exchangeDataDetails.mapNotNull { details ->
			exchangeDataById[details.exchangeDataId]?.let { exchangeData ->
				ExchangeDataWithUnencryptedContent(
					exchangeData = exchangeData,
					unencryptedContent = UnencryptedExchangeDataContent(
						accessControlSecret = base.importAccessControlSecret(details.accessControlSecret),
						exchangeKey = base.importExchangeKey(details.exchangeKey),
						sharedSignatureKey = base.importSharedSignatureKey(details.sharedSignatureKey)
					)
				) to details.verified
			}
		}.also { importedDetails ->
			if (importedDetails.isNotEmpty()) { getOrCreateManagerInGroup(groupId).cacheInjectedExchangeData(importedDetails) }
		}
	}

	private suspend fun getOrCreateManagerInGroup(groupId: String?): AbstractExchangeDataManagerInGroup {
		val normalizedGroupId = sdkBoundGroup.resolve(groupId)
		return groupBoundManagers[normalizedGroupId] ?: createMutex.withLock {
			groupBoundManagers[normalizedGroupId] ?: createManagerForGroup(normalizedGroupId).also {
				groupBoundManagers += normalizedGroupId to it
			}
		}
	}

	protected abstract fun createManagerForGroup(groupId: String?): AbstractExchangeDataManagerInGroup
}

@InternalIcureApi
abstract class AbstractExchangeDataManagerInGroup(
	protected val base: BaseExchangeDataManager,
	protected val userEncryptionKeys: UserEncryptionKeysManager,
	private val cryptoStrategies: CryptoStrategies,
	protected val dataOwnerApi: DataOwnerApi,
	protected val cryptoService: CryptoService,
	protected val sdkBoundGroup: SdkBoundGroup?,
	protected val requestGroup: String?
) {
	private val log = getLogger("AbstractExchangeDataManager")

	protected data class CachedExchangeDataDetails(
		val exchangeData: ExchangeData,
		val decryptedDetails: CachedDecryptedDetails?
	)

	protected data class CachedDecryptedDetails(
		val decryptedContent: UnencryptedExchangeDataContent,
		val verified: Boolean,
		val secureDelegationKeys: Set<SecureDelegationKeyString>
	)

	protected suspend fun decryptData(
		data: ExchangeData
	): Pair<UnencryptedExchangeDataContent, Boolean>? {
		val decryptionKeys = userEncryptionKeys.getAllDecryptionKeys()

		val decryptedExchangeKeyResult = base.tryDecryptExchangeKeys(listOf(data), decryptionKeys)
		val decryptedExchangeKey = decryptedExchangeKeyResult.successfulDecryptions.firstOrNull()
			?: return null

		val decryptedAccessControlSecretResult = base.tryDecryptAccessControlSecret(listOf(data), decryptionKeys)
		val decryptedAccessControlSecret = decryptedAccessControlSecretResult.successfulDecryptions.firstOrNull()
			?: throw IllegalStateException("Decryption key could be decrypted but access control secret could not for data $data")

		val decryptedSharedSignatureKeyResult = base.tryDecryptSharedSignatureKeys(listOf(data), decryptionKeys)
		val decryptedSharedSignatureKey = decryptedSharedSignatureKeyResult.successfulDecryptions.firstOrNull()
			?: throw IllegalStateException("Decryption key could be decrypted but shared signature key could not for data $data")
		val unencryptedContent = UnencryptedExchangeDataContent(
			accessControlSecret = decryptedAccessControlSecret,
			exchangeKey = decryptedExchangeKey,
			sharedSignatureKey = decryptedSharedSignatureKey
		)
		val verified = base.verifyExchangeData(
			ExchangeDataWithUnencryptedContent(
				exchangeData = data,
				unencryptedContent = unencryptedContent
			),
			SelfVerifiedKeysSet(userEncryptionKeys.delegatorActorVerifiedKeys().map { it.toPrivateKeyInfo() }),
			userEncryptionKeys.delegatorActorId()
		)
		return Pair(
			unencryptedContent,
			verified
		)
	}

	protected suspend fun createNewExchangeData(
		delegateReference: EntityReferenceInGroup,
		allowCreationWithoutDelegateKey: Boolean,
		allowCreationWithoutDelegatorKey: Boolean,
	): ExchangeDataWithUnencryptedContent {
		ensure(!allowCreationWithoutDelegateKey || !allowCreationWithoutDelegatorKey) { "Cannot allow creation of exchange data without both delegate and delegator keys." }
		val delegatorEncryptionKeys = userEncryptionKeys.delegatorActorVerifiedKeys().map { it.toPublicKeyInfo() }
		if (delegatorEncryptionKeys.isEmpty()) {
			check(allowCreationWithoutDelegatorKey) {
				"Can't delegate to ${delegateReference}. If the sdk is initialized in keyless mode you must create exchange data to each delegate explicitly. Please use CardinalSdk.crypto.keylessCreateExchangeDataTo or CardinalSdk.crypto.injectExchangeData."
			}
		}
		val delegatorSignatureKeys = SelfVerifiedKeysSet(userEncryptionKeys.delegatorActorVerifiedKeys().map { it.toPrivateKeyInfo() })
		val delegatorReference = EntityReferenceInGroup(userEncryptionKeys.delegatorActorId(), null)
		return if (delegateReference != EntityReferenceInGroup(userEncryptionKeys.delegatorActorId(), null)) {
			val delegate = dataOwnerApi.getCryptoActorStubInGroup(delegateReference)
			if (delegate.stub.groupLinkType == DataOwnerGroupLinkType.Simple) {
				createNewExchangeDataToSimpleGroup(
					simpleDataOwnerGroup = delegate,
					simpleGroupReference = delegateReference,
					delegatorEncryptionKeys = delegatorEncryptionKeys,
					delegatorReference = delegatorReference,
					delegatorSignatureKeys = delegatorSignatureKeys,
				)
			} else {
				createNewExchangeDataToStandardDelegate(
					delegate = delegate,
					delegateReference = delegateReference,
					allowCreationWithoutDelegateKey = allowCreationWithoutDelegateKey,
					delegatorEncryptionKeys = delegatorEncryptionKeys,
					delegatorReference = delegatorReference,
					delegatorSignatureKeys = delegatorSignatureKeys,
				)
			}
		} else {
			base.createExchangeData(
				requestGroup,
				delegatorReference,
				delegateReference,
				delegatorSignatureKeys,
				VerifiedRsaEncryptionKeysSet(delegatorEncryptionKeys),
				null
			)
		}
	}

	private suspend fun createNewExchangeDataToSimpleGroup(
		simpleDataOwnerGroup: CryptoActorStubWithType,
		simpleGroupReference: EntityReferenceInGroup,
		delegatorEncryptionKeys: List<CardinalKeyInfo<PublicRsaKey<RsaAlgorithm.RsaEncryptionAlgorithm>>>,
		delegatorReference: EntityReferenceInGroup,
		delegatorSignatureKeys: SelfVerifiedKeysSet,
	): ExchangeDataWithUnencryptedContent {
		check(delegatorEncryptionKeys.isNotEmpty()) {
			"It is not allowed to create exchange data in keyless mode to a simple-type group (attempting to create exchange data to ${simpleGroupReference.asReferenceStringInGroup(null, sdkBoundGroup)})."
		}
		if (userEncryptionKeys.delegatorActorIsAnonymous()) throw UnsupportedOperationException(
			"Cannot create exchange data to a simple-type group as an anonymous delegator."
		)
		log.d {
			"Loading simple data owner group members for ${simpleDataOwnerGroup.stub.id}"
		}
		val groupMembers = dataOwnerApi.getSimpleGroupDelegateMembersIds(
			dataOwnerGroup = simpleDataOwnerGroup,
			groupId = simpleGroupReference.groupId
		)
		log.d {
			"Loaded ${groupMembers.size} members."
		}
		log.d {
			"Loading delegates public keys ${simpleDataOwnerGroup.stub.id}"
		}
		val publicKeysByDelegate = cryptoStrategies.getDelegatesPublicKeys(
			delegates = groupMembers,
			groupId = simpleGroupReference.groupId
		) ?: dataOwnerApi.getDataOwnersPublicKeys(
			dataOwnerType = simpleDataOwnerGroup.type,
			dataOwners = groupMembers,
			groupId = simpleGroupReference.groupId
		)
		log.d {
			"Loaded ${publicKeysByDelegate.values.sumOf { it.size }} public keys for ${publicKeysByDelegate.size} delegates."
		}
		val loadedPublicKeysByDelegate = publicKeysByDelegate.map { (plainDelegateId, keys) ->
			Pair(
				EntityReferenceInGroup(entityId = plainDelegateId, groupId = simpleGroupReference.groupId),
				VerifiedRsaEncryptionKeysSet(
					keys.map { k ->
						CardinalKeyInfo(
							pubSpkiHexString = k.key,
							key = cryptoService.rsa.loadPublicKeySpki(k.value, k.key.bytes()),
						)
					}
				)
			)
		}.toMap()
		groupMembers.forEach { currMember ->
			check (loadedPublicKeysByDelegate[EntityReferenceInGroup(entityId = currMember, groupId = simpleGroupReference.groupId)].let { it != null && it.isNotEmpty() }) {
				// Probably approach is too conservative, might be good to ignore empty, but for now keeping it safe
				"Could not find a valid public key for delegate $currMember of simple-type data owner group ${simpleGroupReference.groupId}"
			}
		}
		return base.createSimpleGroupExchangeDataAndGetMasterPiece(
			inGroup = requestGroup,
			delegatorReference = delegatorReference,
			delegateReference = simpleGroupReference,
			signatureKeys = delegatorSignatureKeys,
			delegatorEncryptionKeys = VerifiedRsaEncryptionKeysSet(delegatorEncryptionKeys),
			delegateMembersEncryptionKeys = loadedPublicKeysByDelegate,
		)
	}

	private suspend fun createNewExchangeDataToStandardDelegate(
		delegate: CryptoActorStubWithType,
		delegateReference: EntityReferenceInGroup,
		allowCreationWithoutDelegateKey: Boolean,
		delegatorEncryptionKeys: List<CardinalKeyInfo<PublicRsaKey<RsaAlgorithm.RsaEncryptionAlgorithm>>>,
		delegatorReference: EntityReferenceInGroup,
		delegatorSignatureKeys: SelfVerifiedKeysSet,
	): ExchangeDataWithUnencryptedContent {
		val delegateKeys = cryptoService.loadEncryptionKeysForDataOwner(delegate.stub)
		val verifiedDelegateKeys = if (delegateKeys.isEmpty()) {
			require(allowCreationWithoutDelegateKey) { "Delegate $delegateReference has no public keys and the current operation does not allow for creation of exchange data without any delegate keys." }
			emptyList()
		} else {
			val delegateKeysBySpki = delegateKeys.associateBy { it.pubSpkiHexString }
			require(allowCreationWithoutDelegateKey || delegateKeysBySpki.isNotEmpty()) {
				"Could not create exchange data to $delegateReference as the delegate has no public key."
			}
			val verifiedSpki =
				if (
					delegateReference.normalized(sdkBoundGroup).groupId == null &&
					delegateReference.entityId in userEncryptionKeys.delegatorActorParentHierarchy()
				) {
					userEncryptionKeys.getVerifiedPublicKeysFor(delegate.stub)
						.filter { delegateKeysBySpki.containsKey(it) }
				} else {
					cryptoStrategies.verifyDelegatePublicKeys(
						delegate = delegate,
						publicKeys = delegateKeys.map { it.pubSpkiHexString },
						cryptoPrimitives = cryptoService,
						groupId = delegateReference.normalized(sdkBoundGroup).groupId
					)
				}
			// Creation to keyless is allowed if allowCreationWithoutDelegateKey true, but creation to user with keys but no verifiable key is not allowed
			require(delegateKeysBySpki.isEmpty() || verifiedSpki.isNotEmpty()) {
				"Could not create exchange data to $delegateReference as no public key for the delegate could be verified."
			}
			verifiedSpki.map {
				requireNotNull(delegateKeysBySpki[it]) {
					"Key $it was marked as verified but is not a key of data owner ${delegate.stub.id}"
				}
			}
		}
		val allEncryptionKeys = VerifiedRsaEncryptionKeysSet(delegatorEncryptionKeys + verifiedDelegateKeys)
		return base.createExchangeData(
			inGroup = requestGroup,
			delegatorReference = delegatorReference,
			delegateReference = delegateReference,
			signatureKeys = delegatorSignatureKeys,
			encryptionKeys = allEncryptionKeys,
			exchangeDataId = null
		)
	}

	abstract suspend fun getOrCreateEncryptionDataTo(
		delegateReference: EntityReferenceInGroup,
		allowCreationWithoutDelegateKey: Boolean,
		allowCreationWithoutDelegatorKey: Boolean,
	): ExchangeDataWithUnencryptedContent
	abstract suspend fun getCachedDecryptionDataKeyByAccessControlHash(
		hashes: Set<SecureDelegationKeyString>,
	): Map<SecureDelegationKeyString, ExchangeDataWithUnencryptedContent>
	abstract suspend fun getDecryptionDataByExchangeDataGroupIds(
		ids: Set<String>,
		waitOrRetrieveUncached: Boolean,
	): Map<String, ExchangeDataWithPotentiallyDecryptedContent>
	abstract suspend fun getEncodedAccessControlKeysValue(
		entityType: EntityWithEncryptionMetadataTypeName
	): List<Base64String>?
	abstract suspend fun cacheInjectedExchangeData(
		exchangeDataDetails: List<Pair<ExchangeDataWithUnencryptedContent, Boolean>>
	)
	abstract fun dispose()
}
