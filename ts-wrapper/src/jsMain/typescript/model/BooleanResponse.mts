// auto-generated file
import {expectBoolean, requireEntry} from '../internal/JsonDecodeUtils.mjs';


export class BooleanResponse {

	response: boolean;

	constructor(partial: Partial<BooleanResponse> & Pick<BooleanResponse, "response">) {
		this.response = partial.response;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['response'] = this.response
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['BooleanResponse']): BooleanResponse {
		return new BooleanResponse({
			response: expectBoolean(requireEntry(json.response, 'response', path), false, [...path, ".response"]),
		})
	}

}
