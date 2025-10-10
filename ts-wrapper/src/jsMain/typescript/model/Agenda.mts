// auto-generated file
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

}
