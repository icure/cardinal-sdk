package com.icure.cardinal.sdk.crypto.encryptor

import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import kotlinx.serialization.json.JsonObject

internal interface ExtensionsEncryptors {
	suspend fun encryptExtension(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		extensions: JsonObject,
	): JsonObject

	suspend fun decryptExtension(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		extensions: JsonObject,
	): JsonObject
}

internal suspend fun ExtensionsEncryptors.encryptExtension(
	encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
	extensions: JsonObject?
): JsonObject? {
	if (extensions == null) return null
	return encryptExtension(encryptionKey, extensions)
}
