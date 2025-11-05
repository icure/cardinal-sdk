// auto-generated file
import {expectNumber, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


export class Enable2faRequest {

	secret: string;

	otpLength: number;

	constructor(partial: Partial<Enable2faRequest> & Pick<Enable2faRequest, "secret" | "otpLength">) {
		this.secret = partial.secret;
		this.otpLength = partial.otpLength;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['secret'] = this.secret
		res['otpLength'] = this.otpLength
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Enable2faRequest']): Enable2faRequest {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Enable2faRequest({
			secret: expectString(extractEntry(jCpy, 'secret', true, path), false, [...path, ".secret"]),
			otpLength: expectNumber(extractEntry(jCpy, 'otpLength', true, path), false, true, [...path, ".otpLength"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Enable2faRequest at path ${path.join("")}: ${unused}`)}
		return res
	}

}
