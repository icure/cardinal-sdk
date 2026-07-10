// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedPlanOfAction
import com.icure.cardinal.sdk.model.embed.EncryptedPlanOfAction
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object PlanOfActionDecryptor :
	AbstractEntityDecryptor<EncryptedPlanOfAction, DecryptedPlanOfAction>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedPlanOfAction,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
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
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["created"]?.also { usedEncryptedContent += "created" },
						encryptedEntity.created,
						decryptedJsonStrictness,
					),
				modified =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["modified"]?.also { usedEncryptedContent += "modified" },
						encryptedEntity.modified,
						decryptedJsonStrictness,
					),
				author =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["author"]?.also { usedEncryptedContent += "author" },
						encryptedEntity.author,
						decryptedJsonStrictness,
					),
				responsible =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["responsible"]?.also { usedEncryptedContent += "responsible" },
						encryptedEntity.responsible,
						decryptedJsonStrictness,
					),
				tags =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["tags"]?.also { usedEncryptedContent += "tags" },
						encryptedEntity.tags,
						decryptedJsonStrictness,
					),
				codes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["codes"]?.also { usedEncryptedContent += "codes" },
						encryptedEntity.codes,
						decryptedJsonStrictness,
					),
				endOfLife = encryptedEntity.endOfLife,
				prescriberId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["prescriberId"]?.also { usedEncryptedContent += "prescriberId" },
						encryptedEntity.prescriberId,
						decryptedJsonStrictness,
					),
				valueDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["valueDate"]?.also { usedEncryptedContent += "valueDate" },
						encryptedEntity.valueDate,
						decryptedJsonStrictness,
					),
				openingDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["openingDate"]?.also { usedEncryptedContent += "openingDate" },
						encryptedEntity.openingDate,
						decryptedJsonStrictness,
					),
				closingDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["closingDate"]?.also { usedEncryptedContent += "closingDate" },
						encryptedEntity.closingDate,
						decryptedJsonStrictness,
					),
				deadlineDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["deadlineDate"]?.also { usedEncryptedContent += "deadlineDate" },
						encryptedEntity.deadlineDate,
						decryptedJsonStrictness,
					),
				name =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["name"]?.also { usedEncryptedContent += "name" },
						encryptedEntity.name,
						decryptedJsonStrictness,
					),
				descr =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["descr"]?.also { usedEncryptedContent += "descr" },
						encryptedEntity.descr,
						decryptedJsonStrictness,
					),
				note =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["note"]?.also { usedEncryptedContent += "note" },
						encryptedEntity.note,
						decryptedJsonStrictness,
					),
				idOpeningContact =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["idOpeningContact"]?.also { usedEncryptedContent += "idOpeningContact" },
						encryptedEntity.idOpeningContact,
						decryptedJsonStrictness,
					),
				idClosingContact =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["idClosingContact"]?.also { usedEncryptedContent += "idClosingContact" },
						encryptedEntity.idClosingContact,
						decryptedJsonStrictness,
					),
				careTeamMemberships =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["careTeamMemberships"]?.also { usedEncryptedContent += "careTeamMemberships" },
						encryptedEntity.careTeamMemberships.map { x0 ->
							CareTeamMembershipDecryptor.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								patchDecryptedSelfJson = patchDecryptedSelfJson,
								decryptedJsonStrictness = decryptedJsonStrictness,
								encryptedContentDecoder = encryptedContentDecoder,
								cryptoService = cryptoService,
							)
						},
						decryptedJsonStrictness,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
				extensions = encryptedEntity.extensions,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The PlanOfAction encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
