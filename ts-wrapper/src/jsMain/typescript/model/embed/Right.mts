// auto-generated file
import {expectBoolean, expectString} from '../../internal/JsonDecodeUtils.mjs';


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

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.userId != undefined) res['userId'] = this.userId
		res['read'] = this.read
		res['write'] = this.write
		res['administration'] = this.administration
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['Right']): Right {
		return new Right({
			userId: expectString(json.userId, true, [...path, ".userId"]),
			read: expectBoolean(json.read, false, [...path, ".read"]),
			write: expectBoolean(json.write, false, [...path, ".write"]),
			administration: expectBoolean(json.administration, false, [...path, ".administration"]),
		})
	}

}
