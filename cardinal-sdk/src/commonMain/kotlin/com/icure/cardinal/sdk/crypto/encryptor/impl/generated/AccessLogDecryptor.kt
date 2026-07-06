// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.DecryptedAccessLog
import com.icure.cardinal.sdk.model.EncryptedAccessLog
import com.icure.cardinal.sdk.serialization.InstantSerializer
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object AccessLogDecryptor :
	AbstractEntityDecryptor<EncryptedAccessLog, DecryptedAccessLog>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedAccessLog,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedAccessLog {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedAccessLog(
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
				objectId =
					decryptedContent["objectId"].let {
						if (it != null) {
							usedEncryptedContent += "objectId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.objectId
						}
					},
				accessType =
					decryptedContent["accessType"].let {
						if (it != null) {
							usedEncryptedContent += "accessType"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.accessType
						}
					},
				user =
					decryptedContent["user"].let {
						if (it != null) {
							usedEncryptedContent += "user"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.user
						}
					},
				detail =
					decryptedContent["detail"].let {
						if (it != null) {
							usedEncryptedContent += "detail"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.detail
						}
					},
				date =
					decryptedContent["date"].let {
						if (it != null) {
							usedEncryptedContent += "date"
							encryptedContentDecoder.decodeFromJsonElement(InstantSerializer.nullable, it)
						} else {
							encryptedEntity.date
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
				"The AccessLog encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
