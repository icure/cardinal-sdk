// auto-generated file
import {expectArray, expectMap, expectObject, expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {DecryptedPropertyStub} from './PropertyStub.mjs';
import {CryptoActor} from './base/CryptoActor.mjs';
import {Versionable} from './base/Versionable.mjs';
import {AesExchangeKeyEncryptionKeypairIdentifier} from './specializations/AesExchangeKeyEncryptionKeypairIdentifier.mjs';
import {AesExchangeKeyEntryKeyString} from './specializations/AesExchangeKeyEntryKeyString.mjs';
import {HexString} from './specializations/HexString.mjs';
import {SpkiHexString} from './specializations/SpkiHexString.mjs';


export class CryptoActorStub implements Versionable<string>, CryptoActor {

	id: string;

	rev: string;

	hcPartyKeys: { [ key: string ]: Array<HexString> } = {};

	aesExchangeKeys: { [ key: string ]: { [ key: string ]: { [ key: string ]: HexString } } } = {};

	transferKeys: { [ key: string ]: { [ key: string ]: HexString } } = {};

	privateKeyShamirPartitions: { [ key: string ]: HexString } = {};

	publicKey: SpkiHexString | undefined = undefined;

	publicKeysForOaepWithSha256: Array<SpkiHexString>;

	parentId: string | undefined = undefined;

	cryptoActorProperties: Array<DecryptedPropertyStub> | undefined = undefined;

	readonly $ktClass: 'com.icure.cardinal.sdk.model.CryptoActorStub' = 'com.icure.cardinal.sdk.model.CryptoActorStub';

	constructor(partial: Partial<CryptoActorStub> & Pick<CryptoActorStub, "rev" | "publicKeysForOaepWithSha256">) {
		this.id = partial.id ?? randomUuid();
		this.rev = partial.rev;
		if ('hcPartyKeys' in partial && partial.hcPartyKeys !== undefined) this.hcPartyKeys = partial.hcPartyKeys;
		if ('aesExchangeKeys' in partial && partial.aesExchangeKeys !== undefined) this.aesExchangeKeys = partial.aesExchangeKeys;
		if ('transferKeys' in partial && partial.transferKeys !== undefined) this.transferKeys = partial.transferKeys;
		if ('privateKeyShamirPartitions' in partial && partial.privateKeyShamirPartitions !== undefined) this.privateKeyShamirPartitions = partial.privateKeyShamirPartitions;
		if ('publicKey' in partial) this.publicKey = partial.publicKey;
		this.publicKeysForOaepWithSha256 = partial.publicKeysForOaepWithSha256;
		if ('parentId' in partial) this.parentId = partial.parentId;
		if ('cryptoActorProperties' in partial) this.cryptoActorProperties = partial.cryptoActorProperties;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		res['rev'] = this.rev
		res['hcPartyKeys'] = Object.fromEntries(Object.entries(this.hcPartyKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1 )]))
		res['aesExchangeKeys'] = Object.fromEntries(Object.entries(this.aesExchangeKeys).map(([k0, v0]) => [k0, Object.fromEntries(Object.entries(v0).map(([k1, v1]) => [k1, Object.fromEntries(Object.entries(v1).map(([k2, v2]) => [k2, v2]))]))]))
		res['transferKeys'] = Object.fromEntries(Object.entries(this.transferKeys).map(([k0, v0]) => [k0, Object.fromEntries(Object.entries(v0).map(([k1, v1]) => [k1, v1]))]))
		res['privateKeyShamirPartitions'] = Object.fromEntries(Object.entries(this.privateKeyShamirPartitions).map(([k0, v0]) => [k0, v0]))
		if (this.publicKey != undefined) res['publicKey'] = this.publicKey
		res['publicKeysForOaepWithSha256'] = this.publicKeysForOaepWithSha256.map((x0) => x0 )
		if (this.parentId != undefined) res['parentId'] = this.parentId
		if (this.cryptoActorProperties != undefined) res['cryptoActorProperties'] = this.cryptoActorProperties.map((x0) => x0.toJSON() )
		res['$ktClass'] = 'com.icure.cardinal.sdk.model.CryptoActorStub'
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['CryptoActorStub']): CryptoActorStub {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.CryptoActorStub') throw new Error(`Unexpected value for ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.CryptoActorStub". The provided json doesn't represent a CryptoActorStub`)
		const res = new CryptoActorStub({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', true, path), false, [...path, ".rev"]),
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
			publicKeysForOaepWithSha256: expectArray(extractEntry(jCpy, 'publicKeysForOaepWithSha256', true, path), false, [...path, ".publicKeysForOaepWithSha256"], (x0, p0) => expectString(x0, false, p0) as SpkiHexString),
			parentId: expectString(extractEntry(jCpy, 'parentId', false, path), true, [...path, ".parentId"]),
			cryptoActorProperties: expectArray(extractEntry(jCpy, 'cryptoActorProperties', false, path), true, [...path, ".cryptoActorProperties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedPropertyStub.fromJSON)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object CryptoActorStub at path ${path.join("")}: ${unused}`)}
		return res
	}

}
