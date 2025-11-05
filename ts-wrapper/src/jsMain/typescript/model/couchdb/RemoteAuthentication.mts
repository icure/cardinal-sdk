// auto-generated file
import {expectObject, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {Basic} from './Basic.mjs';


export class RemoteAuthentication {

	basic: Basic | undefined = undefined;

	constructor(partial: Partial<RemoteAuthentication>) {
		if ('basic' in partial) this.basic = partial.basic;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.basic != undefined) res['basic'] = this.basic.toJSON()
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['RemoteAuthentication']): RemoteAuthentication {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new RemoteAuthentication({
			basic: expectObject(extractEntry(jCpy, 'basic', false, path), true, ignoreUnknownKeys, [...path, ".basic"], Basic.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object RemoteAuthentication at path ${path.join("")}: ${unused}`)}
		return res
	}

}
