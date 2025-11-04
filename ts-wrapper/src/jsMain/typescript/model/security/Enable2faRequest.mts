// auto-generated file
import {expectNumber, expectString, requireEntry} from '../../internal/JsonDecodeUtils.mjs';


export class Enable2faRequest {

	secret: string;

	otpLength: number;

	constructor(partial: Partial<Enable2faRequest> & Pick<Enable2faRequest, "secret" | "otpLength">) {
		this.secret = partial.secret;
		this.otpLength = partial.otpLength;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['secret'] = this.secret
		res['otpLength'] = this.otpLength
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['Enable2faRequest']): Enable2faRequest {
		return new Enable2faRequest({
			secret: expectString(requireEntry(json.secret, 'secret', path), false, [...path, ".secret"]),
			otpLength: expectNumber(requireEntry(json.otpLength, 'otpLength', path), false, true, [...path, ".otpLength"]),
		})
	}

}
