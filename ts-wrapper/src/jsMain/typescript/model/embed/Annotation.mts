// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectString, requireEntry} from '../../internal/JsonDecodeUtils.mjs';
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

	toJSON(): any {
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

	static fromJSON(json: any, path: Array<string> = ['Annotation']): Annotation {
		return new Annotation({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			author: expectString(json.author, true, [...path, ".author"]),
			created: expectNumber(json.created, true, true, [...path, ".created"]),
			modified: expectNumber(json.modified, true, true, [...path, ".modified"]),
			text: expectString(json.text, true, [...path, ".text"]),
			markdown: expectMap(
				json.markdown,
				false,
				[...path, ".markdown"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			location: expectString(json.location, true, [...path, ".location"]),
			confidential: expectBoolean(json.confidential, true, [...path, ".confidential"]),
			tags: expectArray(json.tags, false, [...path, ".tags"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			encryptedSelf: expectString(json.encryptedSelf, true, [...path, ".encryptedSelf"]),
		})
	}

}
