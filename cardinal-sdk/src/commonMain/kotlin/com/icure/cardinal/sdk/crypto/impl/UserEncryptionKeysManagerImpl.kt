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
	private val keyLoader: KeyLoader
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
			val (updatedKeys, newKey) = keyLoader.doLoadKeys(
				NoOpRecoveryFunction
			) { _, _ -> throw IllegalStateException("Can't create new key during key reload") }
			ensure (newKey == null) { "New key created during key reload." }
			cachedKeyData = updatedKeys
		} ?: throw IllegalStateException("Multiple concurrent requests to reload keys. This is not allowed.")
	}

	override fun getCurrentUserHierarchyAvailableKeypairs(): UserKeyPairInformation = with (cachedKeyData) {
		UserKeyPairInformation(
			DataOwnerKeyInfo(selfId, selfKeys.values.toList()),
			parentsKeys.map { (parentId, parentKeys) -> DataOwnerKeyInfo(parentId, parentKeys.values.toList()) }
		)
	}

	override fun getCurrentUserAvailablePublicKeysHex(verifiedOnly: Boolean): Set<SpkiHexString> = with (cachedKeyData) {
		selfKeys.values.let { keys ->
			if (verifiedOnly) keys.filter { it.isSafeForEncryption } else keys
		}.mapTo(mutableSetOf()) { it.keyPair.pubSpkiHexString }
	}

	override fun getCurrentUserHierarchyAvailablePublicKeysHex(): Set<SpkiHexString> = with (cachedKeyData) {
		keys.flatMap { it.second.values }.mapTo(mutableSetOf()) { it.keyPair.pubSpkiHexString }
	}

	override fun getKeyPairForFingerprint(fingerprint: KeypairFingerprintV2String): CachedKeypairDetails? = with (cachedKeyData) {
		keys.firstNotNullOfOrNull { it.second[fingerprint] }
	}


	override fun getSelfVerifiedKeys(): Set<CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>> = with (cachedKeyData) {
		selfKeys.values.filter { it.isSafeForEncryption }.mapTo(mutableSetOf()) { it.keyPair }
	}

	override fun getVerifiedPublicKeysFor(dataOwner: CryptoActorStub): Set<SpkiHexString> = with (cachedKeyData) {
		keys.firstOrNull {
			it.first == dataOwner.id
		}?.let { (_, keysMap) ->
			keysMap.values.filter { it.isSafeForEncryption }.mapTo(mutableSetOf()) { it.keyPair.pubSpkiHexString }
		} ?: throw IllegalArgumentException("Data owner is not part of the current data owner hierarchy")
	}

	override fun getDecryptionKeys(includeParent: Boolean) = with (cachedKeyData) {
		RsaDecryptionKeysSet((
			if (includeParent) {
				keys.map { it.second }
			} else {
				listOf(selfKeys)
			}
		).flatMap { keyMap -> keyMap.values.map { it.keyPair.toPrivateKeyInfo() } })
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
				initializeParentKeys
			)
			val (initialKeyData, newKey) = keyLoader.doLoadKeys(
				cryptoStrategies::recoverAndVerifySelfHierarchyKeys,
				cryptoStrategies::generateNewKeyForDataOwner
			)
			val manager =
				UserEncryptionKeysManagerImpl(initialKeyData, keyLoader)
			return UserEncryptionKeysManager.Factory.InitialisationDetails(manager, newKey)
		}

	}
}

@InternalIcureApi
private data class KeyData(
	val selfId: String,
	val keys: List<Pair<String, Map<KeypairFingerprintV2String, CachedKeypairDetails>>>
) {
	val selfKeys: Map<KeypairFingerprintV2String, CachedKeypairDetails>
		get() = keys.last().second
	val parentsKeys: List<Pair<String, Map<KeypairFingerprintV2String, CachedKeypairDetails>>>
		get() = keys.dropLast(1)
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
		recoverAndVerifySelfHierarchyKeys: RecoveryFunction,
		generateNewKeyForDataOwner: KeyGenerationFunction
	): Pair<KeyData, CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256>>?> {
		val hierarchy = if (initializeParentKeys)
			dataOwnerApi.getCurrentDataOwnerHierarchy()
		else
			listOf(dataOwnerApi.getCurrentDataOwner())
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
			val reRecoveredByIcure = cardinalKeyRecovery.recoverKeys(
				dataOwnerInfo,
				(loaded + recoveredByStrategies).mapTo(mutableSetOf()) { CardinalKeyInfo(it.publicKeyString, it.pair) }
			).map {
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
			val newKey = when (val newKeyRequest = generateNewKeyForDataOwner(selfInfo, cryptoService)) {
				CryptoStrategies.KeyGenerationRequestResult.Allow ->
					cryptoService.rsa.generateKeyPair(
						RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256,
						RsaService.KeySize.Rsa2048
					)

				is CryptoStrategies.KeyGenerationRequestResult.Use ->
					newKeyRequest.keyPair

				is CryptoStrategies.KeyGenerationRequestResult.Keyless ->
					null // Keyless mode, no new key is created.

				CryptoStrategies.KeyGenerationRequestResult.Deny ->
					throw IllegalStateException("No verified key available for the current data owner and crypto strategies do not allow for the creation of a new key. Aborting api initialisation")
			}
			newKey?.let { newKey ->
				val newKeySpki = cryptoService.rsa.exportSpkiHex(newKey.public)
				val selfWithNewKey = selfInfo.asStub().let {
					it.copy(stub = it.stub.copy(publicKeysForOaepWithSha256 = it.stub.publicKeysForOaepWithSha256 + newKeySpki))
				}
				dataOwnerApi.modifyDataOwnerStub(selfWithNewKey)
				icureStorage.saveEncryptionKeypair(selfInfo.dataOwner.id, newKey, true)
				KeyData(
					selfInfo.dataOwner.id,
					fullyRecoveredKeyData.dropLast(1) + fullyRecoveredKeyData.last().copy(
						second = fullyRecoveredKeyData.last().second + (newKeySpki.fingerprintV2() to CachedKeypairDetails(
							CardinalKeyInfo(newKeySpki, newKey),
							isVerified = true,
							isDevice = true
						))
					)
				) to CardinalKeyInfo(newKeySpki, newKey)
			} ?: (KeyData(
				hierarchy.last().dataOwner.id,
				fullyRecoveredKeyData
			) to null)
		} else {
			KeyData(
				hierarchy.last().dataOwner.id,
				fullyRecoveredKeyData
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
