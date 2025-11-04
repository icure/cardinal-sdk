// auto-generated file
import {expectArray, expectNumber, expectString} from '../../internal/JsonDecodeUtils.mjs';
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

	static fromJSON(json: any,
			path: Array<string> = ['ResourceGroupAllocationSchedule']): ResourceGroupAllocationSchedule {
		return new ResourceGroupAllocationSchedule({
			resourceGroup: CodeStub.fromJSON(json.resourceGroup, [...path, ".resourceGroup"]),
			tags: expectArray(json.tags, false, [...path, ".tags"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			codes: expectArray(json.codes, false, [...path, ".codes"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			name: expectString(json.name, true, [...path, ".name"]),
			startDateTime: expectNumber(json.startDateTime, true, true, [...path, ".startDateTime"]),
			endDateTime: expectNumber(json.endDateTime, true, true, [...path, ".endDateTime"]),
			items: expectArray(json.items, false, [...path, ".items"], (x0, p0) => EmbeddedTimeTableItem.fromJSON(x0, p0)),
		})
	}

}
