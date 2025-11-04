// auto-generated file
import {expectArray, expectBoolean, expectNumber, expectString, requireEntry} from '../../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../../utils/Id.mjs';
import {CodeStub} from '../base/CodeStub.mjs';
import {ICureDocument} from '../base/ICureDocument.mjs';
import {Named} from '../base/Named.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {CareTeamMembership, DecryptedCareTeamMembership, EncryptedCareTeamMembership} from './CareTeamMembership.mjs';
import {Encryptable} from './Encryptable.mjs';


export interface PlanOfAction extends Encryptable, ICureDocument<string>, Named {

	prescriberId: string | undefined;

	valueDate: number | undefined;

	openingDate: number | undefined;

	closingDate: number | undefined;

	deadlineDate: number | undefined;

	descr: string | undefined;

	note: string | undefined;

	idOpeningContact: string | undefined;

	idClosingContact: string | undefined;

	status: number;

	documentIds: Array<string>;

	numberOfCares: number | undefined;

	careTeamMemberships: Array<CareTeamMembership>;

	relevant: boolean;

	readonly isEncrypted: boolean;

}

export class DecryptedPlanOfAction {

	id: string;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	medicalLocationId: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	endOfLife: number | undefined = undefined;

	prescriberId: string | undefined = undefined;

	valueDate: number | undefined = undefined;

	openingDate: number | undefined = undefined;

	closingDate: number | undefined = undefined;

	deadlineDate: number | undefined = undefined;

	name: string | undefined = undefined;

	descr: string | undefined = undefined;

	note: string | undefined = undefined;

	idOpeningContact: string | undefined = undefined;

	idClosingContact: string | undefined = undefined;

	status: number = 0;

	documentIds: Array<string> = [];

	numberOfCares: number | undefined = undefined;

	careTeamMemberships: Array<DecryptedCareTeamMembership> = [];

	relevant: boolean = true;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedPlanOfAction>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		this.id = partial.id ?? randomUuid();
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('prescriberId' in partial) this.prescriberId = partial.prescriberId;
		if ('valueDate' in partial) this.valueDate = partial.valueDate;
		if ('openingDate' in partial) this.openingDate = partial.openingDate;
		if ('closingDate' in partial) this.closingDate = partial.closingDate;
		if ('deadlineDate' in partial) this.deadlineDate = partial.deadlineDate;
		if ('name' in partial) this.name = partial.name;
		if ('descr' in partial) this.descr = partial.descr;
		if ('note' in partial) this.note = partial.note;
		if ('idOpeningContact' in partial) this.idOpeningContact = partial.idOpeningContact;
		if ('idClosingContact' in partial) this.idClosingContact = partial.idClosingContact;
		if ('status' in partial && partial.status !== undefined) this.status = partial.status;
		if ('documentIds' in partial && partial.documentIds !== undefined) this.documentIds = partial.documentIds;
		if ('numberOfCares' in partial) this.numberOfCares = partial.numberOfCares;
		if ('careTeamMemberships' in partial && partial.careTeamMemberships !== undefined) this.careTeamMemberships = partial.careTeamMemberships;
		if ('relevant' in partial && partial.relevant !== undefined) this.relevant = partial.relevant;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		if (this.medicalLocationId != undefined) res['medicalLocationId'] = this.medicalLocationId
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
		if (this.prescriberId != undefined) res['prescriberId'] = this.prescriberId
		if (this.valueDate != undefined) res['valueDate'] = this.valueDate
		if (this.openingDate != undefined) res['openingDate'] = this.openingDate
		if (this.closingDate != undefined) res['closingDate'] = this.closingDate
		if (this.deadlineDate != undefined) res['deadlineDate'] = this.deadlineDate
		if (this.name != undefined) res['name'] = this.name
		if (this.descr != undefined) res['descr'] = this.descr
		if (this.note != undefined) res['note'] = this.note
		if (this.idOpeningContact != undefined) res['idOpeningContact'] = this.idOpeningContact
		if (this.idClosingContact != undefined) res['idClosingContact'] = this.idClosingContact
		res['status'] = this.status
		res['documentIds'] = this.documentIds.map((x0) => x0 )
		if (this.numberOfCares != undefined) res['numberOfCares'] = this.numberOfCares
		res['careTeamMemberships'] = this.careTeamMemberships.map((x0) => x0.toJSON() )
		res['relevant'] = this.relevant
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['DecryptedPlanOfAction']): DecryptedPlanOfAction {
		return new DecryptedPlanOfAction({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			created: expectNumber(json.created, true, true, [...path, ".created"]),
			modified: expectNumber(json.modified, true, true, [...path, ".modified"]),
			author: expectString(json.author, true, [...path, ".author"]),
			responsible: expectString(json.responsible, true, [...path, ".responsible"]),
			medicalLocationId: expectString(json.medicalLocationId, true, [...path, ".medicalLocationId"]),
			tags: expectArray(json.tags, false, [...path, ".tags"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			codes: expectArray(json.codes, false, [...path, ".codes"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			endOfLife: expectNumber(json.endOfLife, true, true, [...path, ".endOfLife"]),
			prescriberId: expectString(json.prescriberId, true, [...path, ".prescriberId"]),
			valueDate: expectNumber(json.valueDate, true, true, [...path, ".valueDate"]),
			openingDate: expectNumber(json.openingDate, true, true, [...path, ".openingDate"]),
			closingDate: expectNumber(json.closingDate, true, true, [...path, ".closingDate"]),
			deadlineDate: expectNumber(json.deadlineDate, true, true, [...path, ".deadlineDate"]),
			name: expectString(json.name, true, [...path, ".name"]),
			descr: expectString(json.descr, true, [...path, ".descr"]),
			note: expectString(json.note, true, [...path, ".note"]),
			idOpeningContact: expectString(json.idOpeningContact, true, [...path, ".idOpeningContact"]),
			idClosingContact: expectString(json.idClosingContact, true, [...path, ".idClosingContact"]),
			status: expectNumber(json.status, false, true, [...path, ".status"]),
			documentIds: expectArray(json.documentIds, false, [...path, ".documentIds"], (x0, p0) => expectString(x0, false, p0)),
			numberOfCares: expectNumber(json.numberOfCares, true, true, [...path, ".numberOfCares"]),
			careTeamMemberships: expectArray(json.careTeamMemberships, false, [...path, ".careTeamMemberships"], (x0, p0) => DecryptedCareTeamMembership.fromJSON(x0, p0)),
			relevant: expectBoolean(json.relevant, false, [...path, ".relevant"]),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
	}

}

export class EncryptedPlanOfAction {

	id: string;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	medicalLocationId: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	endOfLife: number | undefined = undefined;

	prescriberId: string | undefined = undefined;

	valueDate: number | undefined = undefined;

	openingDate: number | undefined = undefined;

	closingDate: number | undefined = undefined;

	deadlineDate: number | undefined = undefined;

	name: string | undefined = undefined;

	descr: string | undefined = undefined;

	note: string | undefined = undefined;

	idOpeningContact: string | undefined = undefined;

	idClosingContact: string | undefined = undefined;

	status: number = 0;

	documentIds: Array<string> = [];

	numberOfCares: number | undefined = undefined;

	careTeamMemberships: Array<EncryptedCareTeamMembership> = [];

	relevant: boolean = true;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedPlanOfAction>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		this.id = partial.id ?? randomUuid();
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('prescriberId' in partial) this.prescriberId = partial.prescriberId;
		if ('valueDate' in partial) this.valueDate = partial.valueDate;
		if ('openingDate' in partial) this.openingDate = partial.openingDate;
		if ('closingDate' in partial) this.closingDate = partial.closingDate;
		if ('deadlineDate' in partial) this.deadlineDate = partial.deadlineDate;
		if ('name' in partial) this.name = partial.name;
		if ('descr' in partial) this.descr = partial.descr;
		if ('note' in partial) this.note = partial.note;
		if ('idOpeningContact' in partial) this.idOpeningContact = partial.idOpeningContact;
		if ('idClosingContact' in partial) this.idClosingContact = partial.idClosingContact;
		if ('status' in partial && partial.status !== undefined) this.status = partial.status;
		if ('documentIds' in partial && partial.documentIds !== undefined) this.documentIds = partial.documentIds;
		if ('numberOfCares' in partial) this.numberOfCares = partial.numberOfCares;
		if ('careTeamMemberships' in partial && partial.careTeamMemberships !== undefined) this.careTeamMemberships = partial.careTeamMemberships;
		if ('relevant' in partial && partial.relevant !== undefined) this.relevant = partial.relevant;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		if (this.medicalLocationId != undefined) res['medicalLocationId'] = this.medicalLocationId
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
		if (this.prescriberId != undefined) res['prescriberId'] = this.prescriberId
		if (this.valueDate != undefined) res['valueDate'] = this.valueDate
		if (this.openingDate != undefined) res['openingDate'] = this.openingDate
		if (this.closingDate != undefined) res['closingDate'] = this.closingDate
		if (this.deadlineDate != undefined) res['deadlineDate'] = this.deadlineDate
		if (this.name != undefined) res['name'] = this.name
		if (this.descr != undefined) res['descr'] = this.descr
		if (this.note != undefined) res['note'] = this.note
		if (this.idOpeningContact != undefined) res['idOpeningContact'] = this.idOpeningContact
		if (this.idClosingContact != undefined) res['idClosingContact'] = this.idClosingContact
		res['status'] = this.status
		res['documentIds'] = this.documentIds.map((x0) => x0 )
		if (this.numberOfCares != undefined) res['numberOfCares'] = this.numberOfCares
		res['careTeamMemberships'] = this.careTeamMemberships.map((x0) => x0.toJSON() )
		res['relevant'] = this.relevant
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['EncryptedPlanOfAction']): EncryptedPlanOfAction {
		return new EncryptedPlanOfAction({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			created: expectNumber(json.created, true, true, [...path, ".created"]),
			modified: expectNumber(json.modified, true, true, [...path, ".modified"]),
			author: expectString(json.author, true, [...path, ".author"]),
			responsible: expectString(json.responsible, true, [...path, ".responsible"]),
			medicalLocationId: expectString(json.medicalLocationId, true, [...path, ".medicalLocationId"]),
			tags: expectArray(json.tags, false, [...path, ".tags"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			codes: expectArray(json.codes, false, [...path, ".codes"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			endOfLife: expectNumber(json.endOfLife, true, true, [...path, ".endOfLife"]),
			prescriberId: expectString(json.prescriberId, true, [...path, ".prescriberId"]),
			valueDate: expectNumber(json.valueDate, true, true, [...path, ".valueDate"]),
			openingDate: expectNumber(json.openingDate, true, true, [...path, ".openingDate"]),
			closingDate: expectNumber(json.closingDate, true, true, [...path, ".closingDate"]),
			deadlineDate: expectNumber(json.deadlineDate, true, true, [...path, ".deadlineDate"]),
			name: expectString(json.name, true, [...path, ".name"]),
			descr: expectString(json.descr, true, [...path, ".descr"]),
			note: expectString(json.note, true, [...path, ".note"]),
			idOpeningContact: expectString(json.idOpeningContact, true, [...path, ".idOpeningContact"]),
			idClosingContact: expectString(json.idClosingContact, true, [...path, ".idClosingContact"]),
			status: expectNumber(json.status, false, true, [...path, ".status"]),
			documentIds: expectArray(json.documentIds, false, [...path, ".documentIds"], (x0, p0) => expectString(x0, false, p0)),
			numberOfCares: expectNumber(json.numberOfCares, true, true, [...path, ".numberOfCares"]),
			careTeamMemberships: expectArray(json.careTeamMemberships, false, [...path, ".careTeamMemberships"], (x0, p0) => EncryptedCareTeamMembership.fromJSON(x0, p0)),
			relevant: expectBoolean(json.relevant, false, [...path, ".relevant"]),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
	}

}
