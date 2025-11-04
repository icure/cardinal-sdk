// auto-generated file
import {expectString, requireEntry} from '../../internal/JsonDecodeUtils.mjs';


export class View {

	map: string;

	reduce: string | undefined = undefined;

	constructor(partial: Partial<View> & Pick<View, "map">) {
		this.map = partial.map;
		if ('reduce' in partial) this.reduce = partial.reduce;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['map'] = this.map
		if (this.reduce != undefined) res['reduce'] = this.reduce
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['View']): View {
		return new View({
			map: expectString(requireEntry(json.map, 'map', path), false, [...path, ".map"]),
			reduce: expectString(json.reduce, true, [...path, ".reduce"]),
		})
	}

}
