// auto-generated file
import {expectArray, expectNumber, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


export class TimeSeries {

	fields: Array<string> = [];

	samples: Array<Array<number>> = [];

	min: Array<number> = [];

	max: Array<number> = [];

	mean: Array<number> = [];

	median: Array<number> = [];

	variance: Array<number> = [];

	constructor(partial: Partial<TimeSeries>) {
		if ('fields' in partial && partial.fields !== undefined) this.fields = partial.fields;
		if ('samples' in partial && partial.samples !== undefined) this.samples = partial.samples;
		if ('min' in partial && partial.min !== undefined) this.min = partial.min;
		if ('max' in partial && partial.max !== undefined) this.max = partial.max;
		if ('mean' in partial && partial.mean !== undefined) this.mean = partial.mean;
		if ('median' in partial && partial.median !== undefined) this.median = partial.median;
		if ('variance' in partial && partial.variance !== undefined) this.variance = partial.variance;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['fields'] = this.fields.map((x0) => x0 )
		res['samples'] = this.samples.map((x0) => x0.map((x1) => x1 ) )
		res['min'] = this.min.map((x0) => x0 )
		res['max'] = this.max.map((x0) => x0 )
		res['mean'] = this.mean.map((x0) => x0 )
		res['median'] = this.median.map((x0) => x0 )
		res['variance'] = this.variance.map((x0) => x0 )
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['TimeSeries']): TimeSeries {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new TimeSeries({
			fields: expectArray(extractEntry(jCpy, 'fields', false, path), false, [...path, ".fields"], (x0, p0) => expectString(x0, false, p0)),
			samples: expectArray(extractEntry(jCpy, 'samples', false, path), false, [...path, ".samples"], (x0, p0) => expectArray(x0, false, p0, (x1, p1) => expectNumber(x1, false, false, p1))),
			min: expectArray(extractEntry(jCpy, 'min', false, path), false, [...path, ".min"], (x0, p0) => expectNumber(x0, false, false, p0)),
			max: expectArray(extractEntry(jCpy, 'max', false, path), false, [...path, ".max"], (x0, p0) => expectNumber(x0, false, false, p0)),
			mean: expectArray(extractEntry(jCpy, 'mean', false, path), false, [...path, ".mean"], (x0, p0) => expectNumber(x0, false, false, p0)),
			median: expectArray(extractEntry(jCpy, 'median', false, path), false, [...path, ".median"], (x0, p0) => expectNumber(x0, false, false, p0)),
			variance: expectArray(extractEntry(jCpy, 'variance', false, path), false, [...path, ".variance"], (x0, p0) => expectNumber(x0, false, false, p0)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object TimeSeries at path ${path.join("")}: ${unused}`)}
		return res
	}

}
