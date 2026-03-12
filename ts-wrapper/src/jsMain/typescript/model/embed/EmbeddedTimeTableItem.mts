// auto-generated file
import {expectArray, expectBoolean, expectNumber, expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {EmbeddedTimeTableHour} from './EmbeddedTimeTableHour.mjs';


/**
 *
 *  Represents a recurring time table item with scheduling rules, availability slots, and access
 *  control.
 *  /
 */
export class EmbeddedTimeTableItem {

	/**
	 *
	 *  The recurrence rule (RFC 5545 RRULE format) defining the schedule pattern.
	 */
	rrule: string;

	/**
	 *
	 *  The start date of the recurrence rule as an integer (YYYYMMDD).
	 */
	rruleStartDate: number | undefined = undefined;

	/**
	 *
	 *  Minimum number of minutes before the slot that booking is allowed.
	 */
	notBeforeInMinutes: number | undefined = undefined;

	/**
	 *
	 *  Maximum number of minutes after the slot start that booking is allowed.
	 */
	notAfterInMinutes: number | undefined = undefined;

	/**
	 *
	 *  The list of hour ranges within this time table item.
	 */
	hours: Array<EmbeddedTimeTableHour>;

	/**
	 *
	 *  The set of calendar item type identifiers associated with this item.
	 */
	calendarItemTypesIds: Array<string>;

	/**
	 *
	 *  The number of available slots for this time table item.
	 */
	availabilities: number = 1;

	/**
	 *
	 *  The set of identifiers for parties allowed to reserve slots.
	 */
	reservingRights: Array<string> = [];

	/**
	 *
	 *  Whether this time table item is publicly visible.
	 */
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

	toJSON(): object {
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

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EmbeddedTimeTableItem']): EmbeddedTimeTableItem {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new EmbeddedTimeTableItem({
			rrule: expectString(extractEntry(jCpy, 'rrule', true, path), false, [...path, ".rrule"]),
			rruleStartDate: expectNumber(extractEntry(jCpy, 'rruleStartDate', false, path), true, true, [...path, ".rruleStartDate"]),
			notBeforeInMinutes: expectNumber(extractEntry(jCpy, 'notBeforeInMinutes', false, path), true, true, [...path, ".notBeforeInMinutes"]),
			notAfterInMinutes: expectNumber(extractEntry(jCpy, 'notAfterInMinutes', false, path), true, true, [...path, ".notAfterInMinutes"]),
			hours: expectArray(extractEntry(jCpy, 'hours', true, path), false, [...path, ".hours"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, EmbeddedTimeTableHour.fromJSON)),
			calendarItemTypesIds: expectArray(extractEntry(jCpy, 'calendarItemTypesIds', true, path), false, [...path, ".calendarItemTypesIds"], (x0, p0) => expectString(x0, false, p0)),
			availabilities: expectNumber(extractEntry(jCpy, 'availabilities', false, path), false, true, [...path, ".availabilities"]),
			reservingRights: expectArray(extractEntry(jCpy, 'reservingRights', false, path), false, [...path, ".reservingRights"], (x0, p0) => expectString(x0, false, p0)),
			public: expectBoolean(extractEntry(jCpy, 'public', false, path), false, [...path, ".public"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EmbeddedTimeTableItem at path ${path.join("")}: ${unused}`)}
		return res
	}

}
