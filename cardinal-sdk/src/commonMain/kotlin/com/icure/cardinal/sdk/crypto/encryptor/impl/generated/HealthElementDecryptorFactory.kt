// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.loadExtensionsEncryptors
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.model.embed.DecryptedAnnotation
import com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMember
import com.icure.cardinal.sdk.model.embed.DecryptedEpisode
import com.icure.cardinal.sdk.model.embed.DecryptedPlanOfAction
import com.icure.cardinal.sdk.model.embed.EncryptedAnnotation
import com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMember
import com.icure.cardinal.sdk.model.embed.EncryptedEpisode
import com.icure.cardinal.sdk.model.embed.EncryptedPlanOfAction
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
internal object HealthElementDecryptorFactory :
	EntityDecryptorFactory<EncryptedHealthElement, DecryptedHealthElement> {
	override fun create(
		entityManifestName: String?,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		cryptoService: CryptoService,
		encryptedContentDecoder: Json,
		unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
	): EntityDecryptor<EncryptedHealthElement, DecryptedHealthElement> {
		val manifest = entityManifestName?.let { encryptorsFactoryContext.getManifest(it) }
		val extensionsDecryptorsByVersion =
			manifest?.extensionsManifestsByModelVersion?.loadExtensionsEncryptors { extensionsManifestName ->
				encryptorsFactoryContext.getExtensionEncryptorsProvider(
					extensionsManifestName = extensionsManifestName,
					encryptedClass = EncryptedHealthElement::class,
					decryptedClass = DecryptedHealthElement::class,
				)
			} ?: emptyMap()
		val patchDecryptedSelfJson = entityManifestName?.let { encryptorsFactoryContext.getManifestDecryptedJsonPatcher(it) }
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
		val plansOfActionDecryptor =
			manifest?.recursiveEncryption?.get("plansOfAction")?.let { nestedManifestName ->
				val pairLazy =
					encryptorsFactoryContext.getEntityEncryptorsProvider(
						entityManifestName = nestedManifestName,
						encryptedClass = EncryptedPlanOfAction::class,
						decryptedClass = DecryptedPlanOfAction::class,
					)
				lazy { pairLazy.value.decryptor }
			} ?: encryptorsFactoryContext.getEmptyEntityDecryptorProvider(
				encryptedClass = EncryptedPlanOfAction::class,
				decryptedClass = DecryptedPlanOfAction::class,
			)
		val episodesDecryptor =
			manifest?.recursiveEncryption?.get("episodes")?.let { nestedManifestName ->
				val pairLazy =
					encryptorsFactoryContext.getEntityEncryptorsProvider(
						entityManifestName = nestedManifestName,
						encryptedClass = EncryptedEpisode::class,
						decryptedClass = DecryptedEpisode::class,
					)
				lazy { pairLazy.value.decryptor }
			} ?: encryptorsFactoryContext.getEmptyEntityDecryptorProvider(
				encryptedClass = EncryptedEpisode::class,
				decryptedClass = DecryptedEpisode::class,
			)
		val careTeamDecryptor =
			manifest?.recursiveEncryption?.get("careTeam")?.let { nestedManifestName ->
				val pairLazy =
					encryptorsFactoryContext.getEntityEncryptorsProvider(
						entityManifestName = nestedManifestName,
						encryptedClass = EncryptedCareTeamMember::class,
						decryptedClass = DecryptedCareTeamMember::class,
					)
				lazy { pairLazy.value.decryptor }
			} ?: encryptorsFactoryContext.getEmptyEntityDecryptorProvider(
				encryptedClass = EncryptedCareTeamMember::class,
				decryptedClass = DecryptedCareTeamMember::class,
			)
		return HealthElementDecryptor(
			encryptedContentDecoder = encryptedContentDecoder,
			notesDecryptor = notesDecryptor,
			plansOfActionDecryptor = plansOfActionDecryptor,
			episodesDecryptor = episodesDecryptor,
			careTeamDecryptor = careTeamDecryptor,
			extensionsDecryptorsByVersion = extensionsDecryptorsByVersion,
			patchDecryptedSelfJson = patchDecryptedSelfJson,
			cryptoService = cryptoService,
			unversionedEntitiesDecryptedJsonStrictness = unversionedEntitiesDecryptedJsonStrictness,
		)
	}
}

@InternalIcureApi
private class HealthElementDecryptor(
	private val encryptedContentDecoder: Json,
	private val notesDecryptor: Lazy<EntityDecryptor<EncryptedAnnotation, DecryptedAnnotation>>,
	private val plansOfActionDecryptor: Lazy<EntityDecryptor<EncryptedPlanOfAction, DecryptedPlanOfAction>>,
	private val episodesDecryptor: Lazy<EntityDecryptor<EncryptedEpisode, DecryptedEpisode>>,
	private val careTeamDecryptor: Lazy<EntityDecryptor<EncryptedCareTeamMember, DecryptedCareTeamMember>>,
	private val extensionsDecryptorsByVersion: Map<CustomisedModelVersion, Lazy<ExtensionsEncryptors>>,
	patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
	cryptoService: CryptoService,
	unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
) : AbstractEntityDecryptor<EncryptedHealthElement, DecryptedHealthElement>(
		patchDecryptedSelfJson,
		cryptoService,
		unversionedEntitiesDecryptedJsonStrictness,
	) {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedHealthElement,
		customisedModelVersion: CustomisedModelVersion?,
	): DecryptedHealthElement {
		val extensions =
			if (customisedModelVersion != null) {
				val extensionsDecryptor =
					(
						extensionsDecryptorsByVersion[customisedModelVersion] ?: throw UnsupportedOperationException(
							"This instance of the SDK is not capable of handling HealthElement entities of version $customisedModelVersion.",
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
			DecryptedHealthElement(
				id = encryptedEntity.id,
				identifiers =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["identifiers"]?.also { usedEncryptedContent += "identifiers" },
						encryptedEntity.identifiers,
						entityCustomisedModelVersion,
					),
				rev = encryptedEntity.rev,
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
				tags =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["tags"]?.also { usedEncryptedContent += "tags" },
						encryptedEntity.tags,
						entityCustomisedModelVersion,
					),
				codes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["codes"]?.also { usedEncryptedContent += "codes" },
						encryptedEntity.codes,
						entityCustomisedModelVersion,
					),
				endOfLife = encryptedEntity.endOfLife,
				deletionDate = encryptedEntity.deletionDate,
				healthElementId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["healthElementId"]?.also { usedEncryptedContent += "healthElementId" },
						encryptedEntity.healthElementId,
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
				descr =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["descr"]?.also { usedEncryptedContent += "descr" },
						encryptedEntity.descr,
						entityCustomisedModelVersion,
					),
				note =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["note"]?.also { usedEncryptedContent += "note" },
						encryptedEntity.note,
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
				relevant =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["relevant"]?.also { usedEncryptedContent += "relevant" },
						encryptedEntity.relevant,
						entityCustomisedModelVersion,
					),
				idOpeningContact =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["idOpeningContact"]?.also { usedEncryptedContent += "idOpeningContact" },
						encryptedEntity.idOpeningContact,
						entityCustomisedModelVersion,
					),
				idClosingContact =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["idClosingContact"]?.also { usedEncryptedContent += "idClosingContact" },
						encryptedEntity.idClosingContact,
						entityCustomisedModelVersion,
					),
				idService =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["idService"]?.also { usedEncryptedContent += "idService" },
						encryptedEntity.idService,
						entityCustomisedModelVersion,
					),
				laterality =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["laterality"]?.also { usedEncryptedContent += "laterality" },
						encryptedEntity.laterality,
						entityCustomisedModelVersion,
					),
				plansOfAction =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["plansOfAction"]?.also { usedEncryptedContent += "plansOfAction" },
						encryptedEntity.plansOfAction.map { x0 ->
							plansOfActionDecryptor.value.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								customisedModelVersion = customisedModelVersion,
							)
						},
						entityCustomisedModelVersion,
					),
				episodes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["episodes"]?.also { usedEncryptedContent += "episodes" },
						encryptedEntity.episodes.map { x0 ->
							episodesDecryptor.value.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								customisedModelVersion = customisedModelVersion,
							)
						},
						entityCustomisedModelVersion,
					),
				careTeam =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["careTeam"]?.also { usedEncryptedContent += "careTeam" },
						encryptedEntity.careTeam.map { x0 ->
							careTeamDecryptor.value.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								customisedModelVersion = customisedModelVersion,
							)
						},
						entityCustomisedModelVersion,
					),
				secretForeignKeys = encryptedEntity.secretForeignKeys,
				cryptedForeignKeys = encryptedEntity.cryptedForeignKeys,
				delegations = encryptedEntity.delegations,
				encryptionKeys = encryptedEntity.encryptionKeys,
				encryptedSelf = encryptedEntity.encryptedSelf,
				securityMetadata = encryptedEntity.securityMetadata,
				extensions = extensions,
				customisedModelVersion = encryptedEntity.customisedModelVersion,
			)
		if (entityCustomisedModelVersion == null &&
			unversionedEntitiesDecryptedJsonStrictness == DecryptedJsonStrictness.Strict &&
			decryptedContent.size != usedEncryptedContent.size
		) {
			throw UnexpectedEncryptedContentException(
				"The HealthElement encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
