// auto-generated file
import {expectString, requireEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';


export class IdWithRev {

	id: string;

	rev: string | undefined = undefined;

	constructor(partial: Partial<IdWithRev>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['IdWithRev']): IdWithRev {
		return new IdWithRev({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			rev: expectString(json.rev, true, [...path, ".rev"]),
		})
	}

}
