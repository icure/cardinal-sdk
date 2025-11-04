// auto-generated file
import {expectNumber} from '../../internal/JsonDecodeUtils.mjs';


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

	static fromJSON(json: any, path: Array<string> = ['TimeTableHour']): TimeTableHour {
		return new TimeTableHour({
			startHour: expectNumber(json.startHour, true, true, [...path, ".startHour"]),
			endHour: expectNumber(json.endHour, true, true, [...path, ".endHour"]),
		})
	}

}
