// auto-generated file
import {expectArray, expectNumber, expectString, expectStringEnum} from '../../internal/JsonDecodeUtils.mjs';
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

	static fromJSON(json: any, path: Array<string> = ['PersonName']): PersonName {
		return new PersonName({
			lastName: expectString(json.lastName, true, [...path, ".lastName"]),
			firstNames: expectArray(json.firstNames, false, [...path, ".firstNames"], (x0, p0) => expectString(x0, false, p0)),
			start: expectNumber(json.start, true, true, [...path, ".start"]),
			end: expectNumber(json.end, true, true, [...path, ".end"]),
			prefix: expectArray(json.prefix, false, [...path, ".prefix"], (x0, p0) => expectString(x0, false, p0)),
			suffix: expectArray(json.suffix, false, [...path, ".suffix"], (x0, p0) => expectString(x0, false, p0)),
			text: expectString(json.text, true, [...path, ".text"]),
			use: expectStringEnum(json.use, true, [...path, ".use"], PersonNameUse, 'PersonNameUse'),
		})
	}

}
