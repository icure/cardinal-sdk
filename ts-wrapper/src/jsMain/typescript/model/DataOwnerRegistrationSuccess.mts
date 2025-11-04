// auto-generated file
import {expectString, requireEntry} from '../internal/JsonDecodeUtils.mjs';


export class DataOwnerRegistrationSuccess {

	userLogin: string;

	userId: string;

	token: string;

	constructor(partial: Partial<DataOwnerRegistrationSuccess> & Pick<DataOwnerRegistrationSuccess, "userLogin" | "userId" | "token">) {
		this.userLogin = partial.userLogin;
		this.userId = partial.userId;
		this.token = partial.token;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['userLogin'] = this.userLogin
		res['userId'] = this.userId
		res['token'] = this.token
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['DataOwnerRegistrationSuccess']): DataOwnerRegistrationSuccess {
		return new DataOwnerRegistrationSuccess({
			userLogin: expectString(requireEntry(json.userLogin, 'userLogin', path), false, [...path, ".userLogin"]),
			userId: expectString(requireEntry(json.userId, 'userId', path), false, [...path, ".userId"]),
			token: expectString(requireEntry(json.token, 'token', path), false, [...path, ".token"]),
		})
	}

}
