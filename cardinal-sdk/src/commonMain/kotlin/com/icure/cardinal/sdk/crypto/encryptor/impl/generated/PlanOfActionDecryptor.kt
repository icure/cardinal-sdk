// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedPlanOfAction
import com.icure.cardinal.sdk.model.embed.EncryptedPlanOfAction
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object PlanOfActionDecryptor :
	AbstractEntityDecryptor<EncryptedPlanOfAction, DecryptedPlanOfAction>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedPlanOfAction,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedPlanOfAction {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedPlanOfAction(
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
				endOfLife = encryptedEntity.endOfLife,
				prescriberId =
					decryptedContent["prescriberId"].let {
						if (it != null) {
							usedEncryptedContent += "prescriberId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.prescriberId
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
				deadlineDate =
					decryptedContent["deadlineDate"].let {
						if (it != null) {
							usedEncryptedContent += "deadlineDate"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.deadlineDate
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
				careTeamMemberships =
					decryptedContent["careTeamMemberships"].let {
						if (it != null) {
							usedEncryptedContent += "careTeamMemberships"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.careTeamMemberships.map { x0 ->
								CareTeamMembershipDecryptor.decrypt(
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
				encryptedSelf = encryptedEntity.encryptedSelf,
				extensions = encryptedEntity.extensions,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The PlanOfAction encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
