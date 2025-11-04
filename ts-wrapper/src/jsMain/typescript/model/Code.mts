// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectString, expectStringEnum, requireEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {AppendixType} from './base/AppendixType.mjs';
import {CodeFlag} from './base/CodeFlag.mjs';
import {CodeIdentification} from './base/CodeIdentification.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {Periodicity} from './embed/Periodicity.mjs';


export class Code implements StoredDocument, CodeIdentification<string> {

	id: string;

	rev: string | undefined = undefined;

	deletionDate: number | undefined = undefined;

	context: string | undefined = undefined;

	type: string | undefined = undefined;

	code: string | undefined = undefined;

	version: string | undefined = undefined;

	label: { [ key: string ]: string } | undefined = undefined;

	author: string | undefined = undefined;

	regions: Array<string> = [];

	periodicity: Array<Periodicity> = [];

	level: number | undefined = undefined;

	links: Array<string> = [];

	qualifiedLinks: { [ key: string ]: Array<string> } = {};

	flags: Array<CodeFlag> = [];

	searchTerms: { [ key: string ]: Array<string> } = {};

	data: string | undefined = undefined;

	appendices: { [ key in AppendixType ]?: string } = {};

	disabled: boolean = false;

	constructor(partial: Partial<Code>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('context' in partial) this.context = partial.context;
		if ('type' in partial) this.type = partial.type;
		if ('code' in partial) this.code = partial.code;
		if ('version' in partial) this.version = partial.version;
		if ('label' in partial) this.label = partial.label;
		if ('author' in partial) this.author = partial.author;
		if ('regions' in partial && partial.regions !== undefined) this.regions = partial.regions;
		if ('periodicity' in partial && partial.periodicity !== undefined) this.periodicity = partial.periodicity;
		if ('level' in partial) this.level = partial.level;
		if ('links' in partial && partial.links !== undefined) this.links = partial.links;
		if ('qualifiedLinks' in partial && partial.qualifiedLinks !== undefined) this.qualifiedLinks = partial.qualifiedLinks;
		if ('flags' in partial && partial.flags !== undefined) this.flags = partial.flags;
		if ('searchTerms' in partial && partial.searchTerms !== undefined) this.searchTerms = partial.searchTerms;
		if ('data' in partial) this.data = partial.data;
		if ('appendices' in partial && partial.appendices !== undefined) this.appendices = partial.appendices;
		if ('disabled' in partial && partial.disabled !== undefined) this.disabled = partial.disabled;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.context != undefined) res['context'] = this.context
		if (this.type != undefined) res['type'] = this.type
		if (this.code != undefined) res['code'] = this.code
		if (this.version != undefined) res['version'] = this.version
		if (this.label != undefined) res['label'] = Object.fromEntries(Object.entries(this.label).map(([k0, v0]) => [k0, v0]))
		if (this.author != undefined) res['author'] = this.author
		res['regions'] = this.regions.map((x0) => x0 )
		res['periodicity'] = this.periodicity.map((x0) => x0.toJSON() )
		if (this.level != undefined) res['level'] = this.level
		res['links'] = this.links.map((x0) => x0 )
		res['qualifiedLinks'] = Object.fromEntries(Object.entries(this.qualifiedLinks).map(([k0, v0]) => [k0, v0.map((x1) => x1 )]))
		res['flags'] = this.flags.map((x0) => x0 )
		res['searchTerms'] = Object.fromEntries(Object.entries(this.searchTerms).map(([k0, v0]) => [k0, v0.map((x1) => x1 )]))
		if (this.data != undefined) res['data'] = this.data
		res['appendices'] = Object.fromEntries(Object.entries(this.appendices).map(([k0, v0]) => [k0, v0]))
		res['disabled'] = this.disabled
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['Code']): Code {
		return new Code({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			rev: expectString(json.rev, true, [...path, ".rev"]),
			deletionDate: expectNumber(json.deletionDate, true, true, [...path, ".deletionDate"]),
			context: expectString(json.context, true, [...path, ".context"]),
			type: expectString(json.type, true, [...path, ".type"]),
			code: expectString(json.code, true, [...path, ".code"]),
			version: expectString(json.version, true, [...path, ".version"]),
			label: expectMap(
				json.label,
				true,
				[...path, ".label"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			author: expectString(json.author, true, [...path, ".author"]),
			regions: expectArray(json.regions, false, [...path, ".regions"], (x0, p0) => expectString(x0, false, p0)),
			periodicity: expectArray(json.periodicity, false, [...path, ".periodicity"], (x0, p0) => Periodicity.fromJSON(x0, p0)),
			level: expectNumber(json.level, true, true, [...path, ".level"]),
			links: expectArray(json.links, false, [...path, ".links"], (x0, p0) => expectString(x0, false, p0)),
			qualifiedLinks: expectMap(
				json.qualifiedLinks,
				false,
				[...path, ".qualifiedLinks"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectString(x1, false, p1))
			),
			flags: expectArray(json.flags, false, [...path, ".flags"], (x0, p0) => expectStringEnum(x0, false, p0, CodeFlag, 'CodeFlag')),
			searchTerms: expectMap(
				json.searchTerms,
				false,
				[...path, ".searchTerms"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectString(x1, false, p1))
			),
			data: expectString(json.data, true, [...path, ".data"]),
			appendices: expectMap(
				json.appendices,
				false,
				[...path, ".appendices"],
				(k0, p0) => expectStringEnum(k0, false, p0, AppendixType, 'AppendixType'),
				(v0, p0) => expectString(v0, false, p0)
			),
			disabled: expectBoolean(json.disabled, false, [...path, ".disabled"]),
		})
	}

}
