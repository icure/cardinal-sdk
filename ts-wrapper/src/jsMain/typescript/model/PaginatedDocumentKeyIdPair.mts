// auto-generated file
import {expectString} from '../internal/JsonDecodeUtils.mjs';


export class PaginatedDocumentKeyIdPair {

	startKey: any | undefined = undefined;

	startKeyDocId: string | undefined = undefined;

	constructor(partial: Partial<PaginatedDocumentKeyIdPair>) {
		if ('startKey' in partial) this.startKey = partial.startKey;
		if ('startKeyDocId' in partial) this.startKeyDocId = partial.startKeyDocId;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.startKey != undefined) res['startKey'] = this.startKey
		if (this.startKeyDocId != undefined) res['startKeyDocId'] = this.startKeyDocId
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['PaginatedDocumentKeyIdPair']): PaginatedDocumentKeyIdPair {
		return new PaginatedDocumentKeyIdPair({
			startKey: json.startKey,
			startKeyDocId: expectString(json.startKeyDocId, true, [...path, ".startKeyDocId"]),
		})
	}

}
