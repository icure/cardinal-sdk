// auto-generated file
import {expectMap, expectString} from '../../internal/JsonDecodeUtils.mjs';
import {CodeIdentification} from './CodeIdentification.mjs';


export class CodeStub implements CodeIdentification<string | undefined> {

	id: string | undefined = undefined;

	context: string | undefined = undefined;

	type: string | undefined = undefined;

	code: string | undefined = undefined;

	version: string | undefined = undefined;

	contextLabel: string | undefined = undefined;

	label: { [ key: string ]: string } | undefined = undefined;

	constructor(partial: Partial<CodeStub>) {
		if ('id' in partial) this.id = partial.id;
		if ('context' in partial) this.context = partial.context;
		if ('type' in partial) this.type = partial.type;
		if ('code' in partial) this.code = partial.code;
		if ('version' in partial) this.version = partial.version;
		if ('contextLabel' in partial) this.contextLabel = partial.contextLabel;
		if ('label' in partial) this.label = partial.label;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.id != undefined) res['id'] = this.id
		if (this.context != undefined) res['context'] = this.context
		if (this.type != undefined) res['type'] = this.type
		if (this.code != undefined) res['code'] = this.code
		if (this.version != undefined) res['version'] = this.version
		if (this.contextLabel != undefined) res['contextLabel'] = this.contextLabel
		if (this.label != undefined) res['label'] = Object.fromEntries(Object.entries(this.label).map(([k0, v0]) => [k0, v0]))
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['CodeStub']): CodeStub {
		return new CodeStub({
			id: expectString(json.id, true, [...path, ".id"]),
			context: expectString(json.context, true, [...path, ".context"]),
			type: expectString(json.type, true, [...path, ".type"]),
			code: expectString(json.code, true, [...path, ".code"]),
			version: expectString(json.version, true, [...path, ".version"]),
			contextLabel: expectString(json.contextLabel, true, [...path, ".contextLabel"]),
			label: expectMap(
				json.label,
				true,
				[...path, ".label"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
		})
	}

}
