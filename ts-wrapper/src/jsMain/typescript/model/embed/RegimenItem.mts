// auto-generated file
import {expectNumber, expectObject, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
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

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.date != undefined) res['date'] = this.date
		if (this.dayNumber != undefined) res['dayNumber'] = this.dayNumber
		if (this.weekday != undefined) res['weekday'] = this.weekday.toJSON()
		if (this.dayPeriod != undefined) res['dayPeriod'] = this.dayPeriod.toJSON()
		if (this.timeOfDay != undefined) res['timeOfDay'] = this.timeOfDay
		if (this.administratedQuantity != undefined) res['administratedQuantity'] = this.administratedQuantity.toJSON()
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['RegimenItem']): RegimenItem {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new RegimenItem({
			date: expectNumber(extractEntry(jCpy, 'date', false, path), true, true, [...path, ".date"]),
			dayNumber: expectNumber(extractEntry(jCpy, 'dayNumber', false, path), true, true, [...path, ".dayNumber"]),
			weekday: expectObject(extractEntry(jCpy, 'weekday', false, path), true, ignoreUnknownKeys, [...path, ".weekday"], Weekday.fromJSON),
			dayPeriod: expectObject(extractEntry(jCpy, 'dayPeriod', false, path), true, ignoreUnknownKeys, [...path, ".dayPeriod"], CodeStub.fromJSON),
			timeOfDay: expectNumber(extractEntry(jCpy, 'timeOfDay', false, path), true, true, [...path, ".timeOfDay"]),
			administratedQuantity: expectObject(extractEntry(jCpy, 'administratedQuantity', false, path), true, ignoreUnknownKeys, [...path, ".administratedQuantity"], AdministrationQuantity.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object RegimenItem at path ${path.join("")}: ${unused}`)}
		return res
	}

}
