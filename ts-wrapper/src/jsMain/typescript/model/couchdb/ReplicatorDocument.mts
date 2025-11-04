// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../../utils/Id.mjs';
import {Versionable} from '../base/Versionable.mjs';
import {Remote} from './Remote.mjs';
import {ReplicationStats} from './ReplicationStats.mjs';


export class ReplicatorDocument implements Versionable<string> {

	id: string;

	rev: string | undefined = undefined;

	source: Remote | undefined = undefined;

	target: Remote | undefined = undefined;

	owner: string | undefined = undefined;

	create_target: boolean | undefined = undefined;

	continuous: boolean | undefined = undefined;

	doc_ids: Array<string> | undefined = undefined;

	replicationState: string | undefined = undefined;

	replicationStateTime: string | undefined = undefined;

	replicationStats: ReplicationStats | undefined = undefined;

	errorCount: number | undefined = undefined;

	revsInfo: Array<{ [ key: string ]: string }> | undefined = undefined;

	revHistory: { [ key: string ]: string } | undefined = undefined;

	constructor(partial: Partial<ReplicatorDocument>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('source' in partial) this.source = partial.source;
		if ('target' in partial) this.target = partial.target;
		if ('owner' in partial) this.owner = partial.owner;
		if ('create_target' in partial) this.create_target = partial.create_target;
		if ('continuous' in partial) this.continuous = partial.continuous;
		if ('doc_ids' in partial) this.doc_ids = partial.doc_ids;
		if ('replicationState' in partial) this.replicationState = partial.replicationState;
		if ('replicationStateTime' in partial) this.replicationStateTime = partial.replicationStateTime;
		if ('replicationStats' in partial) this.replicationStats = partial.replicationStats;
		if ('errorCount' in partial) this.errorCount = partial.errorCount;
		if ('revsInfo' in partial) this.revsInfo = partial.revsInfo;
		if ('revHistory' in partial) this.revHistory = partial.revHistory;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.source != undefined) res['source'] = this.source.toJSON()
		if (this.target != undefined) res['target'] = this.target.toJSON()
		if (this.owner != undefined) res['owner'] = this.owner
		if (this.create_target != undefined) res['create_target'] = this.create_target
		if (this.continuous != undefined) res['continuous'] = this.continuous
		if (this.doc_ids != undefined) res['doc_ids'] = this.doc_ids.map((x0) => x0 )
		if (this.replicationState != undefined) res['replicationState'] = this.replicationState
		if (this.replicationStateTime != undefined) res['replicationStateTime'] = this.replicationStateTime
		if (this.replicationStats != undefined) res['replicationStats'] = this.replicationStats.toJSON()
		if (this.errorCount != undefined) res['errorCount'] = this.errorCount
		if (this.revsInfo != undefined) res['revsInfo'] = this.revsInfo.map((x0) => Object.fromEntries(Object.entries(x0).map(([k1, v1]) => [k1, v1])) )
		if (this.revHistory != undefined) res['revHistory'] = Object.fromEntries(Object.entries(this.revHistory).map(([k0, v0]) => [k0, v0]))
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['ReplicatorDocument']): ReplicatorDocument {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new ReplicatorDocument({
			id: expectString(extractEntry(jCpy.id, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy.rev, 'rev', false, path), true, [...path, ".rev"]),
			source: expectObject(extractEntry(jCpy.source, 'source', false, path), true, ignoreUnknownKeys, [...path, ".source"], Remote.fromJSON),
			target: expectObject(extractEntry(jCpy.target, 'target', false, path), true, ignoreUnknownKeys, [...path, ".target"], Remote.fromJSON),
			owner: expectString(extractEntry(jCpy.owner, 'owner', false, path), true, [...path, ".owner"]),
			create_target: expectBoolean(extractEntry(jCpy.create_target, 'create_target', false, path), true, [...path, ".create_target"]),
			continuous: expectBoolean(extractEntry(jCpy.continuous, 'continuous', false, path), true, [...path, ".continuous"]),
			doc_ids: expectArray(extractEntry(jCpy.doc_ids, 'doc_ids', false, path), true, [...path, ".doc_ids"], (x0, p0) => expectString(x0, false, p0)),
			replicationState: expectString(extractEntry(jCpy.replicationState, 'replicationState', false, path), true, [...path, ".replicationState"]),
			replicationStateTime: expectString(extractEntry(jCpy.replicationStateTime, 'replicationStateTime', false, path), true, [...path, ".replicationStateTime"]),
			replicationStats: expectObject(extractEntry(jCpy.replicationStats, 'replicationStats', false, path), true, ignoreUnknownKeys, [...path, ".replicationStats"], ReplicationStats.fromJSON),
			errorCount: expectNumber(extractEntry(jCpy.errorCount, 'errorCount', false, path), true, true, [...path, ".errorCount"]),
			revsInfo: expectArray(extractEntry(jCpy.revsInfo, 'revsInfo', false, path), true, [...path, ".revsInfo"], (x0, p0) => expectMap(
				x0,
				false,
				p0,
				(k1, p1) => expectString(k1, false, p1),
				(v1, p1) => expectString(v1, false, p1)
			)),
			revHistory: expectMap(
				extractEntry(jCpy.revHistory, 'revHistory', false, path),
				true,
				[...path, ".revHistory"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object ReplicatorDocument at path ${path.join("")}: ${unused}`)}
		return res
	}

}
