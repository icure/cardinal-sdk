// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../../utils/Id.mjs';
import {CodeStub} from '../base/CodeStub.mjs';
import {Identifiable} from '../base/Identifiable.mjs';


export class Annotation implements Identifiable<string> {

	id: string;

	author: string | undefined = undefined;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	text: string | undefined = undefined;

	markdown: { [ key: string ]: string } = {};

	location: string | undefined = undefined;

	confidential: boolean | undefined = undefined;

	tags: Array<CodeStub> = [];

	encryptedSelf: string | undefined = undefined;

	constructor(partial: Partial<Annotation>) {
		this.id = partial.id ?? randomUuid();
		if ('author' in partial) this.author = partial.author;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('text' in partial) this.text = partial.text;
		if ('markdown' in partial && partial.markdown !== undefined) this.markdown = partial.markdown;
		if ('location' in partial) this.location = partial.location;
		if ('confidential' in partial) this.confidential = partial.confidential;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.author != undefined) res['author'] = this.author
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.text != undefined) res['text'] = this.text
		res['markdown'] = Object.fromEntries(Object.entries(this.markdown).map(([k0, v0]) => [k0, v0]))
		if (this.location != undefined) res['location'] = this.location
		if (this.confidential != undefined) res['confidential'] = this.confidential
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Annotation']): Annotation {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Annotation({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			text: expectString(extractEntry(jCpy, 'text', false, path), true, [...path, ".text"]),
			markdown: expectMap(
				extractEntry(jCpy, 'markdown', false, path),
				false,
				[...path, ".markdown"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			location: expectString(extractEntry(jCpy, 'location', false, path), true, [...path, ".location"]),
			confidential: expectBoolean(extractEntry(jCpy, 'confidential', false, path), true, [...path, ".confidential"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Annotation at path ${path.join("")}: ${unused}`)}
		return res
	}

}
