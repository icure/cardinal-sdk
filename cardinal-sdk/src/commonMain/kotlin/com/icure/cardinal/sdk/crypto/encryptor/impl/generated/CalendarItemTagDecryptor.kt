// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedCalendarItemTag
import com.icure.cardinal.sdk.model.embed.EncryptedCalendarItemTag
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object CalendarItemTagDecryptor :
	AbstractEntityDecryptor<EncryptedCalendarItemTag, DecryptedCalendarItemTag>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedCalendarItemTag,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedCalendarItemTag {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedCalendarItemTag(
				code =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["code"]?.also { usedEncryptedContent += "code" },
						encryptedEntity.code,
						decryptedJsonStrictness,
					),
				date =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["date"]?.also { usedEncryptedContent += "date" },
						encryptedEntity.date,
						decryptedJsonStrictness,
					),
				userId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["userId"]?.also { usedEncryptedContent += "userId" },
						encryptedEntity.userId,
						decryptedJsonStrictness,
					),
				userName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["userName"]?.also { usedEncryptedContent += "userName" },
						encryptedEntity.userName,
						decryptedJsonStrictness,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The CalendarItemTag encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}
