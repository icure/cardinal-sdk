// auto-generated file
import {expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {RemoteAuthentication} from './RemoteAuthentication.mjs';


export class Remote {

	url: string;

	auth: RemoteAuthentication | undefined = undefined;

	constructor(partial: Partial<Remote> & Pick<Remote, "url">) {
		this.url = partial.url;
		if ('auth' in partial) this.auth = partial.auth;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['url'] = this.url
		if (this.auth != undefined) res['auth'] = this.auth.toJSON()
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Remote']): Remote {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Remote({
			url: expectString(extractEntry(jCpy, 'url', true, path), false, [...path, ".url"]),
			auth: expectObject(extractEntry(jCpy, 'auth', false, path), true, ignoreUnknownKeys, [...path, ".auth"], RemoteAuthentication.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Remote at path ${path.join("")}: ${unused}`)}
		return res
	}

}
