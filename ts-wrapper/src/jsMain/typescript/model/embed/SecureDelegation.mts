// auto-generated file
import {expectArray, expectString, expectStringEnum, requireEntry} from '../../internal/JsonDecodeUtils.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {SecureDelegationKeyString} from '../specializations/SecureDelegationKeyString.mjs';
import {AccessLevel} from './AccessLevel.mjs';


export class SecureDelegation {

	delegator: string | undefined = undefined;

	delegate: string | undefined = undefined;

	secretIds: Array<Base64String> = [];

	encryptionKeys: Array<Base64String> = [];

	owningEntityIds: Array<Base64String> = [];

	parentDelegations: Array<SecureDelegationKeyString> = [];

	exchangeDataId: string | undefined = undefined;

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

	toJSON(): any {
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

	static fromJSON(json: any, path: Array<string> = ['SecureDelegation']): SecureDelegation {
		return new SecureDelegation({
			delegator: expectString(json.delegator, true, [...path, ".delegator"]),
			delegate: expectString(json.delegate, true, [...path, ".delegate"]),
			secretIds: expectArray(json.secretIds, false, [...path, ".secretIds"], (x0, p0) => expectString(x0, false, p0)),
			encryptionKeys: expectArray(json.encryptionKeys, false, [...path, ".encryptionKeys"], (x0, p0) => expectString(x0, false, p0)),
			owningEntityIds: expectArray(json.owningEntityIds, false, [...path, ".owningEntityIds"], (x0, p0) => expectString(x0, false, p0)),
			parentDelegations: expectArray(json.parentDelegations, false, [...path, ".parentDelegations"], (x0, p0) => expectString(x0, false, p0)),
			exchangeDataId: expectString(json.exchangeDataId, true, [...path, ".exchangeDataId"]),
			permissions: expectStringEnum(requireEntry(json.permissions, 'permissions', path), false, [...path, ".permissions"], AccessLevel, 'AccessLevel'),
		})
	}

}
