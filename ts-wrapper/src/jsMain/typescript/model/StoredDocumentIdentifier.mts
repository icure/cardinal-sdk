// auto-generated file
import {expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {Identifiable} from './base/Identifiable.mjs';


export class StoredDocumentIdentifier implements Identifiable<string> {

	id: string;

	rev: string;

	constructor(partial: Partial<StoredDocumentIdentifier> & Pick<StoredDocumentIdentifier, "rev">) {
		this.id = partial.id ?? randomUuid();
		this.rev = partial.rev;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		res['rev'] = this.rev
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['StoredDocumentIdentifier']): StoredDocumentIdentifier {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new StoredDocumentIdentifier({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', true, path), false, [...path, ".rev"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object StoredDocumentIdentifier at path ${path.join("")}: ${unused}`)}
		return res
	}

}
