// auto-generated file
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

}
