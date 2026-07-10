// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object ServiceDecryptor : AbstractEntityDecryptor<EncryptedService, DecryptedService>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedService,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedService {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedService(
				id = encryptedEntity.id,
				transactionId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["transactionId"]?.also { usedEncryptedContent += "transactionId" },
						encryptedEntity.transactionId,
						decryptedJsonStrictness,
					),
				identifier =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["identifier"]?.also { usedEncryptedContent += "identifier" },
						encryptedEntity.identifier,
						decryptedJsonStrictness,
					),
				contactId = encryptedEntity.contactId,
				subContactIds =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["subContactIds"]?.also { usedEncryptedContent += "subContactIds" },
						encryptedEntity.subContactIds,
						decryptedJsonStrictness,
					),
				plansOfActionIds =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["plansOfActionIds"]?.also { usedEncryptedContent += "plansOfActionIds" },
						encryptedEntity.plansOfActionIds,
						decryptedJsonStrictness,
					),
				healthElementsIds =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["healthElementsIds"]?.also { usedEncryptedContent += "healthElementsIds" },
						encryptedEntity.healthElementsIds,
						decryptedJsonStrictness,
					),
				formIds =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["formIds"]?.also { usedEncryptedContent += "formIds" },
						encryptedEntity.formIds,
						decryptedJsonStrictness,
					),
				secretForeignKeys = encryptedEntity.secretForeignKeys,
				cryptedForeignKeys = encryptedEntity.cryptedForeignKeys,
				delegations = encryptedEntity.delegations,
				encryptionKeys = encryptedEntity.encryptionKeys,
				label =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["label"]?.also { usedEncryptedContent += "label" },
						encryptedEntity.label,
						decryptedJsonStrictness,
					),
				index =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["index"]?.also { usedEncryptedContent += "index" },
						encryptedEntity.index,
						decryptedJsonStrictness,
					),
				content =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["content"]?.also { usedEncryptedContent += "content" },
						encryptedEntity.content.mapValues { (_, x0) ->
							ContentDecryptor.decrypt(
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
				textIndexes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["textIndexes"]?.also { usedEncryptedContent += "textIndexes" },
						encryptedEntity.textIndexes,
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
				endOfLife = encryptedEntity.endOfLife,
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
				comment =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["comment"]?.also { usedEncryptedContent += "comment" },
						encryptedEntity.comment,
						decryptedJsonStrictness,
					),
				invoicingCodes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["invoicingCodes"]?.also { usedEncryptedContent += "invoicingCodes" },
						encryptedEntity.invoicingCodes,
						decryptedJsonStrictness,
					),
				notes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["notes"]?.also { usedEncryptedContent += "notes" },
						encryptedEntity.notes.map { x0 ->
							AnnotationDecryptor.decrypt(
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
				qualifiedLinks =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["qualifiedLinks"]?.also { usedEncryptedContent += "qualifiedLinks" },
						encryptedEntity.qualifiedLinks,
						decryptedJsonStrictness,
					),
				codes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["codes"]?.also { usedEncryptedContent += "codes" },
						encryptedEntity.codes,
						decryptedJsonStrictness,
					),
				tags =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["tags"]?.also { usedEncryptedContent += "tags" },
						encryptedEntity.tags,
						decryptedJsonStrictness,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
				securityMetadata = encryptedEntity.securityMetadata,
				extensions = encryptedEntity.extensions,
				contactExtensionsVersions = encryptedEntity.contactExtensionsVersions,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Service encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
