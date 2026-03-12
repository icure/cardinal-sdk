// auto-generated file
import {expectArray, expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {SecureDelegationKeyString} from '../specializations/SecureDelegationKeyString.mjs';
import {AccessLevel} from './AccessLevel.mjs';


/**
 *
 *  Represents a delegation which allows a data owner to access the encrypted data of an entity and
 *  specifies
 *  the access control level. Created by a delegator data owner and usable by a delegate data owner,
 *  using
 *  exchange data for encryption and access control.
 *  /
 */
export class SecureDelegation {

	/**
	 *
	 *  Optionally the id of the delegator data owner. May be null to prevent data leakages.
	 */
	delegator: string | undefined = undefined;

	/**
	 *
	 *  Optionally the id of the delegate data owner. May be null to prevent data leakages.
	 */
	delegate: string | undefined = undefined;

	/**
	 *
	 *  Encrypted secret ids of the entity holding this delegation.
	 */
	secretIds: Array<Base64String> = [];

	/**
	 *
	 *  Encrypted AES keys used for the encryption of the entity's data.
	 */
	encryptionKeys: Array<Base64String> = [];

	/**
	 *
	 *  Encrypted ids of the owning entity (e.g., patient id for a contact).
	 */
	owningEntityIds: Array<Base64String> = [];

	/**
	 *
	 *  Keys of parent delegations in the security metadata.
	 */
	parentDelegations: Array<SecureDelegationKeyString> = [];

	/**
	 *
	 *  The id of the exchange data used for encryption, if both delegator and delegate are explicit.
	 */
	exchangeDataId: string | undefined = undefined;

	/**
	 *
	 *  The access level permissions for users with access to this delegation.
	 */
	permissions: AccessLevel;

	constructor(partial: Partial<SecureDelegation> & Pick<SecureDelegation, "permissions">) {
		if ('delegator' in partial) this.delegator = partial.delegator;
		if ('delegate' in partial) this.delegate = partial.delegate;
		if ('secretIds' in partial && partial.secretIds !== undefined) this.secretIds = partial.secretIds;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('owningEntityIds' in partial && partial.owningEntityIds !== undefined) this.owningEntityIds = partial.owningEntityIds;
		if ('parentDelegations' in partial && partial.parentDelegations !== undefined) this.parentDelegations = partial.parentDelegations;
		if ('exchangeDataId' in partial) this.exchangeDataId = partial.exchangeDataId;
		this.permissions = partial.permissions;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.delegator != undefined) res['delegator'] = this.delegator
		if (this.delegate != undefined) res['delegate'] = this.delegate
		res['secretIds'] = this.secretIds.map((x0) => x0 )
		res['encryptionKeys'] = this.encryptionKeys.map((x0) => x0 )
		res['owningEntityIds'] = this.owningEntityIds.map((x0) => x0 )
		res['parentDelegations'] = this.parentDelegations.map((x0) => x0 )
		if (this.exchangeDataId != undefined) res['exchangeDataId'] = this.exchangeDataId
		res['permissions'] = this.permissions
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['SecureDelegation']): SecureDelegation {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new SecureDelegation({
			delegator: expectString(extractEntry(jCpy, 'delegator', false, path), true, [...path, ".delegator"]),
			delegate: expectString(extractEntry(jCpy, 'delegate', false, path), true, [...path, ".delegate"]),
			secretIds: expectArray(extractEntry(jCpy, 'secretIds', false, path), false, [...path, ".secretIds"], (x0, p0) => expectString(x0, false, p0) as Base64String),
			encryptionKeys: expectArray(extractEntry(jCpy, 'encryptionKeys', false, path), false, [...path, ".encryptionKeys"], (x0, p0) => expectString(x0, false, p0) as Base64String),
			owningEntityIds: expectArray(extractEntry(jCpy, 'owningEntityIds', false, path), false, [...path, ".owningEntityIds"], (x0, p0) => expectString(x0, false, p0) as Base64String),
			parentDelegations: expectArray(extractEntry(jCpy, 'parentDelegations', false, path), false, [...path, ".parentDelegations"], (x0, p0) => expectString(x0, false, p0) as SecureDelegationKeyString),
			exchangeDataId: expectString(extractEntry(jCpy, 'exchangeDataId', false, path), true, [...path, ".exchangeDataId"]),
			permissions: expectStringEnum(extractEntry(jCpy, 'permissions', true, path), false, [...path, ".permissions"], AccessLevel, 'AccessLevel'),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object SecureDelegation at path ${path.join("")}: ${unused}`)}
		return res
	}

}
