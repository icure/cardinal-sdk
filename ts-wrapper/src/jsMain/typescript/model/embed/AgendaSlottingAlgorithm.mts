// auto-generated file
import {expectNumber, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


export type AgendaSlottingAlgorithm = AgendaSlottingAlgorithm.FixedIntervals;

export namespace AgendaSlottingAlgorithm {

	/**
	 *
	 *
	 *   The appointments can be taken at fixed intervals of [intervalMinutes] starting from the
	 *  beginning of the
	 *   scheduled working hours for the available timetable item.
	 *   # Example
	 *   - Time table item scheduled 09:30-12:00, 12:45-14:00
	 *   - Time table item availabilities 10:03-10:50, 13:00-13:30,
	 *   - [intervalMinutes] = 10
	 *   - Calendar item type duration = 15
	 *   The returned slots for that time table item are 10:10, 10:20, 10:30, 13:05, 13:15
	 */
	export class FixedIntervals {

		intervalMinutes: number;

		readonly $ktClass: 'com.icure.cardinal.sdk.model.embed.AgendaSlottingAlgorithm.FixedIntervals' = 'com.icure.cardinal.sdk.model.embed.AgendaSlottingAlgorithm.FixedIntervals';

		constructor(partial: Partial<FixedIntervals> & Pick<FixedIntervals, "intervalMinutes">) {
			this.intervalMinutes = partial.intervalMinutes;
		}

		toJSON(): object {
			const res: { [k: string]: any } = {}
			res['intervalMinutes'] = this.intervalMinutes
			res['$ktClass'] = 'com.icure.cardinal.sdk.model.embed.AgendaSlottingAlgorithm.FixedIntervals'
			return res
		}

		static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
				path: Array<string> = ['FixedIntervals']): FixedIntervals {
			if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
			const jCpy = { ...json }
			if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.embed.AgendaSlottingAlgorithm.FixedIntervals') throw new Error(`Unexpected value for ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.embed.AgendaSlottingAlgorithm.FixedIntervals". The provided json doesn't represent a FixedIntervals`)
			const res = new FixedIntervals({
				intervalMinutes: expectNumber(extractEntry(jCpy, 'intervalMinutes', true, path), false, true, [...path, ".intervalMinutes"]),
			})
			if (!ignoreUnknownKeys) {
				const unused = Object.keys(jCpy)
				if (unused.length > 0) throw new Error(`Unexpected key(s) for json object FixedIntervals at path ${path.join("")}: ${unused}`)}
			return res
		}

	}

	export function fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['AgendaSlottingAlgorithm']): AgendaSlottingAlgorithm {
		switch ((json as AgendaSlottingAlgorithm).$ktClass) {
			case 'com.icure.cardinal.sdk.model.embed.AgendaSlottingAlgorithm.FixedIntervals': return FixedIntervals.fromJSON(json, ignoreUnknownKeys)
			default: throw new Error('Unexpected discriminator for AgendaSlottingAlgorithm: ' + json.$ktClass)
		}
	}

}
