// auto-generated file
import {expectNumber, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


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

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Range']): Range {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Range({
			low: expectNumber(extractEntry(jCpy, 'low', false, path), true, false, [...path, ".low"]),
			high: expectNumber(extractEntry(jCpy, 'high', false, path), true, false, [...path, ".high"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Range at path ${path.join("")}: ${unused}`)}
		return res
	}

}
