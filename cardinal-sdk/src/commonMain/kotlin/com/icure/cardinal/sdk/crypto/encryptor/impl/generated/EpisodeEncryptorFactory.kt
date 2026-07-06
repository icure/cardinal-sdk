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
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object EpisodeEncryptorFactory : EntityEncryptorFactory<EncryptedEpisode, DecryptedEpisode> {
	override val empty: EntityEncryptor<EncryptedEpisode, DecryptedEpisode> =
		EpisodeEncryptor(
			name = false,
			comment = false,
			startDate = false,
			endDate = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedEpisode, DecryptedEpisode> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return EpisodeEncryptor(
			name = "name" in manifest.fieldsToEncrypt,
			comment = "comment" in manifest.fieldsToEncrypt,
			startDate = "startDate" in manifest.fieldsToEncrypt,
			endDate = "endDate" in manifest.fieldsToEncrypt,
		)
	}
}

private class EpisodeEncryptor(
	private val name: Boolean,
	private val comment: Boolean,
	private val startDate: Boolean,
	private val endDate: Boolean,
) : AbstractEntityEncryptor<EncryptedEpisode, DecryptedEpisode>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedEpisode,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedEpisode {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (name) dataToEncrypt["name"] = encodingJson.encodeToJsonElement(clearEntity.name)
		if (comment) dataToEncrypt["comment"] = encodingJson.encodeToJsonElement(clearEntity.comment)
		if (startDate) dataToEncrypt["startDate"] = encodingJson.encodeToJsonElement(clearEntity.startDate)
		if (endDate) dataToEncrypt["endDate"] = encodingJson.encodeToJsonElement(clearEntity.endDate)
		return EncryptedEpisode(
			id = clearEntity.id,
			name = if (name) null else clearEntity.name,
			comment = if (comment) null else clearEntity.comment,
			startDate = if (startDate) null else clearEntity.startDate,
			endDate = if (endDate) null else clearEntity.endDate,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			extensions = clearEntity.extensions,
		)
	}
}
