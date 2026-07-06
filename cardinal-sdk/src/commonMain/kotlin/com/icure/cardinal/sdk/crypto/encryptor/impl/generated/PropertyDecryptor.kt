// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.DecryptedProperty
import com.icure.cardinal.sdk.model.EncryptedProperty
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object PropertyDecryptor : AbstractEntityDecryptor<EncryptedProperty, DecryptedProperty>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedProperty,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedProperty {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedProperty(
				id = encryptedEntity.id,
				rev = encryptedEntity.rev,
				deletionDate = encryptedEntity.deletionDate,
				type =
					decryptedContent["type"].let {
						if (it != null) {
							usedEncryptedContent += "type"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.type
						}
					},
				typedValue =
					decryptedContent["typedValue"].let {
						if (it != null) {
							usedEncryptedContent += "typedValue"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.typedValue?.let {
								TypedValueDecryptor.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = it,
									patchDecryptedSelfJson = patchDecryptedSelfJson,
									ignoreUnknownDecryptedFields = ignoreUnknownDecryptedFields,
									encryptedContentDecoder = encryptedContentDecoder,
									cryptoService = cryptoService,
								)
							}
						}
					},
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Property encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
