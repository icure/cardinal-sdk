// auto-generated file
import {expectArray, expectMap, expectNumber, expectObject, expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {Delegation} from './embed/Delegation.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';
import {Base64String} from './specializations/Base64String.mjs';


export interface AccessLog extends StoredDocument, ICureDocument<string>, HasEncryptionMetadata, Encryptable {

	objectId: string | undefined;

	accessType: string | undefined;

	user: string | undefined;

	detail: string | undefined;

	date: number | undefined;

	patientId: string | undefined;

	readonly isEncrypted: boolean;

}

export class DecryptedAccessLog {

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

	objectId: string | undefined = undefined;

	accessType: string | undefined = undefined;

	user: string | undefined = undefined;

	detail: string | undefined = undefined;

	date: number | undefined = undefined;

	patientId: string | undefined = undefined;

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

	securityMetadata: SecurityMetadata | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedAccessLog>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
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
		if ('objectId' in partial) this.objectId = partial.objectId;
		if ('accessType' in partial) this.accessType = partial.accessType;
		if ('user' in partial) this.user = partial.user;
		if ('detail' in partial) this.detail = partial.detail;
		if ('date' in partial) this.date = partial.date;
		if ('patientId' in partial) this.patientId = partial.patientId;
		if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
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
		if (this.objectId != undefined) res['objectId'] = this.objectId
		if (this.accessType != undefined) res['accessType'] = this.accessType
		if (this.user != undefined) res['user'] = this.user
		if (this.detail != undefined) res['detail'] = this.detail
		if (this.date != undefined) res['date'] = this.date
		if (this.patientId != undefined) res['patientId'] = this.patientId
		res['secretForeignKeys'] = this.secretForeignKeys.map((x0) => x0 )
		res['cryptedForeignKeys'] = Object.fromEntries(Object.entries(this.cryptedForeignKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['delegations'] = Object.fromEntries(Object.entries(this.delegations).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['encryptionKeys'] = Object.fromEntries(Object.entries(this.encryptionKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		if (this.securityMetadata != undefined) res['securityMetadata'] = this.securityMetadata.toJSON()
		res['isEncrypted'] = false
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedAccessLog']): DecryptedAccessLog {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedAccessLog`)
		const res = new DecryptedAccessLog({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			medicalLocationId: expectString(extractEntry(jCpy, 'medicalLocationId', false, path), true, [...path, ".medicalLocationId"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			endOfLife: expectNumber(extractEntry(jCpy, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			objectId: expectString(extractEntry(jCpy, 'objectId', false, path), true, [...path, ".objectId"]),
			accessType: expectString(extractEntry(jCpy, 'accessType', false, path), true, [...path, ".accessType"]),
			user: expectString(extractEntry(jCpy, 'user', false, path), true, [...path, ".user"]),
			detail: expectString(extractEntry(jCpy, 'detail', false, path), true, [...path, ".detail"]),
			date: expectNumber(extractEntry(jCpy, 'date', false, path), true, true, [...path, ".date"]),
			patientId: expectString(extractEntry(jCpy, 'patientId', false, path), true, [...path, ".patientId"]),
			secretForeignKeys: expectArray(extractEntry(jCpy, 'secretForeignKeys', false, path), false, [...path, ".secretForeignKeys"], (x0, p0) => expectString(x0, false, p0)),
			cryptedForeignKeys: expectMap(
				extractEntry(jCpy, 'cryptedForeignKeys', false, path),
				false,
				[...path, ".cryptedForeignKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectObject(x1, false, ignoreUnknownKeys, p1, Delegation.fromJSON))
			),
			delegations: expectMap(
				extractEntry(jCpy, 'delegations', false, path),
				false,
				[...path, ".delegations"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectObject(x1, false, ignoreUnknownKeys, p1, Delegation.fromJSON))
			),
			encryptionKeys: expectMap(
				extractEntry(jCpy, 'encryptionKeys', false, path),
				false,
				[...path, ".encryptionKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectObject(x1, false, ignoreUnknownKeys, p1, Delegation.fromJSON))
			),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]),
			securityMetadata: expectObject(extractEntry(jCpy, 'securityMetadata', false, path), true, ignoreUnknownKeys, [...path, ".securityMetadata"], SecurityMetadata.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedAccessLog at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export class EncryptedAccessLog {

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

	objectId: string | undefined = undefined;

	accessType: string | undefined = undefined;

	user: string | undefined = undefined;

	detail: string | undefined = undefined;

	date: number | undefined = undefined;

	patientId: string | undefined = undefined;

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

	securityMetadata: SecurityMetadata | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedAccessLog>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
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
		if ('objectId' in partial) this.objectId = partial.objectId;
		if ('accessType' in partial) this.accessType = partial.accessType;
		if ('user' in partial) this.user = partial.user;
		if ('detail' in partial) this.detail = partial.detail;
		if ('date' in partial) this.date = partial.date;
		if ('patientId' in partial) this.patientId = partial.patientId;
		if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
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
		if (this.objectId != undefined) res['objectId'] = this.objectId
		if (this.accessType != undefined) res['accessType'] = this.accessType
		if (this.user != undefined) res['user'] = this.user
		if (this.detail != undefined) res['detail'] = this.detail
		if (this.date != undefined) res['date'] = this.date
		if (this.patientId != undefined) res['patientId'] = this.patientId
		res['secretForeignKeys'] = this.secretForeignKeys.map((x0) => x0 )
		res['cryptedForeignKeys'] = Object.fromEntries(Object.entries(this.cryptedForeignKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['delegations'] = Object.fromEntries(Object.entries(this.delegations).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['encryptionKeys'] = Object.fromEntries(Object.entries(this.encryptionKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		if (this.securityMetadata != undefined) res['securityMetadata'] = this.securityMetadata.toJSON()
		res['isEncrypted'] = true
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedAccessLog']): EncryptedAccessLog {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedAccessLog`)
		const res = new EncryptedAccessLog({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			medicalLocationId: expectString(extractEntry(jCpy, 'medicalLocationId', false, path), true, [...path, ".medicalLocationId"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			endOfLife: expectNumber(extractEntry(jCpy, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			objectId: expectString(extractEntry(jCpy, 'objectId', false, path), true, [...path, ".objectId"]),
			accessType: expectString(extractEntry(jCpy, 'accessType', false, path), true, [...path, ".accessType"]),
			user: expectString(extractEntry(jCpy, 'user', false, path), true, [...path, ".user"]),
			detail: expectString(extractEntry(jCpy, 'detail', false, path), true, [...path, ".detail"]),
			date: expectNumber(extractEntry(jCpy, 'date', false, path), true, true, [...path, ".date"]),
			patientId: expectString(extractEntry(jCpy, 'patientId', false, path), true, [...path, ".patientId"]),
			secretForeignKeys: expectArray(extractEntry(jCpy, 'secretForeignKeys', false, path), false, [...path, ".secretForeignKeys"], (x0, p0) => expectString(x0, false, p0)),
			cryptedForeignKeys: expectMap(
				extractEntry(jCpy, 'cryptedForeignKeys', false, path),
				false,
				[...path, ".cryptedForeignKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectObject(x1, false, ignoreUnknownKeys, p1, Delegation.fromJSON))
			),
			delegations: expectMap(
				extractEntry(jCpy, 'delegations', false, path),
				false,
				[...path, ".delegations"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectObject(x1, false, ignoreUnknownKeys, p1, Delegation.fromJSON))
			),
			encryptionKeys: expectMap(
				extractEntry(jCpy, 'encryptionKeys', false, path),
				false,
				[...path, ".encryptionKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectObject(x1, false, ignoreUnknownKeys, p1, Delegation.fromJSON))
			),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]),
			securityMetadata: expectObject(extractEntry(jCpy, 'securityMetadata', false, path), true, ignoreUnknownKeys, [...path, ".securityMetadata"], SecurityMetadata.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedAccessLog at path ${path.join("")}: ${unused}`)}
		return res
	}

}
