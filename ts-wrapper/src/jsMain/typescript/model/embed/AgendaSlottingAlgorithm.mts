// auto-generated file
import {expectNumber, requireEntry} from '../../internal/JsonDecodeUtils.mjs';


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
			return res
		}

		static fromJSON(json: any, path: Array<string> = ['FixedIntervals']): FixedIntervals {
			return new FixedIntervals({
				intervalMinutes: expectNumber(requireEntry(json.intervalMinutes, 'intervalMinutes', path), false, true, [...path, ".intervalMinutes"]),
			})
		}

	}

}
