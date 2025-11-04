// auto-generated file
import {expectBoolean, expectNumber} from '../../internal/JsonDecodeUtils.mjs';


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

	static fromJSON(json: any, path: Array<string> = ['MessageReadStatus']): MessageReadStatus {
		return new MessageReadStatus({
			time: expectNumber(json.time, true, true, [...path, ".time"]),
			read: expectBoolean(json.read, false, [...path, ".read"]),
		})
	}

}
