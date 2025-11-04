// auto-generated file
import {expectArray, expectBoolean, expectNumber, expectString} from '../../internal/JsonDecodeUtils.mjs';
import {TimeTableHour} from './TimeTableHour.mjs';


export class TimeTableItem {

	rruleStartDate: number | undefined = undefined;

	rrule: string | undefined = undefined;

	notBeforeInMinutes: number | undefined = undefined;

	notAfterInMinutes: number | undefined = undefined;

	zoneId: string | undefined = undefined;

	days: Array<string> = [];

	recurrenceTypes: Array<string> = [];

	hours: Array<TimeTableHour> = [];

	calendarItemTypeId: string | undefined = undefined;

	homeVisit: boolean = false;

	placeId: string | undefined = undefined;

	publicTimeTableItem: boolean = false;

	acceptsNewPatient: boolean = true;

	unavailable: boolean = false;

	reservingRights: Array<string> = [];

	constructor(partial: Partial<TimeTableItem>) {
		if ('rruleStartDate' in partial) this.rruleStartDate = partial.rruleStartDate;
		if ('rrule' in partial) this.rrule = partial.rrule;
		if ('notBeforeInMinutes' in partial) this.notBeforeInMinutes = partial.notBeforeInMinutes;
		if ('notAfterInMinutes' in partial) this.notAfterInMinutes = partial.notAfterInMinutes;
		if ('zoneId' in partial) this.zoneId = partial.zoneId;
		if ('days' in partial && partial.days !== undefined) this.days = partial.days;
		if ('recurrenceTypes' in partial && partial.recurrenceTypes !== undefined) this.recurrenceTypes = partial.recurrenceTypes;
		if ('hours' in partial && partial.hours !== undefined) this.hours = partial.hours;
		if ('calendarItemTypeId' in partial) this.calendarItemTypeId = partial.calendarItemTypeId;
		if ('homeVisit' in partial && partial.homeVisit !== undefined) this.homeVisit = partial.homeVisit;
		if ('placeId' in partial) this.placeId = partial.placeId;
		if ('publicTimeTableItem' in partial && partial.publicTimeTableItem !== undefined) this.publicTimeTableItem = partial.publicTimeTableItem;
		if ('acceptsNewPatient' in partial && partial.acceptsNewPatient !== undefined) this.acceptsNewPatient = partial.acceptsNewPatient;
		if ('unavailable' in partial && partial.unavailable !== undefined) this.unavailable = partial.unavailable;
		if ('reservingRights' in partial && partial.reservingRights !== undefined) this.reservingRights = partial.reservingRights;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.rruleStartDate != undefined) res['rruleStartDate'] = this.rruleStartDate
		if (this.rrule != undefined) res['rrule'] = this.rrule
		if (this.notBeforeInMinutes != undefined) res['notBeforeInMinutes'] = this.notBeforeInMinutes
		if (this.notAfterInMinutes != undefined) res['notAfterInMinutes'] = this.notAfterInMinutes
		if (this.zoneId != undefined) res['zoneId'] = this.zoneId
		res['days'] = this.days.map((x0) => x0 )
		res['recurrenceTypes'] = this.recurrenceTypes.map((x0) => x0 )
		res['hours'] = this.hours.map((x0) => x0.toJSON() )
		if (this.calendarItemTypeId != undefined) res['calendarItemTypeId'] = this.calendarItemTypeId
		res['homeVisit'] = this.homeVisit
		if (this.placeId != undefined) res['placeId'] = this.placeId
		res['publicTimeTableItem'] = this.publicTimeTableItem
		res['acceptsNewPatient'] = this.acceptsNewPatient
		res['unavailable'] = this.unavailable
		res['reservingRights'] = this.reservingRights.map((x0) => x0 )
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['TimeTableItem']): TimeTableItem {
		return new TimeTableItem({
			rruleStartDate: expectNumber(json.rruleStartDate, true, true, [...path, ".rruleStartDate"]),
			rrule: expectString(json.rrule, true, [...path, ".rrule"]),
			notBeforeInMinutes: expectNumber(json.notBeforeInMinutes, true, true, [...path, ".notBeforeInMinutes"]),
			notAfterInMinutes: expectNumber(json.notAfterInMinutes, true, true, [...path, ".notAfterInMinutes"]),
			zoneId: expectString(json.zoneId, true, [...path, ".zoneId"]),
			days: expectArray(json.days, false, [...path, ".days"], (x0, p0) => expectString(x0, false, p0)),
			recurrenceTypes: expectArray(json.recurrenceTypes, false, [...path, ".recurrenceTypes"], (x0, p0) => expectString(x0, false, p0)),
			hours: expectArray(json.hours, false, [...path, ".hours"], (x0, p0) => TimeTableHour.fromJSON(x0, p0)),
			calendarItemTypeId: expectString(json.calendarItemTypeId, true, [...path, ".calendarItemTypeId"]),
			homeVisit: expectBoolean(json.homeVisit, false, [...path, ".homeVisit"]),
			placeId: expectString(json.placeId, true, [...path, ".placeId"]),
			publicTimeTableItem: expectBoolean(json.publicTimeTableItem, false, [...path, ".publicTimeTableItem"]),
			acceptsNewPatient: expectBoolean(json.acceptsNewPatient, false, [...path, ".acceptsNewPatient"]),
			unavailable: expectBoolean(json.unavailable, false, [...path, ".unavailable"]),
			reservingRights: expectArray(json.reservingRights, false, [...path, ".reservingRights"], (x0, p0) => expectString(x0, false, p0)),
		})
	}

}
