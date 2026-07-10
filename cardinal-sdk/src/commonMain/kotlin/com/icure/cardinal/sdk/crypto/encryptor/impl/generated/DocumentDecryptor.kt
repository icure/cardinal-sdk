// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.model.EncryptedDocument
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object DocumentDecryptor : AbstractEntityDecryptor<EncryptedDocument, DecryptedDocument>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedDocument,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedDocument {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedDocument(
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
				documentType =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["documentType"]?.also { usedEncryptedContent += "documentType" },
						encryptedEntity.documentType,
						decryptedJsonStrictness,
					),
				documentStatus =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["documentStatus"]?.also { usedEncryptedContent += "documentStatus" },
						encryptedEntity.documentStatus,
						decryptedJsonStrictness,
					),
				externalUri =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["externalUri"]?.also { usedEncryptedContent += "externalUri" },
						encryptedEntity.externalUri,
						decryptedJsonStrictness,
					),
				name =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["name"]?.also { usedEncryptedContent += "name" },
						encryptedEntity.name,
						decryptedJsonStrictness,
					),
				version =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["version"]?.also { usedEncryptedContent += "version" },
						encryptedEntity.version,
						decryptedJsonStrictness,
					),
				size = encryptedEntity.size,
				hash = encryptedEntity.hash,
				openingContactId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["openingContactId"]?.also { usedEncryptedContent += "openingContactId" },
						encryptedEntity.openingContactId,
						decryptedJsonStrictness,
					),
				attachmentId = encryptedEntity.attachmentId,
				objectStoreReference = encryptedEntity.objectStoreReference,
				mainUti = encryptedEntity.mainUti,
				otherUtis = encryptedEntity.otherUtis,
				mainAttachmentStoredDataSize = encryptedEntity.mainAttachmentStoredDataSize,
				extraMainAttachmentInfo = encryptedEntity.extraMainAttachmentInfo,
				secondaryAttachments = encryptedEntity.secondaryAttachments,
				deletedAttachments = encryptedEntity.deletedAttachments,
				secretForeignKeys = encryptedEntity.secretForeignKeys,
				cryptedForeignKeys = encryptedEntity.cryptedForeignKeys,
				delegations = encryptedEntity.delegations,
				encryptionKeys = encryptedEntity.encryptionKeys,
				encryptedSelf = encryptedEntity.encryptedSelf,
				securityMetadata = encryptedEntity.securityMetadata,
				extensions = encryptedEntity.extensions,
				extensionsVersion = encryptedEntity.extensionsVersion,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Document encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
