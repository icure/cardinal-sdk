// auto-generated file
import {expectMap, expectNumber, expectString} from '../internal/JsonDecodeUtils.mjs';


export class IndexingInfo {

	statuses: { [ key: string ]: number } | undefined = undefined;

	constructor(partial: Partial<IndexingInfo>) {
		if ('statuses' in partial) this.statuses = partial.statuses;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.statuses != undefined) res['statuses'] = Object.fromEntries(Object.entries(this.statuses).map(([k0, v0]) => [k0, v0]))
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['IndexingInfo']): IndexingInfo {
		return new IndexingInfo({
			statuses: expectMap(
				json.statuses,
				true,
				[...path, ".statuses"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectNumber(v0, false, true, p0)
			),
		})
	}

}
