// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedAnnotation
import com.icure.cardinal.sdk.model.embed.EncryptedAnnotation
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object AnnotationDecryptor :
	AbstractEntityDecryptor<EncryptedAnnotation, DecryptedAnnotation>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedAnnotation,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedAnnotation {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedAnnotation(
				id = encryptedEntity.id,
				author =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["author"]?.also { usedEncryptedContent += "author" },
						encryptedEntity.author,
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
				text =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["text"]?.also { usedEncryptedContent += "text" },
						encryptedEntity.text,
						decryptedJsonStrictness,
					),
				markdown =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["markdown"]?.also { usedEncryptedContent += "markdown" },
						encryptedEntity.markdown,
						decryptedJsonStrictness,
					),
				location =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["location"]?.also { usedEncryptedContent += "location" },
						encryptedEntity.location,
						decryptedJsonStrictness,
					),
				confidential =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["confidential"]?.also { usedEncryptedContent += "confidential" },
						encryptedEntity.confidential,
						decryptedJsonStrictness,
					),
				tags =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["tags"]?.also { usedEncryptedContent += "tags" },
						encryptedEntity.tags,
						decryptedJsonStrictness,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Annotation encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
