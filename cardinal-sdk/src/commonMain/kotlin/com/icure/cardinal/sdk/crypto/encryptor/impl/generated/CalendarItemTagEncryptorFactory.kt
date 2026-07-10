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
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

@InternalIcureApi
internal object CalendarItemTagEncryptorFactory :
	EntityEncryptorFactory<EncryptedCalendarItemTag, DecryptedCalendarItemTag> {
	override val empty: EntityEncryptor<EncryptedCalendarItemTag, DecryptedCalendarItemTag> =
		CalendarItemTagEncryptor(
			code_e = false,
			date_e = false,
			userId_e = false,
			userName_e = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedCalendarItemTag, DecryptedCalendarItemTag> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return CalendarItemTagEncryptor(
			code_e = "code" in manifest.fieldsToEncrypt,
			date_e = "date" in manifest.fieldsToEncrypt,
			userId_e = "userId" in manifest.fieldsToEncrypt,
			userName_e = "userName" in manifest.fieldsToEncrypt,
		)
	}
}

@InternalIcureApi
private class CalendarItemTagEncryptor(
	private val code_e: Boolean,
	private val date_e: Boolean,
	private val userId_e: Boolean,
	private val userName_e: Boolean,
) : AbstractEntityEncryptor<EncryptedCalendarItemTag, DecryptedCalendarItemTag>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedCalendarItemTag,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedCalendarItemTag {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (code_e && clearEntity.code != null) dataToEncrypt["code"] = encodingJson.encodeToJsonElement(clearEntity.code)
		if (date_e && clearEntity.date != null) dataToEncrypt["date"] = encodingJson.encodeToJsonElement(clearEntity.date)
		if (userId_e && clearEntity.userId != null) dataToEncrypt["userId"] = encodingJson.encodeToJsonElement(clearEntity.userId)
		if (userName_e && clearEntity.userName != null) dataToEncrypt["userName"] = encodingJson.encodeToJsonElement(clearEntity.userName)
		return EncryptedCalendarItemTag(
			code = if (code_e) null else clearEntity.code,
			date = if (date_e) null else clearEntity.date,
			userId = if (userId_e) null else clearEntity.userId,
			userName = if (userName_e) null else clearEntity.userName,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
		)
	}
}
