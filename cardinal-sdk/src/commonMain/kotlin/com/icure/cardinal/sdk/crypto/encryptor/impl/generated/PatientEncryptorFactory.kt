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
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

@InternalIcureApi
internal object PatientEncryptorFactory : EntityEncryptorFactory<EncryptedPatient, DecryptedPatient> {
	override val empty: EntityEncryptor<EncryptedPatient, DecryptedPatient> =
		PatientEncryptor(
			identifier_e = false,
			created_e = false,
			modified_e = false,
			author_e = false,
			responsible_e = false,
			tags_e = false,
			codes_e = false,
			firstName_e = false,
			lastName_e = false,
			names_e = false,
			companyName_e = false,
			languages_e = false,
			addresses_e = EncryptableFieldConfig.None(AddressEncryptorFactory),
			civility_e = false,
			gender_e = false,
			birthSex_e = false,
			alias_e = false,
			active_e = false,
			deactivationReason_e = false,
			deactivationDate_e = false,
			ssin_e = false,
			maidenName_e = false,
			spouseName_e = false,
			partnerName_e = false,
			personalStatus_e = false,
			dateOfBirth_e = false,
			dateOfDeath_e = false,
			timestampOfLatestEidReading_e = false,
			placeOfBirth_e = false,
			placeOfDeath_e = false,
			deceased_e = false,
			education_e = false,
			profession_e = false,
			notes_e = EncryptableFieldConfig.None(AnnotationEncryptorFactory),
			note_e = false,
			administrativeNote_e = false,
			nationality_e = false,
			race_e = false,
			ethnicity_e = false,
			insurabilities_e = EncryptableFieldConfig.None(InsurabilityEncryptorFactory),
			partnerships_e = EncryptableFieldConfig.None(PartnershipEncryptorFactory),
			patientHealthCareParties_e = EncryptableFieldConfig.None(PatientHealthCarePartyEncryptorFactory),
			financialInstitutionInformation_e = EncryptableFieldConfig.None(FinancialInstitutionInformationEncryptorFactory),
			medicalHouseContracts_e = EncryptableFieldConfig.None(MedicalHouseContractEncryptorFactory),
			patientProfessions_e = false,
			parameters_e = false,
			properties_e = EncryptableFieldConfig.None(PropertyStubEncryptorFactory),
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedPatient, DecryptedPatient> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return PatientEncryptor(
			identifier_e = "identifier" in manifest.fieldsToEncrypt,
			created_e = "created" in manifest.fieldsToEncrypt,
			modified_e = "modified" in manifest.fieldsToEncrypt,
			author_e = "author" in manifest.fieldsToEncrypt,
			responsible_e = "responsible" in manifest.fieldsToEncrypt,
			tags_e = "tags" in manifest.fieldsToEncrypt,
			codes_e = "codes" in manifest.fieldsToEncrypt,
			firstName_e = "firstName" in manifest.fieldsToEncrypt,
			lastName_e = "lastName" in manifest.fieldsToEncrypt,
			names_e = "names" in manifest.fieldsToEncrypt,
			companyName_e = "companyName" in manifest.fieldsToEncrypt,
			languages_e = "languages" in manifest.fieldsToEncrypt,
			addresses_e =
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
			civility_e = "civility" in manifest.fieldsToEncrypt,
			gender_e = "gender" in manifest.fieldsToEncrypt,
			birthSex_e = "birthSex" in manifest.fieldsToEncrypt,
			alias_e = "alias" in manifest.fieldsToEncrypt,
			active_e = "active" in manifest.fieldsToEncrypt,
			deactivationReason_e = "deactivationReason" in manifest.fieldsToEncrypt,
			deactivationDate_e = "deactivationDate" in manifest.fieldsToEncrypt,
			ssin_e = "ssin" in manifest.fieldsToEncrypt,
			maidenName_e = "maidenName" in manifest.fieldsToEncrypt,
			spouseName_e = "spouseName" in manifest.fieldsToEncrypt,
			partnerName_e = "partnerName" in manifest.fieldsToEncrypt,
			personalStatus_e = "personalStatus" in manifest.fieldsToEncrypt,
			dateOfBirth_e = "dateOfBirth" in manifest.fieldsToEncrypt,
			dateOfDeath_e = "dateOfDeath" in manifest.fieldsToEncrypt,
			timestampOfLatestEidReading_e = "timestampOfLatestEidReading" in manifest.fieldsToEncrypt,
			placeOfBirth_e = "placeOfBirth" in manifest.fieldsToEncrypt,
			placeOfDeath_e = "placeOfDeath" in manifest.fieldsToEncrypt,
			deceased_e = "deceased" in manifest.fieldsToEncrypt,
			education_e = "education" in manifest.fieldsToEncrypt,
			profession_e = "profession" in manifest.fieldsToEncrypt,
			notes_e =
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
			note_e = "note" in manifest.fieldsToEncrypt,
			administrativeNote_e = "administrativeNote" in manifest.fieldsToEncrypt,
			nationality_e = "nationality" in manifest.fieldsToEncrypt,
			race_e = "race" in manifest.fieldsToEncrypt,
			ethnicity_e = "ethnicity" in manifest.fieldsToEncrypt,
			insurabilities_e =
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
			partnerships_e =
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
			patientHealthCareParties_e =
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
			financialInstitutionInformation_e =
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
			medicalHouseContracts_e =
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
			patientProfessions_e = "patientProfessions" in manifest.fieldsToEncrypt,
			parameters_e = "parameters" in manifest.fieldsToEncrypt,
			properties_e =
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

@InternalIcureApi
private class PatientEncryptor(
	private val identifier_e: Boolean,
	private val created_e: Boolean,
	private val modified_e: Boolean,
	private val author_e: Boolean,
	private val responsible_e: Boolean,
	private val tags_e: Boolean,
	private val codes_e: Boolean,
	private val firstName_e: Boolean,
	private val lastName_e: Boolean,
	private val names_e: Boolean,
	private val companyName_e: Boolean,
	private val languages_e: Boolean,
	private val addresses_e: EncryptableFieldConfig<EncryptedAddress, DecryptedAddress>,
	private val civility_e: Boolean,
	private val gender_e: Boolean,
	private val birthSex_e: Boolean,
	private val alias_e: Boolean,
	private val active_e: Boolean,
	private val deactivationReason_e: Boolean,
	private val deactivationDate_e: Boolean,
	private val ssin_e: Boolean,
	private val maidenName_e: Boolean,
	private val spouseName_e: Boolean,
	private val partnerName_e: Boolean,
	private val personalStatus_e: Boolean,
	private val dateOfBirth_e: Boolean,
	private val dateOfDeath_e: Boolean,
	private val timestampOfLatestEidReading_e: Boolean,
	private val placeOfBirth_e: Boolean,
	private val placeOfDeath_e: Boolean,
	private val deceased_e: Boolean,
	private val education_e: Boolean,
	private val profession_e: Boolean,
	private val notes_e: EncryptableFieldConfig<EncryptedAnnotation, DecryptedAnnotation>,
	private val note_e: Boolean,
	private val administrativeNote_e: Boolean,
	private val nationality_e: Boolean,
	private val race_e: Boolean,
	private val ethnicity_e: Boolean,
	private val insurabilities_e: EncryptableFieldConfig<EncryptedInsurability, DecryptedInsurability>,
	private val partnerships_e: EncryptableFieldConfig<EncryptedPartnership, DecryptedPartnership>,
	private val patientHealthCareParties_e: EncryptableFieldConfig<EncryptedPatientHealthCareParty, DecryptedPatientHealthCareParty>,
	private val financialInstitutionInformation_e:
		EncryptableFieldConfig<EncryptedFinancialInstitutionInformation, DecryptedFinancialInstitutionInformation>,
	private val medicalHouseContracts_e: EncryptableFieldConfig<EncryptedMedicalHouseContract, DecryptedMedicalHouseContract>,
	private val patientProfessions_e: Boolean,
	private val parameters_e: Boolean,
	private val properties_e: EncryptableFieldConfig<EncryptedPropertyStub, DecryptedPropertyStub>,
) : AbstractEntityEncryptor<EncryptedPatient, DecryptedPatient>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedPatient,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedPatient {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (identifier_e && clearEntity.identifier.isNotEmpty()) {
			dataToEncrypt["identifier"] =
				encodingJson.encodeToJsonElement(
					clearEntity.identifier,
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
		if (firstName_e && clearEntity.firstName != null) dataToEncrypt["firstName"] = encodingJson.encodeToJsonElement(clearEntity.firstName)
		if (lastName_e && clearEntity.lastName != null) dataToEncrypt["lastName"] = encodingJson.encodeToJsonElement(clearEntity.lastName)
		if (names_e && clearEntity.names.isNotEmpty()) dataToEncrypt["names"] = encodingJson.encodeToJsonElement(clearEntity.names)
		if (companyName_e && clearEntity.companyName != null) {
			dataToEncrypt["companyName"] =
				encodingJson.encodeToJsonElement(
					clearEntity.companyName,
				)
		}
		if (languages_e && clearEntity.languages.isNotEmpty()) {
			dataToEncrypt["languages"] =
				encodingJson.encodeToJsonElement(
					clearEntity.languages,
				)
		}
		if (addresses_e.fullEncryption && clearEntity.addresses.isNotEmpty()) {
			dataToEncrypt["addresses"] =
				encodingJson.encodeToJsonElement(
					clearEntity.addresses,
				)
		}
		if (civility_e && clearEntity.civility != null) dataToEncrypt["civility"] = encodingJson.encodeToJsonElement(clearEntity.civility)
		if (gender_e && clearEntity.gender != Gender.Unknown) dataToEncrypt["gender"] = encodingJson.encodeToJsonElement(clearEntity.gender)
		if (birthSex_e && clearEntity.birthSex != Gender.Unknown) {
			dataToEncrypt["birthSex"] =
				encodingJson.encodeToJsonElement(
					clearEntity.birthSex,
				)
		}
		if (alias_e && clearEntity.alias != null) dataToEncrypt["alias"] = encodingJson.encodeToJsonElement(clearEntity.alias)
		if (active_e && clearEntity.active != true) dataToEncrypt["active"] = encodingJson.encodeToJsonElement(clearEntity.active)
		if (deactivationReason_e && clearEntity.deactivationReason != "none") {
			dataToEncrypt["deactivationReason"] =
				encodingJson.encodeToJsonElement(
					clearEntity.deactivationReason,
				)
		}
		if (deactivationDate_e && clearEntity.deactivationDate != null) {
			dataToEncrypt["deactivationDate"] =
				encodingJson.encodeToJsonElement(
					clearEntity.deactivationDate,
				)
		}
		if (ssin_e && clearEntity.ssin != null) dataToEncrypt["ssin"] = encodingJson.encodeToJsonElement(clearEntity.ssin)
		if (maidenName_e && clearEntity.maidenName != null) dataToEncrypt["maidenName"] = encodingJson.encodeToJsonElement(clearEntity.maidenName)
		if (spouseName_e && clearEntity.spouseName != null) dataToEncrypt["spouseName"] = encodingJson.encodeToJsonElement(clearEntity.spouseName)
		if (partnerName_e && clearEntity.partnerName != null) {
			dataToEncrypt["partnerName"] =
				encodingJson.encodeToJsonElement(
					clearEntity.partnerName,
				)
		}
		if (personalStatus_e && clearEntity.personalStatus != PersonalStatus.Unknown) {
			dataToEncrypt["personalStatus"] =
				encodingJson.encodeToJsonElement(
					clearEntity.personalStatus,
				)
		}
		if (dateOfBirth_e && clearEntity.dateOfBirth != null) {
			dataToEncrypt["dateOfBirth"] =
				encodingJson.encodeToJsonElement(
					clearEntity.dateOfBirth,
				)
		}
		if (dateOfDeath_e && clearEntity.dateOfDeath != null) {
			dataToEncrypt["dateOfDeath"] =
				encodingJson.encodeToJsonElement(
					clearEntity.dateOfDeath,
				)
		}
		if (timestampOfLatestEidReading_e && clearEntity.timestampOfLatestEidReading != null) {
			dataToEncrypt["timestampOfLatestEidReading"] =
				encodingJson.encodeToJsonElement(
					clearEntity.timestampOfLatestEidReading,
				)
		}
		if (placeOfBirth_e && clearEntity.placeOfBirth != null) {
			dataToEncrypt["placeOfBirth"] =
				encodingJson.encodeToJsonElement(
					clearEntity.placeOfBirth,
				)
		}
		if (placeOfDeath_e && clearEntity.placeOfDeath != null) {
			dataToEncrypt["placeOfDeath"] =
				encodingJson.encodeToJsonElement(
					clearEntity.placeOfDeath,
				)
		}
		if (deceased_e && clearEntity.deceased != null) dataToEncrypt["deceased"] = encodingJson.encodeToJsonElement(clearEntity.deceased)
		if (education_e && clearEntity.education != null) dataToEncrypt["education"] = encodingJson.encodeToJsonElement(clearEntity.education)
		if (profession_e && clearEntity.profession != null) dataToEncrypt["profession"] = encodingJson.encodeToJsonElement(clearEntity.profession)
		if (notes_e.fullEncryption && clearEntity.notes.isNotEmpty()) dataToEncrypt["notes"] = encodingJson.encodeToJsonElement(clearEntity.notes)
		if (note_e && clearEntity.note != null) dataToEncrypt["note"] = encodingJson.encodeToJsonElement(clearEntity.note)
		if (administrativeNote_e && clearEntity.administrativeNote != null) {
			dataToEncrypt["administrativeNote"] =
				encodingJson.encodeToJsonElement(
					clearEntity.administrativeNote,
				)
		}
		if (nationality_e && clearEntity.nationality != null) {
			dataToEncrypt["nationality"] =
				encodingJson.encodeToJsonElement(
					clearEntity.nationality,
				)
		}
		if (race_e && clearEntity.race != null) dataToEncrypt["race"] = encodingJson.encodeToJsonElement(clearEntity.race)
		if (ethnicity_e && clearEntity.ethnicity != null) dataToEncrypt["ethnicity"] = encodingJson.encodeToJsonElement(clearEntity.ethnicity)
		if (insurabilities_e.fullEncryption && clearEntity.insurabilities.isNotEmpty()) {
			dataToEncrypt["insurabilities"] =
				encodingJson.encodeToJsonElement(
					clearEntity.insurabilities,
				)
		}
		if (partnerships_e.fullEncryption && clearEntity.partnerships.isNotEmpty()) {
			dataToEncrypt["partnerships"] =
				encodingJson.encodeToJsonElement(
					clearEntity.partnerships,
				)
		}
		if (patientHealthCareParties_e.fullEncryption && clearEntity.patientHealthCareParties.isNotEmpty()) {
			dataToEncrypt["patientHealthCareParties"] =
				encodingJson.encodeToJsonElement(
					clearEntity.patientHealthCareParties,
				)
		}
		if (financialInstitutionInformation_e.fullEncryption && clearEntity.financialInstitutionInformation.isNotEmpty()) {
			dataToEncrypt["financialInstitutionInformation"] =
				encodingJson.encodeToJsonElement(
					clearEntity.financialInstitutionInformation,
				)
		}
		if (medicalHouseContracts_e.fullEncryption && clearEntity.medicalHouseContracts.isNotEmpty()) {
			dataToEncrypt["medicalHouseContracts"] =
				encodingJson.encodeToJsonElement(
					clearEntity.medicalHouseContracts,
				)
		}
		if (patientProfessions_e && clearEntity.patientProfessions.isNotEmpty()) {
			dataToEncrypt["patientProfessions"] =
				encodingJson.encodeToJsonElement(
					clearEntity.patientProfessions,
				)
		}
		if (parameters_e && clearEntity.parameters.isNotEmpty()) {
			dataToEncrypt["parameters"] =
				encodingJson.encodeToJsonElement(
					clearEntity.parameters,
				)
		}
		if (properties_e.fullEncryption && clearEntity.properties.isNotEmpty()) {
			dataToEncrypt["properties"] =
				encodingJson.encodeToJsonElement(
					clearEntity.properties,
				)
		}
		return EncryptedPatient(
			id = clearEntity.id,
			identifier = if (identifier_e) emptyList() else clearEntity.identifier,
			rev = clearEntity.rev,
			created = if (created_e) null else clearEntity.created,
			modified = if (modified_e) null else clearEntity.modified,
			author = if (author_e) null else clearEntity.author,
			responsible = if (responsible_e) null else clearEntity.responsible,
			tags = if (tags_e) emptySet() else clearEntity.tags,
			codes = if (codes_e) emptySet() else clearEntity.codes,
			deletionDate = clearEntity.deletionDate,
			firstName = if (firstName_e) null else clearEntity.firstName,
			lastName = if (lastName_e) null else clearEntity.lastName,
			names = if (names_e) emptyList() else clearEntity.names,
			companyName = if (companyName_e) null else clearEntity.companyName,
			languages = if (languages_e) emptyList() else clearEntity.languages,
			addresses =
				addresses_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.addresses.map { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			civility = if (civility_e) null else clearEntity.civility,
			gender = if (gender_e) Gender.Unknown else clearEntity.gender,
			birthSex = if (birthSex_e) Gender.Unknown else clearEntity.birthSex,
			mergeToPatientId = clearEntity.mergeToPatientId,
			mergedIds = clearEntity.mergedIds,
			alias = if (alias_e) null else clearEntity.alias,
			active = if (active_e) true else clearEntity.active,
			deactivationReason = if (deactivationReason_e) "none" else clearEntity.deactivationReason,
			deactivationDate = if (deactivationDate_e) null else clearEntity.deactivationDate,
			ssin = if (ssin_e) null else clearEntity.ssin,
			maidenName = if (maidenName_e) null else clearEntity.maidenName,
			spouseName = if (spouseName_e) null else clearEntity.spouseName,
			partnerName = if (partnerName_e) null else clearEntity.partnerName,
			personalStatus = if (personalStatus_e) PersonalStatus.Unknown else clearEntity.personalStatus,
			dateOfBirth = if (dateOfBirth_e) null else clearEntity.dateOfBirth,
			dateOfDeath = if (dateOfDeath_e) null else clearEntity.dateOfDeath,
			timestampOfLatestEidReading = if (timestampOfLatestEidReading_e) null else clearEntity.timestampOfLatestEidReading,
			placeOfBirth = if (placeOfBirth_e) null else clearEntity.placeOfBirth,
			placeOfDeath = if (placeOfDeath_e) null else clearEntity.placeOfDeath,
			deceased = if (deceased_e) null else clearEntity.deceased,
			education = if (education_e) null else clearEntity.education,
			profession = if (profession_e) null else clearEntity.profession,
			notes =
				notes_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.notes.map { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			note = if (note_e) null else clearEntity.note,
			administrativeNote = if (administrativeNote_e) null else clearEntity.administrativeNote,
			nationality = if (nationality_e) null else clearEntity.nationality,
			race = if (race_e) null else clearEntity.race,
			ethnicity = if (ethnicity_e) null else clearEntity.ethnicity,
			insurabilities =
				insurabilities_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.insurabilities.map { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			partnerships =
				partnerships_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.partnerships.map { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			patientHealthCareParties =
				patientHealthCareParties_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.patientHealthCareParties.map { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			financialInstitutionInformation =
				financialInstitutionInformation_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.financialInstitutionInformation.map { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			medicalHouseContracts =
				medicalHouseContracts_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.medicalHouseContracts.map { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			patientProfessions = if (patientProfessions_e) emptyList() else clearEntity.patientProfessions,
			parameters = if (parameters_e) emptyMap() else clearEntity.parameters,
			properties =
				properties_e.encryptor.let { encryptor ->
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
