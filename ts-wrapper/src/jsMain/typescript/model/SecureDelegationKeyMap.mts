// auto-generated file
import {expectArray, expectMap, expectNumber, expectObject, expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {Delegation} from './embed/Delegation.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';
import {Base64String} from './specializations/Base64String.mjs';


export interface SecureDelegationKeyMap extends StoredDocument, HasEncryptionMetadata, Encryptable {

	/**
	 *
	 *
	 *   The secure delegation key this map refers to.
	 */
	delegationKey: string;

	/**
	 *
	 *
	 *   The delegator of the secure delegation key this map refers to, if the delegator is anonymous in the delegation,
	 *   and if not encrypted.
	 *   On the server side this value should always be encrypted.
	 */
	delegator: string | undefined;

	/**
	 *
	 *
	 *   The delegate of the secure delegation key this map refers to, if the delegate is anonymous in the delegation,
	 *   and if not encrypted.
	 *   On the server side this value should always be encrypted.
	 */
	delegate: string | undefined;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

export class DecryptedSecureDelegationKeyMap {

	id: string;

	rev: string | undefined = undefined;

	/**
	 *
	 *
	 *   The secure delegation key this map refers to.
	 */
	delegationKey: string;

	/**
	 *
	 *
	 *   The delegator of the secure delegation key this map refers to, if the delegator is anonymous in the delegation,
	 *   and if not encrypted.
	 *   On the server side this value should always be encrypted.
	 */
	delegator: string | undefined = undefined;

	/**
	 *
	 *
	 *   The delegate of the secure delegation key this map refers to, if the delegate is anonymous in the delegation,
	 *   and if not encrypted.
	 *   On the server side this value should always be encrypted.
	 */
	delegate: string | undefined = undefined;

	/**
	 *
	 *  The delegate of the secure delegation key this map refers to, if the delegate is anonymous in the delegation,
	 *  and if not encrypted.
	 *  On the server side this value should always be encrypted.
	 *  /
	 */
	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

	securityMetadata: SecurityMetadata | undefined = undefined;

	deletionDate: number | undefined = undefined;

	readonly isEncrypted: false = false;

	readonly $ktClass: 'com.icure.cardinal.sdk.model.DecryptedSecureDelegationKeyMap' = 'com.icure.cardinal.sdk.model.DecryptedSecureDelegationKeyMap';

	constructor(partial: Partial<DecryptedSecureDelegationKeyMap> & Pick<DecryptedSecureDelegationKeyMap, "delegationKey">) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		this.delegationKey = partial.delegationKey;
		if ('delegator' in partial) this.delegator = partial.delegator;
		if ('delegate' in partial) this.delegate = partial.delegate;
		if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		res['delegationKey'] = this.delegationKey
		if (this.delegator != undefined) res['delegator'] = this.delegator
		if (this.delegate != undefined) res['delegate'] = this.delegate
		res['secretForeignKeys'] = this.secretForeignKeys.map((x0) => x0 )
		res['cryptedForeignKeys'] = Object.fromEntries(Object.entries(this.cryptedForeignKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['delegations'] = Object.fromEntries(Object.entries(this.delegations).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['encryptionKeys'] = Object.fromEntries(Object.entries(this.encryptionKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		if (this.securityMetadata != undefined) res['securityMetadata'] = this.securityMetadata.toJSON()
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		res['isEncrypted'] = false
		res['$ktClass'] = 'com.icure.cardinal.sdk.model.DecryptedSecureDelegationKeyMap'
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedSecureDelegationKeyMap']): DecryptedSecureDelegationKeyMap {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedSecureDelegationKeyMap`)
		if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.DecryptedSecureDelegationKeyMap') throw new Error(`Unexpected value for ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.DecryptedSecureDelegationKeyMap". The provided json doesn't represent a DecryptedSecureDelegationKeyMap`)
		const res = new DecryptedSecureDelegationKeyMap({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			delegationKey: expectString(extractEntry(jCpy, 'delegationKey', true, path), false, [...path, ".delegationKey"]),
			delegator: expectString(extractEntry(jCpy, 'delegator', false, path), true, [...path, ".delegator"]),
			delegate: expectString(extractEntry(jCpy, 'delegate', false, path), true, [...path, ".delegate"]),
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
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedSecureDelegationKeyMap at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export class EncryptedSecureDelegationKeyMap {

	id: string;

	rev: string | undefined = undefined;

	/**
	 *
	 *
	 *   The secure delegation key this map refers to.
	 */
	delegationKey: string;

	/**
	 *
	 *
	 *   The delegator of the secure delegation key this map refers to, if the delegator is anonymous in the delegation,
	 *   and if not encrypted.
	 *   On the server side this value should always be encrypted.
	 */
	delegator: string | undefined = undefined;

	/**
	 *
	 *
	 *   The delegate of the secure delegation key this map refers to, if the delegate is anonymous in the delegation,
	 *   and if not encrypted.
	 *   On the server side this value should always be encrypted.
	 */
	delegate: string | undefined = undefined;

	/**
	 *
	 *  The delegate of the secure delegation key this map refers to, if the delegate is anonymous in the delegation,
	 *  and if not encrypted.
	 *  On the server side this value should always be encrypted.
	 *  /
	 */
	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

	securityMetadata: SecurityMetadata | undefined = undefined;

	deletionDate: number | undefined = undefined;

	readonly isEncrypted: true = true;

	readonly $ktClass: 'com.icure.cardinal.sdk.model.EncryptedSecureDelegationKeyMap' = 'com.icure.cardinal.sdk.model.EncryptedSecureDelegationKeyMap';

	constructor(partial: Partial<EncryptedSecureDelegationKeyMap> & Pick<EncryptedSecureDelegationKeyMap, "delegationKey">) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		this.delegationKey = partial.delegationKey;
		if ('delegator' in partial) this.delegator = partial.delegator;
		if ('delegate' in partial) this.delegate = partial.delegate;
		if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		res['delegationKey'] = this.delegationKey
		if (this.delegator != undefined) res['delegator'] = this.delegator
		if (this.delegate != undefined) res['delegate'] = this.delegate
		res['secretForeignKeys'] = this.secretForeignKeys.map((x0) => x0 )
		res['cryptedForeignKeys'] = Object.fromEntries(Object.entries(this.cryptedForeignKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['delegations'] = Object.fromEntries(Object.entries(this.delegations).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['encryptionKeys'] = Object.fromEntries(Object.entries(this.encryptionKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		if (this.securityMetadata != undefined) res['securityMetadata'] = this.securityMetadata.toJSON()
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		res['isEncrypted'] = true
		res['$ktClass'] = 'com.icure.cardinal.sdk.model.EncryptedSecureDelegationKeyMap'
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedSecureDelegationKeyMap']): EncryptedSecureDelegationKeyMap {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedSecureDelegationKeyMap`)
		if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.EncryptedSecureDelegationKeyMap') throw new Error(`Unexpected value for ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.EncryptedSecureDelegationKeyMap". The provided json doesn't represent a EncryptedSecureDelegationKeyMap`)
		const res = new EncryptedSecureDelegationKeyMap({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			delegationKey: expectString(extractEntry(jCpy, 'delegationKey', true, path), false, [...path, ".delegationKey"]),
			delegator: expectString(extractEntry(jCpy, 'delegator', false, path), true, [...path, ".delegator"]),
			delegate: expectString(extractEntry(jCpy, 'delegate', false, path), true, [...path, ".delegate"]),
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
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedSecureDelegationKeyMap at path ${path.join("")}: ${unused}`)}
		return res
	}

}
