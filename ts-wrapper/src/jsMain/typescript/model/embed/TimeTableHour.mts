// auto-generated file
import {expectNumber, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


export class TimeTableHour {

	startHour: number | undefined = undefined;

	endHour: number | undefined = undefined;

	constructor(partial: Partial<TimeTableHour>) {
		if ('startHour' in partial) this.startHour = partial.startHour;
		if ('endHour' in partial) this.endHour = partial.endHour;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.startHour != undefined) res['startHour'] = this.startHour
		if (this.endHour != undefined) res['endHour'] = this.endHour
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['TimeTableHour']): TimeTableHour {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new TimeTableHour({
			startHour: expectNumber(extractEntry(jCpy.startHour, 'startHour', false, path), true, true, [...path, ".startHour"]),
			endHour: expectNumber(extractEntry(jCpy.endHour, 'endHour', false, path), true, true, [...path, ".endHour"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object TimeTableHour at path ${path.join("")}: ${unused}`)}
		return res
	}

}
