// auto-generated file
import {expectArray, expectMap, expectNullish, expectNumber, expectObject, expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {CustomisableRoot} from './base/CustomisableRoot.mjs';
import {Extendable} from './base/Extendable.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {DataAttachment} from './embed/DataAttachment.mjs';
import {Delegation} from './embed/Delegation.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';


export interface CustomEntityBase extends HasEncryptionMetadata, StoredDocument, ICureDocument<string>, CustomisableRoot, Extendable, Encryptable {

	endOfLife: number | undefined;

	dataAttachments: { [ key: string ]: DataAttachment };

	/**
	 *
	 *
	 *   Always empty: deleted attachments are never tracked for custom entities.
	 */
	deletedAttachments: Array<never>;

	encryptedSelf: undefined;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

export class DecryptedCustomEntityBase {

	id: string;

	rev: string | undefined = undefined;

	deletionDate: number | undefined = undefined;

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	securityMetadata: SecurityMetadata | undefined = undefined;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	endOfLife: number | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	customisedModelVersion: number | undefined = undefined;

	extensions: Record<string, any> | undefined = undefined;

	dataAttachments: { [ key: string ]: DataAttachment } = {};

	/**
	 *
	 *
	 *   Always empty: deleted attachments are never tracked for custom entities.
	 */
	deletedAttachments: Array<never> = [];

	encryptedSelf: undefined = undefined;

	readonly isEncrypted: false = false;

	readonly $ktClass: 'com.icure.cardinal.sdk.model.DecryptedCustomEntityBase' = 'com.icure.cardinal.sdk.model.DecryptedCustomEntityBase';

	constructor(partial: Partial<DecryptedCustomEntityBase>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('customisedModelVersion' in partial) this.customisedModelVersion = partial.customisedModelVersion;
		if ('extensions' in partial) this.extensions = partial.extensions;
		if ('dataAttachments' in partial && partial.dataAttachments !== undefined) this.dataAttachments = partial.dataAttachments;
		if ('deletedAttachments' in partial && partial.deletedAttachments !== undefined) this.deletedAttachments = partial.deletedAttachments;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		res['secretForeignKeys'] = this.secretForeignKeys.map((x0) => x0 )
		res['cryptedForeignKeys'] = Object.fromEntries(Object.entries(this.cryptedForeignKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['delegations'] = Object.fromEntries(Object.entries(this.delegations).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['encryptionKeys'] = Object.fromEntries(Object.entries(this.encryptionKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		if (this.securityMetadata != undefined) res['securityMetadata'] = this.securityMetadata.toJSON()
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.customisedModelVersion != undefined) res['customisedModelVersion'] = this.customisedModelVersion
		if (this.extensions != undefined) res['extensions'] = this.extensions
		res['dataAttachments'] = Object.fromEntries(Object.entries(this.dataAttachments).map(([k0, v0]) => [k0, v0.toJSON()]))
		res['deletedAttachments'] = this.deletedAttachments.map((x0) => { throw new Error("Array is not allowed to have elements") } )
		if (this.encryptedSelf != undefined) throw new Error('Unexpected nullish value for encryptedSelf')
		res['isEncrypted'] = false
		res['$ktClass'] = 'com.icure.cardinal.sdk.model.DecryptedCustomEntityBase'
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedCustomEntityBase']): DecryptedCustomEntityBase {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedCustomEntityBase`)
		if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.DecryptedCustomEntityBase') throw new Error(`Unexpected value for ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.DecryptedCustomEntityBase". The provided json doesn't represent a DecryptedCustomEntityBase`)
		const res = new DecryptedCustomEntityBase({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
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
			securityMetadata: expectObject(extractEntry(jCpy, 'securityMetadata', false, path), true, ignoreUnknownKeys, [...path, ".securityMetadata"], SecurityMetadata.fromJSON),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			endOfLife: expectNumber(extractEntry(jCpy, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			customisedModelVersion: expectNumber(extractEntry(jCpy, 'customisedModelVersion', false, path), true, true, [...path, ".customisedModelVersion"]),
			extensions: extractEntry(jCpy, 'extensions', false, path),
			dataAttachments: expectMap(
				extractEntry(jCpy, 'dataAttachments', false, path),
				false,
				[...path, ".dataAttachments"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectObject(v0, false, ignoreUnknownKeys, p0, DataAttachment.fromJSON)
			),
			deletedAttachments: expectArray(extractEntry(jCpy, 'deletedAttachments', false, path), false, [...path, ".deletedAttachments"], (x0, p0) => { throw new Error(`Array at ${p0} is not allowed to have elements`) }),
			encryptedSelf: expectNullish(extractEntry(jCpy, 'encryptedSelf', false, path), [...path, ".encryptedSelf"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedCustomEntityBase at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export class EncryptedCustomEntityBase {

	id: string;

	rev: string | undefined = undefined;

	deletionDate: number | undefined = undefined;

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	securityMetadata: SecurityMetadata | undefined = undefined;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	endOfLife: number | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	customisedModelVersion: number | undefined = undefined;

	extensions: Record<string, any> | undefined = undefined;

	dataAttachments: { [ key: string ]: DataAttachment } = {};

	/**
	 *
	 *
	 *   Always empty: deleted attachments are never tracked for custom entities.
	 */
	deletedAttachments: Array<never> = [];

	encryptedSelf: undefined = undefined;

	readonly isEncrypted: true = true;

	readonly $ktClass: 'com.icure.cardinal.sdk.model.EncryptedCustomEntityBase' = 'com.icure.cardinal.sdk.model.EncryptedCustomEntityBase';

	constructor(partial: Partial<EncryptedCustomEntityBase>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('customisedModelVersion' in partial) this.customisedModelVersion = partial.customisedModelVersion;
		if ('extensions' in partial) this.extensions = partial.extensions;
		if ('dataAttachments' in partial && partial.dataAttachments !== undefined) this.dataAttachments = partial.dataAttachments;
		if ('deletedAttachments' in partial && partial.deletedAttachments !== undefined) this.deletedAttachments = partial.deletedAttachments;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		res['secretForeignKeys'] = this.secretForeignKeys.map((x0) => x0 )
		res['cryptedForeignKeys'] = Object.fromEntries(Object.entries(this.cryptedForeignKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['delegations'] = Object.fromEntries(Object.entries(this.delegations).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['encryptionKeys'] = Object.fromEntries(Object.entries(this.encryptionKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		if (this.securityMetadata != undefined) res['securityMetadata'] = this.securityMetadata.toJSON()
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.customisedModelVersion != undefined) res['customisedModelVersion'] = this.customisedModelVersion
		if (this.extensions != undefined) res['extensions'] = this.extensions
		res['dataAttachments'] = Object.fromEntries(Object.entries(this.dataAttachments).map(([k0, v0]) => [k0, v0.toJSON()]))
		res['deletedAttachments'] = this.deletedAttachments.map((x0) => { throw new Error("Array is not allowed to have elements") } )
		if (this.encryptedSelf != undefined) throw new Error('Unexpected nullish value for encryptedSelf')
		res['isEncrypted'] = true
		res['$ktClass'] = 'com.icure.cardinal.sdk.model.EncryptedCustomEntityBase'
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedCustomEntityBase']): EncryptedCustomEntityBase {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedCustomEntityBase`)
		if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.EncryptedCustomEntityBase') throw new Error(`Unexpected value for ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.EncryptedCustomEntityBase". The provided json doesn't represent a EncryptedCustomEntityBase`)
		const res = new EncryptedCustomEntityBase({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
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
			securityMetadata: expectObject(extractEntry(jCpy, 'securityMetadata', false, path), true, ignoreUnknownKeys, [...path, ".securityMetadata"], SecurityMetadata.fromJSON),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			endOfLife: expectNumber(extractEntry(jCpy, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			customisedModelVersion: expectNumber(extractEntry(jCpy, 'customisedModelVersion', false, path), true, true, [...path, ".customisedModelVersion"]),
			extensions: extractEntry(jCpy, 'extensions', false, path),
			dataAttachments: expectMap(
				extractEntry(jCpy, 'dataAttachments', false, path),
				false,
				[...path, ".dataAttachments"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectObject(v0, false, ignoreUnknownKeys, p0, DataAttachment.fromJSON)
			),
			deletedAttachments: expectArray(extractEntry(jCpy, 'deletedAttachments', false, path), false, [...path, ".deletedAttachments"], (x0, p0) => { throw new Error(`Array at ${p0} is not allowed to have elements`) }),
			encryptedSelf: expectNullish(extractEntry(jCpy, 'encryptedSelf', false, path), [...path, ".encryptedSelf"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedCustomEntityBase at path ${path.join("")}: ${unused}`)}
		return res
	}

}
