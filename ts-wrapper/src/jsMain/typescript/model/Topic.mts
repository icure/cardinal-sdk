// auto-generated file
import {expectArray, expectMap, expectNumber, expectObject, expectString, expectStringEnum, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {TopicRole} from './TopicRole.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {Delegation} from './embed/Delegation.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';
import {Base64String} from './specializations/Base64String.mjs';


/**
 *
 *  Represents a topic for secure messaging between healthcare parties. A topic groups messages in a
 *  conversation
 *  and can be linked to health elements and services for medical context.
 *  /
 */
export interface Topic extends StoredDocument, ICureDocument<string>, HasEncryptionMetadata, Encryptable {

	/**
	 *
	 *  The id of the health element linked to this topic.
	 */
	healthElementId: string | undefined;

	/**
	 *
	 *  The id of the contact linked to this topic.
	 */
	contactId: string | undefined;

	/**
	 *
	 *  A description of the topic.
	 */
	description: string | undefined;

	/**
	 *
	 *  Map of active participants with their roles (participant, admin, or owner).
	 */
	activeParticipants: { [ key: string ]: TopicRole };

	/**
	 *
	 *  Set of ids of health elements linked to this topic.
	 */
	linkedHealthElements: Array<string>;

	/**
	 *
	 *  Set of ids of services linked to this topic.
	 */
	linkedServices: Array<string>;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

/**
 *
 *  Represents a topic for secure messaging between healthcare parties. A topic groups messages in a
 *  conversation
 *  and can be linked to health elements and services for medical context.
 *  /
 */
export class DecryptedTopic {

	/**
	 *
	 *  The unique identifier of the topic.
	 */
	id: string;

	/**
	 *
	 *  The revision of the topic in the database, used for conflict management / optimistic locking.
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
	 *  The id of the health element linked to this topic.
	 */
	healthElementId: string | undefined = undefined;

	/**
	 *
	 *  The id of the contact linked to this topic.
	 */
	contactId: string | undefined = undefined;

	/**
	 *
	 *  A description of the topic.
	 */
	description: string | undefined = undefined;

	/**
	 *
	 *  Codes that identify or qualify this particular topic.
	 */
	codes: Array<CodeStub> = [];

	/**
	 *
	 *  Tags that qualify the topic as being member of a certain class.
	 */
	tags: Array<CodeStub> = [];

	/**
	 *
	 *  The id of the User that created this topic.
	 */
	author: string | undefined = undefined;

	/**
	 *
	 *  The id of the HealthcareParty that is responsible for this topic.
	 */
	responsible: string | undefined = undefined;

	/**
	 *
	 *  Hard delete (unix epoch in ms) timestamp of the object.
	 */
	deletionDate: number | undefined = undefined;

	/**
	 *
	 *  Map of active participants with their roles (participant, admin, or owner).
	 */
	activeParticipants: { [ key: string ]: TopicRole } = {};

	/**
	 *
	 *  The security metadata of the entity.
	 */
	securityMetadata: SecurityMetadata | undefined = undefined;

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
	 *  Set of ids of health elements linked to this topic.
	 */
	linkedHealthElements: Array<string> = [];

	/**
	 *
	 *  Set of ids of services linked to this topic.
	 */
	linkedServices: Array<string> = [];

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedTopic>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('healthElementId' in partial) this.healthElementId = partial.healthElementId;
		if ('contactId' in partial) this.contactId = partial.contactId;
		if ('description' in partial) this.description = partial.description;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('activeParticipants' in partial && partial.activeParticipants !== undefined) this.activeParticipants = partial.activeParticipants;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
		if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
		if ('linkedHealthElements' in partial && partial.linkedHealthElements !== undefined) this.linkedHealthElements = partial.linkedHealthElements;
		if ('linkedServices' in partial && partial.linkedServices !== undefined) this.linkedServices = partial.linkedServices;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.healthElementId != undefined) res['healthElementId'] = this.healthElementId
		if (this.contactId != undefined) res['contactId'] = this.contactId
		if (this.description != undefined) res['description'] = this.description
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		res['activeParticipants'] = Object.fromEntries(Object.entries(this.activeParticipants).map(([k0, v0]) => [k0, v0]))
		if (this.securityMetadata != undefined) res['securityMetadata'] = this.securityMetadata.toJSON()
		res['secretForeignKeys'] = this.secretForeignKeys.map((x0) => x0 )
		res['cryptedForeignKeys'] = Object.fromEntries(Object.entries(this.cryptedForeignKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['delegations'] = Object.fromEntries(Object.entries(this.delegations).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['encryptionKeys'] = Object.fromEntries(Object.entries(this.encryptionKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['linkedHealthElements'] = this.linkedHealthElements.map((x0) => x0 )
		res['linkedServices'] = this.linkedServices.map((x0) => x0 )
		res['isEncrypted'] = false
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedTopic']): DecryptedTopic {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedTopic`)
		const res = new DecryptedTopic({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			healthElementId: expectString(extractEntry(jCpy, 'healthElementId', false, path), true, [...path, ".healthElementId"]),
			contactId: expectString(extractEntry(jCpy, 'contactId', false, path), true, [...path, ".contactId"]),
			description: expectString(extractEntry(jCpy, 'description', false, path), true, [...path, ".description"]),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			activeParticipants: expectMap(
				extractEntry(jCpy, 'activeParticipants', false, path),
				false,
				[...path, ".activeParticipants"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectStringEnum(v0, false, p0, TopicRole, 'TopicRole')
			),
			securityMetadata: expectObject(extractEntry(jCpy, 'securityMetadata', false, path), true, ignoreUnknownKeys, [...path, ".securityMetadata"], SecurityMetadata.fromJSON),
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
			linkedHealthElements: expectArray(extractEntry(jCpy, 'linkedHealthElements', false, path), false, [...path, ".linkedHealthElements"], (x0, p0) => expectString(x0, false, p0)),
			linkedServices: expectArray(extractEntry(jCpy, 'linkedServices', false, path), false, [...path, ".linkedServices"], (x0, p0) => expectString(x0, false, p0)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedTopic at path ${path.join("")}: ${unused}`)}
		return res
	}

}

/**
 *
 *  Represents a topic for secure messaging between healthcare parties. A topic groups messages in a
 *  conversation
 *  and can be linked to health elements and services for medical context.
 *  /
 */
export class EncryptedTopic {

	/**
	 *
	 *  The unique identifier of the topic.
	 */
	id: string;

	/**
	 *
	 *  The revision of the topic in the database, used for conflict management / optimistic locking.
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
	 *  The id of the health element linked to this topic.
	 */
	healthElementId: string | undefined = undefined;

	/**
	 *
	 *  The id of the contact linked to this topic.
	 */
	contactId: string | undefined = undefined;

	/**
	 *
	 *  A description of the topic.
	 */
	description: string | undefined = undefined;

	/**
	 *
	 *  Codes that identify or qualify this particular topic.
	 */
	codes: Array<CodeStub> = [];

	/**
	 *
	 *  Tags that qualify the topic as being member of a certain class.
	 */
	tags: Array<CodeStub> = [];

	/**
	 *
	 *  The id of the User that created this topic.
	 */
	author: string | undefined = undefined;

	/**
	 *
	 *  The id of the HealthcareParty that is responsible for this topic.
	 */
	responsible: string | undefined = undefined;

	/**
	 *
	 *  Hard delete (unix epoch in ms) timestamp of the object.
	 */
	deletionDate: number | undefined = undefined;

	/**
	 *
	 *  Map of active participants with their roles (participant, admin, or owner).
	 */
	activeParticipants: { [ key: string ]: TopicRole } = {};

	/**
	 *
	 *  The security metadata of the entity.
	 */
	securityMetadata: SecurityMetadata | undefined = undefined;

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
	 *  Set of ids of health elements linked to this topic.
	 */
	linkedHealthElements: Array<string> = [];

	/**
	 *
	 *  Set of ids of services linked to this topic.
	 */
	linkedServices: Array<string> = [];

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedTopic>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('healthElementId' in partial) this.healthElementId = partial.healthElementId;
		if ('contactId' in partial) this.contactId = partial.contactId;
		if ('description' in partial) this.description = partial.description;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('activeParticipants' in partial && partial.activeParticipants !== undefined) this.activeParticipants = partial.activeParticipants;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
		if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
		if ('linkedHealthElements' in partial && partial.linkedHealthElements !== undefined) this.linkedHealthElements = partial.linkedHealthElements;
		if ('linkedServices' in partial && partial.linkedServices !== undefined) this.linkedServices = partial.linkedServices;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.healthElementId != undefined) res['healthElementId'] = this.healthElementId
		if (this.contactId != undefined) res['contactId'] = this.contactId
		if (this.description != undefined) res['description'] = this.description
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		res['activeParticipants'] = Object.fromEntries(Object.entries(this.activeParticipants).map(([k0, v0]) => [k0, v0]))
		if (this.securityMetadata != undefined) res['securityMetadata'] = this.securityMetadata.toJSON()
		res['secretForeignKeys'] = this.secretForeignKeys.map((x0) => x0 )
		res['cryptedForeignKeys'] = Object.fromEntries(Object.entries(this.cryptedForeignKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['delegations'] = Object.fromEntries(Object.entries(this.delegations).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['encryptionKeys'] = Object.fromEntries(Object.entries(this.encryptionKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['linkedHealthElements'] = this.linkedHealthElements.map((x0) => x0 )
		res['linkedServices'] = this.linkedServices.map((x0) => x0 )
		res['isEncrypted'] = true
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedTopic']): EncryptedTopic {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedTopic`)
		const res = new EncryptedTopic({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			healthElementId: expectString(extractEntry(jCpy, 'healthElementId', false, path), true, [...path, ".healthElementId"]),
			contactId: expectString(extractEntry(jCpy, 'contactId', false, path), true, [...path, ".contactId"]),
			description: expectString(extractEntry(jCpy, 'description', false, path), true, [...path, ".description"]),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			activeParticipants: expectMap(
				extractEntry(jCpy, 'activeParticipants', false, path),
				false,
				[...path, ".activeParticipants"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectStringEnum(v0, false, p0, TopicRole, 'TopicRole')
			),
			securityMetadata: expectObject(extractEntry(jCpy, 'securityMetadata', false, path), true, ignoreUnknownKeys, [...path, ".securityMetadata"], SecurityMetadata.fromJSON),
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
			linkedHealthElements: expectArray(extractEntry(jCpy, 'linkedHealthElements', false, path), false, [...path, ".linkedHealthElements"], (x0, p0) => expectString(x0, false, p0)),
			linkedServices: expectArray(extractEntry(jCpy, 'linkedServices', false, path), false, [...path, ".linkedServices"], (x0, p0) => expectString(x0, false, p0)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedTopic at path ${path.join("")}: ${unused}`)}
		return res
	}

}
