// auto-generated file
import {expectNumber} from '../../internal/JsonDecodeUtils.mjs';


export class Range {

	low: number | undefined = undefined;

	high: number | undefined = undefined;

	constructor(partial: Partial<Range>) {
		if ('low' in partial) this.low = partial.low;
		if ('high' in partial) this.high = partial.high;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.low != undefined) res['low'] = this.low
		if (this.high != undefined) res['high'] = this.high
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['Range']): Range {
		return new Range({
			low: expectNumber(json.low, true, false, [...path, ".low"]),
			high: expectNumber(json.high, true, false, [...path, ".high"]),
		})
	}

}
