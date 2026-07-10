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
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

@InternalIcureApi
internal object AccessLogEncryptorFactory :
	EntityEncryptorFactory<EncryptedAccessLog, DecryptedAccessLog> {
	override val empty: EntityEncryptor<EncryptedAccessLog, DecryptedAccessLog> =
		object :
			EntityEncryptor<EncryptedAccessLog, DecryptedAccessLog> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedAccessLog,
			): EncryptedAccessLog =
				EncryptedAccessLog(
					id = clearEntity.id,
					rev = clearEntity.rev,
					created = clearEntity.created,
					modified = clearEntity.modified,
					author = clearEntity.author,
					responsible = clearEntity.responsible,
					tags = clearEntity.tags,
					codes = clearEntity.codes,
					deletionDate = clearEntity.deletionDate,
					objectId = clearEntity.objectId,
					accessType = clearEntity.accessType,
					user = clearEntity.user,
					detail = clearEntity.detail,
					date = clearEntity.date,
					secretForeignKeys = clearEntity.secretForeignKeys,
					cryptedForeignKeys = clearEntity.cryptedForeignKeys,
					delegations = clearEntity.delegations,
					encryptionKeys = clearEntity.encryptionKeys,
					encryptedSelf = null,
					securityMetadata = clearEntity.securityMetadata,
					extensions = clearEntity.extensions,
					extensionsVersion = clearEntity.extensionsVersion,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedAccessLog, DecryptedAccessLog> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return AccessLogEncryptor(
			created_e = "created" in manifest.fieldsToEncrypt,
			modified_e = "modified" in manifest.fieldsToEncrypt,
			author_e = "author" in manifest.fieldsToEncrypt,
			responsible_e = "responsible" in manifest.fieldsToEncrypt,
			tags_e = "tags" in manifest.fieldsToEncrypt,
			codes_e = "codes" in manifest.fieldsToEncrypt,
			objectId_e = "objectId" in manifest.fieldsToEncrypt,
			accessType_e = "accessType" in manifest.fieldsToEncrypt,
			user_e = "user" in manifest.fieldsToEncrypt,
			detail_e = "detail" in manifest.fieldsToEncrypt,
			date_e = "date" in manifest.fieldsToEncrypt,
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class AccessLogEncryptor(
	private val created_e: Boolean,
	private val modified_e: Boolean,
	private val author_e: Boolean,
	private val responsible_e: Boolean,
	private val tags_e: Boolean,
	private val codes_e: Boolean,
	private val objectId_e: Boolean,
	private val accessType_e: Boolean,
	private val user_e: Boolean,
	private val detail_e: Boolean,
	private val date_e: Boolean,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedAccessLog, DecryptedAccessLog>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedAccessLog,
	): EncryptedAccessLog {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (created_e && clearEntity.created != null) dataToEncrypt["created"] = encodingJson.encodeToJsonElement(clearEntity.created)
		if (modified_e && clearEntity.modified != null) dataToEncrypt["modified"] = encodingJson.encodeToJsonElement(clearEntity.modified)
		if (author_e && clearEntity.author != null) dataToEncrypt["author"] = encodingJson.encodeToJsonElement(clearEntity.author)
		if (responsible_e && clearEntity.responsible != null) {
			dataToEncrypt["responsible"] =
				encodingJson.encodeToJsonElement(
					clearEntity.responsible,
				)
		}
		if (tags_e && clearEntity.tags.isNotEmpty()) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (codes_e && clearEntity.codes.isNotEmpty()) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (objectId_e && clearEntity.objectId != null) dataToEncrypt["objectId"] = encodingJson.encodeToJsonElement(clearEntity.objectId)
		if (accessType_e && clearEntity.accessType != null) dataToEncrypt["accessType"] = encodingJson.encodeToJsonElement(clearEntity.accessType)
		if (user_e && clearEntity.user != null) dataToEncrypt["user"] = encodingJson.encodeToJsonElement(clearEntity.user)
		if (detail_e && clearEntity.detail != null) dataToEncrypt["detail"] = encodingJson.encodeToJsonElement(clearEntity.detail)
		if (date_e && clearEntity.date != null) {
			dataToEncrypt["date"] =
				encodingJson.encodeToJsonElement(
					InstantSerializer.nullable,
					clearEntity.date,
				)
		}
		return EncryptedAccessLog(
			id = clearEntity.id,
			rev = clearEntity.rev,
			created = if (created_e) null else clearEntity.created,
			modified = if (modified_e) null else clearEntity.modified,
			author = if (author_e) null else clearEntity.author,
			responsible = if (responsible_e) null else clearEntity.responsible,
			tags = if (tags_e) emptySet() else clearEntity.tags,
			codes = if (codes_e) emptySet() else clearEntity.codes,
			deletionDate = clearEntity.deletionDate,
			objectId = if (objectId_e) null else clearEntity.objectId,
			accessType = if (accessType_e) null else clearEntity.accessType,
			user = if (user_e) null else clearEntity.user,
			detail = if (detail_e) null else clearEntity.detail,
			date = if (date_e) null else clearEntity.date,
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
			securityMetadata = clearEntity.securityMetadata,
			extensions = clearEntity.extensions,
			extensionsVersion = clearEntity.extensionsVersion,
		)
	}
}
