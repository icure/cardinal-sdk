package com.icure.cardinal.sdk.crypto.impl

import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.utils.toHexString
import com.icure.cardinal.sdk.crypto.SecureDelegationsEncryption
import com.icure.cardinal.sdk.crypto.UserEncryptionKeysManager
import com.icure.cardinal.sdk.crypto.entities.VerifiedRsaEncryptionKeysSet
import com.icure.cardinal.sdk.model.embed.SecureDelegation
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.cardinal.sdk.utils.IllegalEntityException
import com.icure.utils.InternalIcureApi
import com.icure.cardinal.sdk.utils.base64Encode
import com.icure.cardinal.sdk.utils.decode
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.toByteArray

@InternalIcureApi
class SecureDelegationsEncryptionImpl(
	private val userEncryptionKeys: UserEncryptionKeysManager,
	private val cryptoService: CryptoService
) : SecureDelegationsEncryption {
	companion object {
		/**
		 * WARNING: this values should be ALWAYS be the string 'Cure' and its utf-8 bytes. If changed, it would not be possible to decrypt old secretIds and owningEntityIds
		 * anymore.
		 */
		private const val decryptionValidatorPrefix = "Cure"
		private val decryptionValidatorBytes = decryptionValidatorPrefix.toByteArray(Charsets.UTF_8)
	}

	override suspend fun decryptExchangeDataId(encryptedExchangeIds: Map<KeypairFingerprintV2String, Base64String>): String? =
		cryptoService.decryptDataWithKeys(
			encryptedExchangeIds,
			userEncryptionKeys.getAllDecryptionKeys(),
			KeyIdentifierFormat.FingerprintV2,
			EncodedDataFormat.Base64
		)?.decodeToString()

	override suspend fun encryptExchangeDataId(
		exchangeDataId: String,
		publicKeys: VerifiedRsaEncryptionKeysSet
	): Map<KeypairFingerprintV2String, Base64String> =
		cryptoService.encryptDataWithKeys(
			exchangeDataId.toByteArray(Charsets.UTF_8),
			publicKeys,
			KeyIdentifierFormat.FingerprintV2
		)

	override suspend fun encryptEncryptionKey(hexKey: HexString, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): Base64String =
		cryptoService.aes.encrypt(
			decryptionValidatorBytes + hexKey.decodedBytes(),
			key
		).base64Encode()

	override suspend fun encryptEncryptionKeys(hexKeys: Set<HexString>, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): Set<Base64String> =
		hexKeys.mapTo(mutableSetOf()) { encryptEncryptionKey(it, key) }

	override suspend fun decryptEncryptionKey(encrypted: Base64String, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): HexString =
		cryptoService.aes.decrypt(encrypted.decode(), key).also {
			if (!it.sliceArray(0 until decryptionValidatorBytes.size).contentEquals(decryptionValidatorBytes))
				throw IllegalEntityException("Decrypted key is not valid")
		}.let { HexString(it.sliceArray(decryptionValidatorBytes.size until it.size).toHexString()) }

	override suspend fun decryptEncryptionKeys(delegation: SecureDelegation, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): Set<HexString> =
		delegation.encryptionKeys.mapTo(mutableSetOf()) { decryptEncryptionKey(it, key) }

	override suspend fun encryptSecretId(secretId: String, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): Base64String =
		cryptoService.aes.encrypt(
			(decryptionValidatorPrefix + secretId).toByteArray(Charsets.UTF_8),
			key
		).base64Encode()

	override suspend fun encryptSecretIds(secretIds: Set<String>, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): Set<Base64String> =
		secretIds.mapTo(mutableSetOf()) { encryptSecretId(it, key) }

	override suspend fun decryptSecretId(encrypted: Base64String, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): String =
		cryptoService.aes.decrypt(encrypted.decode(), key).let {
			val decrypted = it.decodeToString()
			if (!decrypted.startsWith(decryptionValidatorPrefix)) throw IllegalEntityException("Decrypted secretId is not valid")
			decrypted.substring(decryptionValidatorPrefix.length)
		}

	override suspend fun decryptSecretIds(delegation: SecureDelegation, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): Set<String> =
		delegation.secretIds.mapTo(mutableSetOf()) { decryptSecretId(it, key) }

	override suspend fun encryptOwningEntityId(owningEntityId: String, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): Base64String =
		cryptoService.aes.encrypt(
			(decryptionValidatorPrefix + owningEntityId).toByteArray(Charsets.UTF_8),
			key
		).base64Encode()

	override suspend fun encryptOwningEntityIds(owningEntityIds: Set<String>, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): Set<Base64String> =
		owningEntityIds.mapTo(mutableSetOf()) { encryptOwningEntityId(it, key) }

	override suspend fun decryptOwningEntityId(encrypted: Base64String, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): String =
		cryptoService.aes.decrypt(encrypted.decode(), key).let {
			val decrypted = it.decodeToString()
			if (!decrypted.startsWith(decryptionValidatorPrefix)) throw IllegalEntityException("Decrypted owningEntityId is not valid")
			decrypted.substring(decryptionValidatorPrefix.length)
		}

	override suspend fun decryptOwningEntityIds(delegation: SecureDelegation, key: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): Set<String> =
		delegation.owningEntityIds.mapTo(mutableSetOf()) { decryptOwningEntityId(it, key) }
}