// auto-generated file
import {expectString} from '../../internal/JsonDecodeUtils.mjs';


export class DocIdentifier {

	id: string | undefined = undefined;

	rev: string | undefined = undefined;

	constructor(partial: Partial<DocIdentifier>) {
		if ('id' in partial) this.id = partial.id;
		if ('rev' in partial) this.rev = partial.rev;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.id != undefined) res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['DocIdentifier']): DocIdentifier {
		return new DocIdentifier({
			id: expectString(json.id, true, [...path, ".id"]),
			rev: expectString(json.rev, true, [...path, ".rev"]),
		})
	}

}
