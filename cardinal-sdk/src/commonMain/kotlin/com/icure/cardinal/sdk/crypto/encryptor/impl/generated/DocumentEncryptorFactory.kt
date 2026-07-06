// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.model.EncryptedDocument
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object DocumentEncryptorFactory :
	EntityEncryptorFactory<EncryptedDocument, DecryptedDocument> {
	override val empty: EntityEncryptor<EncryptedDocument, DecryptedDocument> =
		DocumentEncryptor(
			created = false,
			modified = false,
			author = false,
			responsible = false,
			tags = false,
			codes = false,
			documentType = false,
			documentStatus = false,
			externalUri = false,
			name = false,
			version = false,
			openingContactId = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedDocument, DecryptedDocument> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return DocumentEncryptor(
			created = "created" in manifest.fieldsToEncrypt,
			modified = "modified" in manifest.fieldsToEncrypt,
			author = "author" in manifest.fieldsToEncrypt,
			responsible = "responsible" in manifest.fieldsToEncrypt,
			tags = "tags" in manifest.fieldsToEncrypt,
			codes = "codes" in manifest.fieldsToEncrypt,
			documentType = "documentType" in manifest.fieldsToEncrypt,
			documentStatus = "documentStatus" in manifest.fieldsToEncrypt,
			externalUri = "externalUri" in manifest.fieldsToEncrypt,
			name = "name" in manifest.fieldsToEncrypt,
			version = "version" in manifest.fieldsToEncrypt,
			openingContactId = "openingContactId" in manifest.fieldsToEncrypt,
		)
	}
}

private class DocumentEncryptor(
	private val created: Boolean,
	private val modified: Boolean,
	private val author: Boolean,
	private val responsible: Boolean,
	private val tags: Boolean,
	private val codes: Boolean,
	private val documentType: Boolean,
	private val documentStatus: Boolean,
	private val externalUri: Boolean,
	private val name: Boolean,
	private val version: Boolean,
	private val openingContactId: Boolean,
) : AbstractEntityEncryptor<EncryptedDocument, DecryptedDocument>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedDocument,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedDocument {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (created) dataToEncrypt["created"] = encodingJson.encodeToJsonElement(clearEntity.created)
		if (modified) dataToEncrypt["modified"] = encodingJson.encodeToJsonElement(clearEntity.modified)
		if (author) dataToEncrypt["author"] = encodingJson.encodeToJsonElement(clearEntity.author)
		if (responsible) dataToEncrypt["responsible"] = encodingJson.encodeToJsonElement(clearEntity.responsible)
		if (tags) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (codes) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (documentType) dataToEncrypt["documentType"] = encodingJson.encodeToJsonElement(clearEntity.documentType)
		if (documentStatus) dataToEncrypt["documentStatus"] = encodingJson.encodeToJsonElement(clearEntity.documentStatus)
		if (externalUri) dataToEncrypt["externalUri"] = encodingJson.encodeToJsonElement(clearEntity.externalUri)
		if (name) dataToEncrypt["name"] = encodingJson.encodeToJsonElement(clearEntity.name)
		if (version) dataToEncrypt["version"] = encodingJson.encodeToJsonElement(clearEntity.version)
		if (openingContactId) dataToEncrypt["openingContactId"] = encodingJson.encodeToJsonElement(clearEntity.openingContactId)
		return EncryptedDocument(
			id = clearEntity.id,
			rev = clearEntity.rev,
			created = if (created) null else clearEntity.created,
			modified = if (modified) null else clearEntity.modified,
			author = if (author) null else clearEntity.author,
			responsible = if (responsible) null else clearEntity.responsible,
			tags = if (tags) emptySet() else clearEntity.tags,
			codes = if (codes) emptySet() else clearEntity.codes,
			deletionDate = clearEntity.deletionDate,
			documentType = if (documentType) null else clearEntity.documentType,
			documentStatus = if (documentStatus) null else clearEntity.documentStatus,
			externalUri = if (externalUri) null else clearEntity.externalUri,
			name = if (name) null else clearEntity.name,
			version = if (version) null else clearEntity.version,
			size = clearEntity.size,
			hash = clearEntity.hash,
			openingContactId = if (openingContactId) null else clearEntity.openingContactId,
			attachmentId = clearEntity.attachmentId,
			objectStoreReference = clearEntity.objectStoreReference,
			mainUti = clearEntity.mainUti,
			otherUtis = clearEntity.otherUtis,
			mainAttachmentStoredDataSize = clearEntity.mainAttachmentStoredDataSize,
			extraMainAttachmentInfo = clearEntity.extraMainAttachmentInfo,
			secondaryAttachments = clearEntity.secondaryAttachments,
			deletedAttachments = clearEntity.deletedAttachments,
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
