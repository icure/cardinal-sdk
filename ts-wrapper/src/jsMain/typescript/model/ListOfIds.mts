// auto-generated file
import {expectArray, expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';


export class ListOfIds {

	ids: Array<string> = [];

	constructor(partial: Partial<ListOfIds>) {
		if ('ids' in partial && partial.ids !== undefined) this.ids = partial.ids;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['ids'] = this.ids.map((x0) => x0 )
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['ListOfIds']): ListOfIds {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new ListOfIds({
			ids: expectArray(extractEntry(jCpy, 'ids', false, path), false, [...path, ".ids"], (x0, p0) => expectString(x0, false, p0)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object ListOfIds at path ${path.join("")}: ${unused}`)}
		return res
	}

}
