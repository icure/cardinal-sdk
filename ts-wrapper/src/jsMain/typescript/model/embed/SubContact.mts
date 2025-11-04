// auto-generated file
import {expectArray, expectNumber, expectString} from '../../internal/JsonDecodeUtils.mjs';
import {CodeStub} from '../base/CodeStub.mjs';
import {ICureDocument} from '../base/ICureDocument.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';
import {ServiceLink} from './ServiceLink.mjs';


export interface SubContact extends Encryptable, ICureDocument<string | undefined> {

	descr: string | undefined;

	protocol: string | undefined;

	status: number | undefined;

	formId: string | undefined;

	planOfActionId: string | undefined;

	healthElementId: string | undefined;

	classificationId: string | undefined;

	services: Array<ServiceLink>;

	readonly isEncrypted: boolean;

}

export class DecryptedSubContact {

	id: string | undefined = undefined;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	medicalLocationId: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	endOfLife: number | undefined = undefined;

	descr: string | undefined = undefined;

	protocol: string | undefined = undefined;

	status: number | undefined = undefined;

	formId: string | undefined = undefined;

	planOfActionId: string | undefined = undefined;

	healthElementId: string | undefined = undefined;

	classificationId: string | undefined = undefined;

	services: Array<ServiceLink> = [];

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedSubContact>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		if ('id' in partial) this.id = partial.id;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('descr' in partial) this.descr = partial.descr;
		if ('protocol' in partial) this.protocol = partial.protocol;
		if ('status' in partial) this.status = partial.status;
		if ('formId' in partial) this.formId = partial.formId;
		if ('planOfActionId' in partial) this.planOfActionId = partial.planOfActionId;
		if ('healthElementId' in partial) this.healthElementId = partial.healthElementId;
		if ('classificationId' in partial) this.classificationId = partial.classificationId;
		if ('services' in partial && partial.services !== undefined) this.services = partial.services;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.id != undefined) res['id'] = this.id
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		if (this.medicalLocationId != undefined) res['medicalLocationId'] = this.medicalLocationId
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
		if (this.descr != undefined) res['descr'] = this.descr
		if (this.protocol != undefined) res['protocol'] = this.protocol
		if (this.status != undefined) res['status'] = this.status
		if (this.formId != undefined) res['formId'] = this.formId
		if (this.planOfActionId != undefined) res['planOfActionId'] = this.planOfActionId
		if (this.healthElementId != undefined) res['healthElementId'] = this.healthElementId
		if (this.classificationId != undefined) res['classificationId'] = this.classificationId
		res['services'] = this.services.map((x0) => x0.toJSON() )
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['DecryptedSubContact']): DecryptedSubContact {
		return new DecryptedSubContact({
			id: expectString(json.id, true, [...path, ".id"]),
			created: expectNumber(json.created, true, true, [...path, ".created"]),
			modified: expectNumber(json.modified, true, true, [...path, ".modified"]),
			author: expectString(json.author, true, [...path, ".author"]),
			responsible: expectString(json.responsible, true, [...path, ".responsible"]),
			medicalLocationId: expectString(json.medicalLocationId, true, [...path, ".medicalLocationId"]),
			tags: expectArray(json.tags, false, [...path, ".tags"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			codes: expectArray(json.codes, false, [...path, ".codes"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			endOfLife: expectNumber(json.endOfLife, true, true, [...path, ".endOfLife"]),
			descr: expectString(json.descr, true, [...path, ".descr"]),
			protocol: expectString(json.protocol, true, [...path, ".protocol"]),
			status: expectNumber(json.status, true, true, [...path, ".status"]),
			formId: expectString(json.formId, true, [...path, ".formId"]),
			planOfActionId: expectString(json.planOfActionId, true, [...path, ".planOfActionId"]),
			healthElementId: expectString(json.healthElementId, true, [...path, ".healthElementId"]),
			classificationId: expectString(json.classificationId, true, [...path, ".classificationId"]),
			services: expectArray(json.services, false, [...path, ".services"], (x0, p0) => ServiceLink.fromJSON(x0, p0)),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
	}

}

export class EncryptedSubContact {

	id: string | undefined = undefined;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	medicalLocationId: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	endOfLife: number | undefined = undefined;

	descr: string | undefined = undefined;

	protocol: string | undefined = undefined;

	status: number | undefined = undefined;

	formId: string | undefined = undefined;

	planOfActionId: string | undefined = undefined;

	healthElementId: string | undefined = undefined;

	classificationId: string | undefined = undefined;

	services: Array<ServiceLink> = [];

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedSubContact>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		if ('id' in partial) this.id = partial.id;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('descr' in partial) this.descr = partial.descr;
		if ('protocol' in partial) this.protocol = partial.protocol;
		if ('status' in partial) this.status = partial.status;
		if ('formId' in partial) this.formId = partial.formId;
		if ('planOfActionId' in partial) this.planOfActionId = partial.planOfActionId;
		if ('healthElementId' in partial) this.healthElementId = partial.healthElementId;
		if ('classificationId' in partial) this.classificationId = partial.classificationId;
		if ('services' in partial && partial.services !== undefined) this.services = partial.services;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.id != undefined) res['id'] = this.id
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		if (this.medicalLocationId != undefined) res['medicalLocationId'] = this.medicalLocationId
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
		if (this.descr != undefined) res['descr'] = this.descr
		if (this.protocol != undefined) res['protocol'] = this.protocol
		if (this.status != undefined) res['status'] = this.status
		if (this.formId != undefined) res['formId'] = this.formId
		if (this.planOfActionId != undefined) res['planOfActionId'] = this.planOfActionId
		if (this.healthElementId != undefined) res['healthElementId'] = this.healthElementId
		if (this.classificationId != undefined) res['classificationId'] = this.classificationId
		res['services'] = this.services.map((x0) => x0.toJSON() )
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['EncryptedSubContact']): EncryptedSubContact {
		return new EncryptedSubContact({
			id: expectString(json.id, true, [...path, ".id"]),
			created: expectNumber(json.created, true, true, [...path, ".created"]),
			modified: expectNumber(json.modified, true, true, [...path, ".modified"]),
			author: expectString(json.author, true, [...path, ".author"]),
			responsible: expectString(json.responsible, true, [...path, ".responsible"]),
			medicalLocationId: expectString(json.medicalLocationId, true, [...path, ".medicalLocationId"]),
			tags: expectArray(json.tags, false, [...path, ".tags"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			codes: expectArray(json.codes, false, [...path, ".codes"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			endOfLife: expectNumber(json.endOfLife, true, true, [...path, ".endOfLife"]),
			descr: expectString(json.descr, true, [...path, ".descr"]),
			protocol: expectString(json.protocol, true, [...path, ".protocol"]),
			status: expectNumber(json.status, true, true, [...path, ".status"]),
			formId: expectString(json.formId, true, [...path, ".formId"]),
			planOfActionId: expectString(json.planOfActionId, true, [...path, ".planOfActionId"]),
			healthElementId: expectString(json.healthElementId, true, [...path, ".healthElementId"]),
			classificationId: expectString(json.classificationId, true, [...path, ".classificationId"]),
			services: expectArray(json.services, false, [...path, ".services"], (x0, p0) => ServiceLink.fromJSON(x0, p0)),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
	}

}
