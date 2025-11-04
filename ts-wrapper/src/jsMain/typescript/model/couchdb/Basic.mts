// auto-generated file
import {expectString, requireEntry} from '../../internal/JsonDecodeUtils.mjs';


export class Basic {

	username: string;

	password: string;

	constructor(partial: Partial<Basic> & Pick<Basic, "username" | "password">) {
		this.username = partial.username;
		this.password = partial.password;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['username'] = this.username
		res['password'] = this.password
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['Basic']): Basic {
		return new Basic({
			username: expectString(requireEntry(json.username, 'username', path), false, [...path, ".username"]),
			password: expectString(requireEntry(json.password, 'password', path), false, [...path, ".password"]),
		})
	}

}
