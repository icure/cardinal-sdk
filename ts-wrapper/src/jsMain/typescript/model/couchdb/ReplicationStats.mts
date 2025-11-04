// auto-generated file
import {expectNumber, expectString} from '../../internal/JsonDecodeUtils.mjs';


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

	toJSON(): any {
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

	static fromJSON(json: any, path: Array<string> = ['ReplicationStats']): ReplicationStats {
		return new ReplicationStats({
			revisionsChecked: expectNumber(json.revisionsChecked, true, true, [...path, ".revisionsChecked"]),
			missingRevisionsFound: expectNumber(json.missingRevisionsFound, true, true, [...path, ".missingRevisionsFound"]),
			docsRead: expectNumber(json.docsRead, true, true, [...path, ".docsRead"]),
			docsWritten: expectNumber(json.docsWritten, true, true, [...path, ".docsWritten"]),
			changesPending: expectNumber(json.changesPending, true, true, [...path, ".changesPending"]),
			docWriteFailures: expectNumber(json.docWriteFailures, true, true, [...path, ".docWriteFailures"]),
			checkpointedSourceSeq: expectString(json.checkpointedSourceSeq, true, [...path, ".checkpointedSourceSeq"]),
			startTime: expectString(json.startTime, true, [...path, ".startTime"]),
			error: expectString(json.error, true, [...path, ".error"]),
		})
	}

}
