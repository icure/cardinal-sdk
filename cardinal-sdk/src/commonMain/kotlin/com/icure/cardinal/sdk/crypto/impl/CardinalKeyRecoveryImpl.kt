package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.crypto.BaseExchangeDataManager
import com.icure.cardinal.sdk.crypto.BaseExchangeKeysManager
import com.icure.cardinal.sdk.crypto.CardinalKeyRecovery
import com.icure.cardinal.sdk.crypto.entities.CardinalKeyInfo
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.crypto.entities.RsaDecryptionKeysSet
import com.icure.cardinal.sdk.crypto.entities.ShamirSecretShare
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.extensions.algorithmOfEncryptionKey
import com.icure.cardinal.sdk.model.extensions.publicKeysSpki
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.utils.getLogger
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.utils.toHexString
import com.icure.utils.InternalIcureApi

/**
 * Recovers keys using available shamir splits and transfer keys.
 */
@InternalIcureApi
class CardinalKeyRecoveryImpl(
	private val baseExchangeKeysManager: BaseExchangeKeysManager,
	private val baseExchangeDataManager: BaseExchangeDataManager,
	private val cryptoService: CryptoService,
	private val shamirService: ShamirSecretSharingService
) : CardinalKeyRecovery{
	companion object {
		private val log = getLogger("IcureKeyRecoveryImpl")
	}

	override suspend fun recoverKeys(
		dataOwner: DataOwnerWithType,
		knownKeys: Set<CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>
	): Set<CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>> {
		if (knownKeys.isEmpty()) return emptySet()
		val missingKeys = dataOwner.dataOwner.publicKeysSpki.toMutableSet()
		missingKeys.removeAll(knownKeys.mapTo(mutableSetOf()) { it.pubSpkiHexString })
		val recoveryFunctions = listOf(this::recoverFromTransferKeys, this::recoverFromShamirSplitKeys)
		val allKeys = knownKeys.toMutableSet()
		var foundNewPrivateKeys = true
		while (missingKeys.isNotEmpty() && foundNewPrivateKeys) {
			foundNewPrivateKeys = false
			// Consider all available keys as valid for decryption while recovering other keys
			val decryptionSet = RsaDecryptionKeysSet(allKeys.map { CardinalKeyInfo(it.pubSpkiHexString, it.key.private) })
			val missingKeysFp = missingKeys.mapTo(mutableSetOf()) { it.fingerprintV1() }
			for (recoveryFunction in recoveryFunctions) {
				val recoveredKeys = recoveryFunction(dataOwner, decryptionSet, missingKeysFp)
				if (recoveredKeys.isNotEmpty()) {
					allKeys.addAll(recoveredKeys)
					missingKeys.removeAll(recoveredKeys.mapTo(mutableSetOf()) { it.pubSpkiHexString })
					foundNewPrivateKeys = true
				}
			}
		}
		return allKeys
	}

	/*TODO?
	 * Ask access back suggestion: if by getting access back to an exchange key with another data owner I may recover additional keys we could suggest
	 * to ask for access back to that data owner.
	 */

	private suspend fun recoverFromShamirSplitKeys(
		dataOwner: DataOwnerWithType,
		allKeys: RsaDecryptionKeysSet,
		missingKeysFp: Set<KeypairFingerprintV1String>
	): Set<CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>> =
		if (
			// Currently only legacy key supports shamir split
			dataOwner.dataOwner.publicKey?.takeIf { it.fingerprintV1() in missingKeysFp } != null
				&& dataOwner.dataOwner.privateKeyShamirPartitions.isNotEmpty()
		) {
			val shamirSplits = mapOf<Pair<SpkiHexString, RsaAlgorithm.RsaEncryptionAlgorithm>, Map<String, HexString>>(
				(dataOwner.dataOwner.publicKey!! to RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1) to dataOwner.dataOwner.privateKeyShamirPartitions
			)
			val exchangeKeys = shamirSplits.flatMap { (splitKeyInfo, splitKeyData) ->
				if (splitKeyInfo.first.fingerprintV1() in missingKeysFp) splitKeyData.keys else emptySet()
			}.distinct().associateWith { delegateId ->
				getExchangeKeys(dataOwner.dataOwner.id, delegateId, allKeys)
			}
			recoverWithSplits(shamirSplits, exchangeKeys)
		} else emptySet()

	private suspend fun recoverWithSplits(
		splits: Map<Pair<SpkiHexString, RsaAlgorithm.RsaEncryptionAlgorithm>, Map<String, HexString>>,
		exchangeKeysByDelegateId: Map<String, List<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>>
	): Set<CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>> =
		splits.mapNotNullTo(mutableSetOf()) { (pub, splits) ->
			if (splits.size == 1) {
				val (delegate, encryptedKey) = splits.entries.first()
				exchangeKeysByDelegateId[delegate]?.firstNotNullOfOrNull { exchangeKey ->
					kotlin.runCatching {
						val decrypted = cryptoService.aes.decrypt(encryptedKey.decodedBytes(), exchangeKey)
						tryImportPrivateKey(decrypted, pub.first, pub.second)
					}.getOrNull()
				}
			} else if (splits.size > 1) {
				val decryptedSplits = splits.mapNotNull { (delegate, encryptedPiece) ->
					tryDecryptSplitPiece(
						encryptedPiece.decodedBytes(),
						exchangeKeysByDelegateId[delegate],
						splits.size
					)
				}
				kotlin.runCatching {
					val combinedKey = shamirService.combine(decryptedSplits.map {
						// Drop the `f` padding
						ShamirSecretShare(it.toHexString().drop(1))
					})
					tryImportPrivateKey(combinedKey, pub.first, pub.second)
				}.getOrNull()
			} else null
		}

	private suspend fun tryDecryptSplitPiece(
		split: ByteArray,
		potentialKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>?,
		splitsCount: Int
	  ): ByteArray? =
		potentialKeys?.firstNotNullOfOrNull { exchangeKey ->
			kotlin.runCatching {
				cryptoService.aes.decrypt(split, exchangeKey).takeIf {
					decryptedSplitIsValid(it, splitsCount)
				}
			}.getOrNull()
		}

	private fun decryptedSplitIsValid(decryptedSplit: ByteArray, splitsCount: Int): Boolean =
		// Icure share format in hex is f8 + splitIndex + splitData
		decryptedSplit[0] == 0xf8.toByte() && decryptedSplit[1].toUByte().toInt().let {
			// Split 0 does not exist
			it in 1..splitsCount
		}

	private data class TransferKeyInfo(
		val fullKey: SpkiHexString,
		val algorithm: RsaAlgorithm.RsaEncryptionAlgorithm,
		val encryptedPrivateKey: Set<HexString>
	)
	private suspend fun recoverFromTransferKeys(
		dataOwner: DataOwnerWithType,
		allKeys: RsaDecryptionKeysSet,
		missingKeysFp: Set<KeypairFingerprintV1String>
	): Set<CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>> {
		val publicKeyFingerprintToPublicKey = dataOwner.dataOwner.publicKeysSpki.associateBy { it.fingerprintV1() }
		val missingKeysTransferData = dataOwner.dataOwner.transferKeys.values.flatMap { transferKeysByEncryptor ->
			transferKeysByEncryptor.entries.mapNotNull { (k, v) ->
				k.toFingerprintV1OrNull()?.let { it to v }
			}
		}.groupBy { it.first }.mapNotNull { (fp, encryptedData) ->
			if (fp in missingKeysFp) {
				val fullKey = publicKeyFingerprintToPublicKey[fp]
				if (fullKey != null) {
					TransferKeyInfo(
						fullKey,
						dataOwner.dataOwner.algorithmOfEncryptionKey(fullKey),
						encryptedData.mapTo(mutableSetOf()) { it.second }
					)
				} else {
					log.w { "Missing public key for transfer key with fingerprint $fp" }
					null
				}
			} else null
		}
		val availableExchangeKeys = getExchangeKeys(dataOwner.dataOwner.id, dataOwner.dataOwner.id, allKeys)
		return missingKeysTransferData.mapNotNullTo(mutableSetOf()) { transferKeyInfo ->
			tryDecryptTransferData(
				transferKeyInfo.fullKey,
				transferKeyInfo.encryptedPrivateKey,
				availableExchangeKeys,
				transferKeyInfo.algorithm
			)
		}
	}

	private suspend fun tryDecryptTransferData(
		publicKey: SpkiHexString,
		encryptedPrivateKeys: Collection<HexString>,
		availableExchangeKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		algorithm: RsaAlgorithm.RsaEncryptionAlgorithm
	): CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>? =
		encryptedPrivateKeys.firstNotNullOfOrNull { key ->
			val encryptedKeyBytes = key.decodedBytes()
			availableExchangeKeys.firstNotNullOfOrNull { exchangeKey ->
				kotlin.runCatching {
					val decryptedKeyData = cryptoService.aes.decrypt(encryptedKeyBytes, exchangeKey)
					tryImportPrivateKey(decryptedKeyData, publicKey, algorithm)
				}.getOrNull()
			}
		}

	private suspend fun tryImportPrivateKey(
		rawKeyPkcs8: ByteArray,
		expectedPub: SpkiHexString,
		algorithm: RsaAlgorithm.RsaEncryptionAlgorithm
	): CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>? {
		val importedKeypair = cryptoService.rsa.loadKeyPairPkcs8(algorithm, rawKeyPkcs8)
		val exportedPub = cryptoService.rsa.exportPublicKeySpki(importedKeypair.public)
		return if (exportedPub.toHexString() == expectedPub.s) {
			CardinalKeyInfo(expectedPub, importedKeypair)
		} else {
			log.w { "Recovered private key for ${expectedPub.s} is a valid key but does not match the public key" }
			null
		}
	}

	private suspend fun getExchangeKeys(
		from: String,
		to: String,
		availableDecryptionKeys: RsaDecryptionKeysSet,
	): List<AesKey<AesAlgorithm.CbcWithPkcs7Padding>> {
		val aesExchangeKeys = baseExchangeKeysManager.tryDecryptExchangeKeys(
			baseExchangeKeysManager.getEncryptedExchangeKeysFor(delegatorId = from, delegateId = to),
			availableDecryptionKeys
		).successfulDecryptions
		val encryptedExchangeData = baseExchangeDataManager.getExchangeDataByDelegatorDelegatePair(
			null,
			EntityReferenceInGroup(from, null),
			EntityReferenceInGroup(to, null),
			emptySet()
		)
		val exchangeData =  baseExchangeDataManager.tryDecryptExchangeKeys(
			encryptedExchangeData,
			availableDecryptionKeys
		).successfulDecryptions
		return (aesExchangeKeys + exchangeData).distinctBy { cryptoService.aes.exportKey(it).toHexString() }
	}
}
