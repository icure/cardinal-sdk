// auto-generated file
import {expectNumber, expectString} from '../../internal/JsonDecodeUtils.mjs';


export class AgreementAppendix {

	docSeq: number | undefined = undefined;

	verseSeq: number | undefined = undefined;

	documentId: string | undefined = undefined;

	path: string | undefined = undefined;

	constructor(partial: Partial<AgreementAppendix>) {
		if ('docSeq' in partial) this.docSeq = partial.docSeq;
		if ('verseSeq' in partial) this.verseSeq = partial.verseSeq;
		if ('documentId' in partial) this.documentId = partial.documentId;
		if ('path' in partial) this.path = partial.path;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.docSeq != undefined) res['docSeq'] = this.docSeq
		if (this.verseSeq != undefined) res['verseSeq'] = this.verseSeq
		if (this.documentId != undefined) res['documentId'] = this.documentId
		if (this.path != undefined) res['path'] = this.path
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['AgreementAppendix']): AgreementAppendix {
		return new AgreementAppendix({
			docSeq: expectNumber(json.docSeq, true, true, [...path, ".docSeq"]),
			verseSeq: expectNumber(json.verseSeq, true, true, [...path, ".verseSeq"]),
			documentId: expectString(json.documentId, true, [...path, ".documentId"]),
			path: expectString(json.path, true, [...path, ".path"]),
		})
	}

}
