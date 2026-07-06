package com.icure.cardinal.sdk.crypto.encryptor.impl

import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.decode
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject

internal abstract class AbstractEntityDecryptor<ENCRYPTED : Encryptable, DECRYPTED : Encryptable> :
	EntityDecryptor<ENCRYPTED, DECRYPTED> {

	protected suspend fun decryptAndPatchContent(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: ENCRYPTED,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		cryptoService: CryptoService,
	): Map<String, JsonElement> {
		val decryptedJson = encryptedEntity.encryptedSelf?.decode()?.let { encryptedSelfBytes ->
			decryptionKeys.firstNotNullOfOrNull { decryptionKey ->
				currentCoroutineContext().ensureActive()
				kotlin.runCatching {
					val decryptedBytes = cryptoService.aes.decrypt(encryptedSelfBytes, decryptionKey)
					// Note: chance that if wrong key provided we get "successfully" decrypt garbage -> we consider
					// invalid json in decrypted content as a decryption error.
					Serialization.json.parseToJsonElement(decryptedBytes.decodeToString()) as? JsonObject
				}.getOrNull()
			}
				?: throw EntityEncryptionException("Failed to decrypt ${encryptedEntity::class} content with provided keys")
		} ?: JsonObject(emptyMap())
		return if (patchDecryptedSelfJson != null) {
			patchDecryptedSelfJson(decryptedJson)
		} else {
			decryptedJson
		}
	}
}