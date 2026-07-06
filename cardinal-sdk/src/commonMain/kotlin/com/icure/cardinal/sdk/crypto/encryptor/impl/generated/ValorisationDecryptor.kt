// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedValorisation
import com.icure.cardinal.sdk.model.embed.EncryptedValorisation
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object ValorisationDecryptor :
	AbstractEntityDecryptor<EncryptedValorisation, DecryptedValorisation>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedValorisation,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedValorisation {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedValorisation(
				startOfValidity =
					decryptedContent["startOfValidity"].let {
						if (it != null) {
							usedEncryptedContent += "startOfValidity"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.startOfValidity
						}
					},
				endOfValidity =
					decryptedContent["endOfValidity"].let {
						if (it != null) {
							usedEncryptedContent += "endOfValidity"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.endOfValidity
						}
					},
				predicate =
					decryptedContent["predicate"].let {
						if (it != null) {
							usedEncryptedContent += "predicate"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.predicate
						}
					},
				reference =
					decryptedContent["reference"].let {
						if (it != null) {
							usedEncryptedContent += "reference"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.reference
						}
					},
				totalAmount =
					decryptedContent["totalAmount"].let {
						if (it != null) {
							usedEncryptedContent += "totalAmount"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.totalAmount
						}
					},
				reimbursement =
					decryptedContent["reimbursement"].let {
						if (it != null) {
							usedEncryptedContent += "reimbursement"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.reimbursement
						}
					},
				patientIntervention =
					decryptedContent["patientIntervention"].let {
						if (it != null) {
							usedEncryptedContent += "patientIntervention"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.patientIntervention
						}
					},
				doctorSupplement =
					decryptedContent["doctorSupplement"].let {
						if (it != null) {
							usedEncryptedContent += "doctorSupplement"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.doctorSupplement
						}
					},
				vat =
					decryptedContent["vat"].let {
						if (it != null) {
							usedEncryptedContent += "vat"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.vat
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
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Valorisation encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
