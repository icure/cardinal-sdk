// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.model.embed.DecryptedAnnotation
import com.icure.cardinal.sdk.model.embed.DecryptedContent
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.EncryptedAnnotation
import com.icure.cardinal.sdk.model.embed.EncryptedContent
import com.icure.cardinal.sdk.model.embed.EncryptedService
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
internal object ServiceDecryptorFactory : EntityDecryptorFactory<EncryptedService, DecryptedService> {
	override fun create(
		entityManifestName: String?,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		cryptoService: CryptoService,
		encryptedContentDecoder: Json,
		unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
	): EntityDecryptor<EncryptedService, DecryptedService> {
		val manifest = entityManifestName?.let { encryptorsFactoryContext.getManifest(it) }
		val extensionsDecryptorsByVersion =
			manifest?.extensionsManifestsByModelVersion?.mapValues { (_, extensionsManifestName) ->
				encryptorsFactoryContext.getExtensionEncryptorsProvider(
					extensionsManifestName = extensionsManifestName,
					encryptedClass = EncryptedService::class,
					decryptedClass = DecryptedService::class,
				)
			} ?: emptyMap()
		val patchDecryptedSelfJson = entityManifestName?.let { encryptorsFactoryContext.getManifestDecryptedJsonPatcher(it) }
		val contentDecryptor =
			manifest?.recursiveEncryption?.get("content")?.let { nestedManifestName ->
				val pairLazy =
					encryptorsFactoryContext.getEntityEncryptorsProvider(
						entityManifestName = nestedManifestName,
						encryptedClass = EncryptedContent::class,
						decryptedClass = DecryptedContent::class,
					)
				lazy { pairLazy.value.decryptor }
			} ?: encryptorsFactoryContext.getEmptyEntityDecryptorProvider(
				encryptedClass = EncryptedContent::class,
				decryptedClass = DecryptedContent::class,
			)
		val notesDecryptor =
			manifest?.recursiveEncryption?.get("notes")?.let { nestedManifestName ->
				val pairLazy =
					encryptorsFactoryContext.getEntityEncryptorsProvider(
						entityManifestName = nestedManifestName,
						encryptedClass = EncryptedAnnotation::class,
						decryptedClass = DecryptedAnnotation::class,
					)
				lazy { pairLazy.value.decryptor }
			} ?: encryptorsFactoryContext.getEmptyEntityDecryptorProvider(
				encryptedClass = EncryptedAnnotation::class,
				decryptedClass = DecryptedAnnotation::class,
			)
		return ServiceDecryptor(
			encryptedContentDecoder = encryptedContentDecoder,
			contentDecryptor = contentDecryptor,
			notesDecryptor = notesDecryptor,
			extensionsDecryptorsByVersion = extensionsDecryptorsByVersion,
			patchDecryptedSelfJson = patchDecryptedSelfJson,
			cryptoService = cryptoService,
			unversionedEntitiesDecryptedJsonStrictness = unversionedEntitiesDecryptedJsonStrictness,
		)
	}
}

@InternalIcureApi
private class ServiceDecryptor(
	private val encryptedContentDecoder: Json,
	private val contentDecryptor: Lazy<EntityDecryptor<EncryptedContent, DecryptedContent>>,
	private val notesDecryptor: Lazy<EntityDecryptor<EncryptedAnnotation, DecryptedAnnotation>>,
	private val extensionsDecryptorsByVersion: Map<CustomisedModelVersion, Lazy<ExtensionsEncryptors>>,
	patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
	cryptoService: CryptoService,
	unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
) : AbstractEntityDecryptor<EncryptedService, DecryptedService>(
		patchDecryptedSelfJson,
		cryptoService,
		unversionedEntitiesDecryptedJsonStrictness,
	) {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedService,
		customisedModelVersion: CustomisedModelVersion?,
	): DecryptedService {
		val extensions =
			if (customisedModelVersion != null) {
				val extensionsDecryptor =
					(
						extensionsDecryptorsByVersion[customisedModelVersion] ?: throw UnsupportedOperationException(
							"This instance of the SDK is not capable of handling Service entities of version $customisedModelVersion.",
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
			DecryptedService(
				id = encryptedEntity.id,
				transactionId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["transactionId"]?.also { usedEncryptedContent += "transactionId" },
						encryptedEntity.transactionId,
						entityCustomisedModelVersion,
					),
				identifier =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["identifier"]?.also { usedEncryptedContent += "identifier" },
						encryptedEntity.identifier,
						entityCustomisedModelVersion,
					),
				contactId = encryptedEntity.contactId,
				subContactIds =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["subContactIds"]?.also { usedEncryptedContent += "subContactIds" },
						encryptedEntity.subContactIds,
						entityCustomisedModelVersion,
					),
				plansOfActionIds =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["plansOfActionIds"]?.also { usedEncryptedContent += "plansOfActionIds" },
						encryptedEntity.plansOfActionIds,
						entityCustomisedModelVersion,
					),
				healthElementsIds =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["healthElementsIds"]?.also { usedEncryptedContent += "healthElementsIds" },
						encryptedEntity.healthElementsIds,
						entityCustomisedModelVersion,
					),
				formIds =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["formIds"]?.also { usedEncryptedContent += "formIds" },
						encryptedEntity.formIds,
						entityCustomisedModelVersion,
					),
				secretForeignKeys = encryptedEntity.secretForeignKeys,
				cryptedForeignKeys = encryptedEntity.cryptedForeignKeys,
				delegations = encryptedEntity.delegations,
				encryptionKeys = encryptedEntity.encryptionKeys,
				label =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["label"]?.also { usedEncryptedContent += "label" },
						encryptedEntity.label,
						entityCustomisedModelVersion,
					),
				index =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["index"]?.also { usedEncryptedContent += "index" },
						encryptedEntity.index,
						entityCustomisedModelVersion,
					),
				content =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["content"]?.also { usedEncryptedContent += "content" },
						encryptedEntity.content.mapValues { (_, x0) ->
							contentDecryptor.value.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								customisedModelVersion = customisedModelVersion,
							)
						},
						entityCustomisedModelVersion,
					),
				textIndexes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["textIndexes"]?.also { usedEncryptedContent += "textIndexes" },
						encryptedEntity.textIndexes,
						entityCustomisedModelVersion,
					),
				valueDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["valueDate"]?.also { usedEncryptedContent += "valueDate" },
						encryptedEntity.valueDate,
						entityCustomisedModelVersion,
					),
				openingDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["openingDate"]?.also { usedEncryptedContent += "openingDate" },
						encryptedEntity.openingDate,
						entityCustomisedModelVersion,
					),
				closingDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["closingDate"]?.also { usedEncryptedContent += "closingDate" },
						encryptedEntity.closingDate,
						entityCustomisedModelVersion,
					),
				created =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["created"]?.also { usedEncryptedContent += "created" },
						encryptedEntity.created,
						entityCustomisedModelVersion,
					),
				modified =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["modified"]?.also { usedEncryptedContent += "modified" },
						encryptedEntity.modified,
						entityCustomisedModelVersion,
					),
				endOfLife = encryptedEntity.endOfLife,
				author =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["author"]?.also { usedEncryptedContent += "author" },
						encryptedEntity.author,
						entityCustomisedModelVersion,
					),
				responsible =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["responsible"]?.also { usedEncryptedContent += "responsible" },
						encryptedEntity.responsible,
						entityCustomisedModelVersion,
					),
				comment =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["comment"]?.also { usedEncryptedContent += "comment" },
						encryptedEntity.comment,
						entityCustomisedModelVersion,
					),
				invoicingCodes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["invoicingCodes"]?.also { usedEncryptedContent += "invoicingCodes" },
						encryptedEntity.invoicingCodes,
						entityCustomisedModelVersion,
					),
				notes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["notes"]?.also { usedEncryptedContent += "notes" },
						encryptedEntity.notes.map { x0 ->
							notesDecryptor.value.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								customisedModelVersion = customisedModelVersion,
							)
						},
						entityCustomisedModelVersion,
					),
				qualifiedLinks =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["qualifiedLinks"]?.also { usedEncryptedContent += "qualifiedLinks" },
						encryptedEntity.qualifiedLinks,
						entityCustomisedModelVersion,
					),
				codes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["codes"]?.also { usedEncryptedContent += "codes" },
						encryptedEntity.codes,
						entityCustomisedModelVersion,
					),
				tags =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["tags"]?.also { usedEncryptedContent += "tags" },
						encryptedEntity.tags,
						entityCustomisedModelVersion,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
				securityMetadata = encryptedEntity.securityMetadata,
				extensions = extensions,
				contactExtensionsVersions = encryptedEntity.contactExtensionsVersions,
			)
		if (entityCustomisedModelVersion == null &&
			unversionedEntitiesDecryptedJsonStrictness == DecryptedJsonStrictness.Strict &&
			decryptedContent.size != usedEncryptedContent.size
		) {
			throw UnexpectedEncryptedContentException(
				"The Service encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
