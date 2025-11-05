// auto-generated file
import {expectMap, expectNumber, expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';


export class IndexingInfo {

	statuses: { [ key: string ]: number } | undefined = undefined;

	constructor(partial: Partial<IndexingInfo>) {
		if ('statuses' in partial) this.statuses = partial.statuses;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.statuses != undefined) res['statuses'] = Object.fromEntries(Object.entries(this.statuses).map(([k0, v0]) => [k0, v0]))
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['IndexingInfo']): IndexingInfo {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new IndexingInfo({
			statuses: expectMap(
				extractEntry(jCpy, 'statuses', false, path),
				true,
				[...path, ".statuses"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectNumber(v0, false, true, p0)
			),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object IndexingInfo at path ${path.join("")}: ${unused}`)}
		return res
	}

}
