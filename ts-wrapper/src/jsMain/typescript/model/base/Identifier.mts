// auto-generated file
import {expectString} from '../../internal/JsonDecodeUtils.mjs';
import {CodeStub} from './CodeStub.mjs';


export class Identifier {

	id: string | undefined = undefined;

	assigner: string | undefined = undefined;

	start: string | undefined = undefined;

	end: string | undefined = undefined;

	system: string | undefined = undefined;

	type: CodeStub | undefined = undefined;

	use: string | undefined = undefined;

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

	toJSON(): any {
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

	static fromJSON(json: any, path: Array<string> = ['Identifier']): Identifier {
		return new Identifier({
			id: expectString(json.id, true, [...path, ".id"]),
			assigner: expectString(json.assigner, true, [...path, ".assigner"]),
			start: expectString(json.start, true, [...path, ".start"]),
			end: expectString(json.end, true, [...path, ".end"]),
			system: expectString(json.system, true, [...path, ".system"]),
			type: CodeStub.fromJSON(json.type, [...path, ".type"]),
			use: expectString(json.use, true, [...path, ".use"]),
			value: expectString(json.value, true, [...path, ".value"]),
		})
	}

}
