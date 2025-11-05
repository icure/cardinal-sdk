// auto-generated file
import {expectNumber, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


export type AgendaSlottingAlgorithm = AgendaSlottingAlgorithm.FixedIntervals;

export namespace AgendaSlottingAlgorithm {

	export class FixedIntervals {

		intervalMinutes: number;

		readonly $ktClass: 'com.icure.cardinal.sdk.model.embed.AgendaSlottingAlgorithm.FixedIntervals' = 'com.icure.cardinal.sdk.model.embed.AgendaSlottingAlgorithm.FixedIntervals';

		constructor(partial: Partial<FixedIntervals> & Pick<FixedIntervals, "intervalMinutes">) {
			this.intervalMinutes = partial.intervalMinutes;
		}

		toJSON(): any {
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
