// auto-generated file
import {expectNumber, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


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

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Suspension']): Suspension {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Suspension({
			beginMoment: expectNumber(extractEntry(jCpy, 'beginMoment', false, path), true, true, [...path, ".beginMoment"]),
			endMoment: expectNumber(extractEntry(jCpy, 'endMoment', false, path), true, true, [...path, ".endMoment"]),
			suspensionReason: expectString(extractEntry(jCpy, 'suspensionReason', false, path), true, [...path, ".suspensionReason"]),
			lifecycle: expectString(extractEntry(jCpy, 'lifecycle', false, path), true, [...path, ".lifecycle"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Suspension at path ${path.join("")}: ${unused}`)}
		return res
	}

}
