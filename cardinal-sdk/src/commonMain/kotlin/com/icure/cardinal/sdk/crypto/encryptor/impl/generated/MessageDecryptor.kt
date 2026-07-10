// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.DecryptedMessage
import com.icure.cardinal.sdk.model.EncryptedMessage
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object MessageDecryptor : AbstractEntityDecryptor<EncryptedMessage, DecryptedMessage>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedMessage,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
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
				fromAddress =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["fromAddress"]?.also { usedEncryptedContent += "fromAddress" },
						encryptedEntity.fromAddress,
						decryptedJsonStrictness,
					),
				fromHealthcarePartyId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["fromHealthcarePartyId"]?.also { usedEncryptedContent += "fromHealthcarePartyId" },
						encryptedEntity.fromHealthcarePartyId,
						decryptedJsonStrictness,
					),
				recipients =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["recipients"]?.also { usedEncryptedContent += "recipients" },
						encryptedEntity.recipients,
						decryptedJsonStrictness,
					),
				toAddresses =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["toAddresses"]?.also { usedEncryptedContent += "toAddresses" },
						encryptedEntity.toAddresses,
						decryptedJsonStrictness,
					),
				received =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["received"]?.also { usedEncryptedContent += "received" },
						encryptedEntity.received,
						decryptedJsonStrictness,
					),
				sent =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["sent"]?.also { usedEncryptedContent += "sent" },
						encryptedEntity.sent,
						decryptedJsonStrictness,
					),
				metas =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["metas"]?.also { usedEncryptedContent += "metas" },
						encryptedEntity.metas,
						decryptedJsonStrictness,
					),
				readStatus =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["readStatus"]?.also { usedEncryptedContent += "readStatus" },
						encryptedEntity.readStatus,
						decryptedJsonStrictness,
					),
				transportGuid =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["transportGuid"]?.also { usedEncryptedContent += "transportGuid" },
						encryptedEntity.transportGuid,
						decryptedJsonStrictness,
					),
				remark =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["remark"]?.also { usedEncryptedContent += "remark" },
						encryptedEntity.remark,
						decryptedJsonStrictness,
					),
				conversationGuid =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["conversationGuid"]?.also { usedEncryptedContent += "conversationGuid" },
						encryptedEntity.conversationGuid,
						decryptedJsonStrictness,
					),
				subject =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["subject"]?.also { usedEncryptedContent += "subject" },
						encryptedEntity.subject,
						decryptedJsonStrictness,
					),
				invoiceIds =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["invoiceIds"]?.also { usedEncryptedContent += "invoiceIds" },
						encryptedEntity.invoiceIds,
						decryptedJsonStrictness,
					),
				parentId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["parentId"]?.also { usedEncryptedContent += "parentId" },
						encryptedEntity.parentId,
						decryptedJsonStrictness,
					),
				properties =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["properties"]?.also { usedEncryptedContent += "properties" },
						encryptedEntity.properties.mapTo(mutableSetOf()) { x0 ->
							PropertyStubDecryptor.decrypt(
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
				"The Message encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
