// auto-generated file
import {expectString, requireEntry} from '../../internal/JsonDecodeUtils.mjs';
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

	static fromJSON(json: any, path: Array<string> = ['Remote']): Remote {
		return new Remote({
			url: expectString(requireEntry(json.url, 'url', path), false, [...path, ".url"]),
			auth: RemoteAuthentication.fromJSON(json.auth, [...path, ".auth"]),
		})
	}

}
