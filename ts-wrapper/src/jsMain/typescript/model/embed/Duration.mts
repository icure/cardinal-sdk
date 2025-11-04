// auto-generated file
import {expectNumber} from '../../internal/JsonDecodeUtils.mjs';
import {CodeStub} from '../base/CodeStub.mjs';


export class Duration {

	value: number | undefined = undefined;

	unit: CodeStub | undefined = undefined;

	constructor(partial: Partial<Duration>) {
		if ('value' in partial) this.value = partial.value;
		if ('unit' in partial) this.unit = partial.unit;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.value != undefined) res['value'] = this.value
		if (this.unit != undefined) res['unit'] = this.unit.toJSON()
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['Duration']): Duration {
		return new Duration({
			value: expectNumber(json.value, true, false, [...path, ".value"]),
			unit: CodeStub.fromJSON(json.unit, [...path, ".unit"]),
		})
	}

}
