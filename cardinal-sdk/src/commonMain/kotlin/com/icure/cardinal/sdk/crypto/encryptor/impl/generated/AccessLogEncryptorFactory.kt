// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.DecryptedAccessLog
import com.icure.cardinal.sdk.model.EncryptedAccessLog
import com.icure.cardinal.sdk.serialization.InstantSerializer
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object AccessLogEncryptorFactory :
	EntityEncryptorFactory<EncryptedAccessLog, DecryptedAccessLog> {
	override val empty: EntityEncryptor<EncryptedAccessLog, DecryptedAccessLog> =
		AccessLogEncryptor(
			created = false,
			modified = false,
			author = false,
			responsible = false,
			tags = false,
			codes = false,
			objectId = false,
			accessType = false,
			user = false,
			detail = false,
			date = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedAccessLog, DecryptedAccessLog> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return AccessLogEncryptor(
			created = "created" in manifest.fieldsToEncrypt,
			modified = "modified" in manifest.fieldsToEncrypt,
			author = "author" in manifest.fieldsToEncrypt,
			responsible = "responsible" in manifest.fieldsToEncrypt,
			tags = "tags" in manifest.fieldsToEncrypt,
			codes = "codes" in manifest.fieldsToEncrypt,
			objectId = "objectId" in manifest.fieldsToEncrypt,
			accessType = "accessType" in manifest.fieldsToEncrypt,
			user = "user" in manifest.fieldsToEncrypt,
			detail = "detail" in manifest.fieldsToEncrypt,
			date = "date" in manifest.fieldsToEncrypt,
		)
	}
}

private class AccessLogEncryptor(
	private val created: Boolean,
	private val modified: Boolean,
	private val author: Boolean,
	private val responsible: Boolean,
	private val tags: Boolean,
	private val codes: Boolean,
	private val objectId: Boolean,
	private val accessType: Boolean,
	private val user: Boolean,
	private val detail: Boolean,
	private val date: Boolean,
) : AbstractEntityEncryptor<EncryptedAccessLog, DecryptedAccessLog>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedAccessLog,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedAccessLog {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (created) dataToEncrypt["created"] = encodingJson.encodeToJsonElement(clearEntity.created)
		if (modified) dataToEncrypt["modified"] = encodingJson.encodeToJsonElement(clearEntity.modified)
		if (author) dataToEncrypt["author"] = encodingJson.encodeToJsonElement(clearEntity.author)
		if (responsible) dataToEncrypt["responsible"] = encodingJson.encodeToJsonElement(clearEntity.responsible)
		if (tags) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (codes) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (objectId) dataToEncrypt["objectId"] = encodingJson.encodeToJsonElement(clearEntity.objectId)
		if (accessType) dataToEncrypt["accessType"] = encodingJson.encodeToJsonElement(clearEntity.accessType)
		if (user) dataToEncrypt["user"] = encodingJson.encodeToJsonElement(clearEntity.user)
		if (detail) dataToEncrypt["detail"] = encodingJson.encodeToJsonElement(clearEntity.detail)
		if (date) dataToEncrypt["date"] = encodingJson.encodeToJsonElement(InstantSerializer.nullable, clearEntity.date)
		return EncryptedAccessLog(
			id = clearEntity.id,
			rev = clearEntity.rev,
			created = if (created) null else clearEntity.created,
			modified = if (modified) null else clearEntity.modified,
			author = if (author) null else clearEntity.author,
			responsible = if (responsible) null else clearEntity.responsible,
			tags = if (tags) emptySet() else clearEntity.tags,
			codes = if (codes) emptySet() else clearEntity.codes,
			deletionDate = clearEntity.deletionDate,
			objectId = if (objectId) null else clearEntity.objectId,
			accessType = if (accessType) null else clearEntity.accessType,
			user = if (user) null else clearEntity.user,
			detail = if (detail) null else clearEntity.detail,
			date = if (date) null else clearEntity.date,
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			securityMetadata = clearEntity.securityMetadata,
			extensions = clearEntity.extensions,
			extensionsVersion = clearEntity.extensionsVersion,
		)
	}
}
