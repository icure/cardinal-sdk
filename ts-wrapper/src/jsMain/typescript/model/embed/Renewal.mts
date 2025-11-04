// auto-generated file
import {expectNumber} from '../../internal/JsonDecodeUtils.mjs';
import {Duration} from './Duration.mjs';


export class Renewal {

	decimal: number | undefined = undefined;

	duration: Duration | undefined = undefined;

	constructor(partial: Partial<Renewal>) {
		if ('decimal' in partial) this.decimal = partial.decimal;
		if ('duration' in partial) this.duration = partial.duration;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.decimal != undefined) res['decimal'] = this.decimal
		if (this.duration != undefined) res['duration'] = this.duration.toJSON()
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['Renewal']): Renewal {
		return new Renewal({
			decimal: expectNumber(json.decimal, true, true, [...path, ".decimal"]),
			duration: Duration.fromJSON(json.duration, [...path, ".duration"]),
		})
	}

}
