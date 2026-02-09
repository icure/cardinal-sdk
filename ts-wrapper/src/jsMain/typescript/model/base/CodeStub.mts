// auto-generated file
import {expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {CodeIdentification} from './CodeIdentification.mjs';


export class CodeStub implements CodeIdentification<string | undefined> {

	id: string | undefined = undefined;

	context: string | undefined = undefined;

	type: string | undefined = undefined;

	code: string | undefined = undefined;

	version: string | undefined = undefined;

	contextLabel: string | undefined = undefined;

	constructor(partial: Partial<CodeStub>) {
		if ('id' in partial) this.id = partial.id;
		if ('context' in partial) this.context = partial.context;
		if ('type' in partial) this.type = partial.type;
		if ('code' in partial) this.code = partial.code;
		if ('version' in partial) this.version = partial.version;
		if ('contextLabel' in partial) this.contextLabel = partial.contextLabel;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.id != undefined) res['id'] = this.id
		if (this.context != undefined) res['context'] = this.context
		if (this.type != undefined) res['type'] = this.type
		if (this.code != undefined) res['code'] = this.code
		if (this.version != undefined) res['version'] = this.version
		if (this.contextLabel != undefined) res['contextLabel'] = this.contextLabel
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['CodeStub']): CodeStub {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new CodeStub({
			id: expectString(extractEntry(jCpy, 'id', false, path), true, [...path, ".id"]),
			context: expectString(extractEntry(jCpy, 'context', false, path), true, [...path, ".context"]),
			type: expectString(extractEntry(jCpy, 'type', false, path), true, [...path, ".type"]),
			code: expectString(extractEntry(jCpy, 'code', false, path), true, [...path, ".code"]),
			version: expectString(extractEntry(jCpy, 'version', false, path), true, [...path, ".version"]),
			contextLabel: expectString(extractEntry(jCpy, 'contextLabel', false, path), true, [...path, ".contextLabel"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object CodeStub at path ${path.join("")}: ${unused}`)}
		return res
	}

}
