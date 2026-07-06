// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.EncryptableFieldConfig
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.model.embed.DecryptedAnnotation
import com.icure.cardinal.sdk.model.embed.DecryptedFinancialInstitutionInformation
import com.icure.cardinal.sdk.model.embed.DecryptedInsurability
import com.icure.cardinal.sdk.model.embed.DecryptedMedicalHouseContract
import com.icure.cardinal.sdk.model.embed.DecryptedPartnership
import com.icure.cardinal.sdk.model.embed.DecryptedPatientHealthCareParty
import com.icure.cardinal.sdk.model.embed.EncryptedAddress
import com.icure.cardinal.sdk.model.embed.EncryptedAnnotation
import com.icure.cardinal.sdk.model.embed.EncryptedFinancialInstitutionInformation
import com.icure.cardinal.sdk.model.embed.EncryptedInsurability
import com.icure.cardinal.sdk.model.embed.EncryptedMedicalHouseContract
import com.icure.cardinal.sdk.model.embed.EncryptedPartnership
import com.icure.cardinal.sdk.model.embed.EncryptedPatientHealthCareParty
import com.icure.cardinal.sdk.model.embed.Gender
import com.icure.cardinal.sdk.model.embed.PersonalStatus
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object PatientEncryptorFactory : EntityEncryptorFactory<EncryptedPatient, DecryptedPatient> {
	override val empty: EntityEncryptor<EncryptedPatient, DecryptedPatient> =
		PatientEncryptor(
			identifier = false,
			created = false,
			modified = false,
			author = false,
			responsible = false,
			tags = false,
			codes = false,
			firstName = false,
			lastName = false,
			names = false,
			companyName = false,
			languages = false,
			addresses = EncryptableFieldConfig.None(AddressEncryptorFactory),
			civility = false,
			gender = false,
			birthSex = false,
			alias = false,
			active = false,
			deactivationReason = false,
			deactivationDate = false,
			ssin = false,
			maidenName = false,
			spouseName = false,
			partnerName = false,
			personalStatus = false,
			dateOfBirth = false,
			dateOfDeath = false,
			timestampOfLatestEidReading = false,
			placeOfBirth = false,
			placeOfDeath = false,
			deceased = false,
			education = false,
			profession = false,
			notes = EncryptableFieldConfig.None(AnnotationEncryptorFactory),
			note = false,
			administrativeNote = false,
			nationality = false,
			race = false,
			ethnicity = false,
			insurabilities = EncryptableFieldConfig.None(InsurabilityEncryptorFactory),
			partnerships = EncryptableFieldConfig.None(PartnershipEncryptorFactory),
			patientHealthCareParties = EncryptableFieldConfig.None(PatientHealthCarePartyEncryptorFactory),
			financialInstitutionInformation = EncryptableFieldConfig.None(FinancialInstitutionInformationEncryptorFactory),
			medicalHouseContracts = EncryptableFieldConfig.None(MedicalHouseContractEncryptorFactory),
			patientProfessions = false,
			parameters = false,
			properties = EncryptableFieldConfig.None(PropertyStubEncryptorFactory),
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedPatient, DecryptedPatient> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return PatientEncryptor(
			identifier = "identifier" in manifest.fieldsToEncrypt,
			created = "created" in manifest.fieldsToEncrypt,
			modified = "modified" in manifest.fieldsToEncrypt,
			author = "author" in manifest.fieldsToEncrypt,
			responsible = "responsible" in manifest.fieldsToEncrypt,
			tags = "tags" in manifest.fieldsToEncrypt,
			codes = "codes" in manifest.fieldsToEncrypt,
			firstName = "firstName" in manifest.fieldsToEncrypt,
			lastName = "lastName" in manifest.fieldsToEncrypt,
			names = "names" in manifest.fieldsToEncrypt,
			companyName = "companyName" in manifest.fieldsToEncrypt,
			languages = "languages" in manifest.fieldsToEncrypt,
			addresses =
				if ("addresses" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["addresses"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedAddress::class,
								decryptedClass = DecryptedAddress::class,
							),
						)
					} ?: EncryptableFieldConfig.None(AddressEncryptorFactory)
				},
			civility = "civility" in manifest.fieldsToEncrypt,
			gender = "gender" in manifest.fieldsToEncrypt,
			birthSex = "birthSex" in manifest.fieldsToEncrypt,
			alias = "alias" in manifest.fieldsToEncrypt,
			active = "active" in manifest.fieldsToEncrypt,
			deactivationReason = "deactivationReason" in manifest.fieldsToEncrypt,
			deactivationDate = "deactivationDate" in manifest.fieldsToEncrypt,
			ssin = "ssin" in manifest.fieldsToEncrypt,
			maidenName = "maidenName" in manifest.fieldsToEncrypt,
			spouseName = "spouseName" in manifest.fieldsToEncrypt,
			partnerName = "partnerName" in manifest.fieldsToEncrypt,
			personalStatus = "personalStatus" in manifest.fieldsToEncrypt,
			dateOfBirth = "dateOfBirth" in manifest.fieldsToEncrypt,
			dateOfDeath = "dateOfDeath" in manifest.fieldsToEncrypt,
			timestampOfLatestEidReading = "timestampOfLatestEidReading" in manifest.fieldsToEncrypt,
			placeOfBirth = "placeOfBirth" in manifest.fieldsToEncrypt,
			placeOfDeath = "placeOfDeath" in manifest.fieldsToEncrypt,
			deceased = "deceased" in manifest.fieldsToEncrypt,
			education = "education" in manifest.fieldsToEncrypt,
			profession = "profession" in manifest.fieldsToEncrypt,
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
			note = "note" in manifest.fieldsToEncrypt,
			administrativeNote = "administrativeNote" in manifest.fieldsToEncrypt,
			nationality = "nationality" in manifest.fieldsToEncrypt,
			race = "race" in manifest.fieldsToEncrypt,
			ethnicity = "ethnicity" in manifest.fieldsToEncrypt,
			insurabilities =
				if ("insurabilities" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["insurabilities"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedInsurability::class,
								decryptedClass = DecryptedInsurability::class,
							),
						)
					} ?: EncryptableFieldConfig.None(InsurabilityEncryptorFactory)
				},
			partnerships =
				if ("partnerships" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["partnerships"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedPartnership::class,
								decryptedClass = DecryptedPartnership::class,
							),
						)
					} ?: EncryptableFieldConfig.None(PartnershipEncryptorFactory)
				},
			patientHealthCareParties =
				if ("patientHealthCareParties" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["patientHealthCareParties"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedPatientHealthCareParty::class,
								decryptedClass = DecryptedPatientHealthCareParty::class,
							),
						)
					} ?: EncryptableFieldConfig.None(PatientHealthCarePartyEncryptorFactory)
				},
			financialInstitutionInformation =
				if ("financialInstitutionInformation" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["financialInstitutionInformation"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedFinancialInstitutionInformation::class,
								decryptedClass = DecryptedFinancialInstitutionInformation::class,
							),
						)
					} ?: EncryptableFieldConfig.None(FinancialInstitutionInformationEncryptorFactory)
				},
			medicalHouseContracts =
				if ("medicalHouseContracts" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["medicalHouseContracts"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedMedicalHouseContract::class,
								decryptedClass = DecryptedMedicalHouseContract::class,
							),
						)
					} ?: EncryptableFieldConfig.None(MedicalHouseContractEncryptorFactory)
				},
			patientProfessions = "patientProfessions" in manifest.fieldsToEncrypt,
			parameters = "parameters" in manifest.fieldsToEncrypt,
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
		)
	}
}

private class PatientEncryptor(
	private val identifier: Boolean,
	private val created: Boolean,
	private val modified: Boolean,
	private val author: Boolean,
	private val responsible: Boolean,
	private val tags: Boolean,
	private val codes: Boolean,
	private val firstName: Boolean,
	private val lastName: Boolean,
	private val names: Boolean,
	private val companyName: Boolean,
	private val languages: Boolean,
	private val addresses: EncryptableFieldConfig<EncryptedAddress, DecryptedAddress>,
	private val civility: Boolean,
	private val gender: Boolean,
	private val birthSex: Boolean,
	private val alias: Boolean,
	private val active: Boolean,
	private val deactivationReason: Boolean,
	private val deactivationDate: Boolean,
	private val ssin: Boolean,
	private val maidenName: Boolean,
	private val spouseName: Boolean,
	private val partnerName: Boolean,
	private val personalStatus: Boolean,
	private val dateOfBirth: Boolean,
	private val dateOfDeath: Boolean,
	private val timestampOfLatestEidReading: Boolean,
	private val placeOfBirth: Boolean,
	private val placeOfDeath: Boolean,
	private val deceased: Boolean,
	private val education: Boolean,
	private val profession: Boolean,
	private val notes: EncryptableFieldConfig<EncryptedAnnotation, DecryptedAnnotation>,
	private val note: Boolean,
	private val administrativeNote: Boolean,
	private val nationality: Boolean,
	private val race: Boolean,
	private val ethnicity: Boolean,
	private val insurabilities: EncryptableFieldConfig<EncryptedInsurability, DecryptedInsurability>,
	private val partnerships: EncryptableFieldConfig<EncryptedPartnership, DecryptedPartnership>,
	private val patientHealthCareParties: EncryptableFieldConfig<EncryptedPatientHealthCareParty, DecryptedPatientHealthCareParty>,
	private val financialInstitutionInformation:
		EncryptableFieldConfig<EncryptedFinancialInstitutionInformation, DecryptedFinancialInstitutionInformation>,
	private val medicalHouseContracts: EncryptableFieldConfig<EncryptedMedicalHouseContract, DecryptedMedicalHouseContract>,
	private val patientProfessions: Boolean,
	private val parameters: Boolean,
	private val properties: EncryptableFieldConfig<EncryptedPropertyStub, DecryptedPropertyStub>,
) : AbstractEntityEncryptor<EncryptedPatient, DecryptedPatient>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedPatient,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedPatient {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (identifier) dataToEncrypt["identifier"] = encodingJson.encodeToJsonElement(clearEntity.identifier)
		if (created) dataToEncrypt["created"] = encodingJson.encodeToJsonElement(clearEntity.created)
		if (modified) dataToEncrypt["modified"] = encodingJson.encodeToJsonElement(clearEntity.modified)
		if (author) dataToEncrypt["author"] = encodingJson.encodeToJsonElement(clearEntity.author)
		if (responsible) dataToEncrypt["responsible"] = encodingJson.encodeToJsonElement(clearEntity.responsible)
		if (tags) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (codes) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (firstName) dataToEncrypt["firstName"] = encodingJson.encodeToJsonElement(clearEntity.firstName)
		if (lastName) dataToEncrypt["lastName"] = encodingJson.encodeToJsonElement(clearEntity.lastName)
		if (names) dataToEncrypt["names"] = encodingJson.encodeToJsonElement(clearEntity.names)
		if (companyName) dataToEncrypt["companyName"] = encodingJson.encodeToJsonElement(clearEntity.companyName)
		if (languages) dataToEncrypt["languages"] = encodingJson.encodeToJsonElement(clearEntity.languages)
		if (addresses.fullEncryption) dataToEncrypt["addresses"] = encodingJson.encodeToJsonElement(clearEntity.addresses)
		if (civility) dataToEncrypt["civility"] = encodingJson.encodeToJsonElement(clearEntity.civility)
		if (gender) dataToEncrypt["gender"] = encodingJson.encodeToJsonElement(clearEntity.gender)
		if (birthSex) dataToEncrypt["birthSex"] = encodingJson.encodeToJsonElement(clearEntity.birthSex)
		if (alias) dataToEncrypt["alias"] = encodingJson.encodeToJsonElement(clearEntity.alias)
		if (active) dataToEncrypt["active"] = encodingJson.encodeToJsonElement(clearEntity.active)
		if (deactivationReason) dataToEncrypt["deactivationReason"] = encodingJson.encodeToJsonElement(clearEntity.deactivationReason)
		if (deactivationDate) dataToEncrypt["deactivationDate"] = encodingJson.encodeToJsonElement(clearEntity.deactivationDate)
		if (ssin) dataToEncrypt["ssin"] = encodingJson.encodeToJsonElement(clearEntity.ssin)
		if (maidenName) dataToEncrypt["maidenName"] = encodingJson.encodeToJsonElement(clearEntity.maidenName)
		if (spouseName) dataToEncrypt["spouseName"] = encodingJson.encodeToJsonElement(clearEntity.spouseName)
		if (partnerName) dataToEncrypt["partnerName"] = encodingJson.encodeToJsonElement(clearEntity.partnerName)
		if (personalStatus) dataToEncrypt["personalStatus"] = encodingJson.encodeToJsonElement(clearEntity.personalStatus)
		if (dateOfBirth) dataToEncrypt["dateOfBirth"] = encodingJson.encodeToJsonElement(clearEntity.dateOfBirth)
		if (dateOfDeath) dataToEncrypt["dateOfDeath"] = encodingJson.encodeToJsonElement(clearEntity.dateOfDeath)
		if (timestampOfLatestEidReading) {
			dataToEncrypt["timestampOfLatestEidReading"] =
				encodingJson.encodeToJsonElement(
					clearEntity.timestampOfLatestEidReading,
				)
		}
		if (placeOfBirth) dataToEncrypt["placeOfBirth"] = encodingJson.encodeToJsonElement(clearEntity.placeOfBirth)
		if (placeOfDeath) dataToEncrypt["placeOfDeath"] = encodingJson.encodeToJsonElement(clearEntity.placeOfDeath)
		if (deceased) dataToEncrypt["deceased"] = encodingJson.encodeToJsonElement(clearEntity.deceased)
		if (education) dataToEncrypt["education"] = encodingJson.encodeToJsonElement(clearEntity.education)
		if (profession) dataToEncrypt["profession"] = encodingJson.encodeToJsonElement(clearEntity.profession)
		if (notes.fullEncryption) dataToEncrypt["notes"] = encodingJson.encodeToJsonElement(clearEntity.notes)
		if (note) dataToEncrypt["note"] = encodingJson.encodeToJsonElement(clearEntity.note)
		if (administrativeNote) dataToEncrypt["administrativeNote"] = encodingJson.encodeToJsonElement(clearEntity.administrativeNote)
		if (nationality) dataToEncrypt["nationality"] = encodingJson.encodeToJsonElement(clearEntity.nationality)
		if (race) dataToEncrypt["race"] = encodingJson.encodeToJsonElement(clearEntity.race)
		if (ethnicity) dataToEncrypt["ethnicity"] = encodingJson.encodeToJsonElement(clearEntity.ethnicity)
		if (insurabilities.fullEncryption) dataToEncrypt["insurabilities"] = encodingJson.encodeToJsonElement(clearEntity.insurabilities)
		if (partnerships.fullEncryption) dataToEncrypt["partnerships"] = encodingJson.encodeToJsonElement(clearEntity.partnerships)
		if (patientHealthCareParties.fullEncryption) {
			dataToEncrypt["patientHealthCareParties"] =
				encodingJson.encodeToJsonElement(
					clearEntity.patientHealthCareParties,
				)
		}
		if (financialInstitutionInformation.fullEncryption) {
			dataToEncrypt["financialInstitutionInformation"] =
				encodingJson.encodeToJsonElement(
					clearEntity.financialInstitutionInformation,
				)
		}
		if (medicalHouseContracts.fullEncryption) {
			dataToEncrypt["medicalHouseContracts"] =
				encodingJson.encodeToJsonElement(
					clearEntity.medicalHouseContracts,
				)
		}
		if (patientProfessions) dataToEncrypt["patientProfessions"] = encodingJson.encodeToJsonElement(clearEntity.patientProfessions)
		if (parameters) dataToEncrypt["parameters"] = encodingJson.encodeToJsonElement(clearEntity.parameters)
		if (properties.fullEncryption) dataToEncrypt["properties"] = encodingJson.encodeToJsonElement(clearEntity.properties)
		return EncryptedPatient(
			id = clearEntity.id,
			identifier = if (identifier) emptyList() else clearEntity.identifier,
			rev = clearEntity.rev,
			created = if (created) null else clearEntity.created,
			modified = if (modified) null else clearEntity.modified,
			author = if (author) null else clearEntity.author,
			responsible = if (responsible) null else clearEntity.responsible,
			tags = if (tags) emptySet() else clearEntity.tags,
			codes = if (codes) emptySet() else clearEntity.codes,
			deletionDate = clearEntity.deletionDate,
			firstName = if (firstName) null else clearEntity.firstName,
			lastName = if (lastName) null else clearEntity.lastName,
			names = if (names) emptyList() else clearEntity.names,
			companyName = if (companyName) null else clearEntity.companyName,
			languages = if (languages) emptyList() else clearEntity.languages,
			addresses =
				addresses.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.addresses.map { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			civility = if (civility) null else clearEntity.civility,
			gender = if (gender) Gender.Unknown else clearEntity.gender,
			birthSex = if (birthSex) Gender.Unknown else clearEntity.birthSex,
			mergeToPatientId = clearEntity.mergeToPatientId,
			mergedIds = clearEntity.mergedIds,
			alias = if (alias) null else clearEntity.alias,
			active = if (active) true else clearEntity.active,
			deactivationReason = if (deactivationReason) "none" else clearEntity.deactivationReason,
			deactivationDate = if (deactivationDate) null else clearEntity.deactivationDate,
			ssin = if (ssin) null else clearEntity.ssin,
			maidenName = if (maidenName) null else clearEntity.maidenName,
			spouseName = if (spouseName) null else clearEntity.spouseName,
			partnerName = if (partnerName) null else clearEntity.partnerName,
			personalStatus = if (personalStatus) PersonalStatus.Unknown else clearEntity.personalStatus,
			dateOfBirth = if (dateOfBirth) null else clearEntity.dateOfBirth,
			dateOfDeath = if (dateOfDeath) null else clearEntity.dateOfDeath,
			timestampOfLatestEidReading = if (timestampOfLatestEidReading) null else clearEntity.timestampOfLatestEidReading,
			placeOfBirth = if (placeOfBirth) null else clearEntity.placeOfBirth,
			placeOfDeath = if (placeOfDeath) null else clearEntity.placeOfDeath,
			deceased = if (deceased) null else clearEntity.deceased,
			education = if (education) null else clearEntity.education,
			profession = if (profession) null else clearEntity.profession,
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
			note = if (note) null else clearEntity.note,
			administrativeNote = if (administrativeNote) null else clearEntity.administrativeNote,
			nationality = if (nationality) null else clearEntity.nationality,
			race = if (race) null else clearEntity.race,
			ethnicity = if (ethnicity) null else clearEntity.ethnicity,
			insurabilities =
				insurabilities.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.insurabilities.map { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			partnerships =
				partnerships.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.partnerships.map { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			patientHealthCareParties =
				patientHealthCareParties.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.patientHealthCareParties.map { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			financialInstitutionInformation =
				financialInstitutionInformation.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.financialInstitutionInformation.map { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			medicalHouseContracts =
				medicalHouseContracts.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.medicalHouseContracts.map { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			patientProfessions = if (patientProfessions) emptyList() else clearEntity.patientProfessions,
			parameters = if (parameters) emptyMap() else clearEntity.parameters,
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
			hcPartyKeys = clearEntity.hcPartyKeys,
			aesExchangeKeys = clearEntity.aesExchangeKeys,
			transferKeys = clearEntity.transferKeys,
			privateKeyShamirPartitions = clearEntity.privateKeyShamirPartitions,
			publicKey = clearEntity.publicKey,
			publicKeysForOaepWithSha256 = clearEntity.publicKeysForOaepWithSha256,
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			securityMetadata = clearEntity.securityMetadata,
			cryptoActorProperties = clearEntity.cryptoActorProperties,
			parentId = clearEntity.parentId,
			extensions = clearEntity.extensions,
			extensionsVersion = clearEntity.extensionsVersion,
		)
	}
}
