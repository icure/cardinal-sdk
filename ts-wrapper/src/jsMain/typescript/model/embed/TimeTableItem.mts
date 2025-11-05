// auto-generated file
import {expectArray, expectBoolean, expectNumber, expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
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

	toJSON(): object {
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

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['TimeTableItem']): TimeTableItem {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new TimeTableItem({
			rruleStartDate: expectNumber(extractEntry(jCpy, 'rruleStartDate', false, path), true, true, [...path, ".rruleStartDate"]),
			rrule: expectString(extractEntry(jCpy, 'rrule', false, path), true, [...path, ".rrule"]),
			notBeforeInMinutes: expectNumber(extractEntry(jCpy, 'notBeforeInMinutes', false, path), true, true, [...path, ".notBeforeInMinutes"]),
			notAfterInMinutes: expectNumber(extractEntry(jCpy, 'notAfterInMinutes', false, path), true, true, [...path, ".notAfterInMinutes"]),
			zoneId: expectString(extractEntry(jCpy, 'zoneId', false, path), true, [...path, ".zoneId"]),
			days: expectArray(extractEntry(jCpy, 'days', false, path), false, [...path, ".days"], (x0, p0) => expectString(x0, false, p0)),
			recurrenceTypes: expectArray(extractEntry(jCpy, 'recurrenceTypes', false, path), false, [...path, ".recurrenceTypes"], (x0, p0) => expectString(x0, false, p0)),
			hours: expectArray(extractEntry(jCpy, 'hours', false, path), false, [...path, ".hours"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, TimeTableHour.fromJSON)),
			calendarItemTypeId: expectString(extractEntry(jCpy, 'calendarItemTypeId', false, path), true, [...path, ".calendarItemTypeId"]),
			homeVisit: expectBoolean(extractEntry(jCpy, 'homeVisit', false, path), false, [...path, ".homeVisit"]),
			placeId: expectString(extractEntry(jCpy, 'placeId', false, path), true, [...path, ".placeId"]),
			publicTimeTableItem: expectBoolean(extractEntry(jCpy, 'publicTimeTableItem', false, path), false, [...path, ".publicTimeTableItem"]),
			acceptsNewPatient: expectBoolean(extractEntry(jCpy, 'acceptsNewPatient', false, path), false, [...path, ".acceptsNewPatient"]),
			unavailable: expectBoolean(extractEntry(jCpy, 'unavailable', false, path), false, [...path, ".unavailable"]),
			reservingRights: expectArray(extractEntry(jCpy, 'reservingRights', false, path), false, [...path, ".reservingRights"], (x0, p0) => expectString(x0, false, p0)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object TimeTableItem at path ${path.join("")}: ${unused}`)}
		return res
	}

}
