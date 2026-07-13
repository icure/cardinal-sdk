// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.model.embed.DecryptedContent
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.EncryptedContent
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.options.DecryptedJsonStrictness
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import com.icure.cardinal.sdk.serialization.InstantSerializer
import com.icure.cardinal.sdk.utils.UnexpectedEncryptedContentException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.Lazy
import kotlin.String
import kotlin.collections.Collection

@InternalIcureApi
internal object ContentDecryptorFactory : EntityDecryptorFactory<EncryptedContent, DecryptedContent> {
	override fun create(
		entityManifestName: String?,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		cryptoService: CryptoService,
		encryptedContentDecoder: Json,
		unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
	): EntityDecryptor<EncryptedContent, DecryptedContent> {
		val manifest = entityManifestName?.let { encryptorsFactoryContext.getManifest(it) }
		require(manifest?.extensionsManifestsByModelVersion.isNullOrEmpty()) {
			"Content is not Extendable and does not support extensions decryption, but its manifest defines extensionsManifestsByModelVersion."
		}
		val patchDecryptedSelfJson = entityManifestName?.let { encryptorsFactoryContext.getManifestDecryptedJsonPatcher(it) }
		val compoundValueDecryptor =
			manifest?.recursiveEncryption?.get("compoundValue")?.let { nestedManifestName ->
				val pairLazy =
					encryptorsFactoryContext.getEntityEncryptorsProvider(
						entityManifestName = nestedManifestName,
						encryptedClass = EncryptedService::class,
						decryptedClass = DecryptedService::class,
					)
				lazy { pairLazy.value.decryptor }
			} ?: encryptorsFactoryContext.getEmptyEntityDecryptorProvider(
				encryptedClass = EncryptedService::class,
				decryptedClass = DecryptedService::class,
			)
		return ContentDecryptor(
			encryptedContentDecoder = encryptedContentDecoder,
			compoundValueDecryptor = compoundValueDecryptor,
			patchDecryptedSelfJson = patchDecryptedSelfJson,
			cryptoService = cryptoService,
			unversionedEntitiesDecryptedJsonStrictness = unversionedEntitiesDecryptedJsonStrictness,
		)
	}
}

@InternalIcureApi
private class ContentDecryptor(
	private val encryptedContentDecoder: Json,
	private val compoundValueDecryptor: Lazy<EntityDecryptor<EncryptedService, DecryptedService>>,
	patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
	cryptoService: CryptoService,
	unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
) : AbstractEntityDecryptor<EncryptedContent, DecryptedContent>(
		patchDecryptedSelfJson,
		cryptoService,
		unversionedEntitiesDecryptedJsonStrictness,
	) {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedContent,
		customisedModelVersion: CustomisedModelVersion?,
	): DecryptedContent {
		val entityCustomisedModelVersion = customisedModelVersion?.typeVersion
		val decryptedContent = decryptAndPatchContent(decryptionKeys, encryptedEntity)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedContent(
				stringValue =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["stringValue"]?.also { usedEncryptedContent += "stringValue" },
						encryptedEntity.stringValue,
						entityCustomisedModelVersion,
					),
				numberValue =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["numberValue"]?.also { usedEncryptedContent += "numberValue" },
						encryptedEntity.numberValue,
						entityCustomisedModelVersion,
					),
				booleanValue =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["booleanValue"]?.also { usedEncryptedContent += "booleanValue" },
						encryptedEntity.booleanValue,
						entityCustomisedModelVersion,
					),
				instantValue =
					encryptedContentDecoder.decodeDecrypted(
						InstantSerializer.nullable,
						decryptedContent["instantValue"]?.also { usedEncryptedContent += "instantValue" },
						encryptedEntity.instantValue,
						entityCustomisedModelVersion,
					),
				fuzzyDateValue =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["fuzzyDateValue"]?.also { usedEncryptedContent += "fuzzyDateValue" },
						encryptedEntity.fuzzyDateValue,
						entityCustomisedModelVersion,
					),
				binaryValue =
					encryptedContentDecoder.decodeDecrypted(
						ByteArraySerializer.nullable,
						decryptedContent["binaryValue"]?.also { usedEncryptedContent += "binaryValue" },
						encryptedEntity.binaryValue,
						entityCustomisedModelVersion,
					),
				documentId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["documentId"]?.also { usedEncryptedContent += "documentId" },
						encryptedEntity.documentId,
						entityCustomisedModelVersion,
					),
				measureValue =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["measureValue"]?.also { usedEncryptedContent += "measureValue" },
						encryptedEntity.measureValue,
						entityCustomisedModelVersion,
					),
				medicationValue =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["medicationValue"]?.also { usedEncryptedContent += "medicationValue" },
						encryptedEntity.medicationValue,
						entityCustomisedModelVersion,
					),
				timeSeries =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["timeSeries"]?.also { usedEncryptedContent += "timeSeries" },
						encryptedEntity.timeSeries,
						entityCustomisedModelVersion,
					),
				compoundValue =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["compoundValue"]?.also { usedEncryptedContent += "compoundValue" },
						encryptedEntity.compoundValue?.let {
							it.map { x0 ->
								compoundValueDecryptor.value.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = x0,
									customisedModelVersion = customisedModelVersion,
								)
							}
						},
						entityCustomisedModelVersion,
					),
				ratio =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["ratio"]?.also { usedEncryptedContent += "ratio" },
						encryptedEntity.ratio,
						entityCustomisedModelVersion,
					),
				range =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["range"]?.also { usedEncryptedContent += "range" },
						encryptedEntity.range,
						entityCustomisedModelVersion,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (entityCustomisedModelVersion == null &&
			unversionedEntitiesDecryptedJsonStrictness == DecryptedJsonStrictness.Strict &&
			decryptedContent.size != usedEncryptedContent.size
		) {
			throw UnexpectedEncryptedContentException(
				"The Content encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
