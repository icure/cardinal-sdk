// auto-generated file
import {expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';


export class DataOwnerRegistrationSuccess {

	userLogin: string;

	userId: string;

	token: string;

	constructor(partial: Partial<DataOwnerRegistrationSuccess> & Pick<DataOwnerRegistrationSuccess, "userLogin" | "userId" | "token">) {
		this.userLogin = partial.userLogin;
		this.userId = partial.userId;
		this.token = partial.token;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['userLogin'] = this.userLogin
		res['userId'] = this.userId
		res['token'] = this.token
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DataOwnerRegistrationSuccess']): DataOwnerRegistrationSuccess {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new DataOwnerRegistrationSuccess({
			userLogin: expectString(extractEntry(jCpy, 'userLogin', true, path), false, [...path, ".userLogin"]),
			userId: expectString(extractEntry(jCpy, 'userId', true, path), false, [...path, ".userId"]),
			token: expectString(extractEntry(jCpy, 'token', true, path), false, [...path, ".token"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DataOwnerRegistrationSuccess at path ${path.join("")}: ${unused}`)}
		return res
	}

}
