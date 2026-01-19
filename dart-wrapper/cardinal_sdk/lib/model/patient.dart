// auto-generated file
import 'package:cardinal_sdk/model/base/identifier.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/person_name.dart';
import 'package:cardinal_sdk/model/embed/address.dart';
import 'package:cardinal_sdk/model/embed/gender.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/personal_status.dart';
import 'package:cardinal_sdk/model/embed/annotation.dart';
import 'dart:typed_data';
import 'package:cardinal_sdk/model/embed/insurability.dart';
import 'package:cardinal_sdk/model/embed/partnership.dart';
import 'package:cardinal_sdk/model/embed/patient_health_care_party.dart';
import 'package:cardinal_sdk/model/embed/financial_institution_information.dart';
import 'package:cardinal_sdk/model/embed/medical_house_contract.dart';
import 'package:cardinal_sdk/model/property_stub.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/model/specializations/aes_exchange_key_entry_key_string.dart';
import 'package:cardinal_sdk/model/specializations/aes_exchange_key_encryption_keypair_identifier.dart';
import 'package:cardinal_sdk/crypto/entities/cardinal_keys.dart';
import 'package:cardinal_sdk/model/embed/delegation.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/security_metadata.dart';
import 'package:cardinal_sdk/model/embed/schooling_info.dart';
import 'package:cardinal_sdk/model/embed/employment_info.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:cardinal_sdk/model/base/person.dart';
import 'package:cardinal_sdk/model/base/has_encryption_metadata.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:cardinal_sdk/model/base/crypto_actor.dart';
import 'dart:convert';
import 'package:freezed_annotation/freezed_annotation.dart';
part "patient.freezed.dart";


sealed class Patient implements StoredDocument, ICureDocument<String>, Person, HasEncryptionMetadata, Encryptable, CryptoActor {
	@override abstract final String id;
	abstract final List<Identifier> identifier;
	@override abstract final String? rev;
	@override abstract final int? created;
	@override abstract final int? modified;
	@override abstract final String? author;
	@override abstract final String? responsible;
	@override abstract final Set<CodeStub> tags;
	@override abstract final Set<CodeStub> codes;
	@override abstract final int? endOfLife;
	@override abstract final int? deletionDate;
	@override abstract final String? firstName;
	@override abstract final String? lastName;
	@override abstract final List<PersonName> names;
	@override abstract final String? companyName;
	@override abstract final List<String> languages;
	@override List<Address> get addresses;
	@override abstract final String? civility;
	@override abstract final Gender? gender;
	abstract final Gender? birthSex;
	abstract final String? mergeToPatientId;
	abstract final Set<String> mergedIds;
	abstract final String? alias;
	abstract final bool active;
	abstract final String deactivationReason;
	@actualInt32 abstract final int? deactivationDate;
	abstract final String? ssin;
	abstract final String? maidenName;
	abstract final String? spouseName;
	abstract final String? partnerName;
	abstract final PersonalStatus? personalStatus;
	@actualInt32 abstract final int? dateOfBirth;
	@actualInt32 abstract final int? dateOfDeath;
	abstract final int? timestampOfLatestEidReading;
	abstract final String? placeOfBirth;
	abstract final String? placeOfDeath;
	abstract final bool? deceased;
	abstract final String? education;
	abstract final String? profession;
	abstract final List<Annotation> notes;
	abstract final String? note;
	abstract final String? administrativeNote;
	abstract final String? nationality;
	abstract final String? race;
	abstract final String? ethnicity;
	abstract final String? preferredUserId;
	abstract final Uint8List? picture;
	abstract final String? externalId;
	List<Insurability> get insurabilities;
	abstract final List<Partnership> partnerships;
	List<PatientHealthCareParty> get patientHealthCareParties;
	List<FinancialInstitutionInformation> get financialInstitutionInformation;
	List<MedicalHouseContract> get medicalHouseContracts;
	abstract final List<CodeStub> patientProfessions;
	abstract final Map<String, List<String>> parameters;
	Set<PropertyStub> get properties;
	@override abstract final Map<String, List<HexString>> hcPartyKeys;
	@override abstract final Map<AesExchangeKeyEntryKeyString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> aesExchangeKeys;
	@override abstract final Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> transferKeys;
	@override abstract final Map<String, HexString> privateKeyShamirPartitions;
	@override abstract final CardinalRsaPublicKey? publicKey;
	@override abstract final Set<CardinalRsaPublicKey> publicKeysForOaepWithSha256;
	@override abstract final Set<String> secretForeignKeys;
	@override abstract final Map<String, Set<Delegation>> cryptedForeignKeys;
	@override abstract final Map<String, Set<Delegation>> delegations;
	@override abstract final Map<String, Set<Delegation>> encryptionKeys;
	@override abstract final Base64String? encryptedSelf;
	@override abstract final SecurityMetadata? securityMetadata;
	@override abstract final Set<DecryptedPropertyStub>? cryptoActorProperties;
	@override abstract final String? medicalLocationId;
	abstract final Set<String> nonDuplicateIds;
	abstract final Set<String> encryptedAdministrativesDocuments;
	abstract final String? comment;
	abstract final String? warning;
	abstract final CodeStub? fatherBirthCountry;
	abstract final CodeStub? birthCountry;
	abstract final CodeStub? nativeCountry;
	abstract final CodeStub? socialStatus;
	abstract final CodeStub? mainSourceOfIncome;
	List<SchoolingInfo> get schoolingInfos;
	List<EmploymentInfo> get employementInfos;
	@override abstract final Never? parentId;

	static Map<String, dynamic> encode(Patient value) {
		switch (value) {
			case EncryptedPatient entity:
				Map<String, dynamic> entityJson = EncryptedPatient.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedPatient";
				return entityJson;
			case DecryptedPatient entity:
				Map<String, dynamic> entityJson = DecryptedPatient.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedPatient";
				return entityJson;
		}
	}

	static Patient fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.EncryptedPatient":
				return EncryptedPatient.fromJSON(data);
			case "com.icure.cardinal.sdk.model.DecryptedPatient":
				return DecryptedPatient.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class EncryptedPatient with _$EncryptedPatient implements Patient {
	const factory EncryptedPatient({
		required String id,
		@Default([]) List<Identifier> identifier,
		@Default(null) String? rev,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default(null) int? endOfLife,
		@Default(null) int? deletionDate,
		@Default(null) String? firstName,
		@Default(null) String? lastName,
		@Default([]) List<PersonName> names,
		@Default(null) String? companyName,
		@Default([]) List<String> languages,
		@Default([]) List<EncryptedAddress> addresses,
		@Default(null) String? civility,
		@Default(Gender.unknown) Gender? gender,
		@Default(Gender.unknown) Gender? birthSex,
		@Default(null) String? mergeToPatientId,
		@Default({}) Set<String> mergedIds,
		@Default(null) String? alias,
		@Default(true) bool active,
		@Default("none") String deactivationReason,
		@Default(null) int? deactivationDate,
		@Default(null) String? ssin,
		@Default(null) String? maidenName,
		@Default(null) String? spouseName,
		@Default(null) String? partnerName,
		@Default(PersonalStatus.unknown) PersonalStatus? personalStatus,
		@Default(null) int? dateOfBirth,
		@Default(null) int? dateOfDeath,
		@Default(null) int? timestampOfLatestEidReading,
		@Default(null) String? placeOfBirth,
		@Default(null) String? placeOfDeath,
		@Default(null) bool? deceased,
		@Default(null) String? education,
		@Default(null) String? profession,
		@Default([]) List<Annotation> notes,
		@Default(null) String? note,
		@Default(null) String? administrativeNote,
		@Default(null) String? nationality,
		@Default(null) String? race,
		@Default(null) String? ethnicity,
		@Default(null) String? preferredUserId,
		@Default(null) Uint8List? picture,
		@Default(null) String? externalId,
		@Default([]) List<EncryptedInsurability> insurabilities,
		@Default([]) List<Partnership> partnerships,
		@Default([]) List<EncryptedPatientHealthCareParty> patientHealthCareParties,
		@Default([]) List<EncryptedFinancialInstitutionInformation> financialInstitutionInformation,
		@Default([]) List<EncryptedMedicalHouseContract> medicalHouseContracts,
		@Default([]) List<CodeStub> patientProfessions,
		@Default({}) Map<String, List<String>> parameters,
		@Default({}) Set<EncryptedPropertyStub> properties,
		@Default({}) Map<String, List<HexString>> hcPartyKeys,
		@Default({}) Map<AesExchangeKeyEntryKeyString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> aesExchangeKeys,
		@Default({}) Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> transferKeys,
		@Default({}) Map<String, HexString> privateKeyShamirPartitions,
		@Default(null) CardinalRsaPublicKey? publicKey,
		@Default({}) Set<CardinalRsaPublicKey> publicKeysForOaepWithSha256,
		@Default({}) Set<String> secretForeignKeys,
		@Default({}) Map<String, Set<Delegation>> cryptedForeignKeys,
		@Default({}) Map<String, Set<Delegation>> delegations,
		@Default({}) Map<String, Set<Delegation>> encryptionKeys,
		@Default(null) Base64String? encryptedSelf,
		@Default(null) SecurityMetadata? securityMetadata,
		@Default(null) Set<DecryptedPropertyStub>? cryptoActorProperties,
		@Default(null) String? medicalLocationId,
		@Default({}) Set<String> nonDuplicateIds,
		@Default({}) Set<String> encryptedAdministrativesDocuments,
		@Default(null) String? comment,
		@Default(null) String? warning,
		@Default(null) CodeStub? fatherBirthCountry,
		@Default(null) CodeStub? birthCountry,
		@Default(null) CodeStub? nativeCountry,
		@Default(null) CodeStub? socialStatus,
		@Default(null) CodeStub? mainSourceOfIncome,
		@Default([]) List<EncryptedSchoolingInfo> schoolingInfos,
		@Default([]) List<EncryptedEmploymentInfo> employementInfos,
		@Default(null) Never? parentId,
	}) = _EncryptedPatient;


	static Map<String, dynamic> encode(EncryptedPatient value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"identifier" : value.identifier.map((x0) => Identifier.encode(x0)).toList(),
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"firstName" : value.firstName,
			"lastName" : value.lastName,
			"names" : value.names.map((x0) => PersonName.encode(x0)).toList(),
			"companyName" : value.companyName,
			"languages" : value.languages.map((x0) => x0).toList(),
			"addresses" : value.addresses.map((x0) => EncryptedAddress.encode(x0)).toList(),
			"civility" : value.civility,
			"gender" : value.gender == null ? null : Gender.encode(value.gender!),
			"birthSex" : value.birthSex == null ? null : Gender.encode(value.birthSex!),
			"mergeToPatientId" : value.mergeToPatientId,
			"mergedIds" : value.mergedIds.map((x0) => x0).toList(),
			"alias" : value.alias,
			"active" : value.active,
			"deactivationReason" : value.deactivationReason,
			"deactivationDate" : value.deactivationDate,
			"ssin" : value.ssin,
			"maidenName" : value.maidenName,
			"spouseName" : value.spouseName,
			"partnerName" : value.partnerName,
			"personalStatus" : value.personalStatus == null ? null : PersonalStatus.encode(value.personalStatus!),
			"dateOfBirth" : value.dateOfBirth,
			"dateOfDeath" : value.dateOfDeath,
			"timestampOfLatestEidReading" : value.timestampOfLatestEidReading,
			"placeOfBirth" : value.placeOfBirth,
			"placeOfDeath" : value.placeOfDeath,
			"deceased" : value.deceased,
			"education" : value.education,
			"profession" : value.profession,
			"notes" : value.notes.map((x0) => Annotation.encode(x0)).toList(),
			"note" : value.note,
			"administrativeNote" : value.administrativeNote,
			"nationality" : value.nationality,
			"race" : value.race,
			"ethnicity" : value.ethnicity,
			"preferredUserId" : value.preferredUserId,
			"picture" : value.picture == null ? null : base64Encode(value.picture as List<int>),
			"externalId" : value.externalId,
			"insurabilities" : value.insurabilities.map((x0) => EncryptedInsurability.encode(x0)).toList(),
			"partnerships" : value.partnerships.map((x0) => Partnership.encode(x0)).toList(),
			"patientHealthCareParties" : value.patientHealthCareParties.map((x0) => EncryptedPatientHealthCareParty.encode(x0)).toList(),
			"financialInstitutionInformation" : value.financialInstitutionInformation.map((x0) => EncryptedFinancialInstitutionInformation.encode(x0)).toList(),
			"medicalHouseContracts" : value.medicalHouseContracts.map((x0) => EncryptedMedicalHouseContract.encode(x0)).toList(),
			"patientProfessions" : value.patientProfessions.map((x0) => CodeStub.encode(x0)).toList(),
			"parameters" : value.parameters.map((k0, v0) => MapEntry(k0, v0.map((x1) => x1).toList())),
			"properties" : value.properties.map((x0) => EncryptedPropertyStub.encode(x0)).toList(),
			"hcPartyKeys" : value.hcPartyKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => x1).toList())),
			"aesExchangeKeys" : value.aesExchangeKeys.map((k0, v0) => MapEntry(k0, v0.map((k1, v1) => MapEntry(k1, v1.map((k2, v2) => MapEntry(k2, v2)))))),
			"transferKeys" : value.transferKeys.map((k0, v0) => MapEntry(k0, v0.map((k1, v1) => MapEntry(k1, v1)))),
			"privateKeyShamirPartitions" : value.privateKeyShamirPartitions.map((k0, v0) => MapEntry(k0, v0)),
			"publicKey" : value.publicKey?.spkiHex,
			"publicKeysForOaepWithSha256" : value.publicKeysForOaepWithSha256.map((x0) => x0.spkiHex).toList(),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!),
			"cryptoActorProperties" : value.cryptoActorProperties?.map((x0) => DecryptedPropertyStub.encode(x0)).toList(),
			"medicalLocationId" : value.medicalLocationId,
			"nonDuplicateIds" : value.nonDuplicateIds.map((x0) => x0).toList(),
			"encryptedAdministrativesDocuments" : value.encryptedAdministrativesDocuments.map((x0) => x0).toList(),
			"comment" : value.comment,
			"warning" : value.warning,
			"fatherBirthCountry" : value.fatherBirthCountry == null ? null : CodeStub.encode(value.fatherBirthCountry!),
			"birthCountry" : value.birthCountry == null ? null : CodeStub.encode(value.birthCountry!),
			"nativeCountry" : value.nativeCountry == null ? null : CodeStub.encode(value.nativeCountry!),
			"socialStatus" : value.socialStatus == null ? null : CodeStub.encode(value.socialStatus!),
			"mainSourceOfIncome" : value.mainSourceOfIncome == null ? null : CodeStub.encode(value.mainSourceOfIncome!),
			"schoolingInfos" : value.schoolingInfos.map((x0) => EncryptedSchoolingInfo.encode(x0)).toList(),
			"employementInfos" : value.employementInfos.map((x0) => EncryptedEmploymentInfo.encode(x0)).toList(),
			"parentId" : null
		};
		return entityAsMap;
	}

	static EncryptedPatient fromJSON(Map<String, dynamic> data) {
		return EncryptedPatient(
			id: (data["id"] as String),
			deactivationDate: (data["deactivationDate"] as int?),
			dateOfBirth: (data["dateOfBirth"] as int?),
			dateOfDeath: (data["dateOfDeath"] as int?),
			identifier: (data["identifier"] as List<dynamic>).map((x0) => Identifier.fromJSON(x0) ).toList(),
			rev: (data["rev"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			firstName: (data["firstName"] as String?),
			lastName: (data["lastName"] as String?),
			names: (data["names"] as List<dynamic>).map((x0) => PersonName.fromJSON(x0) ).toList(),
			companyName: (data["companyName"] as String?),
			languages: (data["languages"] as List<dynamic>).map((x0) => (x0 as String) ).toList(),
			addresses: (data["addresses"] as List<dynamic>).map((x0) => EncryptedAddress.fromJSON(x0) ).toList(),
			civility: (data["civility"] as String?),
			gender: data["gender"] == null ? null : Gender.fromJSON(data["gender"]),
			birthSex: data["birthSex"] == null ? null : Gender.fromJSON(data["birthSex"]),
			mergeToPatientId: (data["mergeToPatientId"] as String?),
			mergedIds: (data["mergedIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			alias: (data["alias"] as String?),
			active: (data["active"] as bool),
			deactivationReason: (data["deactivationReason"] as String),
			ssin: (data["ssin"] as String?),
			maidenName: (data["maidenName"] as String?),
			spouseName: (data["spouseName"] as String?),
			partnerName: (data["partnerName"] as String?),
			personalStatus: data["personalStatus"] == null ? null : PersonalStatus.fromJSON(data["personalStatus"]),
			timestampOfLatestEidReading: (data["timestampOfLatestEidReading"] as int?),
			placeOfBirth: (data["placeOfBirth"] as String?),
			placeOfDeath: (data["placeOfDeath"] as String?),
			deceased: (data["deceased"] as bool?),
			education: (data["education"] as String?),
			profession: (data["profession"] as String?),
			notes: (data["notes"] as List<dynamic>).map((x0) => Annotation.fromJSON(x0) ).toList(),
			note: (data["note"] as String?),
			administrativeNote: (data["administrativeNote"] as String?),
			nationality: (data["nationality"] as String?),
			race: (data["race"] as String?),
			ethnicity: (data["ethnicity"] as String?),
			preferredUserId: (data["preferredUserId"] as String?),
			picture: data["picture"] == null ? null : base64Decode(data["picture"] as String),
			externalId: (data["externalId"] as String?),
			insurabilities: (data["insurabilities"] as List<dynamic>).map((x0) => EncryptedInsurability.fromJSON(x0) ).toList(),
			partnerships: (data["partnerships"] as List<dynamic>).map((x0) => Partnership.fromJSON(x0) ).toList(),
			patientHealthCareParties: (data["patientHealthCareParties"] as List<dynamic>).map((x0) => EncryptedPatientHealthCareParty.fromJSON(x0) ).toList(),
			financialInstitutionInformation: (data["financialInstitutionInformation"] as List<dynamic>).map((x0) => EncryptedFinancialInstitutionInformation.fromJSON(x0) ).toList(),
			medicalHouseContracts: (data["medicalHouseContracts"] as List<dynamic>).map((x0) => EncryptedMedicalHouseContract.fromJSON(x0) ).toList(),
			patientProfessions: (data["patientProfessions"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toList(),
			parameters: (data["parameters"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => (x1 as String) ).toList())),
			properties: (data["properties"] as List<dynamic>).map((x0) => EncryptedPropertyStub.fromJSON(x0) ).toSet(),
			hcPartyKeys: (data["hcPartyKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => (x1 as HexString) ).toList())),
			aesExchangeKeys: (data["aesExchangeKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as AesExchangeKeyEntryKeyString), (v0 as Map<String, dynamic>).map((k1, v1) => MapEntry((k1 as String), (v1 as Map<String, dynamic>).map((k2, v2) => MapEntry((k2 as AesExchangeKeyEncryptionKeypairIdentifier), (v2 as HexString))))))),
			transferKeys: (data["transferKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as AesExchangeKeyEncryptionKeypairIdentifier), (v0 as Map<String, dynamic>).map((k1, v1) => MapEntry((k1 as AesExchangeKeyEncryptionKeypairIdentifier), (v1 as HexString))))),
			privateKeyShamirPartitions: (data["privateKeyShamirPartitions"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as HexString))),
			publicKey: data["publicKey"] != null ? CardinalRsaPublicKey.fromSpkiHex(data["publicKey"]!) : null,
			publicKeysForOaepWithSha256: (data["publicKeysForOaepWithSha256"] as List<dynamic>).map((x0) => CardinalRsaPublicKey.fromSpkiHex(x0) ).toSet(),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
			cryptoActorProperties: (data["cryptoActorProperties"] as List<dynamic>?)?.map((x0) => DecryptedPropertyStub.fromJSON(x0) ).toSet(),
			medicalLocationId: (data["medicalLocationId"] as String?),
			nonDuplicateIds: (data["nonDuplicateIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			encryptedAdministrativesDocuments: (data["encryptedAdministrativesDocuments"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			comment: (data["comment"] as String?),
			warning: (data["warning"] as String?),
			fatherBirthCountry: data["fatherBirthCountry"] == null ? null : CodeStub.fromJSON(data["fatherBirthCountry"]),
			birthCountry: data["birthCountry"] == null ? null : CodeStub.fromJSON(data["birthCountry"]),
			nativeCountry: data["nativeCountry"] == null ? null : CodeStub.fromJSON(data["nativeCountry"]),
			socialStatus: data["socialStatus"] == null ? null : CodeStub.fromJSON(data["socialStatus"]),
			mainSourceOfIncome: data["mainSourceOfIncome"] == null ? null : CodeStub.fromJSON(data["mainSourceOfIncome"]),
			schoolingInfos: (data["schoolingInfos"] as List<dynamic>).map((x0) => EncryptedSchoolingInfo.fromJSON(x0) ).toList(),
			employementInfos: (data["employementInfos"] as List<dynamic>).map((x0) => EncryptedEmploymentInfo.fromJSON(x0) ).toList(),
			parentId: null,
		);
	}
}

@freezed
abstract class DecryptedPatient with _$DecryptedPatient implements Patient {
	const factory DecryptedPatient({
		required String id,
		@Default([]) List<Identifier> identifier,
		@Default(null) String? rev,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default(null) int? endOfLife,
		@Default(null) int? deletionDate,
		@Default(null) String? firstName,
		@Default(null) String? lastName,
		@Default([]) List<PersonName> names,
		@Default(null) String? companyName,
		@Default([]) List<String> languages,
		@Default([]) List<DecryptedAddress> addresses,
		@Default(null) String? civility,
		@Default(Gender.unknown) Gender? gender,
		@Default(Gender.unknown) Gender? birthSex,
		@Default(null) String? mergeToPatientId,
		@Default({}) Set<String> mergedIds,
		@Default(null) String? alias,
		@Default(true) bool active,
		@Default("none") String deactivationReason,
		@Default(null) int? deactivationDate,
		@Default(null) String? ssin,
		@Default(null) String? maidenName,
		@Default(null) String? spouseName,
		@Default(null) String? partnerName,
		@Default(PersonalStatus.unknown) PersonalStatus? personalStatus,
		@Default(null) int? dateOfBirth,
		@Default(null) int? dateOfDeath,
		@Default(null) int? timestampOfLatestEidReading,
		@Default(null) String? placeOfBirth,
		@Default(null) String? placeOfDeath,
		@Default(null) bool? deceased,
		@Default(null) String? education,
		@Default(null) String? profession,
		@Default([]) List<Annotation> notes,
		@Default(null) String? note,
		@Default(null) String? administrativeNote,
		@Default(null) String? nationality,
		@Default(null) String? race,
		@Default(null) String? ethnicity,
		@Default(null) String? preferredUserId,
		@Default(null) Uint8List? picture,
		@Default(null) String? externalId,
		@Default([]) List<DecryptedInsurability> insurabilities,
		@Default([]) List<Partnership> partnerships,
		@Default([]) List<DecryptedPatientHealthCareParty> patientHealthCareParties,
		@Default([]) List<DecryptedFinancialInstitutionInformation> financialInstitutionInformation,
		@Default([]) List<DecryptedMedicalHouseContract> medicalHouseContracts,
		@Default([]) List<CodeStub> patientProfessions,
		@Default({}) Map<String, List<String>> parameters,
		@Default({}) Set<DecryptedPropertyStub> properties,
		@Default({}) Map<String, List<HexString>> hcPartyKeys,
		@Default({}) Map<AesExchangeKeyEntryKeyString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> aesExchangeKeys,
		@Default({}) Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> transferKeys,
		@Default({}) Map<String, HexString> privateKeyShamirPartitions,
		@Default(null) CardinalRsaPublicKey? publicKey,
		@Default({}) Set<CardinalRsaPublicKey> publicKeysForOaepWithSha256,
		@Default({}) Set<String> secretForeignKeys,
		@Default({}) Map<String, Set<Delegation>> cryptedForeignKeys,
		@Default({}) Map<String, Set<Delegation>> delegations,
		@Default({}) Map<String, Set<Delegation>> encryptionKeys,
		@Default(null) Base64String? encryptedSelf,
		@Default(null) SecurityMetadata? securityMetadata,
		@Default(null) Set<DecryptedPropertyStub>? cryptoActorProperties,
		@Default(null) String? medicalLocationId,
		@Default({}) Set<String> nonDuplicateIds,
		@Default({}) Set<String> encryptedAdministrativesDocuments,
		@Default(null) String? comment,
		@Default(null) String? warning,
		@Default(null) CodeStub? fatherBirthCountry,
		@Default(null) CodeStub? birthCountry,
		@Default(null) CodeStub? nativeCountry,
		@Default(null) CodeStub? socialStatus,
		@Default(null) CodeStub? mainSourceOfIncome,
		@Default([]) List<DecryptedSchoolingInfo> schoolingInfos,
		@Default([]) List<DecryptedEmploymentInfo> employementInfos,
		@Default(null) Never? parentId,
	}) = _DecryptedPatient;


	static Map<String, dynamic> encode(DecryptedPatient value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"identifier" : value.identifier.map((x0) => Identifier.encode(x0)).toList(),
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"firstName" : value.firstName,
			"lastName" : value.lastName,
			"names" : value.names.map((x0) => PersonName.encode(x0)).toList(),
			"companyName" : value.companyName,
			"languages" : value.languages.map((x0) => x0).toList(),
			"addresses" : value.addresses.map((x0) => DecryptedAddress.encode(x0)).toList(),
			"civility" : value.civility,
			"gender" : value.gender == null ? null : Gender.encode(value.gender!),
			"birthSex" : value.birthSex == null ? null : Gender.encode(value.birthSex!),
			"mergeToPatientId" : value.mergeToPatientId,
			"mergedIds" : value.mergedIds.map((x0) => x0).toList(),
			"alias" : value.alias,
			"active" : value.active,
			"deactivationReason" : value.deactivationReason,
			"deactivationDate" : value.deactivationDate,
			"ssin" : value.ssin,
			"maidenName" : value.maidenName,
			"spouseName" : value.spouseName,
			"partnerName" : value.partnerName,
			"personalStatus" : value.personalStatus == null ? null : PersonalStatus.encode(value.personalStatus!),
			"dateOfBirth" : value.dateOfBirth,
			"dateOfDeath" : value.dateOfDeath,
			"timestampOfLatestEidReading" : value.timestampOfLatestEidReading,
			"placeOfBirth" : value.placeOfBirth,
			"placeOfDeath" : value.placeOfDeath,
			"deceased" : value.deceased,
			"education" : value.education,
			"profession" : value.profession,
			"notes" : value.notes.map((x0) => Annotation.encode(x0)).toList(),
			"note" : value.note,
			"administrativeNote" : value.administrativeNote,
			"nationality" : value.nationality,
			"race" : value.race,
			"ethnicity" : value.ethnicity,
			"preferredUserId" : value.preferredUserId,
			"picture" : value.picture == null ? null : base64Encode(value.picture as List<int>),
			"externalId" : value.externalId,
			"insurabilities" : value.insurabilities.map((x0) => DecryptedInsurability.encode(x0)).toList(),
			"partnerships" : value.partnerships.map((x0) => Partnership.encode(x0)).toList(),
			"patientHealthCareParties" : value.patientHealthCareParties.map((x0) => DecryptedPatientHealthCareParty.encode(x0)).toList(),
			"financialInstitutionInformation" : value.financialInstitutionInformation.map((x0) => DecryptedFinancialInstitutionInformation.encode(x0)).toList(),
			"medicalHouseContracts" : value.medicalHouseContracts.map((x0) => DecryptedMedicalHouseContract.encode(x0)).toList(),
			"patientProfessions" : value.patientProfessions.map((x0) => CodeStub.encode(x0)).toList(),
			"parameters" : value.parameters.map((k0, v0) => MapEntry(k0, v0.map((x1) => x1).toList())),
			"properties" : value.properties.map((x0) => DecryptedPropertyStub.encode(x0)).toList(),
			"hcPartyKeys" : value.hcPartyKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => x1).toList())),
			"aesExchangeKeys" : value.aesExchangeKeys.map((k0, v0) => MapEntry(k0, v0.map((k1, v1) => MapEntry(k1, v1.map((k2, v2) => MapEntry(k2, v2)))))),
			"transferKeys" : value.transferKeys.map((k0, v0) => MapEntry(k0, v0.map((k1, v1) => MapEntry(k1, v1)))),
			"privateKeyShamirPartitions" : value.privateKeyShamirPartitions.map((k0, v0) => MapEntry(k0, v0)),
			"publicKey" : value.publicKey?.spkiHex,
			"publicKeysForOaepWithSha256" : value.publicKeysForOaepWithSha256.map((x0) => x0.spkiHex).toList(),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!),
			"cryptoActorProperties" : value.cryptoActorProperties?.map((x0) => DecryptedPropertyStub.encode(x0)).toList(),
			"medicalLocationId" : value.medicalLocationId,
			"nonDuplicateIds" : value.nonDuplicateIds.map((x0) => x0).toList(),
			"encryptedAdministrativesDocuments" : value.encryptedAdministrativesDocuments.map((x0) => x0).toList(),
			"comment" : value.comment,
			"warning" : value.warning,
			"fatherBirthCountry" : value.fatherBirthCountry == null ? null : CodeStub.encode(value.fatherBirthCountry!),
			"birthCountry" : value.birthCountry == null ? null : CodeStub.encode(value.birthCountry!),
			"nativeCountry" : value.nativeCountry == null ? null : CodeStub.encode(value.nativeCountry!),
			"socialStatus" : value.socialStatus == null ? null : CodeStub.encode(value.socialStatus!),
			"mainSourceOfIncome" : value.mainSourceOfIncome == null ? null : CodeStub.encode(value.mainSourceOfIncome!),
			"schoolingInfos" : value.schoolingInfos.map((x0) => DecryptedSchoolingInfo.encode(x0)).toList(),
			"employementInfos" : value.employementInfos.map((x0) => DecryptedEmploymentInfo.encode(x0)).toList(),
			"parentId" : null
		};
		return entityAsMap;
	}

	static DecryptedPatient fromJSON(Map<String, dynamic> data) {
		return DecryptedPatient(
			id: (data["id"] as String),
			deactivationDate: (data["deactivationDate"] as int?),
			dateOfBirth: (data["dateOfBirth"] as int?),
			dateOfDeath: (data["dateOfDeath"] as int?),
			identifier: (data["identifier"] as List<dynamic>).map((x0) => Identifier.fromJSON(x0) ).toList(),
			rev: (data["rev"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			firstName: (data["firstName"] as String?),
			lastName: (data["lastName"] as String?),
			names: (data["names"] as List<dynamic>).map((x0) => PersonName.fromJSON(x0) ).toList(),
			companyName: (data["companyName"] as String?),
			languages: (data["languages"] as List<dynamic>).map((x0) => (x0 as String) ).toList(),
			addresses: (data["addresses"] as List<dynamic>).map((x0) => DecryptedAddress.fromJSON(x0) ).toList(),
			civility: (data["civility"] as String?),
			gender: data["gender"] == null ? null : Gender.fromJSON(data["gender"]),
			birthSex: data["birthSex"] == null ? null : Gender.fromJSON(data["birthSex"]),
			mergeToPatientId: (data["mergeToPatientId"] as String?),
			mergedIds: (data["mergedIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			alias: (data["alias"] as String?),
			active: (data["active"] as bool),
			deactivationReason: (data["deactivationReason"] as String),
			ssin: (data["ssin"] as String?),
			maidenName: (data["maidenName"] as String?),
			spouseName: (data["spouseName"] as String?),
			partnerName: (data["partnerName"] as String?),
			personalStatus: data["personalStatus"] == null ? null : PersonalStatus.fromJSON(data["personalStatus"]),
			timestampOfLatestEidReading: (data["timestampOfLatestEidReading"] as int?),
			placeOfBirth: (data["placeOfBirth"] as String?),
			placeOfDeath: (data["placeOfDeath"] as String?),
			deceased: (data["deceased"] as bool?),
			education: (data["education"] as String?),
			profession: (data["profession"] as String?),
			notes: (data["notes"] as List<dynamic>).map((x0) => Annotation.fromJSON(x0) ).toList(),
			note: (data["note"] as String?),
			administrativeNote: (data["administrativeNote"] as String?),
			nationality: (data["nationality"] as String?),
			race: (data["race"] as String?),
			ethnicity: (data["ethnicity"] as String?),
			preferredUserId: (data["preferredUserId"] as String?),
			picture: data["picture"] == null ? null : base64Decode(data["picture"] as String),
			externalId: (data["externalId"] as String?),
			insurabilities: (data["insurabilities"] as List<dynamic>).map((x0) => DecryptedInsurability.fromJSON(x0) ).toList(),
			partnerships: (data["partnerships"] as List<dynamic>).map((x0) => Partnership.fromJSON(x0) ).toList(),
			patientHealthCareParties: (data["patientHealthCareParties"] as List<dynamic>).map((x0) => DecryptedPatientHealthCareParty.fromJSON(x0) ).toList(),
			financialInstitutionInformation: (data["financialInstitutionInformation"] as List<dynamic>).map((x0) => DecryptedFinancialInstitutionInformation.fromJSON(x0) ).toList(),
			medicalHouseContracts: (data["medicalHouseContracts"] as List<dynamic>).map((x0) => DecryptedMedicalHouseContract.fromJSON(x0) ).toList(),
			patientProfessions: (data["patientProfessions"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toList(),
			parameters: (data["parameters"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => (x1 as String) ).toList())),
			properties: (data["properties"] as List<dynamic>).map((x0) => DecryptedPropertyStub.fromJSON(x0) ).toSet(),
			hcPartyKeys: (data["hcPartyKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => (x1 as HexString) ).toList())),
			aesExchangeKeys: (data["aesExchangeKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as AesExchangeKeyEntryKeyString), (v0 as Map<String, dynamic>).map((k1, v1) => MapEntry((k1 as String), (v1 as Map<String, dynamic>).map((k2, v2) => MapEntry((k2 as AesExchangeKeyEncryptionKeypairIdentifier), (v2 as HexString))))))),
			transferKeys: (data["transferKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as AesExchangeKeyEncryptionKeypairIdentifier), (v0 as Map<String, dynamic>).map((k1, v1) => MapEntry((k1 as AesExchangeKeyEncryptionKeypairIdentifier), (v1 as HexString))))),
			privateKeyShamirPartitions: (data["privateKeyShamirPartitions"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as HexString))),
			publicKey: data["publicKey"] != null ? CardinalRsaPublicKey.fromSpkiHex(data["publicKey"]!) : null,
			publicKeysForOaepWithSha256: (data["publicKeysForOaepWithSha256"] as List<dynamic>).map((x0) => CardinalRsaPublicKey.fromSpkiHex(x0) ).toSet(),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
			cryptoActorProperties: (data["cryptoActorProperties"] as List<dynamic>?)?.map((x0) => DecryptedPropertyStub.fromJSON(x0) ).toSet(),
			medicalLocationId: (data["medicalLocationId"] as String?),
			nonDuplicateIds: (data["nonDuplicateIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			encryptedAdministrativesDocuments: (data["encryptedAdministrativesDocuments"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			comment: (data["comment"] as String?),
			warning: (data["warning"] as String?),
			fatherBirthCountry: data["fatherBirthCountry"] == null ? null : CodeStub.fromJSON(data["fatherBirthCountry"]),
			birthCountry: data["birthCountry"] == null ? null : CodeStub.fromJSON(data["birthCountry"]),
			nativeCountry: data["nativeCountry"] == null ? null : CodeStub.fromJSON(data["nativeCountry"]),
			socialStatus: data["socialStatus"] == null ? null : CodeStub.fromJSON(data["socialStatus"]),
			mainSourceOfIncome: data["mainSourceOfIncome"] == null ? null : CodeStub.fromJSON(data["mainSourceOfIncome"]),
			schoolingInfos: (data["schoolingInfos"] as List<dynamic>).map((x0) => DecryptedSchoolingInfo.fromJSON(x0) ).toList(),
			employementInfos: (data["employementInfos"] as List<dynamic>).map((x0) => DecryptedEmploymentInfo.fromJSON(x0) ).toList(),
			parentId: null,
		);
	}
}