// auto-generated file
import {expectString} from '../../internal/JsonDecodeUtils.mjs';


export class DocumentGroup {

	guid: string | undefined = undefined;

	name: string | undefined = undefined;

	constructor(partial: Partial<DocumentGroup>) {
		if ('guid' in partial) this.guid = partial.guid;
		if ('name' in partial) this.name = partial.name;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.guid != undefined) res['guid'] = this.guid
		if (this.name != undefined) res['name'] = this.name
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['DocumentGroup']): DocumentGroup {
		return new DocumentGroup({
			guid: expectString(json.guid, true, [...path, ".guid"]),
			name: expectString(json.name, true, [...path, ".name"]),
		})
	}

}
