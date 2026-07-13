// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.model.embed.DecryptedFinancialInstitutionInformation
import com.icure.cardinal.sdk.model.embed.EncryptedFinancialInstitutionInformation
import com.icure.cardinal.sdk.options.DecryptedJsonStrictness
import com.icure.cardinal.sdk.utils.UnexpectedEncryptedContentException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.String
import kotlin.collections.Collection

@InternalIcureApi
internal object FinancialInstitutionInformationDecryptorFactory :
	EntityDecryptorFactory<EncryptedFinancialInstitutionInformation, DecryptedFinancialInstitutionInformation> {
	override fun create(
		entityManifestName: String?,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		cryptoService: CryptoService,
		encryptedContentDecoder: Json,
		unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
	): EntityDecryptor<EncryptedFinancialInstitutionInformation, DecryptedFinancialInstitutionInformation> {
		val manifest = entityManifestName?.let { encryptorsFactoryContext.getManifest(it) }
		require(manifest?.extensionsManifestsByModelVersion.isNullOrEmpty()) {
			"FinancialInstitutionInformation is not Extendable and does not support extensions decryption, but its manifest defines extensionsManifestsByModelVersion."
		}
		val patchDecryptedSelfJson = entityManifestName?.let { encryptorsFactoryContext.getManifestDecryptedJsonPatcher(it) }
		return FinancialInstitutionInformationDecryptor(
			encryptedContentDecoder = encryptedContentDecoder,
			patchDecryptedSelfJson = patchDecryptedSelfJson,
			cryptoService = cryptoService,
			unversionedEntitiesDecryptedJsonStrictness = unversionedEntitiesDecryptedJsonStrictness,
		)
	}
}

@InternalIcureApi
private class FinancialInstitutionInformationDecryptor(
	private val encryptedContentDecoder: Json,
	patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
	cryptoService: CryptoService,
	unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
) :
	AbstractEntityDecryptor<EncryptedFinancialInstitutionInformation, DecryptedFinancialInstitutionInformation>(
			patchDecryptedSelfJson,
			cryptoService,
			unversionedEntitiesDecryptedJsonStrictness,
		) {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedFinancialInstitutionInformation,
		customisedModelVersion: CustomisedModelVersion?,
	): DecryptedFinancialInstitutionInformation {
		val entityCustomisedModelVersion = customisedModelVersion?.typeVersion
		val decryptedContent = decryptAndPatchContent(decryptionKeys, encryptedEntity)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedFinancialInstitutionInformation(
				name =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["name"]?.also { usedEncryptedContent += "name" },
						encryptedEntity.name,
						entityCustomisedModelVersion,
					),
				key =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["key"]?.also { usedEncryptedContent += "key" },
						encryptedEntity.key,
						entityCustomisedModelVersion,
					),
				bankAccount =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["bankAccount"]?.also { usedEncryptedContent += "bankAccount" },
						encryptedEntity.bankAccount,
						entityCustomisedModelVersion,
					),
				bic =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["bic"]?.also { usedEncryptedContent += "bic" },
						encryptedEntity.bic,
						entityCustomisedModelVersion,
					),
				proxyBankAccount =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["proxyBankAccount"]?.also { usedEncryptedContent += "proxyBankAccount" },
						encryptedEntity.proxyBankAccount,
						entityCustomisedModelVersion,
					),
				proxyBic =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["proxyBic"]?.also { usedEncryptedContent += "proxyBic" },
						encryptedEntity.proxyBic,
						entityCustomisedModelVersion,
					),
				preferredFiiForPartners =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["preferredFiiForPartners"]?.also { usedEncryptedContent += "preferredFiiForPartners" },
						encryptedEntity.preferredFiiForPartners,
						entityCustomisedModelVersion,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (entityCustomisedModelVersion == null &&
			unversionedEntitiesDecryptedJsonStrictness == DecryptedJsonStrictness.Strict &&
			decryptedContent.size != usedEncryptedContent.size
		) {
			throw UnexpectedEncryptedContentException(
				"The FinancialInstitutionInformation encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
