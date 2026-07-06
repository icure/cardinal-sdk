// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedInsurability
import com.icure.cardinal.sdk.model.embed.EncryptedInsurability
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object InsurabilityDecryptor :
	AbstractEntityDecryptor<EncryptedInsurability, DecryptedInsurability>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedInsurability,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedInsurability {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedInsurability(
				parameters =
					decryptedContent["parameters"].let {
						if (it != null) {
							usedEncryptedContent += "parameters"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.parameters
						}
					},
				hospitalisation =
					decryptedContent["hospitalisation"].let {
						if (it != null) {
							usedEncryptedContent += "hospitalisation"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.hospitalisation
						}
					},
				ambulatory =
					decryptedContent["ambulatory"].let {
						if (it != null) {
							usedEncryptedContent += "ambulatory"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.ambulatory
						}
					},
				dental =
					decryptedContent["dental"].let {
						if (it != null) {
							usedEncryptedContent += "dental"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.dental
						}
					},
				identificationNumber =
					decryptedContent["identificationNumber"].let {
						if (it != null) {
							usedEncryptedContent += "identificationNumber"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.identificationNumber
						}
					},
				insuranceId =
					decryptedContent["insuranceId"].let {
						if (it != null) {
							usedEncryptedContent += "insuranceId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.insuranceId
						}
					},
				startDate =
					decryptedContent["startDate"].let {
						if (it != null) {
							usedEncryptedContent += "startDate"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.startDate
						}
					},
				endDate =
					decryptedContent["endDate"].let {
						if (it != null) {
							usedEncryptedContent += "endDate"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.endDate
						}
					},
				titularyId =
					decryptedContent["titularyId"].let {
						if (it != null) {
							usedEncryptedContent += "titularyId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.titularyId
						}
					},
				encryptedSelf = encryptedEntity.encryptedSelf,
				extensions = encryptedEntity.extensions,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Insurability encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
