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


export interface Topic extends StoredDocument, ICureDocument<string>, HasEncryptionMetadata, Encryptable {

	healthElementId: string | undefined;

	contactId: string | undefined;

	description: string | undefined;

	activeParticipants: { [ key: string ]: TopicRole };

	linkedHealthElements: Array<string>;

	linkedServices: Array<string>;

	readonly isEncrypted: boolean;

}

export class DecryptedTopic {

	id: string;

	rev: string | undefined = undefined;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	healthElementId: string | undefined = undefined;

	contactId: string | undefined = undefined;

	description: string | undefined = undefined;

	codes: Array<CodeStub> = [];

	tags: Array<CodeStub> = [];

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	medicalLocationId: string | undefined = undefined;

	endOfLife: number | undefined = undefined;

	deletionDate: number | undefined = undefined;

	activeParticipants: { [ key: string ]: TopicRole } = {};

	securityMetadata: SecurityMetadata | undefined = undefined;

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

	linkedHealthElements: Array<string> = [];

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
		if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
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

	toJSON(): any {
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
		if (this.medicalLocationId != undefined) res['medicalLocationId'] = this.medicalLocationId
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
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
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedTopic']): DecryptedTopic {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new DecryptedTopic({
			id: expectString(extractEntry(jCpy.id, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy.rev, 'rev', false, path), true, [...path, ".rev"]),
			created: expectNumber(extractEntry(jCpy.created, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy.modified, 'modified', false, path), true, true, [...path, ".modified"]),
			healthElementId: expectString(extractEntry(jCpy.healthElementId, 'healthElementId', false, path), true, [...path, ".healthElementId"]),
			contactId: expectString(extractEntry(jCpy.contactId, 'contactId', false, path), true, [...path, ".contactId"]),
			description: expectString(extractEntry(jCpy.description, 'description', false, path), true, [...path, ".description"]),
			codes: expectArray(extractEntry(jCpy.codes, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			tags: expectArray(extractEntry(jCpy.tags, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			author: expectString(extractEntry(jCpy.author, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy.responsible, 'responsible', false, path), true, [...path, ".responsible"]),
			medicalLocationId: expectString(extractEntry(jCpy.medicalLocationId, 'medicalLocationId', false, path), true, [...path, ".medicalLocationId"]),
			endOfLife: expectNumber(extractEntry(jCpy.endOfLife, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(extractEntry(jCpy.deletionDate, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			activeParticipants: expectMap(
				extractEntry(jCpy.activeParticipants, 'activeParticipants', false, path),
				false,
				[...path, ".activeParticipants"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectStringEnum(v0, false, p0, TopicRole, 'TopicRole')
			),
			securityMetadata: expectObject(extractEntry(jCpy.securityMetadata, 'securityMetadata', false, path), true, ignoreUnknownKeys, [...path, ".securityMetadata"], SecurityMetadata.fromJSON),
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
			linkedHealthElements: expectArray(extractEntry(jCpy.linkedHealthElements, 'linkedHealthElements', false, path), false, [...path, ".linkedHealthElements"], (x0, p0) => expectString(x0, false, p0)),
			linkedServices: expectArray(extractEntry(jCpy.linkedServices, 'linkedServices', false, path), false, [...path, ".linkedServices"], (x0, p0) => expectString(x0, false, p0)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedTopic at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export class EncryptedTopic {

	id: string;

	rev: string | undefined = undefined;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	healthElementId: string | undefined = undefined;

	contactId: string | undefined = undefined;

	description: string | undefined = undefined;

	codes: Array<CodeStub> = [];

	tags: Array<CodeStub> = [];

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	medicalLocationId: string | undefined = undefined;

	endOfLife: number | undefined = undefined;

	deletionDate: number | undefined = undefined;

	activeParticipants: { [ key: string ]: TopicRole } = {};

	securityMetadata: SecurityMetadata | undefined = undefined;

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

	linkedHealthElements: Array<string> = [];

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
		if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
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

	toJSON(): any {
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
		if (this.medicalLocationId != undefined) res['medicalLocationId'] = this.medicalLocationId
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
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
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedTopic']): EncryptedTopic {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new EncryptedTopic({
			id: expectString(extractEntry(jCpy.id, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy.rev, 'rev', false, path), true, [...path, ".rev"]),
			created: expectNumber(extractEntry(jCpy.created, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy.modified, 'modified', false, path), true, true, [...path, ".modified"]),
			healthElementId: expectString(extractEntry(jCpy.healthElementId, 'healthElementId', false, path), true, [...path, ".healthElementId"]),
			contactId: expectString(extractEntry(jCpy.contactId, 'contactId', false, path), true, [...path, ".contactId"]),
			description: expectString(extractEntry(jCpy.description, 'description', false, path), true, [...path, ".description"]),
			codes: expectArray(extractEntry(jCpy.codes, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			tags: expectArray(extractEntry(jCpy.tags, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			author: expectString(extractEntry(jCpy.author, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy.responsible, 'responsible', false, path), true, [...path, ".responsible"]),
			medicalLocationId: expectString(extractEntry(jCpy.medicalLocationId, 'medicalLocationId', false, path), true, [...path, ".medicalLocationId"]),
			endOfLife: expectNumber(extractEntry(jCpy.endOfLife, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(extractEntry(jCpy.deletionDate, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			activeParticipants: expectMap(
				extractEntry(jCpy.activeParticipants, 'activeParticipants', false, path),
				false,
				[...path, ".activeParticipants"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectStringEnum(v0, false, p0, TopicRole, 'TopicRole')
			),
			securityMetadata: expectObject(extractEntry(jCpy.securityMetadata, 'securityMetadata', false, path), true, ignoreUnknownKeys, [...path, ".securityMetadata"], SecurityMetadata.fromJSON),
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
			linkedHealthElements: expectArray(extractEntry(jCpy.linkedHealthElements, 'linkedHealthElements', false, path), false, [...path, ".linkedHealthElements"], (x0, p0) => expectString(x0, false, p0)),
			linkedServices: expectArray(extractEntry(jCpy.linkedServices, 'linkedServices', false, path), false, [...path, ".linkedServices"], (x0, p0) => expectString(x0, false, p0)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedTopic at path ${path.join("")}: ${unused}`)}
		return res
	}

}
