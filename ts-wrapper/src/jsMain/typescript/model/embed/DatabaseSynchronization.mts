// auto-generated file
import {expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';


export class DatabaseSynchronization {

	source: string | undefined = undefined;

	target: string | undefined = undefined;

	filter: string | undefined = undefined;

	localTarget: DatabaseSynchronization.Target | undefined = undefined;

	constructor(partial: Partial<DatabaseSynchronization>) {
		if ('source' in partial) this.source = partial.source;
		if ('target' in partial) this.target = partial.target;
		if ('filter' in partial) this.filter = partial.filter;
		if ('localTarget' in partial) this.localTarget = partial.localTarget;
	}

	toJSON(): any {
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
			source: expectString(extractEntry(jCpy.source, 'source', false, path), true, [...path, ".source"]),
			target: expectString(extractEntry(jCpy.target, 'target', false, path), true, [...path, ".target"]),
			filter: expectString(extractEntry(jCpy.filter, 'filter', false, path), true, [...path, ".filter"]),
			localTarget: expectStringEnum(extractEntry(jCpy.localTarget, 'localTarget', false, path), true, [...path, ".localTarget"], DatabaseSynchronization.Target, 'DatabaseSynchronization.Target'),
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
