// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.model.embed.EncryptedAddress
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object AddressDecryptor : AbstractEntityDecryptor<EncryptedAddress, DecryptedAddress>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedAddress,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
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
				identifier =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["identifier"]?.also { usedEncryptedContent += "identifier" },
						encryptedEntity.identifier,
						decryptedJsonStrictness,
					),
				addressType =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["addressType"]?.also { usedEncryptedContent += "addressType" },
						encryptedEntity.addressType,
						decryptedJsonStrictness,
					),
				descr =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["descr"]?.also { usedEncryptedContent += "descr" },
						encryptedEntity.descr,
						decryptedJsonStrictness,
					),
				street =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["street"]?.also { usedEncryptedContent += "street" },
						encryptedEntity.street,
						decryptedJsonStrictness,
					),
				houseNumber =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["houseNumber"]?.also { usedEncryptedContent += "houseNumber" },
						encryptedEntity.houseNumber,
						decryptedJsonStrictness,
					),
				postboxNumber =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["postboxNumber"]?.also { usedEncryptedContent += "postboxNumber" },
						encryptedEntity.postboxNumber,
						decryptedJsonStrictness,
					),
				postalCode =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["postalCode"]?.also { usedEncryptedContent += "postalCode" },
						encryptedEntity.postalCode,
						decryptedJsonStrictness,
					),
				city =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["city"]?.also { usedEncryptedContent += "city" },
						encryptedEntity.city,
						decryptedJsonStrictness,
					),
				state =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["state"]?.also { usedEncryptedContent += "state" },
						encryptedEntity.state,
						decryptedJsonStrictness,
					),
				country =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["country"]?.also { usedEncryptedContent += "country" },
						encryptedEntity.country,
						decryptedJsonStrictness,
					),
				note =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["note"]?.also { usedEncryptedContent += "note" },
						encryptedEntity.note,
						decryptedJsonStrictness,
					),
				notes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["notes"]?.also { usedEncryptedContent += "notes" },
						encryptedEntity.notes.map { x0 ->
							AnnotationDecryptor.decrypt(
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
				telecoms =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["telecoms"]?.also { usedEncryptedContent += "telecoms" },
						encryptedEntity.telecoms.map { x0 ->
							TelecomDecryptor.decrypt(
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
				encryptedSelf = encryptedEntity.encryptedSelf,
				extensions = encryptedEntity.extensions,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Address encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
