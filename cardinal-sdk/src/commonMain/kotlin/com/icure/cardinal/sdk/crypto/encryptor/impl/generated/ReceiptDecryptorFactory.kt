// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.model.DecryptedReceipt
import com.icure.cardinal.sdk.model.EncryptedReceipt
import com.icure.cardinal.sdk.options.DecryptedJsonStrictness
import com.icure.cardinal.sdk.utils.UnexpectedEncryptedContentException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.String
import kotlin.collections.Collection

@InternalIcureApi
internal object ReceiptDecryptorFactory : EntityDecryptorFactory<EncryptedReceipt, DecryptedReceipt> {
	override fun create(
		entityManifestName: String?,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		cryptoService: CryptoService,
		encryptedContentDecoder: Json,
		unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
	): EntityDecryptor<EncryptedReceipt, DecryptedReceipt> {
		val manifest = entityManifestName?.let { encryptorsFactoryContext.getManifest(it) }
		require(manifest?.extensionsManifestsByModelVersion.isNullOrEmpty()) {
			"Receipt is not Extendable and does not support extensions decryption, but its manifest defines extensionsManifestsByModelVersion."
		}
		val patchDecryptedSelfJson = entityManifestName?.let { encryptorsFactoryContext.getManifestDecryptedJsonPatcher(it) }
		return ReceiptDecryptor(
			encryptedContentDecoder = encryptedContentDecoder,
			patchDecryptedSelfJson = patchDecryptedSelfJson,
			cryptoService = cryptoService,
			unversionedEntitiesDecryptedJsonStrictness = unversionedEntitiesDecryptedJsonStrictness,
		)
	}
}

@InternalIcureApi
private class ReceiptDecryptor(
	private val encryptedContentDecoder: Json,
	patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
	cryptoService: CryptoService,
	unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
) : AbstractEntityDecryptor<EncryptedReceipt, DecryptedReceipt>(
		patchDecryptedSelfJson,
		cryptoService,
		unversionedEntitiesDecryptedJsonStrictness,
	) {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedReceipt,
		customisedModelVersion: CustomisedModelVersion?,
	): DecryptedReceipt {
		val entityCustomisedModelVersion = customisedModelVersion?.typeVersion
		val decryptedContent = decryptAndPatchContent(decryptionKeys, encryptedEntity)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedReceipt(
				id = encryptedEntity.id,
				rev = encryptedEntity.rev,
				created =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["created"]?.also { usedEncryptedContent += "created" },
						encryptedEntity.created,
						entityCustomisedModelVersion,
					),
				modified =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["modified"]?.also { usedEncryptedContent += "modified" },
						encryptedEntity.modified,
						entityCustomisedModelVersion,
					),
				author =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["author"]?.also { usedEncryptedContent += "author" },
						encryptedEntity.author,
						entityCustomisedModelVersion,
					),
				responsible =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["responsible"]?.also { usedEncryptedContent += "responsible" },
						encryptedEntity.responsible,
						entityCustomisedModelVersion,
					),
				tags =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["tags"]?.also { usedEncryptedContent += "tags" },
						encryptedEntity.tags,
						entityCustomisedModelVersion,
					),
				codes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["codes"]?.also { usedEncryptedContent += "codes" },
						encryptedEntity.codes,
						entityCustomisedModelVersion,
					),
				deletionDate = encryptedEntity.deletionDate,
				attachmentIds =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["attachmentIds"]?.also { usedEncryptedContent += "attachmentIds" },
						encryptedEntity.attachmentIds,
						entityCustomisedModelVersion,
					),
				attachmentInfos =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["attachmentInfos"]?.also { usedEncryptedContent += "attachmentInfos" },
						encryptedEntity.attachmentInfos,
						entityCustomisedModelVersion,
					),
				deletedAttachments =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["deletedAttachments"]?.also { usedEncryptedContent += "deletedAttachments" },
						encryptedEntity.deletedAttachments,
						entityCustomisedModelVersion,
					),
				references =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["references"]?.also { usedEncryptedContent += "references" },
						encryptedEntity.references,
						entityCustomisedModelVersion,
					),
				documentId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["documentId"]?.also { usedEncryptedContent += "documentId" },
						encryptedEntity.documentId,
						entityCustomisedModelVersion,
					),
				category =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["category"]?.also { usedEncryptedContent += "category" },
						encryptedEntity.category,
						entityCustomisedModelVersion,
					),
				subCategory =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["subCategory"]?.also { usedEncryptedContent += "subCategory" },
						encryptedEntity.subCategory,
						entityCustomisedModelVersion,
					),
				secretForeignKeys = encryptedEntity.secretForeignKeys,
				cryptedForeignKeys = encryptedEntity.cryptedForeignKeys,
				delegations = encryptedEntity.delegations,
				encryptionKeys = encryptedEntity.encryptionKeys,
				encryptedSelf = encryptedEntity.encryptedSelf,
				securityMetadata = encryptedEntity.securityMetadata,
			)
		if (entityCustomisedModelVersion == null &&
			unversionedEntitiesDecryptedJsonStrictness == DecryptedJsonStrictness.Strict &&
			decryptedContent.size != usedEncryptedContent.size
		) {
			throw UnexpectedEncryptedContentException(
				"The Receipt encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
