// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.DecryptedForm
import com.icure.cardinal.sdk.model.EncryptedForm
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object FormDecryptor : AbstractEntityDecryptor<EncryptedForm, DecryptedForm>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedForm,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedForm {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedForm(
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
				openingDate =
					decryptedContent["openingDate"].let {
						if (it != null) {
							usedEncryptedContent += "openingDate"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.openingDate
						}
					},
				status =
					decryptedContent["status"].let {
						if (it != null) {
							usedEncryptedContent += "status"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.status
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
				descr =
					decryptedContent["descr"].let {
						if (it != null) {
							usedEncryptedContent += "descr"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.descr
						}
					},
				uniqueId =
					decryptedContent["uniqueId"].let {
						if (it != null) {
							usedEncryptedContent += "uniqueId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.uniqueId
						}
					},
				formTemplateId =
					decryptedContent["formTemplateId"].let {
						if (it != null) {
							usedEncryptedContent += "formTemplateId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.formTemplateId
						}
					},
				contactId =
					decryptedContent["contactId"].let {
						if (it != null) {
							usedEncryptedContent += "contactId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.contactId
						}
					},
				healthElementId =
					decryptedContent["healthElementId"].let {
						if (it != null) {
							usedEncryptedContent += "healthElementId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.healthElementId
						}
					},
				planOfActionId =
					decryptedContent["planOfActionId"].let {
						if (it != null) {
							usedEncryptedContent += "planOfActionId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.planOfActionId
						}
					},
				parent =
					decryptedContent["parent"].let {
						if (it != null) {
							usedEncryptedContent += "parent"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.parent
						}
					},
				anchorId =
					decryptedContent["anchorId"].let {
						if (it != null) {
							usedEncryptedContent += "anchorId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.anchorId
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
			throw EntityEncryptionException("The Form encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}")
		}
		return result
	}
}
