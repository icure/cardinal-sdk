package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.crypto.BaseExchangeDataManager
import com.icure.cardinal.sdk.crypto.CryptoStrategies
import com.icure.cardinal.sdk.crypto.ExchangeDataManager
import com.icure.cardinal.sdk.crypto.UserEncryptionKeysManager
import com.icure.cardinal.sdk.crypto.entities.CardinalKeyInfo
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
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
import com.icure.cardinal.sdk.model.ExchangeData
import com.icure.cardinal.sdk.model.extensions.algorithmOfEncryptionKey
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.kryptom.crypto.CryptoService
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
	protected val useParentKeys: Boolean,
	protected val sdkScope: CoroutineScope,
	protected val sdkBoundGroup: SdkBoundGroup?
) : ExchangeDataManager {
	// TODO No limit to the amount of groupBoundManagers, currently should be fine for most applications
	@Volatile
	private var groupBoundManagers: Map<String?, AbstractExchangeDataManagerInGroup> = mapOf()
	private val createMutex = Mutex()

	override suspend fun giveAccessBackTo(otherDataOwner: String, newDataOwnerPublicKey: SpkiHexString) {
		val self = dataOwnerApi.getCurrentDataOwnerId()
		val other = dataOwnerApi.getCryptoActorStub(otherDataOwner)
		val importedNewKey = cryptoService.rsa.loadPublicKeySpki(
			other.stub.algorithmOfEncryptionKey(newDataOwnerPublicKey),
			newDataOwnerPublicKey.bytes()
		)
		val decryptionKeys = userEncryptionKeys.getDecryptionKeys(true)
		val allExchangeDataToUpdate = if (self == otherDataOwner) {
			base.getExchangeDataByDelegatorDelegatePair(
				null,
				EntityReferenceInGroup(self),
				EntityReferenceInGroup(self)
			)
		} else {
			base.getExchangeDataByDelegatorDelegatePair(
				null,
				EntityReferenceInGroup(self),
				EntityReferenceInGroup(otherDataOwner)
			) + base.getExchangeDataByDelegatorDelegatePair(
				null,
			 EntityReferenceInGroup(otherDataOwner),
				EntityReferenceInGroup(self)
			)
		}
		// Can improve with batch but there should not be many anyway and it is a rare operation
		allExchangeDataToUpdate.forEach {
			base.tryUpdateExchangeData(
				exchangeData = it,
				decryptionKeys = decryptionKeys,
				newEncryptionKeys = VerifiedRsaEncryptionKeysSet(listOf(CardinalKeyInfo(newDataOwnerPublicKey, importedNewKey))),
				newDelegatorSignatureKeys = SelfVerifiedKeysSet(emptySet()),
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
		allowCreationWithoutDelegateKey: Boolean
	): ExchangeDataWithUnencryptedContent =
		getOrCreateManagerInGroup(groupId).getOrCreateEncryptionDataTo(
			delegateReference,
			allowCreationWithoutDelegateKey
		)

	override suspend fun getCachedDecryptionDataKeyByAccessControlHash(
		groupId: String?,
		hashes: Set<SecureDelegationKeyString>
	): Map<SecureDelegationKeyString, ExchangeDataWithUnencryptedContent> =
		getOrCreateManagerInGroup(groupId).getCachedDecryptionDataKeyByAccessControlHash(hashes)

	override suspend fun getDecryptionDataByIds(
		groupId: String?,
		ids: Set<String>,
		waitOrRetrieveUncached: Boolean
	): Map<String, ExchangeDataWithPotentiallyDecryptedContent> =
		getOrCreateManagerInGroup(groupId).getDecryptionDataByIds(ids, waitOrRetrieveUncached)

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
		val self = dataOwnerApi.getCurrentDataOwnerId()
		val retrievedExchangeData = base.getExchangeDataByIds(groupId, exchangeDataDetails.map { it.exchangeDataId }.toSet())
		if (retrievedExchangeData.any { it.delegator != self && it.delegate != self }) {
			throw IllegalArgumentException("Should only inject exchange data from/to the current user")
		}
		val exchangeDataById = retrievedExchangeData.associateBy { it.id }

		if (reEncryptWithOwnKeys) {
			val selfVerifiedKeys = userEncryptionKeys.getSelfVerifiedKeys()
			if (selfVerifiedKeys.isEmpty()) throw IllegalStateException("Can't re-encrypt injected exchange data with own keys if in keyless mode")
			val encryptionKeys = VerifiedRsaEncryptionKeysSet(selfVerifiedKeys.map { k -> CardinalKeyInfo(k.pubSpkiHexString, k.toPublicKeyInfo().key) })
			val signatureKeys = SelfVerifiedKeysSet(selfVerifiedKeys.map { k -> CardinalKeyInfo(k.pubSpkiHexString, k.toPrivateKeyInfo().key) })
			exchangeDataDetails.forEach { details ->
				val exchangeData = exchangeDataById[details.exchangeDataId]
				if (exchangeData != null) {
					base.updateExchangeDataWithRawDecryptedContent(
						exchangeData = exchangeData,
						newEncryptionKeys = encryptionKeys,
						newDelegatorSignatureKeys = if (exchangeData.delegator == self && details.verified) signatureKeys else SelfVerifiedKeysSet(emptySet()),
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
	private val userEncryptionKeys: UserEncryptionKeysManager,
	private val cryptoStrategies: CryptoStrategies,
	protected val dataOwnerApi: DataOwnerApi,
	protected val cryptoService: CryptoService,
	private val useParentKeys: Boolean,
	protected val sdkBoundGroup: SdkBoundGroup?,
	protected val requestGroup: String?
) {
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
		val decryptionKeys = userEncryptionKeys.getDecryptionKeys(true)

		val decryptedExchangeKeyResult = base.tryDecryptExchangeKeys(listOf(data), decryptionKeys)
		val decryptedExchangeKey = decryptedExchangeKeyResult.successfulDecryptions.firstOrNull()
			?: return null

		val decryptedAccessControlSecretResult = base.tryDecryptAccessControlSecret(listOf(data), decryptionKeys)
		val decryptedAccessControlSecret = decryptedAccessControlSecretResult.successfulDecryptions.firstOrNull()
			?: throw Exception("Decryption key could be decrypted but access control secret could not for data $data")

		val decryptedSharedSignatureKeyResult = base.tryDecryptSharedSignatureKeys(listOf(data), decryptionKeys)
		val decryptedSharedSignatureKey = decryptedSharedSignatureKeyResult.successfulDecryptions.firstOrNull()
			?: throw Exception("Decryption key could be decrypted but shared signature key could not for data $data")
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
			SelfVerifiedKeysSet(userEncryptionKeys.getSelfVerifiedKeys().map { it.toPrivateKeyInfo() }),
			true
		)
		return Pair(
			unencryptedContent,
			verified
		)
	}

	protected suspend fun createNewExchangeData(
		delegateReference: EntityReferenceInGroup,
		newDataId: String?,
		allowNoDelegateKeys: Boolean
	): ExchangeDataWithUnencryptedContent {
		val selfEncryptionKeys = userEncryptionKeys.getSelfVerifiedKeys().map { it.toPublicKeyInfo() }
		val verifiedDelegateKeys = if (delegateReference != dataOwnerApi.getCurrentDataOwnerReference()) {
			val delegate =
				dataOwnerApi.getCryptoActorStubInGroup(delegateReference)
			val delegateKeys = cryptoService.loadEncryptionKeysForDataOwner(delegate.stub)
			if (delegateKeys.isEmpty()) {
				require(allowNoDelegateKeys) { "Delegate $delegateReference has no public keys and the current operation does not allow for creation of exchange data without any delegate keys." }
				emptyList()
			} else {
				val delegateKeysBySpki = delegateKeys.associateBy { it.pubSpkiHexString }
				val verifiedSpki = if (useParentKeys && delegateReference in dataOwnerApi.getCurrentDataOwnerHierarchyIdsReference()) {
					userEncryptionKeys.getVerifiedPublicKeysFor(delegate.stub).filter { delegateKeysBySpki.containsKey(it) }
				} else {
					cryptoStrategies.verifyDelegatePublicKeys(
						delegate = delegate,
						publicKeys = delegateKeys.map { it.pubSpkiHexString },
						cryptoPrimitives = cryptoService,
						groupId = delegateReference.normalized(sdkBoundGroup).groupId
					)
				}
				require (allowNoDelegateKeys || verifiedSpki.isNotEmpty()) {
					"Could not create exchange data to $delegateReference as no public key for the delegate could be verified."
				}
				verifiedSpki.map {
					requireNotNull(delegateKeysBySpki[it]) {
						"Key $it was marked as verified but is not a key of data owner ${delegate.stub.id}"
					}
				}
			}
		} else emptyList()
		val allEncryptionKeys = VerifiedRsaEncryptionKeysSet(selfEncryptionKeys + verifiedDelegateKeys)
		return base.createExchangeData(
			requestGroup,
			delegateReference,
			SelfVerifiedKeysSet(userEncryptionKeys.getSelfVerifiedKeys().map { it.toPrivateKeyInfo() }),
			allEncryptionKeys,
			newDataId
		)
	}

	abstract suspend fun getOrCreateEncryptionDataTo(
		delegateReference: EntityReferenceInGroup,
		allowCreationWithoutDelegateKey: Boolean,
	): ExchangeDataWithUnencryptedContent
	abstract suspend fun getCachedDecryptionDataKeyByAccessControlHash(
		hashes: Set<SecureDelegationKeyString>,
	): Map<SecureDelegationKeyString, ExchangeDataWithUnencryptedContent>
	abstract suspend fun getDecryptionDataByIds(
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
