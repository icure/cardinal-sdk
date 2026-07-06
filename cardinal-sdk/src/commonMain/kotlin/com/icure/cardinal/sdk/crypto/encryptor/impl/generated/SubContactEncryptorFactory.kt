// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.embed.DecryptedSubContact
import com.icure.cardinal.sdk.model.embed.EncryptedSubContact
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object SubContactEncryptorFactory :
	EntityEncryptorFactory<EncryptedSubContact, DecryptedSubContact> {
	override val empty: EntityEncryptor<EncryptedSubContact, DecryptedSubContact> =
		SubContactEncryptor(
			created = false,
			modified = false,
			author = false,
			responsible = false,
			tags = false,
			codes = false,
			descr = false,
			protocol = false,
			formId = false,
			planOfActionId = false,
			healthElementId = false,
			services = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedSubContact, DecryptedSubContact> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return SubContactEncryptor(
			created = "created" in manifest.fieldsToEncrypt,
			modified = "modified" in manifest.fieldsToEncrypt,
			author = "author" in manifest.fieldsToEncrypt,
			responsible = "responsible" in manifest.fieldsToEncrypt,
			tags = "tags" in manifest.fieldsToEncrypt,
			codes = "codes" in manifest.fieldsToEncrypt,
			descr = "descr" in manifest.fieldsToEncrypt,
			protocol = "protocol" in manifest.fieldsToEncrypt,
			formId = "formId" in manifest.fieldsToEncrypt,
			planOfActionId = "planOfActionId" in manifest.fieldsToEncrypt,
			healthElementId = "healthElementId" in manifest.fieldsToEncrypt,
			services = "services" in manifest.fieldsToEncrypt,
		)
	}
}

private class SubContactEncryptor(
	private val created: Boolean,
	private val modified: Boolean,
	private val author: Boolean,
	private val responsible: Boolean,
	private val tags: Boolean,
	private val codes: Boolean,
	private val descr: Boolean,
	private val protocol: Boolean,
	private val formId: Boolean,
	private val planOfActionId: Boolean,
	private val healthElementId: Boolean,
	private val services: Boolean,
) : AbstractEntityEncryptor<EncryptedSubContact, DecryptedSubContact>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedSubContact,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedSubContact {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (created) dataToEncrypt["created"] = encodingJson.encodeToJsonElement(clearEntity.created)
		if (modified) dataToEncrypt["modified"] = encodingJson.encodeToJsonElement(clearEntity.modified)
		if (author) dataToEncrypt["author"] = encodingJson.encodeToJsonElement(clearEntity.author)
		if (responsible) dataToEncrypt["responsible"] = encodingJson.encodeToJsonElement(clearEntity.responsible)
		if (tags) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (codes) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (descr) dataToEncrypt["descr"] = encodingJson.encodeToJsonElement(clearEntity.descr)
		if (protocol) dataToEncrypt["protocol"] = encodingJson.encodeToJsonElement(clearEntity.protocol)
		if (formId) dataToEncrypt["formId"] = encodingJson.encodeToJsonElement(clearEntity.formId)
		if (planOfActionId) dataToEncrypt["planOfActionId"] = encodingJson.encodeToJsonElement(clearEntity.planOfActionId)
		if (healthElementId) dataToEncrypt["healthElementId"] = encodingJson.encodeToJsonElement(clearEntity.healthElementId)
		if (services) dataToEncrypt["services"] = encodingJson.encodeToJsonElement(clearEntity.services)
		return EncryptedSubContact(
			id = clearEntity.id,
			created = if (created) null else clearEntity.created,
			modified = if (modified) null else clearEntity.modified,
			author = if (author) null else clearEntity.author,
			responsible = if (responsible) null else clearEntity.responsible,
			tags = if (tags) emptySet() else clearEntity.tags,
			codes = if (codes) emptySet() else clearEntity.codes,
			descr = if (descr) null else clearEntity.descr,
			protocol = if (protocol) null else clearEntity.protocol,
			formId = if (formId) null else clearEntity.formId,
			planOfActionId = if (planOfActionId) null else clearEntity.planOfActionId,
			healthElementId = if (healthElementId) null else clearEntity.healthElementId,
			services = if (services) emptyList() else clearEntity.services,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			extensions = clearEntity.extensions,
		)
	}
}
