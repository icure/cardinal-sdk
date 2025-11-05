// auto-generated file
import {expectString, expectStringEnum, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {TypedValuesType} from './embed/TypedValuesType.mjs';


export class PropertyTypeStub {

	identifier: string | undefined = undefined;

	type: TypedValuesType | undefined = undefined;

	constructor(partial: Partial<PropertyTypeStub>) {
		if ('identifier' in partial) this.identifier = partial.identifier;
		if ('type' in partial) this.type = partial.type;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.identifier != undefined) res['identifier'] = this.identifier
		if (this.type != undefined) res['type'] = this.type
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['PropertyTypeStub']): PropertyTypeStub {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new PropertyTypeStub({
			identifier: expectString(extractEntry(jCpy, 'identifier', false, path), true, [...path, ".identifier"]),
			type: expectStringEnum(extractEntry(jCpy, 'type', false, path), true, [...path, ".type"], TypedValuesType, 'TypedValuesType'),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object PropertyTypeStub at path ${path.join("")}: ${unused}`)}
		return res
	}

}
