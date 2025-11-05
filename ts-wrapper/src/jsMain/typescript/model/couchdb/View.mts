// auto-generated file
import {expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


export class View {

	map: string;

	reduce: string | undefined = undefined;

	constructor(partial: Partial<View> & Pick<View, "map">) {
		this.map = partial.map;
		if ('reduce' in partial) this.reduce = partial.reduce;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['map'] = this.map
		if (this.reduce != undefined) res['reduce'] = this.reduce
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['View']): View {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new View({
			map: expectString(extractEntry(jCpy, 'map', true, path), false, [...path, ".map"]),
			reduce: expectString(extractEntry(jCpy, 'reduce', false, path), true, [...path, ".reduce"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object View at path ${path.join("")}: ${unused}`)}
		return res
	}

}
