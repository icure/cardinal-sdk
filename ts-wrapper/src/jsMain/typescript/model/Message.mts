// auto-generated file
import {expectArray, expectMap, expectNumber, expectObject, expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {DecryptedPropertyStub, EncryptedPropertyStub, PropertyStub} from './PropertyStub.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {Delegation} from './embed/Delegation.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {MessageReadStatus} from './embed/MessageReadStatus.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';
import {Base64String} from './specializations/Base64String.mjs';


/**
 *
 *  Represents a message exchanged between healthcare parties. Messages can be used for internal
 *  communication,
 *  eHealth box messages, eFact batches, and other types of healthcare-related communications.
 *  /
 */
export interface Message extends StoredDocument, ICureDocument<string>, HasEncryptionMetadata, Encryptable {

	/**
	 *
	 *  Address of the sender of the message.
	 */
	fromAddress: string | undefined;

	/**
	 *
	 *  ID of the healthcare party sending the message.
	 */
	fromHealthcarePartyId: string | undefined;

	/**
	 *
	 *  List of IDs of healthcare parties to whom the message is addressed.
	 */
	recipients: Array<string>;

	/**
	 *
	 *  The addresses of the recipients of the message.
	 */
	toAddresses: Array<string>;

	/**
	 *
	 *  The timestamp (unix epoch in ms) when the message was received.
	 */
	received: number | undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) when the message was sent.
	 */
	sent: number | undefined;

	/**
	 *
	 *  Additional metadata for the message.
	 */
	metas: { [ key: string ]: string };

	/**
	 *
	 *  Status showing whether the message is read or not and the time of reading.
	 */
	readStatus: { [ key: string ]: MessageReadStatus };

	/**
	 *
	 *  Transport-level identifier for the message, format depends on the transport type.
	 */
	transportGuid: string | undefined;

	/**
	 *
	 *  An additional remark on the message.
	 */
	remark: string | undefined;

	/**
	 *
	 *  The guid of the conversation this message belongs to.
	 */
	conversationGuid: string | undefined;

	/**
	 *
	 *  Subject for the message.
	 */
	subject: string | undefined;

	/**
	 *
	 *  Set of IDs for invoices in the message.
	 */
	invoiceIds: Array<string>;

	/**
	 *
	 *  ID of a parent in a message conversation.
	 */
	parentId: string | undefined;

	/**
	 *
	 *  Extra properties for the message.
	 */
	properties: Array<PropertyStub>;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

/**
 *
 *  Represents a message exchanged between healthcare parties. Messages can be used for internal
 *  communication,
 *  eHealth box messages, eFact batches, and other types of healthcare-related communications.
 *  /
 */
export class DecryptedMessage {

	/**
	 *
	 *  The ID of the message. We encourage using either a v4 UUID or a HL7 Id.
	 */
	id: string;

	/**
	 *
	 *  The revision of the message in the database, used for conflict management / optimistic locking.
	 */
	rev: string | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) of creation.
	 */
	created: number | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) of the latest modification.
	 */
	modified: number | undefined = undefined;

	/**
	 *
	 *  The id of the User that created this message.
	 */
	author: string | undefined = undefined;

	/**
	 *
	 *  The id of the HealthcareParty that is responsible for this message.
	 */
	responsible: string | undefined = undefined;

	/**
	 *
	 *  Tags that qualify the message as being member of a certain class.
	 */
	tags: Array<CodeStub> = [];

	/**
	 *
	 *  Codes that identify or qualify this particular message.
	 */
	codes: Array<CodeStub> = [];

	/**
	 *
	 *  Hard delete (unix epoch in ms) timestamp of the object.
	 */
	deletionDate: number | undefined = undefined;

	/**
	 *
	 *  Address of the sender of the message.
	 */
	fromAddress: string | undefined = undefined;

	/**
	 *
	 *  ID of the healthcare party sending the message.
	 */
	fromHealthcarePartyId: string | undefined = undefined;

	/**
	 *
	 *  List of IDs of healthcare parties to whom the message is addressed.
	 */
	recipients: Array<string> = [];

	/**
	 *
	 *  The addresses of the recipients of the message.
	 */
	toAddresses: Array<string> = [];

	/**
	 *
	 *  The timestamp (unix epoch in ms) when the message was received.
	 */
	received: number | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) when the message was sent.
	 */
	sent: number | undefined = undefined;

	/**
	 *
	 *  Additional metadata for the message.
	 */
	metas: { [ key: string ]: string } = {};

	/**
	 *
	 *  Status showing whether the message is read or not and the time of reading.
	 */
	readStatus: { [ key: string ]: MessageReadStatus } = {};

	/**
	 *
	 *  Transport-level identifier for the message, format depends on the transport type.
	 */
	transportGuid: string | undefined = undefined;

	/**
	 *
	 *  An additional remark on the message.
	 */
	remark: string | undefined = undefined;

	/**
	 *
	 *  The guid of the conversation this message belongs to.
	 */
	conversationGuid: string | undefined = undefined;

	/**
	 *
	 *  Subject for the message.
	 */
	subject: string | undefined = undefined;

	/**
	 *
	 *  Set of IDs for invoices in the message.
	 */
	invoiceIds: Array<string> = [];

	/**
	 *
	 *  ID of a parent in a message conversation.
	 */
	parentId: string | undefined = undefined;

	/**
	 *
	 *  Extra properties for the message.
	 */
	properties: Array<DecryptedPropertyStub> = [];

	/**
	 *
	 *  The secret patient key, encrypted in the patient's own AES key.
	 */
	secretForeignKeys: Array<string> = [];

	/**
	 *
	 *  The patient id encrypted in the delegates' AES keys.
	 */
	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The delegations giving access to connected healthcare information.
	 */
	delegations: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The keys used to encrypt this entity when stored encrypted.
	 */
	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The base64-encoded encrypted fields of this entity.
	 */
	encryptedSelf: Base64String | undefined = undefined;

	/**
	 *
	 *  The security metadata of the entity.
	 */
	securityMetadata: SecurityMetadata | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedMessage>) {
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
		if ('fromAddress' in partial) this.fromAddress = partial.fromAddress;
		if ('fromHealthcarePartyId' in partial) this.fromHealthcarePartyId = partial.fromHealthcarePartyId;
		if ('recipients' in partial && partial.recipients !== undefined) this.recipients = partial.recipients;
		if ('toAddresses' in partial && partial.toAddresses !== undefined) this.toAddresses = partial.toAddresses;
		if ('received' in partial) this.received = partial.received;
		if ('sent' in partial) this.sent = partial.sent;
		if ('metas' in partial && partial.metas !== undefined) this.metas = partial.metas;
		if ('readStatus' in partial && partial.readStatus !== undefined) this.readStatus = partial.readStatus;
		if ('transportGuid' in partial) this.transportGuid = partial.transportGuid;
		if ('remark' in partial) this.remark = partial.remark;
		if ('conversationGuid' in partial) this.conversationGuid = partial.conversationGuid;
		if ('subject' in partial) this.subject = partial.subject;
		if ('invoiceIds' in partial && partial.invoiceIds !== undefined) this.invoiceIds = partial.invoiceIds;
		if ('parentId' in partial) this.parentId = partial.parentId;
		if ('properties' in partial && partial.properties !== undefined) this.properties = partial.properties;
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
		if (this.fromAddress != undefined) res['fromAddress'] = this.fromAddress
		if (this.fromHealthcarePartyId != undefined) res['fromHealthcarePartyId'] = this.fromHealthcarePartyId
		res['recipients'] = this.recipients.map((x0) => x0 )
		res['toAddresses'] = this.toAddresses.map((x0) => x0 )
		if (this.received != undefined) res['received'] = this.received
		if (this.sent != undefined) res['sent'] = this.sent
		res['metas'] = Object.fromEntries(Object.entries(this.metas).map(([k0, v0]) => [k0, v0]))
		res['readStatus'] = Object.fromEntries(Object.entries(this.readStatus).map(([k0, v0]) => [k0, v0.toJSON()]))
		if (this.transportGuid != undefined) res['transportGuid'] = this.transportGuid
		if (this.remark != undefined) res['remark'] = this.remark
		if (this.conversationGuid != undefined) res['conversationGuid'] = this.conversationGuid
		if (this.subject != undefined) res['subject'] = this.subject
		res['invoiceIds'] = this.invoiceIds.map((x0) => x0 )
		if (this.parentId != undefined) res['parentId'] = this.parentId
		res['properties'] = this.properties.map((x0) => x0.toJSON() )
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
			path: Array<string> = ['DecryptedMessage']): DecryptedMessage {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedMessage`)
		const res = new DecryptedMessage({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			fromAddress: expectString(extractEntry(jCpy, 'fromAddress', false, path), true, [...path, ".fromAddress"]),
			fromHealthcarePartyId: expectString(extractEntry(jCpy, 'fromHealthcarePartyId', false, path), true, [...path, ".fromHealthcarePartyId"]),
			recipients: expectArray(extractEntry(jCpy, 'recipients', false, path), false, [...path, ".recipients"], (x0, p0) => expectString(x0, false, p0)),
			toAddresses: expectArray(extractEntry(jCpy, 'toAddresses', false, path), false, [...path, ".toAddresses"], (x0, p0) => expectString(x0, false, p0)),
			received: expectNumber(extractEntry(jCpy, 'received', false, path), true, true, [...path, ".received"]),
			sent: expectNumber(extractEntry(jCpy, 'sent', false, path), true, true, [...path, ".sent"]),
			metas: expectMap(
				extractEntry(jCpy, 'metas', false, path),
				false,
				[...path, ".metas"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			readStatus: expectMap(
				extractEntry(jCpy, 'readStatus', false, path),
				false,
				[...path, ".readStatus"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectObject(v0, false, ignoreUnknownKeys, p0, MessageReadStatus.fromJSON)
			),
			transportGuid: expectString(extractEntry(jCpy, 'transportGuid', false, path), true, [...path, ".transportGuid"]),
			remark: expectString(extractEntry(jCpy, 'remark', false, path), true, [...path, ".remark"]),
			conversationGuid: expectString(extractEntry(jCpy, 'conversationGuid', false, path), true, [...path, ".conversationGuid"]),
			subject: expectString(extractEntry(jCpy, 'subject', false, path), true, [...path, ".subject"]),
			invoiceIds: expectArray(extractEntry(jCpy, 'invoiceIds', false, path), false, [...path, ".invoiceIds"], (x0, p0) => expectString(x0, false, p0)),
			parentId: expectString(extractEntry(jCpy, 'parentId', false, path), true, [...path, ".parentId"]),
			properties: expectArray(extractEntry(jCpy, 'properties', false, path), false, [...path, ".properties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedPropertyStub.fromJSON)),
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
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedMessage at path ${path.join("")}: ${unused}`)}
		return res
	}

}

/**
 *
 *  Represents a message exchanged between healthcare parties. Messages can be used for internal
 *  communication,
 *  eHealth box messages, eFact batches, and other types of healthcare-related communications.
 *  /
 */
export class EncryptedMessage {

	/**
	 *
	 *  The ID of the message. We encourage using either a v4 UUID or a HL7 Id.
	 */
	id: string;

	/**
	 *
	 *  The revision of the message in the database, used for conflict management / optimistic locking.
	 */
	rev: string | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) of creation.
	 */
	created: number | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) of the latest modification.
	 */
	modified: number | undefined = undefined;

	/**
	 *
	 *  The id of the User that created this message.
	 */
	author: string | undefined = undefined;

	/**
	 *
	 *  The id of the HealthcareParty that is responsible for this message.
	 */
	responsible: string | undefined = undefined;

	/**
	 *
	 *  Tags that qualify the message as being member of a certain class.
	 */
	tags: Array<CodeStub> = [];

	/**
	 *
	 *  Codes that identify or qualify this particular message.
	 */
	codes: Array<CodeStub> = [];

	/**
	 *
	 *  Hard delete (unix epoch in ms) timestamp of the object.
	 */
	deletionDate: number | undefined = undefined;

	/**
	 *
	 *  Address of the sender of the message.
	 */
	fromAddress: string | undefined = undefined;

	/**
	 *
	 *  ID of the healthcare party sending the message.
	 */
	fromHealthcarePartyId: string | undefined = undefined;

	/**
	 *
	 *  List of IDs of healthcare parties to whom the message is addressed.
	 */
	recipients: Array<string> = [];

	/**
	 *
	 *  The addresses of the recipients of the message.
	 */
	toAddresses: Array<string> = [];

	/**
	 *
	 *  The timestamp (unix epoch in ms) when the message was received.
	 */
	received: number | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) when the message was sent.
	 */
	sent: number | undefined = undefined;

	/**
	 *
	 *  Additional metadata for the message.
	 */
	metas: { [ key: string ]: string } = {};

	/**
	 *
	 *  Status showing whether the message is read or not and the time of reading.
	 */
	readStatus: { [ key: string ]: MessageReadStatus } = {};

	/**
	 *
	 *  Transport-level identifier for the message, format depends on the transport type.
	 */
	transportGuid: string | undefined = undefined;

	/**
	 *
	 *  An additional remark on the message.
	 */
	remark: string | undefined = undefined;

	/**
	 *
	 *  The guid of the conversation this message belongs to.
	 */
	conversationGuid: string | undefined = undefined;

	/**
	 *
	 *  Subject for the message.
	 */
	subject: string | undefined = undefined;

	/**
	 *
	 *  Set of IDs for invoices in the message.
	 */
	invoiceIds: Array<string> = [];

	/**
	 *
	 *  ID of a parent in a message conversation.
	 */
	parentId: string | undefined = undefined;

	/**
	 *
	 *  Extra properties for the message.
	 */
	properties: Array<EncryptedPropertyStub> = [];

	/**
	 *
	 *  The secret patient key, encrypted in the patient's own AES key.
	 */
	secretForeignKeys: Array<string> = [];

	/**
	 *
	 *  The patient id encrypted in the delegates' AES keys.
	 */
	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The delegations giving access to connected healthcare information.
	 */
	delegations: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The keys used to encrypt this entity when stored encrypted.
	 */
	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The base64-encoded encrypted fields of this entity.
	 */
	encryptedSelf: Base64String | undefined = undefined;

	/**
	 *
	 *  The security metadata of the entity.
	 */
	securityMetadata: SecurityMetadata | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedMessage>) {
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
		if ('fromAddress' in partial) this.fromAddress = partial.fromAddress;
		if ('fromHealthcarePartyId' in partial) this.fromHealthcarePartyId = partial.fromHealthcarePartyId;
		if ('recipients' in partial && partial.recipients !== undefined) this.recipients = partial.recipients;
		if ('toAddresses' in partial && partial.toAddresses !== undefined) this.toAddresses = partial.toAddresses;
		if ('received' in partial) this.received = partial.received;
		if ('sent' in partial) this.sent = partial.sent;
		if ('metas' in partial && partial.metas !== undefined) this.metas = partial.metas;
		if ('readStatus' in partial && partial.readStatus !== undefined) this.readStatus = partial.readStatus;
		if ('transportGuid' in partial) this.transportGuid = partial.transportGuid;
		if ('remark' in partial) this.remark = partial.remark;
		if ('conversationGuid' in partial) this.conversationGuid = partial.conversationGuid;
		if ('subject' in partial) this.subject = partial.subject;
		if ('invoiceIds' in partial && partial.invoiceIds !== undefined) this.invoiceIds = partial.invoiceIds;
		if ('parentId' in partial) this.parentId = partial.parentId;
		if ('properties' in partial && partial.properties !== undefined) this.properties = partial.properties;
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
		if (this.fromAddress != undefined) res['fromAddress'] = this.fromAddress
		if (this.fromHealthcarePartyId != undefined) res['fromHealthcarePartyId'] = this.fromHealthcarePartyId
		res['recipients'] = this.recipients.map((x0) => x0 )
		res['toAddresses'] = this.toAddresses.map((x0) => x0 )
		if (this.received != undefined) res['received'] = this.received
		if (this.sent != undefined) res['sent'] = this.sent
		res['metas'] = Object.fromEntries(Object.entries(this.metas).map(([k0, v0]) => [k0, v0]))
		res['readStatus'] = Object.fromEntries(Object.entries(this.readStatus).map(([k0, v0]) => [k0, v0.toJSON()]))
		if (this.transportGuid != undefined) res['transportGuid'] = this.transportGuid
		if (this.remark != undefined) res['remark'] = this.remark
		if (this.conversationGuid != undefined) res['conversationGuid'] = this.conversationGuid
		if (this.subject != undefined) res['subject'] = this.subject
		res['invoiceIds'] = this.invoiceIds.map((x0) => x0 )
		if (this.parentId != undefined) res['parentId'] = this.parentId
		res['properties'] = this.properties.map((x0) => x0.toJSON() )
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
			path: Array<string> = ['EncryptedMessage']): EncryptedMessage {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedMessage`)
		const res = new EncryptedMessage({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			fromAddress: expectString(extractEntry(jCpy, 'fromAddress', false, path), true, [...path, ".fromAddress"]),
			fromHealthcarePartyId: expectString(extractEntry(jCpy, 'fromHealthcarePartyId', false, path), true, [...path, ".fromHealthcarePartyId"]),
			recipients: expectArray(extractEntry(jCpy, 'recipients', false, path), false, [...path, ".recipients"], (x0, p0) => expectString(x0, false, p0)),
			toAddresses: expectArray(extractEntry(jCpy, 'toAddresses', false, path), false, [...path, ".toAddresses"], (x0, p0) => expectString(x0, false, p0)),
			received: expectNumber(extractEntry(jCpy, 'received', false, path), true, true, [...path, ".received"]),
			sent: expectNumber(extractEntry(jCpy, 'sent', false, path), true, true, [...path, ".sent"]),
			metas: expectMap(
				extractEntry(jCpy, 'metas', false, path),
				false,
				[...path, ".metas"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			readStatus: expectMap(
				extractEntry(jCpy, 'readStatus', false, path),
				false,
				[...path, ".readStatus"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectObject(v0, false, ignoreUnknownKeys, p0, MessageReadStatus.fromJSON)
			),
			transportGuid: expectString(extractEntry(jCpy, 'transportGuid', false, path), true, [...path, ".transportGuid"]),
			remark: expectString(extractEntry(jCpy, 'remark', false, path), true, [...path, ".remark"]),
			conversationGuid: expectString(extractEntry(jCpy, 'conversationGuid', false, path), true, [...path, ".conversationGuid"]),
			subject: expectString(extractEntry(jCpy, 'subject', false, path), true, [...path, ".subject"]),
			invoiceIds: expectArray(extractEntry(jCpy, 'invoiceIds', false, path), false, [...path, ".invoiceIds"], (x0, p0) => expectString(x0, false, p0)),
			parentId: expectString(extractEntry(jCpy, 'parentId', false, path), true, [...path, ".parentId"]),
			properties: expectArray(extractEntry(jCpy, 'properties', false, path), false, [...path, ".properties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, EncryptedPropertyStub.fromJSON)),
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
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedMessage at path ${path.join("")}: ${unused}`)}
		return res
	}

}
