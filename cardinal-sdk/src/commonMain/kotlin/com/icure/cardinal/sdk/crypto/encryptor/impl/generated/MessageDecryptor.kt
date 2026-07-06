// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.DecryptedMessage
import com.icure.cardinal.sdk.model.EncryptedMessage
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object MessageDecryptor : AbstractEntityDecryptor<EncryptedMessage, DecryptedMessage>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedMessage,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedMessage {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedMessage(
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
				fromAddress =
					decryptedContent["fromAddress"].let {
						if (it != null) {
							usedEncryptedContent += "fromAddress"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.fromAddress
						}
					},
				fromHealthcarePartyId =
					decryptedContent["fromHealthcarePartyId"].let {
						if (it != null) {
							usedEncryptedContent += "fromHealthcarePartyId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.fromHealthcarePartyId
						}
					},
				recipients =
					decryptedContent["recipients"].let {
						if (it != null) {
							usedEncryptedContent += "recipients"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.recipients
						}
					},
				toAddresses =
					decryptedContent["toAddresses"].let {
						if (it != null) {
							usedEncryptedContent += "toAddresses"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.toAddresses
						}
					},
				received =
					decryptedContent["received"].let {
						if (it != null) {
							usedEncryptedContent += "received"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.received
						}
					},
				sent =
					decryptedContent["sent"].let {
						if (it != null) {
							usedEncryptedContent += "sent"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.sent
						}
					},
				metas =
					decryptedContent["metas"].let {
						if (it != null) {
							usedEncryptedContent += "metas"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.metas
						}
					},
				readStatus =
					decryptedContent["readStatus"].let {
						if (it != null) {
							usedEncryptedContent += "readStatus"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.readStatus
						}
					},
				transportGuid =
					decryptedContent["transportGuid"].let {
						if (it != null) {
							usedEncryptedContent += "transportGuid"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.transportGuid
						}
					},
				remark =
					decryptedContent["remark"].let {
						if (it != null) {
							usedEncryptedContent += "remark"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.remark
						}
					},
				conversationGuid =
					decryptedContent["conversationGuid"].let {
						if (it != null) {
							usedEncryptedContent += "conversationGuid"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.conversationGuid
						}
					},
				subject =
					decryptedContent["subject"].let {
						if (it != null) {
							usedEncryptedContent += "subject"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.subject
						}
					},
				invoiceIds =
					decryptedContent["invoiceIds"].let {
						if (it != null) {
							usedEncryptedContent += "invoiceIds"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.invoiceIds
						}
					},
				parentId =
					decryptedContent["parentId"].let {
						if (it != null) {
							usedEncryptedContent += "parentId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.parentId
						}
					},
				properties =
					decryptedContent["properties"].let {
						if (it != null) {
							usedEncryptedContent += "properties"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.properties.mapTo(mutableSetOf()) { x0 ->
								PropertyStubDecryptor.decrypt(
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
				"The Message encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
