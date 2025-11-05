// auto-generated file
import {expectArray, expectObject, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {PermissionItem} from './PermissionItem.mjs';


export class Permission {

	grants: Array<PermissionItem> = [];

	revokes: Array<PermissionItem> = [];

	constructor(partial: Partial<Permission>) {
		if ('grants' in partial && partial.grants !== undefined) this.grants = partial.grants;
		if ('revokes' in partial && partial.revokes !== undefined) this.revokes = partial.revokes;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['grants'] = this.grants.map((x0) => x0.toJSON() )
		res['revokes'] = this.revokes.map((x0) => x0.toJSON() )
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Permission']): Permission {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Permission({
			grants: expectArray(extractEntry(jCpy, 'grants', false, path), false, [...path, ".grants"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, PermissionItem.fromJSON)),
			revokes: expectArray(extractEntry(jCpy, 'revokes', false, path), false, [...path, ".revokes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, PermissionItem.fromJSON)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Permission at path ${path.join("")}: ${unused}`)}
		return res
	}

}
