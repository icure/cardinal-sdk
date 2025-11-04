// auto-generated file
import {expectNumber, requireEntry} from '../../internal/JsonDecodeUtils.mjs';


export class ValueWithPrecision {

	value: number;

	precision: number;

	constructor(partial: Partial<ValueWithPrecision> & Pick<ValueWithPrecision, "value" | "precision">) {
		this.value = partial.value;
		this.precision = partial.precision;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['value'] = this.value
		res['precision'] = this.precision
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['ValueWithPrecision']): ValueWithPrecision {
		return new ValueWithPrecision({
			value: expectNumber(requireEntry(json.value, 'value', path), false, true, [...path, ".value"]),
			precision: expectNumber(requireEntry(json.precision, 'precision', path), false, true, [...path, ".precision"]),
		})
	}

}
