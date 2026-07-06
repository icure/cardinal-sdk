// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedContent
import com.icure.cardinal.sdk.model.embed.EncryptedContent
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
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

internal object ContentDecryptor : AbstractEntityDecryptor<EncryptedContent, DecryptedContent>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedContent,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedContent {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedContent(
				stringValue =
					decryptedContent["stringValue"].let {
						if (it != null) {
							usedEncryptedContent += "stringValue"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.stringValue
						}
					},
				numberValue =
					decryptedContent["numberValue"].let {
						if (it != null) {
							usedEncryptedContent += "numberValue"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.numberValue
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
				instantValue =
					decryptedContent["instantValue"].let {
						if (it != null) {
							usedEncryptedContent += "instantValue"
							encryptedContentDecoder.decodeFromJsonElement(InstantSerializer.nullable, it)
						} else {
							encryptedEntity.instantValue
						}
					},
				fuzzyDateValue =
					decryptedContent["fuzzyDateValue"].let {
						if (it != null) {
							usedEncryptedContent += "fuzzyDateValue"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.fuzzyDateValue
						}
					},
				binaryValue =
					decryptedContent["binaryValue"].let {
						if (it != null) {
							usedEncryptedContent += "binaryValue"
							encryptedContentDecoder.decodeFromJsonElement(ByteArraySerializer.nullable, it)
						} else {
							encryptedEntity.binaryValue
						}
					},
				documentId =
					decryptedContent["documentId"].let {
						if (it != null) {
							usedEncryptedContent += "documentId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.documentId
						}
					},
				measureValue =
					decryptedContent["measureValue"].let {
						if (it != null) {
							usedEncryptedContent += "measureValue"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.measureValue
						}
					},
				medicationValue =
					decryptedContent["medicationValue"].let {
						if (it != null) {
							usedEncryptedContent += "medicationValue"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.medicationValue
						}
					},
				timeSeries =
					decryptedContent["timeSeries"].let {
						if (it != null) {
							usedEncryptedContent += "timeSeries"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.timeSeries
						}
					},
				compoundValue =
					decryptedContent["compoundValue"].let {
						if (it != null) {
							usedEncryptedContent += "compoundValue"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.compoundValue?.let {
								it.map { x0 ->
									ServiceDecryptor.decrypt(
										decryptionKeys = decryptionKeys,
										encryptedEntity = x0,
										patchDecryptedSelfJson = patchDecryptedSelfJson,
										ignoreUnknownDecryptedFields = ignoreUnknownDecryptedFields,
										encryptedContentDecoder = encryptedContentDecoder,
										cryptoService = cryptoService,
									)
								}
							}
						}
					},
				ratio =
					decryptedContent["ratio"].let {
						if (it != null) {
							usedEncryptedContent += "ratio"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.ratio
						}
					},
				range =
					decryptedContent["range"].let {
						if (it != null) {
							usedEncryptedContent += "range"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.range
						}
					},
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Content encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
