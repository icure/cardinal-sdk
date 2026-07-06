// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedSubContact
import com.icure.cardinal.sdk.model.embed.EncryptedSubContact
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object SubContactDecryptor :
	AbstractEntityDecryptor<EncryptedSubContact, DecryptedSubContact>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedSubContact,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedSubContact {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedSubContact(
				id = encryptedEntity.id,
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
				descr =
					decryptedContent["descr"].let {
						if (it != null) {
							usedEncryptedContent += "descr"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.descr
						}
					},
				protocol =
					decryptedContent["protocol"].let {
						if (it != null) {
							usedEncryptedContent += "protocol"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.protocol
						}
					},
				formId =
					decryptedContent["formId"].let {
						if (it != null) {
							usedEncryptedContent += "formId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.formId
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
				healthElementId =
					decryptedContent["healthElementId"].let {
						if (it != null) {
							usedEncryptedContent += "healthElementId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.healthElementId
						}
					},
				services =
					decryptedContent["services"].let {
						if (it != null) {
							usedEncryptedContent += "services"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.services
						}
					},
				encryptedSelf = encryptedEntity.encryptedSelf,
				extensions = encryptedEntity.extensions,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The SubContact encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
