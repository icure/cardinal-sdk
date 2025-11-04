// auto-generated file
import {expectString, expectStringEnum} from '../internal/JsonDecodeUtils.mjs';
import {TypedValuesType} from './embed/TypedValuesType.mjs';


export class PropertyTypeStub {

	identifier: string | undefined = undefined;

	type: TypedValuesType | undefined = undefined;

	constructor(partial: Partial<PropertyTypeStub>) {
		if ('identifier' in partial) this.identifier = partial.identifier;
		if ('type' in partial) this.type = partial.type;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.identifier != undefined) res['identifier'] = this.identifier
		if (this.type != undefined) res['type'] = this.type
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['PropertyTypeStub']): PropertyTypeStub {
		return new PropertyTypeStub({
			identifier: expectString(json.identifier, true, [...path, ".identifier"]),
			type: expectStringEnum(json.type, true, [...path, ".type"], TypedValuesType, 'TypedValuesType'),
		})
	}

}
