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
	private val knownKeys: Map<String, Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>
) : KeyPairRecoverer {

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

	override suspend fun getRecoverableWithEncryptionKeys(
		dataOwner: DataOwnerWithType,
		recoveredKeys: Collection<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>
	): Set<SpkiHexString> {
		val knownKeysForDataOwner = requireNotNull(knownKeys[dataOwner.dataOwner.id]) {
			"Unexpected data owner ${dataOwner.type} ${dataOwner.dataOwner.id}, can only use key recoverer for data owner that is part of the current data owner hierarchy"
		}
		val combinedKeyInfo = (
			knownKeysForDataOwner.map { CardinalKeyInfo(it.key, it.value) } +
				recoveredKeys.map { CardinalKeyInfo(cryptoService.rsa.exportSpkiHex(it.public), it) }
		).toSet()
		val recovered = cardinalKeyRecovery.recoverKeys(
			dataOwner,
			combinedKeyInfo
		)
		val knownPubs = combinedKeyInfo.mapTo(mutableSetOf()) { it.pubSpkiHexString }
		return recovered.mapNotNull { if (it.pubSpkiHexString in knownPubs) null else it.pubSpkiHexString }.toSet()
	}
}