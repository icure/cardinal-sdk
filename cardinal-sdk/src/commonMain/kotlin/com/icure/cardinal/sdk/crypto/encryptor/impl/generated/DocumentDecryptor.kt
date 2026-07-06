// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.model.EncryptedDocument
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object DocumentDecryptor : AbstractEntityDecryptor<EncryptedDocument, DecryptedDocument>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedDocument,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedDocument {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedDocument(
				id = encryptedEntity.id,
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
				deletionDate = encryptedEntity.deletionDate,
				documentType =
					decryptedContent["documentType"].let {
						if (it != null) {
							usedEncryptedContent += "documentType"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.documentType
						}
					},
				documentStatus =
					decryptedContent["documentStatus"].let {
						if (it != null) {
							usedEncryptedContent += "documentStatus"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.documentStatus
						}
					},
				externalUri =
					decryptedContent["externalUri"].let {
						if (it != null) {
							usedEncryptedContent += "externalUri"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.externalUri
						}
					},
				name =
					decryptedContent["name"].let {
						if (it != null) {
							usedEncryptedContent += "name"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.name
						}
					},
				version =
					decryptedContent["version"].let {
						if (it != null) {
							usedEncryptedContent += "version"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.version
						}
					},
				size = encryptedEntity.size,
				hash = encryptedEntity.hash,
				openingContactId =
					decryptedContent["openingContactId"].let {
						if (it != null) {
							usedEncryptedContent += "openingContactId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.openingContactId
						}
					},
				attachmentId = encryptedEntity.attachmentId,
				objectStoreReference = encryptedEntity.objectStoreReference,
				mainUti = encryptedEntity.mainUti,
				otherUtis = encryptedEntity.otherUtis,
				mainAttachmentStoredDataSize = encryptedEntity.mainAttachmentStoredDataSize,
				extraMainAttachmentInfo = encryptedEntity.extraMainAttachmentInfo,
				secondaryAttachments = encryptedEntity.secondaryAttachments,
				deletedAttachments = encryptedEntity.deletedAttachments,
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
				"The Document encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
