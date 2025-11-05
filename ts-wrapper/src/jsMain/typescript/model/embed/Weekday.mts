// auto-generated file
import {expectNumber, expectObject, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {CodeStub} from '../base/CodeStub.mjs';


export class Weekday {

	weekday: CodeStub | undefined = undefined;

	weekNumber: number | undefined = undefined;

	constructor(partial: Partial<Weekday>) {
		if ('weekday' in partial) this.weekday = partial.weekday;
		if ('weekNumber' in partial) this.weekNumber = partial.weekNumber;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.weekday != undefined) res['weekday'] = this.weekday.toJSON()
		if (this.weekNumber != undefined) res['weekNumber'] = this.weekNumber
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Weekday']): Weekday {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Weekday({
			weekday: expectObject(extractEntry(jCpy, 'weekday', false, path), true, ignoreUnknownKeys, [...path, ".weekday"], CodeStub.fromJSON),
			weekNumber: expectNumber(extractEntry(jCpy, 'weekNumber', false, path), true, true, [...path, ".weekNumber"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Weekday at path ${path.join("")}: ${unused}`)}
		return res
	}

}
