// auto-generated file
import {expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';


export class PaginatedDocumentKeyIdPair {

	startKey: any | undefined = undefined;

	startKeyDocId: string | undefined = undefined;

	constructor(partial: Partial<PaginatedDocumentKeyIdPair>) {
		if ('startKey' in partial) this.startKey = partial.startKey;
		if ('startKeyDocId' in partial) this.startKeyDocId = partial.startKeyDocId;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.startKey != undefined) res['startKey'] = this.startKey
		if (this.startKeyDocId != undefined) res['startKeyDocId'] = this.startKeyDocId
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['PaginatedDocumentKeyIdPair']): PaginatedDocumentKeyIdPair {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new PaginatedDocumentKeyIdPair({
			startKey: extractEntry(jCpy, 'startKey', false, path),
			startKeyDocId: expectString(extractEntry(jCpy, 'startKeyDocId', false, path), true, [...path, ".startKeyDocId"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object PaginatedDocumentKeyIdPair at path ${path.join("")}: ${unused}`)}
		return res
	}

}
