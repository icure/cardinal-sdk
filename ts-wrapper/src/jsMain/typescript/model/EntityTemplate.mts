// auto-generated file
import {expectArray, expectBoolean, expectNumber, expectString, requireEntry} from '../internal/JsonDecodeUtils.mjs';
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

	toJSON(): any {
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

	static fromJSON(json: any, path: Array<string> = ['EntityTemplate']): EntityTemplate {
		return new EntityTemplate({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			rev: expectString(json.rev, true, [...path, ".rev"]),
			deletionDate: expectNumber(json.deletionDate, true, true, [...path, ".deletionDate"]),
			userId: expectString(json.userId, true, [...path, ".userId"]),
			descr: expectString(json.descr, true, [...path, ".descr"]),
			keywords: expectArray(json.keywords, true, [...path, ".keywords"], (x0, p0) => expectString(x0, false, p0)),
			entityType: expectString(json.entityType, true, [...path, ".entityType"]),
			subType: expectString(json.subType, true, [...path, ".subType"]),
			defaultTemplate: expectBoolean(json.defaultTemplate, true, [...path, ".defaultTemplate"]),
			entity: expectArray(json.entity, false, [...path, ".entity"], (x0, p0) => x0),
		})
	}

}
