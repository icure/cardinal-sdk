// auto-generated file
import {decodeBase64, encodeBase64} from '../internal/BytesEncoding.mjs';
import {expectArray, expectMap, expectNumber, expectObject, expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {DecryptedPropertyStub} from './PropertyStub.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {CryptoActor} from './base/CryptoActor.mjs';
import {DataOwner} from './base/DataOwner.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {Identifier} from './base/Identifier.mjs';
import {Named} from './base/Named.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {HexString} from './specializations/HexString.mjs';
import {SpkiHexString} from './specializations/SpkiHexString.mjs';


export class Device implements StoredDocument, ICureDocument<string>, Named, CryptoActor, DataOwner {

	id: string;

	rev: string | undefined = undefined;

	deletionDate: number | undefined = undefined;

	identifiers: Array<Identifier> = [];

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	endOfLife: number | undefined = undefined;

	medicalLocationId: string | undefined = undefined;

	externalId: string | undefined = undefined;

	name: string | undefined = undefined;

	type: string | undefined = undefined;

	brand: string | undefined = undefined;

	model: string | undefined = undefined;

	serialNumber: string | undefined = undefined;

	parentId: string | undefined = undefined;

	picture: Int8Array | undefined = undefined;

	properties: Array<DecryptedPropertyStub> = [];

	hcPartyKeys: { [ key: string ]: Array<HexString> } = {};

	aesExchangeKeys: { [ key: string ]: { [ key: string ]: { [ key: string ]: HexString } } } = {};

	transferKeys: { [ key: string ]: { [ key: string ]: HexString } } = {};

	privateKeyShamirPartitions: { [ key: string ]: HexString } = {};

	publicKey: SpkiHexString | undefined = undefined;

	publicKeysForOaepWithSha256: Array<SpkiHexString> = [];

	cryptoActorProperties: Array<DecryptedPropertyStub> | undefined = undefined;

	readonly $ktClass: 'com.icure.cardinal.sdk.model.Device' = 'com.icure.cardinal.sdk.model.Device';

	constructor(partial: Partial<Device>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('identifiers' in partial && partial.identifiers !== undefined) this.identifiers = partial.identifiers;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
		if ('externalId' in partial) this.externalId = partial.externalId;
		if ('name' in partial) this.name = partial.name;
		if ('type' in partial) this.type = partial.type;
		if ('brand' in partial) this.brand = partial.brand;
		if ('model' in partial) this.model = partial.model;
		if ('serialNumber' in partial) this.serialNumber = partial.serialNumber;
		if ('parentId' in partial) this.parentId = partial.parentId;
		if ('picture' in partial) this.picture = partial.picture;
		if ('properties' in partial && partial.properties !== undefined) this.properties = partial.properties;
		if ('hcPartyKeys' in partial && partial.hcPartyKeys !== undefined) this.hcPartyKeys = partial.hcPartyKeys;
		if ('aesExchangeKeys' in partial && partial.aesExchangeKeys !== undefined) this.aesExchangeKeys = partial.aesExchangeKeys;
		if ('transferKeys' in partial && partial.transferKeys !== undefined) this.transferKeys = partial.transferKeys;
		if ('privateKeyShamirPartitions' in partial && partial.privateKeyShamirPartitions !== undefined) this.privateKeyShamirPartitions = partial.privateKeyShamirPartitions;
		if ('publicKey' in partial) this.publicKey = partial.publicKey;
		if ('publicKeysForOaepWithSha256' in partial && partial.publicKeysForOaepWithSha256 !== undefined) this.publicKeysForOaepWithSha256 = partial.publicKeysForOaepWithSha256;
		if ('cryptoActorProperties' in partial) this.cryptoActorProperties = partial.cryptoActorProperties;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		res['identifiers'] = this.identifiers.map((x0) => x0.toJSON() )
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
		if (this.medicalLocationId != undefined) res['medicalLocationId'] = this.medicalLocationId
		if (this.externalId != undefined) res['externalId'] = this.externalId
		if (this.name != undefined) res['name'] = this.name
		if (this.type != undefined) res['type'] = this.type
		if (this.brand != undefined) res['brand'] = this.brand
		if (this.model != undefined) res['model'] = this.model
		if (this.serialNumber != undefined) res['serialNumber'] = this.serialNumber
		if (this.parentId != undefined) res['parentId'] = this.parentId
		if (this.picture != undefined) res['picture'] = encodeBase64(this.picture)
		res['properties'] = this.properties.map((x0) => x0.toJSON() )
		res['hcPartyKeys'] = Object.fromEntries(Object.entries(this.hcPartyKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1 )]))
		res['aesExchangeKeys'] = Object.fromEntries(Object.entries(this.aesExchangeKeys).map(([k0, v0]) => [k0, Object.fromEntries(Object.entries(v0).map(([k1, v1]) => [k1, Object.fromEntries(Object.entries(v1).map(([k2, v2]) => [k2, v2]))]))]))
		res['transferKeys'] = Object.fromEntries(Object.entries(this.transferKeys).map(([k0, v0]) => [k0, Object.fromEntries(Object.entries(v0).map(([k1, v1]) => [k1, v1]))]))
		res['privateKeyShamirPartitions'] = Object.fromEntries(Object.entries(this.privateKeyShamirPartitions).map(([k0, v0]) => [k0, v0]))
		if (this.publicKey != undefined) res['publicKey'] = this.publicKey
		res['publicKeysForOaepWithSha256'] = this.publicKeysForOaepWithSha256.map((x0) => x0 )
		if (this.cryptoActorProperties != undefined) res['cryptoActorProperties'] = this.cryptoActorProperties.map((x0) => x0.toJSON() )
		res['$ktClass'] = 'com.icure.cardinal.sdk.model.Device'
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Device']): Device {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.Device') throw new Error(`Unexpected value for ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.Device". The provided json doesn't represent a Device`)
		const res = new Device({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			identifiers: expectArray(extractEntry(jCpy, 'identifiers', false, path), false, [...path, ".identifiers"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Identifier.fromJSON)),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			endOfLife: expectNumber(extractEntry(jCpy, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			medicalLocationId: expectString(extractEntry(jCpy, 'medicalLocationId', false, path), true, [...path, ".medicalLocationId"]),
			externalId: expectString(extractEntry(jCpy, 'externalId', false, path), true, [...path, ".externalId"]),
			name: expectString(extractEntry(jCpy, 'name', false, path), true, [...path, ".name"]),
			type: expectString(extractEntry(jCpy, 'type', false, path), true, [...path, ".type"]),
			brand: expectString(extractEntry(jCpy, 'brand', false, path), true, [...path, ".brand"]),
			model: expectString(extractEntry(jCpy, 'model', false, path), true, [...path, ".model"]),
			serialNumber: expectString(extractEntry(jCpy, 'serialNumber', false, path), true, [...path, ".serialNumber"]),
			parentId: expectString(extractEntry(jCpy, 'parentId', false, path), true, [...path, ".parentId"]),
			picture: decodeBase64(expectString(extractEntry(jCpy, 'picture', false, path), true, [...path, ".picture"]), [...path, ".picture"]),
			properties: expectArray(extractEntry(jCpy, 'properties', false, path), false, [...path, ".properties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedPropertyStub.fromJSON)),
			hcPartyKeys: expectMap(
				extractEntry(jCpy, 'hcPartyKeys', false, path),
				false,
				[...path, ".hcPartyKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectString(x1, false, p1))
			),
			aesExchangeKeys: expectMap(
				extractEntry(jCpy, 'aesExchangeKeys', false, path),
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
				extractEntry(jCpy, 'transferKeys', false, path),
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
				extractEntry(jCpy, 'privateKeyShamirPartitions', false, path),
				false,
				[...path, ".privateKeyShamirPartitions"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			publicKey: expectString(extractEntry(jCpy, 'publicKey', false, path), true, [...path, ".publicKey"]),
			publicKeysForOaepWithSha256: expectArray(extractEntry(jCpy, 'publicKeysForOaepWithSha256', false, path), false, [...path, ".publicKeysForOaepWithSha256"], (x0, p0) => expectString(x0, false, p0)),
			cryptoActorProperties: expectArray(extractEntry(jCpy, 'cryptoActorProperties', false, path), true, [...path, ".cryptoActorProperties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedPropertyStub.fromJSON)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Device at path ${path.join("")}: ${unused}`)}
		return res
	}

}
