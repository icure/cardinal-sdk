// This file is auto-generated
@file:Suppress("ktlint:standard:max-line-length")

package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.encryptExtension
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
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress

@InternalIcureApi
internal object SubContactEncryptorFactory : EntityEncryptorFactory<EncryptedSubContact, DecryptedSubContact> {
	override val empty: EntityEncryptor<EncryptedSubContact, DecryptedSubContact> =
		object : EntityEncryptor<EncryptedSubContact, DecryptedSubContact> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedSubContact,
			): EncryptedSubContact =
				EncryptedSubContact(
					id = clearEntity.id,
					created = clearEntity.created,
					modified = clearEntity.modified,
					author = clearEntity.author,
					responsible = clearEntity.responsible,
					medicalLocationId = clearEntity.medicalLocationId,
					tags = clearEntity.tags,
					codes = clearEntity.codes,
					endOfLife = clearEntity.endOfLife,
					descr = clearEntity.descr,
					protocol = clearEntity.protocol,
					status = clearEntity.status,
					formId = clearEntity.formId,
					planOfActionId = clearEntity.planOfActionId,
					healthElementId = clearEntity.healthElementId,
					classificationId = clearEntity.classificationId,
					services = clearEntity.services,
					encryptedSelf = null,
					extensions = clearEntity.extensions,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedSubContact, DecryptedSubContact> {
		val manifest = encryptorsFactoryContext.getManifest(entityManifestName)
		val extensionsEncryptor =
			manifest.currentExtensionsManifest?.let {
				encryptorsFactoryContext.getExtensionEncryptorsProvider(
					extensionsManifestName = it,
					encryptedClass = EncryptedSubContact::class,
					decryptedClass = DecryptedSubContact::class,
				)
			}
		return SubContactEncryptor(
			created_e = "created" in manifest.fieldsToEncrypt,
			modified_e = "modified" in manifest.fieldsToEncrypt,
			author_e = "author" in manifest.fieldsToEncrypt,
			responsible_e = "responsible" in manifest.fieldsToEncrypt,
			medicalLocationId_e = "medicalLocationId" in manifest.fieldsToEncrypt,
			tags_e = "tags" in manifest.fieldsToEncrypt,
			codes_e = "codes" in manifest.fieldsToEncrypt,
			endOfLife_e = "endOfLife" in manifest.fieldsToEncrypt,
			descr_e = "descr" in manifest.fieldsToEncrypt,
			protocol_e = "protocol" in manifest.fieldsToEncrypt,
			status_e = "status" in manifest.fieldsToEncrypt,
			formId_e = "formId" in manifest.fieldsToEncrypt,
			planOfActionId_e = "planOfActionId" in manifest.fieldsToEncrypt,
			healthElementId_e = "healthElementId" in manifest.fieldsToEncrypt,
			classificationId_e = "classificationId" in manifest.fieldsToEncrypt,
			services_e = "services" in manifest.fieldsToEncrypt,
			extensionsEncryptor = extensionsEncryptor,
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class SubContactEncryptor(
	private val created_e: Boolean,
	private val modified_e: Boolean,
	private val author_e: Boolean,
	private val responsible_e: Boolean,
	private val medicalLocationId_e: Boolean,
	private val tags_e: Boolean,
	private val codes_e: Boolean,
	private val endOfLife_e: Boolean,
	private val descr_e: Boolean,
	private val protocol_e: Boolean,
	private val status_e: Boolean,
	private val formId_e: Boolean,
	private val planOfActionId_e: Boolean,
	private val healthElementId_e: Boolean,
	private val classificationId_e: Boolean,
	private val services_e: Boolean,
	private val extensionsEncryptor: Lazy<ExtensionsEncryptors>?,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedSubContact, DecryptedSubContact>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedSubContact,
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
		if (medicalLocationId_e && clearEntity.medicalLocationId != null) {
			dataToEncrypt["medicalLocationId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.medicalLocationId,
				)
		}
		if (tags_e && clearEntity.tags.isNotEmpty()) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (codes_e && clearEntity.codes.isNotEmpty()) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (endOfLife_e && clearEntity.endOfLife != null) dataToEncrypt["endOfLife"] = encodingJson.encodeToJsonElement(clearEntity.endOfLife)
		if (descr_e && clearEntity.descr != null) dataToEncrypt["descr"] = encodingJson.encodeToJsonElement(clearEntity.descr)
		if (protocol_e && clearEntity.protocol != null) dataToEncrypt["protocol"] = encodingJson.encodeToJsonElement(clearEntity.protocol)
		if (status_e && clearEntity.status != null) dataToEncrypt["status"] = encodingJson.encodeToJsonElement(clearEntity.status)
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
		if (classificationId_e && clearEntity.classificationId != null) {
			dataToEncrypt["classificationId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.classificationId,
				)
		}
		if (services_e && clearEntity.services.isNotEmpty()) dataToEncrypt["services"] = encodingJson.encodeToJsonElement(clearEntity.services)
		return EncryptedSubContact(
			id = clearEntity.id,
			created = if (created_e) null else clearEntity.created,
			modified = if (modified_e) null else clearEntity.modified,
			author = if (author_e) null else clearEntity.author,
			responsible = if (responsible_e) null else clearEntity.responsible,
			medicalLocationId = if (medicalLocationId_e) null else clearEntity.medicalLocationId,
			tags = if (tags_e) emptySet() else clearEntity.tags,
			codes = if (codes_e) emptySet() else clearEntity.codes,
			endOfLife = if (endOfLife_e) null else clearEntity.endOfLife,
			descr = if (descr_e) null else clearEntity.descr,
			protocol = if (protocol_e) null else clearEntity.protocol,
			status = if (status_e) null else clearEntity.status,
			formId = if (formId_e) null else clearEntity.formId,
			planOfActionId = if (planOfActionId_e) null else clearEntity.planOfActionId,
			healthElementId = if (healthElementId_e) null else clearEntity.healthElementId,
			classificationId = if (classificationId_e) null else clearEntity.classificationId,
			services = if (services_e) emptyList() else clearEntity.services,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
			extensions = extensionsEncryptor?.value?.encryptExtension(encryptionKey, clearEntity.extensions) ?: clearEntity.extensions,
		)
	}
}
