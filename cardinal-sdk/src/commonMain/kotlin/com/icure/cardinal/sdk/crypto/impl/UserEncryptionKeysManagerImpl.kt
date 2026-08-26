package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.crypto.CardinalKeyRecovery
import com.icure.cardinal.sdk.crypto.CryptoStrategies
import com.icure.cardinal.sdk.crypto.KeyPairRecoverer
import com.icure.cardinal.sdk.crypto.RecoveryDataEncryption
import com.icure.cardinal.sdk.crypto.UserEncryptionKeysManager
import com.icure.cardinal.sdk.crypto.entities.CachedKeypairDetails
import com.icure.cardinal.sdk.crypto.entities.CardinalKeyInfo
import com.icure.cardinal.sdk.crypto.entities.DataOwnerParentHierarchyWith
import com.icure.cardinal.sdk.crypto.entities.RsaDecryptionKeysSet
import com.icure.cardinal.sdk.crypto.entities.firstNotNullOfOrNull
import com.icure.cardinal.sdk.crypto.entities.flattenTopmostFirst
import com.icure.cardinal.sdk.crypto.entities.toList
import com.icure.cardinal.sdk.crypto.entities.toParentHierarchyWith
import com.icure.cardinal.sdk.crypto.entities.toPrivateKeyInfo
import com.icure.cardinal.sdk.model.CryptoActorStub
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.base.CryptoActor
import com.icure.cardinal.sdk.model.base.DataOwnerGroupLinkType
import com.icure.cardinal.sdk.model.base.DataOwnerHierarchyInfo
import com.icure.cardinal.sdk.model.extensions.publicKeysWithSha1Spki
import com.icure.cardinal.sdk.model.extensions.publicKeysWithSha256Spki
import com.icure.cardinal.sdk.model.extensions.asStub
import com.icure.cardinal.sdk.model.extensions.publicKeysSpki
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.storage.CardinalStorageFacade
import com.icure.cardinal.sdk.utils.IllegalEntityException
import com.icure.cardinal.sdk.utils.InternalCardinalException
import com.icure.cardinal.sdk.utils.ensure
import com.icure.cardinal.sdk.utils.tryWithLock
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.crypto.RsaService
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.sync.Mutex
import kotlin.concurrent.Volatile

@InternalIcureApi
class UserEncryptionKeysManagerImpl private constructor (
	initialKeyData: KeyData,
	private val keyLoader: KeyLoader,
) : UserEncryptionKeysManager {
	@Volatile // Writes use mutex, but reads do not.
	private var cachedKeyData: KeyData = initialKeyData
	private val cacheWriteMutex: Mutex = Mutex(false)

	/*
	 * The pattern `with (cachedKeyData) { /* whatever */ }` is used to ensure that during the execution of the block
	 * we always use the same instance of `cachedKeyData`.
	 */

	override suspend fun reloadKeys() {
		cacheWriteMutex.tryWithLock {
			val prevData = cachedKeyData
			val (updatedKeys, newKey) = keyLoader.doLoadKeys(
				prevData.parentHierarchyInfo,
				prevData.delegatorActorIsAnonymous,
				NoOpRecoveryFunction
			) { _, _ -> prevData.specialOperationMode ?: throw InternalCardinalException("Shouldn't create new key during key reload") }
			ensure (newKey == null) {
				"New key created during key reload."
			}
			cachedKeyData = updatedKeys
		} ?: throw IllegalStateException("Multiple concurrent requests to reload keys. This is not allowed.")
	}

	override fun getAvailableKeyPairs(): Map<String, List<CachedKeypairDetails>> = with (cachedKeyData) {
		mapOf(
			keys.value.dataOwnerId to keys.value.keysByFingerprint.values.toList(),
		) + keys.links.flattenTopmostFirst().associate { it.dataOwnerId to it.keysByFingerprint.values.toList() }
	}

	override fun getKeyPairForFingerprint(fingerprint: KeypairFingerprintV2String): CachedKeypairDetails? = with (cachedKeyData) {
		keys.firstNotNullOfOrNull { it.keysByFingerprint[fingerprint] }
	}

	override fun delegatorActorId(): String = with (cachedKeyData) {
		alternateEncryptionDataOwnerId ?: keys.value.dataOwnerId
	}

	override fun delegatorActorParentHierarchy(from: String?): DataOwnerHierarchyInfo = with (cachedKeyData) {
		val rootId = from ?: alternateEncryptionDataOwnerId
		if (rootId == null || rootId == parentHierarchyInfo.id) {
			parentHierarchyInfo
		} else {
			parentHierarchyInfo.parentHierarchy(rootId)
		}
	}

	override fun delegatorActorFullHierarchy(): DataOwnerHierarchyInfo = with (cachedKeyData) {
		fullHierarchyInfo
	}

	override fun delegatorActorIsAnonymous(): Boolean = cachedKeyData.delegatorActorIsAnonymous

	override fun delegatorActorVerifiedKeys(): Set<CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>> =
		with (cachedKeyData) {
			delegatorActorKeys.keysByFingerprint.values.filter { it.isSafeForEncryption }.mapTo(mutableSetOf()) { it.keyPair }
		}

	override fun getVerifiedEncryptionKeysForDataOwnerIfInCurrentHierarchy(dataOwnerId: String): Set<CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>? = with (cachedKeyData) {
		keys.firstNotNullOfOrNull { if (it.dataOwnerId == dataOwnerId) it.keysByFingerprint else null }
			?.values?.filter { it.isSafeForEncryption }?.mapTo(mutableSetOf()) { it.keyPair }
	}

	override fun getVerifiedPublicKeysFor(dataOwner: CryptoActorStub): Set<SpkiHexString> = with (cachedKeyData) {
		keys.firstNotNullOfOrNull { if (it.dataOwnerId == dataOwner.id) it.keysByFingerprint else null }
			?.let { keysMap -> keysMap.values.filter { it.isSafeForEncryption }.mapTo(mutableSetOf()) { it.keyPair.pubSpkiHexString } }
			?: throw IllegalArgumentException("Data owner is not part of the current data owner hierarchy")
	}

	override fun getAllDecryptionKeys(): RsaDecryptionKeysSet = with (cachedKeyData) {
		RsaDecryptionKeysSet(
			keys.toList().flatMap { it.keysByFingerprint.values.map { key -> key.keyPair.toPrivateKeyInfo() } }
		)
	}

	override fun getDecryptionKeysForDataOwnerIfInCurrentHierarchy(dataOwnerId: String): RsaDecryptionKeysSet? = with (cachedKeyData) {
		keys.firstNotNullOfOrNull { if (it.dataOwnerId == dataOwnerId) it.keysByFingerprint else null }
			?.values?.map { it.keyPair.toPrivateKeyInfo() }?.let(::RsaDecryptionKeysSet)
	}

	class Factory(
		private val cryptoService: CryptoService,
		private val cryptoStrategies: CryptoStrategies,
		private val dataOwnerApi: DataOwnerApi,
		private val icureStorage: CardinalStorageFacade,
		private val cardinalKeyRecovery: CardinalKeyRecovery,
		private val recoveryDataEncryption: RecoveryDataEncryption,
		private val initializeParentKeys: Boolean
	): UserEncryptionKeysManager.Factory {
		override suspend fun initialize(): UserEncryptionKeysManager.Factory.InitialisationDetails {
			val keyLoader = KeyLoader(
				cryptoService,
				dataOwnerApi,
				icureStorage,
				cardinalKeyRecovery,
				recoveryDataEncryption,
				initializeParentKeys,
				cryptoStrategies
			)
			val (initialKeyData, newKey) = keyLoader.doLoadKeys(
				null,
				null,
				cryptoStrategies::recoverAndVerifySelfHierarchyKeys,
				cryptoStrategies::generateNewKeyForDataOwner,

			)
			val manager =
				UserEncryptionKeysManagerImpl(initialKeyData, keyLoader)
			return UserEncryptionKeysManager.Factory.InitialisationDetails(manager, newKey)
		}

	}
}

@InternalIcureApi
private class LoadedDataOwnerKeys(
	val dataOwnerId: String,
	val keysByFingerprint: Map<KeypairFingerprintV2String, CachedKeypairDetails>
)

@InternalIcureApi
private class KeyData(
	val alternateEncryptionDataOwnerId: String?,
	val delegatorActorIsAnonymous: Boolean,
	// The parent-only hierarchy backing `keys`, as returned by the backend: used to check for changes on reload and
	// to resolve `delegatorActorParentHierarchy`'s `from` parameter.
	val parentHierarchyInfo: DataOwnerHierarchyInfo,
	val fullHierarchyInfo: DataOwnerHierarchyInfo,
	val keys: DataOwnerParentHierarchyWith<LoadedDataOwnerKeys>,
	val specialOperationMode: CryptoStrategies.KeyGenerationRequestResult?
) {
	val delegatorActorKeys: LoadedDataOwnerKeys = if (alternateEncryptionDataOwnerId != null) {
		keys.firstNotNullOfOrNull { if (it.dataOwnerId == alternateEncryptionDataOwnerId) it else null }
			?: throw InternalCardinalException("Alternate encryption data owner id not in keys hierarchy")
	} else {
		keys.value
	}
}


private typealias RecoveryFunction = suspend (
	currentDataOwnerId: String,
	keysData: Map<String, CryptoStrategies.KeyDataRecoveryRequest>,
	cryptoPrimitives: CryptoService,
	keyPairRecoverer: KeyPairRecoverer
) -> Map<String, CryptoStrategies.RecoveredKeyData>
private val NoOpRecoveryFunction: RecoveryFunction = { _, request, _, _ ->
	// Recovery during reload keys does nothing.
	request.keys.associateWith {
		CryptoStrategies.RecoveredKeyData(
			emptyMap(),
			emptyMap()
		)
	}
}
private typealias KeyGenerationFunction = suspend (
	self: DataOwnerWithType,
	cryptoPrimitives: CryptoService
) -> CryptoStrategies.KeyGenerationRequestResult
@InternalIcureApi
private class KeyLoader(
	private val cryptoService: CryptoService,
	private val dataOwnerApi: DataOwnerApi,
	private val icureStorage: CardinalStorageFacade,
	private val cardinalKeyRecovery: CardinalKeyRecovery,
	private val recoveryDataEncryption: RecoveryDataEncryption,
	private val initializeParentKeys: Boolean,
	private val cryptoStrategies: CryptoStrategies
) {

	private fun checkDataOwnerIntegrity(dataOwner: CryptoActor) {
		val keys = dataOwner.publicKeysSpki
		if (keys.distinctBy { it.fingerprintV2() }.size != keys.size) throw IllegalEntityException(
			"Different public keys for ${dataOwner.id} have the same fingerprint; this should not happen in normal circumstances. Please report this error to iCure."
		)
	}

	/*
	 * Process:
	 * 1. Load all keys for each data owner and try to recover any missing keys using iCure recovery.
	 * 2. If some keys are still missing use the user-provided recovery function providing the missing keys information
	 * for ALL data owners at the same time.
	 * 3. If for any non-self data owner there is no key available fail.
	 * 4. If a key for the current data owner
	 */
	suspend fun doLoadKeys(
		expectHierarchyIds: DataOwnerHierarchyInfo?,
		expectDelegatorAnonymity: Boolean?,
		recoverAndVerifySelfHierarchyKeys: RecoveryFunction,
		generateNewKeyForDataOwner: KeyGenerationFunction,
	): Pair<KeyData, CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256>>?> {
		val hierarchy = dataOwnerApi.getCurrentDataOwnerHierarchyInfo()
		val fullHierarchyInfo = if (initializeParentKeys) hierarchy else hierarchy.filterLinks { it.linkType == DataOwnerGroupLinkType.Simple }
		val parentHierarchyInfo = fullHierarchyInfo.filterLinks { it.linkType == DataOwnerGroupLinkType.Parent }
		if (expectHierarchyIds != null) {
			check(parentHierarchyInfo == expectHierarchyIds) {
				"Data owner hierarchy changed during key reload, aborting. You need to re-initialize the entire SDK to reflect data owner hierarchy changes."
			}
		}
		val allIds = parentHierarchyInfo.flattened()
		val selfId = parentHierarchyInfo.id
		// All data owners of a hierarchy share the same type, so we can fetch them all through the more efficient
		// type-specific bulk endpoint instead of the polymorphic one.
		val dataOwnersById = dataOwnerApi.getDataOwnersWithKnownType(allIds, parentHierarchyInfo.dataOwnerType).associateBy { it.dataOwner.id }
		require(dataOwnersById.keys == allIds) {
			"Could not retrieve all data owners of the current data owner hierarchy, missing: ${allIds - dataOwnersById.keys}"
		}
		dataOwnersById.values.forEach { checkDataOwnerIntegrity(it.dataOwner) }
		val selfInfo = dataOwnersById.getValue(selfId)

		val loadedKeyInfoById = dataOwnersById.mapValues { (_, dataOwnerInfo) -> loadAndIcureRecoverKeysFor(dataOwnerInfo) }
		val recoveryRequestById = loadedKeyInfoById.mapValues { (id, loaded) ->
			val dataOwnerInfo = dataOwnersById.getValue(id)
			val (found, missing) = loaded
			val keysWithVerificationInfo = icureStorage.loadSelfVerifiedKeys(id).keys
			CryptoStrategies.KeyDataRecoveryRequest(
				dataOwnerInfo,
				// Note: differently from the og typescript SDK I don't include unavailable keys in unknown.
				unknownKeys = (found.filter { !it.isDevice } + missing).mapNotNull {
					if (it.publicKeyString.fingerprintV1() !in keysWithVerificationInfo) it.publicKeyString else null
				},
				unavailableKeys = missing.map { it.asUnavailableKeyInfo() }
			)
		}
		val keyPairRecoverer = KeyPairRecovererImpl(
			recoveryDataEncryption,
			cardinalKeyRecovery,
			cryptoService,
			loadedKeyInfoById.mapValues { (_, loadedKeysInfo) ->
				loadedKeysInfo.first.associate { it.publicKeyString to it.pair }
			}
		)
		val recoveredKeyData = if (recoveryRequestById.values.any { it.unknownKeys.isNotEmpty() || it.unavailableKeys.isNotEmpty() })
			recoverAndVerifySelfHierarchyKeys(selfId, recoveryRequestById, cryptoService, keyPairRecoverer)
		else
			NoOpRecoveryFunction(selfId, recoveryRequestById, cryptoService, keyPairRecoverer)
		require(dataOwnersById.keys.containsAll(recoveredKeyData.keys)) {
			"Recovery function should return entries only for the requested data owners ids"
		}
		val combinedVerificationDetails = mutableMapOf<String, Map<KeypairFingerprintV1String, Boolean>>()
		recoveredKeyData.forEach { (dataOwnerId, recoveredData) ->
			val currDataOwnerRequest = recoveryRequestById.getValue(dataOwnerId)
			val allRequestedKeys = currDataOwnerRequest.unknownKeys + currDataOwnerRequest.unavailableKeys.map { it.publicKey }
			require (allRequestedKeys.map { it.fingerprintV1() }.containsAll(recoveredData.keyAuthenticity.keys + recoveredData.recoveredKeys.keys)) {
				"Recovery function should return entries only for the requested keys"
			}
			// Save keys
			recoveredData.recoveredKeys.forEach { (_, key) ->
				icureStorage.saveEncryptionKeypair(dataOwnerId, key, false)
			}
			// Save verification information
			val currCombinedVerificationDetails = recoveredData.recoveredKeys.keys.associateWith { true } + recoveredData.keyAuthenticity // key authenticity can override
			icureStorage.updateAndSaveSelfVerifiedKeys(
				dataOwnerId,
				currCombinedVerificationDetails
			)
			combinedVerificationDetails[dataOwnerId] = currCombinedVerificationDetails
		}
		val fullyRecoveredKeyDataById = dataOwnersById.mapValues { (id, dataOwnerInfo) ->
			val loaded = loadedKeyInfoById.getValue(id).first
			val recoveredByStrategies = recoveredKeyData[id]?.recoveredKeys?.mapNotNull { (_, keyPair) ->
				val spki = cryptoService.rsa.exportSpkiHex(keyPair.public)
				DataOwnerKeyInfo.Found(
					spki,
					keyPair,
					isVerified = combinedVerificationDetails.getValue(id).getValue(spki.fingerprintV1()),
					isDevice = false
				)
			} ?: emptyList()
			val availableSpki = (loaded.map { it.publicKeyString } + recoveredByStrategies.map { it.publicKeyString }).toSet()
			val reRecoveredByIcure = cardinalKeyRecovery.recoverKeys(
				dataOwnerInfo,
				(loaded + recoveredByStrategies).mapTo(mutableSetOf()) { CardinalKeyInfo(it.publicKeyString, it.pair) }
			).filter {
				it.pubSpkiHexString !in availableSpki
			}.map {
				DataOwnerKeyInfo.Found(
					it.pubSpkiHexString,
					it.key,
					isVerified = combinedVerificationDetails[id]?.get(it.pubSpkiHexString.fingerprintV1()) == true,
					isDevice = false
				)
			}
			(loaded + recoveredByStrategies + reRecoveredByIcure).associate {
				it.publicKeyString.fingerprintV2() to CachedKeypairDetails(
					CardinalKeyInfo(it.publicKeyString, it.pair),
					isVerified = it.isVerified,
					isDevice = it.isDevice
				)
			}
		}
		if ((fullyRecoveredKeyDataById - selfId).values.any { keysMap -> keysMap.none { it.value.isSafeForEncryption } }) throw IllegalStateException(
			"""
			There are no verified keys available for a parent data owner; make sure that all parent data owners are
			properly initialized and that the current user has access to at least a key for them.
			""".trimIndent()
		)
		fun buildKeyData(
			alternateEncryptionDataOwnerId: String?,
			delegatorActorIsAnonymous: Boolean,
			specialOperationMode: CryptoStrategies.KeyGenerationRequestResult?,
			keysById: Map<String, Map<KeypairFingerprintV2String, CachedKeypairDetails>>
		): KeyData = KeyData(
			alternateEncryptionDataOwnerId = alternateEncryptionDataOwnerId,
			delegatorActorIsAnonymous = delegatorActorIsAnonymous,
			parentHierarchyInfo = parentHierarchyInfo,
			keys = parentHierarchyInfo.toParentHierarchyWith(
				keysById.mapValues { (id, keysMap) -> LoadedDataOwnerKeys(id, keysMap) }
			),
			specialOperationMode = specialOperationMode,
			fullHierarchyInfo = fullHierarchyInfo
		)
		return if (fullyRecoveredKeyDataById.getValue(selfId).none { it.value.isSafeForEncryption }) {
			val keyRequestResult = generateNewKeyForDataOwner(selfInfo, cryptoService)
			val (alternateEncryptionDataOwnerId, newKey) = when (keyRequestResult) {
				CryptoStrategies.KeyGenerationRequestResult.Allow -> {
					Pair(
						null,
						cryptoService.rsa.generateKeyPair(
							RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256,
							RsaService.KeySize.Rsa2048
						)
					)
				}
				is CryptoStrategies.KeyGenerationRequestResult.Use -> {
					Pair(
						null,
						keyRequestResult.keyPair,
					)
				}
				is CryptoStrategies.KeyGenerationRequestResult.Keyless -> {
					// Keyless mode, no new key is created, and can't create encryption metadata
					Pair(
						null,
						null
					)
				}
				CryptoStrategies.KeyGenerationRequestResult.Deny -> {
					throw IllegalStateException("No verified key available for the current data owner and crypto strategies do not allow for the creation of a new key. Aborting api initialisation")
				}
				is CryptoStrategies.KeyGenerationRequestResult.ParentDelegator -> {
					require (fullyRecoveredKeyDataById[keyRequestResult.parentId] != null) {
						"${keyRequestResult.parentId} is not a parent of the current data owner, or the SDK has not been initialized using hierarchical data owners."
					}
					require (fullyRecoveredKeyDataById.getValue(keyRequestResult.parentId).isNotEmpty()) {
						"At least a key of parent ${keyRequestResult.parentId} must be available for encryption in order to use it as parent delegator."
					}
					Pair(
						keyRequestResult.parentId,
						null
					)
				}
			}
			val isDelegatorAnonymous = cryptoStrategies.dataOwnerRequiresAnonymousDelegation(
				if (alternateEncryptionDataOwnerId == null) selfInfo.asStub() else dataOwnersById.getValue(alternateEncryptionDataOwnerId).asStub(),
				null
			)
			if (expectDelegatorAnonymity != null) {
				check(isDelegatorAnonymous == expectDelegatorAnonymity) {
					"Delegator anonymity requirement changed during key reload, aborting. You need to re-initialize the entire SDK to reflect data owner hierarchy changes.\n" +
					"Note that changing anonymity of data owners is generally strongly discouraged:\n" +
					"- When changing from explicit to anonymous existing data is not updated, and an observer may be able to link the old data where the delegator appears explicitly to new anonymous data\n" +
					"- When changing from anonymous to explicit your data owner may not be able to find data that was previously accessible to him."
				}
			}
			if (isDelegatorAnonymous && parentHierarchyInfo.links.isNotEmpty()) {
				// TODO this is untested, may be very messed up. Currently never had a use case for this.
				// Could be particularly problematic with how keys are fully cached for anonymous data owners
				throw UnsupportedOperationException("Anonymous data owners are currently incompatible with hierarchical data owners.")
			}
			if (isDelegatorAnonymous && alternateEncryptionDataOwnerId != null) {
				// TODO this is untested, may be very messed up. Currently never had a use case for this.
				// Could be particularly problematic with how keys are fully cached for anonymous data owners
				throw UnsupportedOperationException("Anonymous data owners are currently incompatible with alternate delegators (ParentDelegator).")
			}
			val specialOperationMode = when (keyRequestResult) {
				CryptoStrategies.KeyGenerationRequestResult.Keyless,
				is CryptoStrategies.KeyGenerationRequestResult.ParentDelegator ->
					keyRequestResult
				else ->
					null
			}
			newKey?.let { newKey ->
				val newKeySpki = cryptoService.rsa.exportSpkiHex(newKey.public)
				val selfWithNewKey = selfInfo.asStub().let {
					it.copy(stub = it.stub.copy(publicKeysForOaepWithSha256 = it.stub.publicKeysForOaepWithSha256 + newKeySpki))
				}
				dataOwnerApi.modifyDataOwnerStub(selfWithNewKey)
				icureStorage.saveEncryptionKeypair(selfInfo.dataOwner.id, newKey, true)
				val updatedKeysById = fullyRecoveredKeyDataById + (
					selfId to (fullyRecoveredKeyDataById.getValue(selfId) + (newKeySpki.fingerprintV2() to CachedKeypairDetails(
						CardinalKeyInfo(newKeySpki, newKey),
						isVerified = true,
						isDevice = true
					)))
				)
				buildKeyData(alternateEncryptionDataOwnerId, isDelegatorAnonymous, specialOperationMode, updatedKeysById) to CardinalKeyInfo(newKeySpki, newKey)
			} ?: (buildKeyData(alternateEncryptionDataOwnerId, isDelegatorAnonymous, specialOperationMode, fullyRecoveredKeyDataById) to null)
		} else {
			buildKeyData(
				null,
				cryptoStrategies.dataOwnerRequiresAnonymousDelegation(
					selfInfo.asStub(),
					null
				),
				null,
				fullyRecoveredKeyDataById
			) to null
		}
	}

	private sealed interface DataOwnerKeyInfo {
		val publicKeyString: SpkiHexString

		data class Found(
			override val publicKeyString: SpkiHexString,
			val pair: RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>,
			val isVerified: Boolean,
			val isDevice: Boolean
		): DataOwnerKeyInfo

		data class Missing(
			override val publicKeyString: SpkiHexString,
			val algorithm: RsaAlgorithm.RsaEncryptionAlgorithm
		): DataOwnerKeyInfo {
			fun asUnavailableKeyInfo() = CryptoStrategies.UnavailableKeyInfo(
				publicKey = publicKeyString,
				keyAlgorithm = algorithm
			)
		}
	}
	/*
	 * Load keys from storage
	 * Attempt to recover with iCure recovery
	 * Verify with stored verification information
	 */
	private suspend fun loadAndIcureRecoverKeysFor(
		dataOwnerInfo: DataOwnerWithType,
	): Pair<Collection<DataOwnerKeyInfo.Found>, Collection<DataOwnerKeyInfo.Missing>> {
		val legacyKey = dataOwnerInfo.dataOwner.publicKey
		val verificationDetails = icureStorage.loadSelfVerifiedKeys(dataOwnerInfo.dataOwner.id)
		val keysWithAlgorithm = (
			dataOwnerInfo.dataOwner.publicKeysWithSha1Spki.map {
				it to RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1
			} + dataOwnerInfo.dataOwner.publicKeysWithSha256Spki.map {
				it to RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256
			}
		)
		val loadedKeysByPub = keysWithAlgorithm.mapNotNull { (pubHex, alg) ->
			icureStorage.loadEncryptionKeypair(
				dataOwnerInfo.dataOwner.id,
				pubHex.fingerprintV1(),
				legacyKey,
				alg
			)?.let { keyPairDetails ->
				pubHex to DataOwnerKeyInfo.Found(
					pubHex,
					keyPairDetails.pair,
					verificationDetails[pubHex.fingerprintV1()] == true,
					keyPairDetails.isDevice
				)
			}
		}.toMap()
		val recoveredKeysByPub = cardinalKeyRecovery.recoverKeys(
			dataOwnerInfo,
			loadedKeysByPub.values.mapTo(mutableSetOf()) { CardinalKeyInfo(it.publicKeyString, it.pair) }
		).associate {
			it.pubSpkiHexString to DataOwnerKeyInfo.Found(
				it.pubSpkiHexString,
				it.key,
				verificationDetails[it.pubSpkiHexString.fingerprintV1()] == true,
				false
			)
		}
		recoveredKeysByPub.values.forEach {
			icureStorage.saveEncryptionKeypair(dataOwnerInfo.dataOwner.id, it.pair, false)
		}
		// Recoverer should not give already available keys, but we just want to make sure there are no duplicates,
		// prioritising loaded keys and not recovered.
		val allAvailableKeys = (recoveredKeysByPub + loadedKeysByPub)
		val missingKeys = keysWithAlgorithm.mapNotNull { (pubHex, alg) ->
			if (allAvailableKeys.keys.contains(pubHex)) {
				null
			} else {
				DataOwnerKeyInfo.Missing(pubHex, alg)
			}
		}
		return allAvailableKeys.values to missingKeys
	}
}
