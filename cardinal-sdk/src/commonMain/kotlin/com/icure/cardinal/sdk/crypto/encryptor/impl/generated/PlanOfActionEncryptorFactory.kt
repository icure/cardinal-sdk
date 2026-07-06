// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.EncryptableFieldConfig
import com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMembership
import com.icure.cardinal.sdk.model.embed.DecryptedPlanOfAction
import com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMembership
import com.icure.cardinal.sdk.model.embed.EncryptedPlanOfAction
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object PlanOfActionEncryptorFactory :
	EntityEncryptorFactory<EncryptedPlanOfAction, DecryptedPlanOfAction> {
	override val empty: EntityEncryptor<EncryptedPlanOfAction, DecryptedPlanOfAction> =
		PlanOfActionEncryptor(
			created = false,
			modified = false,
			author = false,
			responsible = false,
			tags = false,
			codes = false,
			prescriberId = false,
			valueDate = false,
			openingDate = false,
			closingDate = false,
			deadlineDate = false,
			name = false,
			descr = false,
			note = false,
			idOpeningContact = false,
			idClosingContact = false,
			careTeamMemberships = EncryptableFieldConfig.None(CareTeamMembershipEncryptorFactory),
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedPlanOfAction, DecryptedPlanOfAction> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return PlanOfActionEncryptor(
			created = "created" in manifest.fieldsToEncrypt,
			modified = "modified" in manifest.fieldsToEncrypt,
			author = "author" in manifest.fieldsToEncrypt,
			responsible = "responsible" in manifest.fieldsToEncrypt,
			tags = "tags" in manifest.fieldsToEncrypt,
			codes = "codes" in manifest.fieldsToEncrypt,
			prescriberId = "prescriberId" in manifest.fieldsToEncrypt,
			valueDate = "valueDate" in manifest.fieldsToEncrypt,
			openingDate = "openingDate" in manifest.fieldsToEncrypt,
			closingDate = "closingDate" in manifest.fieldsToEncrypt,
			deadlineDate = "deadlineDate" in manifest.fieldsToEncrypt,
			name = "name" in manifest.fieldsToEncrypt,
			descr = "descr" in manifest.fieldsToEncrypt,
			note = "note" in manifest.fieldsToEncrypt,
			idOpeningContact = "idOpeningContact" in manifest.fieldsToEncrypt,
			idClosingContact = "idClosingContact" in manifest.fieldsToEncrypt,
			careTeamMemberships =
				if ("careTeamMemberships" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["careTeamMemberships"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedCareTeamMembership::class,
								decryptedClass = DecryptedCareTeamMembership::class,
							),
						)
					} ?: EncryptableFieldConfig.None(CareTeamMembershipEncryptorFactory)
				},
		)
	}
}

private class PlanOfActionEncryptor(
	private val created: Boolean,
	private val modified: Boolean,
	private val author: Boolean,
	private val responsible: Boolean,
	private val tags: Boolean,
	private val codes: Boolean,
	private val prescriberId: Boolean,
	private val valueDate: Boolean,
	private val openingDate: Boolean,
	private val closingDate: Boolean,
	private val deadlineDate: Boolean,
	private val name: Boolean,
	private val descr: Boolean,
	private val note: Boolean,
	private val idOpeningContact: Boolean,
	private val idClosingContact: Boolean,
	private val careTeamMemberships: EncryptableFieldConfig<EncryptedCareTeamMembership, DecryptedCareTeamMembership>,
) : AbstractEntityEncryptor<EncryptedPlanOfAction, DecryptedPlanOfAction>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedPlanOfAction,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedPlanOfAction {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (created) dataToEncrypt["created"] = encodingJson.encodeToJsonElement(clearEntity.created)
		if (modified) dataToEncrypt["modified"] = encodingJson.encodeToJsonElement(clearEntity.modified)
		if (author) dataToEncrypt["author"] = encodingJson.encodeToJsonElement(clearEntity.author)
		if (responsible) dataToEncrypt["responsible"] = encodingJson.encodeToJsonElement(clearEntity.responsible)
		if (tags) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (codes) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (prescriberId) dataToEncrypt["prescriberId"] = encodingJson.encodeToJsonElement(clearEntity.prescriberId)
		if (valueDate) dataToEncrypt["valueDate"] = encodingJson.encodeToJsonElement(clearEntity.valueDate)
		if (openingDate) dataToEncrypt["openingDate"] = encodingJson.encodeToJsonElement(clearEntity.openingDate)
		if (closingDate) dataToEncrypt["closingDate"] = encodingJson.encodeToJsonElement(clearEntity.closingDate)
		if (deadlineDate) dataToEncrypt["deadlineDate"] = encodingJson.encodeToJsonElement(clearEntity.deadlineDate)
		if (name) dataToEncrypt["name"] = encodingJson.encodeToJsonElement(clearEntity.name)
		if (descr) dataToEncrypt["descr"] = encodingJson.encodeToJsonElement(clearEntity.descr)
		if (note) dataToEncrypt["note"] = encodingJson.encodeToJsonElement(clearEntity.note)
		if (idOpeningContact) dataToEncrypt["idOpeningContact"] = encodingJson.encodeToJsonElement(clearEntity.idOpeningContact)
		if (idClosingContact) dataToEncrypt["idClosingContact"] = encodingJson.encodeToJsonElement(clearEntity.idClosingContact)
		if (careTeamMemberships.fullEncryption) {
			dataToEncrypt["careTeamMemberships"] =
				encodingJson.encodeToJsonElement(
					clearEntity.careTeamMemberships,
				)
		}
		return EncryptedPlanOfAction(
			id = clearEntity.id,
			created = if (created) null else clearEntity.created,
			modified = if (modified) null else clearEntity.modified,
			author = if (author) null else clearEntity.author,
			responsible = if (responsible) null else clearEntity.responsible,
			tags = if (tags) emptySet() else clearEntity.tags,
			codes = if (codes) emptySet() else clearEntity.codes,
			endOfLife = clearEntity.endOfLife,
			prescriberId = if (prescriberId) null else clearEntity.prescriberId,
			valueDate = if (valueDate) null else clearEntity.valueDate,
			openingDate = if (openingDate) null else clearEntity.openingDate,
			closingDate = if (closingDate) null else clearEntity.closingDate,
			deadlineDate = if (deadlineDate) null else clearEntity.deadlineDate,
			name = if (name) null else clearEntity.name,
			descr = if (descr) null else clearEntity.descr,
			note = if (note) null else clearEntity.note,
			idOpeningContact = if (idOpeningContact) null else clearEntity.idOpeningContact,
			idClosingContact = if (idClosingContact) null else clearEntity.idClosingContact,
			careTeamMemberships =
				careTeamMemberships.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.careTeamMemberships.map { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			extensions = clearEntity.extensions,
		)
	}
}
