// auto-generated file
import {expectBoolean, expectNumber, extractEntry} from '../internal/JsonDecodeUtils.mjs';


export class ReplicationInfo {

	active: boolean = false;

	running: boolean = false;

	pendingFrom: number | undefined = undefined;

	pendingTo: number | undefined = undefined;

	constructor(partial: Partial<ReplicationInfo>) {
		if ('active' in partial && partial.active !== undefined) this.active = partial.active;
		if ('running' in partial && partial.running !== undefined) this.running = partial.running;
		if ('pendingFrom' in partial) this.pendingFrom = partial.pendingFrom;
		if ('pendingTo' in partial) this.pendingTo = partial.pendingTo;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['active'] = this.active
		res['running'] = this.running
		if (this.pendingFrom != undefined) res['pendingFrom'] = this.pendingFrom
		if (this.pendingTo != undefined) res['pendingTo'] = this.pendingTo
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['ReplicationInfo']): ReplicationInfo {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new ReplicationInfo({
			active: expectBoolean(extractEntry(jCpy, 'active', false, path), false, [...path, ".active"]),
			running: expectBoolean(extractEntry(jCpy, 'running', false, path), false, [...path, ".running"]),
			pendingFrom: expectNumber(extractEntry(jCpy, 'pendingFrom', false, path), true, true, [...path, ".pendingFrom"]),
			pendingTo: expectNumber(extractEntry(jCpy, 'pendingTo', false, path), true, true, [...path, ".pendingTo"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object ReplicationInfo at path ${path.join("")}: ${unused}`)}
		return res
	}

}
