// auto-generated file
import {expectArray, expectNumber, expectString, requireEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';


export class Role implements StoredDocument {

	id: string;

	rev: string | undefined = undefined;

	deletionDate: number | undefined = undefined;

	name: string | undefined = undefined;

	inheritableUpTo: number | undefined = undefined;

	permissions: Array<string> = [];

	constructor(partial: Partial<Role>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('name' in partial) this.name = partial.name;
		if ('inheritableUpTo' in partial) this.inheritableUpTo = partial.inheritableUpTo;
		if ('permissions' in partial && partial.permissions !== undefined) this.permissions = partial.permissions;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.name != undefined) res['name'] = this.name
		if (this.inheritableUpTo != undefined) res['inheritableUpTo'] = this.inheritableUpTo
		res['permissions'] = this.permissions.map((x0) => x0 )
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['Role']): Role {
		return new Role({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			rev: expectString(json.rev, true, [...path, ".rev"]),
			deletionDate: expectNumber(json.deletionDate, true, true, [...path, ".deletionDate"]),
			name: expectString(json.name, true, [...path, ".name"]),
			inheritableUpTo: expectNumber(json.inheritableUpTo, true, true, [...path, ".inheritableUpTo"]),
			permissions: expectArray(json.permissions, false, [...path, ".permissions"], (x0, p0) => expectString(x0, false, p0)),
		})
	}

}
