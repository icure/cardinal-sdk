// auto-generated file
import {expectString, requireEntry} from '../internal/JsonDecodeUtils.mjs';


export class RegistrationSuccess {

	groupId: string;

	userId: string;

	token: string;

	constructor(partial: Partial<RegistrationSuccess> & Pick<RegistrationSuccess, "groupId" | "userId" | "token">) {
		this.groupId = partial.groupId;
		this.userId = partial.userId;
		this.token = partial.token;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['groupId'] = this.groupId
		res['userId'] = this.userId
		res['token'] = this.token
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['RegistrationSuccess']): RegistrationSuccess {
		return new RegistrationSuccess({
			groupId: expectString(requireEntry(json.groupId, 'groupId', path), false, [...path, ".groupId"]),
			userId: expectString(requireEntry(json.userId, 'userId', path), false, [...path, ".userId"]),
			token: expectString(requireEntry(json.token, 'token', path), false, [...path, ".token"]),
		})
	}

}
