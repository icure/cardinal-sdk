// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.encryptExtension
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.EncryptableFieldConfig
import com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMembership
import com.icure.cardinal.sdk.model.embed.DecryptedPlanOfAction
import com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMembership
import com.icure.cardinal.sdk.model.embed.EncryptedPlanOfAction
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
internal object PlanOfActionEncryptorFactory :
	EntityEncryptorFactory<EncryptedPlanOfAction, DecryptedPlanOfAction> {
	override val empty: EntityEncryptor<EncryptedPlanOfAction, DecryptedPlanOfAction> =
		object :
			EntityEncryptor<EncryptedPlanOfAction, DecryptedPlanOfAction> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedPlanOfAction,
			): EncryptedPlanOfAction =
				EncryptedPlanOfAction(
					id = clearEntity.id,
					created = clearEntity.created,
					modified = clearEntity.modified,
					author = clearEntity.author,
					responsible = clearEntity.responsible,
					tags = clearEntity.tags,
					codes = clearEntity.codes,
					endOfLife = clearEntity.endOfLife,
					prescriberId = clearEntity.prescriberId,
					valueDate = clearEntity.valueDate,
					openingDate = clearEntity.openingDate,
					closingDate = clearEntity.closingDate,
					deadlineDate = clearEntity.deadlineDate,
					name = clearEntity.name,
					descr = clearEntity.descr,
					note = clearEntity.note,
					idOpeningContact = clearEntity.idOpeningContact,
					idClosingContact = clearEntity.idClosingContact,
					careTeamMemberships =
						clearEntity.careTeamMemberships.map { x0 ->
							CareTeamMembershipEncryptorFactory.empty.encrypt(encryptionKey, x0)
						},
					encryptedSelf = null,
					extensions = clearEntity.extensions,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedPlanOfAction, DecryptedPlanOfAction> {
		val manifest = encryptorsFactoryContext.getManifest(entityManifestName)
		val extensionsEncryptor =
			manifest.currentExtensionsManifest?.let {
				encryptorsFactoryContext.getExtensionEncryptorsProvider(
					extensionsManifestName = it,
					encryptedClass = EncryptedPlanOfAction::class,
					decryptedClass = DecryptedPlanOfAction::class,
				)
			}
		return PlanOfActionEncryptor(
			created_e = "created" in manifest.fieldsToEncrypt,
			modified_e = "modified" in manifest.fieldsToEncrypt,
			author_e = "author" in manifest.fieldsToEncrypt,
			responsible_e = "responsible" in manifest.fieldsToEncrypt,
			tags_e = "tags" in manifest.fieldsToEncrypt,
			codes_e = "codes" in manifest.fieldsToEncrypt,
			prescriberId_e = "prescriberId" in manifest.fieldsToEncrypt,
			valueDate_e = "valueDate" in manifest.fieldsToEncrypt,
			openingDate_e = "openingDate" in manifest.fieldsToEncrypt,
			closingDate_e = "closingDate" in manifest.fieldsToEncrypt,
			deadlineDate_e = "deadlineDate" in manifest.fieldsToEncrypt,
			name_e = "name" in manifest.fieldsToEncrypt,
			descr_e = "descr" in manifest.fieldsToEncrypt,
			note_e = "note" in manifest.fieldsToEncrypt,
			idOpeningContact_e = "idOpeningContact" in manifest.fieldsToEncrypt,
			idClosingContact_e = "idClosingContact" in manifest.fieldsToEncrypt,
			careTeamMemberships_e =
				if ("careTeamMemberships" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["careTeamMemberships"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorsFactoryContext.getEntityEncryptorsProvider(
								entityManifestName = it,
								encryptedClass = EncryptedCareTeamMembership::class,
								decryptedClass = DecryptedCareTeamMembership::class,
							),
						)
					} ?: EncryptableFieldConfig.None(CareTeamMembershipEncryptorFactory)
				},
			extensionsEncryptor = extensionsEncryptor,
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class PlanOfActionEncryptor(
	private val created_e: Boolean,
	private val modified_e: Boolean,
	private val author_e: Boolean,
	private val responsible_e: Boolean,
	private val tags_e: Boolean,
	private val codes_e: Boolean,
	private val prescriberId_e: Boolean,
	private val valueDate_e: Boolean,
	private val openingDate_e: Boolean,
	private val closingDate_e: Boolean,
	private val deadlineDate_e: Boolean,
	private val name_e: Boolean,
	private val descr_e: Boolean,
	private val note_e: Boolean,
	private val idOpeningContact_e: Boolean,
	private val idClosingContact_e: Boolean,
	private val careTeamMemberships_e: EncryptableFieldConfig<EncryptedCareTeamMembership, DecryptedCareTeamMembership>,
	private val extensionsEncryptor: Lazy<ExtensionsEncryptors>?,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedPlanOfAction, DecryptedPlanOfAction>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedPlanOfAction,
	): EncryptedPlanOfAction {
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
		if (prescriberId_e && clearEntity.prescriberId != null) {
			dataToEncrypt["prescriberId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.prescriberId,
				)
		}
		if (valueDate_e && clearEntity.valueDate != null) dataToEncrypt["valueDate"] = encodingJson.encodeToJsonElement(clearEntity.valueDate)
		if (openingDate_e && clearEntity.openingDate != null) {
			dataToEncrypt["openingDate"] =
				encodingJson.encodeToJsonElement(
					clearEntity.openingDate,
				)
		}
		if (closingDate_e && clearEntity.closingDate != null) {
			dataToEncrypt["closingDate"] =
				encodingJson.encodeToJsonElement(
					clearEntity.closingDate,
				)
		}
		if (deadlineDate_e && clearEntity.deadlineDate != null) {
			dataToEncrypt["deadlineDate"] =
				encodingJson.encodeToJsonElement(
					clearEntity.deadlineDate,
				)
		}
		if (name_e && clearEntity.name != null) dataToEncrypt["name"] = encodingJson.encodeToJsonElement(clearEntity.name)
		if (descr_e && clearEntity.descr != null) dataToEncrypt["descr"] = encodingJson.encodeToJsonElement(clearEntity.descr)
		if (note_e && clearEntity.note != null) dataToEncrypt["note"] = encodingJson.encodeToJsonElement(clearEntity.note)
		if (idOpeningContact_e && clearEntity.idOpeningContact != null) {
			dataToEncrypt["idOpeningContact"] =
				encodingJson.encodeToJsonElement(
					clearEntity.idOpeningContact,
				)
		}
		if (idClosingContact_e && clearEntity.idClosingContact != null) {
			dataToEncrypt["idClosingContact"] =
				encodingJson.encodeToJsonElement(
					clearEntity.idClosingContact,
				)
		}
		if (careTeamMemberships_e.fullEncryption && clearEntity.careTeamMemberships.isNotEmpty()) {
			dataToEncrypt["careTeamMemberships"] =
				encodingJson.encodeToJsonElement(
					clearEntity.careTeamMemberships,
				)
		}
		return EncryptedPlanOfAction(
			id = clearEntity.id,
			created = if (created_e) null else clearEntity.created,
			modified = if (modified_e) null else clearEntity.modified,
			author = if (author_e) null else clearEntity.author,
			responsible = if (responsible_e) null else clearEntity.responsible,
			tags = if (tags_e) emptySet() else clearEntity.tags,
			codes = if (codes_e) emptySet() else clearEntity.codes,
			endOfLife = clearEntity.endOfLife,
			prescriberId = if (prescriberId_e) null else clearEntity.prescriberId,
			valueDate = if (valueDate_e) null else clearEntity.valueDate,
			openingDate = if (openingDate_e) null else clearEntity.openingDate,
			closingDate = if (closingDate_e) null else clearEntity.closingDate,
			deadlineDate = if (deadlineDate_e) null else clearEntity.deadlineDate,
			name = if (name_e) null else clearEntity.name,
			descr = if (descr_e) null else clearEntity.descr,
			note = if (note_e) null else clearEntity.note,
			idOpeningContact = if (idOpeningContact_e) null else clearEntity.idOpeningContact,
			idClosingContact = if (idClosingContact_e) null else clearEntity.idClosingContact,
			careTeamMemberships =
				careTeamMemberships_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.careTeamMemberships.map { x0 ->
							encryptor.encrypt(encryptionKey, x0)
						}
					}
				},
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
			extensions = extensionsEncryptor?.value?.encryptExtension(encryptionKey, clearEntity.extensions) ?: clearEntity.extensions,
		)
	}
}
