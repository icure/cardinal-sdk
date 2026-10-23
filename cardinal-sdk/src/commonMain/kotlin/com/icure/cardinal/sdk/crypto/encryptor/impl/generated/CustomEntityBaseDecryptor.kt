// This file is auto-generated
@file:Suppress("ktlint:standard:max-line-length")

package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractCustomEntityBaseDecryptor
import com.icure.cardinal.sdk.model.DecryptedCustomEntityBase
import com.icure.cardinal.sdk.model.EncryptedCustomEntityBase
import com.icure.cardinal.sdk.options.DecryptedJsonStrictness
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.Int
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Collection
import kotlin.collections.Map

@InternalIcureApi
internal class CustomEntityBaseDecryptor(
	encryptedContentDecoder: Json,
	extensionsDecryptorsByVersion: Map<Int, Lazy<ExtensionsEncryptors>>,
	cryptoService: CryptoService,
	unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
	customEntityTypeId: String,
) : AbstractCustomEntityBaseDecryptor(
		encryptedContentDecoder,
		extensionsDecryptorsByVersion,
		cryptoService,
		unversionedEntitiesDecryptedJsonStrictness,
		customEntityTypeId,
	) {
	override suspend fun decryptCommonMeta(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedCustomEntityBase,
		entityCustomisedModelVersion: Int,
		extensions: JsonObject?,
	): DecryptedCustomEntityBase {
		val decryptedContent = decryptAndPatchContent(decryptionKeys, encryptedEntity)
		return DecryptedCustomEntityBase(
			id = encryptedEntity.id,
			rev = encryptedEntity.rev,
			deletionDate = encryptedEntity.deletionDate,
			secretForeignKeys = encryptedEntity.secretForeignKeys,
			cryptedForeignKeys = encryptedEntity.cryptedForeignKeys,
			delegations = encryptedEntity.delegations,
			encryptionKeys = encryptedEntity.encryptionKeys,
			securityMetadata = encryptedEntity.securityMetadata,
			created =
				encryptedContentDecoder.decodeDecrypted(
					decryptedContent["created"],
					encryptedEntity.created,
					entityCustomisedModelVersion,
				),
			modified =
				encryptedContentDecoder.decodeDecrypted(
					decryptedContent["modified"],
					encryptedEntity.modified,
					entityCustomisedModelVersion,
				),
			author =
				encryptedContentDecoder.decodeDecrypted(
					decryptedContent["author"],
					encryptedEntity.author,
					entityCustomisedModelVersion,
				),
			responsible =
				encryptedContentDecoder.decodeDecrypted(
					decryptedContent["responsible"],
					encryptedEntity.responsible,
					entityCustomisedModelVersion,
				),
			endOfLife =
				encryptedContentDecoder.decodeDecrypted(
					decryptedContent["endOfLife"],
					encryptedEntity.endOfLife,
					entityCustomisedModelVersion,
				),
			tags =
				encryptedContentDecoder.decodeDecrypted(
					decryptedContent["tags"],
					encryptedEntity.tags,
					entityCustomisedModelVersion,
				),
			codes =
				encryptedContentDecoder.decodeDecrypted(
					decryptedContent["codes"],
					encryptedEntity.codes,
					entityCustomisedModelVersion,
				),
			customisedModelVersion = encryptedEntity.customisedModelVersion,
			extensions = extensions,
			dataAttachments = encryptedEntity.dataAttachments,
			deletedAttachments = encryptedEntity.deletedAttachments,
			encryptedSelf = encryptedEntity.encryptedSelf,
		)
	}
}
