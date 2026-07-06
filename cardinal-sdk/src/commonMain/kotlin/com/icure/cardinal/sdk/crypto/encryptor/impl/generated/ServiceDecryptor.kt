// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object ServiceDecryptor : AbstractEntityDecryptor<EncryptedService, DecryptedService>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedService,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedService {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedService(
				id = encryptedEntity.id,
				transactionId =
					decryptedContent["transactionId"].let {
						if (it != null) {
							usedEncryptedContent += "transactionId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.transactionId
						}
					},
				identifier =
					decryptedContent["identifier"].let {
						if (it != null) {
							usedEncryptedContent += "identifier"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.identifier
						}
					},
				contactId = encryptedEntity.contactId,
				subContactIds =
					decryptedContent["subContactIds"].let {
						if (it != null) {
							usedEncryptedContent += "subContactIds"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.subContactIds
						}
					},
				plansOfActionIds =
					decryptedContent["plansOfActionIds"].let {
						if (it != null) {
							usedEncryptedContent += "plansOfActionIds"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.plansOfActionIds
						}
					},
				healthElementsIds =
					decryptedContent["healthElementsIds"].let {
						if (it != null) {
							usedEncryptedContent += "healthElementsIds"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.healthElementsIds
						}
					},
				formIds =
					decryptedContent["formIds"].let {
						if (it != null) {
							usedEncryptedContent += "formIds"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.formIds
						}
					},
				secretForeignKeys = encryptedEntity.secretForeignKeys,
				cryptedForeignKeys = encryptedEntity.cryptedForeignKeys,
				delegations = encryptedEntity.delegations,
				encryptionKeys = encryptedEntity.encryptionKeys,
				label =
					decryptedContent["label"].let {
						if (it != null) {
							usedEncryptedContent += "label"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.label
						}
					},
				index =
					decryptedContent["index"].let {
						if (it != null) {
							usedEncryptedContent += "index"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.index
						}
					},
				content =
					decryptedContent["content"].let {
						if (it != null) {
							usedEncryptedContent += "content"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.content.mapValues { (_, x0) ->
								ContentDecryptor.decrypt(
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
				textIndexes =
					decryptedContent["textIndexes"].let {
						if (it != null) {
							usedEncryptedContent += "textIndexes"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.textIndexes
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
				endOfLife = encryptedEntity.endOfLife,
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
				comment =
					decryptedContent["comment"].let {
						if (it != null) {
							usedEncryptedContent += "comment"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.comment
						}
					},
				invoicingCodes =
					decryptedContent["invoicingCodes"].let {
						if (it != null) {
							usedEncryptedContent += "invoicingCodes"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.invoicingCodes
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
				qualifiedLinks =
					decryptedContent["qualifiedLinks"].let {
						if (it != null) {
							usedEncryptedContent += "qualifiedLinks"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.qualifiedLinks
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
				tags =
					decryptedContent["tags"].let {
						if (it != null) {
							usedEncryptedContent += "tags"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.tags
						}
					},
				encryptedSelf = encryptedEntity.encryptedSelf,
				securityMetadata = encryptedEntity.securityMetadata,
				extensions = encryptedEntity.extensions,
				contactExtensionsVersions = encryptedEntity.contactExtensionsVersions,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Service encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
