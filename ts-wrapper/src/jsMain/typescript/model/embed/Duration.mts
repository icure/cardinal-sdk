// auto-generated file
import {expectNumber, expectObject, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {CodeStub} from '../base/CodeStub.mjs';


export class Duration {

	value: number | undefined = undefined;

	unit: CodeStub | undefined = undefined;

	constructor(partial: Partial<Duration>) {
		if ('value' in partial) this.value = partial.value;
		if ('unit' in partial) this.unit = partial.unit;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.value != undefined) res['value'] = this.value
		if (this.unit != undefined) res['unit'] = this.unit.toJSON()
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Duration']): Duration {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Duration({
			value: expectNumber(extractEntry(jCpy, 'value', false, path), true, false, [...path, ".value"]),
			unit: expectObject(extractEntry(jCpy, 'unit', false, path), true, ignoreUnknownKeys, [...path, ".unit"], CodeStub.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Duration at path ${path.join("")}: ${unused}`)}
		return res
	}

}
