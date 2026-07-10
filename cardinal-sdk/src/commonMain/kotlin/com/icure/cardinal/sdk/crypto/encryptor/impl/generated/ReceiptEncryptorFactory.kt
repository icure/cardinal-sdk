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
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

@InternalIcureApi
internal object ReceiptEncryptorFactory : EntityEncryptorFactory<EncryptedReceipt, DecryptedReceipt> {
	override val empty: EntityEncryptor<EncryptedReceipt, DecryptedReceipt> =
		object :
			EntityEncryptor<EncryptedReceipt, DecryptedReceipt> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedReceipt,
			): EncryptedReceipt =
				EncryptedReceipt(
					id = clearEntity.id,
					rev = clearEntity.rev,
					created = clearEntity.created,
					modified = clearEntity.modified,
					author = clearEntity.author,
					responsible = clearEntity.responsible,
					tags = clearEntity.tags,
					codes = clearEntity.codes,
					deletionDate = clearEntity.deletionDate,
					attachmentIds = clearEntity.attachmentIds,
					attachmentInfos = clearEntity.attachmentInfos,
					deletedAttachments = clearEntity.deletedAttachments,
					references = clearEntity.references,
					documentId = clearEntity.documentId,
					category = clearEntity.category,
					subCategory = clearEntity.subCategory,
					secretForeignKeys = clearEntity.secretForeignKeys,
					cryptedForeignKeys = clearEntity.cryptedForeignKeys,
					delegations = clearEntity.delegations,
					encryptionKeys = clearEntity.encryptionKeys,
					encryptedSelf = null,
					securityMetadata = clearEntity.securityMetadata,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedReceipt, DecryptedReceipt> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return ReceiptEncryptor(
			created_e = "created" in manifest.fieldsToEncrypt,
			modified_e = "modified" in manifest.fieldsToEncrypt,
			author_e = "author" in manifest.fieldsToEncrypt,
			responsible_e = "responsible" in manifest.fieldsToEncrypt,
			tags_e = "tags" in manifest.fieldsToEncrypt,
			codes_e = "codes" in manifest.fieldsToEncrypt,
			attachmentIds_e = "attachmentIds" in manifest.fieldsToEncrypt,
			attachmentInfos_e = "attachmentInfos" in manifest.fieldsToEncrypt,
			deletedAttachments_e = "deletedAttachments" in manifest.fieldsToEncrypt,
			references_e = "references" in manifest.fieldsToEncrypt,
			documentId_e = "documentId" in manifest.fieldsToEncrypt,
			category_e = "category" in manifest.fieldsToEncrypt,
			subCategory_e = "subCategory" in manifest.fieldsToEncrypt,
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class ReceiptEncryptor(
	private val created_e: Boolean,
	private val modified_e: Boolean,
	private val author_e: Boolean,
	private val responsible_e: Boolean,
	private val tags_e: Boolean,
	private val codes_e: Boolean,
	private val attachmentIds_e: Boolean,
	private val attachmentInfos_e: Boolean,
	private val deletedAttachments_e: Boolean,
	private val references_e: Boolean,
	private val documentId_e: Boolean,
	private val category_e: Boolean,
	private val subCategory_e: Boolean,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedReceipt, DecryptedReceipt>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedReceipt,
	): EncryptedReceipt {
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
		if (attachmentIds_e && clearEntity.attachmentIds.isNotEmpty()) {
			dataToEncrypt["attachmentIds"] =
				encodingJson.encodeToJsonElement(
					clearEntity.attachmentIds,
				)
		}
		if (attachmentInfos_e && clearEntity.attachmentInfos.isNotEmpty()) {
			dataToEncrypt["attachmentInfos"] =
				encodingJson.encodeToJsonElement(
					clearEntity.attachmentInfos,
				)
		}
		if (deletedAttachments_e && clearEntity.deletedAttachments.isNotEmpty()) {
			dataToEncrypt["deletedAttachments"] =
				encodingJson.encodeToJsonElement(
					clearEntity.deletedAttachments,
				)
		}
		if (references_e && clearEntity.references.isNotEmpty()) {
			dataToEncrypt["references"] =
				encodingJson.encodeToJsonElement(
					clearEntity.references,
				)
		}
		if (documentId_e && clearEntity.documentId != null) dataToEncrypt["documentId"] = encodingJson.encodeToJsonElement(clearEntity.documentId)
		if (category_e && clearEntity.category != null) dataToEncrypt["category"] = encodingJson.encodeToJsonElement(clearEntity.category)
		if (subCategory_e && clearEntity.subCategory != null) {
			dataToEncrypt["subCategory"] =
				encodingJson.encodeToJsonElement(
					clearEntity.subCategory,
				)
		}
		return EncryptedReceipt(
			id = clearEntity.id,
			rev = clearEntity.rev,
			created = if (created_e) null else clearEntity.created,
			modified = if (modified_e) null else clearEntity.modified,
			author = if (author_e) null else clearEntity.author,
			responsible = if (responsible_e) null else clearEntity.responsible,
			tags = if (tags_e) emptySet() else clearEntity.tags,
			codes = if (codes_e) emptySet() else clearEntity.codes,
			deletionDate = clearEntity.deletionDate,
			attachmentIds = if (attachmentIds_e) emptyMap() else clearEntity.attachmentIds,
			attachmentInfos = if (attachmentInfos_e) emptyMap() else clearEntity.attachmentInfos,
			deletedAttachments = if (deletedAttachments_e) emptyList() else clearEntity.deletedAttachments,
			references = if (references_e) emptyList() else clearEntity.references,
			documentId = if (documentId_e) null else clearEntity.documentId,
			category = if (category_e) null else clearEntity.category,
			subCategory = if (subCategory_e) null else clearEntity.subCategory,
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
			securityMetadata = clearEntity.securityMetadata,
		)
	}
}
