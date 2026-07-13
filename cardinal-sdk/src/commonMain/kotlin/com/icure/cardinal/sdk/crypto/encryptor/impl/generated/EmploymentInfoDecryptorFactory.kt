// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.model.embed.DecryptedEmploymentInfo
import com.icure.cardinal.sdk.model.embed.EncryptedEmploymentInfo
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
internal object EmploymentInfoDecryptorFactory :
	EntityDecryptorFactory<EncryptedEmploymentInfo, DecryptedEmploymentInfo> {
	override fun create(
		entityManifestName: String?,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		cryptoService: CryptoService,
		encryptedContentDecoder: Json,
		unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
	): EntityDecryptor<EncryptedEmploymentInfo, DecryptedEmploymentInfo> {
		val manifest = entityManifestName?.let { encryptorsFactoryContext.getManifest(it) }
		require(manifest?.extensionsManifestsByModelVersion.isNullOrEmpty()) {
			"EmploymentInfo is not Extendable and does not support extensions decryption, but its manifest defines extensionsManifestsByModelVersion."
		}
		val patchDecryptedSelfJson = entityManifestName?.let { encryptorsFactoryContext.getManifestDecryptedJsonPatcher(it) }
		return EmploymentInfoDecryptor(
			encryptedContentDecoder = encryptedContentDecoder,
			patchDecryptedSelfJson = patchDecryptedSelfJson,
			cryptoService = cryptoService,
			unversionedEntitiesDecryptedJsonStrictness = unversionedEntitiesDecryptedJsonStrictness,
		)
	}
}

@InternalIcureApi
private class EmploymentInfoDecryptor(
	private val encryptedContentDecoder: Json,
	patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
	cryptoService: CryptoService,
	unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
) :
	AbstractEntityDecryptor<EncryptedEmploymentInfo, DecryptedEmploymentInfo>(
			patchDecryptedSelfJson,
			cryptoService,
			unversionedEntitiesDecryptedJsonStrictness,
		) {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedEmploymentInfo,
		customisedModelVersion: CustomisedModelVersion?,
	): DecryptedEmploymentInfo {
		val entityCustomisedModelVersion = customisedModelVersion?.typeVersion
		val decryptedContent = decryptAndPatchContent(decryptionKeys, encryptedEntity)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedEmploymentInfo(
				startDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["startDate"]?.also { usedEncryptedContent += "startDate" },
						encryptedEntity.startDate,
						entityCustomisedModelVersion,
					),
				endDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["endDate"]?.also { usedEncryptedContent += "endDate" },
						encryptedEntity.endDate,
						entityCustomisedModelVersion,
					),
				professionType =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["professionType"]?.also { usedEncryptedContent += "professionType" },
						encryptedEntity.professionType,
						entityCustomisedModelVersion,
					),
				employer =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["employer"]?.also { usedEncryptedContent += "employer" },
						encryptedEntity.employer,
						entityCustomisedModelVersion,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (entityCustomisedModelVersion == null &&
			unversionedEntitiesDecryptedJsonStrictness == DecryptedJsonStrictness.Strict &&
			decryptedContent.size != usedEncryptedContent.size
		) {
			throw UnexpectedEncryptedContentException(
				"The EmploymentInfo encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
