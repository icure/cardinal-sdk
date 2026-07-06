// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.embed.DecryptedCalendarItemTag
import com.icure.cardinal.sdk.model.embed.EncryptedCalendarItemTag
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object CalendarItemTagEncryptorFactory :
	EntityEncryptorFactory<EncryptedCalendarItemTag, DecryptedCalendarItemTag> {
	override val empty: EntityEncryptor<EncryptedCalendarItemTag, DecryptedCalendarItemTag> =
		CalendarItemTagEncryptor(
			code = false,
			date = false,
			userId = false,
			userName = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedCalendarItemTag, DecryptedCalendarItemTag> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return CalendarItemTagEncryptor(
			code = "code" in manifest.fieldsToEncrypt,
			date = "date" in manifest.fieldsToEncrypt,
			userId = "userId" in manifest.fieldsToEncrypt,
			userName = "userName" in manifest.fieldsToEncrypt,
		)
	}
}

private class CalendarItemTagEncryptor(
	private val code: Boolean,
	private val date: Boolean,
	private val userId: Boolean,
	private val userName: Boolean,
) : AbstractEntityEncryptor<EncryptedCalendarItemTag, DecryptedCalendarItemTag>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedCalendarItemTag,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedCalendarItemTag {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (code) dataToEncrypt["code"] = encodingJson.encodeToJsonElement(clearEntity.code)
		if (date) dataToEncrypt["date"] = encodingJson.encodeToJsonElement(clearEntity.date)
		if (userId) dataToEncrypt["userId"] = encodingJson.encodeToJsonElement(clearEntity.userId)
		if (userName) dataToEncrypt["userName"] = encodingJson.encodeToJsonElement(clearEntity.userName)
		return EncryptedCalendarItemTag(
			code = if (code) null else clearEntity.code,
			date = if (date) null else clearEntity.date,
			userId = if (userId) null else clearEntity.userId,
			userName = if (userName) null else clearEntity.userName,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
		)
	}
}
