package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.api.raw.RawDeviceApi
import com.icure.cardinal.sdk.api.raw.RawHealthcarePartyApi
import com.icure.cardinal.sdk.api.raw.RawPatientApi
import com.icure.cardinal.sdk.crypto.BaseExchangeKeysManager
import com.icure.cardinal.sdk.crypto.entities.DataOwnerExchangeKeys
import com.icure.cardinal.sdk.crypto.entities.DecryptionResult
import com.icure.cardinal.sdk.crypto.entities.RsaDecryptionKeysSet
import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.extensions.asStub
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEntryKeyString
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.utils.getLogger
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.PrivateRsaKey
import com.icure.kryptom.crypto.PublicRsaKey
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.utils.toHexString
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

@InternalIcureApi
class BaseExchangeKeysManagerImpl(
	private val cryptoService: CryptoService,
	private val dataOwnerApi: DataOwnerApi,
	private val rawPatientApi: RawPatientApi,
	private val rawDeviceApi: RawDeviceApi,
	private val rawHealthcarePartyApi: RawHealthcarePartyApi
) : BaseExchangeKeysManager {
	private companion object {
		val log = getLogger("BaseExchangeKeysManager")
	}

	private val extendForGiveAccessBackMutex = Mutex()

	override suspend fun giveAccessBackTo(
		otherDataOwner: String,
		newDataOwnerPublicKey: SpkiHexString,
		keyPairsByFingerprint: RsaDecryptionKeysSet
	) {
		val self = dataOwnerApi.getCurrentDataOwner().asStub()
		val other = dataOwnerApi.getCryptoActorStub(otherDataOwner)
		val importedKey = cryptoService.loadEncryptionKeyForDataOwner(other.stub, newDataOwnerPublicKey)
		extendForGiveAccessBack(self, other, newDataOwnerPublicKey.fingerprintV1(), importedKey, keyPairsByFingerprint)
		extendForGiveAccessBack(other, self, newDataOwnerPublicKey.fingerprintV1(), importedKey, keyPairsByFingerprint)
	}

	override suspend fun getEncryptedExchangeKeysFor(
		delegatorId: String,
		delegateId: String
	): List<Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> {
		val delegator = dataOwnerApi.getCryptoActorStub(delegatorId)
		val legacyDelegation = delegator.stub.hcPartyKeys[delegateId]?.get(1)
		val aesExchangeKeys: List<Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> =
			delegator.stub.aesExchangeKeys.values.mapNotNull { delegateToExchangeKeyForDelegatorKeypair ->
				delegateToExchangeKeyForDelegatorKeypair[delegateId]
			}
		return if (legacyDelegation != null)
			aesExchangeKeys + mapOf(AesExchangeKeyEncryptionKeypairIdentifier("") to legacyDelegation)
		else
			aesExchangeKeys
	}

	// { [delegatorId: string]: { [delegatorPubKeyFingerprint: string]: { [delegatePubKeyFingerprint: string]: string } } }
	private suspend fun aesExchangeKeysFromHcpsToDelegate(delegateId: String): Map<String, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> =
		rawHealthcarePartyApi.getAesExchangeKeysForDelegate(delegateId).successBody()

	private suspend fun aesExchangeKeysFromPatientsToDelegate(delegateId: String): Map<String, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> =
		rawPatientApi.getPatientAesExchangeKeysForDelegate(delegateId).successBody()

	private suspend fun aesExchangeKeysFromDevicesToDelegate(delegateId: String): Map<String, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> =
		rawDeviceApi.getDeviceAesExchangeKeysForDelegate(delegateId).successBody()


	override suspend fun getAllExchangeKeysWith(
		dataOwnerId: String,
		otherOwnerTypes: Set<DataOwnerType>
	): DataOwnerExchangeKeys = coroutineScope {
		val allValues = otherOwnerTypes.map {
			when (it) {
				DataOwnerType.Hcp -> async { aesExchangeKeysFromHcpsToDelegate(dataOwnerId) }
				DataOwnerType.Patient -> async { aesExchangeKeysFromPatientsToDelegate(dataOwnerId) }
				DataOwnerType.Device -> async { aesExchangeKeysFromDevicesToDelegate(dataOwnerId) }
			}
		}.awaitAll()
		val keysToOwner = allValues.fold(emptyMap<String, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>()) { acc, retrievedData ->
			acc + retrievedData
		}
		val dataOwner = dataOwnerApi.getCryptoActorStub(dataOwnerId)
		val allDataOwnerKeys = combineDataOwnerAesExchangeKeysWithHcpartyKeys(dataOwner, emptyList())
		val acceptedDelegates = allDataOwnerKeys.flatMap { it.value.keys }.distinct().filter {
			dataOwnerApi.getCryptoActorStub(it).type in otherOwnerTypes
		}.toSet()
		val filteredKeysFromOwner = allDataOwnerKeys.flatMap { (_, dataByDelegate) ->
			dataByDelegate.toList().filter { it.first in acceptedDelegates }
		}.groupBy { it.first }.mapValues { (_, v) -> v.map { it.second } }.filterValues { it.isNotEmpty() }
		DataOwnerExchangeKeys(
			dataOwnerId,
			exchangeKeysByDataOwnerTo = filteredKeysFromOwner,
			exchangeKeysToDataOwnerFrom = keysToOwner.flatMap { (delegator, keyInfo) ->
				keyInfo.values.map { delegator to it }
			}.groupBy { it.first }.mapValues { (_, v) -> v.map { it.second } }.filterValues { it.isNotEmpty() }
		)
	}

	override suspend fun tryDecryptExchangeKeys(
		encryptedExchangeKeys: List<Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>,
		keyPairsByFingerprint: RsaDecryptionKeysSet
	): DecryptionResult<Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>, AesKey<AesAlgorithm.CbcWithPkcs7Padding>> {
		val failed = mutableListOf<Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>()
		val successful = mutableListOf<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>()
		val foundRawKeysHex = mutableSetOf<String>()
		encryptedExchangeKeys.forEach {
			tryDecryptExchangeKey(it, keyPairsByFingerprint)?.also { decryptedKey ->
				val keyHex = cryptoService.aes.exportKey(decryptedKey).toHexString()
				if (!foundRawKeysHex.add(keyHex)) log.d {
					"Duplicate key decrypted: $keyHex"
				} else {
					successful.add(decryptedKey)
				}
			} ?: failed.add(it)
		}
		return DecryptionResult(failed, successful)
	}

	private suspend fun tryDecryptExchangeKey(
		encryptedExchangeKey: Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>,
		keyPairsByFingerprint: RsaDecryptionKeysSet
	): AesKey<AesAlgorithm.CbcWithPkcs7Padding>? =
		encryptedExchangeKey.firstNotNullOfOrNull { (keypairIdentifier, encryptedKey) ->
			val fp = keypairIdentifier.toFingerprintV1OrNull()
			if (fp != null)
				keyPairsByFingerprint.getByFingerprintV1(fp)?.let { privateKey ->
					tryDecryptExchangeKeyWith(encryptedKey, privateKey, fp)
				}
			else
				keyPairsByFingerprint.allKeys.firstNotNullOfOrNull {
					tryDecryptExchangeKeyWith(encryptedKey, it.key, null)
				}
		}

	private suspend fun tryDecryptExchangeKeyWith(
		encryptedValue: HexString,
		privateKey: PrivateRsaKey<RsaAlgorithm.RsaEncryptionAlgorithm>,
		fp: KeypairFingerprintV1String?
	): AesKey<AesAlgorithm.CbcWithPkcs7Padding>? =
		try {
			val decrypted = cryptoService.rsa.decrypt(encryptedValue.decodedBytes(), privateKey)
			this.cryptoService.aes.loadKey(AesAlgorithm.CbcWithPkcs7Padding, decrypted)
		} catch (e: Exception) {
			if (e is CancellationException) throw e
			if (fp != null) log.w(e) {
				"Failed to decrypt exchange key for fingerprint $fp."
			}
			null
		}

	private suspend fun extendForGiveAccessBack(
		delegator: CryptoActorStubWithType,
		delegate: CryptoActorStubWithType,
		newPublicKeyFp: KeypairFingerprintV1String,
		newPublicKey: PublicRsaKey<RsaAlgorithm.RsaEncryptionAlgorithm>,
		decryptionKeyPairsByFingerprint: RsaDecryptionKeysSet
	) {
		extendForGiveAccessBackMutex.withLock {
			var didUpdateData = false
			val updatedAesExchangeKeys = combineDataOwnerAesExchangeKeysWithHcpartyKeys(delegator, listOf(delegate)).mapValues { (_, keysByDelegate) ->
				keysByDelegate.mapValues { (_, encryptedXKey) ->
					val encryptedXKeyByFingerprint = encryptedXKey.mapKeys { (k, _) -> k.toFingerprintV1OrNull() }
					if (encryptedXKeyByFingerprint.containsKey(newPublicKeyFp)) {
						encryptedXKey
					} else {
						tryDecryptExchangeKey(encryptedXKey, decryptionKeyPairsByFingerprint)?.let { decrypted ->
							val encryptedXKeyWithNewPub = encryptExchangeKey(decrypted, newPublicKey)
							didUpdateData = true
							encryptedXKey + (AesExchangeKeyEncryptionKeypairIdentifier(newPublicKeyFp.s) to encryptedXKeyWithNewPub)
						} ?: encryptedXKey
					}
				}
			}
			if (didUpdateData) {
				dataOwnerApi.modifyDataOwnerStub(delegator.copy(
					stub = delegator.stub.copy(aesExchangeKeys = updatedAesExchangeKeys)
				))
			}
		}
	}

	private suspend fun combineDataOwnerAesExchangeKeysWithHcpartyKeys(
		delegator: CryptoActorStubWithType,
		availableDataOwners: Collection<CryptoActorStubWithType>,
	): Map<AesExchangeKeyEntryKeyString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> =
		delegator.stub.publicKey?.let { legacyPubKey ->
			/*
			 * This condition would technically prevent new updates to the hcPartyKeys to be migrated to the aes exchange keys, but since I can only update
			 * data for self data owner and parent entities this is not an issue, because I will always be using the new api from now on and I won't have
			 * a situation where the legacy keys are updated but the aes exchange keys are not.
			 */
			if (delegator.stub.aesExchangeKeys.containsKey(AesExchangeKeyEntryKeyString(legacyPubKey.s)) || delegator.stub.hcPartyKeys.isEmpty()) {
				delegator.stub.aesExchangeKeys
			} else {
				val hcPartyKeys = delegator.stub.hcPartyKeys
				val delegatorLegacyPublicKeyFp = AesExchangeKeyEncryptionKeypairIdentifier(legacyPubKey.fingerprintV1().s)
				val availableDataOwnersById = availableDataOwners.associateBy { it.stub.id }
				val delegatesById = (hcPartyKeys.keys - delegator.stub.id).let { delegates ->
					delegates.associateWith { id -> availableDataOwnersById[id] ?: dataOwnerApi.getCryptoActorStub(id) }
				} + (delegator.stub.id to delegator)
				val aesExchangeKeys = delegator.stub.aesExchangeKeys.toMutableMap()
				aesExchangeKeys + (AesExchangeKeyEntryKeyString(legacyPubKey.s) to hcPartyKeys.mapValues { (delegateId, encryptedKey) ->
					val delegateKey = AesExchangeKeyEncryptionKeypairIdentifier(delegatesById[delegateId]?.stub?.publicKey?.fingerprintV1()?.s ?: "")
					mapOf(
						delegatorLegacyPublicKeyFp to encryptedKey[0],
						delegateKey to encryptedKey[1]
					)
				})
			}
		} ?: delegator.stub.aesExchangeKeys

	private suspend fun encryptExchangeKey(
		exchangeKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		publicKey: PublicRsaKey<RsaAlgorithm.RsaEncryptionAlgorithm>
	): HexString =
		HexString(cryptoService.rsa.encrypt(cryptoService.aes.exportKey(exchangeKey), publicKey).toHexString())
}
