// auto-generated file
import {expectNumber, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


export class ReplicationStats {

	revisionsChecked: number | undefined = undefined;

	missingRevisionsFound: number | undefined = undefined;

	docsRead: number | undefined = undefined;

	docsWritten: number | undefined = undefined;

	changesPending: number | undefined = undefined;

	docWriteFailures: number | undefined = undefined;

	checkpointedSourceSeq: string | undefined = undefined;

	startTime: string | undefined = undefined;

	error: string | undefined = undefined;

	constructor(partial: Partial<ReplicationStats>) {
		if ('revisionsChecked' in partial) this.revisionsChecked = partial.revisionsChecked;
		if ('missingRevisionsFound' in partial) this.missingRevisionsFound = partial.missingRevisionsFound;
		if ('docsRead' in partial) this.docsRead = partial.docsRead;
		if ('docsWritten' in partial) this.docsWritten = partial.docsWritten;
		if ('changesPending' in partial) this.changesPending = partial.changesPending;
		if ('docWriteFailures' in partial) this.docWriteFailures = partial.docWriteFailures;
		if ('checkpointedSourceSeq' in partial) this.checkpointedSourceSeq = partial.checkpointedSourceSeq;
		if ('startTime' in partial) this.startTime = partial.startTime;
		if ('error' in partial) this.error = partial.error;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.revisionsChecked != undefined) res['revisionsChecked'] = this.revisionsChecked
		if (this.missingRevisionsFound != undefined) res['missingRevisionsFound'] = this.missingRevisionsFound
		if (this.docsRead != undefined) res['docsRead'] = this.docsRead
		if (this.docsWritten != undefined) res['docsWritten'] = this.docsWritten
		if (this.changesPending != undefined) res['changesPending'] = this.changesPending
		if (this.docWriteFailures != undefined) res['docWriteFailures'] = this.docWriteFailures
		if (this.checkpointedSourceSeq != undefined) res['checkpointedSourceSeq'] = this.checkpointedSourceSeq
		if (this.startTime != undefined) res['startTime'] = this.startTime
		if (this.error != undefined) res['error'] = this.error
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['ReplicationStats']): ReplicationStats {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new ReplicationStats({
			revisionsChecked: expectNumber(extractEntry(jCpy, 'revisionsChecked', false, path), true, true, [...path, ".revisionsChecked"]),
			missingRevisionsFound: expectNumber(extractEntry(jCpy, 'missingRevisionsFound', false, path), true, true, [...path, ".missingRevisionsFound"]),
			docsRead: expectNumber(extractEntry(jCpy, 'docsRead', false, path), true, true, [...path, ".docsRead"]),
			docsWritten: expectNumber(extractEntry(jCpy, 'docsWritten', false, path), true, true, [...path, ".docsWritten"]),
			changesPending: expectNumber(extractEntry(jCpy, 'changesPending', false, path), true, true, [...path, ".changesPending"]),
			docWriteFailures: expectNumber(extractEntry(jCpy, 'docWriteFailures', false, path), true, true, [...path, ".docWriteFailures"]),
			checkpointedSourceSeq: expectString(extractEntry(jCpy, 'checkpointedSourceSeq', false, path), true, [...path, ".checkpointedSourceSeq"]),
			startTime: expectString(extractEntry(jCpy, 'startTime', false, path), true, [...path, ".startTime"]),
			error: expectString(extractEntry(jCpy, 'error', false, path), true, [...path, ".error"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object ReplicationStats at path ${path.join("")}: ${unused}`)}
		return res
	}

}
