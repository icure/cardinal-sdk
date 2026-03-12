// auto-generated file
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
import {Encryptable} from './embed/Encryptable.mjs';
import {DecryptedFinancialInstitutionInformation, EncryptedFinancialInstitutionInformation, FinancialInstitutionInformation} from './embed/FinancialInstitutionInformation.mjs';
import {Gender} from './embed/Gender.mjs';
import {DecryptedInsurability, EncryptedInsurability, Insurability} from './embed/Insurability.mjs';
import {DecryptedMedicalHouseContract, EncryptedMedicalHouseContract, MedicalHouseContract} from './embed/MedicalHouseContract.mjs';
import {Partnership} from './embed/Partnership.mjs';
import {DecryptedPatientHealthCareParty, EncryptedPatientHealthCareParty, PatientHealthCareParty} from './embed/PatientHealthCareParty.mjs';
import {PersonName} from './embed/PersonName.mjs';
import {PersonalStatus} from './embed/PersonalStatus.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';
import {AesExchangeKeyEncryptionKeypairIdentifier} from './specializations/AesExchangeKeyEncryptionKeypairIdentifier.mjs';
import {AesExchangeKeyEntryKeyString} from './specializations/AesExchangeKeyEntryKeyString.mjs';
import {Base64String} from './specializations/Base64String.mjs';
import {HexString} from './specializations/HexString.mjs';
import {SpkiHexString} from './specializations/SpkiHexString.mjs';


/**
 *
 *  Represents a patient in the iCure platform. A patient is a person who receives healthcare
 *  services.
 *  This entity stores personal, administrative, and medical information about the patient, and
 *  supports
 *  end-to-end encryption of sensitive data.
 *  /
 */
export interface Patient extends StoredDocument, ICureDocument<string>, Person, HasEncryptionMetadata, Encryptable, CryptoActor {

	/**
	 *
	 *  The patient's identifiers, used by the client to uniquely identify the patient.
	 */
	identifier: Array<Identifier>;

	/**
	 *
	 *  The birth sex of the patient.
	 */
	birthSex: Gender | undefined;

	/**
	 *
	 *  The id of the patient this patient has been merged with.
	 */
	mergeToPatientId: string | undefined;

	/**
	 *
	 *  The ids of the patients that have been merged inside this patient.
	 */
	mergedIds: Array<string>;

	/**
	 *
	 *  An alias of the person, nickname, ...
	 */
	alias: string | undefined;

	/**
	 *
	 *  Whether the patient is active.
	 */
	active: boolean;

	/**
	 *
	 *  When not active, the reason for deactivation.
	 */
	deactivationReason: string;

	/**
	 *
	 *  Deactivation date of the patient.
	 */
	deactivationDate: number | undefined;

	/**
	 *
	 *  Social security inscription number.
	 */
	ssin: string | undefined;

	/**
	 *
	 *  Lastname at birth (can be different from the current name).
	 */
	maidenName: string | undefined;

	/**
	 *
	 *  Lastname of the spouse for a married woman.
	 */
	spouseName: string | undefined;

	/**
	 *
	 *  Lastname of the partner.
	 */
	partnerName: string | undefined;

	/**
	 *
	 *  The personal/marital status of the patient.
	 */
	personalStatus: PersonalStatus | undefined;

	/**
	 *
	 *  The birthdate encoded as a fuzzy date on 8 positions (YYYYMMDD).
	 */
	dateOfBirth: number | undefined;

	/**
	 *
	 *  The date of death encoded as a fuzzy date on 8 positions (YYYYMMDD).
	 */
	dateOfDeath: number | undefined;

	/**
	 *
	 *  Timestamp of the latest validation of the eID of the person.
	 */
	timestampOfLatestEidReading: number | undefined;

	/**
	 *
	 *  The place of birth.
	 */
	placeOfBirth: string | undefined;

	/**
	 *
	 *  The place of death.
	 */
	placeOfDeath: string | undefined;

	/**
	 *
	 *  Whether the patient is deceased.
	 */
	deceased: boolean | undefined;

	/**
	 *
	 *  The level of education (college degree, undergraduate, phd).
	 */
	education: string | undefined;

	/**
	 *
	 *  The current professional activity.
	 */
	profession: string | undefined;

	/**
	 *
	 *  Localized text notes (can be confidential).
	 */
	notes: Array<Annotation>;

	/**
	 *
	 *  A text note (can be confidential, encrypted by default).
	 */
	note: string | undefined;

	/**
	 *
	 *  An administrative note, not confidential.
	 */
	administrativeNote: string | undefined;

	/**
	 *
	 *  The nationality of the patient.
	 */
	nationality: string | undefined;

	/**
	 *
	 *  The race of the patient.
	 */
	race: string | undefined;

	/**
	 *
	 *  The ethnicity of the patient.
	 */
	ethnicity: string | undefined;

	/**
	 *
	 *  The id of the user that usually handles this patient.
	 */
	preferredUserId: string | undefined;

	/**
	 *
	 *  List of insurance coverages.
	 */
	insurabilities: Array<Insurability>;

	/**
	 *
	 *  List of partners, or persons of contact.
	 */
	partnerships: Array<Partnership>;

	/**
	 *
	 *  Links between this patient and healthcare parties.
	 */
	patientHealthCareParties: Array<PatientHealthCareParty>;

	/**
	 *
	 *  Financial information used to reimburse the patient.
	 */
	financialInstitutionInformation: Array<FinancialInstitutionInformation>;

	/**
	 *
	 *  Contracts between the patient and the healthcare entity.
	 */
	medicalHouseContracts: Array<MedicalHouseContract>;

	/**
	 *
	 *  Codified list of professions exercised by this patient.
	 */
	patientProfessions: Array<CodeStub>;

	/**
	 *
	 *  Extra parameters.
	 */
	parameters: { [ key: string ]: Array<string> };

	/**
	 *
	 *  Extra properties.
	 */
	properties: Array<PropertyStub>;

	/**
	 *
	 *  Properties related to crypto actor functionality.
	 */
	cryptoActorProperties: Array<DecryptedPropertyStub>;

	/**
	 *
	 *  Always null for patients.
	 */
	parentId: undefined;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

/**
 *
 *  Represents a patient in the iCure platform. A patient is a person who receives healthcare
 *  services.
 *  This entity stores personal, administrative, and medical information about the patient, and
 *  supports
 *  end-to-end encryption of sensitive data.
 *  /
 */
export class DecryptedPatient {

	/**
	 *
	 *  The Id of the patient. We encourage using either a v4 UUID or a HL7 Id.
	 */
	id: string;

	/**
	 *
	 *  The patient's identifiers, used by the client to uniquely identify the patient.
	 */
	identifier: Array<Identifier> = [];

	/**
	 *
	 *  The revision of the patient in the database, used for conflict management / optimistic locking.
	 */
	rev: string | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) of creation.
	 */
	created: number | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) of the latest modification.
	 */
	modified: number | undefined = undefined;

	/**
	 *
	 *  The id of the User that created this patient.
	 */
	author: string | undefined = undefined;

	/**
	 *
	 *  The id of the HealthcareParty that is responsible for this patient.
	 */
	responsible: string | undefined = undefined;

	/**
	 *
	 *  Tags that qualify the patient as being member of a certain class.
	 */
	tags: Array<CodeStub> = [];

	/**
	 *
	 *  Codes that identify or qualify this particular patient.
	 */
	codes: Array<CodeStub> = [];

	/**
	 *
	 *  Hard delete (unix epoch in ms) timestamp of the object.
	 */
	deletionDate: number | undefined = undefined;

	/**
	 *
	 *  The firstname (name) of the patient.
	 */
	firstName: string | undefined = undefined;

	/**
	 *
	 *  The lastname (surname) of the patient.
	 */
	lastName: string | undefined = undefined;

	/**
	 *
	 *  The list of all names of the patient, ordered by preference of use.
	 */
	names: Array<PersonName> = [];

	/**
	 *
	 *  The name of the company this patient is member of.
	 */
	companyName: string | undefined = undefined;

	/**
	 *
	 *  The list of languages spoken by the patient ordered by fluency (alpha-2 code).
	 */
	languages: Array<string> = [];

	/**
	 *
	 *  The list of addresses (with address type).
	 */
	addresses: Array<DecryptedAddress> = [];

	/**
	 *
	 *  Mr., Ms., Pr., Dr. ...
	 */
	civility: string | undefined = undefined;

	/**
	 *
	 *  The gender of the patient.
	 */
	gender: Gender | undefined = Gender.Unknown;

	/**
	 *
	 *  The birth sex of the patient.
	 */
	birthSex: Gender | undefined = Gender.Unknown;

	/**
	 *
	 *  The id of the patient this patient has been merged with.
	 */
	mergeToPatientId: string | undefined = undefined;

	/**
	 *
	 *  The ids of the patients that have been merged inside this patient.
	 */
	mergedIds: Array<string> = [];

	/**
	 *
	 *  An alias of the person, nickname, ...
	 */
	alias: string | undefined = undefined;

	/**
	 *
	 *  Whether the patient is active.
	 */
	active: boolean = true;

	/**
	 *
	 *  When not active, the reason for deactivation.
	 */
	deactivationReason: string = "none";

	/**
	 *
	 *  Deactivation date of the patient.
	 */
	deactivationDate: number | undefined = undefined;

	/**
	 *
	 *  Social security inscription number.
	 */
	ssin: string | undefined = undefined;

	/**
	 *
	 *  Lastname at birth (can be different from the current name).
	 */
	maidenName: string | undefined = undefined;

	/**
	 *
	 *  Lastname of the spouse for a married woman.
	 */
	spouseName: string | undefined = undefined;

	/**
	 *
	 *  Lastname of the partner.
	 */
	partnerName: string | undefined = undefined;

	/**
	 *
	 *  The personal/marital status of the patient.
	 */
	personalStatus: PersonalStatus | undefined = PersonalStatus.Unknown;

	/**
	 *
	 *  The birthdate encoded as a fuzzy date on 8 positions (YYYYMMDD).
	 */
	dateOfBirth: number | undefined = undefined;

	/**
	 *
	 *  The date of death encoded as a fuzzy date on 8 positions (YYYYMMDD).
	 */
	dateOfDeath: number | undefined = undefined;

	/**
	 *
	 *  Timestamp of the latest validation of the eID of the person.
	 */
	timestampOfLatestEidReading: number | undefined = undefined;

	/**
	 *
	 *  The place of birth.
	 */
	placeOfBirth: string | undefined = undefined;

	/**
	 *
	 *  The place of death.
	 */
	placeOfDeath: string | undefined = undefined;

	/**
	 *
	 *  Whether the patient is deceased.
	 */
	deceased: boolean | undefined = undefined;

	/**
	 *
	 *  The level of education (college degree, undergraduate, phd).
	 */
	education: string | undefined = undefined;

	/**
	 *
	 *  The current professional activity.
	 */
	profession: string | undefined = undefined;

	/**
	 *
	 *  Localized text notes (can be confidential).
	 */
	notes: Array<Annotation> = [];

	/**
	 *
	 *  A text note (can be confidential, encrypted by default).
	 */
	note: string | undefined = undefined;

	/**
	 *
	 *  An administrative note, not confidential.
	 */
	administrativeNote: string | undefined = undefined;

	/**
	 *
	 *  The nationality of the patient.
	 */
	nationality: string | undefined = undefined;

	/**
	 *
	 *  The race of the patient.
	 */
	race: string | undefined = undefined;

	/**
	 *
	 *  The ethnicity of the patient.
	 */
	ethnicity: string | undefined = undefined;

	/**
	 *
	 *  The id of the user that usually handles this patient.
	 */
	preferredUserId: string | undefined = undefined;

	/**
	 *
	 *  List of insurance coverages.
	 */
	insurabilities: Array<DecryptedInsurability> = [];

	/**
	 *
	 *  List of partners, or persons of contact.
	 */
	partnerships: Array<Partnership> = [];

	/**
	 *
	 *  Links between this patient and healthcare parties.
	 */
	patientHealthCareParties: Array<DecryptedPatientHealthCareParty> = [];

	/**
	 *
	 *  Financial information used to reimburse the patient.
	 */
	financialInstitutionInformation: Array<DecryptedFinancialInstitutionInformation> = [];

	/**
	 *
	 *  Contracts between the patient and the healthcare entity.
	 */
	medicalHouseContracts: Array<DecryptedMedicalHouseContract> = [];

	/**
	 *
	 *  Codified list of professions exercised by this patient.
	 */
	patientProfessions: Array<CodeStub> = [];

	/**
	 *
	 *  Extra parameters.
	 */
	parameters: { [ key: string ]: Array<string> } = {};

	/**
	 *
	 *  Extra properties.
	 */
	properties: Array<DecryptedPropertyStub> = [];

	/**
	 *
	 *  For each couple of HcParties, the AES exchange key.
	 */
	hcPartyKeys: { [ key: string ]: Array<HexString> } = {};

	/**
	 *
	 *  Extra AES exchange keys, indexed by the owner of the pair and target data owner id.
	 */
	aesExchangeKeys: { [ key: string ]: { [ key: string ]: { [ key: string ]: HexString } } } = {};

	/**
	 *
	 *  Keys used to transfer ownership of encrypted data between key pairs.
	 */
	transferKeys: { [ key: string ]: { [ key: string ]: HexString } } = {};

	/**
	 *
	 *  Shamir partitions of the private key.
	 */
	privateKeyShamirPartitions: { [ key: string ]: HexString } = {};

	/**
	 *
	 *  The public key of this patient, used to encrypt data for this patient.
	 */
	publicKey: SpkiHexString | undefined = undefined;

	/**
	 *
	 *  Public keys for OAEP with SHA-256 encryption.
	 */
	publicKeysForOaepWithSha256: Array<SpkiHexString> = [];

	/**
	 *
	 *  The secret patient key, encrypted in the patient's own AES key.
	 */
	secretForeignKeys: Array<string> = [];

	/**
	 *
	 *  The patient id encrypted in the delegates' AES keys.
	 */
	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The delegations giving access to connected healthcare information.
	 */
	delegations: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The keys used to encrypt this entity when stored encrypted.
	 */
	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The base64-encoded encrypted fields of this entity.
	 */
	encryptedSelf: Base64String | undefined = undefined;

	/**
	 *
	 *  The security metadata of the entity.
	 */
	securityMetadata: SecurityMetadata | undefined = undefined;

	/**
	 *
	 *  Properties related to crypto actor functionality.
	 */
	cryptoActorProperties: Array<DecryptedPropertyStub> = [];

	/**
	 *
	 *  Always null for patients.
	 */
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
		if ('cryptoActorProperties' in partial && partial.cryptoActorProperties !== undefined) this.cryptoActorProperties = partial.cryptoActorProperties;
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
		res['cryptoActorProperties'] = this.cryptoActorProperties.map((x0) => x0.toJSON() )
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
			cryptoActorProperties: expectArray(extractEntry(jCpy, 'cryptoActorProperties', false, path), false, [...path, ".cryptoActorProperties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedPropertyStub.fromJSON)),
			parentId: expectNullish(extractEntry(jCpy, 'parentId', false, path), [...path, ".parentId"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedPatient at path ${path.join("")}: ${unused}`)}
		return res
	}

}

/**
 *
 *  Represents a patient in the iCure platform. A patient is a person who receives healthcare
 *  services.
 *  This entity stores personal, administrative, and medical information about the patient, and
 *  supports
 *  end-to-end encryption of sensitive data.
 *  /
 */
export class EncryptedPatient {

	/**
	 *
	 *  The Id of the patient. We encourage using either a v4 UUID or a HL7 Id.
	 */
	id: string;

	/**
	 *
	 *  The patient's identifiers, used by the client to uniquely identify the patient.
	 */
	identifier: Array<Identifier> = [];

	/**
	 *
	 *  The revision of the patient in the database, used for conflict management / optimistic locking.
	 */
	rev: string | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) of creation.
	 */
	created: number | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) of the latest modification.
	 */
	modified: number | undefined = undefined;

	/**
	 *
	 *  The id of the User that created this patient.
	 */
	author: string | undefined = undefined;

	/**
	 *
	 *  The id of the HealthcareParty that is responsible for this patient.
	 */
	responsible: string | undefined = undefined;

	/**
	 *
	 *  Tags that qualify the patient as being member of a certain class.
	 */
	tags: Array<CodeStub> = [];

	/**
	 *
	 *  Codes that identify or qualify this particular patient.
	 */
	codes: Array<CodeStub> = [];

	/**
	 *
	 *  Hard delete (unix epoch in ms) timestamp of the object.
	 */
	deletionDate: number | undefined = undefined;

	/**
	 *
	 *  The firstname (name) of the patient.
	 */
	firstName: string | undefined = undefined;

	/**
	 *
	 *  The lastname (surname) of the patient.
	 */
	lastName: string | undefined = undefined;

	/**
	 *
	 *  The list of all names of the patient, ordered by preference of use.
	 */
	names: Array<PersonName> = [];

	/**
	 *
	 *  The name of the company this patient is member of.
	 */
	companyName: string | undefined = undefined;

	/**
	 *
	 *  The list of languages spoken by the patient ordered by fluency (alpha-2 code).
	 */
	languages: Array<string> = [];

	/**
	 *
	 *  The list of addresses (with address type).
	 */
	addresses: Array<EncryptedAddress> = [];

	/**
	 *
	 *  Mr., Ms., Pr., Dr. ...
	 */
	civility: string | undefined = undefined;

	/**
	 *
	 *  The gender of the patient.
	 */
	gender: Gender | undefined = Gender.Unknown;

	/**
	 *
	 *  The birth sex of the patient.
	 */
	birthSex: Gender | undefined = Gender.Unknown;

	/**
	 *
	 *  The id of the patient this patient has been merged with.
	 */
	mergeToPatientId: string | undefined = undefined;

	/**
	 *
	 *  The ids of the patients that have been merged inside this patient.
	 */
	mergedIds: Array<string> = [];

	/**
	 *
	 *  An alias of the person, nickname, ...
	 */
	alias: string | undefined = undefined;

	/**
	 *
	 *  Whether the patient is active.
	 */
	active: boolean = true;

	/**
	 *
	 *  When not active, the reason for deactivation.
	 */
	deactivationReason: string = "none";

	/**
	 *
	 *  Deactivation date of the patient.
	 */
	deactivationDate: number | undefined = undefined;

	/**
	 *
	 *  Social security inscription number.
	 */
	ssin: string | undefined = undefined;

	/**
	 *
	 *  Lastname at birth (can be different from the current name).
	 */
	maidenName: string | undefined = undefined;

	/**
	 *
	 *  Lastname of the spouse for a married woman.
	 */
	spouseName: string | undefined = undefined;

	/**
	 *
	 *  Lastname of the partner.
	 */
	partnerName: string | undefined = undefined;

	/**
	 *
	 *  The personal/marital status of the patient.
	 */
	personalStatus: PersonalStatus | undefined = PersonalStatus.Unknown;

	/**
	 *
	 *  The birthdate encoded as a fuzzy date on 8 positions (YYYYMMDD).
	 */
	dateOfBirth: number | undefined = undefined;

	/**
	 *
	 *  The date of death encoded as a fuzzy date on 8 positions (YYYYMMDD).
	 */
	dateOfDeath: number | undefined = undefined;

	/**
	 *
	 *  Timestamp of the latest validation of the eID of the person.
	 */
	timestampOfLatestEidReading: number | undefined = undefined;

	/**
	 *
	 *  The place of birth.
	 */
	placeOfBirth: string | undefined = undefined;

	/**
	 *
	 *  The place of death.
	 */
	placeOfDeath: string | undefined = undefined;

	/**
	 *
	 *  Whether the patient is deceased.
	 */
	deceased: boolean | undefined = undefined;

	/**
	 *
	 *  The level of education (college degree, undergraduate, phd).
	 */
	education: string | undefined = undefined;

	/**
	 *
	 *  The current professional activity.
	 */
	profession: string | undefined = undefined;

	/**
	 *
	 *  Localized text notes (can be confidential).
	 */
	notes: Array<Annotation> = [];

	/**
	 *
	 *  A text note (can be confidential, encrypted by default).
	 */
	note: string | undefined = undefined;

	/**
	 *
	 *  An administrative note, not confidential.
	 */
	administrativeNote: string | undefined = undefined;

	/**
	 *
	 *  The nationality of the patient.
	 */
	nationality: string | undefined = undefined;

	/**
	 *
	 *  The race of the patient.
	 */
	race: string | undefined = undefined;

	/**
	 *
	 *  The ethnicity of the patient.
	 */
	ethnicity: string | undefined = undefined;

	/**
	 *
	 *  The id of the user that usually handles this patient.
	 */
	preferredUserId: string | undefined = undefined;

	/**
	 *
	 *  List of insurance coverages.
	 */
	insurabilities: Array<EncryptedInsurability> = [];

	/**
	 *
	 *  List of partners, or persons of contact.
	 */
	partnerships: Array<Partnership> = [];

	/**
	 *
	 *  Links between this patient and healthcare parties.
	 */
	patientHealthCareParties: Array<EncryptedPatientHealthCareParty> = [];

	/**
	 *
	 *  Financial information used to reimburse the patient.
	 */
	financialInstitutionInformation: Array<EncryptedFinancialInstitutionInformation> = [];

	/**
	 *
	 *  Contracts between the patient and the healthcare entity.
	 */
	medicalHouseContracts: Array<EncryptedMedicalHouseContract> = [];

	/**
	 *
	 *  Codified list of professions exercised by this patient.
	 */
	patientProfessions: Array<CodeStub> = [];

	/**
	 *
	 *  Extra parameters.
	 */
	parameters: { [ key: string ]: Array<string> } = {};

	/**
	 *
	 *  Extra properties.
	 */
	properties: Array<EncryptedPropertyStub> = [];

	/**
	 *
	 *  For each couple of HcParties, the AES exchange key.
	 */
	hcPartyKeys: { [ key: string ]: Array<HexString> } = {};

	/**
	 *
	 *  Extra AES exchange keys, indexed by the owner of the pair and target data owner id.
	 */
	aesExchangeKeys: { [ key: string ]: { [ key: string ]: { [ key: string ]: HexString } } } = {};

	/**
	 *
	 *  Keys used to transfer ownership of encrypted data between key pairs.
	 */
	transferKeys: { [ key: string ]: { [ key: string ]: HexString } } = {};

	/**
	 *
	 *  Shamir partitions of the private key.
	 */
	privateKeyShamirPartitions: { [ key: string ]: HexString } = {};

	/**
	 *
	 *  The public key of this patient, used to encrypt data for this patient.
	 */
	publicKey: SpkiHexString | undefined = undefined;

	/**
	 *
	 *  Public keys for OAEP with SHA-256 encryption.
	 */
	publicKeysForOaepWithSha256: Array<SpkiHexString> = [];

	/**
	 *
	 *  The secret patient key, encrypted in the patient's own AES key.
	 */
	secretForeignKeys: Array<string> = [];

	/**
	 *
	 *  The patient id encrypted in the delegates' AES keys.
	 */
	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The delegations giving access to connected healthcare information.
	 */
	delegations: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The keys used to encrypt this entity when stored encrypted.
	 */
	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The base64-encoded encrypted fields of this entity.
	 */
	encryptedSelf: Base64String | undefined = undefined;

	/**
	 *
	 *  The security metadata of the entity.
	 */
	securityMetadata: SecurityMetadata | undefined = undefined;

	/**
	 *
	 *  Properties related to crypto actor functionality.
	 */
	cryptoActorProperties: Array<DecryptedPropertyStub> = [];

	/**
	 *
	 *  Always null for patients.
	 */
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
		if ('cryptoActorProperties' in partial && partial.cryptoActorProperties !== undefined) this.cryptoActorProperties = partial.cryptoActorProperties;
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
		res['cryptoActorProperties'] = this.cryptoActorProperties.map((x0) => x0.toJSON() )
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
			cryptoActorProperties: expectArray(extractEntry(jCpy, 'cryptoActorProperties', false, path), false, [...path, ".cryptoActorProperties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedPropertyStub.fromJSON)),
			parentId: expectNullish(extractEntry(jCpy, 'parentId', false, path), [...path, ".parentId"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedPatient at path ${path.join("")}: ${unused}`)}
		return res
	}

}
