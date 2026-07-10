// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object HealthElementDecryptor :
	AbstractEntityDecryptor<EncryptedHealthElement, DecryptedHealthElement>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedHealthElement,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedHealthElement {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedHealthElement(
				id = encryptedEntity.id,
				identifiers =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["identifiers"]?.also { usedEncryptedContent += "identifiers" },
						encryptedEntity.identifiers,
						decryptedJsonStrictness,
					),
				rev = encryptedEntity.rev,
				created =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["created"]?.also { usedEncryptedContent += "created" },
						encryptedEntity.created,
						decryptedJsonStrictness,
					),
				modified =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["modified"]?.also { usedEncryptedContent += "modified" },
						encryptedEntity.modified,
						decryptedJsonStrictness,
					),
				author =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["author"]?.also { usedEncryptedContent += "author" },
						encryptedEntity.author,
						decryptedJsonStrictness,
					),
				responsible =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["responsible"]?.also { usedEncryptedContent += "responsible" },
						encryptedEntity.responsible,
						decryptedJsonStrictness,
					),
				tags =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["tags"]?.also { usedEncryptedContent += "tags" },
						encryptedEntity.tags,
						decryptedJsonStrictness,
					),
				codes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["codes"]?.also { usedEncryptedContent += "codes" },
						encryptedEntity.codes,
						decryptedJsonStrictness,
					),
				endOfLife = encryptedEntity.endOfLife,
				deletionDate = encryptedEntity.deletionDate,
				healthElementId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["healthElementId"]?.also { usedEncryptedContent += "healthElementId" },
						encryptedEntity.healthElementId,
						decryptedJsonStrictness,
					),
				valueDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["valueDate"]?.also { usedEncryptedContent += "valueDate" },
						encryptedEntity.valueDate,
						decryptedJsonStrictness,
					),
				openingDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["openingDate"]?.also { usedEncryptedContent += "openingDate" },
						encryptedEntity.openingDate,
						decryptedJsonStrictness,
					),
				closingDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["closingDate"]?.also { usedEncryptedContent += "closingDate" },
						encryptedEntity.closingDate,
						decryptedJsonStrictness,
					),
				descr =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["descr"]?.also { usedEncryptedContent += "descr" },
						encryptedEntity.descr,
						decryptedJsonStrictness,
					),
				note =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["note"]?.also { usedEncryptedContent += "note" },
						encryptedEntity.note,
						decryptedJsonStrictness,
					),
				notes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["notes"]?.also { usedEncryptedContent += "notes" },
						encryptedEntity.notes.map { x0 ->
							AnnotationDecryptor.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								patchDecryptedSelfJson = patchDecryptedSelfJson,
								decryptedJsonStrictness = decryptedJsonStrictness,
								encryptedContentDecoder = encryptedContentDecoder,
								cryptoService = cryptoService,
							)
						},
						decryptedJsonStrictness,
					),
				relevant =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["relevant"]?.also { usedEncryptedContent += "relevant" },
						encryptedEntity.relevant,
						decryptedJsonStrictness,
					),
				idOpeningContact =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["idOpeningContact"]?.also { usedEncryptedContent += "idOpeningContact" },
						encryptedEntity.idOpeningContact,
						decryptedJsonStrictness,
					),
				idClosingContact =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["idClosingContact"]?.also { usedEncryptedContent += "idClosingContact" },
						encryptedEntity.idClosingContact,
						decryptedJsonStrictness,
					),
				idService =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["idService"]?.also { usedEncryptedContent += "idService" },
						encryptedEntity.idService,
						decryptedJsonStrictness,
					),
				laterality =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["laterality"]?.also { usedEncryptedContent += "laterality" },
						encryptedEntity.laterality,
						decryptedJsonStrictness,
					),
				plansOfAction =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["plansOfAction"]?.also { usedEncryptedContent += "plansOfAction" },
						encryptedEntity.plansOfAction.map { x0 ->
							PlanOfActionDecryptor.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								patchDecryptedSelfJson = patchDecryptedSelfJson,
								decryptedJsonStrictness = decryptedJsonStrictness,
								encryptedContentDecoder = encryptedContentDecoder,
								cryptoService = cryptoService,
							)
						},
						decryptedJsonStrictness,
					),
				episodes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["episodes"]?.also { usedEncryptedContent += "episodes" },
						encryptedEntity.episodes.map { x0 ->
							EpisodeDecryptor.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								patchDecryptedSelfJson = patchDecryptedSelfJson,
								decryptedJsonStrictness = decryptedJsonStrictness,
								encryptedContentDecoder = encryptedContentDecoder,
								cryptoService = cryptoService,
							)
						},
						decryptedJsonStrictness,
					),
				careTeam =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["careTeam"]?.also { usedEncryptedContent += "careTeam" },
						encryptedEntity.careTeam.map { x0 ->
							CareTeamMemberDecryptor.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								patchDecryptedSelfJson = patchDecryptedSelfJson,
								decryptedJsonStrictness = decryptedJsonStrictness,
								encryptedContentDecoder = encryptedContentDecoder,
								cryptoService = cryptoService,
							)
						},
						decryptedJsonStrictness,
					),
				secretForeignKeys = encryptedEntity.secretForeignKeys,
				cryptedForeignKeys = encryptedEntity.cryptedForeignKeys,
				delegations = encryptedEntity.delegations,
				encryptionKeys = encryptedEntity.encryptionKeys,
				encryptedSelf = encryptedEntity.encryptedSelf,
				securityMetadata = encryptedEntity.securityMetadata,
				extensions = encryptedEntity.extensions,
				extensionsVersion = encryptedEntity.extensionsVersion,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The HealthElement encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
