// auto-generated file
import {expectNumber, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


export class EmbeddedTimeTableHour {

	startHour: number;

	endHour: number;

	constructor(partial: Partial<EmbeddedTimeTableHour> & Pick<EmbeddedTimeTableHour, "startHour" | "endHour">) {
		this.startHour = partial.startHour;
		this.endHour = partial.endHour;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['startHour'] = this.startHour
		res['endHour'] = this.endHour
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EmbeddedTimeTableHour']): EmbeddedTimeTableHour {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new EmbeddedTimeTableHour({
			startHour: expectNumber(extractEntry(jCpy, 'startHour', true, path), false, true, [...path, ".startHour"]),
			endHour: expectNumber(extractEntry(jCpy, 'endHour', true, path), false, true, [...path, ".endHour"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EmbeddedTimeTableHour at path ${path.join("")}: ${unused}`)}
		return res
	}

}
