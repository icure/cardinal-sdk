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
import com.icure.cardinal.sdk.model.embed.DecryptedEmploymentInfo
import com.icure.cardinal.sdk.model.embed.DecryptedSchoolingInfo
import com.icure.cardinal.sdk.model.embed.EmploymentInfo
import com.icure.cardinal.sdk.model.embed.EncryptedEmploymentInfo
import com.icure.cardinal.sdk.model.embed.EncryptedSchoolingInfo
import com.icure.cardinal.sdk.model.embed.SchoolingInfo
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import kotlin.ByteArray
import com.icure.cardinal.sdk.model.embed.DeactivationReason

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface Patient :
	StoredDocument,
	ICureDocument<String>,
	Person,
	HasEncryptionMetadata,
	Encryptable,
	CryptoActor {
	override val id: String

	public val identifier: List<Identifier>

	override val rev: String?

	override val created: Long?

	override val modified: Long?

	override val author: String?

	override val responsible: String?

	override val tags: Set<CodeStub>

	override val codes: Set<CodeStub>

	override val deletionDate: Long?

	override val firstName: String?

	override val lastName: String?

	override val names: List<PersonName>

	override val companyName: String?

	override val languages: List<String>

	override val addresses: List<Address>

	override val civility: String?

	override val gender: Gender?

	public val birthSex: Gender?

	public val mergeToPatientId: String?

	public val mergedIds: Set<String>

	public val alias: String?

	public val active: Boolean

	public val deactivationReason: String

	public val deactivationDate: Int?

	public val ssin: String?

	public val maidenName: String?

	public val spouseName: String?

	public val partnerName: String?

	public val personalStatus: PersonalStatus?

	public val dateOfBirth: Int?

	public val dateOfDeath: Int?

	public val timestampOfLatestEidReading: Long?

	public val placeOfBirth: String?

	public val placeOfDeath: String?

	public val deceased: Boolean?

	public val education: String?

	public val profession: String?

	public val notes: List<Annotation>

	public val note: String?

	public val administrativeNote: String?

	public val nationality: String?

	public val race: String?

	public val ethnicity: String?

	public val preferredUserId: String?

	public val insurabilities: List<Insurability>

	public val partnerships: List<Partnership>

	public val patientHealthCareParties: List<PatientHealthCareParty>

	public val financialInstitutionInformation: List<FinancialInstitutionInformation>

	public val medicalHouseContracts: List<MedicalHouseContract>

	public val patientProfessions: List<CodeStub>

	public val parameters: Map<String, List<String>>

	public val properties: Set<PropertyStub>

	override val hcPartyKeys: Map<String, List<HexString>>

	override val aesExchangeKeys:
		Map<AesExchangeKeyEntryKeyString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>

	override val transferKeys:
		Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>

	override val privateKeyShamirPartitions: Map<String, HexString>

	override val publicKey: SpkiHexString?

	override val publicKeysForOaepWithSha256: Set<SpkiHexString>

	override val secretForeignKeys: Set<String>

	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	override val delegations: Map<String, Set<Delegation>>

	override val encryptionKeys: Map<String, Set<Delegation>>

	override val encryptedSelf: Base64String?

	override val securityMetadata: SecurityMetadata?

	override val cryptoActorProperties: Set<DecryptedPropertyStub>?

	override val parentId: Nothing?
	// region Patient-Patient
	companion object {
		const val KRAKEN_QUALIFIED_NAME = "org.taktik.icure.entities.Patient"
	}
	// endregion
}

@Serializable
data class DecryptedPatient(
	override val id: String,
	@param:DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val deletionDate: Long? = null,
	override val firstName: String? = null,
	override val lastName: String? = null,
	@param:DefaultValue("emptyList()")
	override val names: List<PersonName> = emptyList(),
	override val companyName: String? = null,
	@param:DefaultValue("emptyList()")
	override val languages: List<String> = emptyList(),
	@param:DefaultValue("emptyList()")
	override val addresses: List<DecryptedAddress> = emptyList(),
	override val civility: String? = null,
	@param:DefaultValue("com.icure.cardinal.sdk.model.embed.Gender.Unknown")
	override val gender: Gender? = Gender.Unknown,
	@param:DefaultValue("com.icure.cardinal.sdk.model.embed.Gender.Unknown")
	override val birthSex: Gender? = Gender.Unknown,
	override val mergeToPatientId: String? = null,
	@param:DefaultValue("emptySet()")
	override val mergedIds: Set<String> = emptySet(),
	override val alias: String? = null,
	@param:DefaultValue("true")
	override val active: Boolean = true,
	@param:DefaultValue("\"none\"")
	override val deactivationReason: String = "none",
	override val deactivationDate: Int? = null,
	override val ssin: String? = null,
	override val maidenName: String? = null,
	override val spouseName: String? = null,
	override val partnerName: String? = null,
	@param:DefaultValue("com.icure.cardinal.sdk.model.embed.PersonalStatus.Unknown")
	override val personalStatus: PersonalStatus? = PersonalStatus.Unknown,
	override val dateOfBirth: Int? = null,
	override val dateOfDeath: Int? = null,
	override val timestampOfLatestEidReading: Long? = null,
	override val placeOfBirth: String? = null,
	override val placeOfDeath: String? = null,
	override val deceased: Boolean? = null,
	override val education: String? = null,
	override val profession: String? = null,
	@param:DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
	override val note: String? = null,
	override val administrativeNote: String? = null,
	override val nationality: String? = null,
	override val race: String? = null,
	override val ethnicity: String? = null,
	override val preferredUserId: String? = null,
	@param:DefaultValue("emptyList()")
	override val insurabilities: List<DecryptedInsurability> = emptyList(),
	@param:DefaultValue("emptyList()")
	override val partnerships: List<Partnership> = emptyList(),
	@param:DefaultValue("emptyList()")
	override val patientHealthCareParties: List<DecryptedPatientHealthCareParty> = emptyList(),
	@param:DefaultValue("emptyList()")
	override val financialInstitutionInformation: List<DecryptedFinancialInstitutionInformation> =
		emptyList(),
	@param:DefaultValue("emptyList()")
	override val medicalHouseContracts: List<DecryptedMedicalHouseContract> = emptyList(),
	@param:DefaultValue("emptyList()")
	override val patientProfessions: List<CodeStub> = emptyList(),
	@param:DefaultValue("emptyMap()")
	override val parameters: Map<String, List<String>> = emptyMap(),
	@param:DefaultValue("emptySet()")
	override val properties: Set<DecryptedPropertyStub> = emptySet(),
	@param:DefaultValue("emptyMap()")
	override val hcPartyKeys: Map<String, List<HexString>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val aesExchangeKeys: Map<AesExchangeKeyEntryKeyString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> =
		emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val transferKeys: Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> =
		emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val privateKeyShamirPartitions: Map<String, HexString> = emptyMap(),
	override val publicKey: SpkiHexString? = null,
	@param:DefaultValue("emptySet()")
	override val publicKeysForOaepWithSha256: Set<SpkiHexString> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
	override val cryptoActorProperties: Set<DecryptedPropertyStub>? = null,
	override val parentId: Nothing? = null,
) : Patient {
	// region Patient-DecryptedPatient
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): DecryptedPatient =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

@Serializable
data class EncryptedPatient(
	override val id: String,
	@param:DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val deletionDate: Long? = null,
	override val firstName: String? = null,
	override val lastName: String? = null,
	@param:DefaultValue("emptyList()")
	override val names: List<PersonName> = emptyList(),
	override val companyName: String? = null,
	@param:DefaultValue("emptyList()")
	override val languages: List<String> = emptyList(),
	@param:DefaultValue("emptyList()")
	override val addresses: List<EncryptedAddress> = emptyList(),
	override val civility: String? = null,
	@param:DefaultValue("com.icure.cardinal.sdk.model.embed.Gender.Unknown")
	override val gender: Gender? = Gender.Unknown,
	@param:DefaultValue("com.icure.cardinal.sdk.model.embed.Gender.Unknown")
	override val birthSex: Gender? = Gender.Unknown,
	override val mergeToPatientId: String? = null,
	@param:DefaultValue("emptySet()")
	override val mergedIds: Set<String> = emptySet(),
	override val alias: String? = null,
	@param:DefaultValue("true")
	override val active: Boolean = true,
	@param:DefaultValue("\"none\"")
	override val deactivationReason: String = "none",
	override val deactivationDate: Int? = null,
	override val ssin: String? = null,
	override val maidenName: String? = null,
	override val spouseName: String? = null,
	override val partnerName: String? = null,
	@param:DefaultValue("com.icure.cardinal.sdk.model.embed.PersonalStatus.Unknown")
	override val personalStatus: PersonalStatus? = PersonalStatus.Unknown,
	override val dateOfBirth: Int? = null,
	override val dateOfDeath: Int? = null,
	override val timestampOfLatestEidReading: Long? = null,
	override val placeOfBirth: String? = null,
	override val placeOfDeath: String? = null,
	override val deceased: Boolean? = null,
	override val education: String? = null,
	override val profession: String? = null,
	@param:DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
	override val note: String? = null,
	override val administrativeNote: String? = null,
	override val nationality: String? = null,
	override val race: String? = null,
	override val ethnicity: String? = null,
	override val preferredUserId: String? = null,
	@param:DefaultValue("emptyList()")
	override val insurabilities: List<EncryptedInsurability> = emptyList(),
	@param:DefaultValue("emptyList()")
	override val partnerships: List<Partnership> = emptyList(),
	@param:DefaultValue("emptyList()")
	override val patientHealthCareParties: List<EncryptedPatientHealthCareParty> = emptyList(),
	@param:DefaultValue("emptyList()")
	override val financialInstitutionInformation: List<EncryptedFinancialInstitutionInformation> =
		emptyList(),
	@param:DefaultValue("emptyList()")
	override val medicalHouseContracts: List<EncryptedMedicalHouseContract> = emptyList(),
	@param:DefaultValue("emptyList()")
	override val patientProfessions: List<CodeStub> = emptyList(),
	@param:DefaultValue("emptyMap()")
	override val parameters: Map<String, List<String>> = emptyMap(),
	@param:DefaultValue("emptySet()")
	override val properties: Set<EncryptedPropertyStub> = emptySet(),
	@param:DefaultValue("emptyMap()")
	override val hcPartyKeys: Map<String, List<HexString>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val aesExchangeKeys: Map<AesExchangeKeyEntryKeyString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> =
		emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val transferKeys: Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> =
		emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val privateKeyShamirPartitions: Map<String, HexString> = emptyMap(),
	override val publicKey: SpkiHexString? = null,
	@param:DefaultValue("emptySet()")
	override val publicKeysForOaepWithSha256: Set<SpkiHexString> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
	override val cryptoActorProperties: Set<DecryptedPropertyStub>? = null,
	override val parentId: Nothing? = null,
) : Patient {
	// region Patient-EncryptedPatient
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): EncryptedPatient =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}
