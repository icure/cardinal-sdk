// auto-generated file
import {expectArray, expectNumber, expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {PersonNameUse} from './PersonNameUse.mjs';


export class PersonName {

	lastName: string | undefined = undefined;

	firstNames: Array<string> = [];

	start: number | undefined = undefined;

	end: number | undefined = undefined;

	prefix: Array<string> = [];

	suffix: Array<string> = [];

	text: string | undefined = undefined;

	use: PersonNameUse | undefined = undefined;

	constructor(partial: Partial<PersonName>) {
		if ('lastName' in partial) this.lastName = partial.lastName;
		if ('firstNames' in partial && partial.firstNames !== undefined) this.firstNames = partial.firstNames;
		if ('start' in partial) this.start = partial.start;
		if ('end' in partial) this.end = partial.end;
		if ('prefix' in partial && partial.prefix !== undefined) this.prefix = partial.prefix;
		if ('suffix' in partial && partial.suffix !== undefined) this.suffix = partial.suffix;
		if ('text' in partial) this.text = partial.text;
		if ('use' in partial) this.use = partial.use;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.lastName != undefined) res['lastName'] = this.lastName
		res['firstNames'] = this.firstNames.map((x0) => x0 )
		if (this.start != undefined) res['start'] = this.start
		if (this.end != undefined) res['end'] = this.end
		res['prefix'] = this.prefix.map((x0) => x0 )
		res['suffix'] = this.suffix.map((x0) => x0 )
		if (this.text != undefined) res['text'] = this.text
		if (this.use != undefined) res['use'] = this.use
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['PersonName']): PersonName {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new PersonName({
			lastName: expectString(extractEntry(jCpy.lastName, 'lastName', false, path), true, [...path, ".lastName"]),
			firstNames: expectArray(extractEntry(jCpy.firstNames, 'firstNames', false, path), false, [...path, ".firstNames"], (x0, p0) => expectString(x0, false, p0)),
			start: expectNumber(extractEntry(jCpy.start, 'start', false, path), true, true, [...path, ".start"]),
			end: expectNumber(extractEntry(jCpy.end, 'end', false, path), true, true, [...path, ".end"]),
			prefix: expectArray(extractEntry(jCpy.prefix, 'prefix', false, path), false, [...path, ".prefix"], (x0, p0) => expectString(x0, false, p0)),
			suffix: expectArray(extractEntry(jCpy.suffix, 'suffix', false, path), false, [...path, ".suffix"], (x0, p0) => expectString(x0, false, p0)),
			text: expectString(extractEntry(jCpy.text, 'text', false, path), true, [...path, ".text"]),
			use: expectStringEnum(extractEntry(jCpy.use, 'use', false, path), true, [...path, ".use"], PersonNameUse, 'PersonNameUse'),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object PersonName at path ${path.join("")}: ${unused}`)}
		return res
	}

}
