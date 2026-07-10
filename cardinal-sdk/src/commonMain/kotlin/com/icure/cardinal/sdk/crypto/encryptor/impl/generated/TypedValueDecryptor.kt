// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedTypedValue
import com.icure.cardinal.sdk.model.embed.EncryptedTypedValue
import com.icure.cardinal.sdk.serialization.InstantSerializer
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object TypedValueDecryptor :
	AbstractEntityDecryptor<EncryptedTypedValue, DecryptedTypedValue>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedTypedValue,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedTypedValue {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedTypedValue(
				type =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["type"]?.also { usedEncryptedContent += "type" },
						encryptedEntity.type,
						decryptedJsonStrictness,
					),
				booleanValue =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["booleanValue"]?.also { usedEncryptedContent += "booleanValue" },
						encryptedEntity.booleanValue,
						decryptedJsonStrictness,
					),
				integerValue =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["integerValue"]?.also { usedEncryptedContent += "integerValue" },
						encryptedEntity.integerValue,
						decryptedJsonStrictness,
					),
				doubleValue =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["doubleValue"]?.also { usedEncryptedContent += "doubleValue" },
						encryptedEntity.doubleValue,
						decryptedJsonStrictness,
					),
				stringValue =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["stringValue"]?.also { usedEncryptedContent += "stringValue" },
						encryptedEntity.stringValue,
						decryptedJsonStrictness,
					),
				dateValue =
					encryptedContentDecoder.decodeDecrypted(
						InstantSerializer.nullable,
						decryptedContent["dateValue"]?.also { usedEncryptedContent += "dateValue" },
						encryptedEntity.dateValue,
						decryptedJsonStrictness,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The TypedValue encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
