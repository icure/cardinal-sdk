// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {DecryptedPropertyStub} from './PropertyStub.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {CryptoActor} from './base/CryptoActor.mjs';
import {DataOwner} from './base/DataOwner.mjs';
import {HasCodes} from './base/HasCodes.mjs';
import {HasTags} from './base/HasTags.mjs';
import {Identifier} from './base/Identifier.mjs';
import {Named} from './base/Named.mjs';
import {Person} from './base/Person.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {DecryptedAddress} from './embed/Address.mjs';
import {DecryptedFinancialInstitutionInformation} from './embed/FinancialInstitutionInformation.mjs';
import {DecryptedFlatRateTarification} from './embed/FlatRateTarification.mjs';
import {Gender} from './embed/Gender.mjs';
import {HealthcarePartyHistoryStatus} from './embed/HealthcarePartyHistoryStatus.mjs';
import {HealthcarePartyStatus} from './embed/HealthcarePartyStatus.mjs';
import {PersonName} from './embed/PersonName.mjs';
import {TelecomType} from './embed/TelecomType.mjs';
import {HexString} from './specializations/HexString.mjs';
import {SpkiHexString} from './specializations/SpkiHexString.mjs';


export class HealthcareParty implements StoredDocument, Named, Person, CryptoActor, DataOwner, HasCodes, HasTags {

	id: string;

	rev: string | undefined = undefined;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	deletionDate: number | undefined = undefined;

	identifier: Array<Identifier> = [];

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	name: string | undefined = undefined;

	lastName: string | undefined = undefined;

	firstName: string | undefined = undefined;

	names: Array<PersonName> = [];

	gender: Gender | undefined = undefined;

	civility: string | undefined = undefined;

	companyName: string | undefined = undefined;

	speciality: string | undefined = undefined;

	bankAccount: string | undefined = undefined;

	bic: string | undefined = undefined;

	proxyBankAccount: string | undefined = undefined;

	proxyBic: string | undefined = undefined;

	invoiceHeader: string | undefined = undefined;

	cbe: string | undefined = undefined;

	ehp: string | undefined = undefined;

	userId: string | undefined = undefined;

	parentId: string | undefined = undefined;

	convention: number | undefined = undefined;

	nihii: string | undefined = undefined;

	nihiiSpecCode: string | undefined = undefined;

	ssin: string | undefined = undefined;

	addresses: Array<DecryptedAddress> = [];

	languages: Array<string> = [];

	picture: Int8Array | undefined = undefined;

	statuses: Array<HealthcarePartyStatus> = [];

	statusHistory: Array<HealthcarePartyHistoryStatus> = [];

	specialityCodes: Array<CodeStub> = [];

	sendFormats: { [ key in TelecomType ]?: string } = {};

	notes: string | undefined = undefined;

	financialInstitutionInformation: Array<DecryptedFinancialInstitutionInformation> = [];

	descr: { [ key: string ]: string } | undefined = {};

	billingType: string | undefined = undefined;

	type: string | undefined = undefined;

	contactPerson: string | undefined = undefined;

	contactPersonHcpId: string | undefined = undefined;

	supervisorId: string | undefined = undefined;

	flatRateTarifications: Array<DecryptedFlatRateTarification> = [];

	importedData: { [ key: string ]: string } = {};

	options: { [ key: string ]: string } = {};

	properties: Array<DecryptedPropertyStub> = [];

	public: boolean = false;

	publicProperties: Array<DecryptedPropertyStub> | undefined = undefined;

	cryptoActorProperties: Array<DecryptedPropertyStub> | undefined = undefined;

	hcPartyKeys: { [ key: string ]: Array<HexString> } = {};

	aesExchangeKeys: { [ key: string ]: { [ key: string ]: { [ key: string ]: HexString } } } = {};

	transferKeys: { [ key: string ]: { [ key: string ]: HexString } } = {};

	privateKeyShamirPartitions: { [ key: string ]: HexString } = {};

	publicKey: SpkiHexString | undefined = undefined;

	publicKeysForOaepWithSha256: Array<SpkiHexString> = [];

	readonly $ktClass: 'com.icure.cardinal.sdk.model.HealthcareParty' = 'com.icure.cardinal.sdk.model.HealthcareParty';

	constructor(partial: Partial<HealthcareParty>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('identifier' in partial && partial.identifier !== undefined) this.identifier = partial.identifier;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('name' in partial) this.name = partial.name;
		if ('lastName' in partial) this.lastName = partial.lastName;
		if ('firstName' in partial) this.firstName = partial.firstName;
		if ('names' in partial && partial.names !== undefined) this.names = partial.names;
		if ('gender' in partial) this.gender = partial.gender;
		if ('civility' in partial) this.civility = partial.civility;
		if ('companyName' in partial) this.companyName = partial.companyName;
		if ('speciality' in partial) this.speciality = partial.speciality;
		if ('bankAccount' in partial) this.bankAccount = partial.bankAccount;
		if ('bic' in partial) this.bic = partial.bic;
		if ('proxyBankAccount' in partial) this.proxyBankAccount = partial.proxyBankAccount;
		if ('proxyBic' in partial) this.proxyBic = partial.proxyBic;
		if ('invoiceHeader' in partial) this.invoiceHeader = partial.invoiceHeader;
		if ('cbe' in partial) this.cbe = partial.cbe;
		if ('ehp' in partial) this.ehp = partial.ehp;
		if ('userId' in partial) this.userId = partial.userId;
		if ('parentId' in partial) this.parentId = partial.parentId;
		if ('convention' in partial) this.convention = partial.convention;
		if ('nihii' in partial) this.nihii = partial.nihii;
		if ('nihiiSpecCode' in partial) this.nihiiSpecCode = partial.nihiiSpecCode;
		if ('ssin' in partial) this.ssin = partial.ssin;
		if ('addresses' in partial && partial.addresses !== undefined) this.addresses = partial.addresses;
		if ('languages' in partial && partial.languages !== undefined) this.languages = partial.languages;
		if ('picture' in partial) this.picture = partial.picture;
		if ('statuses' in partial && partial.statuses !== undefined) this.statuses = partial.statuses;
		if ('statusHistory' in partial && partial.statusHistory !== undefined) this.statusHistory = partial.statusHistory;
		if ('specialityCodes' in partial && partial.specialityCodes !== undefined) this.specialityCodes = partial.specialityCodes;
		if ('sendFormats' in partial && partial.sendFormats !== undefined) this.sendFormats = partial.sendFormats;
		if ('notes' in partial) this.notes = partial.notes;
		if ('financialInstitutionInformation' in partial && partial.financialInstitutionInformation !== undefined) this.financialInstitutionInformation = partial.financialInstitutionInformation;
		if ('descr' in partial) this.descr = partial.descr;
		if ('billingType' in partial) this.billingType = partial.billingType;
		if ('type' in partial) this.type = partial.type;
		if ('contactPerson' in partial) this.contactPerson = partial.contactPerson;
		if ('contactPersonHcpId' in partial) this.contactPersonHcpId = partial.contactPersonHcpId;
		if ('supervisorId' in partial) this.supervisorId = partial.supervisorId;
		if ('flatRateTarifications' in partial && partial.flatRateTarifications !== undefined) this.flatRateTarifications = partial.flatRateTarifications;
		if ('importedData' in partial && partial.importedData !== undefined) this.importedData = partial.importedData;
		if ('options' in partial && partial.options !== undefined) this.options = partial.options;
		if ('properties' in partial && partial.properties !== undefined) this.properties = partial.properties;
		if ('public' in partial && partial.public !== undefined) this.public = partial.public;
		if ('publicProperties' in partial) this.publicProperties = partial.publicProperties;
		if ('cryptoActorProperties' in partial) this.cryptoActorProperties = partial.cryptoActorProperties;
		if ('hcPartyKeys' in partial && partial.hcPartyKeys !== undefined) this.hcPartyKeys = partial.hcPartyKeys;
		if ('aesExchangeKeys' in partial && partial.aesExchangeKeys !== undefined) this.aesExchangeKeys = partial.aesExchangeKeys;
		if ('transferKeys' in partial && partial.transferKeys !== undefined) this.transferKeys = partial.transferKeys;
		if ('privateKeyShamirPartitions' in partial && partial.privateKeyShamirPartitions !== undefined) this.privateKeyShamirPartitions = partial.privateKeyShamirPartitions;
		if ('publicKey' in partial) this.publicKey = partial.publicKey;
		if ('publicKeysForOaepWithSha256' in partial && partial.publicKeysForOaepWithSha256 !== undefined) this.publicKeysForOaepWithSha256 = partial.publicKeysForOaepWithSha256;
	}

}
