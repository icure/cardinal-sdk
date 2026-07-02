// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../../utils/Id.mjs';
import {CodeStub} from '../base/CodeStub.mjs';
import {Identifiable} from '../base/Identifiable.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';


/**
 *
 *  Text node with attribution that can be attached to a medical record. Used by healthcare parties
 *  to add side notes,
 *  for example to flag a faulty thermometer after taking a temperature.
 *  /
 */
export interface Annotation extends Identifiable<string>, Encryptable {

	/**
	 *
	 *  The identifier of the author of this annotation.
	 */
	author: string | undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) of creation of this note, filled automatically if missing.
	 */
	created: number | undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) of the latest modification of this note, filled automatically
	 *  if missing.
	 */
	modified: number | undefined;

	/**
	 *
	 *  Text contained in the note, written as markdown. Deprecated in favor of [markdown].
	 */
	text: string | undefined;

	/**
	 *
	 *  Localized text contained in the note, written as markdown. Keys should respect ISO 639-1.
	 */
	markdown: { [ key: string ]: string };

	/**
	 *
	 *  Defines to which part of the corresponding information the note is related to.
	 */
	location: string | undefined;

	/**
	 *
	 *  Whether this annotation is confidential.
	 */
	confidential: boolean | undefined;

	/**
	 *
	 *  Tags associated with this annotation.
	 */
	tags: Array<CodeStub>;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

/**
 *
 *  Text node with attribution that can be attached to a medical record. Used by healthcare parties
 *  to add side notes,
 *  for example to flag a faulty thermometer after taking a temperature.
 *  /
 */
export class DecryptedAnnotation {

	/**
	 *
	 *  The Id of the Annotation. We encourage using either a v4 UUID or a HL7 Id.
	 */
	id: string;

	/**
	 *
	 *  The identifier of the author of this annotation.
	 */
	author: string | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) of creation of this note, filled automatically if missing.
	 */
	created: number | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) of the latest modification of this note, filled automatically
	 *  if missing.
	 */
	modified: number | undefined = undefined;

	/**
	 *
	 *  Text contained in the note, written as markdown. Deprecated in favor of [markdown].
	 */
	text: string | undefined = undefined;

	/**
	 *
	 *  Localized text contained in the note, written as markdown. Keys should respect ISO 639-1.
	 */
	markdown: { [ key: string ]: string } = {};

	/**
	 *
	 *  Defines to which part of the corresponding information the note is related to.
	 */
	location: string | undefined = undefined;

	/**
	 *
	 *  Whether this annotation is confidential.
	 */
	confidential: boolean | undefined = undefined;

	/**
	 *
	 *  Tags associated with this annotation.
	 */
	tags: Array<CodeStub> = [];

	/**
	 *
	 *  The encrypted content of this annotation.
	 */
	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedAnnotation>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
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
		res['isEncrypted'] = false
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedAnnotation']): DecryptedAnnotation {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedAnnotation`)
		const res = new DecryptedAnnotation({
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
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedAnnotation at path ${path.join("")}: ${unused}`)}
		return res
	}

}

/**
 *
 *  Text node with attribution that can be attached to a medical record. Used by healthcare parties
 *  to add side notes,
 *  for example to flag a faulty thermometer after taking a temperature.
 *  /
 */
export class EncryptedAnnotation {

	/**
	 *
	 *  The Id of the Annotation. We encourage using either a v4 UUID or a HL7 Id.
	 */
	id: string;

	/**
	 *
	 *  The identifier of the author of this annotation.
	 */
	author: string | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) of creation of this note, filled automatically if missing.
	 */
	created: number | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) of the latest modification of this note, filled automatically
	 *  if missing.
	 */
	modified: number | undefined = undefined;

	/**
	 *
	 *  Text contained in the note, written as markdown. Deprecated in favor of [markdown].
	 */
	text: string | undefined = undefined;

	/**
	 *
	 *  Localized text contained in the note, written as markdown. Keys should respect ISO 639-1.
	 */
	markdown: { [ key: string ]: string } = {};

	/**
	 *
	 *  Defines to which part of the corresponding information the note is related to.
	 */
	location: string | undefined = undefined;

	/**
	 *
	 *  Whether this annotation is confidential.
	 */
	confidential: boolean | undefined = undefined;

	/**
	 *
	 *  Tags associated with this annotation.
	 */
	tags: Array<CodeStub> = [];

	/**
	 *
	 *  The encrypted content of this annotation.
	 */
	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedAnnotation>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
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
		res['isEncrypted'] = true
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedAnnotation']): EncryptedAnnotation {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedAnnotation`)
		const res = new EncryptedAnnotation({
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
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedAnnotation at path ${path.join("")}: ${unused}`)}
		return res
	}

}
