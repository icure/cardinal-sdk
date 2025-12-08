// auto-generated file
import {decodeBase64, encodeBase64} from '../internal/BytesEncoding.mjs';
import {expectArray, expectMap, expectNumber, expectObject, expectString, expectStringEnum, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {DataAttachment} from './embed/DataAttachment.mjs';
import {Delegation} from './embed/Delegation.mjs';
import {DeletedAttachment} from './embed/DeletedAttachment.mjs';
import {DocumentLocation} from './embed/DocumentLocation.mjs';
import {DocumentStatus} from './embed/DocumentStatus.mjs';
import {DocumentType} from './embed/DocumentType.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';
import {Base64String} from './specializations/Base64String.mjs';


export interface Document extends StoredDocument, ICureDocument<string>, HasEncryptionMetadata, Encryptable {

	documentLocation: DocumentLocation | undefined;

	documentType: DocumentType | undefined;

	documentStatus: DocumentStatus | undefined;

	externalUri: string | undefined;

	name: string | undefined;

	version: string | undefined;

	storedICureDocumentId: string | undefined;

	externalUuid: string | undefined;

	size: number | undefined;

	hash: string | undefined;

	openingContactId: string | undefined;

	attachmentId: string | undefined;

	objectStoreReference: string | undefined;

	mainUti: string | undefined;

	otherUtis: Array<string>;

	secondaryAttachments: { [ key: string ]: DataAttachment };

	deletedAttachments: Array<DeletedAttachment>;

	encryptedAttachment: Int8Array | undefined;

	decryptedAttachment: Int8Array | undefined;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

export class DecryptedDocument {

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

	documentLocation: DocumentLocation | undefined = undefined;

	documentType: DocumentType | undefined = undefined;

	documentStatus: DocumentStatus | undefined = undefined;

	externalUri: string | undefined = undefined;

	name: string | undefined = undefined;

	version: string | undefined = undefined;

	storedICureDocumentId: string | undefined = undefined;

	externalUuid: string | undefined = undefined;

	size: number | undefined = undefined;

	hash: string | undefined = undefined;

	openingContactId: string | undefined = undefined;

	attachmentId: string | undefined = undefined;

	objectStoreReference: string | undefined = undefined;

	mainUti: string | undefined = undefined;

	otherUtis: Array<string> = [];

	secondaryAttachments: { [ key: string ]: DataAttachment } = {};

	deletedAttachments: Array<DeletedAttachment> = [];

	encryptedAttachment: Int8Array | undefined = undefined;

	decryptedAttachment: Int8Array | undefined = undefined;

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

	securityMetadata: SecurityMetadata | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedDocument>) {
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
		if ('documentLocation' in partial) this.documentLocation = partial.documentLocation;
		if ('documentType' in partial) this.documentType = partial.documentType;
		if ('documentStatus' in partial) this.documentStatus = partial.documentStatus;
		if ('externalUri' in partial) this.externalUri = partial.externalUri;
		if ('name' in partial) this.name = partial.name;
		if ('version' in partial) this.version = partial.version;
		if ('storedICureDocumentId' in partial) this.storedICureDocumentId = partial.storedICureDocumentId;
		if ('externalUuid' in partial) this.externalUuid = partial.externalUuid;
		if ('size' in partial) this.size = partial.size;
		if ('hash' in partial) this.hash = partial.hash;
		if ('openingContactId' in partial) this.openingContactId = partial.openingContactId;
		if ('attachmentId' in partial) this.attachmentId = partial.attachmentId;
		if ('objectStoreReference' in partial) this.objectStoreReference = partial.objectStoreReference;
		if ('mainUti' in partial) this.mainUti = partial.mainUti;
		if ('otherUtis' in partial && partial.otherUtis !== undefined) this.otherUtis = partial.otherUtis;
		if ('secondaryAttachments' in partial && partial.secondaryAttachments !== undefined) this.secondaryAttachments = partial.secondaryAttachments;
		if ('deletedAttachments' in partial && partial.deletedAttachments !== undefined) this.deletedAttachments = partial.deletedAttachments;
		if ('encryptedAttachment' in partial) this.encryptedAttachment = partial.encryptedAttachment;
		if ('decryptedAttachment' in partial) this.decryptedAttachment = partial.decryptedAttachment;
		if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
	}

	toJSON(): object {
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
		if (this.documentLocation != undefined) res['documentLocation'] = this.documentLocation
		if (this.documentType != undefined) res['documentType'] = this.documentType
		if (this.documentStatus != undefined) res['documentStatus'] = this.documentStatus
		if (this.externalUri != undefined) res['externalUri'] = this.externalUri
		if (this.name != undefined) res['name'] = this.name
		if (this.version != undefined) res['version'] = this.version
		if (this.storedICureDocumentId != undefined) res['storedICureDocumentId'] = this.storedICureDocumentId
		if (this.externalUuid != undefined) res['externalUuid'] = this.externalUuid
		if (this.size != undefined) res['size'] = this.size
		if (this.hash != undefined) res['hash'] = this.hash
		if (this.openingContactId != undefined) res['openingContactId'] = this.openingContactId
		if (this.attachmentId != undefined) res['attachmentId'] = this.attachmentId
		if (this.objectStoreReference != undefined) res['objectStoreReference'] = this.objectStoreReference
		if (this.mainUti != undefined) res['mainUti'] = this.mainUti
		res['otherUtis'] = this.otherUtis.map((x0) => x0 )
		res['secondaryAttachments'] = Object.fromEntries(Object.entries(this.secondaryAttachments).map(([k0, v0]) => [k0, v0.toJSON()]))
		res['deletedAttachments'] = this.deletedAttachments.map((x0) => x0.toJSON() )
		if (this.encryptedAttachment != undefined) res['encryptedAttachment'] = encodeBase64(this.encryptedAttachment)
		if (this.decryptedAttachment != undefined) res['decryptedAttachment'] = encodeBase64(this.decryptedAttachment)
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
			path: Array<string> = ['DecryptedDocument']): DecryptedDocument {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedDocument`)
		const res = new DecryptedDocument({
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
			documentLocation: expectStringEnum(extractEntry(jCpy, 'documentLocation', false, path), true, [...path, ".documentLocation"], DocumentLocation, 'DocumentLocation'),
			documentType: expectStringEnum(extractEntry(jCpy, 'documentType', false, path), true, [...path, ".documentType"], DocumentType, 'DocumentType'),
			documentStatus: expectStringEnum(extractEntry(jCpy, 'documentStatus', false, path), true, [...path, ".documentStatus"], DocumentStatus, 'DocumentStatus'),
			externalUri: expectString(extractEntry(jCpy, 'externalUri', false, path), true, [...path, ".externalUri"]),
			name: expectString(extractEntry(jCpy, 'name', false, path), true, [...path, ".name"]),
			version: expectString(extractEntry(jCpy, 'version', false, path), true, [...path, ".version"]),
			storedICureDocumentId: expectString(extractEntry(jCpy, 'storedICureDocumentId', false, path), true, [...path, ".storedICureDocumentId"]),
			externalUuid: expectString(extractEntry(jCpy, 'externalUuid', false, path), true, [...path, ".externalUuid"]),
			size: expectNumber(extractEntry(jCpy, 'size', false, path), true, true, [...path, ".size"]),
			hash: expectString(extractEntry(jCpy, 'hash', false, path), true, [...path, ".hash"]),
			openingContactId: expectString(extractEntry(jCpy, 'openingContactId', false, path), true, [...path, ".openingContactId"]),
			attachmentId: expectString(extractEntry(jCpy, 'attachmentId', false, path), true, [...path, ".attachmentId"]),
			objectStoreReference: expectString(extractEntry(jCpy, 'objectStoreReference', false, path), true, [...path, ".objectStoreReference"]),
			mainUti: expectString(extractEntry(jCpy, 'mainUti', false, path), true, [...path, ".mainUti"]),
			otherUtis: expectArray(extractEntry(jCpy, 'otherUtis', false, path), false, [...path, ".otherUtis"], (x0, p0) => expectString(x0, false, p0)),
			secondaryAttachments: expectMap(
				extractEntry(jCpy, 'secondaryAttachments', false, path),
				false,
				[...path, ".secondaryAttachments"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectObject(v0, false, ignoreUnknownKeys, p0, DataAttachment.fromJSON)
			),
			deletedAttachments: expectArray(extractEntry(jCpy, 'deletedAttachments', false, path), false, [...path, ".deletedAttachments"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DeletedAttachment.fromJSON)),
			encryptedAttachment: decodeBase64(expectString(extractEntry(jCpy, 'encryptedAttachment', false, path), true, [...path, ".encryptedAttachment"]), [...path, ".encryptedAttachment"]),
			decryptedAttachment: decodeBase64(expectString(extractEntry(jCpy, 'decryptedAttachment', false, path), true, [...path, ".decryptedAttachment"]), [...path, ".decryptedAttachment"]),
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
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
			securityMetadata: expectObject(extractEntry(jCpy, 'securityMetadata', false, path), true, ignoreUnknownKeys, [...path, ".securityMetadata"], SecurityMetadata.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedDocument at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export class EncryptedDocument {

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

	documentLocation: DocumentLocation | undefined = undefined;

	documentType: DocumentType | undefined = undefined;

	documentStatus: DocumentStatus | undefined = undefined;

	externalUri: string | undefined = undefined;

	name: string | undefined = undefined;

	version: string | undefined = undefined;

	storedICureDocumentId: string | undefined = undefined;

	externalUuid: string | undefined = undefined;

	size: number | undefined = undefined;

	hash: string | undefined = undefined;

	openingContactId: string | undefined = undefined;

	attachmentId: string | undefined = undefined;

	objectStoreReference: string | undefined = undefined;

	mainUti: string | undefined = undefined;

	otherUtis: Array<string> = [];

	secondaryAttachments: { [ key: string ]: DataAttachment } = {};

	deletedAttachments: Array<DeletedAttachment> = [];

	encryptedAttachment: Int8Array | undefined = undefined;

	decryptedAttachment: Int8Array | undefined = undefined;

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

	securityMetadata: SecurityMetadata | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedDocument>) {
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
		if ('documentLocation' in partial) this.documentLocation = partial.documentLocation;
		if ('documentType' in partial) this.documentType = partial.documentType;
		if ('documentStatus' in partial) this.documentStatus = partial.documentStatus;
		if ('externalUri' in partial) this.externalUri = partial.externalUri;
		if ('name' in partial) this.name = partial.name;
		if ('version' in partial) this.version = partial.version;
		if ('storedICureDocumentId' in partial) this.storedICureDocumentId = partial.storedICureDocumentId;
		if ('externalUuid' in partial) this.externalUuid = partial.externalUuid;
		if ('size' in partial) this.size = partial.size;
		if ('hash' in partial) this.hash = partial.hash;
		if ('openingContactId' in partial) this.openingContactId = partial.openingContactId;
		if ('attachmentId' in partial) this.attachmentId = partial.attachmentId;
		if ('objectStoreReference' in partial) this.objectStoreReference = partial.objectStoreReference;
		if ('mainUti' in partial) this.mainUti = partial.mainUti;
		if ('otherUtis' in partial && partial.otherUtis !== undefined) this.otherUtis = partial.otherUtis;
		if ('secondaryAttachments' in partial && partial.secondaryAttachments !== undefined) this.secondaryAttachments = partial.secondaryAttachments;
		if ('deletedAttachments' in partial && partial.deletedAttachments !== undefined) this.deletedAttachments = partial.deletedAttachments;
		if ('encryptedAttachment' in partial) this.encryptedAttachment = partial.encryptedAttachment;
		if ('decryptedAttachment' in partial) this.decryptedAttachment = partial.decryptedAttachment;
		if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
	}

	toJSON(): object {
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
		if (this.documentLocation != undefined) res['documentLocation'] = this.documentLocation
		if (this.documentType != undefined) res['documentType'] = this.documentType
		if (this.documentStatus != undefined) res['documentStatus'] = this.documentStatus
		if (this.externalUri != undefined) res['externalUri'] = this.externalUri
		if (this.name != undefined) res['name'] = this.name
		if (this.version != undefined) res['version'] = this.version
		if (this.storedICureDocumentId != undefined) res['storedICureDocumentId'] = this.storedICureDocumentId
		if (this.externalUuid != undefined) res['externalUuid'] = this.externalUuid
		if (this.size != undefined) res['size'] = this.size
		if (this.hash != undefined) res['hash'] = this.hash
		if (this.openingContactId != undefined) res['openingContactId'] = this.openingContactId
		if (this.attachmentId != undefined) res['attachmentId'] = this.attachmentId
		if (this.objectStoreReference != undefined) res['objectStoreReference'] = this.objectStoreReference
		if (this.mainUti != undefined) res['mainUti'] = this.mainUti
		res['otherUtis'] = this.otherUtis.map((x0) => x0 )
		res['secondaryAttachments'] = Object.fromEntries(Object.entries(this.secondaryAttachments).map(([k0, v0]) => [k0, v0.toJSON()]))
		res['deletedAttachments'] = this.deletedAttachments.map((x0) => x0.toJSON() )
		if (this.encryptedAttachment != undefined) res['encryptedAttachment'] = encodeBase64(this.encryptedAttachment)
		if (this.decryptedAttachment != undefined) res['decryptedAttachment'] = encodeBase64(this.decryptedAttachment)
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
			path: Array<string> = ['EncryptedDocument']): EncryptedDocument {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedDocument`)
		const res = new EncryptedDocument({
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
			documentLocation: expectStringEnum(extractEntry(jCpy, 'documentLocation', false, path), true, [...path, ".documentLocation"], DocumentLocation, 'DocumentLocation'),
			documentType: expectStringEnum(extractEntry(jCpy, 'documentType', false, path), true, [...path, ".documentType"], DocumentType, 'DocumentType'),
			documentStatus: expectStringEnum(extractEntry(jCpy, 'documentStatus', false, path), true, [...path, ".documentStatus"], DocumentStatus, 'DocumentStatus'),
			externalUri: expectString(extractEntry(jCpy, 'externalUri', false, path), true, [...path, ".externalUri"]),
			name: expectString(extractEntry(jCpy, 'name', false, path), true, [...path, ".name"]),
			version: expectString(extractEntry(jCpy, 'version', false, path), true, [...path, ".version"]),
			storedICureDocumentId: expectString(extractEntry(jCpy, 'storedICureDocumentId', false, path), true, [...path, ".storedICureDocumentId"]),
			externalUuid: expectString(extractEntry(jCpy, 'externalUuid', false, path), true, [...path, ".externalUuid"]),
			size: expectNumber(extractEntry(jCpy, 'size', false, path), true, true, [...path, ".size"]),
			hash: expectString(extractEntry(jCpy, 'hash', false, path), true, [...path, ".hash"]),
			openingContactId: expectString(extractEntry(jCpy, 'openingContactId', false, path), true, [...path, ".openingContactId"]),
			attachmentId: expectString(extractEntry(jCpy, 'attachmentId', false, path), true, [...path, ".attachmentId"]),
			objectStoreReference: expectString(extractEntry(jCpy, 'objectStoreReference', false, path), true, [...path, ".objectStoreReference"]),
			mainUti: expectString(extractEntry(jCpy, 'mainUti', false, path), true, [...path, ".mainUti"]),
			otherUtis: expectArray(extractEntry(jCpy, 'otherUtis', false, path), false, [...path, ".otherUtis"], (x0, p0) => expectString(x0, false, p0)),
			secondaryAttachments: expectMap(
				extractEntry(jCpy, 'secondaryAttachments', false, path),
				false,
				[...path, ".secondaryAttachments"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectObject(v0, false, ignoreUnknownKeys, p0, DataAttachment.fromJSON)
			),
			deletedAttachments: expectArray(extractEntry(jCpy, 'deletedAttachments', false, path), false, [...path, ".deletedAttachments"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DeletedAttachment.fromJSON)),
			encryptedAttachment: decodeBase64(expectString(extractEntry(jCpy, 'encryptedAttachment', false, path), true, [...path, ".encryptedAttachment"]), [...path, ".encryptedAttachment"]),
			decryptedAttachment: decodeBase64(expectString(extractEntry(jCpy, 'decryptedAttachment', false, path), true, [...path, ".decryptedAttachment"]), [...path, ".decryptedAttachment"]),
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
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
			securityMetadata: expectObject(extractEntry(jCpy, 'securityMetadata', false, path), true, ignoreUnknownKeys, [...path, ".securityMetadata"], SecurityMetadata.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedDocument at path ${path.join("")}: ${unused}`)}
		return res
	}

}
