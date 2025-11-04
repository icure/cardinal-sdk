// auto-generated file
import {expectNumber, expectString, requireEntry} from '../../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../../utils/Id.mjs';


export class DatabaseInfo {

	id: string;

	updateSeq: string | undefined = undefined;

	fileSize: number | undefined = undefined;

	externalSize: number | undefined = undefined;

	activeSize: number | undefined = undefined;

	docs: number | undefined = undefined;

	q: number | undefined = undefined;

	n: number | undefined = undefined;

	w: number | undefined = undefined;

	r: number | undefined = undefined;

	constructor(partial: Partial<DatabaseInfo>) {
		this.id = partial.id ?? randomUuid();
		if ('updateSeq' in partial) this.updateSeq = partial.updateSeq;
		if ('fileSize' in partial) this.fileSize = partial.fileSize;
		if ('externalSize' in partial) this.externalSize = partial.externalSize;
		if ('activeSize' in partial) this.activeSize = partial.activeSize;
		if ('docs' in partial) this.docs = partial.docs;
		if ('q' in partial) this.q = partial.q;
		if ('n' in partial) this.n = partial.n;
		if ('w' in partial) this.w = partial.w;
		if ('r' in partial) this.r = partial.r;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.updateSeq != undefined) res['updateSeq'] = this.updateSeq
		if (this.fileSize != undefined) res['fileSize'] = this.fileSize
		if (this.externalSize != undefined) res['externalSize'] = this.externalSize
		if (this.activeSize != undefined) res['activeSize'] = this.activeSize
		if (this.docs != undefined) res['docs'] = this.docs
		if (this.q != undefined) res['q'] = this.q
		if (this.n != undefined) res['n'] = this.n
		if (this.w != undefined) res['w'] = this.w
		if (this.r != undefined) res['r'] = this.r
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['DatabaseInfo']): DatabaseInfo {
		return new DatabaseInfo({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			updateSeq: expectString(json.updateSeq, true, [...path, ".updateSeq"]),
			fileSize: expectNumber(json.fileSize, true, true, [...path, ".fileSize"]),
			externalSize: expectNumber(json.externalSize, true, true, [...path, ".externalSize"]),
			activeSize: expectNumber(json.activeSize, true, true, [...path, ".activeSize"]),
			docs: expectNumber(json.docs, true, true, [...path, ".docs"]),
			q: expectNumber(json.q, true, true, [...path, ".q"]),
			n: expectNumber(json.n, true, true, [...path, ".n"]),
			w: expectNumber(json.w, true, true, [...path, ".w"]),
			r: expectNumber(json.r, true, true, [...path, ".r"]),
		})
	}

}
