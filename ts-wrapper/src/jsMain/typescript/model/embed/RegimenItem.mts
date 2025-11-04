// auto-generated file
import {expectNumber} from '../../internal/JsonDecodeUtils.mjs';
import {CodeStub} from '../base/CodeStub.mjs';
import {AdministrationQuantity} from './AdministrationQuantity.mjs';
import {Weekday} from './Weekday.mjs';


export class RegimenItem {

	date: number | undefined = undefined;

	dayNumber: number | undefined = undefined;

	weekday: Weekday | undefined = undefined;

	dayPeriod: CodeStub | undefined = undefined;

	timeOfDay: number | undefined = undefined;

	administratedQuantity: AdministrationQuantity | undefined = undefined;

	constructor(partial: Partial<RegimenItem>) {
		if ('date' in partial) this.date = partial.date;
		if ('dayNumber' in partial) this.dayNumber = partial.dayNumber;
		if ('weekday' in partial) this.weekday = partial.weekday;
		if ('dayPeriod' in partial) this.dayPeriod = partial.dayPeriod;
		if ('timeOfDay' in partial) this.timeOfDay = partial.timeOfDay;
		if ('administratedQuantity' in partial) this.administratedQuantity = partial.administratedQuantity;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.date != undefined) res['date'] = this.date
		if (this.dayNumber != undefined) res['dayNumber'] = this.dayNumber
		if (this.weekday != undefined) res['weekday'] = this.weekday.toJSON()
		if (this.dayPeriod != undefined) res['dayPeriod'] = this.dayPeriod.toJSON()
		if (this.timeOfDay != undefined) res['timeOfDay'] = this.timeOfDay
		if (this.administratedQuantity != undefined) res['administratedQuantity'] = this.administratedQuantity.toJSON()
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['RegimenItem']): RegimenItem {
		return new RegimenItem({
			date: expectNumber(json.date, true, true, [...path, ".date"]),
			dayNumber: expectNumber(json.dayNumber, true, true, [...path, ".dayNumber"]),
			weekday: Weekday.fromJSON(json.weekday, [...path, ".weekday"]),
			dayPeriod: CodeStub.fromJSON(json.dayPeriod, [...path, ".dayPeriod"]),
			timeOfDay: expectNumber(json.timeOfDay, true, true, [...path, ".timeOfDay"]),
			administratedQuantity: AdministrationQuantity.fromJSON(json.administratedQuantity, [...path, ".administratedQuantity"]),
		})
	}

}
