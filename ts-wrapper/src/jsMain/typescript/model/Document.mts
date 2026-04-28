// auto-generated file
import {expectArray, expectMap, expectNumber, expectObject, expectString, expectStringEnum, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {Document as Document_} from './Document.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {DataAttachment} from './embed/DataAttachment.mjs';
import {Delegation} from './embed/Delegation.mjs';
import {DeletedAttachment} from './embed/DeletedAttachment.mjs';
import {DocumentStatus} from './embed/DocumentStatus.mjs';
import {DocumentType} from './embed/DocumentType.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';
import {Base64String} from './specializations/Base64String.mjs';


/**
 *
 *  Represents a document entity stored in CouchDB. Documents can have main and secondary data
 *  attachments,
 *  and support various storage backends (CouchDB attachments, object storage).
 *  /
 */
export interface Document extends StoredDocument, ICureDocument<string>, HasEncryptionMetadata, Encryptable {

	/**
	 *
	 *  The type of document (e.g., admission, clinical path, document report, invoice).
	 */
	documentType: DocumentType | undefined;

	/**
	 *
	 *  The status of the document development (e.g., Draft, finalized, reviewed, signed).
	 */
	documentStatus: DocumentStatus | undefined;

	/**
	 *
	 *  When the document is stored externally, the URI of the document in that repository.
	 */
	externalUri: string | undefined;

	/**
	 *
	 *  The name of the document.
	 */
	name: string | undefined;

	/**
	 *
	 *  The document version.
	 */
	version: string | undefined;

	/**
	 *
	 *  The size of the document file.
	 */
	size: number | undefined;

	/**
	 *
	 *  The hashed version of the document.
	 */
	hash: string | undefined;

	/**
	 *
	 *  The id of the contact during which the document was created.
	 */
	openingContactId: string | undefined;

	/**
	 *
	 *  The id of the main attachment stored as a CouchDB attachment.
	 */
	attachmentId: string | undefined;

	/**
	 *
	 *  The id of the main attachment in the object storage service.
	 */
	objectStoreReference: string | undefined;

	/**
	 *
	 *  The main Uniform Type Identifier of the main attachment.
	 */
	mainUti: string | undefined;

	/**
	 *
	 *  Extra Uniform Type Identifiers for the main attachment.
	 */
	otherUtis: Array<string>;

	/**
	 *
	 *  Extra Uniform Type Identifiers for the main attachment.
	 */
	mainAttachmentStoredDataSize: number | undefined;

	extraMainAttachmentInfo: Document.ExtraMainAttachmentInfo | undefined;

	/**
	 *
	 *  Secondary attachments for this document.
	 */
	secondaryAttachments: { [ key: string ]: DataAttachment };

	/**
	 *
	 *  Information on past attachments for this document.
	 */
	deletedAttachments: Array<DeletedAttachment>;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

/**
 *
 *  Represents a document entity stored in CouchDB. Documents can have main and secondary data
 *  attachments,
 *  and support various storage backends (CouchDB attachments, object storage).
 *  /
 */
export class DecryptedDocument {

	/**
	 *
	 *  The Id of the document. We encourage using either a v4 UUID or a HL7 Id.
	 */
	id: string;

	/**
	 *
	 *  The revision of the document in the database, used for conflict management / optimistic locking.
	 */
	rev: string | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) of creation of this entity.
	 */
	created: number | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) of the latest modification of this entity.
	 */
	modified: number | undefined = undefined;

	/**
	 *
	 *  The id of the User that created this document.
	 */
	author: string | undefined = undefined;

	/**
	 *
	 *  The id of the data owner that is responsible for this document.
	 */
	responsible: string | undefined = undefined;

	/**
	 *
	 *  Tags that qualify the document as being member of a certain class.
	 */
	tags: Array<CodeStub> = [];

	/**
	 *
	 *  Codes that identify or qualify this particular document.
	 */
	codes: Array<CodeStub> = [];

	/**
	 *
	 *  Hard delete (unix epoch in ms) timestamp of the object.
	 */
	deletionDate: number | undefined = undefined;

	/**
	 *
	 *  The type of document (e.g., admission, clinical path, document report, invoice).
	 */
	documentType: DocumentType | undefined = undefined;

	/**
	 *
	 *  The status of the document development (e.g., Draft, finalized, reviewed, signed).
	 */
	documentStatus: DocumentStatus | undefined = undefined;

	/**
	 *
	 *  When the document is stored externally, the URI of the document in that repository.
	 */
	externalUri: string | undefined = undefined;

	/**
	 *
	 *  The name of the document.
	 */
	name: string | undefined = undefined;

	/**
	 *
	 *  The document version.
	 */
	version: string | undefined = undefined;

	/**
	 *
	 *  The size of the document file.
	 */
	size: number | undefined = undefined;

	/**
	 *
	 *  The hashed version of the document.
	 */
	hash: string | undefined = undefined;

	/**
	 *
	 *  The id of the contact during which the document was created.
	 */
	openingContactId: string | undefined = undefined;

	/**
	 *
	 *  The id of the main attachment stored as a CouchDB attachment.
	 */
	attachmentId: string | undefined = undefined;

	/**
	 *
	 *  The id of the main attachment in the object storage service.
	 */
	objectStoreReference: string | undefined = undefined;

	/**
	 *
	 *  The main Uniform Type Identifier of the main attachment.
	 */
	mainUti: string | undefined = undefined;

	/**
	 *
	 *  Extra Uniform Type Identifiers for the main attachment.
	 */
	otherUtis: Array<string> = [];

	/**
	 *
	 *  Extra Uniform Type Identifiers for the main attachment.
	 */
	mainAttachmentStoredDataSize: number | undefined = undefined;

	extraMainAttachmentInfo: Document_.ExtraMainAttachmentInfo | undefined = undefined;

	/**
	 *
	 *  Secondary attachments for this document.
	 */
	secondaryAttachments: { [ key: string ]: DataAttachment } = {};

	/**
	 *
	 *  Information on past attachments for this document.
	 */
	deletedAttachments: Array<DeletedAttachment> = [];

	/**
	 *
	 *  The secret foreign keys, used for secure linking to patients.
	 */
	secretForeignKeys: Array<string> = [];

	/**
	 *
	 *  The encrypted foreign keys.
	 */
	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The delegations giving access to connected healthcare information.
	 */
	delegations: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The encryption keys used to encrypt secured properties, encrypted for separate Crypto Actors.
	 */
	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The base64-encoded encrypted fields of this document.
	 */
	encryptedSelf: Base64String | undefined = undefined;

	/**
	 *
	 *  The security metadata of this entity, for access control.
	 */
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
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('documentType' in partial) this.documentType = partial.documentType;
		if ('documentStatus' in partial) this.documentStatus = partial.documentStatus;
		if ('externalUri' in partial) this.externalUri = partial.externalUri;
		if ('name' in partial) this.name = partial.name;
		if ('version' in partial) this.version = partial.version;
		if ('size' in partial) this.size = partial.size;
		if ('hash' in partial) this.hash = partial.hash;
		if ('openingContactId' in partial) this.openingContactId = partial.openingContactId;
		if ('attachmentId' in partial) this.attachmentId = partial.attachmentId;
		if ('objectStoreReference' in partial) this.objectStoreReference = partial.objectStoreReference;
		if ('mainUti' in partial) this.mainUti = partial.mainUti;
		if ('otherUtis' in partial && partial.otherUtis !== undefined) this.otherUtis = partial.otherUtis;
		if ('mainAttachmentStoredDataSize' in partial) this.mainAttachmentStoredDataSize = partial.mainAttachmentStoredDataSize;
		if ('extraMainAttachmentInfo' in partial) this.extraMainAttachmentInfo = partial.extraMainAttachmentInfo;
		if ('secondaryAttachments' in partial && partial.secondaryAttachments !== undefined) this.secondaryAttachments = partial.secondaryAttachments;
		if ('deletedAttachments' in partial && partial.deletedAttachments !== undefined) this.deletedAttachments = partial.deletedAttachments;
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
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.documentType != undefined) res['documentType'] = this.documentType
		if (this.documentStatus != undefined) res['documentStatus'] = this.documentStatus
		if (this.externalUri != undefined) res['externalUri'] = this.externalUri
		if (this.name != undefined) res['name'] = this.name
		if (this.version != undefined) res['version'] = this.version
		if (this.size != undefined) res['size'] = this.size
		if (this.hash != undefined) res['hash'] = this.hash
		if (this.openingContactId != undefined) res['openingContactId'] = this.openingContactId
		if (this.attachmentId != undefined) res['attachmentId'] = this.attachmentId
		if (this.objectStoreReference != undefined) res['objectStoreReference'] = this.objectStoreReference
		if (this.mainUti != undefined) res['mainUti'] = this.mainUti
		res['otherUtis'] = this.otherUtis.map((x0) => x0 )
		if (this.mainAttachmentStoredDataSize != undefined) res['mainAttachmentStoredDataSize'] = this.mainAttachmentStoredDataSize
		if (this.extraMainAttachmentInfo != undefined) res['extraMainAttachmentInfo'] = this.extraMainAttachmentInfo.toJSON()
		res['secondaryAttachments'] = Object.fromEntries(Object.entries(this.secondaryAttachments).map(([k0, v0]) => [k0, v0.toJSON()]))
		res['deletedAttachments'] = this.deletedAttachments.map((x0) => x0.toJSON() )
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
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			documentType: expectStringEnum(extractEntry(jCpy, 'documentType', false, path), true, [...path, ".documentType"], DocumentType, 'DocumentType'),
			documentStatus: expectStringEnum(extractEntry(jCpy, 'documentStatus', false, path), true, [...path, ".documentStatus"], DocumentStatus, 'DocumentStatus'),
			externalUri: expectString(extractEntry(jCpy, 'externalUri', false, path), true, [...path, ".externalUri"]),
			name: expectString(extractEntry(jCpy, 'name', false, path), true, [...path, ".name"]),
			version: expectString(extractEntry(jCpy, 'version', false, path), true, [...path, ".version"]),
			size: expectNumber(extractEntry(jCpy, 'size', false, path), true, true, [...path, ".size"]),
			hash: expectString(extractEntry(jCpy, 'hash', false, path), true, [...path, ".hash"]),
			openingContactId: expectString(extractEntry(jCpy, 'openingContactId', false, path), true, [...path, ".openingContactId"]),
			attachmentId: expectString(extractEntry(jCpy, 'attachmentId', false, path), true, [...path, ".attachmentId"]),
			objectStoreReference: expectString(extractEntry(jCpy, 'objectStoreReference', false, path), true, [...path, ".objectStoreReference"]),
			mainUti: expectString(extractEntry(jCpy, 'mainUti', false, path), true, [...path, ".mainUti"]),
			otherUtis: expectArray(extractEntry(jCpy, 'otherUtis', false, path), false, [...path, ".otherUtis"], (x0, p0) => expectString(x0, false, p0)),
			mainAttachmentStoredDataSize: expectNumber(extractEntry(jCpy, 'mainAttachmentStoredDataSize', false, path), true, true, [...path, ".mainAttachmentStoredDataSize"]),
			extraMainAttachmentInfo: expectObject(extractEntry(jCpy, 'extraMainAttachmentInfo', false, path), true, ignoreUnknownKeys, [...path, ".extraMainAttachmentInfo"], Document_.ExtraMainAttachmentInfo.fromJSON),
			secondaryAttachments: expectMap(
				extractEntry(jCpy, 'secondaryAttachments', false, path),
				false,
				[...path, ".secondaryAttachments"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectObject(v0, false, ignoreUnknownKeys, p0, DataAttachment.fromJSON)
			),
			deletedAttachments: expectArray(extractEntry(jCpy, 'deletedAttachments', false, path), false, [...path, ".deletedAttachments"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DeletedAttachment.fromJSON)),
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

/**
 *
 *  Represents a document entity stored in CouchDB. Documents can have main and secondary data
 *  attachments,
 *  and support various storage backends (CouchDB attachments, object storage).
 *  /
 */
export class EncryptedDocument {

	/**
	 *
	 *  The Id of the document. We encourage using either a v4 UUID or a HL7 Id.
	 */
	id: string;

	/**
	 *
	 *  The revision of the document in the database, used for conflict management / optimistic locking.
	 */
	rev: string | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) of creation of this entity.
	 */
	created: number | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) of the latest modification of this entity.
	 */
	modified: number | undefined = undefined;

	/**
	 *
	 *  The id of the User that created this document.
	 */
	author: string | undefined = undefined;

	/**
	 *
	 *  The id of the data owner that is responsible for this document.
	 */
	responsible: string | undefined = undefined;

	/**
	 *
	 *  Tags that qualify the document as being member of a certain class.
	 */
	tags: Array<CodeStub> = [];

	/**
	 *
	 *  Codes that identify or qualify this particular document.
	 */
	codes: Array<CodeStub> = [];

	/**
	 *
	 *  Hard delete (unix epoch in ms) timestamp of the object.
	 */
	deletionDate: number | undefined = undefined;

	/**
	 *
	 *  The type of document (e.g., admission, clinical path, document report, invoice).
	 */
	documentType: DocumentType | undefined = undefined;

	/**
	 *
	 *  The status of the document development (e.g., Draft, finalized, reviewed, signed).
	 */
	documentStatus: DocumentStatus | undefined = undefined;

	/**
	 *
	 *  When the document is stored externally, the URI of the document in that repository.
	 */
	externalUri: string | undefined = undefined;

	/**
	 *
	 *  The name of the document.
	 */
	name: string | undefined = undefined;

	/**
	 *
	 *  The document version.
	 */
	version: string | undefined = undefined;

	/**
	 *
	 *  The size of the document file.
	 */
	size: number | undefined = undefined;

	/**
	 *
	 *  The hashed version of the document.
	 */
	hash: string | undefined = undefined;

	/**
	 *
	 *  The id of the contact during which the document was created.
	 */
	openingContactId: string | undefined = undefined;

	/**
	 *
	 *  The id of the main attachment stored as a CouchDB attachment.
	 */
	attachmentId: string | undefined = undefined;

	/**
	 *
	 *  The id of the main attachment in the object storage service.
	 */
	objectStoreReference: string | undefined = undefined;

	/**
	 *
	 *  The main Uniform Type Identifier of the main attachment.
	 */
	mainUti: string | undefined = undefined;

	/**
	 *
	 *  Extra Uniform Type Identifiers for the main attachment.
	 */
	otherUtis: Array<string> = [];

	/**
	 *
	 *  Extra Uniform Type Identifiers for the main attachment.
	 */
	mainAttachmentStoredDataSize: number | undefined = undefined;

	extraMainAttachmentInfo: Document_.ExtraMainAttachmentInfo | undefined = undefined;

	/**
	 *
	 *  Secondary attachments for this document.
	 */
	secondaryAttachments: { [ key: string ]: DataAttachment } = {};

	/**
	 *
	 *  Information on past attachments for this document.
	 */
	deletedAttachments: Array<DeletedAttachment> = [];

	/**
	 *
	 *  The secret foreign keys, used for secure linking to patients.
	 */
	secretForeignKeys: Array<string> = [];

	/**
	 *
	 *  The encrypted foreign keys.
	 */
	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The delegations giving access to connected healthcare information.
	 */
	delegations: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The encryption keys used to encrypt secured properties, encrypted for separate Crypto Actors.
	 */
	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The base64-encoded encrypted fields of this document.
	 */
	encryptedSelf: Base64String | undefined = undefined;

	/**
	 *
	 *  The security metadata of this entity, for access control.
	 */
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
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('documentType' in partial) this.documentType = partial.documentType;
		if ('documentStatus' in partial) this.documentStatus = partial.documentStatus;
		if ('externalUri' in partial) this.externalUri = partial.externalUri;
		if ('name' in partial) this.name = partial.name;
		if ('version' in partial) this.version = partial.version;
		if ('size' in partial) this.size = partial.size;
		if ('hash' in partial) this.hash = partial.hash;
		if ('openingContactId' in partial) this.openingContactId = partial.openingContactId;
		if ('attachmentId' in partial) this.attachmentId = partial.attachmentId;
		if ('objectStoreReference' in partial) this.objectStoreReference = partial.objectStoreReference;
		if ('mainUti' in partial) this.mainUti = partial.mainUti;
		if ('otherUtis' in partial && partial.otherUtis !== undefined) this.otherUtis = partial.otherUtis;
		if ('mainAttachmentStoredDataSize' in partial) this.mainAttachmentStoredDataSize = partial.mainAttachmentStoredDataSize;
		if ('extraMainAttachmentInfo' in partial) this.extraMainAttachmentInfo = partial.extraMainAttachmentInfo;
		if ('secondaryAttachments' in partial && partial.secondaryAttachments !== undefined) this.secondaryAttachments = partial.secondaryAttachments;
		if ('deletedAttachments' in partial && partial.deletedAttachments !== undefined) this.deletedAttachments = partial.deletedAttachments;
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
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.documentType != undefined) res['documentType'] = this.documentType
		if (this.documentStatus != undefined) res['documentStatus'] = this.documentStatus
		if (this.externalUri != undefined) res['externalUri'] = this.externalUri
		if (this.name != undefined) res['name'] = this.name
		if (this.version != undefined) res['version'] = this.version
		if (this.size != undefined) res['size'] = this.size
		if (this.hash != undefined) res['hash'] = this.hash
		if (this.openingContactId != undefined) res['openingContactId'] = this.openingContactId
		if (this.attachmentId != undefined) res['attachmentId'] = this.attachmentId
		if (this.objectStoreReference != undefined) res['objectStoreReference'] = this.objectStoreReference
		if (this.mainUti != undefined) res['mainUti'] = this.mainUti
		res['otherUtis'] = this.otherUtis.map((x0) => x0 )
		if (this.mainAttachmentStoredDataSize != undefined) res['mainAttachmentStoredDataSize'] = this.mainAttachmentStoredDataSize
		if (this.extraMainAttachmentInfo != undefined) res['extraMainAttachmentInfo'] = this.extraMainAttachmentInfo.toJSON()
		res['secondaryAttachments'] = Object.fromEntries(Object.entries(this.secondaryAttachments).map(([k0, v0]) => [k0, v0.toJSON()]))
		res['deletedAttachments'] = this.deletedAttachments.map((x0) => x0.toJSON() )
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
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			documentType: expectStringEnum(extractEntry(jCpy, 'documentType', false, path), true, [...path, ".documentType"], DocumentType, 'DocumentType'),
			documentStatus: expectStringEnum(extractEntry(jCpy, 'documentStatus', false, path), true, [...path, ".documentStatus"], DocumentStatus, 'DocumentStatus'),
			externalUri: expectString(extractEntry(jCpy, 'externalUri', false, path), true, [...path, ".externalUri"]),
			name: expectString(extractEntry(jCpy, 'name', false, path), true, [...path, ".name"]),
			version: expectString(extractEntry(jCpy, 'version', false, path), true, [...path, ".version"]),
			size: expectNumber(extractEntry(jCpy, 'size', false, path), true, true, [...path, ".size"]),
			hash: expectString(extractEntry(jCpy, 'hash', false, path), true, [...path, ".hash"]),
			openingContactId: expectString(extractEntry(jCpy, 'openingContactId', false, path), true, [...path, ".openingContactId"]),
			attachmentId: expectString(extractEntry(jCpy, 'attachmentId', false, path), true, [...path, ".attachmentId"]),
			objectStoreReference: expectString(extractEntry(jCpy, 'objectStoreReference', false, path), true, [...path, ".objectStoreReference"]),
			mainUti: expectString(extractEntry(jCpy, 'mainUti', false, path), true, [...path, ".mainUti"]),
			otherUtis: expectArray(extractEntry(jCpy, 'otherUtis', false, path), false, [...path, ".otherUtis"], (x0, p0) => expectString(x0, false, p0)),
			mainAttachmentStoredDataSize: expectNumber(extractEntry(jCpy, 'mainAttachmentStoredDataSize', false, path), true, true, [...path, ".mainAttachmentStoredDataSize"]),
			extraMainAttachmentInfo: expectObject(extractEntry(jCpy, 'extraMainAttachmentInfo', false, path), true, ignoreUnknownKeys, [...path, ".extraMainAttachmentInfo"], Document_.ExtraMainAttachmentInfo.fromJSON),
			secondaryAttachments: expectMap(
				extractEntry(jCpy, 'secondaryAttachments', false, path),
				false,
				[...path, ".secondaryAttachments"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectObject(v0, false, ignoreUnknownKeys, p0, DataAttachment.fromJSON)
			),
			deletedAttachments: expectArray(extractEntry(jCpy, 'deletedAttachments', false, path), false, [...path, ".deletedAttachments"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DeletedAttachment.fromJSON)),
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

export namespace Document {

	export class ExtraMainAttachmentInfo {

		compressionAlgorithm: string | undefined = undefined;

		triedCompressionAlgorithmsVersion: string | undefined = undefined;

		realDataSize: number | undefined = undefined;

		constructor(partial: Partial<ExtraMainAttachmentInfo>) {
			if ('compressionAlgorithm' in partial) this.compressionAlgorithm = partial.compressionAlgorithm;
			if ('triedCompressionAlgorithmsVersion' in partial) this.triedCompressionAlgorithmsVersion = partial.triedCompressionAlgorithmsVersion;
			if ('realDataSize' in partial) this.realDataSize = partial.realDataSize;
		}

		toJSON(): object {
			const res: { [k: string]: any } = {}
			if (this.compressionAlgorithm != undefined) res['compressionAlgorithm'] = this.compressionAlgorithm
			if (this.triedCompressionAlgorithmsVersion != undefined) res['triedCompressionAlgorithmsVersion'] = this.triedCompressionAlgorithmsVersion
			if (this.realDataSize != undefined) res['realDataSize'] = this.realDataSize
			return res
		}

		static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
				path: Array<string> = ['ExtraMainAttachmentInfo']): ExtraMainAttachmentInfo {
			if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
			const jCpy = { ...json }
			const res = new ExtraMainAttachmentInfo({
				compressionAlgorithm: expectString(extractEntry(jCpy, 'compressionAlgorithm', false, path), true, [...path, ".compressionAlgorithm"]),
				triedCompressionAlgorithmsVersion: expectString(extractEntry(jCpy, 'triedCompressionAlgorithmsVersion', false, path), true, [...path, ".triedCompressionAlgorithmsVersion"]),
				realDataSize: expectNumber(extractEntry(jCpy, 'realDataSize', false, path), true, true, [...path, ".realDataSize"]),
			})
			if (!ignoreUnknownKeys) {
				const unused = Object.keys(jCpy)
				if (unused.length > 0) throw new Error(`Unexpected key(s) for json object ExtraMainAttachmentInfo at path ${path.join("")}: ${unused}`)}
			return res
		}

	}

}
