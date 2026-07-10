// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.embed.DecryptedEpisode
import com.icure.cardinal.sdk.model.embed.EncryptedEpisode
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
internal object EpisodeEncryptorFactory : EntityEncryptorFactory<EncryptedEpisode, DecryptedEpisode> {
	override val empty: EntityEncryptor<EncryptedEpisode, DecryptedEpisode> =
		EpisodeEncryptor(
			name_e = false,
			comment_e = false,
			startDate_e = false,
			endDate_e = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedEpisode, DecryptedEpisode> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return EpisodeEncryptor(
			name_e = "name" in manifest.fieldsToEncrypt,
			comment_e = "comment" in manifest.fieldsToEncrypt,
			startDate_e = "startDate" in manifest.fieldsToEncrypt,
			endDate_e = "endDate" in manifest.fieldsToEncrypt,
		)
	}
}

@InternalIcureApi
private class EpisodeEncryptor(
	private val name_e: Boolean,
	private val comment_e: Boolean,
	private val startDate_e: Boolean,
	private val endDate_e: Boolean,
) : AbstractEntityEncryptor<EncryptedEpisode, DecryptedEpisode>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedEpisode,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedEpisode {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (name_e && clearEntity.name != null) dataToEncrypt["name"] = encodingJson.encodeToJsonElement(clearEntity.name)
		if (comment_e && clearEntity.comment != null) dataToEncrypt["comment"] = encodingJson.encodeToJsonElement(clearEntity.comment)
		if (startDate_e && clearEntity.startDate != null) dataToEncrypt["startDate"] = encodingJson.encodeToJsonElement(clearEntity.startDate)
		if (endDate_e && clearEntity.endDate != null) dataToEncrypt["endDate"] = encodingJson.encodeToJsonElement(clearEntity.endDate)
		return EncryptedEpisode(
			id = clearEntity.id,
			name = if (name_e) null else clearEntity.name,
			comment = if (comment_e) null else clearEntity.comment,
			startDate = if (startDate_e) null else clearEntity.startDate,
			endDate = if (endDate_e) null else clearEntity.endDate,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			extensions = clearEntity.extensions,
		)
	}
}
