// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.encryptExtension
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.EncryptableFieldConfig
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.model.embed.DecryptedAnnotation
import com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMember
import com.icure.cardinal.sdk.model.embed.DecryptedEpisode
import com.icure.cardinal.sdk.model.embed.DecryptedPlanOfAction
import com.icure.cardinal.sdk.model.embed.EncryptedAnnotation
import com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMember
import com.icure.cardinal.sdk.model.embed.EncryptedEpisode
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
internal object HealthElementEncryptorFactory :
	EntityEncryptorFactory<EncryptedHealthElement, DecryptedHealthElement> {
	override val empty: EntityEncryptor<EncryptedHealthElement, DecryptedHealthElement> =
		object :
			EntityEncryptor<EncryptedHealthElement, DecryptedHealthElement> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedHealthElement,
			): EncryptedHealthElement =
				EncryptedHealthElement(
					id = clearEntity.id,
					identifiers = clearEntity.identifiers,
					rev = clearEntity.rev,
					created = clearEntity.created,
					modified = clearEntity.modified,
					author = clearEntity.author,
					responsible = clearEntity.responsible,
					tags = clearEntity.tags,
					codes = clearEntity.codes,
					endOfLife = clearEntity.endOfLife,
					deletionDate = clearEntity.deletionDate,
					healthElementId = clearEntity.healthElementId,
					valueDate = clearEntity.valueDate,
					openingDate = clearEntity.openingDate,
					closingDate = clearEntity.closingDate,
					descr = clearEntity.descr,
					note = clearEntity.note,
					notes =
						clearEntity.notes.map { x0 ->
							AnnotationEncryptorFactory.empty.encrypt(encryptionKey, x0)
						},
					relevant = clearEntity.relevant,
					idOpeningContact = clearEntity.idOpeningContact,
					idClosingContact = clearEntity.idClosingContact,
					idService = clearEntity.idService,
					laterality = clearEntity.laterality,
					plansOfAction =
						clearEntity.plansOfAction.map { x0 ->
							PlanOfActionEncryptorFactory.empty.encrypt(encryptionKey, x0)
						},
					episodes =
						clearEntity.episodes.map { x0 ->
							EpisodeEncryptorFactory.empty.encrypt(encryptionKey, x0)
						},
					careTeam =
						clearEntity.careTeam.map { x0 ->
							CareTeamMemberEncryptorFactory.empty.encrypt(encryptionKey, x0)
						},
					secretForeignKeys = clearEntity.secretForeignKeys,
					cryptedForeignKeys = clearEntity.cryptedForeignKeys,
					delegations = clearEntity.delegations,
					encryptionKeys = clearEntity.encryptionKeys,
					encryptedSelf = null,
					securityMetadata = clearEntity.securityMetadata,
					extensions = clearEntity.extensions,
					extensionsVersion = clearEntity.extensionsVersion,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedHealthElement, DecryptedHealthElement> {
		val manifest = encryptorsFactoryContext.getManifest(entityManifestName)
		val extensionsEncryptor =
			manifest.currentExtensionsManifest?.let {
				encryptorsFactoryContext.getExtensionEncryptorsProvider(
					extensionsManifestName = it,
					encryptedClass = EncryptedHealthElement::class,
					decryptedClass = DecryptedHealthElement::class,
				)
			}
		return HealthElementEncryptor(
			identifiers_e = "identifiers" in manifest.fieldsToEncrypt,
			created_e = "created" in manifest.fieldsToEncrypt,
			modified_e = "modified" in manifest.fieldsToEncrypt,
			author_e = "author" in manifest.fieldsToEncrypt,
			responsible_e = "responsible" in manifest.fieldsToEncrypt,
			tags_e = "tags" in manifest.fieldsToEncrypt,
			codes_e = "codes" in manifest.fieldsToEncrypt,
			healthElementId_e = "healthElementId" in manifest.fieldsToEncrypt,
			valueDate_e = "valueDate" in manifest.fieldsToEncrypt,
			openingDate_e = "openingDate" in manifest.fieldsToEncrypt,
			closingDate_e = "closingDate" in manifest.fieldsToEncrypt,
			descr_e = "descr" in manifest.fieldsToEncrypt,
			note_e = "note" in manifest.fieldsToEncrypt,
			notes_e =
				if ("notes" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["notes"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorsFactoryContext.getEntityEncryptorsProvider(
								entityManifestName = it,
								encryptedClass = EncryptedAnnotation::class,
								decryptedClass = DecryptedAnnotation::class,
							),
						)
					} ?: EncryptableFieldConfig.None(AnnotationEncryptorFactory)
				},
			relevant_e = "relevant" in manifest.fieldsToEncrypt,
			idOpeningContact_e = "idOpeningContact" in manifest.fieldsToEncrypt,
			idClosingContact_e = "idClosingContact" in manifest.fieldsToEncrypt,
			idService_e = "idService" in manifest.fieldsToEncrypt,
			laterality_e = "laterality" in manifest.fieldsToEncrypt,
			plansOfAction_e =
				if ("plansOfAction" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["plansOfAction"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorsFactoryContext.getEntityEncryptorsProvider(
								entityManifestName = it,
								encryptedClass = EncryptedPlanOfAction::class,
								decryptedClass = DecryptedPlanOfAction::class,
							),
						)
					} ?: EncryptableFieldConfig.None(PlanOfActionEncryptorFactory)
				},
			episodes_e =
				if ("episodes" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["episodes"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorsFactoryContext.getEntityEncryptorsProvider(
								entityManifestName = it,
								encryptedClass = EncryptedEpisode::class,
								decryptedClass = DecryptedEpisode::class,
							),
						)
					} ?: EncryptableFieldConfig.None(EpisodeEncryptorFactory)
				},
			careTeam_e =
				if ("careTeam" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["careTeam"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorsFactoryContext.getEntityEncryptorsProvider(
								entityManifestName = it,
								encryptedClass = EncryptedCareTeamMember::class,
								decryptedClass = DecryptedCareTeamMember::class,
							),
						)
					} ?: EncryptableFieldConfig.None(CareTeamMemberEncryptorFactory)
				},
			extensionsEncryptor = extensionsEncryptor,
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class HealthElementEncryptor(
	private val identifiers_e: Boolean,
	private val created_e: Boolean,
	private val modified_e: Boolean,
	private val author_e: Boolean,
	private val responsible_e: Boolean,
	private val tags_e: Boolean,
	private val codes_e: Boolean,
	private val healthElementId_e: Boolean,
	private val valueDate_e: Boolean,
	private val openingDate_e: Boolean,
	private val closingDate_e: Boolean,
	private val descr_e: Boolean,
	private val note_e: Boolean,
	private val notes_e: EncryptableFieldConfig<EncryptedAnnotation, DecryptedAnnotation>,
	private val relevant_e: Boolean,
	private val idOpeningContact_e: Boolean,
	private val idClosingContact_e: Boolean,
	private val idService_e: Boolean,
	private val laterality_e: Boolean,
	private val plansOfAction_e: EncryptableFieldConfig<EncryptedPlanOfAction, DecryptedPlanOfAction>,
	private val episodes_e: EncryptableFieldConfig<EncryptedEpisode, DecryptedEpisode>,
	private val careTeam_e: EncryptableFieldConfig<EncryptedCareTeamMember, DecryptedCareTeamMember>,
	private val extensionsEncryptor: Lazy<ExtensionsEncryptors>?,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedHealthElement, DecryptedHealthElement>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedHealthElement,
	): EncryptedHealthElement {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (identifiers_e && clearEntity.identifiers.isNotEmpty()) {
			dataToEncrypt["identifiers"] =
				encodingJson.encodeToJsonElement(
					clearEntity.identifiers,
				)
		}
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
		if (healthElementId_e && clearEntity.healthElementId != null) {
			dataToEncrypt["healthElementId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.healthElementId,
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
		if (descr_e && clearEntity.descr != null) dataToEncrypt["descr"] = encodingJson.encodeToJsonElement(clearEntity.descr)
		if (note_e && clearEntity.note != null) dataToEncrypt["note"] = encodingJson.encodeToJsonElement(clearEntity.note)
		if (notes_e.fullEncryption && clearEntity.notes.isNotEmpty()) dataToEncrypt["notes"] = encodingJson.encodeToJsonElement(clearEntity.notes)
		if (relevant_e && clearEntity.relevant != true) dataToEncrypt["relevant"] = encodingJson.encodeToJsonElement(clearEntity.relevant)
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
		if (idService_e && clearEntity.idService != null) dataToEncrypt["idService"] = encodingJson.encodeToJsonElement(clearEntity.idService)
		if (laterality_e && clearEntity.laterality != null) dataToEncrypt["laterality"] = encodingJson.encodeToJsonElement(clearEntity.laterality)
		if (plansOfAction_e.fullEncryption && clearEntity.plansOfAction.isNotEmpty()) {
			dataToEncrypt["plansOfAction"] =
				encodingJson.encodeToJsonElement(
					clearEntity.plansOfAction,
				)
		}
		if (episodes_e.fullEncryption && clearEntity.episodes.isNotEmpty()) {
			dataToEncrypt["episodes"] =
				encodingJson.encodeToJsonElement(
					clearEntity.episodes,
				)
		}
		if (careTeam_e.fullEncryption && clearEntity.careTeam.isNotEmpty()) {
			dataToEncrypt["careTeam"] =
				encodingJson.encodeToJsonElement(
					clearEntity.careTeam,
				)
		}
		return EncryptedHealthElement(
			id = clearEntity.id,
			identifiers = if (identifiers_e) emptyList() else clearEntity.identifiers,
			rev = clearEntity.rev,
			created = if (created_e) null else clearEntity.created,
			modified = if (modified_e) null else clearEntity.modified,
			author = if (author_e) null else clearEntity.author,
			responsible = if (responsible_e) null else clearEntity.responsible,
			tags = if (tags_e) emptySet() else clearEntity.tags,
			codes = if (codes_e) emptySet() else clearEntity.codes,
			endOfLife = clearEntity.endOfLife,
			deletionDate = clearEntity.deletionDate,
			healthElementId = if (healthElementId_e) null else clearEntity.healthElementId,
			valueDate = if (valueDate_e) null else clearEntity.valueDate,
			openingDate = if (openingDate_e) null else clearEntity.openingDate,
			closingDate = if (closingDate_e) null else clearEntity.closingDate,
			descr = if (descr_e) null else clearEntity.descr,
			note = if (note_e) null else clearEntity.note,
			notes =
				notes_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.notes.map { x0 ->
							encryptor.encrypt(encryptionKey, x0)
						}
					}
				},
			relevant = if (relevant_e) true else clearEntity.relevant,
			idOpeningContact = if (idOpeningContact_e) null else clearEntity.idOpeningContact,
			idClosingContact = if (idClosingContact_e) null else clearEntity.idClosingContact,
			idService = if (idService_e) null else clearEntity.idService,
			laterality = if (laterality_e) null else clearEntity.laterality,
			plansOfAction =
				plansOfAction_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.plansOfAction.map { x0 ->
							encryptor.encrypt(encryptionKey, x0)
						}
					}
				},
			episodes =
				episodes_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.episodes.map { x0 ->
							encryptor.encrypt(encryptionKey, x0)
						}
					}
				},
			careTeam =
				careTeam_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.careTeam.map { x0 ->
							encryptor.encrypt(encryptionKey, x0)
						}
					}
				},
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
			securityMetadata = clearEntity.securityMetadata,
			extensions = extensionsEncryptor?.value?.encryptExtension(encryptionKey, clearEntity.extensions) ?: clearEntity.extensions,
			extensionsVersion = clearEntity.extensionsVersion,
		)
	}
}
