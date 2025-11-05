// auto-generated file
import {expectNumber, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


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

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['AgreementAppendix']): AgreementAppendix {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new AgreementAppendix({
			docSeq: expectNumber(extractEntry(jCpy, 'docSeq', false, path), true, true, [...path, ".docSeq"]),
			verseSeq: expectNumber(extractEntry(jCpy, 'verseSeq', false, path), true, true, [...path, ".verseSeq"]),
			documentId: expectString(extractEntry(jCpy, 'documentId', false, path), true, [...path, ".documentId"]),
			path: expectString(extractEntry(jCpy, 'path', false, path), true, [...path, ".path"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object AgreementAppendix at path ${path.join("")}: ${unused}`)}
		return res
	}

}
