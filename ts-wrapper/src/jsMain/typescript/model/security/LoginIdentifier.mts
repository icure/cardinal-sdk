// auto-generated file
import {expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


/**
 *
 *  A structured identifier used to match a user during login, composed of an assigner system and a
 *  value within that system.
 *  /
 */
export class LoginIdentifier {

	/**
	 *
	 *  The system or authority that issued or manages this identifier.
	 */
	assigner: string;

	/**
	 *
	 *  The identifier value within the assigner's namespace.
	 */
	value: string;

	constructor(partial: Partial<LoginIdentifier> & Pick<LoginIdentifier, "assigner" | "value">) {
		this.assigner = partial.assigner;
		this.value = partial.value;
	}

	toJSON(): object {
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
			assigner: expectString(extractEntry(jCpy, 'assigner', true, path), false, [...path, ".assigner"]),
			value: expectString(extractEntry(jCpy, 'value', true, path), false, [...path, ".value"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object LoginIdentifier at path ${path.join("")}: ${unused}`)}
		return res
	}

}
