// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.DecryptedReceipt
import com.icure.cardinal.sdk.model.EncryptedReceipt
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object ReceiptDecryptor : AbstractEntityDecryptor<EncryptedReceipt, DecryptedReceipt>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedReceipt,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedReceipt {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedReceipt(
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
				attachmentIds =
					decryptedContent["attachmentIds"].let {
						if (it != null) {
							usedEncryptedContent += "attachmentIds"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.attachmentIds
						}
					},
				attachmentInfos =
					decryptedContent["attachmentInfos"].let {
						if (it != null) {
							usedEncryptedContent += "attachmentInfos"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.attachmentInfos
						}
					},
				deletedAttachments =
					decryptedContent["deletedAttachments"].let {
						if (it != null) {
							usedEncryptedContent += "deletedAttachments"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.deletedAttachments
						}
					},
				references =
					decryptedContent["references"].let {
						if (it != null) {
							usedEncryptedContent += "references"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.references
						}
					},
				documentId =
					decryptedContent["documentId"].let {
						if (it != null) {
							usedEncryptedContent += "documentId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.documentId
						}
					},
				category =
					decryptedContent["category"].let {
						if (it != null) {
							usedEncryptedContent += "category"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.category
						}
					},
				subCategory =
					decryptedContent["subCategory"].let {
						if (it != null) {
							usedEncryptedContent += "subCategory"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.subCategory
						}
					},
				secretForeignKeys = encryptedEntity.secretForeignKeys,
				cryptedForeignKeys = encryptedEntity.cryptedForeignKeys,
				delegations = encryptedEntity.delegations,
				encryptionKeys = encryptedEntity.encryptionKeys,
				encryptedSelf = encryptedEntity.encryptedSelf,
				securityMetadata = encryptedEntity.securityMetadata,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Receipt encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
