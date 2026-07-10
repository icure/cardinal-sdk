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
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

@InternalIcureApi
internal object SubContactEncryptorFactory :
	EntityEncryptorFactory<EncryptedSubContact, DecryptedSubContact> {
	override val empty: EntityEncryptor<EncryptedSubContact, DecryptedSubContact> =
		SubContactEncryptor(
			created_e = false,
			modified_e = false,
			author_e = false,
			responsible_e = false,
			tags_e = false,
			codes_e = false,
			descr_e = false,
			protocol_e = false,
			formId_e = false,
			planOfActionId_e = false,
			healthElementId_e = false,
			services_e = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedSubContact, DecryptedSubContact> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return SubContactEncryptor(
			created_e = "created" in manifest.fieldsToEncrypt,
			modified_e = "modified" in manifest.fieldsToEncrypt,
			author_e = "author" in manifest.fieldsToEncrypt,
			responsible_e = "responsible" in manifest.fieldsToEncrypt,
			tags_e = "tags" in manifest.fieldsToEncrypt,
			codes_e = "codes" in manifest.fieldsToEncrypt,
			descr_e = "descr" in manifest.fieldsToEncrypt,
			protocol_e = "protocol" in manifest.fieldsToEncrypt,
			formId_e = "formId" in manifest.fieldsToEncrypt,
			planOfActionId_e = "planOfActionId" in manifest.fieldsToEncrypt,
			healthElementId_e = "healthElementId" in manifest.fieldsToEncrypt,
			services_e = "services" in manifest.fieldsToEncrypt,
		)
	}
}

@InternalIcureApi
private class SubContactEncryptor(
	private val created_e: Boolean,
	private val modified_e: Boolean,
	private val author_e: Boolean,
	private val responsible_e: Boolean,
	private val tags_e: Boolean,
	private val codes_e: Boolean,
	private val descr_e: Boolean,
	private val protocol_e: Boolean,
	private val formId_e: Boolean,
	private val planOfActionId_e: Boolean,
	private val healthElementId_e: Boolean,
	private val services_e: Boolean,
) : AbstractEntityEncryptor<EncryptedSubContact, DecryptedSubContact>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedSubContact,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedSubContact {
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
		if (descr_e && clearEntity.descr != null) dataToEncrypt["descr"] = encodingJson.encodeToJsonElement(clearEntity.descr)
		if (protocol_e && clearEntity.protocol != null) dataToEncrypt["protocol"] = encodingJson.encodeToJsonElement(clearEntity.protocol)
		if (formId_e && clearEntity.formId != null) dataToEncrypt["formId"] = encodingJson.encodeToJsonElement(clearEntity.formId)
		if (planOfActionId_e && clearEntity.planOfActionId != null) {
			dataToEncrypt["planOfActionId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.planOfActionId,
				)
		}
		if (healthElementId_e && clearEntity.healthElementId != null) {
			dataToEncrypt["healthElementId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.healthElementId,
				)
		}
		if (services_e && clearEntity.services.isNotEmpty()) dataToEncrypt["services"] = encodingJson.encodeToJsonElement(clearEntity.services)
		return EncryptedSubContact(
			id = clearEntity.id,
			created = if (created_e) null else clearEntity.created,
			modified = if (modified_e) null else clearEntity.modified,
			author = if (author_e) null else clearEntity.author,
			responsible = if (responsible_e) null else clearEntity.responsible,
			tags = if (tags_e) emptySet() else clearEntity.tags,
			codes = if (codes_e) emptySet() else clearEntity.codes,
			descr = if (descr_e) null else clearEntity.descr,
			protocol = if (protocol_e) null else clearEntity.protocol,
			formId = if (formId_e) null else clearEntity.formId,
			planOfActionId = if (planOfActionId_e) null else clearEntity.planOfActionId,
			healthElementId = if (healthElementId_e) null else clearEntity.healthElementId,
			services = if (services_e) emptyList() else clearEntity.services,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			extensions = clearEntity.extensions,
		)
	}
}
