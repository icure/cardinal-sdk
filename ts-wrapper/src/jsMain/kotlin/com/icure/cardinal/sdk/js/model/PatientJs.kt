// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.CryptoActorJs
import com.icure.cardinal.sdk.js.model.base.HasEncryptionMetadataJs
import com.icure.cardinal.sdk.js.model.base.ICureDocumentJs
import com.icure.cardinal.sdk.js.model.base.IdentifierJs
import com.icure.cardinal.sdk.js.model.base.PersonJs
import com.icure.cardinal.sdk.js.model.base.StoredDocumentJs
import com.icure.cardinal.sdk.js.model.embed.AnnotationJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedAddressJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedFinancialInstitutionInformationJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedInsurabilityJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedMedicalHouseContractJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedPatientHealthCarePartyJs
import com.icure.cardinal.sdk.js.model.embed.DelegationJs
import com.icure.cardinal.sdk.js.model.embed.EncryptableJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedAddressJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedFinancialInstitutionInformationJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedInsurabilityJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedMedicalHouseContractJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedPatientHealthCarePartyJs
import com.icure.cardinal.sdk.js.model.embed.FinancialInstitutionInformationJs
import com.icure.cardinal.sdk.js.model.embed.InsurabilityJs
import com.icure.cardinal.sdk.js.model.embed.MedicalHouseContractJs
import com.icure.cardinal.sdk.js.model.embed.PartnershipJs
import com.icure.cardinal.sdk.js.model.embed.PatientHealthCarePartyJs
import com.icure.cardinal.sdk.js.model.embed.PersonNameJs
import com.icure.cardinal.sdk.js.model.embed.SecurityMetadataJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Nothing
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("Patient")
public sealed external interface PatientJs : StoredDocumentJs, ICureDocumentJs<String>, PersonJs,
		HasEncryptionMetadataJs, EncryptableJs, CryptoActorJs {
	public val identifier: Array<out IdentifierJs>

	public val birthSex: String?

	public val mergeToPatientId: String?

	public val mergedIds: Array<out String>

	public val alias: String?

	public val active: Boolean

	public val deactivationReason: String

	public val deactivationDate: Double?

	public val ssin: String?

	public val maidenName: String?

	public val spouseName: String?

	public val partnerName: String?

	public val personalStatus: String?

	public val dateOfBirth: Double?

	public val dateOfDeath: Double?

	public val timestampOfLatestEidReading: Double?

	public val placeOfBirth: String?

	public val placeOfDeath: String?

	public val deceased: Boolean?

	public val education: String?

	public val profession: String?

	public val notes: Array<out AnnotationJs>

	public val note: String?

	public val administrativeNote: String?

	public val nationality: String?

	public val race: String?

	public val ethnicity: String?

	public val preferredUserId: String?

	public val insurabilities: Array<out InsurabilityJs>

	public val partnerships: Array<out PartnershipJs>

	public val patientHealthCareParties: Array<out PatientHealthCarePartyJs>

	public val financialInstitutionInformation: Array<out FinancialInstitutionInformationJs>

	public val medicalHouseContracts: Array<out MedicalHouseContractJs>

	public val patientProfessions: Array<out CodeStubJs>

	public val parameters: Record<String, out Array<out String>>

	public val properties: Array<out PropertyStubJs>

	public val isEncrypted: Boolean
}

@JsName("DecryptedPatient")
public external class DecryptedPatientJs(
	partial: dynamic,
) : PatientJs {
	override val id: String

	override val identifier: Array<IdentifierJs>

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val deletionDate: Double?

	override val firstName: String?

	override val lastName: String?

	override val names: Array<PersonNameJs>

	override val companyName: String?

	override val languages: Array<String>

	override val addresses: Array<DecryptedAddressJs>

	override val civility: String?

	override val gender: String?

	override val birthSex: String?

	override val mergeToPatientId: String?

	override val mergedIds: Array<String>

	override val alias: String?

	override val active: Boolean

	override val deactivationReason: String

	override val deactivationDate: Double?

	override val ssin: String?

	override val maidenName: String?

	override val spouseName: String?

	override val partnerName: String?

	override val personalStatus: String?

	override val dateOfBirth: Double?

	override val dateOfDeath: Double?

	override val timestampOfLatestEidReading: Double?

	override val placeOfBirth: String?

	override val placeOfDeath: String?

	override val deceased: Boolean?

	override val education: String?

	override val profession: String?

	override val notes: Array<AnnotationJs>

	override val note: String?

	override val administrativeNote: String?

	override val nationality: String?

	override val race: String?

	override val ethnicity: String?

	override val preferredUserId: String?

	override val insurabilities: Array<DecryptedInsurabilityJs>

	override val partnerships: Array<PartnershipJs>

	override val patientHealthCareParties: Array<DecryptedPatientHealthCarePartyJs>

	override val financialInstitutionInformation: Array<DecryptedFinancialInstitutionInformationJs>

	override val medicalHouseContracts: Array<DecryptedMedicalHouseContractJs>

	override val patientProfessions: Array<CodeStubJs>

	override val parameters: Record<String, Array<String>>

	override val properties: Array<DecryptedPropertyStubJs>

	override val hcPartyKeys: Record<String, Array<String>>

	override val aesExchangeKeys: Record<String, Record<String, Record<String, String>>>

	override val transferKeys: Record<String, Record<String, String>>

	override val privateKeyShamirPartitions: Record<String, String>

	override val publicKey: String?

	override val publicKeysForOaepWithSha256: Array<String>

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val cryptoActorProperties: Array<DecryptedPropertyStubJs>

	override val parentId: Nothing?

	override val isEncrypted: Boolean

	override val ktClass: String
}

@JsName("EncryptedPatient")
public external class EncryptedPatientJs(
	partial: dynamic,
) : PatientJs {
	override val id: String

	override val identifier: Array<IdentifierJs>

	override val rev: String?

	override val created: Double?

	override val modified: Double?

	override val author: String?

	override val responsible: String?

	override val tags: Array<CodeStubJs>

	override val codes: Array<CodeStubJs>

	override val deletionDate: Double?

	override val firstName: String?

	override val lastName: String?

	override val names: Array<PersonNameJs>

	override val companyName: String?

	override val languages: Array<String>

	override val addresses: Array<EncryptedAddressJs>

	override val civility: String?

	override val gender: String?

	override val birthSex: String?

	override val mergeToPatientId: String?

	override val mergedIds: Array<String>

	override val alias: String?

	override val active: Boolean

	override val deactivationReason: String

	override val deactivationDate: Double?

	override val ssin: String?

	override val maidenName: String?

	override val spouseName: String?

	override val partnerName: String?

	override val personalStatus: String?

	override val dateOfBirth: Double?

	override val dateOfDeath: Double?

	override val timestampOfLatestEidReading: Double?

	override val placeOfBirth: String?

	override val placeOfDeath: String?

	override val deceased: Boolean?

	override val education: String?

	override val profession: String?

	override val notes: Array<AnnotationJs>

	override val note: String?

	override val administrativeNote: String?

	override val nationality: String?

	override val race: String?

	override val ethnicity: String?

	override val preferredUserId: String?

	override val insurabilities: Array<EncryptedInsurabilityJs>

	override val partnerships: Array<PartnershipJs>

	override val patientHealthCareParties: Array<EncryptedPatientHealthCarePartyJs>

	override val financialInstitutionInformation: Array<EncryptedFinancialInstitutionInformationJs>

	override val medicalHouseContracts: Array<EncryptedMedicalHouseContractJs>

	override val patientProfessions: Array<CodeStubJs>

	override val parameters: Record<String, Array<String>>

	override val properties: Array<EncryptedPropertyStubJs>

	override val hcPartyKeys: Record<String, Array<String>>

	override val aesExchangeKeys: Record<String, Record<String, Record<String, String>>>

	override val transferKeys: Record<String, Record<String, String>>

	override val privateKeyShamirPartitions: Record<String, String>

	override val publicKey: String?

	override val publicKeysForOaepWithSha256: Array<String>

	override val secretForeignKeys: Array<String>

	override val cryptedForeignKeys: Record<String, Array<DelegationJs>>

	override val delegations: Record<String, Array<DelegationJs>>

	override val encryptionKeys: Record<String, Array<DelegationJs>>

	override val encryptedSelf: String?

	override val securityMetadata: SecurityMetadataJs?

	override val cryptoActorProperties: Array<DecryptedPropertyStubJs>

	override val parentId: Nothing?

	override val isEncrypted: Boolean

	override val ktClass: String
}
