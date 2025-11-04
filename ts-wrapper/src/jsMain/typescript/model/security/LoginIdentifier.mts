// auto-generated file
import {expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


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

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['LoginIdentifier']): LoginIdentifier {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new LoginIdentifier({
			assigner: expectString(extractEntry(jCpy.assigner, 'assigner', true, path), false, [...path, ".assigner"]),
			value: expectString(extractEntry(jCpy.value, 'value', true, path), false, [...path, ".value"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object LoginIdentifier at path ${path.join("")}: ${unused}`)}
		return res
	}

}
