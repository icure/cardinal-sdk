// auto-generated file
import {expectArray, expectString} from '../../internal/JsonDecodeUtils.mjs';
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

	static fromJSON(json: any, path: Array<string> = ['Delegation']): Delegation {
		return new Delegation({
			owner: expectString(json.owner, true, [...path, ".owner"]),
			delegatedTo: expectString(json.delegatedTo, true, [...path, ".delegatedTo"]),
			key: expectString(json.key, false, [...path, ".key"]),
			tags: expectArray(json.tags, false, [...path, ".tags"], (x0, p0) => expectString(x0, false, p0)),
		})
	}

}
