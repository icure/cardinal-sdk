// auto-generated file
import {expectNumber, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


export class ReferralPeriod {

	startDate: number | undefined = undefined;

	endDate: number | undefined = undefined;

	comment: string | undefined = undefined;

	constructor(partial: Partial<ReferralPeriod>) {
		if ('startDate' in partial) this.startDate = partial.startDate;
		if ('endDate' in partial) this.endDate = partial.endDate;
		if ('comment' in partial) this.comment = partial.comment;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.startDate != undefined) res['startDate'] = this.startDate
		if (this.endDate != undefined) res['endDate'] = this.endDate
		if (this.comment != undefined) res['comment'] = this.comment
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['ReferralPeriod']): ReferralPeriod {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new ReferralPeriod({
			startDate: expectNumber(extractEntry(jCpy.startDate, 'startDate', false, path), true, true, [...path, ".startDate"]),
			endDate: expectNumber(extractEntry(jCpy.endDate, 'endDate', false, path), true, true, [...path, ".endDate"]),
			comment: expectString(extractEntry(jCpy.comment, 'comment', false, path), true, [...path, ".comment"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object ReferralPeriod at path ${path.join("")}: ${unused}`)}
		return res
	}

}
