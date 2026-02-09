// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.IdentifierJs
import com.icure.cardinal.sdk.js.model.base.codeStub_fromJs
import com.icure.cardinal.sdk.js.model.base.codeStub_toJs
import com.icure.cardinal.sdk.js.model.base.identifier_fromJs
import com.icure.cardinal.sdk.js.model.base.identifier_toJs
import com.icure.cardinal.sdk.js.model.embed.AnnotationJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedAddressJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedFinancialInstitutionInformationJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedInsurabilityJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedMedicalHouseContractJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedPatientHealthCarePartyJs
import com.icure.cardinal.sdk.js.model.embed.DelegationJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedAddressJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedFinancialInstitutionInformationJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedInsurabilityJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedMedicalHouseContractJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedPatientHealthCarePartyJs
import com.icure.cardinal.sdk.js.model.embed.PartnershipJs
import com.icure.cardinal.sdk.js.model.embed.PersonNameJs
import com.icure.cardinal.sdk.js.model.embed.address_fromJs
import com.icure.cardinal.sdk.js.model.embed.address_toJs
import com.icure.cardinal.sdk.js.model.embed.annotation_fromJs
import com.icure.cardinal.sdk.js.model.embed.annotation_toJs
import com.icure.cardinal.sdk.js.model.embed.delegation_fromJs
import com.icure.cardinal.sdk.js.model.embed.delegation_toJs
import com.icure.cardinal.sdk.js.model.embed.financialInstitutionInformation_fromJs
import com.icure.cardinal.sdk.js.model.embed.financialInstitutionInformation_toJs
import com.icure.cardinal.sdk.js.model.embed.insurability_fromJs
import com.icure.cardinal.sdk.js.model.embed.insurability_toJs
import com.icure.cardinal.sdk.js.model.embed.medicalHouseContract_fromJs
import com.icure.cardinal.sdk.js.model.embed.medicalHouseContract_toJs
import com.icure.cardinal.sdk.js.model.embed.partnership_fromJs
import com.icure.cardinal.sdk.js.model.embed.partnership_toJs
import com.icure.cardinal.sdk.js.model.embed.patientHealthCareParty_fromJs
import com.icure.cardinal.sdk.js.model.embed.patientHealthCareParty_toJs
import com.icure.cardinal.sdk.js.model.embed.personName_fromJs
import com.icure.cardinal.sdk.js.model.embed.personName_toJs
import com.icure.cardinal.sdk.js.model.embed.securityMetadata_fromJs
import com.icure.cardinal.sdk.js.model.embed.securityMetadata_toJs
import com.icure.cardinal.sdk.js.model.specializations.aesExchangeKeyEncryptionKeypairIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.specializations.aesExchangeKeyEncryptionKeypairIdentifier_toJs
import com.icure.cardinal.sdk.js.model.specializations.aesExchangeKeyEntryKeyString_fromJs
import com.icure.cardinal.sdk.js.model.specializations.aesExchangeKeyEntryKeyString_toJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.js.model.specializations.hexString_fromJs
import com.icure.cardinal.sdk.js.model.specializations.hexString_toJs
import com.icure.cardinal.sdk.js.model.specializations.spkiHexString_fromJs
import com.icure.cardinal.sdk.js.model.specializations.spkiHexString_toJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.embed.Annotation
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.model.embed.DecryptedFinancialInstitutionInformation
import com.icure.cardinal.sdk.model.embed.DecryptedInsurability
import com.icure.cardinal.sdk.model.embed.DecryptedMedicalHouseContract
import com.icure.cardinal.sdk.model.embed.DecryptedPatientHealthCareParty
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.EncryptedAddress
import com.icure.cardinal.sdk.model.embed.EncryptedFinancialInstitutionInformation
import com.icure.cardinal.sdk.model.embed.EncryptedInsurability
import com.icure.cardinal.sdk.model.embed.EncryptedMedicalHouseContract
import com.icure.cardinal.sdk.model.embed.EncryptedPatientHealthCareParty
import com.icure.cardinal.sdk.model.embed.Gender
import com.icure.cardinal.sdk.model.embed.Partnership
import com.icure.cardinal.sdk.model.embed.PersonName
import com.icure.cardinal.sdk.model.embed.PersonalStatus
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEntryKeyString
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

@Suppress("UNUSED_VARIABLE")
public fun patient_toJs(obj: DecryptedPatient): DecryptedPatientJs {
	val id = obj.id
	val identifier = listToArray(
		obj.identifier,
		{ x1: Identifier ->
			identifier_toJs(x1)
		},
	)
	val rev = nullToUndefined(
		obj.rev
	)
	val created = nullToUndefined(
		longToNumber(obj.created)
	)
	val modified = nullToUndefined(
		longToNumber(obj.modified)
	)
	val author = nullToUndefined(
		obj.author
	)
	val responsible = nullToUndefined(
		obj.responsible
	)
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val codes = setToArray(
		obj.codes,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val firstName = nullToUndefined(
		obj.firstName
	)
	val lastName = nullToUndefined(
		obj.lastName
	)
	val names = listToArray(
		obj.names,
		{ x1: PersonName ->
			personName_toJs(x1)
		},
	)
	val companyName = nullToUndefined(
		obj.companyName
	)
	val languages = listToArray(
		obj.languages,
		{ x1: String ->
			x1
		},
	)
	val addresses = listToArray(
		obj.addresses,
		{ x1: DecryptedAddress ->
			address_toJs(x1)
		},
	)
	val civility = nullToUndefined(
		obj.civility
	)
	val gender = nullToUndefined(
		obj.gender?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val birthSex = nullToUndefined(
		obj.birthSex?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val mergeToPatientId = nullToUndefined(
		obj.mergeToPatientId
	)
	val mergedIds = setToArray(
		obj.mergedIds,
		{ x1: String ->
			x1
		},
	)
	val alias = nullToUndefined(
		obj.alias
	)
	val active = obj.active
	val deactivationReason = obj.deactivationReason
	val deactivationDate = nullToUndefined(
		intToNumber(obj.deactivationDate)
	)
	val ssin = nullToUndefined(
		obj.ssin
	)
	val maidenName = nullToUndefined(
		obj.maidenName
	)
	val spouseName = nullToUndefined(
		obj.spouseName
	)
	val partnerName = nullToUndefined(
		obj.partnerName
	)
	val personalStatus = nullToUndefined(
		obj.personalStatus?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val dateOfBirth = nullToUndefined(
		intToNumber(obj.dateOfBirth)
	)
	val dateOfDeath = nullToUndefined(
		intToNumber(obj.dateOfDeath)
	)
	val timestampOfLatestEidReading = nullToUndefined(
		longToNumber(obj.timestampOfLatestEidReading)
	)
	val placeOfBirth = nullToUndefined(
		obj.placeOfBirth
	)
	val placeOfDeath = nullToUndefined(
		obj.placeOfDeath
	)
	val deceased = nullToUndefined(
		obj.deceased
	)
	val education = nullToUndefined(
		obj.education
	)
	val profession = nullToUndefined(
		obj.profession
	)
	val notes = listToArray(
		obj.notes,
		{ x1: Annotation ->
			annotation_toJs(x1)
		},
	)
	val note = nullToUndefined(
		obj.note
	)
	val administrativeNote = nullToUndefined(
		obj.administrativeNote
	)
	val nationality = nullToUndefined(
		obj.nationality
	)
	val race = nullToUndefined(
		obj.race
	)
	val ethnicity = nullToUndefined(
		obj.ethnicity
	)
	val preferredUserId = nullToUndefined(
		obj.preferredUserId
	)
	val insurabilities = listToArray(
		obj.insurabilities,
		{ x1: DecryptedInsurability ->
			insurability_toJs(x1)
		},
	)
	val partnerships = listToArray(
		obj.partnerships,
		{ x1: Partnership ->
			partnership_toJs(x1)
		},
	)
	val patientHealthCareParties = listToArray(
		obj.patientHealthCareParties,
		{ x1: DecryptedPatientHealthCareParty ->
			patientHealthCareParty_toJs(x1)
		},
	)
	val financialInstitutionInformation = listToArray(
		obj.financialInstitutionInformation,
		{ x1: DecryptedFinancialInstitutionInformation ->
			financialInstitutionInformation_toJs(x1)
		},
	)
	val medicalHouseContracts = listToArray(
		obj.medicalHouseContracts,
		{ x1: DecryptedMedicalHouseContract ->
			medicalHouseContract_toJs(x1)
		},
	)
	val patientProfessions = listToArray(
		obj.patientProfessions,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val parameters = mapToObject(
		obj.parameters,
		{ x1: String ->
			x1
		},
		{ x1: List<String> ->
			listToArray(
				x1,
				{ x2: String ->
					x2
				},
			)
		},
	)
	val properties = setToArray(
		obj.properties,
		{ x1: DecryptedPropertyStub ->
			propertyStub_toJs(x1)
		},
	)
	val hcPartyKeys = mapToObject(
		obj.hcPartyKeys,
		{ x1: String ->
			x1
		},
		{ x1: List<HexString> ->
			listToArray(
				x1,
				{ x2: HexString ->
					hexString_toJs(x2)
				},
			)
		},
	)
	val aesExchangeKeys = mapToObject(
		obj.aesExchangeKeys,
		{ x1: AesExchangeKeyEntryKeyString ->
			aesExchangeKeyEntryKeyString_toJs(x1)
		},
		{ x1: Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> ->
			mapToObject(
				x1,
				{ x2: String ->
					x2
				},
				{ x2: Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString> ->
					mapToObject(
						x2,
						{ x3: AesExchangeKeyEncryptionKeypairIdentifier ->
							aesExchangeKeyEncryptionKeypairIdentifier_toJs(x3)
						},
						{ x3: HexString ->
							hexString_toJs(x3)
						},
					)
				},
			)
		},
	)
	val transferKeys = mapToObject(
		obj.transferKeys,
		{ x1: AesExchangeKeyEncryptionKeypairIdentifier ->
			aesExchangeKeyEncryptionKeypairIdentifier_toJs(x1)
		},
		{ x1: Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString> ->
			mapToObject(
				x1,
				{ x2: AesExchangeKeyEncryptionKeypairIdentifier ->
					aesExchangeKeyEncryptionKeypairIdentifier_toJs(x2)
				},
				{ x2: HexString ->
					hexString_toJs(x2)
				},
			)
		},
	)
	val privateKeyShamirPartitions = mapToObject(
		obj.privateKeyShamirPartitions,
		{ x1: String ->
			x1
		},
		{ x1: HexString ->
			hexString_toJs(x1)
		},
	)
	val publicKey = nullToUndefined(
		obj.publicKey?.let { nonNull1 ->
			spkiHexString_toJs(nonNull1)
		}
	)
	val publicKeysForOaepWithSha256 = setToArray(
		obj.publicKeysForOaepWithSha256,
		{ x1: SpkiHexString ->
			spkiHexString_toJs(x1)
		},
	)
	val secretForeignKeys = setToArray(
		obj.secretForeignKeys,
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = mapToObject(
		obj.cryptedForeignKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val delegations = mapToObject(
		obj.delegations,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptionKeys = mapToObject(
		obj.encryptionKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	val securityMetadata = nullToUndefined(
		obj.securityMetadata?.let { nonNull1 ->
			securityMetadata_toJs(nonNull1)
		}
	)
	val cryptoActorProperties = nullToUndefined(
		setToArray(
			obj.cryptoActorProperties,
			{ x1: DecryptedPropertyStub ->
				propertyStub_toJs(x1)
			},
		)
	)
	val parentId = nullToUndefined(
		obj.parentId
	)
	return DecryptedPatientJs(js("{" +
		"id:id," +
		"identifier:identifier," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"tags:tags," +
		"codes:codes," +
		"deletionDate:deletionDate," +
		"firstName:firstName," +
		"lastName:lastName," +
		"names:names," +
		"companyName:companyName," +
		"languages:languages," +
		"addresses:addresses," +
		"civility:civility," +
		"gender:gender," +
		"birthSex:birthSex," +
		"mergeToPatientId:mergeToPatientId," +
		"mergedIds:mergedIds," +
		"alias:alias," +
		"active:active," +
		"deactivationReason:deactivationReason," +
		"deactivationDate:deactivationDate," +
		"ssin:ssin," +
		"maidenName:maidenName," +
		"spouseName:spouseName," +
		"partnerName:partnerName," +
		"personalStatus:personalStatus," +
		"dateOfBirth:dateOfBirth," +
		"dateOfDeath:dateOfDeath," +
		"timestampOfLatestEidReading:timestampOfLatestEidReading," +
		"placeOfBirth:placeOfBirth," +
		"placeOfDeath:placeOfDeath," +
		"deceased:deceased," +
		"education:education," +
		"profession:profession," +
		"notes:notes," +
		"note:note," +
		"administrativeNote:administrativeNote," +
		"nationality:nationality," +
		"race:race," +
		"ethnicity:ethnicity," +
		"preferredUserId:preferredUserId," +
		"insurabilities:insurabilities," +
		"partnerships:partnerships," +
		"patientHealthCareParties:patientHealthCareParties," +
		"financialInstitutionInformation:financialInstitutionInformation," +
		"medicalHouseContracts:medicalHouseContracts," +
		"patientProfessions:patientProfessions," +
		"parameters:parameters," +
		"properties:properties," +
		"hcPartyKeys:hcPartyKeys," +
		"aesExchangeKeys:aesExchangeKeys," +
		"transferKeys:transferKeys," +
		"privateKeyShamirPartitions:privateKeyShamirPartitions," +
		"publicKey:publicKey," +
		"publicKeysForOaepWithSha256:publicKeysForOaepWithSha256," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata," +
		"cryptoActorProperties:cryptoActorProperties," +
		"parentId:parentId" +
	"}"))
}

public fun patient_fromJs(obj: DecryptedPatientJs): DecryptedPatient {
	val id = obj.id
	val identifier = arrayToList(
		obj.identifier,
		"obj.identifier",
		{ x1: IdentifierJs ->
			identifier_fromJs(x1)
		},
	)
	val rev = undefinedToNull(obj.rev)
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val author = undefinedToNull(obj.author)
	val responsible = undefinedToNull(obj.responsible)
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val codes = arrayToSet(
		obj.codes,
		"obj.codes",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val firstName = undefinedToNull(obj.firstName)
	val lastName = undefinedToNull(obj.lastName)
	val names = arrayToList(
		obj.names,
		"obj.names",
		{ x1: PersonNameJs ->
			personName_fromJs(x1)
		},
	)
	val companyName = undefinedToNull(obj.companyName)
	val languages = arrayToList(
		obj.languages,
		"obj.languages",
		{ x1: String ->
			x1
		},
	)
	val addresses = arrayToList(
		obj.addresses,
		"obj.addresses",
		{ x1: DecryptedAddressJs ->
			address_fromJs(x1)
		},
	)
	val civility = undefinedToNull(obj.civility)
	val gender = obj.gender?.let { nonNull1 ->
		Gender.valueOf(nonNull1)
	}
	val birthSex = obj.birthSex?.let { nonNull1 ->
		Gender.valueOf(nonNull1)
	}
	val mergeToPatientId = undefinedToNull(obj.mergeToPatientId)
	val mergedIds = arrayToSet(
		obj.mergedIds,
		"obj.mergedIds",
		{ x1: String ->
			x1
		},
	)
	val alias = undefinedToNull(obj.alias)
	val active = obj.active
	val deactivationReason = obj.deactivationReason
	val deactivationDate = numberToInt(obj.deactivationDate, "obj.deactivationDate")
	val ssin = undefinedToNull(obj.ssin)
	val maidenName = undefinedToNull(obj.maidenName)
	val spouseName = undefinedToNull(obj.spouseName)
	val partnerName = undefinedToNull(obj.partnerName)
	val personalStatus = obj.personalStatus?.let { nonNull1 ->
		PersonalStatus.valueOf(nonNull1)
	}
	val dateOfBirth = numberToInt(obj.dateOfBirth, "obj.dateOfBirth")
	val dateOfDeath = numberToInt(obj.dateOfDeath, "obj.dateOfDeath")
	val timestampOfLatestEidReading = numberToLong(obj.timestampOfLatestEidReading,
			"obj.timestampOfLatestEidReading")
	val placeOfBirth = undefinedToNull(obj.placeOfBirth)
	val placeOfDeath = undefinedToNull(obj.placeOfDeath)
	val deceased = undefinedToNull(obj.deceased)
	val education = undefinedToNull(obj.education)
	val profession = undefinedToNull(obj.profession)
	val notes = arrayToList(
		obj.notes,
		"obj.notes",
		{ x1: AnnotationJs ->
			annotation_fromJs(x1)
		},
	)
	val note = undefinedToNull(obj.note)
	val administrativeNote = undefinedToNull(obj.administrativeNote)
	val nationality = undefinedToNull(obj.nationality)
	val race = undefinedToNull(obj.race)
	val ethnicity = undefinedToNull(obj.ethnicity)
	val preferredUserId = undefinedToNull(obj.preferredUserId)
	val insurabilities = arrayToList(
		obj.insurabilities,
		"obj.insurabilities",
		{ x1: DecryptedInsurabilityJs ->
			insurability_fromJs(x1)
		},
	)
	val partnerships = arrayToList(
		obj.partnerships,
		"obj.partnerships",
		{ x1: PartnershipJs ->
			partnership_fromJs(x1)
		},
	)
	val patientHealthCareParties = arrayToList(
		obj.patientHealthCareParties,
		"obj.patientHealthCareParties",
		{ x1: DecryptedPatientHealthCarePartyJs ->
			patientHealthCareParty_fromJs(x1)
		},
	)
	val financialInstitutionInformation = arrayToList(
		obj.financialInstitutionInformation,
		"obj.financialInstitutionInformation",
		{ x1: DecryptedFinancialInstitutionInformationJs ->
			financialInstitutionInformation_fromJs(x1)
		},
	)
	val medicalHouseContracts = arrayToList(
		obj.medicalHouseContracts,
		"obj.medicalHouseContracts",
		{ x1: DecryptedMedicalHouseContractJs ->
			medicalHouseContract_fromJs(x1)
		},
	)
	val patientProfessions = arrayToList(
		obj.patientProfessions,
		"obj.patientProfessions",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val parameters = objectToMap(
		obj.parameters,
		"obj.parameters",
		{ x1: String ->
			x1
		},
		{ x1: Array<String> ->
			arrayToList(
				x1,
				"x1",
				{ x2: String ->
					x2
				},
			)
		},
	)
	val properties = arrayToSet(
		obj.properties,
		"obj.properties",
		{ x1: DecryptedPropertyStubJs ->
			propertyStub_fromJs(x1)
		},
	)
	val hcPartyKeys = objectToMap(
		obj.hcPartyKeys,
		"obj.hcPartyKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<String> ->
			arrayToList(
				x1,
				"x1",
				{ x2: String ->
					hexString_fromJs(x2)
				},
			)
		},
	)
	val aesExchangeKeys = objectToMap(
		obj.aesExchangeKeys,
		"obj.aesExchangeKeys",
		{ x1: String ->
			aesExchangeKeyEntryKeyString_fromJs(x1)
		},
		{ x1: Record<String, Record<String, String>> ->
			objectToMap(
				x1,
				"x1",
				{ x2: String ->
					x2
				},
				{ x2: Record<String, String> ->
					objectToMap(
						x2,
						"x2",
						{ x3: String ->
							aesExchangeKeyEncryptionKeypairIdentifier_fromJs(x3)
						},
						{ x3: String ->
							hexString_fromJs(x3)
						},
					)
				},
			)
		},
	)
	val transferKeys = objectToMap(
		obj.transferKeys,
		"obj.transferKeys",
		{ x1: String ->
			aesExchangeKeyEncryptionKeypairIdentifier_fromJs(x1)
		},
		{ x1: Record<String, String> ->
			objectToMap(
				x1,
				"x1",
				{ x2: String ->
					aesExchangeKeyEncryptionKeypairIdentifier_fromJs(x2)
				},
				{ x2: String ->
					hexString_fromJs(x2)
				},
			)
		},
	)
	val privateKeyShamirPartitions = objectToMap(
		obj.privateKeyShamirPartitions,
		"obj.privateKeyShamirPartitions",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			hexString_fromJs(x1)
		},
	)
	val publicKey = obj.publicKey?.let { nonNull1 ->
		spkiHexString_fromJs(nonNull1)
	}
	val publicKeysForOaepWithSha256 = arrayToSet(
		obj.publicKeysForOaepWithSha256,
		"obj.publicKeysForOaepWithSha256",
		{ x1: String ->
			spkiHexString_fromJs(x1)
		},
	)
	val secretForeignKeys = arrayToSet(
		obj.secretForeignKeys,
		"obj.secretForeignKeys",
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = objectToMap(
		obj.cryptedForeignKeys,
		"obj.cryptedForeignKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val delegations = objectToMap(
		obj.delegations,
		"obj.delegations",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptionKeys = objectToMap(
		obj.encryptionKeys,
		"obj.encryptionKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_fromJs(nonNull1)
	}
	val cryptoActorProperties = arrayToSet(
		obj.cryptoActorProperties,
		"obj.cryptoActorProperties",
		{ x1: DecryptedPropertyStubJs ->
			propertyStub_fromJs(x1)
		},
	)
	val parentId = obj.parentId
	return DecryptedPatient(
		id = id,
		identifier = identifier,
		rev = rev,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		tags = tags,
		codes = codes,
		deletionDate = deletionDate,
		firstName = firstName,
		lastName = lastName,
		names = names,
		companyName = companyName,
		languages = languages,
		addresses = addresses,
		civility = civility,
		gender = gender,
		birthSex = birthSex,
		mergeToPatientId = mergeToPatientId,
		mergedIds = mergedIds,
		alias = alias,
		active = active,
		deactivationReason = deactivationReason,
		deactivationDate = deactivationDate,
		ssin = ssin,
		maidenName = maidenName,
		spouseName = spouseName,
		partnerName = partnerName,
		personalStatus = personalStatus,
		dateOfBirth = dateOfBirth,
		dateOfDeath = dateOfDeath,
		timestampOfLatestEidReading = timestampOfLatestEidReading,
		placeOfBirth = placeOfBirth,
		placeOfDeath = placeOfDeath,
		deceased = deceased,
		education = education,
		profession = profession,
		notes = notes,
		note = note,
		administrativeNote = administrativeNote,
		nationality = nationality,
		race = race,
		ethnicity = ethnicity,
		preferredUserId = preferredUserId,
		insurabilities = insurabilities,
		partnerships = partnerships,
		patientHealthCareParties = patientHealthCareParties,
		financialInstitutionInformation = financialInstitutionInformation,
		medicalHouseContracts = medicalHouseContracts,
		patientProfessions = patientProfessions,
		parameters = parameters,
		properties = properties,
		hcPartyKeys = hcPartyKeys,
		aesExchangeKeys = aesExchangeKeys,
		transferKeys = transferKeys,
		privateKeyShamirPartitions = privateKeyShamirPartitions,
		publicKey = publicKey,
		publicKeysForOaepWithSha256 = publicKeysForOaepWithSha256,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
		cryptoActorProperties = cryptoActorProperties,
		parentId = parentId,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun patient_toJs(obj: EncryptedPatient): EncryptedPatientJs {
	val id = obj.id
	val identifier = listToArray(
		obj.identifier,
		{ x1: Identifier ->
			identifier_toJs(x1)
		},
	)
	val rev = nullToUndefined(
		obj.rev
	)
	val created = nullToUndefined(
		longToNumber(obj.created)
	)
	val modified = nullToUndefined(
		longToNumber(obj.modified)
	)
	val author = nullToUndefined(
		obj.author
	)
	val responsible = nullToUndefined(
		obj.responsible
	)
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val codes = setToArray(
		obj.codes,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val firstName = nullToUndefined(
		obj.firstName
	)
	val lastName = nullToUndefined(
		obj.lastName
	)
	val names = listToArray(
		obj.names,
		{ x1: PersonName ->
			personName_toJs(x1)
		},
	)
	val companyName = nullToUndefined(
		obj.companyName
	)
	val languages = listToArray(
		obj.languages,
		{ x1: String ->
			x1
		},
	)
	val addresses = listToArray(
		obj.addresses,
		{ x1: EncryptedAddress ->
			address_toJs(x1)
		},
	)
	val civility = nullToUndefined(
		obj.civility
	)
	val gender = nullToUndefined(
		obj.gender?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val birthSex = nullToUndefined(
		obj.birthSex?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val mergeToPatientId = nullToUndefined(
		obj.mergeToPatientId
	)
	val mergedIds = setToArray(
		obj.mergedIds,
		{ x1: String ->
			x1
		},
	)
	val alias = nullToUndefined(
		obj.alias
	)
	val active = obj.active
	val deactivationReason = obj.deactivationReason
	val deactivationDate = nullToUndefined(
		intToNumber(obj.deactivationDate)
	)
	val ssin = nullToUndefined(
		obj.ssin
	)
	val maidenName = nullToUndefined(
		obj.maidenName
	)
	val spouseName = nullToUndefined(
		obj.spouseName
	)
	val partnerName = nullToUndefined(
		obj.partnerName
	)
	val personalStatus = nullToUndefined(
		obj.personalStatus?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val dateOfBirth = nullToUndefined(
		intToNumber(obj.dateOfBirth)
	)
	val dateOfDeath = nullToUndefined(
		intToNumber(obj.dateOfDeath)
	)
	val timestampOfLatestEidReading = nullToUndefined(
		longToNumber(obj.timestampOfLatestEidReading)
	)
	val placeOfBirth = nullToUndefined(
		obj.placeOfBirth
	)
	val placeOfDeath = nullToUndefined(
		obj.placeOfDeath
	)
	val deceased = nullToUndefined(
		obj.deceased
	)
	val education = nullToUndefined(
		obj.education
	)
	val profession = nullToUndefined(
		obj.profession
	)
	val notes = listToArray(
		obj.notes,
		{ x1: Annotation ->
			annotation_toJs(x1)
		},
	)
	val note = nullToUndefined(
		obj.note
	)
	val administrativeNote = nullToUndefined(
		obj.administrativeNote
	)
	val nationality = nullToUndefined(
		obj.nationality
	)
	val race = nullToUndefined(
		obj.race
	)
	val ethnicity = nullToUndefined(
		obj.ethnicity
	)
	val preferredUserId = nullToUndefined(
		obj.preferredUserId
	)
	val insurabilities = listToArray(
		obj.insurabilities,
		{ x1: EncryptedInsurability ->
			insurability_toJs(x1)
		},
	)
	val partnerships = listToArray(
		obj.partnerships,
		{ x1: Partnership ->
			partnership_toJs(x1)
		},
	)
	val patientHealthCareParties = listToArray(
		obj.patientHealthCareParties,
		{ x1: EncryptedPatientHealthCareParty ->
			patientHealthCareParty_toJs(x1)
		},
	)
	val financialInstitutionInformation = listToArray(
		obj.financialInstitutionInformation,
		{ x1: EncryptedFinancialInstitutionInformation ->
			financialInstitutionInformation_toJs(x1)
		},
	)
	val medicalHouseContracts = listToArray(
		obj.medicalHouseContracts,
		{ x1: EncryptedMedicalHouseContract ->
			medicalHouseContract_toJs(x1)
		},
	)
	val patientProfessions = listToArray(
		obj.patientProfessions,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val parameters = mapToObject(
		obj.parameters,
		{ x1: String ->
			x1
		},
		{ x1: List<String> ->
			listToArray(
				x1,
				{ x2: String ->
					x2
				},
			)
		},
	)
	val properties = setToArray(
		obj.properties,
		{ x1: EncryptedPropertyStub ->
			propertyStub_toJs(x1)
		},
	)
	val hcPartyKeys = mapToObject(
		obj.hcPartyKeys,
		{ x1: String ->
			x1
		},
		{ x1: List<HexString> ->
			listToArray(
				x1,
				{ x2: HexString ->
					hexString_toJs(x2)
				},
			)
		},
	)
	val aesExchangeKeys = mapToObject(
		obj.aesExchangeKeys,
		{ x1: AesExchangeKeyEntryKeyString ->
			aesExchangeKeyEntryKeyString_toJs(x1)
		},
		{ x1: Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> ->
			mapToObject(
				x1,
				{ x2: String ->
					x2
				},
				{ x2: Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString> ->
					mapToObject(
						x2,
						{ x3: AesExchangeKeyEncryptionKeypairIdentifier ->
							aesExchangeKeyEncryptionKeypairIdentifier_toJs(x3)
						},
						{ x3: HexString ->
							hexString_toJs(x3)
						},
					)
				},
			)
		},
	)
	val transferKeys = mapToObject(
		obj.transferKeys,
		{ x1: AesExchangeKeyEncryptionKeypairIdentifier ->
			aesExchangeKeyEncryptionKeypairIdentifier_toJs(x1)
		},
		{ x1: Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString> ->
			mapToObject(
				x1,
				{ x2: AesExchangeKeyEncryptionKeypairIdentifier ->
					aesExchangeKeyEncryptionKeypairIdentifier_toJs(x2)
				},
				{ x2: HexString ->
					hexString_toJs(x2)
				},
			)
		},
	)
	val privateKeyShamirPartitions = mapToObject(
		obj.privateKeyShamirPartitions,
		{ x1: String ->
			x1
		},
		{ x1: HexString ->
			hexString_toJs(x1)
		},
	)
	val publicKey = nullToUndefined(
		obj.publicKey?.let { nonNull1 ->
			spkiHexString_toJs(nonNull1)
		}
	)
	val publicKeysForOaepWithSha256 = setToArray(
		obj.publicKeysForOaepWithSha256,
		{ x1: SpkiHexString ->
			spkiHexString_toJs(x1)
		},
	)
	val secretForeignKeys = setToArray(
		obj.secretForeignKeys,
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = mapToObject(
		obj.cryptedForeignKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val delegations = mapToObject(
		obj.delegations,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptionKeys = mapToObject(
		obj.encryptionKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	val securityMetadata = nullToUndefined(
		obj.securityMetadata?.let { nonNull1 ->
			securityMetadata_toJs(nonNull1)
		}
	)
	val cryptoActorProperties = nullToUndefined(
		setToArray(
			obj.cryptoActorProperties,
			{ x1: DecryptedPropertyStub ->
				propertyStub_toJs(x1)
			},
		)
	)
	val parentId = nullToUndefined(
		obj.parentId
	)
	return EncryptedPatientJs(js("{" +
		"id:id," +
		"identifier:identifier," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"tags:tags," +
		"codes:codes," +
		"deletionDate:deletionDate," +
		"firstName:firstName," +
		"lastName:lastName," +
		"names:names," +
		"companyName:companyName," +
		"languages:languages," +
		"addresses:addresses," +
		"civility:civility," +
		"gender:gender," +
		"birthSex:birthSex," +
		"mergeToPatientId:mergeToPatientId," +
		"mergedIds:mergedIds," +
		"alias:alias," +
		"active:active," +
		"deactivationReason:deactivationReason," +
		"deactivationDate:deactivationDate," +
		"ssin:ssin," +
		"maidenName:maidenName," +
		"spouseName:spouseName," +
		"partnerName:partnerName," +
		"personalStatus:personalStatus," +
		"dateOfBirth:dateOfBirth," +
		"dateOfDeath:dateOfDeath," +
		"timestampOfLatestEidReading:timestampOfLatestEidReading," +
		"placeOfBirth:placeOfBirth," +
		"placeOfDeath:placeOfDeath," +
		"deceased:deceased," +
		"education:education," +
		"profession:profession," +
		"notes:notes," +
		"note:note," +
		"administrativeNote:administrativeNote," +
		"nationality:nationality," +
		"race:race," +
		"ethnicity:ethnicity," +
		"preferredUserId:preferredUserId," +
		"insurabilities:insurabilities," +
		"partnerships:partnerships," +
		"patientHealthCareParties:patientHealthCareParties," +
		"financialInstitutionInformation:financialInstitutionInformation," +
		"medicalHouseContracts:medicalHouseContracts," +
		"patientProfessions:patientProfessions," +
		"parameters:parameters," +
		"properties:properties," +
		"hcPartyKeys:hcPartyKeys," +
		"aesExchangeKeys:aesExchangeKeys," +
		"transferKeys:transferKeys," +
		"privateKeyShamirPartitions:privateKeyShamirPartitions," +
		"publicKey:publicKey," +
		"publicKeysForOaepWithSha256:publicKeysForOaepWithSha256," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata," +
		"cryptoActorProperties:cryptoActorProperties," +
		"parentId:parentId" +
	"}"))
}

public fun patient_fromJs(obj: EncryptedPatientJs): EncryptedPatient {
	val id = obj.id
	val identifier = arrayToList(
		obj.identifier,
		"obj.identifier",
		{ x1: IdentifierJs ->
			identifier_fromJs(x1)
		},
	)
	val rev = undefinedToNull(obj.rev)
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val author = undefinedToNull(obj.author)
	val responsible = undefinedToNull(obj.responsible)
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val codes = arrayToSet(
		obj.codes,
		"obj.codes",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val firstName = undefinedToNull(obj.firstName)
	val lastName = undefinedToNull(obj.lastName)
	val names = arrayToList(
		obj.names,
		"obj.names",
		{ x1: PersonNameJs ->
			personName_fromJs(x1)
		},
	)
	val companyName = undefinedToNull(obj.companyName)
	val languages = arrayToList(
		obj.languages,
		"obj.languages",
		{ x1: String ->
			x1
		},
	)
	val addresses = arrayToList(
		obj.addresses,
		"obj.addresses",
		{ x1: EncryptedAddressJs ->
			address_fromJs(x1)
		},
	)
	val civility = undefinedToNull(obj.civility)
	val gender = obj.gender?.let { nonNull1 ->
		Gender.valueOf(nonNull1)
	}
	val birthSex = obj.birthSex?.let { nonNull1 ->
		Gender.valueOf(nonNull1)
	}
	val mergeToPatientId = undefinedToNull(obj.mergeToPatientId)
	val mergedIds = arrayToSet(
		obj.mergedIds,
		"obj.mergedIds",
		{ x1: String ->
			x1
		},
	)
	val alias = undefinedToNull(obj.alias)
	val active = obj.active
	val deactivationReason = obj.deactivationReason
	val deactivationDate = numberToInt(obj.deactivationDate, "obj.deactivationDate")
	val ssin = undefinedToNull(obj.ssin)
	val maidenName = undefinedToNull(obj.maidenName)
	val spouseName = undefinedToNull(obj.spouseName)
	val partnerName = undefinedToNull(obj.partnerName)
	val personalStatus = obj.personalStatus?.let { nonNull1 ->
		PersonalStatus.valueOf(nonNull1)
	}
	val dateOfBirth = numberToInt(obj.dateOfBirth, "obj.dateOfBirth")
	val dateOfDeath = numberToInt(obj.dateOfDeath, "obj.dateOfDeath")
	val timestampOfLatestEidReading = numberToLong(obj.timestampOfLatestEidReading,
			"obj.timestampOfLatestEidReading")
	val placeOfBirth = undefinedToNull(obj.placeOfBirth)
	val placeOfDeath = undefinedToNull(obj.placeOfDeath)
	val deceased = undefinedToNull(obj.deceased)
	val education = undefinedToNull(obj.education)
	val profession = undefinedToNull(obj.profession)
	val notes = arrayToList(
		obj.notes,
		"obj.notes",
		{ x1: AnnotationJs ->
			annotation_fromJs(x1)
		},
	)
	val note = undefinedToNull(obj.note)
	val administrativeNote = undefinedToNull(obj.administrativeNote)
	val nationality = undefinedToNull(obj.nationality)
	val race = undefinedToNull(obj.race)
	val ethnicity = undefinedToNull(obj.ethnicity)
	val preferredUserId = undefinedToNull(obj.preferredUserId)
	val insurabilities = arrayToList(
		obj.insurabilities,
		"obj.insurabilities",
		{ x1: EncryptedInsurabilityJs ->
			insurability_fromJs(x1)
		},
	)
	val partnerships = arrayToList(
		obj.partnerships,
		"obj.partnerships",
		{ x1: PartnershipJs ->
			partnership_fromJs(x1)
		},
	)
	val patientHealthCareParties = arrayToList(
		obj.patientHealthCareParties,
		"obj.patientHealthCareParties",
		{ x1: EncryptedPatientHealthCarePartyJs ->
			patientHealthCareParty_fromJs(x1)
		},
	)
	val financialInstitutionInformation = arrayToList(
		obj.financialInstitutionInformation,
		"obj.financialInstitutionInformation",
		{ x1: EncryptedFinancialInstitutionInformationJs ->
			financialInstitutionInformation_fromJs(x1)
		},
	)
	val medicalHouseContracts = arrayToList(
		obj.medicalHouseContracts,
		"obj.medicalHouseContracts",
		{ x1: EncryptedMedicalHouseContractJs ->
			medicalHouseContract_fromJs(x1)
		},
	)
	val patientProfessions = arrayToList(
		obj.patientProfessions,
		"obj.patientProfessions",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val parameters = objectToMap(
		obj.parameters,
		"obj.parameters",
		{ x1: String ->
			x1
		},
		{ x1: Array<String> ->
			arrayToList(
				x1,
				"x1",
				{ x2: String ->
					x2
				},
			)
		},
	)
	val properties = arrayToSet(
		obj.properties,
		"obj.properties",
		{ x1: EncryptedPropertyStubJs ->
			propertyStub_fromJs(x1)
		},
	)
	val hcPartyKeys = objectToMap(
		obj.hcPartyKeys,
		"obj.hcPartyKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<String> ->
			arrayToList(
				x1,
				"x1",
				{ x2: String ->
					hexString_fromJs(x2)
				},
			)
		},
	)
	val aesExchangeKeys = objectToMap(
		obj.aesExchangeKeys,
		"obj.aesExchangeKeys",
		{ x1: String ->
			aesExchangeKeyEntryKeyString_fromJs(x1)
		},
		{ x1: Record<String, Record<String, String>> ->
			objectToMap(
				x1,
				"x1",
				{ x2: String ->
					x2
				},
				{ x2: Record<String, String> ->
					objectToMap(
						x2,
						"x2",
						{ x3: String ->
							aesExchangeKeyEncryptionKeypairIdentifier_fromJs(x3)
						},
						{ x3: String ->
							hexString_fromJs(x3)
						},
					)
				},
			)
		},
	)
	val transferKeys = objectToMap(
		obj.transferKeys,
		"obj.transferKeys",
		{ x1: String ->
			aesExchangeKeyEncryptionKeypairIdentifier_fromJs(x1)
		},
		{ x1: Record<String, String> ->
			objectToMap(
				x1,
				"x1",
				{ x2: String ->
					aesExchangeKeyEncryptionKeypairIdentifier_fromJs(x2)
				},
				{ x2: String ->
					hexString_fromJs(x2)
				},
			)
		},
	)
	val privateKeyShamirPartitions = objectToMap(
		obj.privateKeyShamirPartitions,
		"obj.privateKeyShamirPartitions",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			hexString_fromJs(x1)
		},
	)
	val publicKey = obj.publicKey?.let { nonNull1 ->
		spkiHexString_fromJs(nonNull1)
	}
	val publicKeysForOaepWithSha256 = arrayToSet(
		obj.publicKeysForOaepWithSha256,
		"obj.publicKeysForOaepWithSha256",
		{ x1: String ->
			spkiHexString_fromJs(x1)
		},
	)
	val secretForeignKeys = arrayToSet(
		obj.secretForeignKeys,
		"obj.secretForeignKeys",
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = objectToMap(
		obj.cryptedForeignKeys,
		"obj.cryptedForeignKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val delegations = objectToMap(
		obj.delegations,
		"obj.delegations",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptionKeys = objectToMap(
		obj.encryptionKeys,
		"obj.encryptionKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_fromJs(nonNull1)
	}
	val cryptoActorProperties = arrayToSet(
		obj.cryptoActorProperties,
		"obj.cryptoActorProperties",
		{ x1: DecryptedPropertyStubJs ->
			propertyStub_fromJs(x1)
		},
	)
	val parentId = obj.parentId
	return EncryptedPatient(
		id = id,
		identifier = identifier,
		rev = rev,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		tags = tags,
		codes = codes,
		deletionDate = deletionDate,
		firstName = firstName,
		lastName = lastName,
		names = names,
		companyName = companyName,
		languages = languages,
		addresses = addresses,
		civility = civility,
		gender = gender,
		birthSex = birthSex,
		mergeToPatientId = mergeToPatientId,
		mergedIds = mergedIds,
		alias = alias,
		active = active,
		deactivationReason = deactivationReason,
		deactivationDate = deactivationDate,
		ssin = ssin,
		maidenName = maidenName,
		spouseName = spouseName,
		partnerName = partnerName,
		personalStatus = personalStatus,
		dateOfBirth = dateOfBirth,
		dateOfDeath = dateOfDeath,
		timestampOfLatestEidReading = timestampOfLatestEidReading,
		placeOfBirth = placeOfBirth,
		placeOfDeath = placeOfDeath,
		deceased = deceased,
		education = education,
		profession = profession,
		notes = notes,
		note = note,
		administrativeNote = administrativeNote,
		nationality = nationality,
		race = race,
		ethnicity = ethnicity,
		preferredUserId = preferredUserId,
		insurabilities = insurabilities,
		partnerships = partnerships,
		patientHealthCareParties = patientHealthCareParties,
		financialInstitutionInformation = financialInstitutionInformation,
		medicalHouseContracts = medicalHouseContracts,
		patientProfessions = patientProfessions,
		parameters = parameters,
		properties = properties,
		hcPartyKeys = hcPartyKeys,
		aesExchangeKeys = aesExchangeKeys,
		transferKeys = transferKeys,
		privateKeyShamirPartitions = privateKeyShamirPartitions,
		publicKey = publicKey,
		publicKeysForOaepWithSha256 = publicKeysForOaepWithSha256,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
		cryptoActorProperties = cryptoActorProperties,
		parentId = parentId,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun patient_toJs(obj: Patient): PatientJs = when (obj) {
	is EncryptedPatient -> patient_toJs(obj)
	is DecryptedPatient -> patient_toJs(obj)
}

public fun patient_fromJs(obj: PatientJs): Patient = if (obj.isEncrypted) {
	patient_fromJs(obj as EncryptedPatientJs)
} else {
	patient_fromJs(obj as DecryptedPatientJs)
}
