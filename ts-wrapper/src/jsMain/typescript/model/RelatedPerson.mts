// auto-generated file
import {expectArray, expectMap, expectNumber, expectObject, expectString, expectStringEnum, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {DecryptedPropertyStub, EncryptedPropertyStub, PropertyStub} from './PropertyStub.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
import {HasEndOfLife} from './base/HasEndOfLife.mjs';
import {HasIdentifier} from './base/HasIdentifier.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {Identifier} from './base/Identifier.mjs';
import {Person} from './base/Person.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {DecryptedAddress, EncryptedAddress} from './embed/Address.mjs';
import {Delegation} from './embed/Delegation.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {Gender} from './embed/Gender.mjs';
import {PersonName} from './embed/PersonName.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';
import {Base64String} from './specializations/Base64String.mjs';


/**
 *
 *
 *   A person related to one or more patients, that is neither a patient nor a healthcare party:
 *  typically a contact
 *   person (parent of a child patient, caregiver, ...), referenced from a patient's partnership with
 *   partnerType = relatedPerson. It is a standalone encryptable entity but NOT a crypto actor nor a
 *  data owner.
 */
export interface RelatedPerson extends StoredDocument, ICureDocument<string>, Person, HasEncryptionMetadata, Encryptable, HasIdentifier, HasEndOfLife {

	/**
	 *
	 *  Extra properties of the related person.
	 */
	properties: Array<PropertyStub>;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

/**
 *
 *
 *   A person related to one or more patients, that is neither a patient nor a healthcare party:
 *  typically a contact
 *   person (parent of a child patient, caregiver, ...), referenced from a patient's partnership with
 *   partnerType = relatedPerson. It is a standalone encryptable entity but NOT a crypto actor nor a
 *  data owner.
 */
export class DecryptedRelatedPerson {

	/**
	 *
	 *  The Id of the related person. We encourage using either a v4 UUID or a HL7 Id.
	 */
	id: string;

	/**
	 *
	 *  The revision of the related person in the database, used for conflict management / optimistic
	 *  locking.
	 */
	rev: string | undefined = undefined;

	/**
	 *
	 *  The identifiers of the related person.
	 */
	identifier: Array<Identifier> = [];

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
	 *  The id of the User that created this related person.
	 */
	author: string | undefined = undefined;

	/**
	 *
	 *  The id of the data owner that is responsible for this related person.
	 */
	responsible: string | undefined = undefined;

	/**
	 *
	 *  Tags that qualify the related person as being member of a certain class.
	 */
	tags: Array<CodeStub> = [];

	/**
	 *
	 *  Codes that identify or qualify this particular related person.
	 */
	codes: Array<CodeStub> = [];

	/**
	 *
	 *  Soft delete (unix epoch in ms) timestamp of the object.
	 */
	endOfLife: number | undefined = undefined;

	/**
	 *
	 *  Hard delete (unix epoch in ms) timestamp of the object.
	 */
	deletionDate: number | undefined = undefined;

	/**
	 *
	 *  The firstname (name) of the related person.
	 */
	firstName: string | undefined = undefined;

	/**
	 *
	 *  The lastname (surname) of the related person.
	 */
	lastName: string | undefined = undefined;

	/**
	 *
	 *  The list of all names of the related person, also containing the official full name information.
	 *
	 */
	names: Array<PersonName> = [];

	/**
	 *
	 *  The name of the company this related person is member of.
	 */
	companyName: string | undefined = undefined;

	/**
	 *
	 *  The list of languages spoken by the related person, in ISO 639-2 alpha-2 code.
	 */
	languages: Array<string> = [];

	/**
	 *
	 *  The addresses and telecoms of the related person.
	 */
	addresses: Array<DecryptedAddress> = [];

	/**
	 *
	 *  Mr., Ms., Pr., Dr. ...
	 */
	civility: string | undefined = undefined;

	/**
	 *
	 *  The gender of the related person.
	 */
	gender: Gender | undefined = undefined;

	/**
	 *
	 *  Extra properties of the related person.
	 */
	properties: Array<DecryptedPropertyStub> = [];

	/**
	 *
	 *  The secret foreign keys of this entity.
	 */
	secretForeignKeys: Array<string> = [];

	/**
	 *
	 *  The foreign keys encrypted in the delegates' AES keys.
	 */
	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The delegations giving access to this related person.
	 */
	delegations: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The keys used to encrypt this entity when the entity is stored encrypted.
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

	constructor(partial: Partial<DecryptedRelatedPerson>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('identifier' in partial && partial.identifier !== undefined) this.identifier = partial.identifier;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('firstName' in partial) this.firstName = partial.firstName;
		if ('lastName' in partial) this.lastName = partial.lastName;
		if ('names' in partial && partial.names !== undefined) this.names = partial.names;
		if ('companyName' in partial) this.companyName = partial.companyName;
		if ('languages' in partial && partial.languages !== undefined) this.languages = partial.languages;
		if ('addresses' in partial && partial.addresses !== undefined) this.addresses = partial.addresses;
		if ('civility' in partial) this.civility = partial.civility;
		if ('gender' in partial) this.gender = partial.gender;
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
		res['identifier'] = this.identifier.map((x0) => x0.toJSON() )
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.firstName != undefined) res['firstName'] = this.firstName
		if (this.lastName != undefined) res['lastName'] = this.lastName
		res['names'] = this.names.map((x0) => x0.toJSON() )
		if (this.companyName != undefined) res['companyName'] = this.companyName
		res['languages'] = this.languages.map((x0) => x0 )
		res['addresses'] = this.addresses.map((x0) => x0.toJSON() )
		if (this.civility != undefined) res['civility'] = this.civility
		if (this.gender != undefined) res['gender'] = this.gender
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
			path: Array<string> = ['DecryptedRelatedPerson']): DecryptedRelatedPerson {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedRelatedPerson`)
		const res = new DecryptedRelatedPerson({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			identifier: expectArray(extractEntry(jCpy, 'identifier', false, path), false, [...path, ".identifier"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Identifier.fromJSON)),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			endOfLife: expectNumber(extractEntry(jCpy, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			firstName: expectString(extractEntry(jCpy, 'firstName', false, path), true, [...path, ".firstName"]),
			lastName: expectString(extractEntry(jCpy, 'lastName', false, path), true, [...path, ".lastName"]),
			names: expectArray(extractEntry(jCpy, 'names', false, path), false, [...path, ".names"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, PersonName.fromJSON)),
			companyName: expectString(extractEntry(jCpy, 'companyName', false, path), true, [...path, ".companyName"]),
			languages: expectArray(extractEntry(jCpy, 'languages', false, path), false, [...path, ".languages"], (x0, p0) => expectString(x0, false, p0)),
			addresses: expectArray(extractEntry(jCpy, 'addresses', false, path), false, [...path, ".addresses"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedAddress.fromJSON)),
			civility: expectString(extractEntry(jCpy, 'civility', false, path), true, [...path, ".civility"]),
			gender: expectStringEnum(extractEntry(jCpy, 'gender', false, path), true, [...path, ".gender"], Gender, 'Gender'),
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
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedRelatedPerson at path ${path.join("")}: ${unused}`)}
		return res
	}

}

/**
 *
 *
 *   A person related to one or more patients, that is neither a patient nor a healthcare party:
 *  typically a contact
 *   person (parent of a child patient, caregiver, ...), referenced from a patient's partnership with
 *   partnerType = relatedPerson. It is a standalone encryptable entity but NOT a crypto actor nor a
 *  data owner.
 */
export class EncryptedRelatedPerson {

	/**
	 *
	 *  The Id of the related person. We encourage using either a v4 UUID or a HL7 Id.
	 */
	id: string;

	/**
	 *
	 *  The revision of the related person in the database, used for conflict management / optimistic
	 *  locking.
	 */
	rev: string | undefined = undefined;

	/**
	 *
	 *  The identifiers of the related person.
	 */
	identifier: Array<Identifier> = [];

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
	 *  The id of the User that created this related person.
	 */
	author: string | undefined = undefined;

	/**
	 *
	 *  The id of the data owner that is responsible for this related person.
	 */
	responsible: string | undefined = undefined;

	/**
	 *
	 *  Tags that qualify the related person as being member of a certain class.
	 */
	tags: Array<CodeStub> = [];

	/**
	 *
	 *  Codes that identify or qualify this particular related person.
	 */
	codes: Array<CodeStub> = [];

	/**
	 *
	 *  Soft delete (unix epoch in ms) timestamp of the object.
	 */
	endOfLife: number | undefined = undefined;

	/**
	 *
	 *  Hard delete (unix epoch in ms) timestamp of the object.
	 */
	deletionDate: number | undefined = undefined;

	/**
	 *
	 *  The firstname (name) of the related person.
	 */
	firstName: string | undefined = undefined;

	/**
	 *
	 *  The lastname (surname) of the related person.
	 */
	lastName: string | undefined = undefined;

	/**
	 *
	 *  The list of all names of the related person, also containing the official full name information.
	 *
	 */
	names: Array<PersonName> = [];

	/**
	 *
	 *  The name of the company this related person is member of.
	 */
	companyName: string | undefined = undefined;

	/**
	 *
	 *  The list of languages spoken by the related person, in ISO 639-2 alpha-2 code.
	 */
	languages: Array<string> = [];

	/**
	 *
	 *  The addresses and telecoms of the related person.
	 */
	addresses: Array<EncryptedAddress> = [];

	/**
	 *
	 *  Mr., Ms., Pr., Dr. ...
	 */
	civility: string | undefined = undefined;

	/**
	 *
	 *  The gender of the related person.
	 */
	gender: Gender | undefined = undefined;

	/**
	 *
	 *  Extra properties of the related person.
	 */
	properties: Array<EncryptedPropertyStub> = [];

	/**
	 *
	 *  The secret foreign keys of this entity.
	 */
	secretForeignKeys: Array<string> = [];

	/**
	 *
	 *  The foreign keys encrypted in the delegates' AES keys.
	 */
	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The delegations giving access to this related person.
	 */
	delegations: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The keys used to encrypt this entity when the entity is stored encrypted.
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

	constructor(partial: Partial<EncryptedRelatedPerson>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('identifier' in partial && partial.identifier !== undefined) this.identifier = partial.identifier;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('firstName' in partial) this.firstName = partial.firstName;
		if ('lastName' in partial) this.lastName = partial.lastName;
		if ('names' in partial && partial.names !== undefined) this.names = partial.names;
		if ('companyName' in partial) this.companyName = partial.companyName;
		if ('languages' in partial && partial.languages !== undefined) this.languages = partial.languages;
		if ('addresses' in partial && partial.addresses !== undefined) this.addresses = partial.addresses;
		if ('civility' in partial) this.civility = partial.civility;
		if ('gender' in partial) this.gender = partial.gender;
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
		res['identifier'] = this.identifier.map((x0) => x0.toJSON() )
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.firstName != undefined) res['firstName'] = this.firstName
		if (this.lastName != undefined) res['lastName'] = this.lastName
		res['names'] = this.names.map((x0) => x0.toJSON() )
		if (this.companyName != undefined) res['companyName'] = this.companyName
		res['languages'] = this.languages.map((x0) => x0 )
		res['addresses'] = this.addresses.map((x0) => x0.toJSON() )
		if (this.civility != undefined) res['civility'] = this.civility
		if (this.gender != undefined) res['gender'] = this.gender
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
			path: Array<string> = ['EncryptedRelatedPerson']): EncryptedRelatedPerson {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedRelatedPerson`)
		const res = new EncryptedRelatedPerson({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			identifier: expectArray(extractEntry(jCpy, 'identifier', false, path), false, [...path, ".identifier"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Identifier.fromJSON)),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			endOfLife: expectNumber(extractEntry(jCpy, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			firstName: expectString(extractEntry(jCpy, 'firstName', false, path), true, [...path, ".firstName"]),
			lastName: expectString(extractEntry(jCpy, 'lastName', false, path), true, [...path, ".lastName"]),
			names: expectArray(extractEntry(jCpy, 'names', false, path), false, [...path, ".names"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, PersonName.fromJSON)),
			companyName: expectString(extractEntry(jCpy, 'companyName', false, path), true, [...path, ".companyName"]),
			languages: expectArray(extractEntry(jCpy, 'languages', false, path), false, [...path, ".languages"], (x0, p0) => expectString(x0, false, p0)),
			addresses: expectArray(extractEntry(jCpy, 'addresses', false, path), false, [...path, ".addresses"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, EncryptedAddress.fromJSON)),
			civility: expectString(extractEntry(jCpy, 'civility', false, path), true, [...path, ".civility"]),
			gender: expectStringEnum(extractEntry(jCpy, 'gender', false, path), true, [...path, ".gender"], Gender, 'Gender'),
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
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedRelatedPerson at path ${path.join("")}: ${unused}`)}
		return res
	}

}
