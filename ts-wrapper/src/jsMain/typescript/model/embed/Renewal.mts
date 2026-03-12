// auto-generated file
import {expectNumber, expectObject, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {Duration} from './Duration.mjs';


/**
 *
 *  Represents the renewal information for a medication prescription, including the number of
 *  renewals and their duration.
 *  /
 */
export class Renewal {

	/**
	 *
	 *  The number of authorized renewals.
	 */
	decimal: number | undefined = undefined;

	/**
	 *
	 *  The duration of each renewal period.
	 */
	duration: Duration | undefined = undefined;

	constructor(partial: Partial<Renewal>) {
		if ('decimal' in partial) this.decimal = partial.decimal;
		if ('duration' in partial) this.duration = partial.duration;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.decimal != undefined) res['decimal'] = this.decimal
		if (this.duration != undefined) res['duration'] = this.duration.toJSON()
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Renewal']): Renewal {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Renewal({
			decimal: expectNumber(extractEntry(jCpy, 'decimal', false, path), true, true, [...path, ".decimal"]),
			duration: expectObject(extractEntry(jCpy, 'duration', false, path), true, ignoreUnknownKeys, [...path, ".duration"], Duration.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Renewal at path ${path.join("")}: ${unused}`)}
		return res
	}

}
