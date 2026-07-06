// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.DecryptedReceipt
import com.icure.cardinal.sdk.model.EncryptedReceipt
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object ReceiptEncryptorFactory : EntityEncryptorFactory<EncryptedReceipt, DecryptedReceipt> {
	override val empty: EntityEncryptor<EncryptedReceipt, DecryptedReceipt> =
		ReceiptEncryptor(
			created = false,
			modified = false,
			author = false,
			responsible = false,
			tags = false,
			codes = false,
			attachmentIds = false,
			attachmentInfos = false,
			deletedAttachments = false,
			references = false,
			documentId = false,
			category = false,
			subCategory = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedReceipt, DecryptedReceipt> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return ReceiptEncryptor(
			created = "created" in manifest.fieldsToEncrypt,
			modified = "modified" in manifest.fieldsToEncrypt,
			author = "author" in manifest.fieldsToEncrypt,
			responsible = "responsible" in manifest.fieldsToEncrypt,
			tags = "tags" in manifest.fieldsToEncrypt,
			codes = "codes" in manifest.fieldsToEncrypt,
			attachmentIds = "attachmentIds" in manifest.fieldsToEncrypt,
			attachmentInfos = "attachmentInfos" in manifest.fieldsToEncrypt,
			deletedAttachments = "deletedAttachments" in manifest.fieldsToEncrypt,
			references = "references" in manifest.fieldsToEncrypt,
			documentId = "documentId" in manifest.fieldsToEncrypt,
			category = "category" in manifest.fieldsToEncrypt,
			subCategory = "subCategory" in manifest.fieldsToEncrypt,
		)
	}
}

private class ReceiptEncryptor(
	private val created: Boolean,
	private val modified: Boolean,
	private val author: Boolean,
	private val responsible: Boolean,
	private val tags: Boolean,
	private val codes: Boolean,
	private val attachmentIds: Boolean,
	private val attachmentInfos: Boolean,
	private val deletedAttachments: Boolean,
	private val references: Boolean,
	private val documentId: Boolean,
	private val category: Boolean,
	private val subCategory: Boolean,
) : AbstractEntityEncryptor<EncryptedReceipt, DecryptedReceipt>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedReceipt,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedReceipt {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (created) dataToEncrypt["created"] = encodingJson.encodeToJsonElement(clearEntity.created)
		if (modified) dataToEncrypt["modified"] = encodingJson.encodeToJsonElement(clearEntity.modified)
		if (author) dataToEncrypt["author"] = encodingJson.encodeToJsonElement(clearEntity.author)
		if (responsible) dataToEncrypt["responsible"] = encodingJson.encodeToJsonElement(clearEntity.responsible)
		if (tags) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (codes) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (attachmentIds) dataToEncrypt["attachmentIds"] = encodingJson.encodeToJsonElement(clearEntity.attachmentIds)
		if (attachmentInfos) dataToEncrypt["attachmentInfos"] = encodingJson.encodeToJsonElement(clearEntity.attachmentInfos)
		if (deletedAttachments) dataToEncrypt["deletedAttachments"] = encodingJson.encodeToJsonElement(clearEntity.deletedAttachments)
		if (references) dataToEncrypt["references"] = encodingJson.encodeToJsonElement(clearEntity.references)
		if (documentId) dataToEncrypt["documentId"] = encodingJson.encodeToJsonElement(clearEntity.documentId)
		if (category) dataToEncrypt["category"] = encodingJson.encodeToJsonElement(clearEntity.category)
		if (subCategory) dataToEncrypt["subCategory"] = encodingJson.encodeToJsonElement(clearEntity.subCategory)
		return EncryptedReceipt(
			id = clearEntity.id,
			rev = clearEntity.rev,
			created = if (created) null else clearEntity.created,
			modified = if (modified) null else clearEntity.modified,
			author = if (author) null else clearEntity.author,
			responsible = if (responsible) null else clearEntity.responsible,
			tags = if (tags) emptySet() else clearEntity.tags,
			codes = if (codes) emptySet() else clearEntity.codes,
			deletionDate = clearEntity.deletionDate,
			attachmentIds = if (attachmentIds) emptyMap() else clearEntity.attachmentIds,
			attachmentInfos = if (attachmentInfos) emptyMap() else clearEntity.attachmentInfos,
			deletedAttachments = if (deletedAttachments) emptyList() else clearEntity.deletedAttachments,
			references = if (references) emptyList() else clearEntity.references,
			documentId = if (documentId) null else clearEntity.documentId,
			category = if (category) null else clearEntity.category,
			subCategory = if (subCategory) null else clearEntity.subCategory,
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			securityMetadata = clearEntity.securityMetadata,
		)
	}
}
