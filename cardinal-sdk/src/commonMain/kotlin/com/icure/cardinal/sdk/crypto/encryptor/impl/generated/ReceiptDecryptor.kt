// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.DecryptedReceipt
import com.icure.cardinal.sdk.model.EncryptedReceipt
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object ReceiptDecryptor : AbstractEntityDecryptor<EncryptedReceipt, DecryptedReceipt>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedReceipt,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
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
				deletionDate = encryptedEntity.deletionDate,
				attachmentIds =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["attachmentIds"]?.also { usedEncryptedContent += "attachmentIds" },
						encryptedEntity.attachmentIds,
						decryptedJsonStrictness,
					),
				attachmentInfos =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["attachmentInfos"]?.also { usedEncryptedContent += "attachmentInfos" },
						encryptedEntity.attachmentInfos,
						decryptedJsonStrictness,
					),
				deletedAttachments =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["deletedAttachments"]?.also { usedEncryptedContent += "deletedAttachments" },
						encryptedEntity.deletedAttachments,
						decryptedJsonStrictness,
					),
				references =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["references"]?.also { usedEncryptedContent += "references" },
						encryptedEntity.references,
						decryptedJsonStrictness,
					),
				documentId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["documentId"]?.also { usedEncryptedContent += "documentId" },
						encryptedEntity.documentId,
						decryptedJsonStrictness,
					),
				category =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["category"]?.also { usedEncryptedContent += "category" },
						encryptedEntity.category,
						decryptedJsonStrictness,
					),
				subCategory =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["subCategory"]?.also { usedEncryptedContent += "subCategory" },
						encryptedEntity.subCategory,
						decryptedJsonStrictness,
					),
				secretForeignKeys = encryptedEntity.secretForeignKeys,
				cryptedForeignKeys = encryptedEntity.cryptedForeignKeys,
				delegations = encryptedEntity.delegations,
				encryptionKeys = encryptedEntity.encryptionKeys,
				encryptedSelf = encryptedEntity.encryptedSelf,
				securityMetadata = encryptedEntity.securityMetadata,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Receipt encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
