// auto-generated file
import {expectArray, expectBoolean, expectNumber, expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';


export class EntityTemplate implements StoredDocument {

	id: string;

	rev: string | undefined = undefined;

	deletionDate: number | undefined = undefined;

	userId: string | undefined = undefined;

	descr: string | undefined = undefined;

	keywords: Array<string> | undefined = undefined;

	entityType: string | undefined = undefined;

	subType: string | undefined = undefined;

	defaultTemplate: boolean | undefined = undefined;

	entity: Array<any> = [];

	constructor(partial: Partial<EntityTemplate>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('userId' in partial) this.userId = partial.userId;
		if ('descr' in partial) this.descr = partial.descr;
		if ('keywords' in partial) this.keywords = partial.keywords;
		if ('entityType' in partial) this.entityType = partial.entityType;
		if ('subType' in partial) this.subType = partial.subType;
		if ('defaultTemplate' in partial) this.defaultTemplate = partial.defaultTemplate;
		if ('entity' in partial && partial.entity !== undefined) this.entity = partial.entity;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.userId != undefined) res['userId'] = this.userId
		if (this.descr != undefined) res['descr'] = this.descr
		if (this.keywords != undefined) res['keywords'] = this.keywords.map((x0) => x0 )
		if (this.entityType != undefined) res['entityType'] = this.entityType
		if (this.subType != undefined) res['subType'] = this.subType
		if (this.defaultTemplate != undefined) res['defaultTemplate'] = this.defaultTemplate
		res['entity'] = this.entity.map((x0) => x0 )
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EntityTemplate']): EntityTemplate {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new EntityTemplate({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			userId: expectString(extractEntry(jCpy, 'userId', false, path), true, [...path, ".userId"]),
			descr: expectString(extractEntry(jCpy, 'descr', false, path), true, [...path, ".descr"]),
			keywords: expectArray(extractEntry(jCpy, 'keywords', false, path), true, [...path, ".keywords"], (x0, p0) => expectString(x0, false, p0)),
			entityType: expectString(extractEntry(jCpy, 'entityType', false, path), true, [...path, ".entityType"]),
			subType: expectString(extractEntry(jCpy, 'subType', false, path), true, [...path, ".subType"]),
			defaultTemplate: expectBoolean(extractEntry(jCpy, 'defaultTemplate', false, path), true, [...path, ".defaultTemplate"]),
			entity: expectArray(extractEntry(jCpy, 'entity', false, path), false, [...path, ".entity"], (x0, p0) => x0),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EntityTemplate at path ${path.join("")}: ${unused}`)}
		return res
	}

}
