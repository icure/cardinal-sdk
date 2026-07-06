// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedFlatRateTarification
import com.icure.cardinal.sdk.model.embed.EncryptedFlatRateTarification
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object FlatRateTarificationDecryptor :
	AbstractEntityDecryptor<EncryptedFlatRateTarification, DecryptedFlatRateTarification>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedFlatRateTarification,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedFlatRateTarification {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedFlatRateTarification(
				code =
					decryptedContent["code"].let {
						if (it != null) {
							usedEncryptedContent += "code"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.code
						}
					},
				flatRateType =
					decryptedContent["flatRateType"].let {
						if (it != null) {
							usedEncryptedContent += "flatRateType"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.flatRateType
						}
					},
				label =
					decryptedContent["label"].let {
						if (it != null) {
							usedEncryptedContent += "label"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.label
						}
					},
				valorisations =
					decryptedContent["valorisations"].let {
						if (it != null) {
							usedEncryptedContent += "valorisations"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.valorisations.map { x0 ->
								ValorisationDecryptor.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = x0,
									patchDecryptedSelfJson = patchDecryptedSelfJson,
									ignoreUnknownDecryptedFields = ignoreUnknownDecryptedFields,
									encryptedContentDecoder = encryptedContentDecoder,
									cryptoService = cryptoService,
								)
							}
						}
					},
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The FlatRateTarification encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
