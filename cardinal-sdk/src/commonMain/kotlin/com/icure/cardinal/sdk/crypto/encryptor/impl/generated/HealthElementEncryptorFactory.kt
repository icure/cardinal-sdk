// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
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
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object HealthElementEncryptorFactory :
	EntityEncryptorFactory<EncryptedHealthElement, DecryptedHealthElement> {
	override val empty: EntityEncryptor<EncryptedHealthElement, DecryptedHealthElement> =
		HealthElementEncryptor(
			identifiers = false,
			created = false,
			modified = false,
			author = false,
			responsible = false,
			tags = false,
			codes = false,
			healthElementId = false,
			valueDate = false,
			openingDate = false,
			closingDate = false,
			descr = false,
			note = false,
			notes = EncryptableFieldConfig.None(AnnotationEncryptorFactory),
			relevant = false,
			idOpeningContact = false,
			idClosingContact = false,
			idService = false,
			laterality = false,
			plansOfAction = EncryptableFieldConfig.None(PlanOfActionEncryptorFactory),
			episodes = EncryptableFieldConfig.None(EpisodeEncryptorFactory),
			careTeam = EncryptableFieldConfig.None(CareTeamMemberEncryptorFactory),
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedHealthElement, DecryptedHealthElement> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return HealthElementEncryptor(
			identifiers = "identifiers" in manifest.fieldsToEncrypt,
			created = "created" in manifest.fieldsToEncrypt,
			modified = "modified" in manifest.fieldsToEncrypt,
			author = "author" in manifest.fieldsToEncrypt,
			responsible = "responsible" in manifest.fieldsToEncrypt,
			tags = "tags" in manifest.fieldsToEncrypt,
			codes = "codes" in manifest.fieldsToEncrypt,
			healthElementId = "healthElementId" in manifest.fieldsToEncrypt,
			valueDate = "valueDate" in manifest.fieldsToEncrypt,
			openingDate = "openingDate" in manifest.fieldsToEncrypt,
			closingDate = "closingDate" in manifest.fieldsToEncrypt,
			descr = "descr" in manifest.fieldsToEncrypt,
			note = "note" in manifest.fieldsToEncrypt,
			notes =
				if ("notes" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["notes"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedAnnotation::class,
								decryptedClass = DecryptedAnnotation::class,
							),
						)
					} ?: EncryptableFieldConfig.None(AnnotationEncryptorFactory)
				},
			relevant = "relevant" in manifest.fieldsToEncrypt,
			idOpeningContact = "idOpeningContact" in manifest.fieldsToEncrypt,
			idClosingContact = "idClosingContact" in manifest.fieldsToEncrypt,
			idService = "idService" in manifest.fieldsToEncrypt,
			laterality = "laterality" in manifest.fieldsToEncrypt,
			plansOfAction =
				if ("plansOfAction" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["plansOfAction"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedPlanOfAction::class,
								decryptedClass = DecryptedPlanOfAction::class,
							),
						)
					} ?: EncryptableFieldConfig.None(PlanOfActionEncryptorFactory)
				},
			episodes =
				if ("episodes" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["episodes"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedEpisode::class,
								decryptedClass = DecryptedEpisode::class,
							),
						)
					} ?: EncryptableFieldConfig.None(EpisodeEncryptorFactory)
				},
			careTeam =
				if ("careTeam" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["careTeam"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedCareTeamMember::class,
								decryptedClass = DecryptedCareTeamMember::class,
							),
						)
					} ?: EncryptableFieldConfig.None(CareTeamMemberEncryptorFactory)
				},
		)
	}
}

private class HealthElementEncryptor(
	private val identifiers: Boolean,
	private val created: Boolean,
	private val modified: Boolean,
	private val author: Boolean,
	private val responsible: Boolean,
	private val tags: Boolean,
	private val codes: Boolean,
	private val healthElementId: Boolean,
	private val valueDate: Boolean,
	private val openingDate: Boolean,
	private val closingDate: Boolean,
	private val descr: Boolean,
	private val note: Boolean,
	private val notes: EncryptableFieldConfig<EncryptedAnnotation, DecryptedAnnotation>,
	private val relevant: Boolean,
	private val idOpeningContact: Boolean,
	private val idClosingContact: Boolean,
	private val idService: Boolean,
	private val laterality: Boolean,
	private val plansOfAction: EncryptableFieldConfig<EncryptedPlanOfAction, DecryptedPlanOfAction>,
	private val episodes: EncryptableFieldConfig<EncryptedEpisode, DecryptedEpisode>,
	private val careTeam: EncryptableFieldConfig<EncryptedCareTeamMember, DecryptedCareTeamMember>,
) : AbstractEntityEncryptor<EncryptedHealthElement, DecryptedHealthElement>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedHealthElement,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedHealthElement {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (identifiers) dataToEncrypt["identifiers"] = encodingJson.encodeToJsonElement(clearEntity.identifiers)
		if (created) dataToEncrypt["created"] = encodingJson.encodeToJsonElement(clearEntity.created)
		if (modified) dataToEncrypt["modified"] = encodingJson.encodeToJsonElement(clearEntity.modified)
		if (author) dataToEncrypt["author"] = encodingJson.encodeToJsonElement(clearEntity.author)
		if (responsible) dataToEncrypt["responsible"] = encodingJson.encodeToJsonElement(clearEntity.responsible)
		if (tags) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (codes) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (healthElementId) dataToEncrypt["healthElementId"] = encodingJson.encodeToJsonElement(clearEntity.healthElementId)
		if (valueDate) dataToEncrypt["valueDate"] = encodingJson.encodeToJsonElement(clearEntity.valueDate)
		if (openingDate) dataToEncrypt["openingDate"] = encodingJson.encodeToJsonElement(clearEntity.openingDate)
		if (closingDate) dataToEncrypt["closingDate"] = encodingJson.encodeToJsonElement(clearEntity.closingDate)
		if (descr) dataToEncrypt["descr"] = encodingJson.encodeToJsonElement(clearEntity.descr)
		if (note) dataToEncrypt["note"] = encodingJson.encodeToJsonElement(clearEntity.note)
		if (notes.fullEncryption) dataToEncrypt["notes"] = encodingJson.encodeToJsonElement(clearEntity.notes)
		if (relevant) dataToEncrypt["relevant"] = encodingJson.encodeToJsonElement(clearEntity.relevant)
		if (idOpeningContact) dataToEncrypt["idOpeningContact"] = encodingJson.encodeToJsonElement(clearEntity.idOpeningContact)
		if (idClosingContact) dataToEncrypt["idClosingContact"] = encodingJson.encodeToJsonElement(clearEntity.idClosingContact)
		if (idService) dataToEncrypt["idService"] = encodingJson.encodeToJsonElement(clearEntity.idService)
		if (laterality) dataToEncrypt["laterality"] = encodingJson.encodeToJsonElement(clearEntity.laterality)
		if (plansOfAction.fullEncryption) dataToEncrypt["plansOfAction"] = encodingJson.encodeToJsonElement(clearEntity.plansOfAction)
		if (episodes.fullEncryption) dataToEncrypt["episodes"] = encodingJson.encodeToJsonElement(clearEntity.episodes)
		if (careTeam.fullEncryption) dataToEncrypt["careTeam"] = encodingJson.encodeToJsonElement(clearEntity.careTeam)
		return EncryptedHealthElement(
			id = clearEntity.id,
			identifiers = if (identifiers) emptyList() else clearEntity.identifiers,
			rev = clearEntity.rev,
			created = if (created) null else clearEntity.created,
			modified = if (modified) null else clearEntity.modified,
			author = if (author) null else clearEntity.author,
			responsible = if (responsible) null else clearEntity.responsible,
			tags = if (tags) emptySet() else clearEntity.tags,
			codes = if (codes) emptySet() else clearEntity.codes,
			endOfLife = clearEntity.endOfLife,
			deletionDate = clearEntity.deletionDate,
			healthElementId = if (healthElementId) null else clearEntity.healthElementId,
			valueDate = if (valueDate) null else clearEntity.valueDate,
			openingDate = if (openingDate) null else clearEntity.openingDate,
			closingDate = if (closingDate) null else clearEntity.closingDate,
			descr = if (descr) null else clearEntity.descr,
			note = if (note) null else clearEntity.note,
			notes =
				notes.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.notes.map { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			relevant = if (relevant) true else clearEntity.relevant,
			idOpeningContact = if (idOpeningContact) null else clearEntity.idOpeningContact,
			idClosingContact = if (idClosingContact) null else clearEntity.idClosingContact,
			idService = if (idService) null else clearEntity.idService,
			laterality = if (laterality) null else clearEntity.laterality,
			plansOfAction =
				plansOfAction.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.plansOfAction.map { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			episodes =
				episodes.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.episodes.map { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			careTeam =
				careTeam.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.careTeam.map { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
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
