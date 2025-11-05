// auto-generated file
import {expectBoolean, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


export class Right {

	userId: string | undefined = undefined;

	read: boolean = false;

	write: boolean = false;

	administration: boolean = false;

	constructor(partial: Partial<Right>) {
		if ('userId' in partial) this.userId = partial.userId;
		if ('read' in partial && partial.read !== undefined) this.read = partial.read;
		if ('write' in partial && partial.write !== undefined) this.write = partial.write;
		if ('administration' in partial && partial.administration !== undefined) this.administration = partial.administration;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.userId != undefined) res['userId'] = this.userId
		res['read'] = this.read
		res['write'] = this.write
		res['administration'] = this.administration
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Right']): Right {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Right({
			userId: expectString(extractEntry(jCpy, 'userId', false, path), true, [...path, ".userId"]),
			read: expectBoolean(extractEntry(jCpy, 'read', false, path), false, [...path, ".read"]),
			write: expectBoolean(extractEntry(jCpy, 'write', false, path), false, [...path, ".write"]),
			administration: expectBoolean(extractEntry(jCpy, 'administration', false, path), false, [...path, ".administration"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Right at path ${path.join("")}: ${unused}`)}
		return res
	}

}
