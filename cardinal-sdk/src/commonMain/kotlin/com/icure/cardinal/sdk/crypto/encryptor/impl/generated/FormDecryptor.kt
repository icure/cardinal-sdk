// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.DecryptedForm
import com.icure.cardinal.sdk.model.EncryptedForm
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object FormDecryptor : AbstractEntityDecryptor<EncryptedForm, DecryptedForm>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedForm,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedForm {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedForm(
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
				openingDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["openingDate"]?.also { usedEncryptedContent += "openingDate" },
						encryptedEntity.openingDate,
						decryptedJsonStrictness,
					),
				status =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["status"]?.also { usedEncryptedContent += "status" },
						encryptedEntity.status,
						decryptedJsonStrictness,
					),
				version =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["version"]?.also { usedEncryptedContent += "version" },
						encryptedEntity.version,
						decryptedJsonStrictness,
					),
				descr =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["descr"]?.also { usedEncryptedContent += "descr" },
						encryptedEntity.descr,
						decryptedJsonStrictness,
					),
				uniqueId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["uniqueId"]?.also { usedEncryptedContent += "uniqueId" },
						encryptedEntity.uniqueId,
						decryptedJsonStrictness,
					),
				formTemplateId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["formTemplateId"]?.also { usedEncryptedContent += "formTemplateId" },
						encryptedEntity.formTemplateId,
						decryptedJsonStrictness,
					),
				contactId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["contactId"]?.also { usedEncryptedContent += "contactId" },
						encryptedEntity.contactId,
						decryptedJsonStrictness,
					),
				healthElementId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["healthElementId"]?.also { usedEncryptedContent += "healthElementId" },
						encryptedEntity.healthElementId,
						decryptedJsonStrictness,
					),
				planOfActionId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["planOfActionId"]?.also { usedEncryptedContent += "planOfActionId" },
						encryptedEntity.planOfActionId,
						decryptedJsonStrictness,
					),
				parent =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["parent"]?.also { usedEncryptedContent += "parent" },
						encryptedEntity.parent,
						decryptedJsonStrictness,
					),
				anchorId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["anchorId"]?.also { usedEncryptedContent += "anchorId" },
						encryptedEntity.anchorId,
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
			throw EntityEncryptionException("The Form encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}")
		}
		return result
	}
}
