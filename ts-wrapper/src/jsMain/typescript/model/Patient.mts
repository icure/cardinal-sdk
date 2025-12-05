// auto-generated file
import {decodeBase64, encodeBase64} from '../internal/BytesEncoding.mjs';
import {expectArray, expectBoolean, expectMap, expectNullish, expectNumber, expectObject, expectString, expectStringEnum, extractEntry} from '../internal/JsonDecodeUtils.mjs';
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
import {AesExchangeKeyEncryptionKeypairIdentifier} from './specializations/AesExchangeKeyEncryptionKeypairIdentifier.mjs';
import {AesExchangeKeyEntryKeyString} from './specializations/AesExchangeKeyEntryKeyString.mjs';
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

	toJSON(): object;

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

	toJSON(): object {
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
		if (this.parentId != undefined) throw new Error('Unexpected nullish value for parentId')
		res['isEncrypted'] = false
		res['$ktClass'] = 'com.icure.cardinal.sdk.model.DecryptedPatient'
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedPatient']): DecryptedPatient {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedPatient`)
		if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.DecryptedPatient') throw new Error(`Unexpected value for ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.DecryptedPatient". The provided json doesn't represent a DecryptedPatient`)
		const res = new DecryptedPatient({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			identifier: expectArray(extractEntry(jCpy, 'identifier', false, path), false, [...path, ".identifier"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Identifier.fromJSON)),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			endOfLife: expectNumber(extractEntry(jCpy, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			firstName: expectString(extractEntry(jCpy, 'firstName', false, path), true, [...path, ".firstName"]),
			lastName: expectString(extractEntry(jCpy, 'lastName', false, path), true, [...path, ".lastName"]),
			names: expectArray(extractEntry(jCpy, 'names', false, path), false, [...path, ".names"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, PersonName.fromJSON)),
			companyName: expectString(extractEntry(jCpy, 'companyName', false, path), true, [...path, ".companyName"]),
			languages: expectArray(extractEntry(jCpy, 'languages', false, path), false, [...path, ".languages"], (x0, p0) => expectString(x0, false, p0)),
			addresses: expectArray(extractEntry(jCpy, 'addresses', false, path), false, [...path, ".addresses"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedAddress.fromJSON)),
			civility: expectString(extractEntry(jCpy, 'civility', false, path), true, [...path, ".civility"]),
			gender: expectStringEnum(extractEntry(jCpy, 'gender', false, path), true, [...path, ".gender"], Gender, 'Gender'),
			birthSex: expectStringEnum(extractEntry(jCpy, 'birthSex', false, path), true, [...path, ".birthSex"], Gender, 'Gender'),
			mergeToPatientId: expectString(extractEntry(jCpy, 'mergeToPatientId', false, path), true, [...path, ".mergeToPatientId"]),
			mergedIds: expectArray(extractEntry(jCpy, 'mergedIds', false, path), false, [...path, ".mergedIds"], (x0, p0) => expectString(x0, false, p0)),
			alias: expectString(extractEntry(jCpy, 'alias', false, path), true, [...path, ".alias"]),
			active: expectBoolean(extractEntry(jCpy, 'active', false, path), false, [...path, ".active"]),
			deactivationReason: expectString(extractEntry(jCpy, 'deactivationReason', false, path), false, [...path, ".deactivationReason"]),
			deactivationDate: expectNumber(extractEntry(jCpy, 'deactivationDate', false, path), true, true, [...path, ".deactivationDate"]),
			ssin: expectString(extractEntry(jCpy, 'ssin', false, path), true, [...path, ".ssin"]),
			maidenName: expectString(extractEntry(jCpy, 'maidenName', false, path), true, [...path, ".maidenName"]),
			spouseName: expectString(extractEntry(jCpy, 'spouseName', false, path), true, [...path, ".spouseName"]),
			partnerName: expectString(extractEntry(jCpy, 'partnerName', false, path), true, [...path, ".partnerName"]),
			personalStatus: expectStringEnum(extractEntry(jCpy, 'personalStatus', false, path), true, [...path, ".personalStatus"], PersonalStatus, 'PersonalStatus'),
			dateOfBirth: expectNumber(extractEntry(jCpy, 'dateOfBirth', false, path), true, true, [...path, ".dateOfBirth"]),
			dateOfDeath: expectNumber(extractEntry(jCpy, 'dateOfDeath', false, path), true, true, [...path, ".dateOfDeath"]),
			timestampOfLatestEidReading: expectNumber(extractEntry(jCpy, 'timestampOfLatestEidReading', false, path), true, true, [...path, ".timestampOfLatestEidReading"]),
			placeOfBirth: expectString(extractEntry(jCpy, 'placeOfBirth', false, path), true, [...path, ".placeOfBirth"]),
			placeOfDeath: expectString(extractEntry(jCpy, 'placeOfDeath', false, path), true, [...path, ".placeOfDeath"]),
			deceased: expectBoolean(extractEntry(jCpy, 'deceased', false, path), true, [...path, ".deceased"]),
			education: expectString(extractEntry(jCpy, 'education', false, path), true, [...path, ".education"]),
			profession: expectString(extractEntry(jCpy, 'profession', false, path), true, [...path, ".profession"]),
			notes: expectArray(extractEntry(jCpy, 'notes', false, path), false, [...path, ".notes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Annotation.fromJSON)),
			note: expectString(extractEntry(jCpy, 'note', false, path), true, [...path, ".note"]),
			administrativeNote: expectString(extractEntry(jCpy, 'administrativeNote', false, path), true, [...path, ".administrativeNote"]),
			nationality: expectString(extractEntry(jCpy, 'nationality', false, path), true, [...path, ".nationality"]),
			race: expectString(extractEntry(jCpy, 'race', false, path), true, [...path, ".race"]),
			ethnicity: expectString(extractEntry(jCpy, 'ethnicity', false, path), true, [...path, ".ethnicity"]),
			preferredUserId: expectString(extractEntry(jCpy, 'preferredUserId', false, path), true, [...path, ".preferredUserId"]),
			picture: decodeBase64(expectString(extractEntry(jCpy, 'picture', false, path), true, [...path, ".picture"]), [...path, ".picture"]),
			externalId: expectString(extractEntry(jCpy, 'externalId', false, path), true, [...path, ".externalId"]),
			insurabilities: expectArray(extractEntry(jCpy, 'insurabilities', false, path), false, [...path, ".insurabilities"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedInsurability.fromJSON)),
			partnerships: expectArray(extractEntry(jCpy, 'partnerships', false, path), false, [...path, ".partnerships"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Partnership.fromJSON)),
			patientHealthCareParties: expectArray(extractEntry(jCpy, 'patientHealthCareParties', false, path), false, [...path, ".patientHealthCareParties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedPatientHealthCareParty.fromJSON)),
			financialInstitutionInformation: expectArray(extractEntry(jCpy, 'financialInstitutionInformation', false, path), false, [...path, ".financialInstitutionInformation"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedFinancialInstitutionInformation.fromJSON)),
			medicalHouseContracts: expectArray(extractEntry(jCpy, 'medicalHouseContracts', false, path), false, [...path, ".medicalHouseContracts"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedMedicalHouseContract.fromJSON)),
			patientProfessions: expectArray(extractEntry(jCpy, 'patientProfessions', false, path), false, [...path, ".patientProfessions"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			parameters: expectMap(
				extractEntry(jCpy, 'parameters', false, path),
				false,
				[...path, ".parameters"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectString(x1, false, p1))
			),
			properties: expectArray(extractEntry(jCpy, 'properties', false, path), false, [...path, ".properties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedPropertyStub.fromJSON)),
			hcPartyKeys: expectMap(
				extractEntry(jCpy, 'hcPartyKeys', false, path),
				false,
				[...path, ".hcPartyKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectString(x1, false, p1) as HexString)
			),
			aesExchangeKeys: expectMap(
				extractEntry(jCpy, 'aesExchangeKeys', false, path),
				false,
				[...path, ".aesExchangeKeys"],
				(k0, p0) => expectString(k0, false, p0) as AesExchangeKeyEntryKeyString,
				(v0, p0) => expectMap(
					v0,
					false,
					p0,
					(k1, p1) => expectString(k1, false, p1),
					(v1, p1) => expectMap(
						v1,
						false,
						p1,
						(k2, p2) => expectString(k2, false, p2) as AesExchangeKeyEncryptionKeypairIdentifier,
						(v2, p2) => expectString(v2, false, p2) as HexString
					)
				)
			),
			transferKeys: expectMap(
				extractEntry(jCpy, 'transferKeys', false, path),
				false,
				[...path, ".transferKeys"],
				(k0, p0) => expectString(k0, false, p0) as AesExchangeKeyEncryptionKeypairIdentifier,
				(v0, p0) => expectMap(
					v0,
					false,
					p0,
					(k1, p1) => expectString(k1, false, p1) as AesExchangeKeyEncryptionKeypairIdentifier,
					(v1, p1) => expectString(v1, false, p1) as HexString
				)
			),
			privateKeyShamirPartitions: expectMap(
				extractEntry(jCpy, 'privateKeyShamirPartitions', false, path),
				false,
				[...path, ".privateKeyShamirPartitions"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0) as HexString
			),
			publicKey: expectString(extractEntry(jCpy, 'publicKey', false, path), true, [...path, ".publicKey"]) as SpkiHexString,
			publicKeysForOaepWithSha256: expectArray(extractEntry(jCpy, 'publicKeysForOaepWithSha256', false, path), false, [...path, ".publicKeysForOaepWithSha256"], (x0, p0) => expectString(x0, false, p0) as SpkiHexString),
			secretForeignKeys: expectArray(extractEntry(jCpy, 'secretForeignKeys', false, path), false, [...path, ".secretForeignKeys"], (x0, p0) => expectString(x0, false, p0)),
			cryptedForeignKeys: expectMap(
				extractEntry(jCpy, 'cryptedForeignKeys', false, path),
				false,
				[...path, ".cryptedForeignKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectObject(x1, false, ignoreUnknownKeys, p1, Delegation.fromJSON))
			),
			delegations: expectMap(
				extractEntry(jCpy, 'delegations', false, path),
				false,
				[...path, ".delegations"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectObject(x1, false, ignoreUnknownKeys, p1, Delegation.fromJSON))
			),
			encryptionKeys: expectMap(
				extractEntry(jCpy, 'encryptionKeys', false, path),
				false,
				[...path, ".encryptionKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectObject(x1, false, ignoreUnknownKeys, p1, Delegation.fromJSON))
			),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
			securityMetadata: expectObject(extractEntry(jCpy, 'securityMetadata', false, path), true, ignoreUnknownKeys, [...path, ".securityMetadata"], SecurityMetadata.fromJSON),
			cryptoActorProperties: expectArray(extractEntry(jCpy, 'cryptoActorProperties', false, path), true, [...path, ".cryptoActorProperties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedPropertyStub.fromJSON)),
			medicalLocationId: expectString(extractEntry(jCpy, 'medicalLocationId', false, path), true, [...path, ".medicalLocationId"]),
			nonDuplicateIds: expectArray(extractEntry(jCpy, 'nonDuplicateIds', false, path), false, [...path, ".nonDuplicateIds"], (x0, p0) => expectString(x0, false, p0)),
			encryptedAdministrativesDocuments: expectArray(extractEntry(jCpy, 'encryptedAdministrativesDocuments', false, path), false, [...path, ".encryptedAdministrativesDocuments"], (x0, p0) => expectString(x0, false, p0)),
			comment: expectString(extractEntry(jCpy, 'comment', false, path), true, [...path, ".comment"]),
			warning: expectString(extractEntry(jCpy, 'warning', false, path), true, [...path, ".warning"]),
			fatherBirthCountry: expectObject(extractEntry(jCpy, 'fatherBirthCountry', false, path), true, ignoreUnknownKeys, [...path, ".fatherBirthCountry"], CodeStub.fromJSON),
			birthCountry: expectObject(extractEntry(jCpy, 'birthCountry', false, path), true, ignoreUnknownKeys, [...path, ".birthCountry"], CodeStub.fromJSON),
			nativeCountry: expectObject(extractEntry(jCpy, 'nativeCountry', false, path), true, ignoreUnknownKeys, [...path, ".nativeCountry"], CodeStub.fromJSON),
			socialStatus: expectObject(extractEntry(jCpy, 'socialStatus', false, path), true, ignoreUnknownKeys, [...path, ".socialStatus"], CodeStub.fromJSON),
			mainSourceOfIncome: expectObject(extractEntry(jCpy, 'mainSourceOfIncome', false, path), true, ignoreUnknownKeys, [...path, ".mainSourceOfIncome"], CodeStub.fromJSON),
			schoolingInfos: expectArray(extractEntry(jCpy, 'schoolingInfos', false, path), false, [...path, ".schoolingInfos"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedSchoolingInfo.fromJSON)),
			employementInfos: expectArray(extractEntry(jCpy, 'employementInfos', false, path), false, [...path, ".employementInfos"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedEmploymentInfo.fromJSON)),
			parentId: expectNullish(extractEntry(jCpy, 'parentId', false, path), [...path, ".parentId"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedPatient at path ${path.join("")}: ${unused}`)}
		return res
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

	toJSON(): object {
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
		if (this.parentId != undefined) throw new Error('Unexpected nullish value for parentId')
		res['isEncrypted'] = true
		res['$ktClass'] = 'com.icure.cardinal.sdk.model.EncryptedPatient'
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedPatient']): EncryptedPatient {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedPatient`)
		if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.EncryptedPatient') throw new Error(`Unexpected value for ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.EncryptedPatient". The provided json doesn't represent a EncryptedPatient`)
		const res = new EncryptedPatient({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			identifier: expectArray(extractEntry(jCpy, 'identifier', false, path), false, [...path, ".identifier"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Identifier.fromJSON)),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			endOfLife: expectNumber(extractEntry(jCpy, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			firstName: expectString(extractEntry(jCpy, 'firstName', false, path), true, [...path, ".firstName"]),
			lastName: expectString(extractEntry(jCpy, 'lastName', false, path), true, [...path, ".lastName"]),
			names: expectArray(extractEntry(jCpy, 'names', false, path), false, [...path, ".names"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, PersonName.fromJSON)),
			companyName: expectString(extractEntry(jCpy, 'companyName', false, path), true, [...path, ".companyName"]),
			languages: expectArray(extractEntry(jCpy, 'languages', false, path), false, [...path, ".languages"], (x0, p0) => expectString(x0, false, p0)),
			addresses: expectArray(extractEntry(jCpy, 'addresses', false, path), false, [...path, ".addresses"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, EncryptedAddress.fromJSON)),
			civility: expectString(extractEntry(jCpy, 'civility', false, path), true, [...path, ".civility"]),
			gender: expectStringEnum(extractEntry(jCpy, 'gender', false, path), true, [...path, ".gender"], Gender, 'Gender'),
			birthSex: expectStringEnum(extractEntry(jCpy, 'birthSex', false, path), true, [...path, ".birthSex"], Gender, 'Gender'),
			mergeToPatientId: expectString(extractEntry(jCpy, 'mergeToPatientId', false, path), true, [...path, ".mergeToPatientId"]),
			mergedIds: expectArray(extractEntry(jCpy, 'mergedIds', false, path), false, [...path, ".mergedIds"], (x0, p0) => expectString(x0, false, p0)),
			alias: expectString(extractEntry(jCpy, 'alias', false, path), true, [...path, ".alias"]),
			active: expectBoolean(extractEntry(jCpy, 'active', false, path), false, [...path, ".active"]),
			deactivationReason: expectString(extractEntry(jCpy, 'deactivationReason', false, path), false, [...path, ".deactivationReason"]),
			deactivationDate: expectNumber(extractEntry(jCpy, 'deactivationDate', false, path), true, true, [...path, ".deactivationDate"]),
			ssin: expectString(extractEntry(jCpy, 'ssin', false, path), true, [...path, ".ssin"]),
			maidenName: expectString(extractEntry(jCpy, 'maidenName', false, path), true, [...path, ".maidenName"]),
			spouseName: expectString(extractEntry(jCpy, 'spouseName', false, path), true, [...path, ".spouseName"]),
			partnerName: expectString(extractEntry(jCpy, 'partnerName', false, path), true, [...path, ".partnerName"]),
			personalStatus: expectStringEnum(extractEntry(jCpy, 'personalStatus', false, path), true, [...path, ".personalStatus"], PersonalStatus, 'PersonalStatus'),
			dateOfBirth: expectNumber(extractEntry(jCpy, 'dateOfBirth', false, path), true, true, [...path, ".dateOfBirth"]),
			dateOfDeath: expectNumber(extractEntry(jCpy, 'dateOfDeath', false, path), true, true, [...path, ".dateOfDeath"]),
			timestampOfLatestEidReading: expectNumber(extractEntry(jCpy, 'timestampOfLatestEidReading', false, path), true, true, [...path, ".timestampOfLatestEidReading"]),
			placeOfBirth: expectString(extractEntry(jCpy, 'placeOfBirth', false, path), true, [...path, ".placeOfBirth"]),
			placeOfDeath: expectString(extractEntry(jCpy, 'placeOfDeath', false, path), true, [...path, ".placeOfDeath"]),
			deceased: expectBoolean(extractEntry(jCpy, 'deceased', false, path), true, [...path, ".deceased"]),
			education: expectString(extractEntry(jCpy, 'education', false, path), true, [...path, ".education"]),
			profession: expectString(extractEntry(jCpy, 'profession', false, path), true, [...path, ".profession"]),
			notes: expectArray(extractEntry(jCpy, 'notes', false, path), false, [...path, ".notes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Annotation.fromJSON)),
			note: expectString(extractEntry(jCpy, 'note', false, path), true, [...path, ".note"]),
			administrativeNote: expectString(extractEntry(jCpy, 'administrativeNote', false, path), true, [...path, ".administrativeNote"]),
			nationality: expectString(extractEntry(jCpy, 'nationality', false, path), true, [...path, ".nationality"]),
			race: expectString(extractEntry(jCpy, 'race', false, path), true, [...path, ".race"]),
			ethnicity: expectString(extractEntry(jCpy, 'ethnicity', false, path), true, [...path, ".ethnicity"]),
			preferredUserId: expectString(extractEntry(jCpy, 'preferredUserId', false, path), true, [...path, ".preferredUserId"]),
			picture: decodeBase64(expectString(extractEntry(jCpy, 'picture', false, path), true, [...path, ".picture"]), [...path, ".picture"]),
			externalId: expectString(extractEntry(jCpy, 'externalId', false, path), true, [...path, ".externalId"]),
			insurabilities: expectArray(extractEntry(jCpy, 'insurabilities', false, path), false, [...path, ".insurabilities"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, EncryptedInsurability.fromJSON)),
			partnerships: expectArray(extractEntry(jCpy, 'partnerships', false, path), false, [...path, ".partnerships"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Partnership.fromJSON)),
			patientHealthCareParties: expectArray(extractEntry(jCpy, 'patientHealthCareParties', false, path), false, [...path, ".patientHealthCareParties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, EncryptedPatientHealthCareParty.fromJSON)),
			financialInstitutionInformation: expectArray(extractEntry(jCpy, 'financialInstitutionInformation', false, path), false, [...path, ".financialInstitutionInformation"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, EncryptedFinancialInstitutionInformation.fromJSON)),
			medicalHouseContracts: expectArray(extractEntry(jCpy, 'medicalHouseContracts', false, path), false, [...path, ".medicalHouseContracts"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, EncryptedMedicalHouseContract.fromJSON)),
			patientProfessions: expectArray(extractEntry(jCpy, 'patientProfessions', false, path), false, [...path, ".patientProfessions"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			parameters: expectMap(
				extractEntry(jCpy, 'parameters', false, path),
				false,
				[...path, ".parameters"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectString(x1, false, p1))
			),
			properties: expectArray(extractEntry(jCpy, 'properties', false, path), false, [...path, ".properties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, EncryptedPropertyStub.fromJSON)),
			hcPartyKeys: expectMap(
				extractEntry(jCpy, 'hcPartyKeys', false, path),
				false,
				[...path, ".hcPartyKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectString(x1, false, p1) as HexString)
			),
			aesExchangeKeys: expectMap(
				extractEntry(jCpy, 'aesExchangeKeys', false, path),
				false,
				[...path, ".aesExchangeKeys"],
				(k0, p0) => expectString(k0, false, p0) as AesExchangeKeyEntryKeyString,
				(v0, p0) => expectMap(
					v0,
					false,
					p0,
					(k1, p1) => expectString(k1, false, p1),
					(v1, p1) => expectMap(
						v1,
						false,
						p1,
						(k2, p2) => expectString(k2, false, p2) as AesExchangeKeyEncryptionKeypairIdentifier,
						(v2, p2) => expectString(v2, false, p2) as HexString
					)
				)
			),
			transferKeys: expectMap(
				extractEntry(jCpy, 'transferKeys', false, path),
				false,
				[...path, ".transferKeys"],
				(k0, p0) => expectString(k0, false, p0) as AesExchangeKeyEncryptionKeypairIdentifier,
				(v0, p0) => expectMap(
					v0,
					false,
					p0,
					(k1, p1) => expectString(k1, false, p1) as AesExchangeKeyEncryptionKeypairIdentifier,
					(v1, p1) => expectString(v1, false, p1) as HexString
				)
			),
			privateKeyShamirPartitions: expectMap(
				extractEntry(jCpy, 'privateKeyShamirPartitions', false, path),
				false,
				[...path, ".privateKeyShamirPartitions"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0) as HexString
			),
			publicKey: expectString(extractEntry(jCpy, 'publicKey', false, path), true, [...path, ".publicKey"]) as SpkiHexString,
			publicKeysForOaepWithSha256: expectArray(extractEntry(jCpy, 'publicKeysForOaepWithSha256', false, path), false, [...path, ".publicKeysForOaepWithSha256"], (x0, p0) => expectString(x0, false, p0) as SpkiHexString),
			secretForeignKeys: expectArray(extractEntry(jCpy, 'secretForeignKeys', false, path), false, [...path, ".secretForeignKeys"], (x0, p0) => expectString(x0, false, p0)),
			cryptedForeignKeys: expectMap(
				extractEntry(jCpy, 'cryptedForeignKeys', false, path),
				false,
				[...path, ".cryptedForeignKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectObject(x1, false, ignoreUnknownKeys, p1, Delegation.fromJSON))
			),
			delegations: expectMap(
				extractEntry(jCpy, 'delegations', false, path),
				false,
				[...path, ".delegations"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectObject(x1, false, ignoreUnknownKeys, p1, Delegation.fromJSON))
			),
			encryptionKeys: expectMap(
				extractEntry(jCpy, 'encryptionKeys', false, path),
				false,
				[...path, ".encryptionKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectObject(x1, false, ignoreUnknownKeys, p1, Delegation.fromJSON))
			),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
			securityMetadata: expectObject(extractEntry(jCpy, 'securityMetadata', false, path), true, ignoreUnknownKeys, [...path, ".securityMetadata"], SecurityMetadata.fromJSON),
			cryptoActorProperties: expectArray(extractEntry(jCpy, 'cryptoActorProperties', false, path), true, [...path, ".cryptoActorProperties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedPropertyStub.fromJSON)),
			medicalLocationId: expectString(extractEntry(jCpy, 'medicalLocationId', false, path), true, [...path, ".medicalLocationId"]),
			nonDuplicateIds: expectArray(extractEntry(jCpy, 'nonDuplicateIds', false, path), false, [...path, ".nonDuplicateIds"], (x0, p0) => expectString(x0, false, p0)),
			encryptedAdministrativesDocuments: expectArray(extractEntry(jCpy, 'encryptedAdministrativesDocuments', false, path), false, [...path, ".encryptedAdministrativesDocuments"], (x0, p0) => expectString(x0, false, p0)),
			comment: expectString(extractEntry(jCpy, 'comment', false, path), true, [...path, ".comment"]),
			warning: expectString(extractEntry(jCpy, 'warning', false, path), true, [...path, ".warning"]),
			fatherBirthCountry: expectObject(extractEntry(jCpy, 'fatherBirthCountry', false, path), true, ignoreUnknownKeys, [...path, ".fatherBirthCountry"], CodeStub.fromJSON),
			birthCountry: expectObject(extractEntry(jCpy, 'birthCountry', false, path), true, ignoreUnknownKeys, [...path, ".birthCountry"], CodeStub.fromJSON),
			nativeCountry: expectObject(extractEntry(jCpy, 'nativeCountry', false, path), true, ignoreUnknownKeys, [...path, ".nativeCountry"], CodeStub.fromJSON),
			socialStatus: expectObject(extractEntry(jCpy, 'socialStatus', false, path), true, ignoreUnknownKeys, [...path, ".socialStatus"], CodeStub.fromJSON),
			mainSourceOfIncome: expectObject(extractEntry(jCpy, 'mainSourceOfIncome', false, path), true, ignoreUnknownKeys, [...path, ".mainSourceOfIncome"], CodeStub.fromJSON),
			schoolingInfos: expectArray(extractEntry(jCpy, 'schoolingInfos', false, path), false, [...path, ".schoolingInfos"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, EncryptedSchoolingInfo.fromJSON)),
			employementInfos: expectArray(extractEntry(jCpy, 'employementInfos', false, path), false, [...path, ".employementInfos"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, EncryptedEmploymentInfo.fromJSON)),
			parentId: expectNullish(extractEntry(jCpy, 'parentId', false, path), [...path, ".parentId"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedPatient at path ${path.join("")}: ${unused}`)}
		return res
	}

}
