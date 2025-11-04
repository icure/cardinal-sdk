// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectObject, expectString, expectStringEnum, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {AppendixType} from './base/AppendixType.mjs';
import {CodeFlag} from './base/CodeFlag.mjs';
import {CodeIdentification} from './base/CodeIdentification.mjs';
import {LinkQualification} from './base/LinkQualification.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {LetterValue} from './embed/LetterValue.mjs';
import {Periodicity} from './embed/Periodicity.mjs';
import {DecryptedValorisation} from './embed/Valorisation.mjs';


export class Tarification implements StoredDocument, CodeIdentification<string> {

	id: string;

	rev: string | undefined = undefined;

	deletionDate: number | undefined = undefined;

	label: { [ key: string ]: string } | undefined = undefined;

	context: string | undefined = undefined;

	type: string | undefined = undefined;

	code: string | undefined = undefined;

	version: string | undefined = undefined;

	author: string | undefined = undefined;

	regions: Array<string> = [];

	periodicity: Array<Periodicity> = [];

	level: number | undefined = undefined;

	links: Array<string> = [];

	qualifiedLinks: { [ key in LinkQualification ]?: Array<string> } = {};

	flags: Array<CodeFlag> = [];

	searchTerms: { [ key: string ]: Array<string> } = {};

	data: string | undefined = undefined;

	appendices: { [ key in AppendixType ]?: string } = {};

	disabled: boolean = false;

	valorisations: Array<DecryptedValorisation> = [];

	category: { [ key: string ]: string } = {};

	consultationCode: boolean | undefined = undefined;

	hasRelatedCode: boolean | undefined = undefined;

	needsPrescriber: boolean | undefined = undefined;

	relatedCodes: Array<string> = [];

	ngroup: string | undefined = undefined;

	letterValues: Array<LetterValue> = [];

	constructor(partial: Partial<Tarification>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('label' in partial) this.label = partial.label;
		if ('context' in partial) this.context = partial.context;
		if ('type' in partial) this.type = partial.type;
		if ('code' in partial) this.code = partial.code;
		if ('version' in partial) this.version = partial.version;
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
		if ('valorisations' in partial && partial.valorisations !== undefined) this.valorisations = partial.valorisations;
		if ('category' in partial && partial.category !== undefined) this.category = partial.category;
		if ('consultationCode' in partial) this.consultationCode = partial.consultationCode;
		if ('hasRelatedCode' in partial) this.hasRelatedCode = partial.hasRelatedCode;
		if ('needsPrescriber' in partial) this.needsPrescriber = partial.needsPrescriber;
		if ('relatedCodes' in partial && partial.relatedCodes !== undefined) this.relatedCodes = partial.relatedCodes;
		if ('ngroup' in partial) this.ngroup = partial.ngroup;
		if ('letterValues' in partial && partial.letterValues !== undefined) this.letterValues = partial.letterValues;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.label != undefined) res['label'] = Object.fromEntries(Object.entries(this.label).map(([k0, v0]) => [k0, v0]))
		if (this.context != undefined) res['context'] = this.context
		if (this.type != undefined) res['type'] = this.type
		if (this.code != undefined) res['code'] = this.code
		if (this.version != undefined) res['version'] = this.version
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
		res['valorisations'] = this.valorisations.map((x0) => x0.toJSON() )
		res['category'] = Object.fromEntries(Object.entries(this.category).map(([k0, v0]) => [k0, v0]))
		if (this.consultationCode != undefined) res['consultationCode'] = this.consultationCode
		if (this.hasRelatedCode != undefined) res['hasRelatedCode'] = this.hasRelatedCode
		if (this.needsPrescriber != undefined) res['needsPrescriber'] = this.needsPrescriber
		res['relatedCodes'] = this.relatedCodes.map((x0) => x0 )
		if (this.ngroup != undefined) res['ngroup'] = this.ngroup
		res['letterValues'] = this.letterValues.map((x0) => x0.toJSON() )
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Tarification']): Tarification {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Tarification({
			id: expectString(extractEntry(jCpy.id, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy.rev, 'rev', false, path), true, [...path, ".rev"]),
			deletionDate: expectNumber(extractEntry(jCpy.deletionDate, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			label: expectMap(
				extractEntry(jCpy.label, 'label', false, path),
				true,
				[...path, ".label"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			context: expectString(extractEntry(jCpy.context, 'context', false, path), true, [...path, ".context"]),
			type: expectString(extractEntry(jCpy.type, 'type', false, path), true, [...path, ".type"]),
			code: expectString(extractEntry(jCpy.code, 'code', false, path), true, [...path, ".code"]),
			version: expectString(extractEntry(jCpy.version, 'version', false, path), true, [...path, ".version"]),
			author: expectString(extractEntry(jCpy.author, 'author', false, path), true, [...path, ".author"]),
			regions: expectArray(extractEntry(jCpy.regions, 'regions', false, path), false, [...path, ".regions"], (x0, p0) => expectString(x0, false, p0)),
			periodicity: expectArray(extractEntry(jCpy.periodicity, 'periodicity', false, path), false, [...path, ".periodicity"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Periodicity.fromJSON)),
			level: expectNumber(extractEntry(jCpy.level, 'level', false, path), true, true, [...path, ".level"]),
			links: expectArray(extractEntry(jCpy.links, 'links', false, path), false, [...path, ".links"], (x0, p0) => expectString(x0, false, p0)),
			qualifiedLinks: expectMap(
				extractEntry(jCpy.qualifiedLinks, 'qualifiedLinks', false, path),
				false,
				[...path, ".qualifiedLinks"],
				(k0, p0) => expectStringEnum(k0, false, p0, LinkQualification, 'LinkQualification'),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectString(x1, false, p1))
			),
			flags: expectArray(extractEntry(jCpy.flags, 'flags', false, path), false, [...path, ".flags"], (x0, p0) => expectStringEnum(x0, false, p0, CodeFlag, 'CodeFlag')),
			searchTerms: expectMap(
				extractEntry(jCpy.searchTerms, 'searchTerms', false, path),
				false,
				[...path, ".searchTerms"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectString(x1, false, p1))
			),
			data: expectString(extractEntry(jCpy.data, 'data', false, path), true, [...path, ".data"]),
			appendices: expectMap(
				extractEntry(jCpy.appendices, 'appendices', false, path),
				false,
				[...path, ".appendices"],
				(k0, p0) => expectStringEnum(k0, false, p0, AppendixType, 'AppendixType'),
				(v0, p0) => expectString(v0, false, p0)
			),
			disabled: expectBoolean(extractEntry(jCpy.disabled, 'disabled', false, path), false, [...path, ".disabled"]),
			valorisations: expectArray(extractEntry(jCpy.valorisations, 'valorisations', false, path), false, [...path, ".valorisations"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedValorisation.fromJSON)),
			category: expectMap(
				extractEntry(jCpy.category, 'category', false, path),
				false,
				[...path, ".category"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			consultationCode: expectBoolean(extractEntry(jCpy.consultationCode, 'consultationCode', false, path), true, [...path, ".consultationCode"]),
			hasRelatedCode: expectBoolean(extractEntry(jCpy.hasRelatedCode, 'hasRelatedCode', false, path), true, [...path, ".hasRelatedCode"]),
			needsPrescriber: expectBoolean(extractEntry(jCpy.needsPrescriber, 'needsPrescriber', false, path), true, [...path, ".needsPrescriber"]),
			relatedCodes: expectArray(extractEntry(jCpy.relatedCodes, 'relatedCodes', false, path), false, [...path, ".relatedCodes"], (x0, p0) => expectString(x0, false, p0)),
			ngroup: expectString(extractEntry(jCpy.ngroup, 'ngroup', false, path), true, [...path, ".ngroup"]),
			letterValues: expectArray(extractEntry(jCpy.letterValues, 'letterValues', false, path), false, [...path, ".letterValues"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, LetterValue.fromJSON)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Tarification at path ${path.join("")}: ${unused}`)}
		return res
	}

}
