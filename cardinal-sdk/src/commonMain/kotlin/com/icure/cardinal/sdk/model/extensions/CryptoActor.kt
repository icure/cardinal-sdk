package com.icure.cardinal.sdk.model.extensions

import com.icure.cardinal.sdk.model.CryptoActorStub
import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.base.CryptoActor
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.kryptom.crypto.RsaAlgorithm

/**
 * All public keys of the crypto actor to be used for OAEP with SHA1
 */
val CryptoActor.publicKeysWithSha1Spki: Set<SpkiHexString> get() =
	(aesExchangeKeys.keys.mapNotNull { it.asPublicKey() } + listOfNotNull(publicKey)).toSet()

/**
 * All public keys of the crypto actor to be used for OAEP with SHA256
 */
val CryptoActor.publicKeysWithSha256Spki: Set<SpkiHexString> get() =
	publicKeysForOaepWithSha256.toSet()

/**
 * All public keys of the crypto actor
 */
val CryptoActor.publicKeysSpki: Set<SpkiHexString> get() =
	publicKeysWithSha1Spki + publicKeysWithSha256Spki

fun CryptoActor.algorithmOfEncryptionKey(encryptionKey: SpkiHexString) =
	when {
		publicKeysWithSha1Spki.contains(encryptionKey) -> RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1
		publicKeysWithSha256Spki.contains(encryptionKey) -> RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256
		else -> throw IllegalArgumentException("Key $encryptionKey is not a valid encryption key of crypto actor $id")
	}

fun CryptoActor.asStub() =
	this as? CryptoActorStub ?: CryptoActorStub(
		id = id,
		rev = requireNotNull(rev) { "You can only convert to a stub crypto actors that are already persisted." },
		hcPartyKeys = hcPartyKeys,
		aesExchangeKeys = aesExchangeKeys,
		transferKeys = transferKeys,
		privateKeyShamirPartitions = privateKeyShamirPartitions,
		publicKey = publicKey,
		publicKeysForOaepWithSha256 = publicKeysForOaepWithSha256,
		cryptoActorProperties = cryptoActorProperties,
		dataOwnerGroups = dataOwnerGroups
	)

val DataOwnerWithType.type: DataOwnerType get() = when(this) {
	is DataOwnerWithType.DeviceDataOwner -> DataOwnerType.Device
	is DataOwnerWithType.HcpDataOwner -> DataOwnerType.Hcp
	is DataOwnerWithType.PatientDataOwner -> DataOwnerType.Patient
}

fun DataOwnerWithType.asStub(): CryptoActorStubWithType =
	CryptoActorStubWithType(type = type, stub = dataOwner.asStub())
