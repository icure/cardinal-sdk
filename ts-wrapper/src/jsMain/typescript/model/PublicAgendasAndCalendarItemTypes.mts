// auto-generated file
import {expectArray, expectObject, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {Agenda} from './Agenda.mjs';
import {CalendarItemType} from './CalendarItemType.mjs';


export class PublicAgendasAndCalendarItemTypes {

	agendas: Array<Agenda>;

	calendarItemTypes: Array<CalendarItemType>;

	constructor(partial: Partial<PublicAgendasAndCalendarItemTypes> & Pick<PublicAgendasAndCalendarItemTypes, "agendas" | "calendarItemTypes">) {
		this.agendas = partial.agendas;
		this.calendarItemTypes = partial.calendarItemTypes;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['agendas'] = this.agendas.map((x0) => x0.toJSON() )
		res['calendarItemTypes'] = this.calendarItemTypes.map((x0) => x0.toJSON() )
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['PublicAgendasAndCalendarItemTypes']): PublicAgendasAndCalendarItemTypes {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new PublicAgendasAndCalendarItemTypes({
			agendas: expectArray(extractEntry(jCpy.agendas, 'agendas', true, path), false, [...path, ".agendas"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Agenda.fromJSON)),
			calendarItemTypes: expectArray(extractEntry(jCpy.calendarItemTypes, 'calendarItemTypes', true, path), false, [...path, ".calendarItemTypes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CalendarItemType.fromJSON)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object PublicAgendasAndCalendarItemTypes at path ${path.join("")}: ${unused}`)}
		return res
	}

}
