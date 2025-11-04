// auto-generated file
import {expectArray, expectMap, expectString, requireEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {DecryptedPropertyStub} from './PropertyStub.mjs';
import {CryptoActor} from './base/CryptoActor.mjs';
import {Versionable} from './base/Versionable.mjs';
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

	toJSON(): any {
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
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['CryptoActorStub']): CryptoActorStub {
		return new CryptoActorStub({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			rev: expectString(requireEntry(json.rev, 'rev', path), false, [...path, ".rev"]),
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
			publicKeysForOaepWithSha256: expectArray(requireEntry(json.publicKeysForOaepWithSha256, 'publicKeysForOaepWithSha256', path), false, [...path, ".publicKeysForOaepWithSha256"], (x0, p0) => expectString(x0, false, p0)),
			parentId: expectString(json.parentId, true, [...path, ".parentId"]),
			cryptoActorProperties: expectArray(json.cryptoActorProperties, true, [...path, ".cryptoActorProperties"], (x0, p0) => DecryptedPropertyStub.fromJSON(x0, p0)),
		})
	}

}
