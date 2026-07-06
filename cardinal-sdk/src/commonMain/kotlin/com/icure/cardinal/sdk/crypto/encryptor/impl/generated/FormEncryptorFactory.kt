// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.DecryptedForm
import com.icure.cardinal.sdk.model.EncryptedForm
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object FormEncryptorFactory : EntityEncryptorFactory<EncryptedForm, DecryptedForm> {
	override val empty: EntityEncryptor<EncryptedForm, DecryptedForm> =
		FormEncryptor(
			created = false,
			modified = false,
			author = false,
			responsible = false,
			tags = false,
			codes = false,
			openingDate = false,
			status = false,
			version = false,
			descr = false,
			uniqueId = false,
			formTemplateId = false,
			contactId = false,
			healthElementId = false,
			planOfActionId = false,
			parent = false,
			anchorId = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedForm, DecryptedForm> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return FormEncryptor(
			created = "created" in manifest.fieldsToEncrypt,
			modified = "modified" in manifest.fieldsToEncrypt,
			author = "author" in manifest.fieldsToEncrypt,
			responsible = "responsible" in manifest.fieldsToEncrypt,
			tags = "tags" in manifest.fieldsToEncrypt,
			codes = "codes" in manifest.fieldsToEncrypt,
			openingDate = "openingDate" in manifest.fieldsToEncrypt,
			status = "status" in manifest.fieldsToEncrypt,
			version = "version" in manifest.fieldsToEncrypt,
			descr = "descr" in manifest.fieldsToEncrypt,
			uniqueId = "uniqueId" in manifest.fieldsToEncrypt,
			formTemplateId = "formTemplateId" in manifest.fieldsToEncrypt,
			contactId = "contactId" in manifest.fieldsToEncrypt,
			healthElementId = "healthElementId" in manifest.fieldsToEncrypt,
			planOfActionId = "planOfActionId" in manifest.fieldsToEncrypt,
			parent = "parent" in manifest.fieldsToEncrypt,
			anchorId = "anchorId" in manifest.fieldsToEncrypt,
		)
	}
}

private class FormEncryptor(
	private val created: Boolean,
	private val modified: Boolean,
	private val author: Boolean,
	private val responsible: Boolean,
	private val tags: Boolean,
	private val codes: Boolean,
	private val openingDate: Boolean,
	private val status: Boolean,
	private val version: Boolean,
	private val descr: Boolean,
	private val uniqueId: Boolean,
	private val formTemplateId: Boolean,
	private val contactId: Boolean,
	private val healthElementId: Boolean,
	private val planOfActionId: Boolean,
	private val parent: Boolean,
	private val anchorId: Boolean,
) : AbstractEntityEncryptor<EncryptedForm, DecryptedForm>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedForm,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedForm {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (created) dataToEncrypt["created"] = encodingJson.encodeToJsonElement(clearEntity.created)
		if (modified) dataToEncrypt["modified"] = encodingJson.encodeToJsonElement(clearEntity.modified)
		if (author) dataToEncrypt["author"] = encodingJson.encodeToJsonElement(clearEntity.author)
		if (responsible) dataToEncrypt["responsible"] = encodingJson.encodeToJsonElement(clearEntity.responsible)
		if (tags) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (codes) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (openingDate) dataToEncrypt["openingDate"] = encodingJson.encodeToJsonElement(clearEntity.openingDate)
		if (status) dataToEncrypt["status"] = encodingJson.encodeToJsonElement(clearEntity.status)
		if (version) dataToEncrypt["version"] = encodingJson.encodeToJsonElement(clearEntity.version)
		if (descr) dataToEncrypt["descr"] = encodingJson.encodeToJsonElement(clearEntity.descr)
		if (uniqueId) dataToEncrypt["uniqueId"] = encodingJson.encodeToJsonElement(clearEntity.uniqueId)
		if (formTemplateId) dataToEncrypt["formTemplateId"] = encodingJson.encodeToJsonElement(clearEntity.formTemplateId)
		if (contactId) dataToEncrypt["contactId"] = encodingJson.encodeToJsonElement(clearEntity.contactId)
		if (healthElementId) dataToEncrypt["healthElementId"] = encodingJson.encodeToJsonElement(clearEntity.healthElementId)
		if (planOfActionId) dataToEncrypt["planOfActionId"] = encodingJson.encodeToJsonElement(clearEntity.planOfActionId)
		if (parent) dataToEncrypt["parent"] = encodingJson.encodeToJsonElement(clearEntity.parent)
		if (anchorId) dataToEncrypt["anchorId"] = encodingJson.encodeToJsonElement(clearEntity.anchorId)
		return EncryptedForm(
			id = clearEntity.id,
			rev = clearEntity.rev,
			created = if (created) null else clearEntity.created,
			modified = if (modified) null else clearEntity.modified,
			author = if (author) null else clearEntity.author,
			responsible = if (responsible) null else clearEntity.responsible,
			tags = if (tags) emptySet() else clearEntity.tags,
			codes = if (codes) emptySet() else clearEntity.codes,
			deletionDate = clearEntity.deletionDate,
			openingDate = if (openingDate) null else clearEntity.openingDate,
			status = if (status) null else clearEntity.status,
			version = if (version) null else clearEntity.version,
			descr = if (descr) null else clearEntity.descr,
			uniqueId = if (uniqueId) null else clearEntity.uniqueId,
			formTemplateId = if (formTemplateId) null else clearEntity.formTemplateId,
			contactId = if (contactId) null else clearEntity.contactId,
			healthElementId = if (healthElementId) null else clearEntity.healthElementId,
			planOfActionId = if (planOfActionId) null else clearEntity.planOfActionId,
			parent = if (parent) null else clearEntity.parent,
			anchorId = if (anchorId) null else clearEntity.anchorId,
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			securityMetadata = clearEntity.securityMetadata,
		)
	}
}
