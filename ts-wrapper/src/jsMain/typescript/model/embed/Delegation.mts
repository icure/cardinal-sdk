// auto-generated file
import {expectArray, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {HexString} from '../specializations/HexString.mjs';


export class Delegation {

	owner: string | undefined = undefined;

	delegatedTo: string | undefined = undefined;

	key: HexString | undefined = undefined;

	tags: Array<string> = [];

	constructor(partial: Partial<Delegation>) {
		if ('owner' in partial) this.owner = partial.owner;
		if ('delegatedTo' in partial) this.delegatedTo = partial.delegatedTo;
		if ('key' in partial) this.key = partial.key;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.owner != undefined) res['owner'] = this.owner
		if (this.delegatedTo != undefined) res['delegatedTo'] = this.delegatedTo
		if (this.key != undefined) res['key'] = this.key
		res['tags'] = this.tags.map((x0) => x0 )
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Delegation']): Delegation {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Delegation({
			owner: expectString(extractEntry(jCpy, 'owner', false, path), true, [...path, ".owner"]),
			delegatedTo: expectString(extractEntry(jCpy, 'delegatedTo', false, path), true, [...path, ".delegatedTo"]),
			key: expectString(extractEntry(jCpy, 'key', false, path), true, [...path, ".key"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectString(x0, false, p0)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Delegation at path ${path.join("")}: ${unused}`)}
		return res
	}

}
