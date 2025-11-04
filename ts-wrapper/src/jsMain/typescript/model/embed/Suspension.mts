// auto-generated file
import {expectNumber, expectString} from '../../internal/JsonDecodeUtils.mjs';


export class Suspension {

	beginMoment: number | undefined = undefined;

	endMoment: number | undefined = undefined;

	suspensionReason: string | undefined = undefined;

	lifecycle: string | undefined = undefined;

	constructor(partial: Partial<Suspension>) {
		if ('beginMoment' in partial) this.beginMoment = partial.beginMoment;
		if ('endMoment' in partial) this.endMoment = partial.endMoment;
		if ('suspensionReason' in partial) this.suspensionReason = partial.suspensionReason;
		if ('lifecycle' in partial) this.lifecycle = partial.lifecycle;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.beginMoment != undefined) res['beginMoment'] = this.beginMoment
		if (this.endMoment != undefined) res['endMoment'] = this.endMoment
		if (this.suspensionReason != undefined) res['suspensionReason'] = this.suspensionReason
		if (this.lifecycle != undefined) res['lifecycle'] = this.lifecycle
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['Suspension']): Suspension {
		return new Suspension({
			beginMoment: expectNumber(json.beginMoment, true, true, [...path, ".beginMoment"]),
			endMoment: expectNumber(json.endMoment, true, true, [...path, ".endMoment"]),
			suspensionReason: expectString(json.suspensionReason, true, [...path, ".suspensionReason"]),
			lifecycle: expectString(json.lifecycle, true, [...path, ".lifecycle"]),
		})
	}

}
