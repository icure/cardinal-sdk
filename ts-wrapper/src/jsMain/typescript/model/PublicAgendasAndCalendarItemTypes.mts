// auto-generated file
import {expectArray, requireEntry} from '../internal/JsonDecodeUtils.mjs';
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

	static fromJSON(json: any,
			path: Array<string> = ['PublicAgendasAndCalendarItemTypes']): PublicAgendasAndCalendarItemTypes {
		return new PublicAgendasAndCalendarItemTypes({
			agendas: expectArray(requireEntry(json.agendas, 'agendas', path), false, [...path, ".agendas"], (x0, p0) => Agenda.fromJSON(x0, p0)),
			calendarItemTypes: expectArray(requireEntry(json.calendarItemTypes, 'calendarItemTypes', path), false, [...path, ".calendarItemTypes"], (x0, p0) => CalendarItemType.fromJSON(x0, p0)),
		})
	}

}
