// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedAnnotation
import com.icure.cardinal.sdk.model.embed.EncryptedAnnotation
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object AnnotationDecryptor :
	AbstractEntityDecryptor<EncryptedAnnotation, DecryptedAnnotation>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedAnnotation,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedAnnotation {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedAnnotation(
				id = encryptedEntity.id,
				author =
					decryptedContent["author"].let {
						if (it != null) {
							usedEncryptedContent += "author"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.author
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
				text =
					decryptedContent["text"].let {
						if (it != null) {
							usedEncryptedContent += "text"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.text
						}
					},
				markdown =
					decryptedContent["markdown"].let {
						if (it != null) {
							usedEncryptedContent += "markdown"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.markdown
						}
					},
				location =
					decryptedContent["location"].let {
						if (it != null) {
							usedEncryptedContent += "location"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.location
						}
					},
				confidential =
					decryptedContent["confidential"].let {
						if (it != null) {
							usedEncryptedContent += "confidential"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.confidential
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
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Annotation encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
