// auto-generated file
import {expectString, requireEntry} from '../../internal/JsonDecodeUtils.mjs';


export class LoginIdentifier {

	assigner: string;

	value: string;

	constructor(partial: Partial<LoginIdentifier> & Pick<LoginIdentifier, "assigner" | "value">) {
		this.assigner = partial.assigner;
		this.value = partial.value;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['assigner'] = this.assigner
		res['value'] = this.value
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['LoginIdentifier']): LoginIdentifier {
		return new LoginIdentifier({
			assigner: expectString(requireEntry(json.assigner, 'assigner', path), false, [...path, ".assigner"]),
			value: expectString(requireEntry(json.value, 'value', path), false, [...path, ".value"]),
		})
	}

}
