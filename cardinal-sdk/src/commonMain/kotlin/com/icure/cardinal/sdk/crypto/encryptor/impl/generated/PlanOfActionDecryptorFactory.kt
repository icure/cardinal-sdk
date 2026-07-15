// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.loadExtensionsEncryptors
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMembership
import com.icure.cardinal.sdk.model.embed.DecryptedPlanOfAction
import com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMembership
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
internal object PlanOfActionDecryptorFactory :
	EntityDecryptorFactory<EncryptedPlanOfAction, DecryptedPlanOfAction> {
	override fun create(
		entityManifestName: String?,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		cryptoService: CryptoService,
		encryptedContentDecoder: Json,
		unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
	): EntityDecryptor<EncryptedPlanOfAction, DecryptedPlanOfAction> {
		val manifest = entityManifestName?.let { encryptorsFactoryContext.getManifest(it) }
		val extensionsDecryptorsByVersion =
			manifest?.extensionsManifestsByModelVersion?.loadExtensionsEncryptors { extensionsManifestName ->
				encryptorsFactoryContext.getExtensionEncryptorsProvider(
					extensionsManifestName = extensionsManifestName,
					encryptedClass = EncryptedPlanOfAction::class,
					decryptedClass = DecryptedPlanOfAction::class,
				)
			} ?: emptyMap()
		val patchDecryptedSelfJson = entityManifestName?.let { encryptorsFactoryContext.getManifestDecryptedJsonPatcher(it) }
		val careTeamMembershipsDecryptor =
			manifest?.recursiveEncryption?.get("careTeamMemberships")?.let { nestedManifestName ->
				val pairLazy =
					encryptorsFactoryContext.getEntityEncryptorsProvider(
						entityManifestName = nestedManifestName,
						encryptedClass = EncryptedCareTeamMembership::class,
						decryptedClass = DecryptedCareTeamMembership::class,
					)
				lazy { pairLazy.value.decryptor }
			} ?: encryptorsFactoryContext.getEmptyEntityDecryptorProvider(
				encryptedClass = EncryptedCareTeamMembership::class,
				decryptedClass = DecryptedCareTeamMembership::class,
			)
		return PlanOfActionDecryptor(
			encryptedContentDecoder = encryptedContentDecoder,
			careTeamMembershipsDecryptor = careTeamMembershipsDecryptor,
			extensionsDecryptorsByVersion = extensionsDecryptorsByVersion,
			patchDecryptedSelfJson = patchDecryptedSelfJson,
			cryptoService = cryptoService,
			unversionedEntitiesDecryptedJsonStrictness = unversionedEntitiesDecryptedJsonStrictness,
		)
	}
}

@InternalIcureApi
private class PlanOfActionDecryptor(
	private val encryptedContentDecoder: Json,
	private val careTeamMembershipsDecryptor: Lazy<EntityDecryptor<EncryptedCareTeamMembership, DecryptedCareTeamMembership>>,
	private val extensionsDecryptorsByVersion: Map<CustomisedModelVersion, Lazy<ExtensionsEncryptors>>,
	patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
	cryptoService: CryptoService,
	unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
) : AbstractEntityDecryptor<EncryptedPlanOfAction, DecryptedPlanOfAction>(
		patchDecryptedSelfJson,
		cryptoService,
		unversionedEntitiesDecryptedJsonStrictness,
	) {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedPlanOfAction,
		customisedModelVersion: CustomisedModelVersion?,
	): DecryptedPlanOfAction {
		val extensions =
			if (customisedModelVersion != null) {
				val extensionsDecryptor =
					(
						extensionsDecryptorsByVersion[customisedModelVersion] ?: throw UnsupportedOperationException(
							"This instance of the SDK is not capable of handling PlanOfAction entities of version $customisedModelVersion.",
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
			DecryptedPlanOfAction(
				id = encryptedEntity.id,
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
				prescriberId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["prescriberId"]?.also { usedEncryptedContent += "prescriberId" },
						encryptedEntity.prescriberId,
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
				deadlineDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["deadlineDate"]?.also { usedEncryptedContent += "deadlineDate" },
						encryptedEntity.deadlineDate,
						entityCustomisedModelVersion,
					),
				name =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["name"]?.also { usedEncryptedContent += "name" },
						encryptedEntity.name,
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
				careTeamMemberships =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["careTeamMemberships"]?.also { usedEncryptedContent += "careTeamMemberships" },
						encryptedEntity.careTeamMemberships.map { x0 ->
							careTeamMembershipsDecryptor.value.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								customisedModelVersion = customisedModelVersion,
							)
						},
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
				"The PlanOfAction encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
