// auto-generated file
import {expectNumber} from '../../internal/JsonDecodeUtils.mjs';
import {CodeStub} from '../base/CodeStub.mjs';


export class Weekday {

	weekday: CodeStub | undefined = undefined;

	weekNumber: number | undefined = undefined;

	constructor(partial: Partial<Weekday>) {
		if ('weekday' in partial) this.weekday = partial.weekday;
		if ('weekNumber' in partial) this.weekNumber = partial.weekNumber;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.weekday != undefined) res['weekday'] = this.weekday.toJSON()
		if (this.weekNumber != undefined) res['weekNumber'] = this.weekNumber
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['Weekday']): Weekday {
		return new Weekday({
			weekday: CodeStub.fromJSON(json.weekday, [...path, ".weekday"]),
			weekNumber: expectNumber(json.weekNumber, true, true, [...path, ".weekNumber"]),
		})
	}

}
