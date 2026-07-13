package com.icure.cardinal.sdk.crypto.encryptor.impl

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.UndecryptableContentException
import com.icure.cardinal.sdk.utils.decode
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.utils.base64Encode
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.toByteArray
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject

internal object EncryptorsHelpers {
	suspend fun getUpdatedEncryptSelf(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		updatedEncryptedSelfContent: JsonObject,
		existingEncryptedSelf: Base64String?,
		cryptoService: CryptoService,
	): Base64String? {
		if (updatedEncryptedSelfContent.isEmpty()) return null
		val existingEncryptedSelfContent = existingEncryptedSelf?.let {
			kotlin.runCatching {
				val decryptedBytes = cryptoService.aes.decrypt(it.decode(), encryptionKey)
				Serialization.json.parseToJsonElement(decryptedBytes.decodeToString()).jsonObject
			}.onFailure { e -> if (e is CancellationException) throw e }.getOrNull()
		}
		return if (existingEncryptedSelfContent == updatedEncryptedSelfContent) {
			existingEncryptedSelf
		} else {
			Base64String(
				base64Encode(
					cryptoService.aes.encrypt(
						updatedEncryptedSelfContent.toString().toByteArray(Charsets.UTF_8),
						encryptionKey
					)
				)
			)
		}
	}

	suspend fun decryptEncryptSelf(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedSelf: Base64String?,
		cryptoService: CryptoService,
	): JsonObject =
		encryptedSelf?.decode()?.let { encryptedSelfBytes ->
			decryptionKeys.firstNotNullOfOrNull { decryptionKey ->
				currentCoroutineContext().ensureActive()
				kotlin.runCatching {
					val decryptedBytes = cryptoService.aes.decrypt(encryptedSelfBytes, decryptionKey)
					// Note: since we are using AES-CBC there is a chance that if the wrong key is provided ww get some
					// garbage in decryptedBytes without any exception being thrown.
					// The chances of also getting a valid json object in utf8 in that case are basically none, so it
					// should be safe to accept any valid json object coming out of it as valid decryption, and treat
					// successful decryption to not valid json object as bad key.
					Serialization.json.parseToJsonElement(decryptedBytes.decodeToString()) as? JsonObject
				}.getOrNull()
			}
				?: throw UndecryptableContentException("Failed to decrypt content with provided keys")
		} ?: JsonObject(emptyMap())
}