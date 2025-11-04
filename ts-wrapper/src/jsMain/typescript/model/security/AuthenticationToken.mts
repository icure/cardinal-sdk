// auto-generated file
import {expectNumber, expectString, requireEntry} from '../../internal/JsonDecodeUtils.mjs';


export class AuthenticationToken {

	token: string | undefined = undefined;

	creationTime: number;

	validity: number;

	deletionDate: number | undefined = undefined;

	constructor(partial: Partial<AuthenticationToken> & Pick<AuthenticationToken, "creationTime" | "validity">) {
		if ('token' in partial) this.token = partial.token;
		this.creationTime = partial.creationTime;
		this.validity = partial.validity;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.token != undefined) res['token'] = this.token
		res['creationTime'] = this.creationTime
		res['validity'] = this.validity
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['AuthenticationToken']): AuthenticationToken {
		return new AuthenticationToken({
			token: expectString(json.token, true, [...path, ".token"]),
			creationTime: expectNumber(requireEntry(json.creationTime, 'creationTime', path), false, true, [...path, ".creationTime"]),
			validity: expectNumber(requireEntry(json.validity, 'validity', path), false, true, [...path, ".validity"]),
			deletionDate: expectNumber(json.deletionDate, true, true, [...path, ".deletionDate"]),
		})
	}

}
