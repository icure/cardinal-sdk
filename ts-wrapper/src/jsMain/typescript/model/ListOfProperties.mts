// auto-generated file
import {expectArray, expectObject, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {DecryptedPropertyStub} from './PropertyStub.mjs';


export class ListOfProperties {

	properties: Array<DecryptedPropertyStub> = [];

	constructor(partial: Partial<ListOfProperties>) {
		if ('properties' in partial && partial.properties !== undefined) this.properties = partial.properties;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['properties'] = this.properties.map((x0) => x0.toJSON() )
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['ListOfProperties']): ListOfProperties {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new ListOfProperties({
			properties: expectArray(extractEntry(jCpy, 'properties', false, path), false, [...path, ".properties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedPropertyStub.fromJSON)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object ListOfProperties at path ${path.join("")}: ${unused}`)}
		return res
	}

}
