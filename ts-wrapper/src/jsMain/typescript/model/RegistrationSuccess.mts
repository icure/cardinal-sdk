// auto-generated file
import {expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';


/**
 *
 *  DTO returned upon successful user and group registration, containing the identifiers and
 *  initial authentication token needed to access the newly created environment.
 *  /
 */
export class RegistrationSuccess {

	/**
	 *
	 *  The identifier of the newly created group.
	 */
	groupId: string;

	/**
	 *
	 *  The identifier of the newly created user.
	 */
	userId: string;

	/**
	 *
	 *  The initial authentication token for the newly registered user.
	 */
	token: string;

	constructor(partial: Partial<RegistrationSuccess> & Pick<RegistrationSuccess, "groupId" | "userId" | "token">) {
		this.groupId = partial.groupId;
		this.userId = partial.userId;
		this.token = partial.token;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['groupId'] = this.groupId
		res['userId'] = this.userId
		res['token'] = this.token
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['RegistrationSuccess']): RegistrationSuccess {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new RegistrationSuccess({
			groupId: expectString(extractEntry(jCpy, 'groupId', true, path), false, [...path, ".groupId"]),
			userId: expectString(extractEntry(jCpy, 'userId', true, path), false, [...path, ".userId"]),
			token: expectString(extractEntry(jCpy, 'token', true, path), false, [...path, ".token"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object RegistrationSuccess at path ${path.join("")}: ${unused}`)}
		return res
	}

}
