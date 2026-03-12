// auto-generated file
import {expectArray, expectMap, expectNumber, expectObject, expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
import {HasEndOfLife} from './base/HasEndOfLife.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {Delegation} from './embed/Delegation.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';
import {Base64String} from './specializations/Base64String.mjs';


/**
 *
 *  Represents a classification used to organize and categorize medical data. Classifications can be
 *  nested
 *  through parent-child relationships and linked to classification templates.
 *  /
 */
export interface Classification extends StoredDocument, ICureDocument<string>, HasEncryptionMetadata, Encryptable, HasEndOfLife {

	/**
	 *
	 *  The id of the parent classification, for nesting.
	 */
	parentId: string | undefined;

	/**
	 *
	 *  A human-readable label for this classification.
	 */
	label: string;

	/**
	 *
	 *  The id of the classification template this classification is based on.
	 */
	templateId: string | undefined;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

/**
 *
 *  Represents a classification used to organize and categorize medical data. Classifications can be
 *  nested
 *  through parent-child relationships and linked to classification templates.
 *  /
 */
export class DecryptedClassification {

	/**
	 *
	 *  The Id of the classification. We encourage using either a v4 UUID or a HL7 Id.
	 */
	id: string;

	/**
	 *
	 *  The revision of the classification in the database, used for conflict management / optimistic
	 *  locking.
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
	 *  The id of the User that created this classification.
	 */
	author: string | undefined = undefined;

	/**
	 *
	 *  The id of the data owner that is responsible for this classification.
	 */
	responsible: string | undefined = undefined;

	/**
	 *
	 *  Tags that qualify the classification as being member of a certain class.
	 */
	tags: Array<CodeStub> = [];

	/**
	 *
	 *  Codes that identify or qualify this particular classification.
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
	 *  The id of the parent classification, for nesting.
	 */
	parentId: string | undefined = undefined;

	/**
	 *
	 *  A human-readable label for this classification.
	 */
	label: string = "";

	/**
	 *
	 *  The id of the classification template this classification is based on.
	 */
	templateId: string | undefined = undefined;

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
	 *  The base64-encoded encrypted fields of this classification.
	 */
	encryptedSelf: Base64String | undefined = undefined;

	/**
	 *
	 *  The security metadata of this entity, for access control.
	 */
	securityMetadata: SecurityMetadata | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedClassification>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('parentId' in partial) this.parentId = partial.parentId;
		if ('label' in partial && partial.label !== undefined) this.label = partial.label;
		if ('templateId' in partial) this.templateId = partial.templateId;
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
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.parentId != undefined) res['parentId'] = this.parentId
		res['label'] = this.label
		if (this.templateId != undefined) res['templateId'] = this.templateId
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
			path: Array<string> = ['DecryptedClassification']): DecryptedClassification {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedClassification`)
		const res = new DecryptedClassification({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			endOfLife: expectNumber(extractEntry(jCpy, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			parentId: expectString(extractEntry(jCpy, 'parentId', false, path), true, [...path, ".parentId"]),
			label: expectString(extractEntry(jCpy, 'label', false, path), false, [...path, ".label"]),
			templateId: expectString(extractEntry(jCpy, 'templateId', false, path), true, [...path, ".templateId"]),
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
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedClassification at path ${path.join("")}: ${unused}`)}
		return res
	}

}

/**
 *
 *  Represents a classification used to organize and categorize medical data. Classifications can be
 *  nested
 *  through parent-child relationships and linked to classification templates.
 *  /
 */
export class EncryptedClassification {

	/**
	 *
	 *  The Id of the classification. We encourage using either a v4 UUID or a HL7 Id.
	 */
	id: string;

	/**
	 *
	 *  The revision of the classification in the database, used for conflict management / optimistic
	 *  locking.
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
	 *  The id of the User that created this classification.
	 */
	author: string | undefined = undefined;

	/**
	 *
	 *  The id of the data owner that is responsible for this classification.
	 */
	responsible: string | undefined = undefined;

	/**
	 *
	 *  Tags that qualify the classification as being member of a certain class.
	 */
	tags: Array<CodeStub> = [];

	/**
	 *
	 *  Codes that identify or qualify this particular classification.
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
	 *  The id of the parent classification, for nesting.
	 */
	parentId: string | undefined = undefined;

	/**
	 *
	 *  A human-readable label for this classification.
	 */
	label: string = "";

	/**
	 *
	 *  The id of the classification template this classification is based on.
	 */
	templateId: string | undefined = undefined;

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
	 *  The base64-encoded encrypted fields of this classification.
	 */
	encryptedSelf: Base64String | undefined = undefined;

	/**
	 *
	 *  The security metadata of this entity, for access control.
	 */
	securityMetadata: SecurityMetadata | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedClassification>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('parentId' in partial) this.parentId = partial.parentId;
		if ('label' in partial && partial.label !== undefined) this.label = partial.label;
		if ('templateId' in partial) this.templateId = partial.templateId;
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
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.parentId != undefined) res['parentId'] = this.parentId
		res['label'] = this.label
		if (this.templateId != undefined) res['templateId'] = this.templateId
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
			path: Array<string> = ['EncryptedClassification']): EncryptedClassification {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedClassification`)
		const res = new EncryptedClassification({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			endOfLife: expectNumber(extractEntry(jCpy, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			parentId: expectString(extractEntry(jCpy, 'parentId', false, path), true, [...path, ".parentId"]),
			label: expectString(extractEntry(jCpy, 'label', false, path), false, [...path, ".label"]),
			templateId: expectString(extractEntry(jCpy, 'templateId', false, path), true, [...path, ".templateId"]),
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
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedClassification at path ${path.join("")}: ${unused}`)}
		return res
	}

}
