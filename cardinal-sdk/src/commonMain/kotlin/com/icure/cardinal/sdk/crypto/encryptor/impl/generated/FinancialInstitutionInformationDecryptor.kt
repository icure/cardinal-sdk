// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedFinancialInstitutionInformation
import com.icure.cardinal.sdk.model.embed.EncryptedFinancialInstitutionInformation
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object FinancialInstitutionInformationDecryptor :
	AbstractEntityDecryptor<EncryptedFinancialInstitutionInformation, DecryptedFinancialInstitutionInformation>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedFinancialInstitutionInformation,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedFinancialInstitutionInformation {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedFinancialInstitutionInformation(
				name =
					decryptedContent["name"].let {
						if (it != null) {
							usedEncryptedContent += "name"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.name
						}
					},
				key =
					decryptedContent["key"].let {
						if (it != null) {
							usedEncryptedContent += "key"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.key
						}
					},
				bankAccount =
					decryptedContent["bankAccount"].let {
						if (it != null) {
							usedEncryptedContent += "bankAccount"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.bankAccount
						}
					},
				bic =
					decryptedContent["bic"].let {
						if (it != null) {
							usedEncryptedContent += "bic"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.bic
						}
					},
				proxyBankAccount =
					decryptedContent["proxyBankAccount"].let {
						if (it != null) {
							usedEncryptedContent += "proxyBankAccount"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.proxyBankAccount
						}
					},
				proxyBic =
					decryptedContent["proxyBic"].let {
						if (it != null) {
							usedEncryptedContent += "proxyBic"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.proxyBic
						}
					},
				preferredFiiForPartners =
					decryptedContent["preferredFiiForPartners"].let {
						if (it != null) {
							usedEncryptedContent += "preferredFiiForPartners"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.preferredFiiForPartners
						}
					},
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The FinancialInstitutionInformation encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
