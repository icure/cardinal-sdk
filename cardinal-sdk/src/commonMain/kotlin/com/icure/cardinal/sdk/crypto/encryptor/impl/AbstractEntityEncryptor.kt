package com.icure.cardinal.sdk.crypto.encryptor.impl

import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.decode
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.utils.base64Encode
import com.icure.utils.InternalIcureApi
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.toByteArray
import kotlinx.coroutines.CancellationException
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject

@InternalIcureApi
internal abstract class AbstractEntityEncryptor<ENCRYPTED : Encryptable, DECRYPTED : Encryptable> :
	EntityEncryptor<ENCRYPTED, DECRYPTED> {

	protected suspend fun getUpdatedEncryptSelf(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		entity: DECRYPTED,
		updatedEncryptedSelfContent: JsonObject,
		cryptoService: CryptoService,
	): Base64String? {
		if (updatedEncryptedSelfContent.isEmpty()) return null
		val existingEncryptedSelfContent = entity.encryptedSelf?.let {
			kotlin.runCatching {
				val decryptedBytes = cryptoService.aes.decrypt(it.decode(), encryptionKey)
				Serialization.json.parseToJsonElement(decryptedBytes.decodeToString()).jsonObject
			}.onFailure { e -> if (e is CancellationException) throw e }.getOrNull()
		}
		return if (existingEncryptedSelfContent == updatedEncryptedSelfContent) {
			entity.encryptedSelf
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
}