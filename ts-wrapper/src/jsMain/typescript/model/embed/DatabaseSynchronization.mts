// auto-generated file
import {expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


/**
 *
 *  Represents a database synchronization configuration between a source and a target, with optional
 *  filtering.
 *  /
 */
export class DatabaseSynchronization {

	/**
	 *
	 *  The source database URL or identifier.
	 */
	source: string | undefined = undefined;

	/**
	 *
	 *  The target database URL or identifier.
	 */
	target: string | undefined = undefined;

	/**
	 *
	 *  A filter expression to apply during synchronization.
	 */
	filter: string | undefined = undefined;

	/**
	 *
	 *  The local target type for the synchronization (base, healthdata, or patient).
	 */
	localTarget: DatabaseSynchronization.Target | undefined = undefined;

	constructor(partial: Partial<DatabaseSynchronization>) {
		if ('source' in partial) this.source = partial.source;
		if ('target' in partial) this.target = partial.target;
		if ('filter' in partial) this.filter = partial.filter;
		if ('localTarget' in partial) this.localTarget = partial.localTarget;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.source != undefined) res['source'] = this.source
		if (this.target != undefined) res['target'] = this.target
		if (this.filter != undefined) res['filter'] = this.filter
		if (this.localTarget != undefined) res['localTarget'] = this.localTarget
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DatabaseSynchronization']): DatabaseSynchronization {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new DatabaseSynchronization({
			source: expectString(extractEntry(jCpy, 'source', false, path), true, [...path, ".source"]),
			target: expectString(extractEntry(jCpy, 'target', false, path), true, [...path, ".target"]),
			filter: expectString(extractEntry(jCpy, 'filter', false, path), true, [...path, ".filter"]),
			localTarget: expectStringEnum(extractEntry(jCpy, 'localTarget', false, path), true, [...path, ".localTarget"], DatabaseSynchronization.Target, 'DatabaseSynchronization.Target'),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DatabaseSynchronization at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export namespace DatabaseSynchronization {

	export enum Target {
		Base = "Base",
		Healthdata = "Healthdata",
		Patient = "Patient"
	}

}
