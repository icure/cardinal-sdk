// auto-generated file
import {expectArray, expectBoolean, expectNumber, expectString, requireEntry} from '../../internal/JsonDecodeUtils.mjs';
import {EmbeddedTimeTableHour} from './EmbeddedTimeTableHour.mjs';


export class EmbeddedTimeTableItem {

	rrule: string;

	rruleStartDate: number | undefined = undefined;

	notBeforeInMinutes: number | undefined = undefined;

	notAfterInMinutes: number | undefined = undefined;

	hours: Array<EmbeddedTimeTableHour>;

	calendarItemTypesIds: Array<string>;

	availabilities: number = 1;

	reservingRights: Array<string> = [];

	public: boolean = false;

	constructor(partial: Partial<EmbeddedTimeTableItem> & Pick<EmbeddedTimeTableItem, "rrule" | "hours" | "calendarItemTypesIds">) {
		this.rrule = partial.rrule;
		if ('rruleStartDate' in partial) this.rruleStartDate = partial.rruleStartDate;
		if ('notBeforeInMinutes' in partial) this.notBeforeInMinutes = partial.notBeforeInMinutes;
		if ('notAfterInMinutes' in partial) this.notAfterInMinutes = partial.notAfterInMinutes;
		this.hours = partial.hours;
		this.calendarItemTypesIds = partial.calendarItemTypesIds;
		if ('availabilities' in partial && partial.availabilities !== undefined) this.availabilities = partial.availabilities;
		if ('reservingRights' in partial && partial.reservingRights !== undefined) this.reservingRights = partial.reservingRights;
		if ('public' in partial && partial.public !== undefined) this.public = partial.public;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['rrule'] = this.rrule
		if (this.rruleStartDate != undefined) res['rruleStartDate'] = this.rruleStartDate
		if (this.notBeforeInMinutes != undefined) res['notBeforeInMinutes'] = this.notBeforeInMinutes
		if (this.notAfterInMinutes != undefined) res['notAfterInMinutes'] = this.notAfterInMinutes
		res['hours'] = this.hours.map((x0) => x0.toJSON() )
		res['calendarItemTypesIds'] = this.calendarItemTypesIds.map((x0) => x0 )
		res['availabilities'] = this.availabilities
		res['reservingRights'] = this.reservingRights.map((x0) => x0 )
		res['public'] = this.public
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['EmbeddedTimeTableItem']): EmbeddedTimeTableItem {
		return new EmbeddedTimeTableItem({
			rrule: expectString(requireEntry(json.rrule, 'rrule', path), false, [...path, ".rrule"]),
			rruleStartDate: expectNumber(json.rruleStartDate, true, true, [...path, ".rruleStartDate"]),
			notBeforeInMinutes: expectNumber(json.notBeforeInMinutes, true, true, [...path, ".notBeforeInMinutes"]),
			notAfterInMinutes: expectNumber(json.notAfterInMinutes, true, true, [...path, ".notAfterInMinutes"]),
			hours: expectArray(requireEntry(json.hours, 'hours', path), false, [...path, ".hours"], (x0, p0) => EmbeddedTimeTableHour.fromJSON(x0, p0)),
			calendarItemTypesIds: expectArray(requireEntry(json.calendarItemTypesIds, 'calendarItemTypesIds', path), false, [...path, ".calendarItemTypesIds"], (x0, p0) => expectString(x0, false, p0)),
			availabilities: expectNumber(json.availabilities, false, true, [...path, ".availabilities"]),
			reservingRights: expectArray(json.reservingRights, false, [...path, ".reservingRights"], (x0, p0) => expectString(x0, false, p0)),
			public: expectBoolean(json.public, false, [...path, ".public"]),
		})
	}

}
