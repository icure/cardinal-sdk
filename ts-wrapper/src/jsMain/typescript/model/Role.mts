// auto-generated file
import {expectArray, expectNumber, expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';


/**
 *
 *  The RoleDto class represents a role in the system, which can have permissions and can be
 *  inheritable up to a certain level by users in child Groups.$
 *  down the group hierarchy this role can be inherited by users in child groups. A value of 0 means
 *  it cannot be inherited, while a value of -1 means it can be inherited indefinitely.
 *  /
 */
export class Role implements StoredDocument {

	/**
	 *
	 *  The unique identifier of the role.
	 */
	id: string;

	/**
	 *
	 *  The revision identifier of the role, used for optimistic locking.
	 */
	rev: string | undefined = undefined;

	/**
	 *
	 *  The timestamp of when the role was deleted, if applicable.
	 */
	deletionDate: number | undefined = undefined;

	/**
	 *
	 *  The name of the role.
	 */
	name: string | undefined = undefined;

	/**
	 *
	 *  The maximum level of inheritance for this role, indicating how far
	 */
	inheritableUpTo: number | undefined = undefined;

	/**
	 *
	 *  A set of permissions associated with this role, defining what actions users with this role can
	 *  perform.
	 */
	permissions: Array<string> = [];

	constructor(partial: Partial<Role>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('name' in partial) this.name = partial.name;
		if ('inheritableUpTo' in partial) this.inheritableUpTo = partial.inheritableUpTo;
		if ('permissions' in partial && partial.permissions !== undefined) this.permissions = partial.permissions;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.name != undefined) res['name'] = this.name
		if (this.inheritableUpTo != undefined) res['inheritableUpTo'] = this.inheritableUpTo
		res['permissions'] = this.permissions.map((x0) => x0 )
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Role']): Role {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Role({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			name: expectString(extractEntry(jCpy, 'name', false, path), true, [...path, ".name"]),
			inheritableUpTo: expectNumber(extractEntry(jCpy, 'inheritableUpTo', false, path), true, true, [...path, ".inheritableUpTo"]),
			permissions: expectArray(extractEntry(jCpy, 'permissions', false, path), false, [...path, ".permissions"], (x0, p0) => expectString(x0, false, p0)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Role at path ${path.join("")}: ${unused}`)}
		return res
	}

}
