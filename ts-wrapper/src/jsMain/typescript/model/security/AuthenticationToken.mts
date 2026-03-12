// auto-generated file
import {expectNumber, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


/**
 *
 *  Represents an authentication token associated with a user, including its creation time and
 *  validity period.
 *  The token value is stored in encrypted form.
 *  /
 */
export class AuthenticationToken {

	/**
	 *
	 *  The encrypted token string.
	 */
	token: string | undefined = undefined;

	/**
	 *
	 *  The epoch-millisecond timestamp at which the token became valid.
	 */
	creationTime: number;

	/**
	 *
	 *  The duration in seconds for which the token remains valid after creation.
	 */
	validity: number;

	/**
	 *
	 *  The epoch-millisecond timestamp of a hard deletion, if the token has been marked for deletion.
	 */
	deletionDate: number | undefined = undefined;

	constructor(partial: Partial<AuthenticationToken> & Pick<AuthenticationToken, "creationTime" | "validity">) {
		if ('token' in partial) this.token = partial.token;
		this.creationTime = partial.creationTime;
		this.validity = partial.validity;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.token != undefined) res['token'] = this.token
		res['creationTime'] = this.creationTime
		res['validity'] = this.validity
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['AuthenticationToken']): AuthenticationToken {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new AuthenticationToken({
			token: expectString(extractEntry(jCpy, 'token', false, path), true, [...path, ".token"]),
			creationTime: expectNumber(extractEntry(jCpy, 'creationTime', true, path), false, true, [...path, ".creationTime"]),
			validity: expectNumber(extractEntry(jCpy, 'validity', true, path), false, true, [...path, ".validity"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object AuthenticationToken at path ${path.join("")}: ${unused}`)}
		return res
	}

}
