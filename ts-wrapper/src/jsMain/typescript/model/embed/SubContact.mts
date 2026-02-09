// auto-generated file
import {expectArray, expectNumber, expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {CodeStub} from '../base/CodeStub.mjs';
import {ICureDocument} from '../base/ICureDocument.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';
import {ServiceLink} from './ServiceLink.mjs';


export interface SubContact extends Encryptable, ICureDocument<string | undefined> {

	descr: string | undefined;

	protocol: string | undefined;

	formId: string | undefined;

	planOfActionId: string | undefined;

	healthElementId: string | undefined;

	services: Array<ServiceLink>;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

export class DecryptedSubContact {

	id: string | undefined = undefined;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	descr: string | undefined = undefined;

	protocol: string | undefined = undefined;

	formId: string | undefined = undefined;

	planOfActionId: string | undefined = undefined;

	healthElementId: string | undefined = undefined;

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
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('descr' in partial) this.descr = partial.descr;
		if ('protocol' in partial) this.protocol = partial.protocol;
		if ('formId' in partial) this.formId = partial.formId;
		if ('planOfActionId' in partial) this.planOfActionId = partial.planOfActionId;
		if ('healthElementId' in partial) this.healthElementId = partial.healthElementId;
		if ('services' in partial && partial.services !== undefined) this.services = partial.services;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.id != undefined) res['id'] = this.id
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.descr != undefined) res['descr'] = this.descr
		if (this.protocol != undefined) res['protocol'] = this.protocol
		if (this.formId != undefined) res['formId'] = this.formId
		if (this.planOfActionId != undefined) res['planOfActionId'] = this.planOfActionId
		if (this.healthElementId != undefined) res['healthElementId'] = this.healthElementId
		res['services'] = this.services.map((x0) => x0.toJSON() )
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = false
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedSubContact']): DecryptedSubContact {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedSubContact`)
		const res = new DecryptedSubContact({
			id: expectString(extractEntry(jCpy, 'id', false, path), true, [...path, ".id"]),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			descr: expectString(extractEntry(jCpy, 'descr', false, path), true, [...path, ".descr"]),
			protocol: expectString(extractEntry(jCpy, 'protocol', false, path), true, [...path, ".protocol"]),
			formId: expectString(extractEntry(jCpy, 'formId', false, path), true, [...path, ".formId"]),
			planOfActionId: expectString(extractEntry(jCpy, 'planOfActionId', false, path), true, [...path, ".planOfActionId"]),
			healthElementId: expectString(extractEntry(jCpy, 'healthElementId', false, path), true, [...path, ".healthElementId"]),
			services: expectArray(extractEntry(jCpy, 'services', false, path), false, [...path, ".services"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, ServiceLink.fromJSON)),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedSubContact at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export class EncryptedSubContact {

	id: string | undefined = undefined;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	descr: string | undefined = undefined;

	protocol: string | undefined = undefined;

	formId: string | undefined = undefined;

	planOfActionId: string | undefined = undefined;

	healthElementId: string | undefined = undefined;

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
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('descr' in partial) this.descr = partial.descr;
		if ('protocol' in partial) this.protocol = partial.protocol;
		if ('formId' in partial) this.formId = partial.formId;
		if ('planOfActionId' in partial) this.planOfActionId = partial.planOfActionId;
		if ('healthElementId' in partial) this.healthElementId = partial.healthElementId;
		if ('services' in partial && partial.services !== undefined) this.services = partial.services;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.id != undefined) res['id'] = this.id
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.descr != undefined) res['descr'] = this.descr
		if (this.protocol != undefined) res['protocol'] = this.protocol
		if (this.formId != undefined) res['formId'] = this.formId
		if (this.planOfActionId != undefined) res['planOfActionId'] = this.planOfActionId
		if (this.healthElementId != undefined) res['healthElementId'] = this.healthElementId
		res['services'] = this.services.map((x0) => x0.toJSON() )
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = true
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedSubContact']): EncryptedSubContact {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedSubContact`)
		const res = new EncryptedSubContact({
			id: expectString(extractEntry(jCpy, 'id', false, path), true, [...path, ".id"]),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			descr: expectString(extractEntry(jCpy, 'descr', false, path), true, [...path, ".descr"]),
			protocol: expectString(extractEntry(jCpy, 'protocol', false, path), true, [...path, ".protocol"]),
			formId: expectString(extractEntry(jCpy, 'formId', false, path), true, [...path, ".formId"]),
			planOfActionId: expectString(extractEntry(jCpy, 'planOfActionId', false, path), true, [...path, ".planOfActionId"]),
			healthElementId: expectString(extractEntry(jCpy, 'healthElementId', false, path), true, [...path, ".healthElementId"]),
			services: expectArray(extractEntry(jCpy, 'services', false, path), false, [...path, ".services"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, ServiceLink.fromJSON)),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedSubContact at path ${path.join("")}: ${unused}`)}
		return res
	}

}
