// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.loadExtensionsEncryptors
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.model.embed.DecryptedInsurability
import com.icure.cardinal.sdk.model.embed.EncryptedInsurability
import com.icure.cardinal.sdk.options.DecryptedJsonStrictness
import com.icure.cardinal.sdk.utils.UnexpectedEncryptedContentException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.Lazy
import kotlin.String
import kotlin.UnsupportedOperationException
import kotlin.collections.Collection
import kotlin.collections.Map

@InternalIcureApi
internal object InsurabilityDecryptorFactory :
	EntityDecryptorFactory<EncryptedInsurability, DecryptedInsurability> {
	override fun create(
		entityManifestName: String?,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		cryptoService: CryptoService,
		encryptedContentDecoder: Json,
		unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
	): EntityDecryptor<EncryptedInsurability, DecryptedInsurability> {
		val manifest = entityManifestName?.let { encryptorsFactoryContext.getManifest(it) }
		val extensionsDecryptorsByVersion =
			manifest?.extensionsManifestsByModelVersion?.loadExtensionsEncryptors { extensionsManifestName ->
				encryptorsFactoryContext.getExtensionEncryptorsProvider(
					extensionsManifestName = extensionsManifestName,
					encryptedClass = EncryptedInsurability::class,
					decryptedClass = DecryptedInsurability::class,
				)
			} ?: emptyMap()
		val patchDecryptedSelfJson = entityManifestName?.let { encryptorsFactoryContext.getManifestDecryptedJsonPatcher(it) }
		return InsurabilityDecryptor(
			encryptedContentDecoder = encryptedContentDecoder,
			extensionsDecryptorsByVersion = extensionsDecryptorsByVersion,
			patchDecryptedSelfJson = patchDecryptedSelfJson,
			cryptoService = cryptoService,
			unversionedEntitiesDecryptedJsonStrictness = unversionedEntitiesDecryptedJsonStrictness,
		)
	}
}

@InternalIcureApi
private class InsurabilityDecryptor(
	private val encryptedContentDecoder: Json,
	private val extensionsDecryptorsByVersion: Map<CustomisedModelVersion, Lazy<ExtensionsEncryptors>>,
	patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
	cryptoService: CryptoService,
	unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
) : AbstractEntityDecryptor<EncryptedInsurability, DecryptedInsurability>(
		patchDecryptedSelfJson,
		cryptoService,
		unversionedEntitiesDecryptedJsonStrictness,
	) {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedInsurability,
		customisedModelVersion: CustomisedModelVersion?,
	): DecryptedInsurability {
		val extensions =
			if (customisedModelVersion != null) {
				val extensionsDecryptor =
					(
						extensionsDecryptorsByVersion[customisedModelVersion] ?: throw UnsupportedOperationException(
							"This instance of the SDK is not capable of handling Insurability entities of version $customisedModelVersion.",
						)
					).value
				encryptedEntity.extensions?.let { extensionsDecryptor.decryptExtension(decryptionKeys, it) }
			} else {
				encryptedEntity.extensions
			}
		val entityCustomisedModelVersion = customisedModelVersion?.typeVersion
		val decryptedContent = decryptAndPatchContent(decryptionKeys, encryptedEntity)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedInsurability(
				parameters =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["parameters"]?.also { usedEncryptedContent += "parameters" },
						encryptedEntity.parameters,
						entityCustomisedModelVersion,
					),
				hospitalisation =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["hospitalisation"]?.also { usedEncryptedContent += "hospitalisation" },
						encryptedEntity.hospitalisation,
						entityCustomisedModelVersion,
					),
				ambulatory =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["ambulatory"]?.also { usedEncryptedContent += "ambulatory" },
						encryptedEntity.ambulatory,
						entityCustomisedModelVersion,
					),
				dental =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["dental"]?.also { usedEncryptedContent += "dental" },
						encryptedEntity.dental,
						entityCustomisedModelVersion,
					),
				identificationNumber =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["identificationNumber"]?.also { usedEncryptedContent += "identificationNumber" },
						encryptedEntity.identificationNumber,
						entityCustomisedModelVersion,
					),
				insuranceId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["insuranceId"]?.also { usedEncryptedContent += "insuranceId" },
						encryptedEntity.insuranceId,
						entityCustomisedModelVersion,
					),
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
				titularyId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["titularyId"]?.also { usedEncryptedContent += "titularyId" },
						encryptedEntity.titularyId,
						entityCustomisedModelVersion,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
				extensions = extensions,
			)
		if (entityCustomisedModelVersion == null &&
			unversionedEntitiesDecryptedJsonStrictness == DecryptedJsonStrictness.Strict &&
			decryptedContent.size != usedEncryptedContent.size
		) {
			throw UnexpectedEncryptedContentException(
				"The Insurability encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
