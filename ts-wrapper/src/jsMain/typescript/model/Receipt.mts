// auto-generated file
import {expectArray, expectMap, expectNumber, expectObject, expectString, expectStringEnum, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {Delegation} from './embed/Delegation.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {ReceiptBlobType} from './embed/ReceiptBlobType.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';
import {Base64String} from './specializations/Base64String.mjs';


export interface Receipt extends StoredDocument, ICureDocument<string>, HasEncryptionMetadata, Encryptable {

	attachmentIds: { [ key in ReceiptBlobType ]?: string };

	references: Array<string>;

	documentId: string | undefined;

	category: string | undefined;

	subCategory: string | undefined;

	readonly isEncrypted: boolean;

}

export class DecryptedReceipt {

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

	attachmentIds: { [ key in ReceiptBlobType ]?: string } = {};

	references: Array<string> = [];

	documentId: string | undefined = undefined;

	category: string | undefined = undefined;

	subCategory: string | undefined = undefined;

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

	securityMetadata: SecurityMetadata | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedReceipt>) {
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
		if ('attachmentIds' in partial && partial.attachmentIds !== undefined) this.attachmentIds = partial.attachmentIds;
		if ('references' in partial && partial.references !== undefined) this.references = partial.references;
		if ('documentId' in partial) this.documentId = partial.documentId;
		if ('category' in partial) this.category = partial.category;
		if ('subCategory' in partial) this.subCategory = partial.subCategory;
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
		res['attachmentIds'] = Object.fromEntries(Object.entries(this.attachmentIds).map(([k0, v0]) => [k0, v0]))
		res['references'] = this.references.map((x0) => x0 )
		if (this.documentId != undefined) res['documentId'] = this.documentId
		if (this.category != undefined) res['category'] = this.category
		if (this.subCategory != undefined) res['subCategory'] = this.subCategory
		res['secretForeignKeys'] = this.secretForeignKeys.map((x0) => x0 )
		res['cryptedForeignKeys'] = Object.fromEntries(Object.entries(this.cryptedForeignKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['delegations'] = Object.fromEntries(Object.entries(this.delegations).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['encryptionKeys'] = Object.fromEntries(Object.entries(this.encryptionKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		if (this.securityMetadata != undefined) res['securityMetadata'] = this.securityMetadata.toJSON()
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedReceipt']): DecryptedReceipt {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new DecryptedReceipt({
			id: expectString(extractEntry(jCpy.id, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy.rev, 'rev', false, path), true, [...path, ".rev"]),
			created: expectNumber(extractEntry(jCpy.created, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy.modified, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy.author, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy.responsible, 'responsible', false, path), true, [...path, ".responsible"]),
			medicalLocationId: expectString(extractEntry(jCpy.medicalLocationId, 'medicalLocationId', false, path), true, [...path, ".medicalLocationId"]),
			tags: expectArray(extractEntry(jCpy.tags, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy.codes, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			endOfLife: expectNumber(extractEntry(jCpy.endOfLife, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(extractEntry(jCpy.deletionDate, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			attachmentIds: expectMap(
				extractEntry(jCpy.attachmentIds, 'attachmentIds', false, path),
				false,
				[...path, ".attachmentIds"],
				(k0, p0) => expectStringEnum(k0, false, p0, ReceiptBlobType, 'ReceiptBlobType'),
				(v0, p0) => expectString(v0, false, p0)
			),
			references: expectArray(extractEntry(jCpy.references, 'references', false, path), false, [...path, ".references"], (x0, p0) => expectString(x0, false, p0)),
			documentId: expectString(extractEntry(jCpy.documentId, 'documentId', false, path), true, [...path, ".documentId"]),
			category: expectString(extractEntry(jCpy.category, 'category', false, path), true, [...path, ".category"]),
			subCategory: expectString(extractEntry(jCpy.subCategory, 'subCategory', false, path), true, [...path, ".subCategory"]),
			secretForeignKeys: expectArray(extractEntry(jCpy.secretForeignKeys, 'secretForeignKeys', false, path), false, [...path, ".secretForeignKeys"], (x0, p0) => expectString(x0, false, p0)),
			cryptedForeignKeys: expectMap(
				extractEntry(jCpy.cryptedForeignKeys, 'cryptedForeignKeys', false, path),
				false,
				[...path, ".cryptedForeignKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectObject(x1, false, ignoreUnknownKeys, p1, Delegation.fromJSON))
			),
			delegations: expectMap(
				extractEntry(jCpy.delegations, 'delegations', false, path),
				false,
				[...path, ".delegations"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectObject(x1, false, ignoreUnknownKeys, p1, Delegation.fromJSON))
			),
			encryptionKeys: expectMap(
				extractEntry(jCpy.encryptionKeys, 'encryptionKeys', false, path),
				false,
				[...path, ".encryptionKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectObject(x1, false, ignoreUnknownKeys, p1, Delegation.fromJSON))
			),
			encryptedSelf: expectString(extractEntry(jCpy.encryptedSelf, 'encryptedSelf', false, path), false, [...path, ".encryptedSelf"]),
			securityMetadata: expectObject(extractEntry(jCpy.securityMetadata, 'securityMetadata', false, path), true, ignoreUnknownKeys, [...path, ".securityMetadata"], SecurityMetadata.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedReceipt at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export class EncryptedReceipt {

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

	attachmentIds: { [ key in ReceiptBlobType ]?: string } = {};

	references: Array<string> = [];

	documentId: string | undefined = undefined;

	category: string | undefined = undefined;

	subCategory: string | undefined = undefined;

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

	securityMetadata: SecurityMetadata | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedReceipt>) {
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
		if ('attachmentIds' in partial && partial.attachmentIds !== undefined) this.attachmentIds = partial.attachmentIds;
		if ('references' in partial && partial.references !== undefined) this.references = partial.references;
		if ('documentId' in partial) this.documentId = partial.documentId;
		if ('category' in partial) this.category = partial.category;
		if ('subCategory' in partial) this.subCategory = partial.subCategory;
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
		res['attachmentIds'] = Object.fromEntries(Object.entries(this.attachmentIds).map(([k0, v0]) => [k0, v0]))
		res['references'] = this.references.map((x0) => x0 )
		if (this.documentId != undefined) res['documentId'] = this.documentId
		if (this.category != undefined) res['category'] = this.category
		if (this.subCategory != undefined) res['subCategory'] = this.subCategory
		res['secretForeignKeys'] = this.secretForeignKeys.map((x0) => x0 )
		res['cryptedForeignKeys'] = Object.fromEntries(Object.entries(this.cryptedForeignKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['delegations'] = Object.fromEntries(Object.entries(this.delegations).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['encryptionKeys'] = Object.fromEntries(Object.entries(this.encryptionKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		if (this.securityMetadata != undefined) res['securityMetadata'] = this.securityMetadata.toJSON()
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedReceipt']): EncryptedReceipt {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new EncryptedReceipt({
			id: expectString(extractEntry(jCpy.id, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy.rev, 'rev', false, path), true, [...path, ".rev"]),
			created: expectNumber(extractEntry(jCpy.created, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy.modified, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy.author, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy.responsible, 'responsible', false, path), true, [...path, ".responsible"]),
			medicalLocationId: expectString(extractEntry(jCpy.medicalLocationId, 'medicalLocationId', false, path), true, [...path, ".medicalLocationId"]),
			tags: expectArray(extractEntry(jCpy.tags, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy.codes, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			endOfLife: expectNumber(extractEntry(jCpy.endOfLife, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(extractEntry(jCpy.deletionDate, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			attachmentIds: expectMap(
				extractEntry(jCpy.attachmentIds, 'attachmentIds', false, path),
				false,
				[...path, ".attachmentIds"],
				(k0, p0) => expectStringEnum(k0, false, p0, ReceiptBlobType, 'ReceiptBlobType'),
				(v0, p0) => expectString(v0, false, p0)
			),
			references: expectArray(extractEntry(jCpy.references, 'references', false, path), false, [...path, ".references"], (x0, p0) => expectString(x0, false, p0)),
			documentId: expectString(extractEntry(jCpy.documentId, 'documentId', false, path), true, [...path, ".documentId"]),
			category: expectString(extractEntry(jCpy.category, 'category', false, path), true, [...path, ".category"]),
			subCategory: expectString(extractEntry(jCpy.subCategory, 'subCategory', false, path), true, [...path, ".subCategory"]),
			secretForeignKeys: expectArray(extractEntry(jCpy.secretForeignKeys, 'secretForeignKeys', false, path), false, [...path, ".secretForeignKeys"], (x0, p0) => expectString(x0, false, p0)),
			cryptedForeignKeys: expectMap(
				extractEntry(jCpy.cryptedForeignKeys, 'cryptedForeignKeys', false, path),
				false,
				[...path, ".cryptedForeignKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectObject(x1, false, ignoreUnknownKeys, p1, Delegation.fromJSON))
			),
			delegations: expectMap(
				extractEntry(jCpy.delegations, 'delegations', false, path),
				false,
				[...path, ".delegations"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectObject(x1, false, ignoreUnknownKeys, p1, Delegation.fromJSON))
			),
			encryptionKeys: expectMap(
				extractEntry(jCpy.encryptionKeys, 'encryptionKeys', false, path),
				false,
				[...path, ".encryptionKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectObject(x1, false, ignoreUnknownKeys, p1, Delegation.fromJSON))
			),
			encryptedSelf: expectString(extractEntry(jCpy.encryptedSelf, 'encryptedSelf', false, path), false, [...path, ".encryptedSelf"]),
			securityMetadata: expectObject(extractEntry(jCpy.securityMetadata, 'securityMetadata', false, path), true, ignoreUnknownKeys, [...path, ".securityMetadata"], SecurityMetadata.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedReceipt at path ${path.join("")}: ${unused}`)}
		return res
	}

}
