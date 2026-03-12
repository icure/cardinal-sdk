// auto-generated file
import {expectArray, expectObject, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {Agenda} from './Agenda.mjs';
import {CalendarItemType} from './CalendarItemType.mjs';


/**
 *
 *
 *   DTO containing publicly accessible agendas and their associated calendar item types,
 *   used for public appointment booking.
 */
export class PublicAgendasAndCalendarItemTypes {

	/**
	 *
	 *  The list of publicly available agendas.
	 */
	agendas: Array<Agenda> = [];

	/**
	 *
	 *  The list of calendar item types associated with the public agendas.
	 */
	calendarItemTypes: Array<CalendarItemType> = [];

	constructor(partial: Partial<PublicAgendasAndCalendarItemTypes>) {
		if ('agendas' in partial && partial.agendas !== undefined) this.agendas = partial.agendas;
		if ('calendarItemTypes' in partial && partial.calendarItemTypes !== undefined) this.calendarItemTypes = partial.calendarItemTypes;
	}

	toJSON(): object {
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
			agendas: expectArray(extractEntry(jCpy, 'agendas', false, path), false, [...path, ".agendas"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Agenda.fromJSON)),
			calendarItemTypes: expectArray(extractEntry(jCpy, 'calendarItemTypes', false, path), false, [...path, ".calendarItemTypes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CalendarItemType.fromJSON)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object PublicAgendasAndCalendarItemTypes at path ${path.join("")}: ${unused}`)}
		return res
	}

}
