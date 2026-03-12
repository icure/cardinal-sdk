// auto-generated file
import {expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


/**
 *
 *
 *   Data transfer object that uniquely identifies a CouchDB document by its id and revision.
 */
export class DocIdentifier {

	/**
	 *
	 *  The document identifier.
	 */
	id: string | undefined = undefined;

	/**
	 *
	 *  The document revision.
	 */
	rev: string | undefined = undefined;

	constructor(partial: Partial<DocIdentifier>) {
		if ('id' in partial) this.id = partial.id;
		if ('rev' in partial) this.rev = partial.rev;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.id != undefined) res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DocIdentifier']): DocIdentifier {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new DocIdentifier({
			id: expectString(extractEntry(jCpy, 'id', false, path), true, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DocIdentifier at path ${path.join("")}: ${unused}`)}
		return res
	}

}
