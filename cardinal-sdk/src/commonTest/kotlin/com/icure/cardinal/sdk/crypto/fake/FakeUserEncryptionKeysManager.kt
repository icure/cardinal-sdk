package com.icure.cardinal.sdk.crypto.fake

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.cardinal.sdk.crypto.UserEncryptionKeysManager
import com.icure.cardinal.sdk.crypto.entities.CachedKeypairDetails
import com.icure.cardinal.sdk.crypto.entities.CardinalKeyInfo
import com.icure.cardinal.sdk.crypto.entities.RsaDecryptionKeysSet
import com.icure.cardinal.sdk.crypto.entities.UserKeyPairInformation
import com.icure.cardinal.sdk.crypto.entities.toPrivateKeyInfo
import com.icure.cardinal.sdk.model.CryptoActorStub
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
class FakeUserEncryptionKeysManager(private val selfDelegatorActorId: String) : UserEncryptionKeysManager {
	private val selfKeys = mutableMapOf<KeypairFingerprintV2String, CachedKeypairDetails>()

	fun addSelfKey(
		key: CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>,
		verified: Boolean
	) {
		selfKeys[key.pubSpkiHexString.fingerprintV2()] = CachedKeypairDetails(key, verified, verified)
	}

	override fun getCurrentUserHierarchyAvailableKeypairs(): UserKeyPairInformation {
		TODO("Not yet implemented")
	}

	override fun getKeyPairForFingerprint(fingerprint: KeypairFingerprintV2String): CachedKeypairDetails? =
		selfKeys[fingerprint]

	override fun delegatorActorVerifiedKeys(): Set<CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>> =
		selfKeys.values.filter { it.isVerified }.map { it.keyPair }.toSet()

	override fun getVerifiedPublicKeysFor(dataOwner: CryptoActorStub): Set<SpkiHexString> {
		TODO("Not yet implemented")
	}

	override fun getAllDecryptionKeys(): RsaDecryptionKeysSet =
		RsaDecryptionKeysSet(selfKeys.values.map { it.keyPair.toPrivateKeyInfo() })

	override suspend fun reloadKeys() {
	}

	override fun delegatorActorId(): String =
		selfDelegatorActorId

	override fun delegatorActorIsAnonymous(): Boolean {
		TODO("Not yet implemented")
	}

	override fun getVerifiedEncryptionKeysForDataOwnerIfInCurrentHierarchy(dataOwnerId: String): Set<CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>? {
		if (dataOwnerId == selfDelegatorActorId) {
			return delegatorActorVerifiedKeys()
		} else TODO("Not yet implemented")
	}

	override fun getDecryptionKeysForDataOwnerIfInCurrentHierarchy(dataOwnerId: String): RsaDecryptionKeysSet? {
		if (dataOwnerId == selfDelegatorActorId) {
			return getAllDecryptionKeys()
		} else TODO("Not yet implemented")
	}

	override fun delegatorActorHierarchy(from: String?): List<String> {
		TODO("Not yet implemented")
	}
}