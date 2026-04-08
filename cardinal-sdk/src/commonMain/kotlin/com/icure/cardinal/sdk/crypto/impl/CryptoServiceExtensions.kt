package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.crypto.entities.CardinalKeyInfo
import com.icure.cardinal.sdk.crypto.entities.RsaDecryptionKeysSet
import com.icure.cardinal.sdk.crypto.entities.VerifiedRsaEncryptionKeysSet
import com.icure.cardinal.sdk.model.base.CryptoActor
import com.icure.cardinal.sdk.model.extensions.publicKeysWithSha1Spki
import com.icure.cardinal.sdk.model.extensions.publicKeysWithSha256Spki
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.utils.IllegalEntityException
import com.icure.cardinal.sdk.utils.base64Encode
import com.icure.cardinal.sdk.utils.decode
import com.icure.cardinal.sdk.utils.getLogger
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.PrivateRsaKey
import com.icure.kryptom.crypto.PublicRsaKey
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaService
import com.icure.kryptom.utils.toHexString
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.CancellationException

private val log = getLogger("CryptoService")

@InternalIcureApi
sealed interface KeyIdentifierFormat<T> {
	fun format(key: CardinalKeyInfo<*>): T
	fun takeKeyFrom(rsaDecryptionKeys: RsaDecryptionKeysSet, identifier: T): PrivateRsaKey<RsaAlgorithm.RsaEncryptionAlgorithm>?

	data object FingerprintV1 : KeyIdentifierFormat<KeypairFingerprintV1String> {
		override fun format(key: CardinalKeyInfo<*>) = key.pubSpkiHexString.fingerprintV1()
		override fun takeKeyFrom(rsaDecryptionKeys: RsaDecryptionKeysSet, identifier: KeypairFingerprintV1String) =
			rsaDecryptionKeys.getByFingerprintV1(identifier)
	}

	data object FingerprintV2 : KeyIdentifierFormat<KeypairFingerprintV2String> {
		override fun format(key: CardinalKeyInfo<*>) = key.pubSpkiHexString.fingerprintV2()

		override fun takeKeyFrom(rsaDecryptionKeys: RsaDecryptionKeysSet, identifier: KeypairFingerprintV2String) =
			rsaDecryptionKeys.getByFingerprintV2(identifier)
	}
}

@InternalIcureApi
sealed interface EncodedDataFormat<T> {
	fun decode(encoded: T): ByteArray

	data object Base64 : EncodedDataFormat<Base64String> {
		override fun decode(encoded: Base64String) = encoded.decode()
	}

	data object Hex : EncodedDataFormat<HexString> {
		override fun decode(encoded: HexString) = encoded.decodedBytes()
	}
}

@InternalIcureApi
suspend fun <T> CryptoService.encryptDataWithKeys(
	data: ByteArray,
	encryptionKeysSet: VerifiedRsaEncryptionKeysSet,
	keyIdentifierFormat: KeyIdentifierFormat<T>,
): Map<T, Base64String> =
	encryptionKeysSet.allKeys.associate { keyInfo ->
		keyIdentifierFormat.format(keyInfo) to rsa.encrypt(data, keyInfo.key).base64Encode()
	}

@InternalIcureApi
suspend fun <KeyIdentifier, EncodedData> CryptoService.decryptDataWithKeys(
	data: Map<KeyIdentifier, EncodedData>,
	decryptionKeys: RsaDecryptionKeysSet,
	keyIdentifierFormat: KeyIdentifierFormat<KeyIdentifier>,
	encodedDataFormat: EncodedDataFormat<EncodedData>
): ByteArray? =
	data.firstNotNullOfOrNull { (fp, encryptedAndEncoded) ->
		kotlin.runCatching {
			keyIdentifierFormat.takeKeyFrom(decryptionKeys, fp)?.let {
				rsa.decrypt(encodedDataFormat.decode(encryptedAndEncoded), it)
			}
		}.onFailure {
			if (it is CancellationException) throw it
			log.w(it) { "Failed to decrypt data using RSA key $fp" }
		}.getOrNull()
	}

@InternalIcureApi
suspend fun CryptoService.loadEncryptionKeysForDataOwner(
	cryptoActor: CryptoActor,
	subset: Set<SpkiHexString>? = null
): List<CardinalKeyInfo<PublicRsaKey<RsaAlgorithm.RsaEncryptionAlgorithm>>> {
	val sha1Keys = cryptoActor.publicKeysWithSha1Spki
	val sha256Keys = cryptoActor.publicKeysWithSha256Spki
	if ((sha1Keys + sha256Keys).size != sha1Keys.size + sha256Keys.size) throw IllegalEntityException(
		"Crypto actor ${cryptoActor.id} has some ambiguous keys (for both OAEP with SHA1 and OAEP with SHA256 usages)."
	)
	val sha256ToLoad = subset?.intersect(sha256Keys) ?: sha256Keys
	val sha1ToLoad = subset?.intersect(sha1Keys) ?: sha1Keys
	return sha256ToLoad.map {
		CardinalKeyInfo(
			pubSpkiHexString = it,
			key = rsa.loadPublicKeySpki(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256, it.bytes())
		)
	} + sha1ToLoad.map {
		CardinalKeyInfo(
			pubSpkiHexString = it,
			key = rsa.loadPublicKeySpki(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1, it.bytes())
		)
	}
}

@InternalIcureApi
suspend fun CryptoService.loadEncryptionKeyForDataOwner(
	cryptoActor: CryptoActor,
	spki: SpkiHexString
): PublicRsaKey<RsaAlgorithm.RsaEncryptionAlgorithm> =
	when (spki) {
		in cryptoActor.publicKeysWithSha1Spki -> {
			rsa.loadPublicKeySpki(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1, spki.bytes())
		}
		in cryptoActor.publicKeysWithSha256Spki -> {
			rsa.loadPublicKeySpki(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256, spki.bytes())
		}
		else -> throw IllegalArgumentException("The provided spki $spki is not a public key of the crypto actor ${cryptoActor.id}.")
	}

suspend fun RsaService.exportSpkiHex(publicKey: PublicRsaKey<*>) =
	SpkiHexString(exportPublicKeySpki(publicKey).toHexString())
