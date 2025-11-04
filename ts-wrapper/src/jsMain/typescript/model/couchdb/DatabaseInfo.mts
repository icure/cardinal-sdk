// auto-generated file
import {expectNumber, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
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

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DatabaseInfo']): DatabaseInfo {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new DatabaseInfo({
			id: expectString(extractEntry(jCpy.id, 'id', true, path), false, [...path, ".id"]),
			updateSeq: expectString(extractEntry(jCpy.updateSeq, 'updateSeq', false, path), true, [...path, ".updateSeq"]),
			fileSize: expectNumber(extractEntry(jCpy.fileSize, 'fileSize', false, path), true, true, [...path, ".fileSize"]),
			externalSize: expectNumber(extractEntry(jCpy.externalSize, 'externalSize', false, path), true, true, [...path, ".externalSize"]),
			activeSize: expectNumber(extractEntry(jCpy.activeSize, 'activeSize', false, path), true, true, [...path, ".activeSize"]),
			docs: expectNumber(extractEntry(jCpy.docs, 'docs', false, path), true, true, [...path, ".docs"]),
			q: expectNumber(extractEntry(jCpy.q, 'q', false, path), true, true, [...path, ".q"]),
			n: expectNumber(extractEntry(jCpy.n, 'n', false, path), true, true, [...path, ".n"]),
			w: expectNumber(extractEntry(jCpy.w, 'w', false, path), true, true, [...path, ".w"]),
			r: expectNumber(extractEntry(jCpy.r, 'r', false, path), true, true, [...path, ".r"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DatabaseInfo at path ${path.join("")}: ${unused}`)}
		return res
	}

}
