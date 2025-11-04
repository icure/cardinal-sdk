// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectString, expectStringEnum, requireEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {DecryptedPropertyStub} from './PropertyStub.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {AgendaSlottingAlgorithm} from './embed/AgendaSlottingAlgorithm.mjs';
import {ResourceGroupAllocationSchedule} from './embed/ResourceGroupAllocationSchedule.mjs';
import {Right} from './embed/Right.mjs';
import {UserAccessLevel} from './embed/UserAccessLevel.mjs';


export class Agenda implements StoredDocument, ICureDocument<string> {

	id: string;

	rev: string | undefined = undefined;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	medicalLocationId: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	endOfLife: number | undefined = undefined;

	deletionDate: number | undefined = undefined;

	daySplitHour: number | undefined = undefined;

	unpublished: boolean = false;

	name: string | undefined = undefined;

	userId: string | undefined = undefined;

	zoneId: string | undefined = undefined;

	rights: Array<Right> = [];

	userRights: { [ key: string ]: UserAccessLevel } = {};

	slottingAlgorithm: AgendaSlottingAlgorithm | undefined = undefined;

	publicBookingQuota: number | undefined = undefined;

	properties: Array<DecryptedPropertyStub> = [];

	schedules: Array<ResourceGroupAllocationSchedule> = [];

	constructor(partial: Partial<Agenda>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('daySplitHour' in partial) this.daySplitHour = partial.daySplitHour;
		if ('unpublished' in partial && partial.unpublished !== undefined) this.unpublished = partial.unpublished;
		if ('name' in partial) this.name = partial.name;
		if ('userId' in partial) this.userId = partial.userId;
		if ('zoneId' in partial) this.zoneId = partial.zoneId;
		if ('rights' in partial && partial.rights !== undefined) this.rights = partial.rights;
		if ('userRights' in partial && partial.userRights !== undefined) this.userRights = partial.userRights;
		if ('slottingAlgorithm' in partial) this.slottingAlgorithm = partial.slottingAlgorithm;
		if ('publicBookingQuota' in partial) this.publicBookingQuota = partial.publicBookingQuota;
		if ('properties' in partial && partial.properties !== undefined) this.properties = partial.properties;
		if ('schedules' in partial && partial.schedules !== undefined) this.schedules = partial.schedules;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		if (this.medicalLocationId != undefined) res['medicalLocationId'] = this.medicalLocationId
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.daySplitHour != undefined) res['daySplitHour'] = this.daySplitHour
		res['unpublished'] = this.unpublished
		if (this.name != undefined) res['name'] = this.name
		if (this.userId != undefined) res['userId'] = this.userId
		if (this.zoneId != undefined) res['zoneId'] = this.zoneId
		res['rights'] = this.rights.map((x0) => x0.toJSON() )
		res['userRights'] = Object.fromEntries(Object.entries(this.userRights).map(([k0, v0]) => [k0, v0]))
		if (this.slottingAlgorithm != undefined) res['slottingAlgorithm'] = this.slottingAlgorithm.toJSON()
		if (this.publicBookingQuota != undefined) res['publicBookingQuota'] = this.publicBookingQuota
		res['properties'] = this.properties.map((x0) => x0.toJSON() )
		res['schedules'] = this.schedules.map((x0) => x0.toJSON() )
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['Agenda']): Agenda {
		return new Agenda({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			rev: expectString(json.rev, true, [...path, ".rev"]),
			created: expectNumber(json.created, true, true, [...path, ".created"]),
			modified: expectNumber(json.modified, true, true, [...path, ".modified"]),
			author: expectString(json.author, true, [...path, ".author"]),
			responsible: expectString(json.responsible, true, [...path, ".responsible"]),
			medicalLocationId: expectString(json.medicalLocationId, true, [...path, ".medicalLocationId"]),
			tags: expectArray(json.tags, false, [...path, ".tags"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			codes: expectArray(json.codes, false, [...path, ".codes"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			endOfLife: expectNumber(json.endOfLife, true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(json.deletionDate, true, true, [...path, ".deletionDate"]),
			daySplitHour: expectNumber(json.daySplitHour, true, true, [...path, ".daySplitHour"]),
			unpublished: expectBoolean(json.unpublished, false, [...path, ".unpublished"]),
			name: expectString(json.name, true, [...path, ".name"]),
			userId: expectString(json.userId, true, [...path, ".userId"]),
			zoneId: expectString(json.zoneId, true, [...path, ".zoneId"]),
			rights: expectArray(json.rights, false, [...path, ".rights"], (x0, p0) => Right.fromJSON(x0, p0)),
			userRights: expectMap(
				json.userRights,
				false,
				[...path, ".userRights"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectStringEnum(v0, false, p0, UserAccessLevel, 'UserAccessLevel')
			),
			slottingAlgorithm: AgendaSlottingAlgorithm.fromJSON(json.slottingAlgorithm, [...path, ".slottingAlgorithm"]),
			publicBookingQuota: expectNumber(json.publicBookingQuota, true, true, [...path, ".publicBookingQuota"]),
			properties: expectArray(json.properties, false, [...path, ".properties"], (x0, p0) => DecryptedPropertyStub.fromJSON(x0, p0)),
			schedules: expectArray(json.schedules, false, [...path, ".schedules"], (x0, p0) => ResourceGroupAllocationSchedule.fromJSON(x0, p0)),
		})
	}

}
