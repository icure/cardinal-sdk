package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.crypto.CardinalKeyRecovery
import com.icure.cardinal.sdk.crypto.KeyPairRecoverer
import com.icure.cardinal.sdk.crypto.RecoveryDataEncryption
import com.icure.cardinal.sdk.crypto.entities.CardinalKeyInfo
import com.icure.cardinal.sdk.crypto.entities.RecoveryDataKey
import com.icure.cardinal.sdk.crypto.entities.RecoveryResult
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.extensions.type
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class KeyPairRecovererImpl(
	private val recoveryDataEncryption: RecoveryDataEncryption,
	private val cardinalKeyRecovery: CardinalKeyRecovery,
	private val cryptoService: CryptoService,
	initialKnownKeys: Map<String, Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>
) : KeyPairRecoverer {
	private val allKnownKeys = initialKnownKeys.mapValues { entry ->
		entry.value.toMutableMap()
	}

	override suspend fun recoverWithRecoveryKey(
		recoveryKey: RecoveryDataKey,
		autoDelete: Boolean,
	): RecoveryResult<Map<String, Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>> =
		recoveryDataEncryption.getAndDecryptKeyPairsRecoveryData(recoveryKey, autoDelete)

	override suspend fun waitForRecoveryKey(
		recoveryKey: RecoveryDataKey,
		autoDelete: Boolean,
		waitSeconds: Int
	): RecoveryResult<Map<String, Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>> =
		recoveryDataEncryption.waitAndDecryptKeyPairsRecoveryData(recoveryKey, autoDelete, waitSeconds)

	override suspend fun recoverWithEncryptionKeys(
		dataOwner: DataOwnerWithType,
		recoveredKeys: Collection<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>
	): Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>> {
		val knownKeysForDataOwner = requireNotNull(allKnownKeys[dataOwner.dataOwner.id]) {
			"Unexpected data owner ${dataOwner.type} ${dataOwner.dataOwner.id}, can only use key recoverer for data owner that is part of the current data owner hierarchy"
		}
		recoveredKeys.forEach { recoveredKey ->
			knownKeysForDataOwner[cryptoService.rsa.exportSpkiHex(recoveredKey.public)] = recoveredKey
		}
		val recovered = cardinalKeyRecovery.recoverKeys(
			dataOwner,
			knownKeysForDataOwner.mapTo(mutableSetOf()) { CardinalKeyInfo(it.key, it.value) },
		)
		val newlyRecovered = mutableMapOf<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>()
		recovered.forEach { recoveredKey ->
			val keySpki = cryptoService.rsa.exportSpkiHex(recoveredKey.key.public)
			if (!knownKeysForDataOwner.containsKey(keySpki)) {
				knownKeysForDataOwner[keySpki] = recoveredKey.key
				newlyRecovered[keySpki] = recoveredKey.key
			}
		}
		return newlyRecovered
	}
}