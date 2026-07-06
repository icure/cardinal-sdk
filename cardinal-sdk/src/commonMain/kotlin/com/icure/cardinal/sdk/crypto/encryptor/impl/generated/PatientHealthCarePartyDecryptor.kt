// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedPatientHealthCareParty
import com.icure.cardinal.sdk.model.embed.EncryptedPatientHealthCareParty
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object PatientHealthCarePartyDecryptor :
	AbstractEntityDecryptor<EncryptedPatientHealthCareParty, DecryptedPatientHealthCareParty>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedPatientHealthCareParty,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedPatientHealthCareParty {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedPatientHealthCareParty(
				type =
					decryptedContent["type"].let {
						if (it != null) {
							usedEncryptedContent += "type"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.type
						}
					},
				healthcarePartyId =
					decryptedContent["healthcarePartyId"].let {
						if (it != null) {
							usedEncryptedContent += "healthcarePartyId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.healthcarePartyId
						}
					},
				sendFormats =
					decryptedContent["sendFormats"].let {
						if (it != null) {
							usedEncryptedContent += "sendFormats"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.sendFormats
						}
					},
				referralPeriods =
					decryptedContent["referralPeriods"].let {
						if (it != null) {
							usedEncryptedContent += "referralPeriods"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.referralPeriods
						}
					},
				properties =
					decryptedContent["properties"].let {
						if (it != null) {
							usedEncryptedContent += "properties"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.properties?.let {
								it.mapTo(mutableSetOf()) { x0 ->
									PropertyStubDecryptor.decrypt(
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
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The PatientHealthCareParty encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
