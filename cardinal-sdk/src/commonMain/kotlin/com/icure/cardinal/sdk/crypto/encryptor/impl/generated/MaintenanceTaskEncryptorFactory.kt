// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.EncryptableFieldConfig
import com.icure.cardinal.sdk.model.DecryptedMaintenanceTask
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.EncryptedMaintenanceTask
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.embed.TaskStatus
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object MaintenanceTaskEncryptorFactory :
	EntityEncryptorFactory<EncryptedMaintenanceTask, DecryptedMaintenanceTask> {
	override val empty: EntityEncryptor<EncryptedMaintenanceTask, DecryptedMaintenanceTask> =
		MaintenanceTaskEncryptor(
			identifier = false,
			created = false,
			modified = false,
			author = false,
			responsible = false,
			tags = false,
			codes = false,
			taskType = false,
			properties = EncryptableFieldConfig.None(PropertyStubEncryptorFactory),
			status = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedMaintenanceTask, DecryptedMaintenanceTask> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return MaintenanceTaskEncryptor(
			identifier = "identifier" in manifest.fieldsToEncrypt,
			created = "created" in manifest.fieldsToEncrypt,
			modified = "modified" in manifest.fieldsToEncrypt,
			author = "author" in manifest.fieldsToEncrypt,
			responsible = "responsible" in manifest.fieldsToEncrypt,
			tags = "tags" in manifest.fieldsToEncrypt,
			codes = "codes" in manifest.fieldsToEncrypt,
			taskType = "taskType" in manifest.fieldsToEncrypt,
			properties =
				if ("properties" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["properties"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedPropertyStub::class,
								decryptedClass = DecryptedPropertyStub::class,
							),
						)
					} ?: EncryptableFieldConfig.None(PropertyStubEncryptorFactory)
				},
			status = "status" in manifest.fieldsToEncrypt,
		)
	}
}

private class MaintenanceTaskEncryptor(
	private val identifier: Boolean,
	private val created: Boolean,
	private val modified: Boolean,
	private val author: Boolean,
	private val responsible: Boolean,
	private val tags: Boolean,
	private val codes: Boolean,
	private val taskType: Boolean,
	private val properties: EncryptableFieldConfig<EncryptedPropertyStub, DecryptedPropertyStub>,
	private val status: Boolean,
) : AbstractEntityEncryptor<EncryptedMaintenanceTask, DecryptedMaintenanceTask>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedMaintenanceTask,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedMaintenanceTask {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (identifier) dataToEncrypt["identifier"] = encodingJson.encodeToJsonElement(clearEntity.identifier)
		if (created) dataToEncrypt["created"] = encodingJson.encodeToJsonElement(clearEntity.created)
		if (modified) dataToEncrypt["modified"] = encodingJson.encodeToJsonElement(clearEntity.modified)
		if (author) dataToEncrypt["author"] = encodingJson.encodeToJsonElement(clearEntity.author)
		if (responsible) dataToEncrypt["responsible"] = encodingJson.encodeToJsonElement(clearEntity.responsible)
		if (tags) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (codes) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (taskType) dataToEncrypt["taskType"] = encodingJson.encodeToJsonElement(clearEntity.taskType)
		if (properties.fullEncryption) dataToEncrypt["properties"] = encodingJson.encodeToJsonElement(clearEntity.properties)
		if (status) dataToEncrypt["status"] = encodingJson.encodeToJsonElement(clearEntity.status)
		return EncryptedMaintenanceTask(
			id = clearEntity.id,
			rev = clearEntity.rev,
			identifier = if (identifier) emptyList() else clearEntity.identifier,
			created = if (created) null else clearEntity.created,
			modified = if (modified) null else clearEntity.modified,
			author = if (author) null else clearEntity.author,
			responsible = if (responsible) null else clearEntity.responsible,
			tags = if (tags) emptySet() else clearEntity.tags,
			codes = if (codes) emptySet() else clearEntity.codes,
			endOfLife = clearEntity.endOfLife,
			deletionDate = clearEntity.deletionDate,
			taskType = if (taskType) null else clearEntity.taskType,
			properties =
				properties.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptySet()
					} else {
						clearEntity.properties.mapTo(mutableSetOf()) { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			status = if (status) TaskStatus.Pending else clearEntity.status,
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			securityMetadata = clearEntity.securityMetadata,
		)
	}
}
