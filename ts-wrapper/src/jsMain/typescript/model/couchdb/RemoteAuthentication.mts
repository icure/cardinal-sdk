// auto-generated file
import {Basic} from './Basic.mjs';


export class RemoteAuthentication {

	basic: Basic | undefined = undefined;

	constructor(partial: Partial<RemoteAuthentication>) {
		if ('basic' in partial) this.basic = partial.basic;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.basic != undefined) res['basic'] = this.basic.toJSON()
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['RemoteAuthentication']): RemoteAuthentication {
		return new RemoteAuthentication({
			basic: Basic.fromJSON(json.basic, [...path, ".basic"]),
		})
	}

}
