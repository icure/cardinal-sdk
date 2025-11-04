// auto-generated file
import {expectString, expectStringEnum} from '../../internal/JsonDecodeUtils.mjs';


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

	static fromJSON(json: any,
			path: Array<string> = ['DatabaseSynchronization']): DatabaseSynchronization {
		return new DatabaseSynchronization({
			source: expectString(json.source, true, [...path, ".source"]),
			target: expectString(json.target, true, [...path, ".target"]),
			filter: expectString(json.filter, true, [...path, ".filter"]),
			localTarget: expectStringEnum(json.localTarget, true, [...path, ".localTarget"], DatabaseSynchronization.Target, 'DatabaseSynchronization.Target'),
		})
	}

}

export namespace DatabaseSynchronization {

	export enum Target {
		Base = "Base",
		Healthdata = "Healthdata",
		Patient = "Patient"
	}

}
