// auto-generated file
import {expectArray, expectMap, expectNumber, expectString, expectStringEnum, requireEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {Identifier} from './base/Identifier.mjs';
import {ParticipantType} from './base/ParticipantType.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {Address, DecryptedAddress, EncryptedAddress} from './embed/Address.mjs';
import {Annotation} from './embed/Annotation.mjs';
import {Delegation} from './embed/Delegation.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';
import {DecryptedService, EncryptedService, Service} from './embed/Service.mjs';
import {DecryptedSubContact, EncryptedSubContact, SubContact} from './embed/SubContact.mjs';
import {Base64String} from './specializations/Base64String.mjs';


export interface Contact extends StoredDocument, ICureDocument<string>, HasEncryptionMetadata, Encryptable {

	identifier: Array<Identifier>;

	groupId: string | undefined;

	openingDate: number | undefined;

	closingDate: number | undefined;

	descr: string | undefined;

	location: string | undefined;

	externalId: string | undefined;

	encounterType: CodeStub | undefined;

	encounterLocation: Address | undefined;

	subContacts: Array<SubContact>;

	services: Array<Service>;

	participants: { [ key in ParticipantType ]?: string };

	healthcarePartyId: string | undefined;

	modifiedContactId: string | undefined;

	notes: Array<Annotation>;

	readonly isEncrypted: boolean;

}

export class DecryptedContact {

	id: string;

	rev: string | undefined = undefined;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	medicalLocationId: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	identifier: Array<Identifier> = [];

	endOfLife: number | undefined = undefined;

	deletionDate: number | undefined = undefined;

	groupId: string | undefined = undefined;

	openingDate: number | undefined = undefined;

	closingDate: number | undefined = undefined;

	descr: string | undefined = undefined;

	location: string | undefined = undefined;

	externalId: string | undefined = undefined;

	encounterType: CodeStub | undefined = undefined;

	encounterLocation: DecryptedAddress | undefined = undefined;

	subContacts: Array<DecryptedSubContact> = [];

	services: Array<DecryptedService> = [];

	participants: { [ key in ParticipantType ]?: string } = {};

	healthcarePartyId: string | undefined = undefined;

	modifiedContactId: string | undefined = undefined;

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

	securityMetadata: SecurityMetadata | undefined = undefined;

	notes: Array<Annotation> = [];

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedContact>) {
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
		if ('identifier' in partial && partial.identifier !== undefined) this.identifier = partial.identifier;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('groupId' in partial) this.groupId = partial.groupId;
		if ('openingDate' in partial) this.openingDate = partial.openingDate;
		if ('closingDate' in partial) this.closingDate = partial.closingDate;
		if ('descr' in partial) this.descr = partial.descr;
		if ('location' in partial) this.location = partial.location;
		if ('externalId' in partial) this.externalId = partial.externalId;
		if ('encounterType' in partial) this.encounterType = partial.encounterType;
		if ('encounterLocation' in partial) this.encounterLocation = partial.encounterLocation;
		if ('subContacts' in partial && partial.subContacts !== undefined) this.subContacts = partial.subContacts;
		if ('services' in partial && partial.services !== undefined) this.services = partial.services;
		if ('participants' in partial && partial.participants !== undefined) this.participants = partial.participants;
		if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
		if ('modifiedContactId' in partial) this.modifiedContactId = partial.modifiedContactId;
		if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
		if ('notes' in partial && partial.notes !== undefined) this.notes = partial.notes;
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
		res['identifier'] = this.identifier.map((x0) => x0.toJSON() )
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.groupId != undefined) res['groupId'] = this.groupId
		if (this.openingDate != undefined) res['openingDate'] = this.openingDate
		if (this.closingDate != undefined) res['closingDate'] = this.closingDate
		if (this.descr != undefined) res['descr'] = this.descr
		if (this.location != undefined) res['location'] = this.location
		if (this.externalId != undefined) res['externalId'] = this.externalId
		if (this.encounterType != undefined) res['encounterType'] = this.encounterType.toJSON()
		if (this.encounterLocation != undefined) res['encounterLocation'] = this.encounterLocation.toJSON()
		res['subContacts'] = this.subContacts.map((x0) => x0.toJSON() )
		res['services'] = this.services.map((x0) => x0.toJSON() )
		res['participants'] = Object.fromEntries(Object.entries(this.participants).map(([k0, v0]) => [k0, v0]))
		if (this.healthcarePartyId != undefined) res['healthcarePartyId'] = this.healthcarePartyId
		if (this.modifiedContactId != undefined) res['modifiedContactId'] = this.modifiedContactId
		res['secretForeignKeys'] = this.secretForeignKeys.map((x0) => x0 )
		res['cryptedForeignKeys'] = Object.fromEntries(Object.entries(this.cryptedForeignKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['delegations'] = Object.fromEntries(Object.entries(this.delegations).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['encryptionKeys'] = Object.fromEntries(Object.entries(this.encryptionKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		if (this.securityMetadata != undefined) res['securityMetadata'] = this.securityMetadata.toJSON()
		res['notes'] = this.notes.map((x0) => x0.toJSON() )
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['DecryptedContact']): DecryptedContact {
		return new DecryptedContact({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			rev: expectString(json.rev, true, [...path, ".rev"]),
			created: expectNumber(json.created, true, true, [...path, ".created"]),
			modified: expectNumber(json.modified, true, true, [...path, ".modified"]),
			author: expectString(json.author, true, [...path, ".author"]),
			responsible: expectString(json.responsible, true, [...path, ".responsible"]),
			medicalLocationId: expectString(json.medicalLocationId, true, [...path, ".medicalLocationId"]),
			tags: expectArray(json.tags, false, [...path, ".tags"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			codes: expectArray(json.codes, false, [...path, ".codes"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			identifier: expectArray(json.identifier, false, [...path, ".identifier"], (x0, p0) => Identifier.fromJSON(x0, p0)),
			endOfLife: expectNumber(json.endOfLife, true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(json.deletionDate, true, true, [...path, ".deletionDate"]),
			groupId: expectString(json.groupId, true, [...path, ".groupId"]),
			openingDate: expectNumber(json.openingDate, true, true, [...path, ".openingDate"]),
			closingDate: expectNumber(json.closingDate, true, true, [...path, ".closingDate"]),
			descr: expectString(json.descr, true, [...path, ".descr"]),
			location: expectString(json.location, true, [...path, ".location"]),
			externalId: expectString(json.externalId, true, [...path, ".externalId"]),
			encounterType: CodeStub.fromJSON(json.encounterType, [...path, ".encounterType"]),
			encounterLocation: DecryptedAddress.fromJSON(json.encounterLocation, [...path, ".encounterLocation"]),
			subContacts: expectArray(json.subContacts, false, [...path, ".subContacts"], (x0, p0) => DecryptedSubContact.fromJSON(x0, p0)),
			services: expectArray(json.services, false, [...path, ".services"], (x0, p0) => DecryptedService.fromJSON(x0, p0)),
			participants: expectMap(
				json.participants,
				false,
				[...path, ".participants"],
				(k0, p0) => expectStringEnum(k0, false, p0, ParticipantType, 'ParticipantType'),
				(v0, p0) => expectString(v0, false, p0)
			),
			healthcarePartyId: expectString(json.healthcarePartyId, true, [...path, ".healthcarePartyId"]),
			modifiedContactId: expectString(json.modifiedContactId, true, [...path, ".modifiedContactId"]),
			secretForeignKeys: expectArray(json.secretForeignKeys, false, [...path, ".secretForeignKeys"], (x0, p0) => expectString(x0, false, p0)),
			cryptedForeignKeys: expectMap(
				json.cryptedForeignKeys,
				false,
				[...path, ".cryptedForeignKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => Delegation.fromJSON(x1, p1))
			),
			delegations: expectMap(
				json.delegations,
				false,
				[...path, ".delegations"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => Delegation.fromJSON(x1, p1))
			),
			encryptionKeys: expectMap(
				json.encryptionKeys,
				false,
				[...path, ".encryptionKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => Delegation.fromJSON(x1, p1))
			),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
			securityMetadata: SecurityMetadata.fromJSON(json.securityMetadata, [...path, ".securityMetadata"]),
			notes: expectArray(json.notes, false, [...path, ".notes"], (x0, p0) => Annotation.fromJSON(x0, p0)),
		})
	}

}

export class EncryptedContact {

	id: string;

	rev: string | undefined = undefined;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	medicalLocationId: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	identifier: Array<Identifier> = [];

	endOfLife: number | undefined = undefined;

	deletionDate: number | undefined = undefined;

	groupId: string | undefined = undefined;

	openingDate: number | undefined = undefined;

	closingDate: number | undefined = undefined;

	descr: string | undefined = undefined;

	location: string | undefined = undefined;

	externalId: string | undefined = undefined;

	encounterType: CodeStub | undefined = undefined;

	encounterLocation: EncryptedAddress | undefined = undefined;

	subContacts: Array<EncryptedSubContact> = [];

	services: Array<EncryptedService> = [];

	participants: { [ key in ParticipantType ]?: string } = {};

	healthcarePartyId: string | undefined = undefined;

	modifiedContactId: string | undefined = undefined;

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

	securityMetadata: SecurityMetadata | undefined = undefined;

	notes: Array<Annotation> = [];

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedContact>) {
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
		if ('identifier' in partial && partial.identifier !== undefined) this.identifier = partial.identifier;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('groupId' in partial) this.groupId = partial.groupId;
		if ('openingDate' in partial) this.openingDate = partial.openingDate;
		if ('closingDate' in partial) this.closingDate = partial.closingDate;
		if ('descr' in partial) this.descr = partial.descr;
		if ('location' in partial) this.location = partial.location;
		if ('externalId' in partial) this.externalId = partial.externalId;
		if ('encounterType' in partial) this.encounterType = partial.encounterType;
		if ('encounterLocation' in partial) this.encounterLocation = partial.encounterLocation;
		if ('subContacts' in partial && partial.subContacts !== undefined) this.subContacts = partial.subContacts;
		if ('services' in partial && partial.services !== undefined) this.services = partial.services;
		if ('participants' in partial && partial.participants !== undefined) this.participants = partial.participants;
		if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
		if ('modifiedContactId' in partial) this.modifiedContactId = partial.modifiedContactId;
		if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
		if ('notes' in partial && partial.notes !== undefined) this.notes = partial.notes;
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
		res['identifier'] = this.identifier.map((x0) => x0.toJSON() )
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.groupId != undefined) res['groupId'] = this.groupId
		if (this.openingDate != undefined) res['openingDate'] = this.openingDate
		if (this.closingDate != undefined) res['closingDate'] = this.closingDate
		if (this.descr != undefined) res['descr'] = this.descr
		if (this.location != undefined) res['location'] = this.location
		if (this.externalId != undefined) res['externalId'] = this.externalId
		if (this.encounterType != undefined) res['encounterType'] = this.encounterType.toJSON()
		if (this.encounterLocation != undefined) res['encounterLocation'] = this.encounterLocation.toJSON()
		res['subContacts'] = this.subContacts.map((x0) => x0.toJSON() )
		res['services'] = this.services.map((x0) => x0.toJSON() )
		res['participants'] = Object.fromEntries(Object.entries(this.participants).map(([k0, v0]) => [k0, v0]))
		if (this.healthcarePartyId != undefined) res['healthcarePartyId'] = this.healthcarePartyId
		if (this.modifiedContactId != undefined) res['modifiedContactId'] = this.modifiedContactId
		res['secretForeignKeys'] = this.secretForeignKeys.map((x0) => x0 )
		res['cryptedForeignKeys'] = Object.fromEntries(Object.entries(this.cryptedForeignKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['delegations'] = Object.fromEntries(Object.entries(this.delegations).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['encryptionKeys'] = Object.fromEntries(Object.entries(this.encryptionKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		if (this.securityMetadata != undefined) res['securityMetadata'] = this.securityMetadata.toJSON()
		res['notes'] = this.notes.map((x0) => x0.toJSON() )
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['EncryptedContact']): EncryptedContact {
		return new EncryptedContact({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			rev: expectString(json.rev, true, [...path, ".rev"]),
			created: expectNumber(json.created, true, true, [...path, ".created"]),
			modified: expectNumber(json.modified, true, true, [...path, ".modified"]),
			author: expectString(json.author, true, [...path, ".author"]),
			responsible: expectString(json.responsible, true, [...path, ".responsible"]),
			medicalLocationId: expectString(json.medicalLocationId, true, [...path, ".medicalLocationId"]),
			tags: expectArray(json.tags, false, [...path, ".tags"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			codes: expectArray(json.codes, false, [...path, ".codes"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			identifier: expectArray(json.identifier, false, [...path, ".identifier"], (x0, p0) => Identifier.fromJSON(x0, p0)),
			endOfLife: expectNumber(json.endOfLife, true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(json.deletionDate, true, true, [...path, ".deletionDate"]),
			groupId: expectString(json.groupId, true, [...path, ".groupId"]),
			openingDate: expectNumber(json.openingDate, true, true, [...path, ".openingDate"]),
			closingDate: expectNumber(json.closingDate, true, true, [...path, ".closingDate"]),
			descr: expectString(json.descr, true, [...path, ".descr"]),
			location: expectString(json.location, true, [...path, ".location"]),
			externalId: expectString(json.externalId, true, [...path, ".externalId"]),
			encounterType: CodeStub.fromJSON(json.encounterType, [...path, ".encounterType"]),
			encounterLocation: EncryptedAddress.fromJSON(json.encounterLocation, [...path, ".encounterLocation"]),
			subContacts: expectArray(json.subContacts, false, [...path, ".subContacts"], (x0, p0) => EncryptedSubContact.fromJSON(x0, p0)),
			services: expectArray(json.services, false, [...path, ".services"], (x0, p0) => EncryptedService.fromJSON(x0, p0)),
			participants: expectMap(
				json.participants,
				false,
				[...path, ".participants"],
				(k0, p0) => expectStringEnum(k0, false, p0, ParticipantType, 'ParticipantType'),
				(v0, p0) => expectString(v0, false, p0)
			),
			healthcarePartyId: expectString(json.healthcarePartyId, true, [...path, ".healthcarePartyId"]),
			modifiedContactId: expectString(json.modifiedContactId, true, [...path, ".modifiedContactId"]),
			secretForeignKeys: expectArray(json.secretForeignKeys, false, [...path, ".secretForeignKeys"], (x0, p0) => expectString(x0, false, p0)),
			cryptedForeignKeys: expectMap(
				json.cryptedForeignKeys,
				false,
				[...path, ".cryptedForeignKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => Delegation.fromJSON(x1, p1))
			),
			delegations: expectMap(
				json.delegations,
				false,
				[...path, ".delegations"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => Delegation.fromJSON(x1, p1))
			),
			encryptionKeys: expectMap(
				json.encryptionKeys,
				false,
				[...path, ".encryptionKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => Delegation.fromJSON(x1, p1))
			),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
			securityMetadata: SecurityMetadata.fromJSON(json.securityMetadata, [...path, ".securityMetadata"]),
			notes: expectArray(json.notes, false, [...path, ".notes"], (x0, p0) => Annotation.fromJSON(x0, p0)),
		})
	}

}
