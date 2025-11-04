// auto-generated file
import {expectBoolean, expectNumber} from '../internal/JsonDecodeUtils.mjs';


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

	static fromJSON(json: any, path: Array<string> = ['ReplicationInfo']): ReplicationInfo {
		return new ReplicationInfo({
			active: expectBoolean(json.active, false, [...path, ".active"]),
			running: expectBoolean(json.running, false, [...path, ".running"]),
			pendingFrom: expectNumber(json.pendingFrom, true, true, [...path, ".pendingFrom"]),
			pendingTo: expectNumber(json.pendingTo, true, true, [...path, ".pendingTo"]),
		})
	}

}
