// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedFinancialInstitutionInformation
import com.icure.cardinal.sdk.model.embed.EncryptedFinancialInstitutionInformation
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object FinancialInstitutionInformationDecryptor :
	AbstractEntityDecryptor<EncryptedFinancialInstitutionInformation, DecryptedFinancialInstitutionInformation>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedFinancialInstitutionInformation,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
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
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["name"]?.also { usedEncryptedContent += "name" },
						encryptedEntity.name,
						decryptedJsonStrictness,
					),
				key =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["key"]?.also { usedEncryptedContent += "key" },
						encryptedEntity.key,
						decryptedJsonStrictness,
					),
				bankAccount =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["bankAccount"]?.also { usedEncryptedContent += "bankAccount" },
						encryptedEntity.bankAccount,
						decryptedJsonStrictness,
					),
				bic =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["bic"]?.also { usedEncryptedContent += "bic" },
						encryptedEntity.bic,
						decryptedJsonStrictness,
					),
				proxyBankAccount =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["proxyBankAccount"]?.also { usedEncryptedContent += "proxyBankAccount" },
						encryptedEntity.proxyBankAccount,
						decryptedJsonStrictness,
					),
				proxyBic =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["proxyBic"]?.also { usedEncryptedContent += "proxyBic" },
						encryptedEntity.proxyBic,
						decryptedJsonStrictness,
					),
				preferredFiiForPartners =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["preferredFiiForPartners"]?.also { usedEncryptedContent += "preferredFiiForPartners" },
						encryptedEntity.preferredFiiForPartners,
						decryptedJsonStrictness,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The FinancialInstitutionInformation encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
