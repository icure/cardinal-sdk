// auto-generated file
import {expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


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

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Basic']): Basic {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Basic({
			username: expectString(extractEntry(jCpy, 'username', true, path), false, [...path, ".username"]),
			password: expectString(extractEntry(jCpy, 'password', true, path), false, [...path, ".password"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Basic at path ${path.join("")}: ${unused}`)}
		return res
	}

}
