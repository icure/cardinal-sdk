// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedContent
import com.icure.cardinal.sdk.model.embed.EncryptedContent
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
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
internal object ContentDecryptor : AbstractEntityDecryptor<EncryptedContent, DecryptedContent>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedContent,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedContent {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedContent(
				stringValue =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["stringValue"]?.also { usedEncryptedContent += "stringValue" },
						encryptedEntity.stringValue,
						decryptedJsonStrictness,
					),
				numberValue =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["numberValue"]?.also { usedEncryptedContent += "numberValue" },
						encryptedEntity.numberValue,
						decryptedJsonStrictness,
					),
				booleanValue =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["booleanValue"]?.also { usedEncryptedContent += "booleanValue" },
						encryptedEntity.booleanValue,
						decryptedJsonStrictness,
					),
				instantValue =
					encryptedContentDecoder.decodeDecrypted(
						InstantSerializer.nullable,
						decryptedContent["instantValue"]?.also { usedEncryptedContent += "instantValue" },
						encryptedEntity.instantValue,
						decryptedJsonStrictness,
					),
				fuzzyDateValue =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["fuzzyDateValue"]?.also { usedEncryptedContent += "fuzzyDateValue" },
						encryptedEntity.fuzzyDateValue,
						decryptedJsonStrictness,
					),
				binaryValue =
					encryptedContentDecoder.decodeDecrypted(
						ByteArraySerializer.nullable,
						decryptedContent["binaryValue"]?.also { usedEncryptedContent += "binaryValue" },
						encryptedEntity.binaryValue,
						decryptedJsonStrictness,
					),
				documentId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["documentId"]?.also { usedEncryptedContent += "documentId" },
						encryptedEntity.documentId,
						decryptedJsonStrictness,
					),
				measureValue =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["measureValue"]?.also { usedEncryptedContent += "measureValue" },
						encryptedEntity.measureValue,
						decryptedJsonStrictness,
					),
				medicationValue =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["medicationValue"]?.also { usedEncryptedContent += "medicationValue" },
						encryptedEntity.medicationValue,
						decryptedJsonStrictness,
					),
				timeSeries =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["timeSeries"]?.also { usedEncryptedContent += "timeSeries" },
						encryptedEntity.timeSeries,
						decryptedJsonStrictness,
					),
				compoundValue =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["compoundValue"]?.also { usedEncryptedContent += "compoundValue" },
						encryptedEntity.compoundValue?.let {
							it.map { x0 ->
								ServiceDecryptor.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = x0,
									patchDecryptedSelfJson = patchDecryptedSelfJson,
									decryptedJsonStrictness = decryptedJsonStrictness,
									encryptedContentDecoder = encryptedContentDecoder,
									cryptoService = cryptoService,
								)
							}
						},
						decryptedJsonStrictness,
					),
				ratio =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["ratio"]?.also { usedEncryptedContent += "ratio" },
						encryptedEntity.ratio,
						decryptedJsonStrictness,
					),
				range =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["range"]?.also { usedEncryptedContent += "range" },
						encryptedEntity.range,
						decryptedJsonStrictness,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Content encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
