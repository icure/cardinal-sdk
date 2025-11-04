// auto-generated file
import {expectNumber, expectString} from '../../internal/JsonDecodeUtils.mjs';


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

	static fromJSON(json: any, path: Array<string> = ['ReferralPeriod']): ReferralPeriod {
		return new ReferralPeriod({
			startDate: expectNumber(json.startDate, true, true, [...path, ".startDate"]),
			endDate: expectNumber(json.endDate, true, true, [...path, ".endDate"]),
			comment: expectString(json.comment, true, [...path, ".comment"]),
		})
	}

}
