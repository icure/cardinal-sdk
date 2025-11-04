// auto-generated file
import {expectBoolean, expectNumber, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


export class MessageReadStatus {

	time: number | undefined = undefined;

	read: boolean = false;

	constructor(partial: Partial<MessageReadStatus>) {
		if ('time' in partial) this.time = partial.time;
		if ('read' in partial && partial.read !== undefined) this.read = partial.read;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.time != undefined) res['time'] = this.time
		res['read'] = this.read
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['MessageReadStatus']): MessageReadStatus {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new MessageReadStatus({
			time: expectNumber(extractEntry(jCpy.time, 'time', false, path), true, true, [...path, ".time"]),
			read: expectBoolean(extractEntry(jCpy.read, 'read', false, path), false, [...path, ".read"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object MessageReadStatus at path ${path.join("")}: ${unused}`)}
		return res
	}

}
