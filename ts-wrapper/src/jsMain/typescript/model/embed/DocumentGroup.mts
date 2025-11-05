// auto-generated file
import {expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


export class DocumentGroup {

	guid: string | undefined = undefined;

	name: string | undefined = undefined;

	constructor(partial: Partial<DocumentGroup>) {
		if ('guid' in partial) this.guid = partial.guid;
		if ('name' in partial) this.name = partial.name;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.guid != undefined) res['guid'] = this.guid
		if (this.name != undefined) res['name'] = this.name
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DocumentGroup']): DocumentGroup {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new DocumentGroup({
			guid: expectString(extractEntry(jCpy, 'guid', false, path), true, [...path, ".guid"]),
			name: expectString(extractEntry(jCpy, 'name', false, path), true, [...path, ".name"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DocumentGroup at path ${path.join("")}: ${unused}`)}
		return res
	}

}
