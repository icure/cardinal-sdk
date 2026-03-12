// auto-generated file
import {expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {CodeStub} from './CodeStub.mjs';


/**
 *
 *
 *   An identifier intended for computation
 *
 *   An identifier - identifies some entity uniquely and unambiguously. Typically this is used for
 *   business identifiers.
 */
export class Identifier {

	/**
	 *
	 *
	 *   Unique id for inter-element referencing
	 */
	id: string | undefined = undefined;

	/**
	 *
	 *
	 *   Organization that issued id (may be just text)
	 */
	assigner: string | undefined = undefined;

	/**
	 *
	 *
	 *   Time period when id is/was valid for use
	 */
	start: string | undefined = undefined;

	end: string | undefined = undefined;

	/**
	 *
	 *
	 *   The namespace for the identifier value
	 */
	system: string | undefined = undefined;

	/**
	 *
	 *
	 *   Description of identifier
	 */
	type: CodeStub | undefined = undefined;

	/**
	 *
	 *
	 *   usual | official | temp | secondary | old (If known)
	 */
	use: string | undefined = undefined;

	/**
	 *
	 *
	 *   The value that is unique
	 */
	value: string | undefined = undefined;

	constructor(partial: Partial<Identifier>) {
		if ('id' in partial) this.id = partial.id;
		if ('assigner' in partial) this.assigner = partial.assigner;
		if ('start' in partial) this.start = partial.start;
		if ('end' in partial) this.end = partial.end;
		if ('system' in partial) this.system = partial.system;
		if ('type' in partial) this.type = partial.type;
		if ('use' in partial) this.use = partial.use;
		if ('value' in partial) this.value = partial.value;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.id != undefined) res['id'] = this.id
		if (this.assigner != undefined) res['assigner'] = this.assigner
		if (this.start != undefined) res['start'] = this.start
		if (this.end != undefined) res['end'] = this.end
		if (this.system != undefined) res['system'] = this.system
		if (this.type != undefined) res['type'] = this.type.toJSON()
		if (this.use != undefined) res['use'] = this.use
		if (this.value != undefined) res['value'] = this.value
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Identifier']): Identifier {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Identifier({
			id: expectString(extractEntry(jCpy, 'id', false, path), true, [...path, ".id"]),
			assigner: expectString(extractEntry(jCpy, 'assigner', false, path), true, [...path, ".assigner"]),
			start: expectString(extractEntry(jCpy, 'start', false, path), true, [...path, ".start"]),
			end: expectString(extractEntry(jCpy, 'end', false, path), true, [...path, ".end"]),
			system: expectString(extractEntry(jCpy, 'system', false, path), true, [...path, ".system"]),
			type: expectObject(extractEntry(jCpy, 'type', false, path), true, ignoreUnknownKeys, [...path, ".type"], CodeStub.fromJSON),
			use: expectString(extractEntry(jCpy, 'use', false, path), true, [...path, ".use"]),
			value: expectString(extractEntry(jCpy, 'value', false, path), true, [...path, ".value"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Identifier at path ${path.join("")}: ${unused}`)}
		return res
	}

}
