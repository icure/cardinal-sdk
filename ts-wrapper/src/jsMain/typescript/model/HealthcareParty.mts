// auto-generated file
import {decodeBase64, encodeBase64} from '../internal/BytesEncoding.mjs';
import {expectArray, expectBoolean, expectMap, expectNumber, expectString, expectStringEnum, requireEntry} from '../internal/JsonDecodeUtils.mjs';
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

	toJSON(): any {
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
		if (this.cbe != undefined) res['cbe'] = this.cbe
		if (this.ehp != undefined) res['ehp'] = this.ehp
		if (this.userId != undefined) res['userId'] = this.userId
		if (this.parentId != undefined) res['parentId'] = this.parentId
		if (this.convention != undefined) res['convention'] = this.convention
		if (this.nihii != undefined) res['nihii'] = this.nihii
		if (this.nihiiSpecCode != undefined) res['nihiiSpecCode'] = this.nihiiSpecCode
		if (this.ssin != undefined) res['ssin'] = this.ssin
		res['addresses'] = this.addresses.map((x0) => x0.toJSON() )
		res['languages'] = this.languages.map((x0) => x0 )
		if (this.picture != undefined) res['picture'] = encodeBase64(this.picture)
		res['statuses'] = this.statuses.map((x0) => x0 )
		res['statusHistory'] = this.statusHistory.map((x0) => x0.toJSON() )
		res['specialityCodes'] = this.specialityCodes.map((x0) => x0.toJSON() )
		res['sendFormats'] = Object.fromEntries(Object.entries(this.sendFormats).map(([k0, v0]) => [k0, v0]))
		if (this.notes != undefined) res['notes'] = this.notes
		res['financialInstitutionInformation'] = this.financialInstitutionInformation.map((x0) => x0.toJSON() )
		if (this.descr != undefined) res['descr'] = Object.fromEntries(Object.entries(this.descr).map(([k0, v0]) => [k0, v0]))
		if (this.billingType != undefined) res['billingType'] = this.billingType
		if (this.type != undefined) res['type'] = this.type
		if (this.contactPerson != undefined) res['contactPerson'] = this.contactPerson
		if (this.contactPersonHcpId != undefined) res['contactPersonHcpId'] = this.contactPersonHcpId
		if (this.supervisorId != undefined) res['supervisorId'] = this.supervisorId
		res['flatRateTarifications'] = this.flatRateTarifications.map((x0) => x0.toJSON() )
		res['importedData'] = Object.fromEntries(Object.entries(this.importedData).map(([k0, v0]) => [k0, v0]))
		res['options'] = Object.fromEntries(Object.entries(this.options).map(([k0, v0]) => [k0, v0]))
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
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['HealthcareParty']): HealthcareParty {
		return new HealthcareParty({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			rev: expectString(json.rev, true, [...path, ".rev"]),
			created: expectNumber(json.created, true, true, [...path, ".created"]),
			modified: expectNumber(json.modified, true, true, [...path, ".modified"]),
			deletionDate: expectNumber(json.deletionDate, true, true, [...path, ".deletionDate"]),
			identifier: expectArray(json.identifier, false, [...path, ".identifier"], (x0, p0) => Identifier.fromJSON(x0, p0)),
			tags: expectArray(json.tags, false, [...path, ".tags"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			codes: expectArray(json.codes, false, [...path, ".codes"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			name: expectString(json.name, true, [...path, ".name"]),
			lastName: expectString(json.lastName, true, [...path, ".lastName"]),
			firstName: expectString(json.firstName, true, [...path, ".firstName"]),
			names: expectArray(json.names, false, [...path, ".names"], (x0, p0) => PersonName.fromJSON(x0, p0)),
			gender: expectStringEnum(json.gender, true, [...path, ".gender"], Gender, 'Gender'),
			civility: expectString(json.civility, true, [...path, ".civility"]),
			companyName: expectString(json.companyName, true, [...path, ".companyName"]),
			speciality: expectString(json.speciality, true, [...path, ".speciality"]),
			bankAccount: expectString(json.bankAccount, true, [...path, ".bankAccount"]),
			bic: expectString(json.bic, true, [...path, ".bic"]),
			proxyBankAccount: expectString(json.proxyBankAccount, true, [...path, ".proxyBankAccount"]),
			proxyBic: expectString(json.proxyBic, true, [...path, ".proxyBic"]),
			invoiceHeader: expectString(json.invoiceHeader, true, [...path, ".invoiceHeader"]),
			cbe: expectString(json.cbe, true, [...path, ".cbe"]),
			ehp: expectString(json.ehp, true, [...path, ".ehp"]),
			userId: expectString(json.userId, true, [...path, ".userId"]),
			parentId: expectString(json.parentId, true, [...path, ".parentId"]),
			convention: expectNumber(json.convention, true, true, [...path, ".convention"]),
			nihii: expectString(json.nihii, true, [...path, ".nihii"]),
			nihiiSpecCode: expectString(json.nihiiSpecCode, true, [...path, ".nihiiSpecCode"]),
			ssin: expectString(json.ssin, true, [...path, ".ssin"]),
			addresses: expectArray(json.addresses, false, [...path, ".addresses"], (x0, p0) => DecryptedAddress.fromJSON(x0, p0)),
			languages: expectArray(json.languages, false, [...path, ".languages"], (x0, p0) => expectString(x0, false, p0)),
			picture: decodeBase64(expectString(json.picture, true, [...path, ".picture"]), [...path, ".picture"]),
			statuses: expectArray(json.statuses, false, [...path, ".statuses"], (x0, p0) => expectStringEnum(x0, false, p0, HealthcarePartyStatus, 'HealthcarePartyStatus')),
			statusHistory: expectArray(json.statusHistory, false, [...path, ".statusHistory"], (x0, p0) => HealthcarePartyHistoryStatus.fromJSON(x0, p0)),
			specialityCodes: expectArray(json.specialityCodes, false, [...path, ".specialityCodes"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			sendFormats: expectMap(
				json.sendFormats,
				false,
				[...path, ".sendFormats"],
				(k0, p0) => expectStringEnum(k0, false, p0, TelecomType, 'TelecomType'),
				(v0, p0) => expectString(v0, false, p0)
			),
			notes: expectString(json.notes, true, [...path, ".notes"]),
			financialInstitutionInformation: expectArray(json.financialInstitutionInformation, false, [...path, ".financialInstitutionInformation"], (x0, p0) => DecryptedFinancialInstitutionInformation.fromJSON(x0, p0)),
			descr: expectMap(
				json.descr,
				true,
				[...path, ".descr"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			billingType: expectString(json.billingType, true, [...path, ".billingType"]),
			type: expectString(json.type, true, [...path, ".type"]),
			contactPerson: expectString(json.contactPerson, true, [...path, ".contactPerson"]),
			contactPersonHcpId: expectString(json.contactPersonHcpId, true, [...path, ".contactPersonHcpId"]),
			supervisorId: expectString(json.supervisorId, true, [...path, ".supervisorId"]),
			flatRateTarifications: expectArray(json.flatRateTarifications, false, [...path, ".flatRateTarifications"], (x0, p0) => DecryptedFlatRateTarification.fromJSON(x0, p0)),
			importedData: expectMap(
				json.importedData,
				false,
				[...path, ".importedData"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			options: expectMap(
				json.options,
				false,
				[...path, ".options"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			properties: expectArray(json.properties, false, [...path, ".properties"], (x0, p0) => DecryptedPropertyStub.fromJSON(x0, p0)),
			public: expectBoolean(json.public, false, [...path, ".public"]),
			publicProperties: expectArray(json.publicProperties, true, [...path, ".publicProperties"], (x0, p0) => DecryptedPropertyStub.fromJSON(x0, p0)),
			cryptoActorProperties: expectArray(json.cryptoActorProperties, true, [...path, ".cryptoActorProperties"], (x0, p0) => DecryptedPropertyStub.fromJSON(x0, p0)),
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
		})
	}

}
