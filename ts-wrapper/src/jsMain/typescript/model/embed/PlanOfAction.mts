// auto-generated file
import {expectArray, expectNumber, expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../../utils/Id.mjs';
import {CodeStub} from '../base/CodeStub.mjs';
import {HasEndOfLife} from '../base/HasEndOfLife.mjs';
import {ICureDocument} from '../base/ICureDocument.mjs';
import {Named} from '../base/Named.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {CareTeamMembership, DecryptedCareTeamMembership, EncryptedCareTeamMembership} from './CareTeamMembership.mjs';
import {Encryptable} from './Encryptable.mjs';


export interface PlanOfAction extends Encryptable, ICureDocument<string>, Named, HasEndOfLife {

	prescriberId: string | undefined;

	valueDate: number | undefined;

	openingDate: number | undefined;

	closingDate: number | undefined;

	deadlineDate: number | undefined;

	descr: string | undefined;

	note: string | undefined;

	idOpeningContact: string | undefined;

	idClosingContact: string | undefined;

	careTeamMemberships: Array<CareTeamMembership>;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

export class DecryptedPlanOfAction {

	id: string;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

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

	careTeamMemberships: Array<DecryptedCareTeamMembership> = [];

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedPlanOfAction>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		this.id = partial.id ?? randomUuid();
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
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
		if ('careTeamMemberships' in partial && partial.careTeamMemberships !== undefined) this.careTeamMemberships = partial.careTeamMemberships;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
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
		res['careTeamMemberships'] = this.careTeamMemberships.map((x0) => x0.toJSON() )
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = false
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedPlanOfAction']): DecryptedPlanOfAction {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedPlanOfAction`)
		const res = new DecryptedPlanOfAction({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			endOfLife: expectNumber(extractEntry(jCpy, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			prescriberId: expectString(extractEntry(jCpy, 'prescriberId', false, path), true, [...path, ".prescriberId"]),
			valueDate: expectNumber(extractEntry(jCpy, 'valueDate', false, path), true, true, [...path, ".valueDate"]),
			openingDate: expectNumber(extractEntry(jCpy, 'openingDate', false, path), true, true, [...path, ".openingDate"]),
			closingDate: expectNumber(extractEntry(jCpy, 'closingDate', false, path), true, true, [...path, ".closingDate"]),
			deadlineDate: expectNumber(extractEntry(jCpy, 'deadlineDate', false, path), true, true, [...path, ".deadlineDate"]),
			name: expectString(extractEntry(jCpy, 'name', false, path), true, [...path, ".name"]),
			descr: expectString(extractEntry(jCpy, 'descr', false, path), true, [...path, ".descr"]),
			note: expectString(extractEntry(jCpy, 'note', false, path), true, [...path, ".note"]),
			idOpeningContact: expectString(extractEntry(jCpy, 'idOpeningContact', false, path), true, [...path, ".idOpeningContact"]),
			idClosingContact: expectString(extractEntry(jCpy, 'idClosingContact', false, path), true, [...path, ".idClosingContact"]),
			careTeamMemberships: expectArray(extractEntry(jCpy, 'careTeamMemberships', false, path), false, [...path, ".careTeamMemberships"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedCareTeamMembership.fromJSON)),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedPlanOfAction at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export class EncryptedPlanOfAction {

	id: string;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

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

	careTeamMemberships: Array<EncryptedCareTeamMembership> = [];

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedPlanOfAction>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		this.id = partial.id ?? randomUuid();
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
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
		if ('careTeamMemberships' in partial && partial.careTeamMemberships !== undefined) this.careTeamMemberships = partial.careTeamMemberships;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
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
		res['careTeamMemberships'] = this.careTeamMemberships.map((x0) => x0.toJSON() )
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = true
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedPlanOfAction']): EncryptedPlanOfAction {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedPlanOfAction`)
		const res = new EncryptedPlanOfAction({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			endOfLife: expectNumber(extractEntry(jCpy, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			prescriberId: expectString(extractEntry(jCpy, 'prescriberId', false, path), true, [...path, ".prescriberId"]),
			valueDate: expectNumber(extractEntry(jCpy, 'valueDate', false, path), true, true, [...path, ".valueDate"]),
			openingDate: expectNumber(extractEntry(jCpy, 'openingDate', false, path), true, true, [...path, ".openingDate"]),
			closingDate: expectNumber(extractEntry(jCpy, 'closingDate', false, path), true, true, [...path, ".closingDate"]),
			deadlineDate: expectNumber(extractEntry(jCpy, 'deadlineDate', false, path), true, true, [...path, ".deadlineDate"]),
			name: expectString(extractEntry(jCpy, 'name', false, path), true, [...path, ".name"]),
			descr: expectString(extractEntry(jCpy, 'descr', false, path), true, [...path, ".descr"]),
			note: expectString(extractEntry(jCpy, 'note', false, path), true, [...path, ".note"]),
			idOpeningContact: expectString(extractEntry(jCpy, 'idOpeningContact', false, path), true, [...path, ".idOpeningContact"]),
			idClosingContact: expectString(extractEntry(jCpy, 'idClosingContact', false, path), true, [...path, ".idClosingContact"]),
			careTeamMemberships: expectArray(extractEntry(jCpy, 'careTeamMemberships', false, path), false, [...path, ".careTeamMemberships"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, EncryptedCareTeamMembership.fromJSON)),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedPlanOfAction at path ${path.join("")}: ${unused}`)}
		return res
	}

}
