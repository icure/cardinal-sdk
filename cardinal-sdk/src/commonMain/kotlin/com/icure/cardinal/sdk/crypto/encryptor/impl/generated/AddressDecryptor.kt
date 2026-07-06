// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.model.embed.EncryptedAddress
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object AddressDecryptor : AbstractEntityDecryptor<EncryptedAddress, DecryptedAddress>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedAddress,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedAddress {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedAddress(
				tags =
					decryptedContent["tags"].let {
						if (it != null) {
							usedEncryptedContent += "tags"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.tags
						}
					},
				codes =
					decryptedContent["codes"].let {
						if (it != null) {
							usedEncryptedContent += "codes"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.codes
						}
					},
				identifier =
					decryptedContent["identifier"].let {
						if (it != null) {
							usedEncryptedContent += "identifier"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.identifier
						}
					},
				addressType =
					decryptedContent["addressType"].let {
						if (it != null) {
							usedEncryptedContent += "addressType"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.addressType
						}
					},
				descr =
					decryptedContent["descr"].let {
						if (it != null) {
							usedEncryptedContent += "descr"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.descr
						}
					},
				street =
					decryptedContent["street"].let {
						if (it != null) {
							usedEncryptedContent += "street"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.street
						}
					},
				houseNumber =
					decryptedContent["houseNumber"].let {
						if (it != null) {
							usedEncryptedContent += "houseNumber"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.houseNumber
						}
					},
				postboxNumber =
					decryptedContent["postboxNumber"].let {
						if (it != null) {
							usedEncryptedContent += "postboxNumber"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.postboxNumber
						}
					},
				postalCode =
					decryptedContent["postalCode"].let {
						if (it != null) {
							usedEncryptedContent += "postalCode"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.postalCode
						}
					},
				city =
					decryptedContent["city"].let {
						if (it != null) {
							usedEncryptedContent += "city"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.city
						}
					},
				state =
					decryptedContent["state"].let {
						if (it != null) {
							usedEncryptedContent += "state"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.state
						}
					},
				country =
					decryptedContent["country"].let {
						if (it != null) {
							usedEncryptedContent += "country"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.country
						}
					},
				note =
					decryptedContent["note"].let {
						if (it != null) {
							usedEncryptedContent += "note"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.note
						}
					},
				notes =
					decryptedContent["notes"].let {
						if (it != null) {
							usedEncryptedContent += "notes"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.notes.map { x0 ->
								AnnotationDecryptor.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = x0,
									patchDecryptedSelfJson = patchDecryptedSelfJson,
									ignoreUnknownDecryptedFields = ignoreUnknownDecryptedFields,
									encryptedContentDecoder = encryptedContentDecoder,
									cryptoService = cryptoService,
								)
							}
						}
					},
				telecoms =
					decryptedContent["telecoms"].let {
						if (it != null) {
							usedEncryptedContent += "telecoms"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.telecoms.map { x0 ->
								TelecomDecryptor.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = x0,
									patchDecryptedSelfJson = patchDecryptedSelfJson,
									ignoreUnknownDecryptedFields = ignoreUnknownDecryptedFields,
									encryptedContentDecoder = encryptedContentDecoder,
									cryptoService = cryptoService,
								)
							}
						}
					},
				encryptedSelf = encryptedEntity.encryptedSelf,
				extensions = encryptedEntity.extensions,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Address encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
