// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {CodeIdentification} from './base/CodeIdentification.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';


export class Code implements StoredDocument, CodeIdentification<string> {

	id: string;

	rev: string | undefined = undefined;

	deletionDate: number | undefined = undefined;

	context: string | undefined = undefined;

	type: string | undefined = undefined;

	code: string | undefined = undefined;

	version: string | undefined = undefined;

	label: { [ key: string ]: string } = {};

	author: string | undefined = undefined;

	regions: Array<string> = [];

	links: Array<string> = [];

	qualifiedLinks: { [ key: string ]: Array<string> } = {};

	searchTerms: { [ key: string ]: Array<string> } = {};

	disabled: boolean = false;

	constructor(partial: Partial<Code>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('context' in partial) this.context = partial.context;
		if ('type' in partial) this.type = partial.type;
		if ('code' in partial) this.code = partial.code;
		if ('version' in partial) this.version = partial.version;
		if ('label' in partial && partial.label !== undefined) this.label = partial.label;
		if ('author' in partial) this.author = partial.author;
		if ('regions' in partial && partial.regions !== undefined) this.regions = partial.regions;
		if ('links' in partial && partial.links !== undefined) this.links = partial.links;
		if ('qualifiedLinks' in partial && partial.qualifiedLinks !== undefined) this.qualifiedLinks = partial.qualifiedLinks;
		if ('searchTerms' in partial && partial.searchTerms !== undefined) this.searchTerms = partial.searchTerms;
		if ('disabled' in partial && partial.disabled !== undefined) this.disabled = partial.disabled;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.context != undefined) res['context'] = this.context
		if (this.type != undefined) res['type'] = this.type
		if (this.code != undefined) res['code'] = this.code
		if (this.version != undefined) res['version'] = this.version
		res['label'] = Object.fromEntries(Object.entries(this.label).map(([k0, v0]) => [k0, v0]))
		if (this.author != undefined) res['author'] = this.author
		res['regions'] = this.regions.map((x0) => x0 )
		res['links'] = this.links.map((x0) => x0 )
		res['qualifiedLinks'] = Object.fromEntries(Object.entries(this.qualifiedLinks).map(([k0, v0]) => [k0, v0.map((x1) => x1 )]))
		res['searchTerms'] = Object.fromEntries(Object.entries(this.searchTerms).map(([k0, v0]) => [k0, v0.map((x1) => x1 )]))
		res['disabled'] = this.disabled
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Code']): Code {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Code({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			context: expectString(extractEntry(jCpy, 'context', false, path), true, [...path, ".context"]),
			type: expectString(extractEntry(jCpy, 'type', false, path), true, [...path, ".type"]),
			code: expectString(extractEntry(jCpy, 'code', false, path), true, [...path, ".code"]),
			version: expectString(extractEntry(jCpy, 'version', false, path), true, [...path, ".version"]),
			label: expectMap(
				extractEntry(jCpy, 'label', false, path),
				false,
				[...path, ".label"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			regions: expectArray(extractEntry(jCpy, 'regions', false, path), false, [...path, ".regions"], (x0, p0) => expectString(x0, false, p0)),
			links: expectArray(extractEntry(jCpy, 'links', false, path), false, [...path, ".links"], (x0, p0) => expectString(x0, false, p0)),
			qualifiedLinks: expectMap(
				extractEntry(jCpy, 'qualifiedLinks', false, path),
				false,
				[...path, ".qualifiedLinks"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectString(x1, false, p1))
			),
			searchTerms: expectMap(
				extractEntry(jCpy, 'searchTerms', false, path),
				false,
				[...path, ".searchTerms"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectString(x1, false, p1))
			),
			disabled: expectBoolean(extractEntry(jCpy, 'disabled', false, path), false, [...path, ".disabled"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Code at path ${path.join("")}: ${unused}`)}
		return res
	}

}
