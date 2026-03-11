package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.CryptoActor
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.base.Person
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.Address
import com.icure.cardinal.sdk.model.embed.Annotation
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.model.embed.DecryptedFinancialInstitutionInformation
import com.icure.cardinal.sdk.model.embed.DecryptedInsurability
import com.icure.cardinal.sdk.model.embed.DecryptedMedicalHouseContract
import com.icure.cardinal.sdk.model.embed.DecryptedPatientHealthCareParty
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.embed.EncryptedAddress
import com.icure.cardinal.sdk.model.embed.EncryptedFinancialInstitutionInformation
import com.icure.cardinal.sdk.model.embed.EncryptedInsurability
import com.icure.cardinal.sdk.model.embed.EncryptedMedicalHouseContract
import com.icure.cardinal.sdk.model.embed.EncryptedPatientHealthCareParty
import com.icure.cardinal.sdk.model.embed.FinancialInstitutionInformation
import com.icure.cardinal.sdk.model.embed.Gender
import com.icure.cardinal.sdk.model.embed.Insurability
import com.icure.cardinal.sdk.model.embed.MedicalHouseContract
import com.icure.cardinal.sdk.model.embed.Partnership
import com.icure.cardinal.sdk.model.embed.PatientHealthCareParty
import com.icure.cardinal.sdk.model.embed.PersonName
import com.icure.cardinal.sdk.model.embed.PersonalStatus
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEntryKeyString
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

/**
 * Represents a patient in the iCure platform. A patient is a person who receives healthcare
 * services.
 * This entity stores personal, administrative, and medical information about the patient, and
 * supports
 * end-to-end encryption of sensitive data.
 * /
 */
public sealed interface Patient :
	StoredDocument,
	ICureDocument<String>,
	Person,
	HasEncryptionMetadata,
	Encryptable,
	CryptoActor {
	/**
	 * The Id of the patient. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String

	/**
	 * The patient's identifiers, used by the client to uniquely identify the patient.
	 */
	public val identifier: List<Identifier>

	/**
	 * The revision of the patient in the database, used for conflict management / optimistic locking.
	 */
	override val rev: String?

	/**
	 * The timestamp (unix epoch in ms) of creation.
	 */
	override val created: Long?

	/**
	 * The timestamp (unix epoch in ms) of the latest modification.
	 */
	override val modified: Long?

	/**
	 * The id of the User that created this patient.
	 */
	override val author: String?

	/**
	 * The id of the HealthcareParty that is responsible for this patient.
	 */
	override val responsible: String?

	/**
	 * Tags that qualify the patient as being member of a certain class.
	 */
	override val tags: Set<CodeStub>

	/**
	 * Codes that identify or qualify this particular patient.
	 */
	override val codes: Set<CodeStub>

	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long?

	/**
	 * The firstname (name) of the patient.
	 */
	override val firstName: String?

	/**
	 * The lastname (surname) of the patient.
	 */
	override val lastName: String?

	/**
	 * The list of all names of the patient, ordered by preference of use.
	 */
	override val names: List<PersonName>

	/**
	 * The name of the company this patient is member of.
	 */
	override val companyName: String?

	/**
	 * The list of languages spoken by the patient ordered by fluency (alpha-2 code).
	 */
	override val languages: List<String>

	/**
	 * The list of addresses (with address type).
	 */
	override val addresses: List<Address>

	/**
	 * Mr., Ms., Pr., Dr. ...
	 */
	override val civility: String?

	/**
	 * The gender of the patient.
	 */
	override val gender: Gender?

	/**
	 * The birth sex of the patient.
	 */
	public val birthSex: Gender?

	/**
	 * The id of the patient this patient has been merged with.
	 */
	public val mergeToPatientId: String?

	/**
	 * The ids of the patients that have been merged inside this patient.
	 */
	public val mergedIds: Set<String>

	/**
	 * An alias of the person, nickname, ...
	 */
	public val alias: String?

	/**
	 * Whether the patient is active.
	 */
	public val active: Boolean

	/**
	 * When not active, the reason for deactivation.
	 */
	public val deactivationReason: String

	/**
	 * Deactivation date of the patient.
	 */
	public val deactivationDate: Int?

	/**
	 * Social security inscription number.
	 */
	public val ssin: String?

	/**
	 * Lastname at birth (can be different from the current name).
	 */
	public val maidenName: String?

	/**
	 * Lastname of the spouse for a married woman.
	 */
	public val spouseName: String?

	/**
	 * Lastname of the partner.
	 */
	public val partnerName: String?

	/**
	 * The personal/marital status of the patient.
	 */
	public val personalStatus: PersonalStatus?

	/**
	 * The birthdate encoded as a fuzzy date on 8 positions (YYYYMMDD).
	 */
	public val dateOfBirth: Int?

	/**
	 * The date of death encoded as a fuzzy date on 8 positions (YYYYMMDD).
	 */
	public val dateOfDeath: Int?

	/**
	 * Timestamp of the latest validation of the eID of the person.
	 */
	public val timestampOfLatestEidReading: Long?

	/**
	 * The place of birth.
	 */
	public val placeOfBirth: String?

	/**
	 * The place of death.
	 */
	public val placeOfDeath: String?

	/**
	 * Whether the patient is deceased.
	 */
	public val deceased: Boolean?

	/**
	 * The level of education (college degree, undergraduate, phd).
	 */
	public val education: String?

	/**
	 * The current professional activity.
	 */
	public val profession: String?

	/**
	 * Localized text notes (can be confidential).
	 */
	public val notes: List<Annotation>

	/**
	 * A text note (can be confidential, encrypted by default).
	 */
	public val note: String?

	/**
	 * An administrative note, not confidential.
	 */
	public val administrativeNote: String?

	/**
	 * The nationality of the patient.
	 */
	public val nationality: String?

	/**
	 * The race of the patient.
	 */
	public val race: String?

	/**
	 * The ethnicity of the patient.
	 */
	public val ethnicity: String?

	/**
	 * The id of the user that usually handles this patient.
	 */
	public val preferredUserId: String?

	/**
	 * List of insurance coverages.
	 */
	public val insurabilities: List<Insurability>

	/**
	 * List of partners, or persons of contact.
	 */
	public val partnerships: List<Partnership>

	/**
	 * Links between this patient and healthcare parties.
	 */
	public val patientHealthCareParties: List<PatientHealthCareParty>

	/**
	 * Financial information used to reimburse the patient.
	 */
	public val financialInstitutionInformation: List<FinancialInstitutionInformation>

	/**
	 * Contracts between the patient and the healthcare entity.
	 */
	public val medicalHouseContracts: List<MedicalHouseContract>

	/**
	 * Codified list of professions exercised by this patient.
	 */
	public val patientProfessions: List<CodeStub>

	/**
	 * Extra parameters.
	 */
	public val parameters: Map<String, List<String>>

	/**
	 * Extra properties.
	 */
	public val properties: Set<PropertyStub>

	/**
	 * For each couple of HcParties, the AES exchange key.
	 */
	override val hcPartyKeys: Map<String, List<HexString>>

	/**
	 * Extra AES exchange keys, indexed by the owner of the pair and target data owner id.
	 */
	override val aesExchangeKeys:
		Map<AesExchangeKeyEntryKeyString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>

	/**
	 * Keys used to transfer ownership of encrypted data between key pairs.
	 */
	override val transferKeys:
		Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>

	/**
	 * Shamir partitions of the private key.
	 */
	override val privateKeyShamirPartitions: Map<String, HexString>

	/**
	 * The public key of this patient, used to encrypt data for this patient.
	 */
	override val publicKey: SpkiHexString?

	/**
	 * Public keys for OAEP with SHA-256 encryption.
	 */
	override val publicKeysForOaepWithSha256: Set<SpkiHexString>

	/**
	 * The secret patient key, encrypted in the patient's own AES key.
	 */
	override val secretForeignKeys: Set<String>

	/**
	 * The patient id encrypted in the delegates' AES keys.
	 */
	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	/**
	 * The delegations giving access to connected healthcare information.
	 */
	override val delegations: Map<String, Set<Delegation>>

	/**
	 * The keys used to encrypt this entity when stored encrypted.
	 */
	override val encryptionKeys: Map<String, Set<Delegation>>

	/**
	 * The base64-encoded encrypted fields of this entity.
	 */
	override val encryptedSelf: Base64String?

	/**
	 * The security metadata of the entity.
	 */
	override val securityMetadata: SecurityMetadata?

	/**
	 * Properties related to crypto actor functionality.
	 */
	override val cryptoActorProperties: Set<DecryptedPropertyStub>

	/**
	 * Always null for patients.
	 */
	override val parentId: Nothing?
}

/**
 * Represents a patient in the iCure platform. A patient is a person who receives healthcare
 * services.
 * This entity stores personal, administrative, and medical information about the patient, and
 * supports
 * end-to-end encryption of sensitive data.
 * /
 */
@Serializable
public data class DecryptedPatient(
	/**
	 * The Id of the patient. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The patient's identifiers, used by the client to uniquely identify the patient.
	 */
	@param:DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	/**
	 * The revision of the patient in the database, used for conflict management / optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * The timestamp (unix epoch in ms) of creation.
	 */
	override val created: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) of the latest modification.
	 */
	override val modified: Long? = null,
	/**
	 * The id of the User that created this patient.
	 */
	override val author: String? = null,
	/**
	 * The id of the HealthcareParty that is responsible for this patient.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the patient as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular patient.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The firstname (name) of the patient.
	 */
	override val firstName: String? = null,
	/**
	 * The lastname (surname) of the patient.
	 */
	override val lastName: String? = null,
	/**
	 * The list of all names of the patient, ordered by preference of use.
	 */
	@param:DefaultValue("emptyList()")
	override val names: List<PersonName> = emptyList(),
	/**
	 * The name of the company this patient is member of.
	 */
	override val companyName: String? = null,
	/**
	 * The list of languages spoken by the patient ordered by fluency (alpha-2 code).
	 */
	@param:DefaultValue("emptyList()")
	override val languages: List<String> = emptyList(),
	/**
	 * The list of addresses (with address type).
	 */
	@param:DefaultValue("emptyList()")
	override val addresses: List<DecryptedAddress> = emptyList(),
	/**
	 * Mr., Ms., Pr., Dr. ...
	 */
	override val civility: String? = null,
	/**
	 * The gender of the patient.
	 */
	@param:DefaultValue("com.icure.cardinal.sdk.model.embed.Gender.Unknown")
	override val gender: Gender? = Gender.Unknown,
	/**
	 * The birth sex of the patient.
	 */
	@param:DefaultValue("com.icure.cardinal.sdk.model.embed.Gender.Unknown")
	override val birthSex: Gender? = Gender.Unknown,
	/**
	 * The id of the patient this patient has been merged with.
	 */
	override val mergeToPatientId: String? = null,
	/**
	 * The ids of the patients that have been merged inside this patient.
	 */
	@param:DefaultValue("emptySet()")
	override val mergedIds: Set<String> = emptySet(),
	/**
	 * An alias of the person, nickname, ...
	 */
	override val alias: String? = null,
	/**
	 * Whether the patient is active.
	 */
	@param:DefaultValue("true")
	override val active: Boolean = true,
	/**
	 * When not active, the reason for deactivation.
	 */
	@param:DefaultValue("\"none\"")
	override val deactivationReason: String = "none",
	/**
	 * Deactivation date of the patient.
	 */
	override val deactivationDate: Int? = null,
	/**
	 * Social security inscription number.
	 */
	override val ssin: String? = null,
	/**
	 * Lastname at birth (can be different from the current name).
	 */
	override val maidenName: String? = null,
	/**
	 * Lastname of the spouse for a married woman.
	 */
	override val spouseName: String? = null,
	/**
	 * Lastname of the partner.
	 */
	override val partnerName: String? = null,
	/**
	 * The personal/marital status of the patient.
	 */
	@param:DefaultValue("com.icure.cardinal.sdk.model.embed.PersonalStatus.Unknown")
	override val personalStatus: PersonalStatus? = PersonalStatus.Unknown,
	/**
	 * The birthdate encoded as a fuzzy date on 8 positions (YYYYMMDD).
	 */
	override val dateOfBirth: Int? = null,
	/**
	 * The date of death encoded as a fuzzy date on 8 positions (YYYYMMDD).
	 */
	override val dateOfDeath: Int? = null,
	/**
	 * Timestamp of the latest validation of the eID of the person.
	 */
	override val timestampOfLatestEidReading: Long? = null,
	/**
	 * The place of birth.
	 */
	override val placeOfBirth: String? = null,
	/**
	 * The place of death.
	 */
	override val placeOfDeath: String? = null,
	/**
	 * Whether the patient is deceased.
	 */
	override val deceased: Boolean? = null,
	/**
	 * The level of education (college degree, undergraduate, phd).
	 */
	override val education: String? = null,
	/**
	 * The current professional activity.
	 */
	override val profession: String? = null,
	/**
	 * Localized text notes (can be confidential).
	 */
	@param:DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
	/**
	 * A text note (can be confidential, encrypted by default).
	 */
	override val note: String? = null,
	/**
	 * An administrative note, not confidential.
	 */
	override val administrativeNote: String? = null,
	/**
	 * The nationality of the patient.
	 */
	override val nationality: String? = null,
	/**
	 * The race of the patient.
	 */
	override val race: String? = null,
	/**
	 * The ethnicity of the patient.
	 */
	override val ethnicity: String? = null,
	/**
	 * The id of the user that usually handles this patient.
	 */
	override val preferredUserId: String? = null,
	/**
	 * List of insurance coverages.
	 */
	@param:DefaultValue("emptyList()")
	override val insurabilities: List<DecryptedInsurability> = emptyList(),
	/**
	 * List of partners, or persons of contact.
	 */
	@param:DefaultValue("emptyList()")
	override val partnerships: List<Partnership> = emptyList(),
	/**
	 * Links between this patient and healthcare parties.
	 */
	@param:DefaultValue("emptyList()")
	override val patientHealthCareParties: List<DecryptedPatientHealthCareParty> = emptyList(),
	/**
	 * Financial information used to reimburse the patient.
	 */
	@param:DefaultValue("emptyList()")
	override val financialInstitutionInformation: List<DecryptedFinancialInstitutionInformation> =
		emptyList(),
	/**
	 * Contracts between the patient and the healthcare entity.
	 */
	@param:DefaultValue("emptyList()")
	override val medicalHouseContracts: List<DecryptedMedicalHouseContract> = emptyList(),
	/**
	 * Codified list of professions exercised by this patient.
	 */
	@param:DefaultValue("emptyList()")
	override val patientProfessions: List<CodeStub> = emptyList(),
	/**
	 * Extra parameters.
	 */
	@param:DefaultValue("emptyMap()")
	override val parameters: Map<String, List<String>> = emptyMap(),
	/**
	 * Extra properties.
	 */
	@param:DefaultValue("emptySet()")
	override val properties: Set<DecryptedPropertyStub> = emptySet(),
	/**
	 * For each couple of HcParties, the AES exchange key.
	 */
	@param:DefaultValue("emptyMap()")
	override val hcPartyKeys: Map<String, List<HexString>> = emptyMap(),
	/**
	 * Extra AES exchange keys, indexed by the owner of the pair and target data owner id.
	 */
	@param:DefaultValue("emptyMap()")
	override val aesExchangeKeys: Map<AesExchangeKeyEntryKeyString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> =
		emptyMap(),
	/**
	 * Keys used to transfer ownership of encrypted data between key pairs.
	 */
	@param:DefaultValue("emptyMap()")
	override val transferKeys: Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> =
		emptyMap(),
	/**
	 * Shamir partitions of the private key.
	 */
	@param:DefaultValue("emptyMap()")
	override val privateKeyShamirPartitions: Map<String, HexString> = emptyMap(),
	/**
	 * The public key of this patient, used to encrypt data for this patient.
	 */
	override val publicKey: SpkiHexString? = null,
	/**
	 * Public keys for OAEP with SHA-256 encryption.
	 */
	@param:DefaultValue("emptySet()")
	override val publicKeysForOaepWithSha256: Set<SpkiHexString> = emptySet(),
	/**
	 * The secret patient key, encrypted in the patient's own AES key.
	 */
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	/**
	 * The patient id encrypted in the delegates' AES keys.
	 */
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The delegations giving access to connected healthcare information.
	 */
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The keys used to encrypt this entity when stored encrypted.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The base64-encoded encrypted fields of this entity.
	 */
	override val encryptedSelf: Base64String? = null,
	/**
	 * The security metadata of the entity.
	 */
	override val securityMetadata: SecurityMetadata? = null,
	/**
	 * Properties related to crypto actor functionality.
	 */
	override val cryptoActorProperties: Set<DecryptedPropertyStub> = emptySet(),
	/**
	 * Always null for patients.
	 */
	override val parentId: Nothing? = null,
) : Patient

/**
 * Represents a patient in the iCure platform. A patient is a person who receives healthcare
 * services.
 * This entity stores personal, administrative, and medical information about the patient, and
 * supports
 * end-to-end encryption of sensitive data.
 * /
 */
@Serializable
public data class EncryptedPatient(
	/**
	 * The Id of the patient. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The patient's identifiers, used by the client to uniquely identify the patient.
	 */
	@param:DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	/**
	 * The revision of the patient in the database, used for conflict management / optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * The timestamp (unix epoch in ms) of creation.
	 */
	override val created: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) of the latest modification.
	 */
	override val modified: Long? = null,
	/**
	 * The id of the User that created this patient.
	 */
	override val author: String? = null,
	/**
	 * The id of the HealthcareParty that is responsible for this patient.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the patient as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular patient.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The firstname (name) of the patient.
	 */
	override val firstName: String? = null,
	/**
	 * The lastname (surname) of the patient.
	 */
	override val lastName: String? = null,
	/**
	 * The list of all names of the patient, ordered by preference of use.
	 */
	@param:DefaultValue("emptyList()")
	override val names: List<PersonName> = emptyList(),
	/**
	 * The name of the company this patient is member of.
	 */
	override val companyName: String? = null,
	/**
	 * The list of languages spoken by the patient ordered by fluency (alpha-2 code).
	 */
	@param:DefaultValue("emptyList()")
	override val languages: List<String> = emptyList(),
	/**
	 * The list of addresses (with address type).
	 */
	@param:DefaultValue("emptyList()")
	override val addresses: List<EncryptedAddress> = emptyList(),
	/**
	 * Mr., Ms., Pr., Dr. ...
	 */
	override val civility: String? = null,
	/**
	 * The gender of the patient.
	 */
	@param:DefaultValue("com.icure.cardinal.sdk.model.embed.Gender.Unknown")
	override val gender: Gender? = Gender.Unknown,
	/**
	 * The birth sex of the patient.
	 */
	@param:DefaultValue("com.icure.cardinal.sdk.model.embed.Gender.Unknown")
	override val birthSex: Gender? = Gender.Unknown,
	/**
	 * The id of the patient this patient has been merged with.
	 */
	override val mergeToPatientId: String? = null,
	/**
	 * The ids of the patients that have been merged inside this patient.
	 */
	@param:DefaultValue("emptySet()")
	override val mergedIds: Set<String> = emptySet(),
	/**
	 * An alias of the person, nickname, ...
	 */
	override val alias: String? = null,
	/**
	 * Whether the patient is active.
	 */
	@param:DefaultValue("true")
	override val active: Boolean = true,
	/**
	 * When not active, the reason for deactivation.
	 */
	@param:DefaultValue("\"none\"")
	override val deactivationReason: String = "none",
	/**
	 * Deactivation date of the patient.
	 */
	override val deactivationDate: Int? = null,
	/**
	 * Social security inscription number.
	 */
	override val ssin: String? = null,
	/**
	 * Lastname at birth (can be different from the current name).
	 */
	override val maidenName: String? = null,
	/**
	 * Lastname of the spouse for a married woman.
	 */
	override val spouseName: String? = null,
	/**
	 * Lastname of the partner.
	 */
	override val partnerName: String? = null,
	/**
	 * The personal/marital status of the patient.
	 */
	@param:DefaultValue("com.icure.cardinal.sdk.model.embed.PersonalStatus.Unknown")
	override val personalStatus: PersonalStatus? = PersonalStatus.Unknown,
	/**
	 * The birthdate encoded as a fuzzy date on 8 positions (YYYYMMDD).
	 */
	override val dateOfBirth: Int? = null,
	/**
	 * The date of death encoded as a fuzzy date on 8 positions (YYYYMMDD).
	 */
	override val dateOfDeath: Int? = null,
	/**
	 * Timestamp of the latest validation of the eID of the person.
	 */
	override val timestampOfLatestEidReading: Long? = null,
	/**
	 * The place of birth.
	 */
	override val placeOfBirth: String? = null,
	/**
	 * The place of death.
	 */
	override val placeOfDeath: String? = null,
	/**
	 * Whether the patient is deceased.
	 */
	override val deceased: Boolean? = null,
	/**
	 * The level of education (college degree, undergraduate, phd).
	 */
	override val education: String? = null,
	/**
	 * The current professional activity.
	 */
	override val profession: String? = null,
	/**
	 * Localized text notes (can be confidential).
	 */
	@param:DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
	/**
	 * A text note (can be confidential, encrypted by default).
	 */
	override val note: String? = null,
	/**
	 * An administrative note, not confidential.
	 */
	override val administrativeNote: String? = null,
	/**
	 * The nationality of the patient.
	 */
	override val nationality: String? = null,
	/**
	 * The race of the patient.
	 */
	override val race: String? = null,
	/**
	 * The ethnicity of the patient.
	 */
	override val ethnicity: String? = null,
	/**
	 * The id of the user that usually handles this patient.
	 */
	override val preferredUserId: String? = null,
	/**
	 * List of insurance coverages.
	 */
	@param:DefaultValue("emptyList()")
	override val insurabilities: List<EncryptedInsurability> = emptyList(),
	/**
	 * List of partners, or persons of contact.
	 */
	@param:DefaultValue("emptyList()")
	override val partnerships: List<Partnership> = emptyList(),
	/**
	 * Links between this patient and healthcare parties.
	 */
	@param:DefaultValue("emptyList()")
	override val patientHealthCareParties: List<EncryptedPatientHealthCareParty> = emptyList(),
	/**
	 * Financial information used to reimburse the patient.
	 */
	@param:DefaultValue("emptyList()")
	override val financialInstitutionInformation: List<EncryptedFinancialInstitutionInformation> =
		emptyList(),
	/**
	 * Contracts between the patient and the healthcare entity.
	 */
	@param:DefaultValue("emptyList()")
	override val medicalHouseContracts: List<EncryptedMedicalHouseContract> = emptyList(),
	/**
	 * Codified list of professions exercised by this patient.
	 */
	@param:DefaultValue("emptyList()")
	override val patientProfessions: List<CodeStub> = emptyList(),
	/**
	 * Extra parameters.
	 */
	@param:DefaultValue("emptyMap()")
	override val parameters: Map<String, List<String>> = emptyMap(),
	/**
	 * Extra properties.
	 */
	@param:DefaultValue("emptySet()")
	override val properties: Set<EncryptedPropertyStub> = emptySet(),
	/**
	 * For each couple of HcParties, the AES exchange key.
	 */
	@param:DefaultValue("emptyMap()")
	override val hcPartyKeys: Map<String, List<HexString>> = emptyMap(),
	/**
	 * Extra AES exchange keys, indexed by the owner of the pair and target data owner id.
	 */
	@param:DefaultValue("emptyMap()")
	override val aesExchangeKeys: Map<AesExchangeKeyEntryKeyString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> =
		emptyMap(),
	/**
	 * Keys used to transfer ownership of encrypted data between key pairs.
	 */
	@param:DefaultValue("emptyMap()")
	override val transferKeys: Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> =
		emptyMap(),
	/**
	 * Shamir partitions of the private key.
	 */
	@param:DefaultValue("emptyMap()")
	override val privateKeyShamirPartitions: Map<String, HexString> = emptyMap(),
	/**
	 * The public key of this patient, used to encrypt data for this patient.
	 */
	override val publicKey: SpkiHexString? = null,
	/**
	 * Public keys for OAEP with SHA-256 encryption.
	 */
	@param:DefaultValue("emptySet()")
	override val publicKeysForOaepWithSha256: Set<SpkiHexString> = emptySet(),
	/**
	 * The secret patient key, encrypted in the patient's own AES key.
	 */
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	/**
	 * The patient id encrypted in the delegates' AES keys.
	 */
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The delegations giving access to connected healthcare information.
	 */
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The keys used to encrypt this entity when stored encrypted.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The base64-encoded encrypted fields of this entity.
	 */
	override val encryptedSelf: Base64String? = null,
	/**
	 * The security metadata of the entity.
	 */
	override val securityMetadata: SecurityMetadata? = null,
	/**
	 * Properties related to crypto actor functionality.
	 */
	override val cryptoActorProperties: Set<DecryptedPropertyStub> = emptySet(),
	/**
	 * Always null for patients.
	 */
	override val parentId: Nothing? = null,
) : Patient
