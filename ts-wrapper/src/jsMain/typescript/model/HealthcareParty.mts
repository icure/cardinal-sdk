// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectObject, expectString, expectStringEnum, extractEntry} from '../internal/JsonDecodeUtils.mjs';
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
import {Gender} from './embed/Gender.mjs';
import {PersonName} from './embed/PersonName.mjs';
import {AesExchangeKeyEncryptionKeypairIdentifier} from './specializations/AesExchangeKeyEncryptionKeypairIdentifier.mjs';
import {AesExchangeKeyEntryKeyString} from './specializations/AesExchangeKeyEntryKeyString.mjs';
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

	parentId: string | undefined = undefined;

	ssin: string | undefined = undefined;

	addresses: Array<DecryptedAddress> = [];

	languages: Array<string> = [];

	specialityCodes: Array<CodeStub> = [];

	notes: string | undefined = undefined;

	financialInstitutionInformation: Array<DecryptedFinancialInstitutionInformation> = [];

	descr: { [ key: string ]: string } | undefined = {};

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
		if ('parentId' in partial) this.parentId = partial.parentId;
		if ('ssin' in partial) this.ssin = partial.ssin;
		if ('addresses' in partial && partial.addresses !== undefined) this.addresses = partial.addresses;
		if ('languages' in partial && partial.languages !== undefined) this.languages = partial.languages;
		if ('specialityCodes' in partial && partial.specialityCodes !== undefined) this.specialityCodes = partial.specialityCodes;
		if ('notes' in partial) this.notes = partial.notes;
		if ('financialInstitutionInformation' in partial && partial.financialInstitutionInformation !== undefined) this.financialInstitutionInformation = partial.financialInstitutionInformation;
		if ('descr' in partial) this.descr = partial.descr;
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

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		res['identifier'] = this.identifier.map((x0) => x0.toJSON() )
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.name != undefined) res['name'] = this.name
		if (this.lastName != undefined) res['lastName'] = this.lastName
		if (this.firstName != undefined) res['firstName'] = this.firstName
		res['names'] = this.names.map((x0) => x0.toJSON() )
		if (this.gender != undefined) res['gender'] = this.gender
		if (this.civility != undefined) res['civility'] = this.civility
		if (this.companyName != undefined) res['companyName'] = this.companyName
		if (this.speciality != undefined) res['speciality'] = this.speciality
		if (this.bankAccount != undefined) res['bankAccount'] = this.bankAccount
		if (this.bic != undefined) res['bic'] = this.bic
		if (this.proxyBankAccount != undefined) res['proxyBankAccount'] = this.proxyBankAccount
		if (this.proxyBic != undefined) res['proxyBic'] = this.proxyBic
		if (this.invoiceHeader != undefined) res['invoiceHeader'] = this.invoiceHeader
		if (this.parentId != undefined) res['parentId'] = this.parentId
		if (this.ssin != undefined) res['ssin'] = this.ssin
		res['addresses'] = this.addresses.map((x0) => x0.toJSON() )
		res['languages'] = this.languages.map((x0) => x0 )
		res['specialityCodes'] = this.specialityCodes.map((x0) => x0.toJSON() )
		if (this.notes != undefined) res['notes'] = this.notes
		res['financialInstitutionInformation'] = this.financialInstitutionInformation.map((x0) => x0.toJSON() )
		if (this.descr != undefined) res['descr'] = Object.fromEntries(Object.entries(this.descr).map(([k0, v0]) => [k0, v0]))
		res['properties'] = this.properties.map((x0) => x0.toJSON() )
		res['public'] = this.public
		if (this.publicProperties != undefined) res['publicProperties'] = this.publicProperties.map((x0) => x0.toJSON() )
		if (this.cryptoActorProperties != undefined) res['cryptoActorProperties'] = this.cryptoActorProperties.map((x0) => x0.toJSON() )
		res['hcPartyKeys'] = Object.fromEntries(Object.entries(this.hcPartyKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1 )]))
		res['aesExchangeKeys'] = Object.fromEntries(Object.entries(this.aesExchangeKeys).map(([k0, v0]) => [k0, Object.fromEntries(Object.entries(v0).map(([k1, v1]) => [k1, Object.fromEntries(Object.entries(v1).map(([k2, v2]) => [k2, v2]))]))]))
		res['transferKeys'] = Object.fromEntries(Object.entries(this.transferKeys).map(([k0, v0]) => [k0, Object.fromEntries(Object.entries(v0).map(([k1, v1]) => [k1, v1]))]))
		res['privateKeyShamirPartitions'] = Object.fromEntries(Object.entries(this.privateKeyShamirPartitions).map(([k0, v0]) => [k0, v0]))
		if (this.publicKey != undefined) res['publicKey'] = this.publicKey
		res['publicKeysForOaepWithSha256'] = this.publicKeysForOaepWithSha256.map((x0) => x0 )
		res['$ktClass'] = 'com.icure.cardinal.sdk.model.HealthcareParty'
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['HealthcareParty']): HealthcareParty {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.HealthcareParty') throw new Error(`Unexpected value for ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.HealthcareParty". The provided json doesn't represent a HealthcareParty`)
		const res = new HealthcareParty({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			identifier: expectArray(extractEntry(jCpy, 'identifier', false, path), false, [...path, ".identifier"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Identifier.fromJSON)),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			name: expectString(extractEntry(jCpy, 'name', false, path), true, [...path, ".name"]),
			lastName: expectString(extractEntry(jCpy, 'lastName', false, path), true, [...path, ".lastName"]),
			firstName: expectString(extractEntry(jCpy, 'firstName', false, path), true, [...path, ".firstName"]),
			names: expectArray(extractEntry(jCpy, 'names', false, path), false, [...path, ".names"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, PersonName.fromJSON)),
			gender: expectStringEnum(extractEntry(jCpy, 'gender', false, path), true, [...path, ".gender"], Gender, 'Gender'),
			civility: expectString(extractEntry(jCpy, 'civility', false, path), true, [...path, ".civility"]),
			companyName: expectString(extractEntry(jCpy, 'companyName', false, path), true, [...path, ".companyName"]),
			speciality: expectString(extractEntry(jCpy, 'speciality', false, path), true, [...path, ".speciality"]),
			bankAccount: expectString(extractEntry(jCpy, 'bankAccount', false, path), true, [...path, ".bankAccount"]),
			bic: expectString(extractEntry(jCpy, 'bic', false, path), true, [...path, ".bic"]),
			proxyBankAccount: expectString(extractEntry(jCpy, 'proxyBankAccount', false, path), true, [...path, ".proxyBankAccount"]),
			proxyBic: expectString(extractEntry(jCpy, 'proxyBic', false, path), true, [...path, ".proxyBic"]),
			invoiceHeader: expectString(extractEntry(jCpy, 'invoiceHeader', false, path), true, [...path, ".invoiceHeader"]),
			parentId: expectString(extractEntry(jCpy, 'parentId', false, path), true, [...path, ".parentId"]),
			ssin: expectString(extractEntry(jCpy, 'ssin', false, path), true, [...path, ".ssin"]),
			addresses: expectArray(extractEntry(jCpy, 'addresses', false, path), false, [...path, ".addresses"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedAddress.fromJSON)),
			languages: expectArray(extractEntry(jCpy, 'languages', false, path), false, [...path, ".languages"], (x0, p0) => expectString(x0, false, p0)),
			specialityCodes: expectArray(extractEntry(jCpy, 'specialityCodes', false, path), false, [...path, ".specialityCodes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			notes: expectString(extractEntry(jCpy, 'notes', false, path), true, [...path, ".notes"]),
			financialInstitutionInformation: expectArray(extractEntry(jCpy, 'financialInstitutionInformation', false, path), false, [...path, ".financialInstitutionInformation"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedFinancialInstitutionInformation.fromJSON)),
			descr: expectMap(
				extractEntry(jCpy, 'descr', false, path),
				true,
				[...path, ".descr"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			properties: expectArray(extractEntry(jCpy, 'properties', false, path), false, [...path, ".properties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedPropertyStub.fromJSON)),
			public: expectBoolean(extractEntry(jCpy, 'public', false, path), false, [...path, ".public"]),
			publicProperties: expectArray(extractEntry(jCpy, 'publicProperties', false, path), true, [...path, ".publicProperties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedPropertyStub.fromJSON)),
			cryptoActorProperties: expectArray(extractEntry(jCpy, 'cryptoActorProperties', false, path), true, [...path, ".cryptoActorProperties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedPropertyStub.fromJSON)),
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
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object HealthcareParty at path ${path.join("")}: ${unused}`)}
		return res
	}

}
