// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedTypedValue
import com.icure.cardinal.sdk.model.embed.EncryptedTypedValue
import com.icure.cardinal.sdk.serialization.InstantSerializer
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object TypedValueDecryptor :
	AbstractEntityDecryptor<EncryptedTypedValue, DecryptedTypedValue>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedTypedValue,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedTypedValue {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedTypedValue(
				type =
					decryptedContent["type"].let {
						if (it != null) {
							usedEncryptedContent += "type"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.type
						}
					},
				booleanValue =
					decryptedContent["booleanValue"].let {
						if (it != null) {
							usedEncryptedContent += "booleanValue"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.booleanValue
						}
					},
				integerValue =
					decryptedContent["integerValue"].let {
						if (it != null) {
							usedEncryptedContent += "integerValue"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.integerValue
						}
					},
				doubleValue =
					decryptedContent["doubleValue"].let {
						if (it != null) {
							usedEncryptedContent += "doubleValue"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.doubleValue
						}
					},
				stringValue =
					decryptedContent["stringValue"].let {
						if (it != null) {
							usedEncryptedContent += "stringValue"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.stringValue
						}
					},
				dateValue =
					decryptedContent["dateValue"].let {
						if (it != null) {
							usedEncryptedContent += "dateValue"
							encryptedContentDecoder.decodeFromJsonElement(InstantSerializer.nullable, it)
						} else {
							encryptedEntity.dateValue
						}
					},
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The TypedValue encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
