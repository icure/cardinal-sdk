// auto-generated file
import {expectArray, expectNumber, expectObject, expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasEndOfLife} from './base/HasEndOfLife.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {TimeTableItem} from './embed/TimeTableItem.mjs';


export class TimeTable implements StoredDocument, ICureDocument<string>, HasEndOfLife {

	id: string;

	rev: string | undefined = undefined;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	endOfLife: number | undefined = undefined;

	deletionDate: number | undefined = undefined;

	name: string | undefined = undefined;

	agendaId: string | undefined = undefined;

	startTime: number | undefined = undefined;

	endTime: number | undefined = undefined;

	items: Array<TimeTableItem> = [];

	constructor(partial: Partial<TimeTable>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('name' in partial) this.name = partial.name;
		if ('agendaId' in partial) this.agendaId = partial.agendaId;
		if ('startTime' in partial) this.startTime = partial.startTime;
		if ('endTime' in partial) this.endTime = partial.endTime;
		if ('items' in partial && partial.items !== undefined) this.items = partial.items;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.name != undefined) res['name'] = this.name
		if (this.agendaId != undefined) res['agendaId'] = this.agendaId
		if (this.startTime != undefined) res['startTime'] = this.startTime
		if (this.endTime != undefined) res['endTime'] = this.endTime
		res['items'] = this.items.map((x0) => x0.toJSON() )
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['TimeTable']): TimeTable {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new TimeTable({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			endOfLife: expectNumber(extractEntry(jCpy, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			name: expectString(extractEntry(jCpy, 'name', false, path), true, [...path, ".name"]),
			agendaId: expectString(extractEntry(jCpy, 'agendaId', false, path), true, [...path, ".agendaId"]),
			startTime: expectNumber(extractEntry(jCpy, 'startTime', false, path), true, true, [...path, ".startTime"]),
			endTime: expectNumber(extractEntry(jCpy, 'endTime', false, path), true, true, [...path, ".endTime"]),
			items: expectArray(extractEntry(jCpy, 'items', false, path), false, [...path, ".items"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, TimeTableItem.fromJSON)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object TimeTable at path ${path.join("")}: ${unused}`)}
		return res
	}

}
