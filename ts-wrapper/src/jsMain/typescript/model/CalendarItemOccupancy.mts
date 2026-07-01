// auto-generated file
import {expectNumber, extractEntry} from '../internal/JsonDecodeUtils.mjs';


/**
 *
 *  One point of a concurrent-occupancy step function for a period of calendar items.
 *
 *  The occupancy of a period is emitted as a sequence of these points, ordered by [timestamp]: each
 *  point
 *  indicates that, starting from [timestamp], the number of overlapping (busy) calendar items
 *  becomes [occupancy].
 *  /
 */
export class CalendarItemOccupancy {

	/**
	 *
	 *  A fuzzy date-time at which the occupancy changes.
	 */
	timestamp: number;

	/**
	 *
	 *  The number of calendar items that are concurrently busy starting from [timestamp].
	 */
	occupancy: number;

	constructor(partial: Partial<CalendarItemOccupancy> & Pick<CalendarItemOccupancy, "timestamp" | "occupancy">) {
		this.timestamp = partial.timestamp;
		this.occupancy = partial.occupancy;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['timestamp'] = this.timestamp
		res['occupancy'] = this.occupancy
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['CalendarItemOccupancy']): CalendarItemOccupancy {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new CalendarItemOccupancy({
			timestamp: expectNumber(extractEntry(jCpy, 'timestamp', true, path), false, true, [...path, ".timestamp"]),
			occupancy: expectNumber(extractEntry(jCpy, 'occupancy', true, path), false, true, [...path, ".occupancy"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object CalendarItemOccupancy at path ${path.join("")}: ${unused}`)}
		return res
	}

}
