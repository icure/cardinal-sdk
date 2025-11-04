// auto-generated file
import {expectNumber, requireEntry} from '../../internal/JsonDecodeUtils.mjs';


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

	static fromJSON(json: any,
			path: Array<string> = ['EmbeddedTimeTableHour']): EmbeddedTimeTableHour {
		return new EmbeddedTimeTableHour({
			startHour: expectNumber(requireEntry(json.startHour, 'startHour', path), false, true, [...path, ".startHour"]),
			endHour: expectNumber(requireEntry(json.endHour, 'endHour', path), false, true, [...path, ".endHour"]),
		})
	}

}
