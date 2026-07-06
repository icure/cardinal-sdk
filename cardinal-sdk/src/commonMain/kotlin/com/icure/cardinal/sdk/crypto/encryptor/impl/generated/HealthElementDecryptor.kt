// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object HealthElementDecryptor :
	AbstractEntityDecryptor<EncryptedHealthElement, DecryptedHealthElement>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedHealthElement,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
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
					decryptedContent["identifiers"].let {
						if (it != null) {
							usedEncryptedContent += "identifiers"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.identifiers
						}
					},
				rev = encryptedEntity.rev,
				created =
					decryptedContent["created"].let {
						if (it != null) {
							usedEncryptedContent += "created"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.created
						}
					},
				modified =
					decryptedContent["modified"].let {
						if (it != null) {
							usedEncryptedContent += "modified"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.modified
						}
					},
				author =
					decryptedContent["author"].let {
						if (it != null) {
							usedEncryptedContent += "author"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.author
						}
					},
				responsible =
					decryptedContent["responsible"].let {
						if (it != null) {
							usedEncryptedContent += "responsible"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.responsible
						}
					},
				tags =
					decryptedContent["tags"].let {
						if (it != null) {
							usedEncryptedContent += "tags"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.tags
						}
					},
				codes =
					decryptedContent["codes"].let {
						if (it != null) {
							usedEncryptedContent += "codes"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.codes
						}
					},
				endOfLife = encryptedEntity.endOfLife,
				deletionDate = encryptedEntity.deletionDate,
				healthElementId =
					decryptedContent["healthElementId"].let {
						if (it != null) {
							usedEncryptedContent += "healthElementId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.healthElementId
						}
					},
				valueDate =
					decryptedContent["valueDate"].let {
						if (it != null) {
							usedEncryptedContent += "valueDate"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.valueDate
						}
					},
				openingDate =
					decryptedContent["openingDate"].let {
						if (it != null) {
							usedEncryptedContent += "openingDate"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.openingDate
						}
					},
				closingDate =
					decryptedContent["closingDate"].let {
						if (it != null) {
							usedEncryptedContent += "closingDate"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.closingDate
						}
					},
				descr =
					decryptedContent["descr"].let {
						if (it != null) {
							usedEncryptedContent += "descr"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.descr
						}
					},
				note =
					decryptedContent["note"].let {
						if (it != null) {
							usedEncryptedContent += "note"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.note
						}
					},
				notes =
					decryptedContent["notes"].let {
						if (it != null) {
							usedEncryptedContent += "notes"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.notes.map { x0 ->
								AnnotationDecryptor.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = x0,
									patchDecryptedSelfJson = patchDecryptedSelfJson,
									ignoreUnknownDecryptedFields = ignoreUnknownDecryptedFields,
									encryptedContentDecoder = encryptedContentDecoder,
									cryptoService = cryptoService,
								)
							}
						}
					},
				relevant =
					decryptedContent["relevant"].let {
						if (it != null) {
							usedEncryptedContent += "relevant"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.relevant
						}
					},
				idOpeningContact =
					decryptedContent["idOpeningContact"].let {
						if (it != null) {
							usedEncryptedContent += "idOpeningContact"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.idOpeningContact
						}
					},
				idClosingContact =
					decryptedContent["idClosingContact"].let {
						if (it != null) {
							usedEncryptedContent += "idClosingContact"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.idClosingContact
						}
					},
				idService =
					decryptedContent["idService"].let {
						if (it != null) {
							usedEncryptedContent += "idService"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.idService
						}
					},
				laterality =
					decryptedContent["laterality"].let {
						if (it != null) {
							usedEncryptedContent += "laterality"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.laterality
						}
					},
				plansOfAction =
					decryptedContent["plansOfAction"].let {
						if (it != null) {
							usedEncryptedContent += "plansOfAction"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.plansOfAction.map { x0 ->
								PlanOfActionDecryptor.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = x0,
									patchDecryptedSelfJson = patchDecryptedSelfJson,
									ignoreUnknownDecryptedFields = ignoreUnknownDecryptedFields,
									encryptedContentDecoder = encryptedContentDecoder,
									cryptoService = cryptoService,
								)
							}
						}
					},
				episodes =
					decryptedContent["episodes"].let {
						if (it != null) {
							usedEncryptedContent += "episodes"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.episodes.map { x0 ->
								EpisodeDecryptor.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = x0,
									patchDecryptedSelfJson = patchDecryptedSelfJson,
									ignoreUnknownDecryptedFields = ignoreUnknownDecryptedFields,
									encryptedContentDecoder = encryptedContentDecoder,
									cryptoService = cryptoService,
								)
							}
						}
					},
				careTeam =
					decryptedContent["careTeam"].let {
						if (it != null) {
							usedEncryptedContent += "careTeam"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.careTeam.map { x0 ->
								CareTeamMemberDecryptor.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = x0,
									patchDecryptedSelfJson = patchDecryptedSelfJson,
									ignoreUnknownDecryptedFields = ignoreUnknownDecryptedFields,
									encryptedContentDecoder = encryptedContentDecoder,
									cryptoService = cryptoService,
								)
							}
						}
					},
				secretForeignKeys = encryptedEntity.secretForeignKeys,
				cryptedForeignKeys = encryptedEntity.cryptedForeignKeys,
				delegations = encryptedEntity.delegations,
				encryptionKeys = encryptedEntity.encryptionKeys,
				encryptedSelf = encryptedEntity.encryptedSelf,
				securityMetadata = encryptedEntity.securityMetadata,
				extensions = encryptedEntity.extensions,
				extensionsVersion = encryptedEntity.extensionsVersion,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The HealthElement encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
