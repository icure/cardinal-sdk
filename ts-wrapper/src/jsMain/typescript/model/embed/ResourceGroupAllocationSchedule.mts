// auto-generated file
import {expectArray, expectNumber, expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {CodeStub} from '../base/CodeStub.mjs';
import {EmbeddedTimeTableItem} from './EmbeddedTimeTableItem.mjs';


export class ResourceGroupAllocationSchedule {

	resourceGroup: CodeStub | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	name: string | undefined = undefined;

	startDateTime: number | undefined = undefined;

	endDateTime: number | undefined = undefined;

	items: Array<EmbeddedTimeTableItem> = [];

	constructor(partial: Partial<ResourceGroupAllocationSchedule>) {
		if ('resourceGroup' in partial) this.resourceGroup = partial.resourceGroup;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('name' in partial) this.name = partial.name;
		if ('startDateTime' in partial) this.startDateTime = partial.startDateTime;
		if ('endDateTime' in partial) this.endDateTime = partial.endDateTime;
		if ('items' in partial && partial.items !== undefined) this.items = partial.items;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.resourceGroup != undefined) res['resourceGroup'] = this.resourceGroup.toJSON()
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.name != undefined) res['name'] = this.name
		if (this.startDateTime != undefined) res['startDateTime'] = this.startDateTime
		if (this.endDateTime != undefined) res['endDateTime'] = this.endDateTime
		res['items'] = this.items.map((x0) => x0.toJSON() )
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['ResourceGroupAllocationSchedule']): ResourceGroupAllocationSchedule {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new ResourceGroupAllocationSchedule({
			resourceGroup: expectObject(extractEntry(jCpy, 'resourceGroup', false, path), true, ignoreUnknownKeys, [...path, ".resourceGroup"], CodeStub.fromJSON),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			name: expectString(extractEntry(jCpy, 'name', false, path), true, [...path, ".name"]),
			startDateTime: expectNumber(extractEntry(jCpy, 'startDateTime', false, path), true, true, [...path, ".startDateTime"]),
			endDateTime: expectNumber(extractEntry(jCpy, 'endDateTime', false, path), true, true, [...path, ".endDateTime"]),
			items: expectArray(extractEntry(jCpy, 'items', false, path), false, [...path, ".items"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, EmbeddedTimeTableItem.fromJSON)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object ResourceGroupAllocationSchedule at path ${path.join("")}: ${unused}`)}
		return res
	}

}
