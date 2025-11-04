// auto-generated file
import {decodeBase64, encodeBase64} from '../internal/BytesEncoding.mjs';
import {expectArray, expectBoolean, expectMap, expectNullish, expectNumber, expectString, expectStringEnum, requireEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {DecryptedPropertyStub, EncryptedPropertyStub, PropertyStub} from './PropertyStub.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {CryptoActor} from './base/CryptoActor.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {Identifier} from './base/Identifier.mjs';
import {Person} from './base/Person.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {DecryptedAddress, EncryptedAddress} from './embed/Address.mjs';
import {Annotation} from './embed/Annotation.mjs';
import {Delegation} from './embed/Delegation.mjs';
import {DecryptedEmploymentInfo, EmploymentInfo, EncryptedEmploymentInfo} from './embed/EmploymentInfo.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {DecryptedFinancialInstitutionInformation, EncryptedFinancialInstitutionInformation, FinancialInstitutionInformation} from './embed/FinancialInstitutionInformation.mjs';
import {Gender} from './embed/Gender.mjs';
import {DecryptedInsurability, EncryptedInsurability, Insurability} from './embed/Insurability.mjs';
import {DecryptedMedicalHouseContract, EncryptedMedicalHouseContract, MedicalHouseContract} from './embed/MedicalHouseContract.mjs';
import {Partnership} from './embed/Partnership.mjs';
import {DecryptedPatientHealthCareParty, EncryptedPatientHealthCareParty, PatientHealthCareParty} from './embed/PatientHealthCareParty.mjs';
import {PersonName} from './embed/PersonName.mjs';
import {PersonalStatus} from './embed/PersonalStatus.mjs';
import {DecryptedSchoolingInfo, EncryptedSchoolingInfo, SchoolingInfo} from './embed/SchoolingInfo.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';
import {Base64String} from './specializations/Base64String.mjs';
import {HexString} from './specializations/HexString.mjs';
import {SpkiHexString} from './specializations/SpkiHexString.mjs';


export interface Patient extends StoredDocument, ICureDocument<string>, Person, HasEncryptionMetadata, Encryptable, CryptoActor {

	identifier: Array<Identifier>;

	birthSex: Gender | undefined;

	mergeToPatientId: string | undefined;

	mergedIds: Array<string>;

	alias: string | undefined;

	active: boolean;

	deactivationReason: string;

	deactivationDate: number | undefined;

	ssin: string | undefined;

	maidenName: string | undefined;

	spouseName: string | undefined;

	partnerName: string | undefined;

	personalStatus: PersonalStatus | undefined;

	dateOfBirth: number | undefined;

	dateOfDeath: number | undefined;

	timestampOfLatestEidReading: number | undefined;

	placeOfBirth: string | undefined;

	placeOfDeath: string | undefined;

	deceased: boolean | undefined;

	education: string | undefined;

	profession: string | undefined;

	notes: Array<Annotation>;

	note: string | undefined;

	administrativeNote: string | undefined;

	nationality: string | undefined;

	race: string | undefined;

	ethnicity: string | undefined;

	preferredUserId: string | undefined;

	picture: Int8Array | undefined;

	externalId: string | undefined;

	insurabilities: Array<Insurability>;

	partnerships: Array<Partnership>;

	patientHealthCareParties: Array<PatientHealthCareParty>;

	financialInstitutionInformation: Array<FinancialInstitutionInformation>;

	medicalHouseContracts: Array<MedicalHouseContract>;

	patientProfessions: Array<CodeStub>;

	parameters: { [ key: string ]: Array<string> };

	properties: Array<PropertyStub>;

	nonDuplicateIds: Array<string>;

	encryptedAdministrativesDocuments: Array<string>;

	comment: string | undefined;

	warning: string | undefined;

	fatherBirthCountry: CodeStub | undefined;

	birthCountry: CodeStub | undefined;

	nativeCountry: CodeStub | undefined;

	socialStatus: CodeStub | undefined;

	mainSourceOfIncome: CodeStub | undefined;

	schoolingInfos: Array<SchoolingInfo>;

	employementInfos: Array<EmploymentInfo>;

	parentId: undefined;

	readonly isEncrypted: boolean;

}

export class DecryptedPatient {

	id: string;

	identifier: Array<Identifier> = [];

	rev: string | undefined = undefined;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	endOfLife: number | undefined = undefined;

	deletionDate: number | undefined = undefined;

	firstName: string | undefined = undefined;

	lastName: string | undefined = undefined;

	names: Array<PersonName> = [];

	companyName: string | undefined = undefined;

	languages: Array<string> = [];

	addresses: Array<DecryptedAddress> = [];

	civility: string | undefined = undefined;

	gender: Gender | undefined = Gender.Unknown;

	birthSex: Gender | undefined = Gender.Unknown;

	mergeToPatientId: string | undefined = undefined;

	mergedIds: Array<string> = [];

	alias: string | undefined = undefined;

	active: boolean = true;

	deactivationReason: string = "none";

	deactivationDate: number | undefined = undefined;

	ssin: string | undefined = undefined;

	maidenName: string | undefined = undefined;

	spouseName: string | undefined = undefined;

	partnerName: string | undefined = undefined;

	personalStatus: PersonalStatus | undefined = PersonalStatus.Unknown;

	dateOfBirth: number | undefined = undefined;

	dateOfDeath: number | undefined = undefined;

	timestampOfLatestEidReading: number | undefined = undefined;

	placeOfBirth: string | undefined = undefined;

	placeOfDeath: string | undefined = undefined;

	deceased: boolean | undefined = undefined;

	education: string | undefined = undefined;

	profession: string | undefined = undefined;

	notes: Array<Annotation> = [];

	note: string | undefined = undefined;

	administrativeNote: string | undefined = undefined;

	nationality: string | undefined = undefined;

	race: string | undefined = undefined;

	ethnicity: string | undefined = undefined;

	preferredUserId: string | undefined = undefined;

	picture: Int8Array | undefined = undefined;

	externalId: string | undefined = undefined;

	insurabilities: Array<DecryptedInsurability> = [];

	partnerships: Array<Partnership> = [];

	patientHealthCareParties: Array<DecryptedPatientHealthCareParty> = [];

	financialInstitutionInformation: Array<DecryptedFinancialInstitutionInformation> = [];

	medicalHouseContracts: Array<DecryptedMedicalHouseContract> = [];

	patientProfessions: Array<CodeStub> = [];

	parameters: { [ key: string ]: Array<string> } = {};

	properties: Array<DecryptedPropertyStub> = [];

	hcPartyKeys: { [ key: string ]: Array<HexString> } = {};

	aesExchangeKeys: { [ key: string ]: { [ key: string ]: { [ key: string ]: HexString } } } = {};

	transferKeys: { [ key: string ]: { [ key: string ]: HexString } } = {};

	privateKeyShamirPartitions: { [ key: string ]: HexString } = {};

	publicKey: SpkiHexString | undefined = undefined;

	publicKeysForOaepWithSha256: Array<SpkiHexString> = [];

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

	securityMetadata: SecurityMetadata | undefined = undefined;

	cryptoActorProperties: Array<DecryptedPropertyStub> | undefined = undefined;

	medicalLocationId: string | undefined = undefined;

	nonDuplicateIds: Array<string> = [];

	encryptedAdministrativesDocuments: Array<string> = [];

	comment: string | undefined = undefined;

	warning: string | undefined = undefined;

	fatherBirthCountry: CodeStub | undefined = undefined;

	birthCountry: CodeStub | undefined = undefined;

	nativeCountry: CodeStub | undefined = undefined;

	socialStatus: CodeStub | undefined = undefined;

	mainSourceOfIncome: CodeStub | undefined = undefined;

	schoolingInfos: Array<DecryptedSchoolingInfo> = [];

	employementInfos: Array<DecryptedEmploymentInfo> = [];

	parentId: undefined = undefined;

	readonly isEncrypted: false = false;

	readonly $ktClass: 'com.icure.cardinal.sdk.model.DecryptedPatient' = 'com.icure.cardinal.sdk.model.DecryptedPatient';

	constructor(partial: Partial<DecryptedPatient>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		this.id = partial.id ?? randomUuid();
		if ('identifier' in partial && partial.identifier !== undefined) this.identifier = partial.identifier;
		if ('rev' in partial) this.rev = partial.rev;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('firstName' in partial) this.firstName = partial.firstName;
		if ('lastName' in partial) this.lastName = partial.lastName;
		if ('names' in partial && partial.names !== undefined) this.names = partial.names;
		if ('companyName' in partial) this.companyName = partial.companyName;
		if ('languages' in partial && partial.languages !== undefined) this.languages = partial.languages;
		if ('addresses' in partial && partial.addresses !== undefined) this.addresses = partial.addresses;
		if ('civility' in partial) this.civility = partial.civility;
		if ('gender' in partial) this.gender = partial.gender;
		if ('birthSex' in partial) this.birthSex = partial.birthSex;
		if ('mergeToPatientId' in partial) this.mergeToPatientId = partial.mergeToPatientId;
		if ('mergedIds' in partial && partial.mergedIds !== undefined) this.mergedIds = partial.mergedIds;
		if ('alias' in partial) this.alias = partial.alias;
		if ('active' in partial && partial.active !== undefined) this.active = partial.active;
		if ('deactivationReason' in partial && partial.deactivationReason !== undefined) this.deactivationReason = partial.deactivationReason;
		if ('deactivationDate' in partial) this.deactivationDate = partial.deactivationDate;
		if ('ssin' in partial) this.ssin = partial.ssin;
		if ('maidenName' in partial) this.maidenName = partial.maidenName;
		if ('spouseName' in partial) this.spouseName = partial.spouseName;
		if ('partnerName' in partial) this.partnerName = partial.partnerName;
		if ('personalStatus' in partial) this.personalStatus = partial.personalStatus;
		if ('dateOfBirth' in partial) this.dateOfBirth = partial.dateOfBirth;
		if ('dateOfDeath' in partial) this.dateOfDeath = partial.dateOfDeath;
		if ('timestampOfLatestEidReading' in partial) this.timestampOfLatestEidReading = partial.timestampOfLatestEidReading;
		if ('placeOfBirth' in partial) this.placeOfBirth = partial.placeOfBirth;
		if ('placeOfDeath' in partial) this.placeOfDeath = partial.placeOfDeath;
		if ('deceased' in partial) this.deceased = partial.deceased;
		if ('education' in partial) this.education = partial.education;
		if ('profession' in partial) this.profession = partial.profession;
		if ('notes' in partial && partial.notes !== undefined) this.notes = partial.notes;
		if ('note' in partial) this.note = partial.note;
		if ('administrativeNote' in partial) this.administrativeNote = partial.administrativeNote;
		if ('nationality' in partial) this.nationality = partial.nationality;
		if ('race' in partial) this.race = partial.race;
		if ('ethnicity' in partial) this.ethnicity = partial.ethnicity;
		if ('preferredUserId' in partial) this.preferredUserId = partial.preferredUserId;
		if ('picture' in partial) this.picture = partial.picture;
		if ('externalId' in partial) this.externalId = partial.externalId;
		if ('insurabilities' in partial && partial.insurabilities !== undefined) this.insurabilities = partial.insurabilities;
		if ('partnerships' in partial && partial.partnerships !== undefined) this.partnerships = partial.partnerships;
		if ('patientHealthCareParties' in partial && partial.patientHealthCareParties !== undefined) this.patientHealthCareParties = partial.patientHealthCareParties;
		if ('financialInstitutionInformation' in partial && partial.financialInstitutionInformation !== undefined) this.financialInstitutionInformation = partial.financialInstitutionInformation;
		if ('medicalHouseContracts' in partial && partial.medicalHouseContracts !== undefined) this.medicalHouseContracts = partial.medicalHouseContracts;
		if ('patientProfessions' in partial && partial.patientProfessions !== undefined) this.patientProfessions = partial.patientProfessions;
		if ('parameters' in partial && partial.parameters !== undefined) this.parameters = partial.parameters;
		if ('properties' in partial && partial.properties !== undefined) this.properties = partial.properties;
		if ('hcPartyKeys' in partial && partial.hcPartyKeys !== undefined) this.hcPartyKeys = partial.hcPartyKeys;
		if ('aesExchangeKeys' in partial && partial.aesExchangeKeys !== undefined) this.aesExchangeKeys = partial.aesExchangeKeys;
		if ('transferKeys' in partial && partial.transferKeys !== undefined) this.transferKeys = partial.transferKeys;
		if ('privateKeyShamirPartitions' in partial && partial.privateKeyShamirPartitions !== undefined) this.privateKeyShamirPartitions = partial.privateKeyShamirPartitions;
		if ('publicKey' in partial) this.publicKey = partial.publicKey;
		if ('publicKeysForOaepWithSha256' in partial && partial.publicKeysForOaepWithSha256 !== undefined) this.publicKeysForOaepWithSha256 = partial.publicKeysForOaepWithSha256;
		if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
		if ('cryptoActorProperties' in partial) this.cryptoActorProperties = partial.cryptoActorProperties;
		if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
		if ('nonDuplicateIds' in partial && partial.nonDuplicateIds !== undefined) this.nonDuplicateIds = partial.nonDuplicateIds;
		if ('encryptedAdministrativesDocuments' in partial && partial.encryptedAdministrativesDocuments !== undefined) this.encryptedAdministrativesDocuments = partial.encryptedAdministrativesDocuments;
		if ('comment' in partial) this.comment = partial.comment;
		if ('warning' in partial) this.warning = partial.warning;
		if ('fatherBirthCountry' in partial) this.fatherBirthCountry = partial.fatherBirthCountry;
		if ('birthCountry' in partial) this.birthCountry = partial.birthCountry;
		if ('nativeCountry' in partial) this.nativeCountry = partial.nativeCountry;
		if ('socialStatus' in partial) this.socialStatus = partial.socialStatus;
		if ('mainSourceOfIncome' in partial) this.mainSourceOfIncome = partial.mainSourceOfIncome;
		if ('schoolingInfos' in partial && partial.schoolingInfos !== undefined) this.schoolingInfos = partial.schoolingInfos;
		if ('employementInfos' in partial && partial.employementInfos !== undefined) this.employementInfos = partial.employementInfos;
		if ('parentId' in partial) this.parentId = partial.parentId;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		res['identifier'] = this.identifier.map((x0) => x0.toJSON() )
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.firstName != undefined) res['firstName'] = this.firstName
		if (this.lastName != undefined) res['lastName'] = this.lastName
		res['names'] = this.names.map((x0) => x0.toJSON() )
		if (this.companyName != undefined) res['companyName'] = this.companyName
		res['languages'] = this.languages.map((x0) => x0 )
		res['addresses'] = this.addresses.map((x0) => x0.toJSON() )
		if (this.civility != undefined) res['civility'] = this.civility
		if (this.gender != undefined) res['gender'] = this.gender
		if (this.birthSex != undefined) res['birthSex'] = this.birthSex
		if (this.mergeToPatientId != undefined) res['mergeToPatientId'] = this.mergeToPatientId
		res['mergedIds'] = this.mergedIds.map((x0) => x0 )
		if (this.alias != undefined) res['alias'] = this.alias
		res['active'] = this.active
		res['deactivationReason'] = this.deactivationReason
		if (this.deactivationDate != undefined) res['deactivationDate'] = this.deactivationDate
		if (this.ssin != undefined) res['ssin'] = this.ssin
		if (this.maidenName != undefined) res['maidenName'] = this.maidenName
		if (this.spouseName != undefined) res['spouseName'] = this.spouseName
		if (this.partnerName != undefined) res['partnerName'] = this.partnerName
		if (this.personalStatus != undefined) res['personalStatus'] = this.personalStatus
		if (this.dateOfBirth != undefined) res['dateOfBirth'] = this.dateOfBirth
		if (this.dateOfDeath != undefined) res['dateOfDeath'] = this.dateOfDeath
		if (this.timestampOfLatestEidReading != undefined) res['timestampOfLatestEidReading'] = this.timestampOfLatestEidReading
		if (this.placeOfBirth != undefined) res['placeOfBirth'] = this.placeOfBirth
		if (this.placeOfDeath != undefined) res['placeOfDeath'] = this.placeOfDeath
		if (this.deceased != undefined) res['deceased'] = this.deceased
		if (this.education != undefined) res['education'] = this.education
		if (this.profession != undefined) res['profession'] = this.profession
		res['notes'] = this.notes.map((x0) => x0.toJSON() )
		if (this.note != undefined) res['note'] = this.note
		if (this.administrativeNote != undefined) res['administrativeNote'] = this.administrativeNote
		if (this.nationality != undefined) res['nationality'] = this.nationality
		if (this.race != undefined) res['race'] = this.race
		if (this.ethnicity != undefined) res['ethnicity'] = this.ethnicity
		if (this.preferredUserId != undefined) res['preferredUserId'] = this.preferredUserId
		if (this.picture != undefined) res['picture'] = encodeBase64(this.picture)
		if (this.externalId != undefined) res['externalId'] = this.externalId
		res['insurabilities'] = this.insurabilities.map((x0) => x0.toJSON() )
		res['partnerships'] = this.partnerships.map((x0) => x0.toJSON() )
		res['patientHealthCareParties'] = this.patientHealthCareParties.map((x0) => x0.toJSON() )
		res['financialInstitutionInformation'] = this.financialInstitutionInformation.map((x0) => x0.toJSON() )
		res['medicalHouseContracts'] = this.medicalHouseContracts.map((x0) => x0.toJSON() )
		res['patientProfessions'] = this.patientProfessions.map((x0) => x0.toJSON() )
		res['parameters'] = Object.fromEntries(Object.entries(this.parameters).map(([k0, v0]) => [k0, v0.map((x1) => x1 )]))
		res['properties'] = this.properties.map((x0) => x0.toJSON() )
		res['hcPartyKeys'] = Object.fromEntries(Object.entries(this.hcPartyKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1 )]))
		res['aesExchangeKeys'] = Object.fromEntries(Object.entries(this.aesExchangeKeys).map(([k0, v0]) => [k0, Object.fromEntries(Object.entries(v0).map(([k1, v1]) => [k1, Object.fromEntries(Object.entries(v1).map(([k2, v2]) => [k2, v2]))]))]))
		res['transferKeys'] = Object.fromEntries(Object.entries(this.transferKeys).map(([k0, v0]) => [k0, Object.fromEntries(Object.entries(v0).map(([k1, v1]) => [k1, v1]))]))
		res['privateKeyShamirPartitions'] = Object.fromEntries(Object.entries(this.privateKeyShamirPartitions).map(([k0, v0]) => [k0, v0]))
		if (this.publicKey != undefined) res['publicKey'] = this.publicKey
		res['publicKeysForOaepWithSha256'] = this.publicKeysForOaepWithSha256.map((x0) => x0 )
		res['secretForeignKeys'] = this.secretForeignKeys.map((x0) => x0 )
		res['cryptedForeignKeys'] = Object.fromEntries(Object.entries(this.cryptedForeignKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['delegations'] = Object.fromEntries(Object.entries(this.delegations).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['encryptionKeys'] = Object.fromEntries(Object.entries(this.encryptionKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		if (this.securityMetadata != undefined) res['securityMetadata'] = this.securityMetadata.toJSON()
		if (this.cryptoActorProperties != undefined) res['cryptoActorProperties'] = this.cryptoActorProperties.map((x0) => x0.toJSON() )
		if (this.medicalLocationId != undefined) res['medicalLocationId'] = this.medicalLocationId
		res['nonDuplicateIds'] = this.nonDuplicateIds.map((x0) => x0 )
		res['encryptedAdministrativesDocuments'] = this.encryptedAdministrativesDocuments.map((x0) => x0 )
		if (this.comment != undefined) res['comment'] = this.comment
		if (this.warning != undefined) res['warning'] = this.warning
		if (this.fatherBirthCountry != undefined) res['fatherBirthCountry'] = this.fatherBirthCountry.toJSON()
		if (this.birthCountry != undefined) res['birthCountry'] = this.birthCountry.toJSON()
		if (this.nativeCountry != undefined) res['nativeCountry'] = this.nativeCountry.toJSON()
		if (this.socialStatus != undefined) res['socialStatus'] = this.socialStatus.toJSON()
		if (this.mainSourceOfIncome != undefined) res['mainSourceOfIncome'] = this.mainSourceOfIncome.toJSON()
		res['schoolingInfos'] = this.schoolingInfos.map((x0) => x0.toJSON() )
		res['employementInfos'] = this.employementInfos.map((x0) => x0.toJSON() )
		if (this.parentId != undefined) throw new Error('Unexpected non nullish value for parentId')
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['DecryptedPatient']): DecryptedPatient {
		return new DecryptedPatient({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			identifier: expectArray(json.identifier, false, [...path, ".identifier"], (x0, p0) => Identifier.fromJSON(x0, p0)),
			rev: expectString(json.rev, true, [...path, ".rev"]),
			created: expectNumber(json.created, true, true, [...path, ".created"]),
			modified: expectNumber(json.modified, true, true, [...path, ".modified"]),
			author: expectString(json.author, true, [...path, ".author"]),
			responsible: expectString(json.responsible, true, [...path, ".responsible"]),
			tags: expectArray(json.tags, false, [...path, ".tags"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			codes: expectArray(json.codes, false, [...path, ".codes"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			endOfLife: expectNumber(json.endOfLife, true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(json.deletionDate, true, true, [...path, ".deletionDate"]),
			firstName: expectString(json.firstName, true, [...path, ".firstName"]),
			lastName: expectString(json.lastName, true, [...path, ".lastName"]),
			names: expectArray(json.names, false, [...path, ".names"], (x0, p0) => PersonName.fromJSON(x0, p0)),
			companyName: expectString(json.companyName, true, [...path, ".companyName"]),
			languages: expectArray(json.languages, false, [...path, ".languages"], (x0, p0) => expectString(x0, false, p0)),
			addresses: expectArray(json.addresses, false, [...path, ".addresses"], (x0, p0) => DecryptedAddress.fromJSON(x0, p0)),
			civility: expectString(json.civility, true, [...path, ".civility"]),
			gender: expectStringEnum(json.gender, true, [...path, ".gender"], Gender, 'Gender'),
			birthSex: expectStringEnum(json.birthSex, true, [...path, ".birthSex"], Gender, 'Gender'),
			mergeToPatientId: expectString(json.mergeToPatientId, true, [...path, ".mergeToPatientId"]),
			mergedIds: expectArray(json.mergedIds, false, [...path, ".mergedIds"], (x0, p0) => expectString(x0, false, p0)),
			alias: expectString(json.alias, true, [...path, ".alias"]),
			active: expectBoolean(json.active, false, [...path, ".active"]),
			deactivationReason: expectString(json.deactivationReason, false, [...path, ".deactivationReason"]),
			deactivationDate: expectNumber(json.deactivationDate, true, true, [...path, ".deactivationDate"]),
			ssin: expectString(json.ssin, true, [...path, ".ssin"]),
			maidenName: expectString(json.maidenName, true, [...path, ".maidenName"]),
			spouseName: expectString(json.spouseName, true, [...path, ".spouseName"]),
			partnerName: expectString(json.partnerName, true, [...path, ".partnerName"]),
			personalStatus: expectStringEnum(json.personalStatus, true, [...path, ".personalStatus"], PersonalStatus, 'PersonalStatus'),
			dateOfBirth: expectNumber(json.dateOfBirth, true, true, [...path, ".dateOfBirth"]),
			dateOfDeath: expectNumber(json.dateOfDeath, true, true, [...path, ".dateOfDeath"]),
			timestampOfLatestEidReading: expectNumber(json.timestampOfLatestEidReading, true, true, [...path, ".timestampOfLatestEidReading"]),
			placeOfBirth: expectString(json.placeOfBirth, true, [...path, ".placeOfBirth"]),
			placeOfDeath: expectString(json.placeOfDeath, true, [...path, ".placeOfDeath"]),
			deceased: expectBoolean(json.deceased, true, [...path, ".deceased"]),
			education: expectString(json.education, true, [...path, ".education"]),
			profession: expectString(json.profession, true, [...path, ".profession"]),
			notes: expectArray(json.notes, false, [...path, ".notes"], (x0, p0) => Annotation.fromJSON(x0, p0)),
			note: expectString(json.note, true, [...path, ".note"]),
			administrativeNote: expectString(json.administrativeNote, true, [...path, ".administrativeNote"]),
			nationality: expectString(json.nationality, true, [...path, ".nationality"]),
			race: expectString(json.race, true, [...path, ".race"]),
			ethnicity: expectString(json.ethnicity, true, [...path, ".ethnicity"]),
			preferredUserId: expectString(json.preferredUserId, true, [...path, ".preferredUserId"]),
			picture: decodeBase64(expectString(json.picture, true, [...path, ".picture"]), [...path, ".picture"]),
			externalId: expectString(json.externalId, true, [...path, ".externalId"]),
			insurabilities: expectArray(json.insurabilities, false, [...path, ".insurabilities"], (x0, p0) => DecryptedInsurability.fromJSON(x0, p0)),
			partnerships: expectArray(json.partnerships, false, [...path, ".partnerships"], (x0, p0) => Partnership.fromJSON(x0, p0)),
			patientHealthCareParties: expectArray(json.patientHealthCareParties, false, [...path, ".patientHealthCareParties"], (x0, p0) => DecryptedPatientHealthCareParty.fromJSON(x0, p0)),
			financialInstitutionInformation: expectArray(json.financialInstitutionInformation, false, [...path, ".financialInstitutionInformation"], (x0, p0) => DecryptedFinancialInstitutionInformation.fromJSON(x0, p0)),
			medicalHouseContracts: expectArray(json.medicalHouseContracts, false, [...path, ".medicalHouseContracts"], (x0, p0) => DecryptedMedicalHouseContract.fromJSON(x0, p0)),
			patientProfessions: expectArray(json.patientProfessions, false, [...path, ".patientProfessions"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			parameters: expectMap(
				json.parameters,
				false,
				[...path, ".parameters"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectString(x1, false, p1))
			),
			properties: expectArray(json.properties, false, [...path, ".properties"], (x0, p0) => DecryptedPropertyStub.fromJSON(x0, p0)),
			hcPartyKeys: expectMap(
				json.hcPartyKeys,
				false,
				[...path, ".hcPartyKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectString(x1, false, p1))
			),
			aesExchangeKeys: expectMap(
				json.aesExchangeKeys,
				false,
				[...path, ".aesExchangeKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectMap(
					v0,
					false,
					p0,
					(k1, p1) => expectString(k1, false, p1),
					(v1, p1) => expectMap(
						v1,
						false,
						p1,
						(k2, p2) => expectString(k2, false, p2),
						(v2, p2) => expectString(v2, false, p2)
					)
				)
			),
			transferKeys: expectMap(
				json.transferKeys,
				false,
				[...path, ".transferKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectMap(
					v0,
					false,
					p0,
					(k1, p1) => expectString(k1, false, p1),
					(v1, p1) => expectString(v1, false, p1)
				)
			),
			privateKeyShamirPartitions: expectMap(
				json.privateKeyShamirPartitions,
				false,
				[...path, ".privateKeyShamirPartitions"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			publicKey: expectString(json.publicKey, false, [...path, ".publicKey"]),
			publicKeysForOaepWithSha256: expectArray(json.publicKeysForOaepWithSha256, false, [...path, ".publicKeysForOaepWithSha256"], (x0, p0) => expectString(x0, false, p0)),
			secretForeignKeys: expectArray(json.secretForeignKeys, false, [...path, ".secretForeignKeys"], (x0, p0) => expectString(x0, false, p0)),
			cryptedForeignKeys: expectMap(
				json.cryptedForeignKeys,
				false,
				[...path, ".cryptedForeignKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => Delegation.fromJSON(x1, p1))
			),
			delegations: expectMap(
				json.delegations,
				false,
				[...path, ".delegations"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => Delegation.fromJSON(x1, p1))
			),
			encryptionKeys: expectMap(
				json.encryptionKeys,
				false,
				[...path, ".encryptionKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => Delegation.fromJSON(x1, p1))
			),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
			securityMetadata: SecurityMetadata.fromJSON(json.securityMetadata, [...path, ".securityMetadata"]),
			cryptoActorProperties: expectArray(json.cryptoActorProperties, true, [...path, ".cryptoActorProperties"], (x0, p0) => DecryptedPropertyStub.fromJSON(x0, p0)),
			medicalLocationId: expectString(json.medicalLocationId, true, [...path, ".medicalLocationId"]),
			nonDuplicateIds: expectArray(json.nonDuplicateIds, false, [...path, ".nonDuplicateIds"], (x0, p0) => expectString(x0, false, p0)),
			encryptedAdministrativesDocuments: expectArray(json.encryptedAdministrativesDocuments, false, [...path, ".encryptedAdministrativesDocuments"], (x0, p0) => expectString(x0, false, p0)),
			comment: expectString(json.comment, true, [...path, ".comment"]),
			warning: expectString(json.warning, true, [...path, ".warning"]),
			fatherBirthCountry: CodeStub.fromJSON(json.fatherBirthCountry, [...path, ".fatherBirthCountry"]),
			birthCountry: CodeStub.fromJSON(json.birthCountry, [...path, ".birthCountry"]),
			nativeCountry: CodeStub.fromJSON(json.nativeCountry, [...path, ".nativeCountry"]),
			socialStatus: CodeStub.fromJSON(json.socialStatus, [...path, ".socialStatus"]),
			mainSourceOfIncome: CodeStub.fromJSON(json.mainSourceOfIncome, [...path, ".mainSourceOfIncome"]),
			schoolingInfos: expectArray(json.schoolingInfos, false, [...path, ".schoolingInfos"], (x0, p0) => DecryptedSchoolingInfo.fromJSON(x0, p0)),
			employementInfos: expectArray(json.employementInfos, false, [...path, ".employementInfos"], (x0, p0) => DecryptedEmploymentInfo.fromJSON(x0, p0)),
			parentId: expectNullish(json.parentId, [...path, ".parentId"]),
		})
	}

}

export class EncryptedPatient {

	id: string;

	identifier: Array<Identifier> = [];

	rev: string | undefined = undefined;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	endOfLife: number | undefined = undefined;

	deletionDate: number | undefined = undefined;

	firstName: string | undefined = undefined;

	lastName: string | undefined = undefined;

	names: Array<PersonName> = [];

	companyName: string | undefined = undefined;

	languages: Array<string> = [];

	addresses: Array<EncryptedAddress> = [];

	civility: string | undefined = undefined;

	gender: Gender | undefined = Gender.Unknown;

	birthSex: Gender | undefined = Gender.Unknown;

	mergeToPatientId: string | undefined = undefined;

	mergedIds: Array<string> = [];

	alias: string | undefined = undefined;

	active: boolean = true;

	deactivationReason: string = "none";

	deactivationDate: number | undefined = undefined;

	ssin: string | undefined = undefined;

	maidenName: string | undefined = undefined;

	spouseName: string | undefined = undefined;

	partnerName: string | undefined = undefined;

	personalStatus: PersonalStatus | undefined = PersonalStatus.Unknown;

	dateOfBirth: number | undefined = undefined;

	dateOfDeath: number | undefined = undefined;

	timestampOfLatestEidReading: number | undefined = undefined;

	placeOfBirth: string | undefined = undefined;

	placeOfDeath: string | undefined = undefined;

	deceased: boolean | undefined = undefined;

	education: string | undefined = undefined;

	profession: string | undefined = undefined;

	notes: Array<Annotation> = [];

	note: string | undefined = undefined;

	administrativeNote: string | undefined = undefined;

	nationality: string | undefined = undefined;

	race: string | undefined = undefined;

	ethnicity: string | undefined = undefined;

	preferredUserId: string | undefined = undefined;

	picture: Int8Array | undefined = undefined;

	externalId: string | undefined = undefined;

	insurabilities: Array<EncryptedInsurability> = [];

	partnerships: Array<Partnership> = [];

	patientHealthCareParties: Array<EncryptedPatientHealthCareParty> = [];

	financialInstitutionInformation: Array<EncryptedFinancialInstitutionInformation> = [];

	medicalHouseContracts: Array<EncryptedMedicalHouseContract> = [];

	patientProfessions: Array<CodeStub> = [];

	parameters: { [ key: string ]: Array<string> } = {};

	properties: Array<EncryptedPropertyStub> = [];

	hcPartyKeys: { [ key: string ]: Array<HexString> } = {};

	aesExchangeKeys: { [ key: string ]: { [ key: string ]: { [ key: string ]: HexString } } } = {};

	transferKeys: { [ key: string ]: { [ key: string ]: HexString } } = {};

	privateKeyShamirPartitions: { [ key: string ]: HexString } = {};

	publicKey: SpkiHexString | undefined = undefined;

	publicKeysForOaepWithSha256: Array<SpkiHexString> = [];

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

	securityMetadata: SecurityMetadata | undefined = undefined;

	cryptoActorProperties: Array<DecryptedPropertyStub> | undefined = undefined;

	medicalLocationId: string | undefined = undefined;

	nonDuplicateIds: Array<string> = [];

	encryptedAdministrativesDocuments: Array<string> = [];

	comment: string | undefined = undefined;

	warning: string | undefined = undefined;

	fatherBirthCountry: CodeStub | undefined = undefined;

	birthCountry: CodeStub | undefined = undefined;

	nativeCountry: CodeStub | undefined = undefined;

	socialStatus: CodeStub | undefined = undefined;

	mainSourceOfIncome: CodeStub | undefined = undefined;

	schoolingInfos: Array<EncryptedSchoolingInfo> = [];

	employementInfos: Array<EncryptedEmploymentInfo> = [];

	parentId: undefined = undefined;

	readonly isEncrypted: true = true;

	readonly $ktClass: 'com.icure.cardinal.sdk.model.EncryptedPatient' = 'com.icure.cardinal.sdk.model.EncryptedPatient';

	constructor(partial: Partial<EncryptedPatient>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		this.id = partial.id ?? randomUuid();
		if ('identifier' in partial && partial.identifier !== undefined) this.identifier = partial.identifier;
		if ('rev' in partial) this.rev = partial.rev;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('firstName' in partial) this.firstName = partial.firstName;
		if ('lastName' in partial) this.lastName = partial.lastName;
		if ('names' in partial && partial.names !== undefined) this.names = partial.names;
		if ('companyName' in partial) this.companyName = partial.companyName;
		if ('languages' in partial && partial.languages !== undefined) this.languages = partial.languages;
		if ('addresses' in partial && partial.addresses !== undefined) this.addresses = partial.addresses;
		if ('civility' in partial) this.civility = partial.civility;
		if ('gender' in partial) this.gender = partial.gender;
		if ('birthSex' in partial) this.birthSex = partial.birthSex;
		if ('mergeToPatientId' in partial) this.mergeToPatientId = partial.mergeToPatientId;
		if ('mergedIds' in partial && partial.mergedIds !== undefined) this.mergedIds = partial.mergedIds;
		if ('alias' in partial) this.alias = partial.alias;
		if ('active' in partial && partial.active !== undefined) this.active = partial.active;
		if ('deactivationReason' in partial && partial.deactivationReason !== undefined) this.deactivationReason = partial.deactivationReason;
		if ('deactivationDate' in partial) this.deactivationDate = partial.deactivationDate;
		if ('ssin' in partial) this.ssin = partial.ssin;
		if ('maidenName' in partial) this.maidenName = partial.maidenName;
		if ('spouseName' in partial) this.spouseName = partial.spouseName;
		if ('partnerName' in partial) this.partnerName = partial.partnerName;
		if ('personalStatus' in partial) this.personalStatus = partial.personalStatus;
		if ('dateOfBirth' in partial) this.dateOfBirth = partial.dateOfBirth;
		if ('dateOfDeath' in partial) this.dateOfDeath = partial.dateOfDeath;
		if ('timestampOfLatestEidReading' in partial) this.timestampOfLatestEidReading = partial.timestampOfLatestEidReading;
		if ('placeOfBirth' in partial) this.placeOfBirth = partial.placeOfBirth;
		if ('placeOfDeath' in partial) this.placeOfDeath = partial.placeOfDeath;
		if ('deceased' in partial) this.deceased = partial.deceased;
		if ('education' in partial) this.education = partial.education;
		if ('profession' in partial) this.profession = partial.profession;
		if ('notes' in partial && partial.notes !== undefined) this.notes = partial.notes;
		if ('note' in partial) this.note = partial.note;
		if ('administrativeNote' in partial) this.administrativeNote = partial.administrativeNote;
		if ('nationality' in partial) this.nationality = partial.nationality;
		if ('race' in partial) this.race = partial.race;
		if ('ethnicity' in partial) this.ethnicity = partial.ethnicity;
		if ('preferredUserId' in partial) this.preferredUserId = partial.preferredUserId;
		if ('picture' in partial) this.picture = partial.picture;
		if ('externalId' in partial) this.externalId = partial.externalId;
		if ('insurabilities' in partial && partial.insurabilities !== undefined) this.insurabilities = partial.insurabilities;
		if ('partnerships' in partial && partial.partnerships !== undefined) this.partnerships = partial.partnerships;
		if ('patientHealthCareParties' in partial && partial.patientHealthCareParties !== undefined) this.patientHealthCareParties = partial.patientHealthCareParties;
		if ('financialInstitutionInformation' in partial && partial.financialInstitutionInformation !== undefined) this.financialInstitutionInformation = partial.financialInstitutionInformation;
		if ('medicalHouseContracts' in partial && partial.medicalHouseContracts !== undefined) this.medicalHouseContracts = partial.medicalHouseContracts;
		if ('patientProfessions' in partial && partial.patientProfessions !== undefined) this.patientProfessions = partial.patientProfessions;
		if ('parameters' in partial && partial.parameters !== undefined) this.parameters = partial.parameters;
		if ('properties' in partial && partial.properties !== undefined) this.properties = partial.properties;
		if ('hcPartyKeys' in partial && partial.hcPartyKeys !== undefined) this.hcPartyKeys = partial.hcPartyKeys;
		if ('aesExchangeKeys' in partial && partial.aesExchangeKeys !== undefined) this.aesExchangeKeys = partial.aesExchangeKeys;
		if ('transferKeys' in partial && partial.transferKeys !== undefined) this.transferKeys = partial.transferKeys;
		if ('privateKeyShamirPartitions' in partial && partial.privateKeyShamirPartitions !== undefined) this.privateKeyShamirPartitions = partial.privateKeyShamirPartitions;
		if ('publicKey' in partial) this.publicKey = partial.publicKey;
		if ('publicKeysForOaepWithSha256' in partial && partial.publicKeysForOaepWithSha256 !== undefined) this.publicKeysForOaepWithSha256 = partial.publicKeysForOaepWithSha256;
		if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
		if ('cryptoActorProperties' in partial) this.cryptoActorProperties = partial.cryptoActorProperties;
		if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
		if ('nonDuplicateIds' in partial && partial.nonDuplicateIds !== undefined) this.nonDuplicateIds = partial.nonDuplicateIds;
		if ('encryptedAdministrativesDocuments' in partial && partial.encryptedAdministrativesDocuments !== undefined) this.encryptedAdministrativesDocuments = partial.encryptedAdministrativesDocuments;
		if ('comment' in partial) this.comment = partial.comment;
		if ('warning' in partial) this.warning = partial.warning;
		if ('fatherBirthCountry' in partial) this.fatherBirthCountry = partial.fatherBirthCountry;
		if ('birthCountry' in partial) this.birthCountry = partial.birthCountry;
		if ('nativeCountry' in partial) this.nativeCountry = partial.nativeCountry;
		if ('socialStatus' in partial) this.socialStatus = partial.socialStatus;
		if ('mainSourceOfIncome' in partial) this.mainSourceOfIncome = partial.mainSourceOfIncome;
		if ('schoolingInfos' in partial && partial.schoolingInfos !== undefined) this.schoolingInfos = partial.schoolingInfos;
		if ('employementInfos' in partial && partial.employementInfos !== undefined) this.employementInfos = partial.employementInfos;
		if ('parentId' in partial) this.parentId = partial.parentId;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		res['identifier'] = this.identifier.map((x0) => x0.toJSON() )
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.firstName != undefined) res['firstName'] = this.firstName
		if (this.lastName != undefined) res['lastName'] = this.lastName
		res['names'] = this.names.map((x0) => x0.toJSON() )
		if (this.companyName != undefined) res['companyName'] = this.companyName
		res['languages'] = this.languages.map((x0) => x0 )
		res['addresses'] = this.addresses.map((x0) => x0.toJSON() )
		if (this.civility != undefined) res['civility'] = this.civility
		if (this.gender != undefined) res['gender'] = this.gender
		if (this.birthSex != undefined) res['birthSex'] = this.birthSex
		if (this.mergeToPatientId != undefined) res['mergeToPatientId'] = this.mergeToPatientId
		res['mergedIds'] = this.mergedIds.map((x0) => x0 )
		if (this.alias != undefined) res['alias'] = this.alias
		res['active'] = this.active
		res['deactivationReason'] = this.deactivationReason
		if (this.deactivationDate != undefined) res['deactivationDate'] = this.deactivationDate
		if (this.ssin != undefined) res['ssin'] = this.ssin
		if (this.maidenName != undefined) res['maidenName'] = this.maidenName
		if (this.spouseName != undefined) res['spouseName'] = this.spouseName
		if (this.partnerName != undefined) res['partnerName'] = this.partnerName
		if (this.personalStatus != undefined) res['personalStatus'] = this.personalStatus
		if (this.dateOfBirth != undefined) res['dateOfBirth'] = this.dateOfBirth
		if (this.dateOfDeath != undefined) res['dateOfDeath'] = this.dateOfDeath
		if (this.timestampOfLatestEidReading != undefined) res['timestampOfLatestEidReading'] = this.timestampOfLatestEidReading
		if (this.placeOfBirth != undefined) res['placeOfBirth'] = this.placeOfBirth
		if (this.placeOfDeath != undefined) res['placeOfDeath'] = this.placeOfDeath
		if (this.deceased != undefined) res['deceased'] = this.deceased
		if (this.education != undefined) res['education'] = this.education
		if (this.profession != undefined) res['profession'] = this.profession
		res['notes'] = this.notes.map((x0) => x0.toJSON() )
		if (this.note != undefined) res['note'] = this.note
		if (this.administrativeNote != undefined) res['administrativeNote'] = this.administrativeNote
		if (this.nationality != undefined) res['nationality'] = this.nationality
		if (this.race != undefined) res['race'] = this.race
		if (this.ethnicity != undefined) res['ethnicity'] = this.ethnicity
		if (this.preferredUserId != undefined) res['preferredUserId'] = this.preferredUserId
		if (this.picture != undefined) res['picture'] = encodeBase64(this.picture)
		if (this.externalId != undefined) res['externalId'] = this.externalId
		res['insurabilities'] = this.insurabilities.map((x0) => x0.toJSON() )
		res['partnerships'] = this.partnerships.map((x0) => x0.toJSON() )
		res['patientHealthCareParties'] = this.patientHealthCareParties.map((x0) => x0.toJSON() )
		res['financialInstitutionInformation'] = this.financialInstitutionInformation.map((x0) => x0.toJSON() )
		res['medicalHouseContracts'] = this.medicalHouseContracts.map((x0) => x0.toJSON() )
		res['patientProfessions'] = this.patientProfessions.map((x0) => x0.toJSON() )
		res['parameters'] = Object.fromEntries(Object.entries(this.parameters).map(([k0, v0]) => [k0, v0.map((x1) => x1 )]))
		res['properties'] = this.properties.map((x0) => x0.toJSON() )
		res['hcPartyKeys'] = Object.fromEntries(Object.entries(this.hcPartyKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1 )]))
		res['aesExchangeKeys'] = Object.fromEntries(Object.entries(this.aesExchangeKeys).map(([k0, v0]) => [k0, Object.fromEntries(Object.entries(v0).map(([k1, v1]) => [k1, Object.fromEntries(Object.entries(v1).map(([k2, v2]) => [k2, v2]))]))]))
		res['transferKeys'] = Object.fromEntries(Object.entries(this.transferKeys).map(([k0, v0]) => [k0, Object.fromEntries(Object.entries(v0).map(([k1, v1]) => [k1, v1]))]))
		res['privateKeyShamirPartitions'] = Object.fromEntries(Object.entries(this.privateKeyShamirPartitions).map(([k0, v0]) => [k0, v0]))
		if (this.publicKey != undefined) res['publicKey'] = this.publicKey
		res['publicKeysForOaepWithSha256'] = this.publicKeysForOaepWithSha256.map((x0) => x0 )
		res['secretForeignKeys'] = this.secretForeignKeys.map((x0) => x0 )
		res['cryptedForeignKeys'] = Object.fromEntries(Object.entries(this.cryptedForeignKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['delegations'] = Object.fromEntries(Object.entries(this.delegations).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['encryptionKeys'] = Object.fromEntries(Object.entries(this.encryptionKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		if (this.securityMetadata != undefined) res['securityMetadata'] = this.securityMetadata.toJSON()
		if (this.cryptoActorProperties != undefined) res['cryptoActorProperties'] = this.cryptoActorProperties.map((x0) => x0.toJSON() )
		if (this.medicalLocationId != undefined) res['medicalLocationId'] = this.medicalLocationId
		res['nonDuplicateIds'] = this.nonDuplicateIds.map((x0) => x0 )
		res['encryptedAdministrativesDocuments'] = this.encryptedAdministrativesDocuments.map((x0) => x0 )
		if (this.comment != undefined) res['comment'] = this.comment
		if (this.warning != undefined) res['warning'] = this.warning
		if (this.fatherBirthCountry != undefined) res['fatherBirthCountry'] = this.fatherBirthCountry.toJSON()
		if (this.birthCountry != undefined) res['birthCountry'] = this.birthCountry.toJSON()
		if (this.nativeCountry != undefined) res['nativeCountry'] = this.nativeCountry.toJSON()
		if (this.socialStatus != undefined) res['socialStatus'] = this.socialStatus.toJSON()
		if (this.mainSourceOfIncome != undefined) res['mainSourceOfIncome'] = this.mainSourceOfIncome.toJSON()
		res['schoolingInfos'] = this.schoolingInfos.map((x0) => x0.toJSON() )
		res['employementInfos'] = this.employementInfos.map((x0) => x0.toJSON() )
		if (this.parentId != undefined) throw new Error('Unexpected non nullish value for parentId')
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['EncryptedPatient']): EncryptedPatient {
		return new EncryptedPatient({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			identifier: expectArray(json.identifier, false, [...path, ".identifier"], (x0, p0) => Identifier.fromJSON(x0, p0)),
			rev: expectString(json.rev, true, [...path, ".rev"]),
			created: expectNumber(json.created, true, true, [...path, ".created"]),
			modified: expectNumber(json.modified, true, true, [...path, ".modified"]),
			author: expectString(json.author, true, [...path, ".author"]),
			responsible: expectString(json.responsible, true, [...path, ".responsible"]),
			tags: expectArray(json.tags, false, [...path, ".tags"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			codes: expectArray(json.codes, false, [...path, ".codes"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			endOfLife: expectNumber(json.endOfLife, true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(json.deletionDate, true, true, [...path, ".deletionDate"]),
			firstName: expectString(json.firstName, true, [...path, ".firstName"]),
			lastName: expectString(json.lastName, true, [...path, ".lastName"]),
			names: expectArray(json.names, false, [...path, ".names"], (x0, p0) => PersonName.fromJSON(x0, p0)),
			companyName: expectString(json.companyName, true, [...path, ".companyName"]),
			languages: expectArray(json.languages, false, [...path, ".languages"], (x0, p0) => expectString(x0, false, p0)),
			addresses: expectArray(json.addresses, false, [...path, ".addresses"], (x0, p0) => EncryptedAddress.fromJSON(x0, p0)),
			civility: expectString(json.civility, true, [...path, ".civility"]),
			gender: expectStringEnum(json.gender, true, [...path, ".gender"], Gender, 'Gender'),
			birthSex: expectStringEnum(json.birthSex, true, [...path, ".birthSex"], Gender, 'Gender'),
			mergeToPatientId: expectString(json.mergeToPatientId, true, [...path, ".mergeToPatientId"]),
			mergedIds: expectArray(json.mergedIds, false, [...path, ".mergedIds"], (x0, p0) => expectString(x0, false, p0)),
			alias: expectString(json.alias, true, [...path, ".alias"]),
			active: expectBoolean(json.active, false, [...path, ".active"]),
			deactivationReason: expectString(json.deactivationReason, false, [...path, ".deactivationReason"]),
			deactivationDate: expectNumber(json.deactivationDate, true, true, [...path, ".deactivationDate"]),
			ssin: expectString(json.ssin, true, [...path, ".ssin"]),
			maidenName: expectString(json.maidenName, true, [...path, ".maidenName"]),
			spouseName: expectString(json.spouseName, true, [...path, ".spouseName"]),
			partnerName: expectString(json.partnerName, true, [...path, ".partnerName"]),
			personalStatus: expectStringEnum(json.personalStatus, true, [...path, ".personalStatus"], PersonalStatus, 'PersonalStatus'),
			dateOfBirth: expectNumber(json.dateOfBirth, true, true, [...path, ".dateOfBirth"]),
			dateOfDeath: expectNumber(json.dateOfDeath, true, true, [...path, ".dateOfDeath"]),
			timestampOfLatestEidReading: expectNumber(json.timestampOfLatestEidReading, true, true, [...path, ".timestampOfLatestEidReading"]),
			placeOfBirth: expectString(json.placeOfBirth, true, [...path, ".placeOfBirth"]),
			placeOfDeath: expectString(json.placeOfDeath, true, [...path, ".placeOfDeath"]),
			deceased: expectBoolean(json.deceased, true, [...path, ".deceased"]),
			education: expectString(json.education, true, [...path, ".education"]),
			profession: expectString(json.profession, true, [...path, ".profession"]),
			notes: expectArray(json.notes, false, [...path, ".notes"], (x0, p0) => Annotation.fromJSON(x0, p0)),
			note: expectString(json.note, true, [...path, ".note"]),
			administrativeNote: expectString(json.administrativeNote, true, [...path, ".administrativeNote"]),
			nationality: expectString(json.nationality, true, [...path, ".nationality"]),
			race: expectString(json.race, true, [...path, ".race"]),
			ethnicity: expectString(json.ethnicity, true, [...path, ".ethnicity"]),
			preferredUserId: expectString(json.preferredUserId, true, [...path, ".preferredUserId"]),
			picture: decodeBase64(expectString(json.picture, true, [...path, ".picture"]), [...path, ".picture"]),
			externalId: expectString(json.externalId, true, [...path, ".externalId"]),
			insurabilities: expectArray(json.insurabilities, false, [...path, ".insurabilities"], (x0, p0) => EncryptedInsurability.fromJSON(x0, p0)),
			partnerships: expectArray(json.partnerships, false, [...path, ".partnerships"], (x0, p0) => Partnership.fromJSON(x0, p0)),
			patientHealthCareParties: expectArray(json.patientHealthCareParties, false, [...path, ".patientHealthCareParties"], (x0, p0) => EncryptedPatientHealthCareParty.fromJSON(x0, p0)),
			financialInstitutionInformation: expectArray(json.financialInstitutionInformation, false, [...path, ".financialInstitutionInformation"], (x0, p0) => EncryptedFinancialInstitutionInformation.fromJSON(x0, p0)),
			medicalHouseContracts: expectArray(json.medicalHouseContracts, false, [...path, ".medicalHouseContracts"], (x0, p0) => EncryptedMedicalHouseContract.fromJSON(x0, p0)),
			patientProfessions: expectArray(json.patientProfessions, false, [...path, ".patientProfessions"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			parameters: expectMap(
				json.parameters,
				false,
				[...path, ".parameters"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectString(x1, false, p1))
			),
			properties: expectArray(json.properties, false, [...path, ".properties"], (x0, p0) => EncryptedPropertyStub.fromJSON(x0, p0)),
			hcPartyKeys: expectMap(
				json.hcPartyKeys,
				false,
				[...path, ".hcPartyKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectString(x1, false, p1))
			),
			aesExchangeKeys: expectMap(
				json.aesExchangeKeys,
				false,
				[...path, ".aesExchangeKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectMap(
					v0,
					false,
					p0,
					(k1, p1) => expectString(k1, false, p1),
					(v1, p1) => expectMap(
						v1,
						false,
						p1,
						(k2, p2) => expectString(k2, false, p2),
						(v2, p2) => expectString(v2, false, p2)
					)
				)
			),
			transferKeys: expectMap(
				json.transferKeys,
				false,
				[...path, ".transferKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectMap(
					v0,
					false,
					p0,
					(k1, p1) => expectString(k1, false, p1),
					(v1, p1) => expectString(v1, false, p1)
				)
			),
			privateKeyShamirPartitions: expectMap(
				json.privateKeyShamirPartitions,
				false,
				[...path, ".privateKeyShamirPartitions"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			publicKey: expectString(json.publicKey, false, [...path, ".publicKey"]),
			publicKeysForOaepWithSha256: expectArray(json.publicKeysForOaepWithSha256, false, [...path, ".publicKeysForOaepWithSha256"], (x0, p0) => expectString(x0, false, p0)),
			secretForeignKeys: expectArray(json.secretForeignKeys, false, [...path, ".secretForeignKeys"], (x0, p0) => expectString(x0, false, p0)),
			cryptedForeignKeys: expectMap(
				json.cryptedForeignKeys,
				false,
				[...path, ".cryptedForeignKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => Delegation.fromJSON(x1, p1))
			),
			delegations: expectMap(
				json.delegations,
				false,
				[...path, ".delegations"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => Delegation.fromJSON(x1, p1))
			),
			encryptionKeys: expectMap(
				json.encryptionKeys,
				false,
				[...path, ".encryptionKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => Delegation.fromJSON(x1, p1))
			),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
			securityMetadata: SecurityMetadata.fromJSON(json.securityMetadata, [...path, ".securityMetadata"]),
			cryptoActorProperties: expectArray(json.cryptoActorProperties, true, [...path, ".cryptoActorProperties"], (x0, p0) => DecryptedPropertyStub.fromJSON(x0, p0)),
			medicalLocationId: expectString(json.medicalLocationId, true, [...path, ".medicalLocationId"]),
			nonDuplicateIds: expectArray(json.nonDuplicateIds, false, [...path, ".nonDuplicateIds"], (x0, p0) => expectString(x0, false, p0)),
			encryptedAdministrativesDocuments: expectArray(json.encryptedAdministrativesDocuments, false, [...path, ".encryptedAdministrativesDocuments"], (x0, p0) => expectString(x0, false, p0)),
			comment: expectString(json.comment, true, [...path, ".comment"]),
			warning: expectString(json.warning, true, [...path, ".warning"]),
			fatherBirthCountry: CodeStub.fromJSON(json.fatherBirthCountry, [...path, ".fatherBirthCountry"]),
			birthCountry: CodeStub.fromJSON(json.birthCountry, [...path, ".birthCountry"]),
			nativeCountry: CodeStub.fromJSON(json.nativeCountry, [...path, ".nativeCountry"]),
			socialStatus: CodeStub.fromJSON(json.socialStatus, [...path, ".socialStatus"]),
			mainSourceOfIncome: CodeStub.fromJSON(json.mainSourceOfIncome, [...path, ".mainSourceOfIncome"]),
			schoolingInfos: expectArray(json.schoolingInfos, false, [...path, ".schoolingInfos"], (x0, p0) => EncryptedSchoolingInfo.fromJSON(x0, p0)),
			employementInfos: expectArray(json.employementInfos, false, [...path, ".employementInfos"], (x0, p0) => EncryptedEmploymentInfo.fromJSON(x0, p0)),
			parentId: expectNullish(json.parentId, [...path, ".parentId"]),
		})
	}

}
