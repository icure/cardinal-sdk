// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.encryptExtension
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.DecryptedTopic
import com.icure.cardinal.sdk.model.EncryptedTopic
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

@InternalIcureApi
internal object TopicEncryptorFactory : EntityEncryptorFactory<EncryptedTopic, DecryptedTopic> {
	override val empty: EntityEncryptor<EncryptedTopic, DecryptedTopic> =
		object :
			EntityEncryptor<EncryptedTopic, DecryptedTopic> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedTopic,
			): EncryptedTopic =
				EncryptedTopic(
					id = clearEntity.id,
					rev = clearEntity.rev,
					created = clearEntity.created,
					modified = clearEntity.modified,
					healthElementId = clearEntity.healthElementId,
					contactId = clearEntity.contactId,
					description = clearEntity.description,
					codes = clearEntity.codes,
					tags = clearEntity.tags,
					author = clearEntity.author,
					responsible = clearEntity.responsible,
					deletionDate = clearEntity.deletionDate,
					activeParticipants = clearEntity.activeParticipants,
					securityMetadata = clearEntity.securityMetadata,
					secretForeignKeys = clearEntity.secretForeignKeys,
					cryptedForeignKeys = clearEntity.cryptedForeignKeys,
					delegations = clearEntity.delegations,
					encryptionKeys = clearEntity.encryptionKeys,
					encryptedSelf = null,
					linkedHealthElements = clearEntity.linkedHealthElements,
					linkedServices = clearEntity.linkedServices,
					extensions = clearEntity.extensions,
					customisedModelVersion = clearEntity.customisedModelVersion,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedTopic, DecryptedTopic> {
		val manifest = encryptorsFactoryContext.getManifest(entityManifestName)
		val extensionsEncryptor =
			manifest.currentExtensionsManifest?.let {
				encryptorsFactoryContext.getExtensionEncryptorsProvider(
					extensionsManifestName = it,
					encryptedClass = EncryptedTopic::class,
					decryptedClass = DecryptedTopic::class,
				)
			}
		return TopicEncryptor(
			created_e = "created" in manifest.fieldsToEncrypt,
			modified_e = "modified" in manifest.fieldsToEncrypt,
			healthElementId_e = "healthElementId" in manifest.fieldsToEncrypt,
			contactId_e = "contactId" in manifest.fieldsToEncrypt,
			description_e = "description" in manifest.fieldsToEncrypt,
			codes_e = "codes" in manifest.fieldsToEncrypt,
			tags_e = "tags" in manifest.fieldsToEncrypt,
			author_e = "author" in manifest.fieldsToEncrypt,
			responsible_e = "responsible" in manifest.fieldsToEncrypt,
			linkedHealthElements_e = "linkedHealthElements" in manifest.fieldsToEncrypt,
			linkedServices_e = "linkedServices" in manifest.fieldsToEncrypt,
			extensionsEncryptor = extensionsEncryptor,
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class TopicEncryptor(
	private val created_e: Boolean,
	private val modified_e: Boolean,
	private val healthElementId_e: Boolean,
	private val contactId_e: Boolean,
	private val description_e: Boolean,
	private val codes_e: Boolean,
	private val tags_e: Boolean,
	private val author_e: Boolean,
	private val responsible_e: Boolean,
	private val linkedHealthElements_e: Boolean,
	private val linkedServices_e: Boolean,
	private val extensionsEncryptor: Lazy<ExtensionsEncryptors>?,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedTopic, DecryptedTopic>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedTopic,
	): EncryptedTopic {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (created_e && clearEntity.created != null) dataToEncrypt["created"] = encodingJson.encodeToJsonElement(clearEntity.created)
		if (modified_e && clearEntity.modified != null) dataToEncrypt["modified"] = encodingJson.encodeToJsonElement(clearEntity.modified)
		if (healthElementId_e && clearEntity.healthElementId != null) {
			dataToEncrypt["healthElementId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.healthElementId,
				)
		}
		if (contactId_e && clearEntity.contactId != null) dataToEncrypt["contactId"] = encodingJson.encodeToJsonElement(clearEntity.contactId)
		if (description_e && clearEntity.description != null) {
			dataToEncrypt["description"] =
				encodingJson.encodeToJsonElement(
					clearEntity.description,
				)
		}
		if (codes_e && clearEntity.codes.isNotEmpty()) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (tags_e && clearEntity.tags.isNotEmpty()) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (author_e && clearEntity.author != null) dataToEncrypt["author"] = encodingJson.encodeToJsonElement(clearEntity.author)
		if (responsible_e && clearEntity.responsible != null) {
			dataToEncrypt["responsible"] =
				encodingJson.encodeToJsonElement(
					clearEntity.responsible,
				)
		}
		if (linkedHealthElements_e && clearEntity.linkedHealthElements.isNotEmpty()) {
			dataToEncrypt["linkedHealthElements"] =
				encodingJson.encodeToJsonElement(
					clearEntity.linkedHealthElements,
				)
		}
		if (linkedServices_e && clearEntity.linkedServices.isNotEmpty()) {
			dataToEncrypt["linkedServices"] =
				encodingJson.encodeToJsonElement(
					clearEntity.linkedServices,
				)
		}
		return EncryptedTopic(
			id = clearEntity.id,
			rev = clearEntity.rev,
			created = if (created_e) null else clearEntity.created,
			modified = if (modified_e) null else clearEntity.modified,
			healthElementId = if (healthElementId_e) null else clearEntity.healthElementId,
			contactId = if (contactId_e) null else clearEntity.contactId,
			description = if (description_e) null else clearEntity.description,
			codes = if (codes_e) emptySet() else clearEntity.codes,
			tags = if (tags_e) emptySet() else clearEntity.tags,
			author = if (author_e) null else clearEntity.author,
			responsible = if (responsible_e) null else clearEntity.responsible,
			deletionDate = clearEntity.deletionDate,
			activeParticipants = clearEntity.activeParticipants,
			securityMetadata = clearEntity.securityMetadata,
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
			linkedHealthElements = if (linkedHealthElements_e) emptySet() else clearEntity.linkedHealthElements,
			linkedServices = if (linkedServices_e) emptySet() else clearEntity.linkedServices,
			extensions = extensionsEncryptor?.value?.encryptExtension(encryptionKey, clearEntity.extensions) ?: clearEntity.extensions,
			customisedModelVersion = clearEntity.customisedModelVersion,
		)
	}
}
