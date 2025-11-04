// auto-generated file
import {expectArray, expectString} from '../internal/JsonDecodeUtils.mjs';


export class ListOfIds {

	ids: Array<string> = [];

	constructor(partial: Partial<ListOfIds>) {
		if ('ids' in partial && partial.ids !== undefined) this.ids = partial.ids;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['ids'] = this.ids.map((x0) => x0 )
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['ListOfIds']): ListOfIds {
		return new ListOfIds({
			ids: expectArray(json.ids, false, [...path, ".ids"], (x0, p0) => expectString(x0, false, p0)),
		})
	}

}
