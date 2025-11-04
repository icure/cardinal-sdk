// auto-generated file
import {expectString, requireEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {Identifiable} from './base/Identifiable.mjs';


export class StoredDocumentIdentifier implements Identifiable<string> {

	id: string;

	rev: string;

	constructor(partial: Partial<StoredDocumentIdentifier> & Pick<StoredDocumentIdentifier, "rev">) {
		this.id = partial.id ?? randomUuid();
		this.rev = partial.rev;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		res['rev'] = this.rev
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['StoredDocumentIdentifier']): StoredDocumentIdentifier {
		return new StoredDocumentIdentifier({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			rev: expectString(requireEntry(json.rev, 'rev', path), false, [...path, ".rev"]),
		})
	}

}
