package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.crypto.CardinalKeyRecovery
import com.icure.cardinal.sdk.crypto.CryptoStrategies
import com.icure.cardinal.sdk.crypto.KeyPairRecoverer
import com.icure.cardinal.sdk.crypto.RecoveryDataEncryption
import com.icure.cardinal.sdk.crypto.UserEncryptionKeysManager
import com.icure.cardinal.sdk.crypto.entities.CachedKeypairDetails
import com.icure.cardinal.sdk.crypto.entities.CardinalKeyInfo
import com.icure.cardinal.sdk.crypto.entities.DataOwnerKeyInfo
import com.icure.cardinal.sdk.crypto.entities.RsaDecryptionKeysSet
import com.icure.cardinal.sdk.crypto.entities.UserKeyPairInformation
import com.icure.cardinal.sdk.crypto.entities.toPrivateKeyInfo
import com.icure.cardinal.sdk.model.CryptoActorStub
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.extensions.publicKeysWithSha1Spki
import com.icure.cardinal.sdk.model.extensions.publicKeysWithSha256Spki
import com.icure.cardinal.sdk.model.extensions.asStub
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.storage.CardinalStorageFacade
import com.icure.cardinal.sdk.utils.InternalCardinalException
import com.icure.cardinal.sdk.utils.ensure
import com.icure.cardinal.sdk.utils.ensureNonNull
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
				prevData.keys.map { it.first },
				prevData.delegatorActorIsAnonymous,
				NoOpRecoveryFunction
			) { _, _ -> prevData.specialOperationMode ?: throw InternalCardinalException("Shouldn't create new key during key reload") }
			ensure (newKey == null) {
				"New key created during key reload."
			}
			cachedKeyData = updatedKeys
		} ?: throw IllegalStateException("Multiple concurrent requests to reload keys. This is not allowed.")
	}

	override fun getCurrentUserHierarchyAvailableKeypairs(): UserKeyPairInformation = with (cachedKeyData) {
		val mappedInfo = keys.map { (parentId, parentKeys) -> DataOwnerKeyInfo(parentId, parentKeys.values.toList()) }
		UserKeyPairInformation(
			mappedInfo.last(),
			mappedInfo.dropLast(1),
		)
	}

	override fun getKeyPairForFingerprint(fingerprint: KeypairFingerprintV2String): CachedKeypairDetails? = with (cachedKeyData) {
		keys.firstNotNullOfOrNull { it.second[fingerprint] }
	}

	override fun delegatorActorId(): String = with (cachedKeyData) {
		alternateEncryptionDataOwnerId ?: keys.last().first
	}

	override fun delegatorActorHierarchy(from: String?): List<String> = with (cachedKeyData) {
		if (alternateEncryptionDataOwnerId == null && from == null) {
			keys.map { it.first }
		} else {
			val index = keys.indexOfFirst { it.first == from || it.first == alternateEncryptionDataOwnerId }
			ensure(index >= 0) {
				"Alternate encryption data owner id not in keys list"
			}
			val res = keys.take(index + 1).map { it.first }
			require(from == null || res.last() == from) {
				"Provided 'from' id is not part of the current delegator hierarchy"
			}
			res
		}
	}

	override fun delegatorActorIsAnonymous(): Boolean = cachedKeyData.delegatorActorIsAnonymous

	override fun delegatorActorVerifiedKeys(): Set<CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>> =
		with (cachedKeyData) {
			delegatorActorKeys.second.values.filter { it.isSafeForEncryption }.mapTo(mutableSetOf()) { it.keyPair }
		}

	override fun getVerifiedEncryptionKeysForDataOwnerIfInCurrentHierarchy(dataOwnerId: String): Set<CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>? = with (cachedKeyData) {
		keys.firstOrNull { it.first == dataOwnerId }?.second?.values?.filter { it.isSafeForEncryption }?.mapTo(mutableSetOf()) { it.keyPair }
	}

	override fun getVerifiedPublicKeysFor(dataOwner: CryptoActorStub): Set<SpkiHexString> = with (cachedKeyData) {
		keys.firstOrNull {
			it.first == dataOwner.id
		}?.let { (_, keysMap) ->
			keysMap.values.filter { it.isSafeForEncryption }.mapTo(mutableSetOf()) { it.keyPair.pubSpkiHexString }
		} ?: throw IllegalArgumentException("Data owner is not part of the current data owner hierarchy")
	}

	override fun getAllDecryptionKeys(): RsaDecryptionKeysSet = with (cachedKeyData) {
		RsaDecryptionKeysSet(
			keys.map { it.second }.flatMap { keyMap -> keyMap.values.map { it.keyPair.toPrivateKeyInfo() } }
		)
	}

	override fun getDecryptionKeysForDataOwnerIfInCurrentHierarchy(dataOwnerId: String): RsaDecryptionKeysSet? = with (cachedKeyData) {
		keys.firstOrNull { it.first == dataOwnerId }?.second?.values?.map { it.keyPair.toPrivateKeyInfo() }?.let(::RsaDecryptionKeysSet)
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
private class KeyData(
	val alternateEncryptionDataOwnerId: String?,
	val delegatorActorIsAnonymous: Boolean,
	val keys: List<Pair<String, Map<KeypairFingerprintV2String, CachedKeypairDetails>>>,
	val specialOperationMode: CryptoStrategies.KeyGenerationRequestResult?
) {
	val delegatorActorKeys = if (alternateEncryptionDataOwnerId != null) {
		keys.first { it.first == alternateEncryptionDataOwnerId }
	} else {
		keys.last()
	}
}


private typealias RecoveryFunction = suspend (
	keysData: List<CryptoStrategies.KeyDataRecoveryRequest>,
	cryptoPrimitives: CryptoService,
	keyPairRecoverer: KeyPairRecoverer
) -> Map<String, CryptoStrategies.RecoveredKeyData>
private val NoOpRecoveryFunction: RecoveryFunction = { request, _, _ ->
	// Recovery during reload keys does nothing.
	request.associate {
		it.dataOwnerDetails.dataOwner.id to CryptoStrategies.RecoveredKeyData(
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

	/*
	 * Process:
	 * 1. Load all keys for each data owner and try to recover any missing keys using iCure recovery.
	 * 2. If some keys are still missing use the user-provided recovery function providing the missing keys information
	 * for ALL data owners at the same time.
	 * 3. If for any non-self data owner there is no key available fail.
	 * 4. If a key for the current data owner
	 */
	suspend fun doLoadKeys(
		expectHierarchyIds: List<String>?,
		expectDelegatorAnonymity: Boolean?,
		recoverAndVerifySelfHierarchyKeys: RecoveryFunction,
		generateNewKeyForDataOwner: KeyGenerationFunction,
	): Pair<KeyData, CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256>>?> {
		val hierarchy = if (initializeParentKeys)
			dataOwnerApi.getCurrentDataOwnerHierarchy()
		else
			listOf(dataOwnerApi.getCurrentDataOwner())
		if (expectHierarchyIds != null) {
			check(hierarchy.map { it.dataOwner.id } == expectHierarchyIds) {
				"Data owner hierarchy changed during key reload, aborting. You need to re-initialize the entire SDK to reflect data owner hierarchy changes."
			}
		}
		val loadedKeyInfo = hierarchy.map { it to loadAndIcureRecoverKeysFor(it) }
		val recoveryRequest = loadedKeyInfo.map { (dataOwnerInfo, loaded) ->
			val (found, missing) = loaded
			val keysWithVerificationInfo = icureStorage.loadSelfVerifiedKeys(dataOwnerInfo.dataOwner.id).keys
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
			loadedKeyInfo.associate { (dataOwnerWithType, loadedKeysInfo) ->
				dataOwnerWithType.dataOwner.id to loadedKeysInfo.first.associate {
					it.publicKeyString to it.pair
				}
			}
		)
		val recoveredKeyData = if (recoveryRequest.any { it.unknownKeys.isNotEmpty() || it.unavailableKeys.isNotEmpty() })
			recoverAndVerifySelfHierarchyKeys(recoveryRequest,cryptoService, keyPairRecoverer)
		else
			NoOpRecoveryFunction(recoveryRequest, cryptoService, keyPairRecoverer)
		require(hierarchy.map { it.dataOwner.id }.containsAll(recoveredKeyData.keys)) {
			"Recovery function should return entries only for the requested data owners ids"
		}
		val combinedVerificationDetails = mutableMapOf<String, Map<KeypairFingerprintV1String, Boolean>>()
		recoveredKeyData.forEach { (dataOwnerId, recoveredData) ->
			val currDataOwnerRequest = recoveryRequest.first { it.dataOwnerDetails.dataOwner.id == dataOwnerId }
			val allRequestedKeys = currDataOwnerRequest.unknownKeys + currDataOwnerRequest.unavailableKeys.map { it.publicKey }
			require (allRequestedKeys.map { it.fingerprintV1() }.containsAll(recoveredData.keyAuthenticity.keys + recoveredData.recoveredKeys.keys)) {
				"Recovery function should return entries only for the requested keys"
			}
			// Save keys
			recoveredData.recoveredKeys.forEach { (fp, key) ->
				icureStorage.saveEncryptionKeypair(dataOwnerId, key, false)
				// Validate verification information (if present) for this key
				require (recoveredData.keyAuthenticity[fp] != false) {
					throw IllegalArgumentException("Recovered key $fp is explicitly marked as unverified, but recovered keys must be verified")
				}
			}
			// Save verification information
			val currCombinedVerificationDetails = recoveredData.keyAuthenticity + recoveredData.recoveredKeys.keys.associateWith { true }
			icureStorage.updateAndSaveSelfVerifiedKeys(
				dataOwnerId,
				currCombinedVerificationDetails
			)
			combinedVerificationDetails[dataOwnerId] = currCombinedVerificationDetails
		}
		val fullyRecoveredKeyData = hierarchy.map { dataOwnerInfo ->
			val loaded = loadedKeyInfo.first { it.first == dataOwnerInfo }.second.first
			val recoveredByStrategies = recoveredKeyData[dataOwnerInfo.dataOwner.id]?.recoveredKeys?.mapNotNull { (_, keyPair) ->
				DataOwnerKeyInfo.Found(
					cryptoService.rsa.exportSpkiHex(keyPair.public),
					keyPair,
					isVerified = true,
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
					isVerified = combinedVerificationDetails.getValue(dataOwnerInfo.dataOwner.id)[it.pubSpkiHexString.fingerprintV1()] == true,
					isDevice = false
				)
			}
			dataOwnerInfo.dataOwner.id to (loaded + recoveredByStrategies + reRecoveredByIcure).associate {
				it.publicKeyString.fingerprintV2() to CachedKeypairDetails(
					CardinalKeyInfo(it.publicKeyString, it.pair),
					isVerified = it.isVerified,
					isDevice = it.isDevice
				)
			}
		}
		if (fullyRecoveredKeyData.dropLast(1).any { (_, keys) -> keys.none { it.value.isSafeForEncryption } }) throw IllegalStateException(
			"""
			There are no verified keys available for a parent data owner; make sure that all parent data owners are 
			properly initialized and that the current user has access to at least a key for them. 
			""".trimIndent()
		)
		return if (fullyRecoveredKeyData.last().second.none { it.value.isSafeForEncryption }) {
			val selfInfo = hierarchy.last()
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
					val parentId = selfInfo.dataOwner.parentId
					require (parentId != null && fullyRecoveredKeyData[fullyRecoveredKeyData.size - 2].second.isNotEmpty()) {
						"ParentDelegator option is only available if the current data owner has a parent, the SDK is initialized using hierarchical data owners, and at least a key of the parent is available for encryption."
					}
					Pair(
						parentId,
						null
					)
				}
			}
			val isDelegatorAnonymous = cryptoStrategies.dataOwnerRequiresAnonymousDelegation(
				if (alternateEncryptionDataOwnerId == null) selfInfo.asStub() else hierarchy.first { it.dataOwner.id == alternateEncryptionDataOwnerId }.asStub(),
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
			if (isDelegatorAnonymous && hierarchy.size > 1) {
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
				CryptoStrategies.KeyGenerationRequestResult.ParentDelegator ->
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
				KeyData(
					alternateEncryptionDataOwnerId = alternateEncryptionDataOwnerId,
					delegatorActorIsAnonymous = isDelegatorAnonymous,
					keys = fullyRecoveredKeyData.dropLast(1) + fullyRecoveredKeyData.last().copy(
						second = fullyRecoveredKeyData.last().second + (newKeySpki.fingerprintV2() to CachedKeypairDetails(
							CardinalKeyInfo(newKeySpki, newKey),
							isVerified = true,
							isDevice = true
						))
					),
					specialOperationMode = specialOperationMode
				) to CardinalKeyInfo(newKeySpki, newKey)
			} ?: (KeyData(
				alternateEncryptionDataOwnerId = alternateEncryptionDataOwnerId,
				delegatorActorIsAnonymous = isDelegatorAnonymous,
				fullyRecoveredKeyData,
				specialOperationMode = specialOperationMode
			) to null)
		} else {
			KeyData(
				null,
				cryptoStrategies.dataOwnerRequiresAnonymousDelegation(
					hierarchy.last().asStub(),
					null
				),
				fullyRecoveredKeyData,
				null
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
