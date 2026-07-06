// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.EncryptedContact
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object ContactDecryptor : AbstractEntityDecryptor<EncryptedContact, DecryptedContact>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedContact,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedContact {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedContact(
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
				identifier =
					decryptedContent["identifier"].let {
						if (it != null) {
							usedEncryptedContent += "identifier"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.identifier
						}
					},
				endOfLife = encryptedEntity.endOfLife,
				deletionDate = encryptedEntity.deletionDate,
				groupId =
					decryptedContent["groupId"].let {
						if (it != null) {
							usedEncryptedContent += "groupId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.groupId
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
				location =
					decryptedContent["location"].let {
						if (it != null) {
							usedEncryptedContent += "location"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.location
						}
					},
				encounterType =
					decryptedContent["encounterType"].let {
						if (it != null) {
							usedEncryptedContent += "encounterType"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.encounterType
						}
					},
				encounterLocation =
					decryptedContent["encounterLocation"].let {
						if (it != null) {
							usedEncryptedContent += "encounterLocation"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.encounterLocation?.let {
								AddressDecryptor.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = it,
									patchDecryptedSelfJson = patchDecryptedSelfJson,
									ignoreUnknownDecryptedFields = ignoreUnknownDecryptedFields,
									encryptedContentDecoder = encryptedContentDecoder,
									cryptoService = cryptoService,
								)
							}
						}
					},
				subContacts =
					decryptedContent["subContacts"].let {
						if (it != null) {
							usedEncryptedContent += "subContacts"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.subContacts.mapTo(mutableSetOf()) { x0 ->
								SubContactDecryptor.decrypt(
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
				services =
					decryptedContent["services"].let {
						if (it != null) {
							usedEncryptedContent += "services"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.services.mapTo(mutableSetOf()) { x0 ->
								ServiceDecryptor.decrypt(
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
				participantList =
					decryptedContent["participantList"].let {
						if (it != null) {
							usedEncryptedContent += "participantList"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.participantList
						}
					},
				secretForeignKeys = encryptedEntity.secretForeignKeys,
				cryptedForeignKeys = encryptedEntity.cryptedForeignKeys,
				delegations = encryptedEntity.delegations,
				encryptionKeys = encryptedEntity.encryptionKeys,
				encryptedSelf = encryptedEntity.encryptedSelf,
				securityMetadata = encryptedEntity.securityMetadata,
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
				extensions = encryptedEntity.extensions,
				extensionsVersion = encryptedEntity.extensionsVersion,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Contact encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
