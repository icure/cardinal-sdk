// auto-generated file
import {expectBoolean, extractEntry} from '../internal/JsonDecodeUtils.mjs';


export class BooleanResponse {

	response: boolean;

	constructor(partial: Partial<BooleanResponse> & Pick<BooleanResponse, "response">) {
		this.response = partial.response;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['response'] = this.response
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['BooleanResponse']): BooleanResponse {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new BooleanResponse({
			response: expectBoolean(extractEntry(jCpy, 'response', true, path), false, [...path, ".response"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object BooleanResponse at path ${path.join("")}: ${unused}`)}
		return res
	}

}
