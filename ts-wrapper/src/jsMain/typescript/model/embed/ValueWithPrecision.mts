// auto-generated file
import {expectNumber, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


export class ValueWithPrecision {

	value: number;

	precision: number;

	constructor(partial: Partial<ValueWithPrecision> & Pick<ValueWithPrecision, "value" | "precision">) {
		this.value = partial.value;
		this.precision = partial.precision;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['value'] = this.value
		res['precision'] = this.precision
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['ValueWithPrecision']): ValueWithPrecision {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new ValueWithPrecision({
			value: expectNumber(extractEntry(jCpy, 'value', true, path), false, true, [...path, ".value"]),
			precision: expectNumber(extractEntry(jCpy, 'precision', true, path), false, true, [...path, ".precision"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object ValueWithPrecision at path ${path.join("")}: ${unused}`)}
		return res
	}

}
