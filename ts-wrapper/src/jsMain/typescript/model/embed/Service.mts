// auto-generated file
import {expectArray, expectMap, expectNumber, expectObject, expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../../utils/Id.mjs';
import {CodeStub} from '../base/CodeStub.mjs';
import {HasEndOfLife} from '../base/HasEndOfLife.mjs';
import {ICureDocument} from '../base/ICureDocument.mjs';
import {Identifier} from '../base/Identifier.mjs';
import {LinkQualification} from '../base/LinkQualification.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Annotation} from './Annotation.mjs';
import {Content, DecryptedContent, EncryptedContent} from './Content.mjs';
import {Delegation} from './Delegation.mjs';
import {Encryptable} from './Encryptable.mjs';
import {SecurityMetadata} from './SecurityMetadata.mjs';


export interface Service extends Encryptable, ICureDocument<string>, HasEndOfLife {

	/**
	 *
	 *  The transactionId is used when a single service had to be split into parts for technical
	 *  reasons. Several services with the same non null transaction id form one single service
	 */
	transactionId: string | undefined;

	/**
	 *
	 *  The transactionId is used when a single service had to be split into parts for technical
	 *  reasons. Several services with the same non null transaction id form one single service
	 */
	identifier: Array<Identifier>;

	/**
	 *
	 *  Id of the contact during which the service is provided. Only used when the Service is emitted
	 *  outside of its contact
	 */
	contactId: string | undefined;

	subContactIds: Array<string> | undefined;

	/**
	 *
	 *  List of IDs of all plans of actions (healthcare approaches) as a part of which the Service is
	 *  provided. Only used when the Service is emitted outside of its contact
	 */
	plansOfActionIds: Array<string> | undefined;

	/**
	 *
	 *  List of IDs of all healthcare elements for which the service is provided. Only used when the
	 *  Service is emitted outside of its contact
	 */
	healthElementsIds: Array<string> | undefined;

	/**
	 *
	 *  List of Ids of all forms linked to the Service. Only used when the Service is emitted outside of
	 *  its contact.
	 */
	formIds: Array<string> | undefined;

	/**
	 *
	 *  List of Ids of all forms linked to the Service. Only used when the Service is emitted outside of
	 *  its contact.
	 */
	secretForeignKeys: Array<string> | undefined;

	/**
	 *
	 *  The public patient key, encrypted here for separate Crypto Actors.
	 */
	cryptedForeignKeys: { [ key: string ]: Array<Delegation> };

	/**
	 *
	 *  The delegations giving access to connected healthcare information.
	 */
	delegations: { [ key: string ]: Array<Delegation> };

	/**
	 *
	 *  The contact secret encryption key used to encrypt the secured properties (like services for
	 *  example), encrypted for separate Crypto Actors.
	 */
	encryptionKeys: { [ key: string ]: Array<Delegation> };

	/**
	 *
	 *  Description / Unambiguous qualification (LOINC code) of the type of information contained in the
	 *  service. Could be a code to qualify temperature, complaint, diagnostic, ...
	 */
	label: string | undefined;

	/**
	 *
	 *  Used for sorting services inside an upper object (A contact, a transaction, a FHIR bundle, ...)
	 */
	index: number | undefined;

	/**
	 *
	 *  Information contained in the service. Content is localized, using ISO language code as key
	 */
	content: { [ key: string ]: Content };

	/**
	 *
	 *  Information contained in the service. Content is localized, using ISO language code as key
	 */
	textIndexes: { [ key: string ]: string };

	/**
	 *
	 *  The date (YYYYMMDDhhmmss) when the Service is noted to have started and also closes on the same
	 *  date
	 */
	valueDate: number | undefined;

	/**
	 *
	 *  The date (YYYYMMDDhhmmss) of the start of the Service
	 */
	openingDate: number | undefined;

	/**
	 *
	 *  The date (YYYYMMDDhhmmss) marking the end of the Service
	 */
	closingDate: number | undefined;

	/**
	 *
	 *  Text, comments on the Service provided
	 */
	comment: string | undefined;

	/**
	 *
	 *  List of invoicing codes
	 */
	invoicingCodes: Array<string>;

	/**
	 *
	 *  Comments - Notes recorded by a HCP about this service
	 */
	notes: Array<Annotation>;

	/**
	 *
	 *  Links towards related services (possibly in other contacts)
	 */
	qualifiedLinks: { [ key in LinkQualification ]?: { [ key: string ]: string } };

	securityMetadata: SecurityMetadata | undefined;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

export class DecryptedService {

	/**
	 *
	 *  The Id of the Service. We encourage using either a v4 UUID or a HL7 Id.
	 */
	id: string;

	/**
	 *
	 *  The transactionId is used when a single service had to be split into parts for technical
	 *  reasons. Several services with the same non null transaction id form one single service
	 */
	transactionId: string | undefined = undefined;

	/**
	 *
	 *  The transactionId is used when a single service had to be split into parts for technical
	 *  reasons. Several services with the same non null transaction id form one single service
	 */
	identifier: Array<Identifier> = [];

	/**
	 *
	 *  Id of the contact during which the service is provided. Only used when the Service is emitted
	 *  outside of its contact
	 */
	contactId: string | undefined = undefined;

	subContactIds: Array<string> | undefined = undefined;

	/**
	 *
	 *  List of IDs of all plans of actions (healthcare approaches) as a part of which the Service is
	 *  provided. Only used when the Service is emitted outside of its contact
	 */
	plansOfActionIds: Array<string> | undefined = undefined;

	/**
	 *
	 *  List of IDs of all healthcare elements for which the service is provided. Only used when the
	 *  Service is emitted outside of its contact
	 */
	healthElementsIds: Array<string> | undefined = undefined;

	/**
	 *
	 *  List of Ids of all forms linked to the Service. Only used when the Service is emitted outside of
	 *  its contact.
	 */
	formIds: Array<string> | undefined = undefined;

	/**
	 *
	 *  List of Ids of all forms linked to the Service. Only used when the Service is emitted outside of
	 *  its contact.
	 */
	secretForeignKeys: Array<string> | undefined = [];

	/**
	 *
	 *  The public patient key, encrypted here for separate Crypto Actors.
	 */
	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The delegations giving access to connected healthcare information.
	 */
	delegations: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The contact secret encryption key used to encrypt the secured properties (like services for
	 *  example), encrypted for separate Crypto Actors.
	 */
	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  Description / Unambiguous qualification (LOINC code) of the type of information contained in the
	 *  service. Could be a code to qualify temperature, complaint, diagnostic, ...
	 */
	label: string | undefined = undefined;

	/**
	 *
	 *  Used for sorting services inside an upper object (A contact, a transaction, a FHIR bundle, ...)
	 */
	index: number | undefined = undefined;

	/**
	 *
	 *  Information contained in the service. Content is localized, using ISO language code as key
	 */
	content: { [ key: string ]: DecryptedContent } = {};

	/**
	 *
	 *  Information contained in the service. Content is localized, using ISO language code as key
	 */
	textIndexes: { [ key: string ]: string } = {};

	/**
	 *
	 *  The date (YYYYMMDDhhmmss) when the Service is noted to have started and also closes on the same
	 *  date
	 */
	valueDate: number | undefined = undefined;

	/**
	 *
	 *  The date (YYYYMMDDhhmmss) of the start of the Service
	 */
	openingDate: number | undefined = undefined;

	/**
	 *
	 *  The date (YYYYMMDDhhmmss) marking the end of the Service
	 */
	closingDate: number | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) of creation of the service, will be filled automatically if
	 *  missing. Not enforced by the application server.
	 */
	created: number | undefined = undefined;

	/**
	 *
	 *  The date (unix epoch in ms) of the latest modification of the service, will be filled
	 *  automatically if missing. Not enforced by the application server.
	 */
	modified: number | undefined = undefined;

	endOfLife: number | undefined = undefined;

	/**
	 *
	 *  The id of the User that has created this service, if absent, falls back on the contact's author
	 */
	author: string | undefined = undefined;

	/**
	 *
	 *  The id of the HealthcareParty that is responsible for this service, if absent, falls back on the
	 *  contact's responsible
	 */
	responsible: string | undefined = undefined;

	/**
	 *
	 *  Text, comments on the Service provided
	 */
	comment: string | undefined = undefined;

	/**
	 *
	 *  List of invoicing codes
	 */
	invoicingCodes: Array<string> = [];

	/**
	 *
	 *  Comments - Notes recorded by a HCP about this service
	 */
	notes: Array<Annotation> = [];

	/**
	 *
	 *  Links towards related services (possibly in other contacts)
	 */
	qualifiedLinks: { [ key in LinkQualification ]?: { [ key: string ]: string } } = {};

	/**
	 *
	 *  Links towards related services (possibly in other contacts)
	 */
	codes: Array<CodeStub> = [];

	tags: Array<CodeStub> = [];

	encryptedSelf: Base64String | undefined = undefined;

	securityMetadata: SecurityMetadata | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedService>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		this.id = partial.id ?? randomUuid();
		if ('transactionId' in partial) this.transactionId = partial.transactionId;
		if ('identifier' in partial && partial.identifier !== undefined) this.identifier = partial.identifier;
		if ('contactId' in partial) this.contactId = partial.contactId;
		if ('subContactIds' in partial) this.subContactIds = partial.subContactIds;
		if ('plansOfActionIds' in partial) this.plansOfActionIds = partial.plansOfActionIds;
		if ('healthElementsIds' in partial) this.healthElementsIds = partial.healthElementsIds;
		if ('formIds' in partial) this.formIds = partial.formIds;
		if ('secretForeignKeys' in partial) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('label' in partial) this.label = partial.label;
		if ('index' in partial) this.index = partial.index;
		if ('content' in partial && partial.content !== undefined) this.content = partial.content;
		if ('textIndexes' in partial && partial.textIndexes !== undefined) this.textIndexes = partial.textIndexes;
		if ('valueDate' in partial) this.valueDate = partial.valueDate;
		if ('openingDate' in partial) this.openingDate = partial.openingDate;
		if ('closingDate' in partial) this.closingDate = partial.closingDate;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('comment' in partial) this.comment = partial.comment;
		if ('invoicingCodes' in partial && partial.invoicingCodes !== undefined) this.invoicingCodes = partial.invoicingCodes;
		if ('notes' in partial && partial.notes !== undefined) this.notes = partial.notes;
		if ('qualifiedLinks' in partial && partial.qualifiedLinks !== undefined) this.qualifiedLinks = partial.qualifiedLinks;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.transactionId != undefined) res['transactionId'] = this.transactionId
		res['identifier'] = this.identifier.map((x0) => x0.toJSON() )
		if (this.contactId != undefined) res['contactId'] = this.contactId
		if (this.subContactIds != undefined) res['subContactIds'] = this.subContactIds.map((x0) => x0 )
		if (this.plansOfActionIds != undefined) res['plansOfActionIds'] = this.plansOfActionIds.map((x0) => x0 )
		if (this.healthElementsIds != undefined) res['healthElementsIds'] = this.healthElementsIds.map((x0) => x0 )
		if (this.formIds != undefined) res['formIds'] = this.formIds.map((x0) => x0 )
		if (this.secretForeignKeys != undefined) res['secretForeignKeys'] = this.secretForeignKeys.map((x0) => x0 )
		res['cryptedForeignKeys'] = Object.fromEntries(Object.entries(this.cryptedForeignKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['delegations'] = Object.fromEntries(Object.entries(this.delegations).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['encryptionKeys'] = Object.fromEntries(Object.entries(this.encryptionKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		if (this.label != undefined) res['label'] = this.label
		if (this.index != undefined) res['index'] = this.index
		res['content'] = Object.fromEntries(Object.entries(this.content).map(([k0, v0]) => [k0, v0.toJSON()]))
		res['textIndexes'] = Object.fromEntries(Object.entries(this.textIndexes).map(([k0, v0]) => [k0, v0]))
		if (this.valueDate != undefined) res['valueDate'] = this.valueDate
		if (this.openingDate != undefined) res['openingDate'] = this.openingDate
		if (this.closingDate != undefined) res['closingDate'] = this.closingDate
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		if (this.comment != undefined) res['comment'] = this.comment
		res['invoicingCodes'] = this.invoicingCodes.map((x0) => x0 )
		res['notes'] = this.notes.map((x0) => x0.toJSON() )
		res['qualifiedLinks'] = Object.fromEntries(Object.entries(this.qualifiedLinks).map(([k0, v0]) => [k0, Object.fromEntries(Object.entries(v0).map(([k1, v1]) => [k1, v1]))]))
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		if (this.securityMetadata != undefined) res['securityMetadata'] = this.securityMetadata.toJSON()
		res['isEncrypted'] = false
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedService']): DecryptedService {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedService`)
		const res = new DecryptedService({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			transactionId: expectString(extractEntry(jCpy, 'transactionId', false, path), true, [...path, ".transactionId"]),
			identifier: expectArray(extractEntry(jCpy, 'identifier', false, path), false, [...path, ".identifier"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Identifier.fromJSON)),
			contactId: expectString(extractEntry(jCpy, 'contactId', false, path), true, [...path, ".contactId"]),
			subContactIds: expectArray(extractEntry(jCpy, 'subContactIds', false, path), true, [...path, ".subContactIds"], (x0, p0) => expectString(x0, false, p0)),
			plansOfActionIds: expectArray(extractEntry(jCpy, 'plansOfActionIds', false, path), true, [...path, ".plansOfActionIds"], (x0, p0) => expectString(x0, false, p0)),
			healthElementsIds: expectArray(extractEntry(jCpy, 'healthElementsIds', false, path), true, [...path, ".healthElementsIds"], (x0, p0) => expectString(x0, false, p0)),
			formIds: expectArray(extractEntry(jCpy, 'formIds', false, path), true, [...path, ".formIds"], (x0, p0) => expectString(x0, false, p0)),
			secretForeignKeys: expectArray(extractEntry(jCpy, 'secretForeignKeys', false, path), true, [...path, ".secretForeignKeys"], (x0, p0) => expectString(x0, false, p0)),
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
			label: expectString(extractEntry(jCpy, 'label', false, path), true, [...path, ".label"]),
			index: expectNumber(extractEntry(jCpy, 'index', false, path), true, true, [...path, ".index"]),
			content: expectMap(
				extractEntry(jCpy, 'content', false, path),
				false,
				[...path, ".content"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectObject(v0, false, ignoreUnknownKeys, p0, DecryptedContent.fromJSON)
			),
			textIndexes: expectMap(
				extractEntry(jCpy, 'textIndexes', false, path),
				false,
				[...path, ".textIndexes"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			valueDate: expectNumber(extractEntry(jCpy, 'valueDate', false, path), true, true, [...path, ".valueDate"]),
			openingDate: expectNumber(extractEntry(jCpy, 'openingDate', false, path), true, true, [...path, ".openingDate"]),
			closingDate: expectNumber(extractEntry(jCpy, 'closingDate', false, path), true, true, [...path, ".closingDate"]),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			endOfLife: expectNumber(extractEntry(jCpy, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			comment: expectString(extractEntry(jCpy, 'comment', false, path), true, [...path, ".comment"]),
			invoicingCodes: expectArray(extractEntry(jCpy, 'invoicingCodes', false, path), false, [...path, ".invoicingCodes"], (x0, p0) => expectString(x0, false, p0)),
			notes: expectArray(extractEntry(jCpy, 'notes', false, path), false, [...path, ".notes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Annotation.fromJSON)),
			qualifiedLinks: expectMap(
				extractEntry(jCpy, 'qualifiedLinks', false, path),
				false,
				[...path, ".qualifiedLinks"],
				(k0, p0) => expectStringEnum(k0, false, p0, LinkQualification, 'LinkQualification'),
				(v0, p0) => expectMap(
					v0,
					false,
					p0,
					(k1, p1) => expectString(k1, false, p1),
					(v1, p1) => expectString(v1, false, p1)
				)
			),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
			securityMetadata: expectObject(extractEntry(jCpy, 'securityMetadata', false, path), true, ignoreUnknownKeys, [...path, ".securityMetadata"], SecurityMetadata.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedService at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export class EncryptedService {

	/**
	 *
	 *  The Id of the Service. We encourage using either a v4 UUID or a HL7 Id.
	 */
	id: string;

	/**
	 *
	 *  The transactionId is used when a single service had to be split into parts for technical
	 *  reasons. Several services with the same non null transaction id form one single service
	 */
	transactionId: string | undefined = undefined;

	/**
	 *
	 *  The transactionId is used when a single service had to be split into parts for technical
	 *  reasons. Several services with the same non null transaction id form one single service
	 */
	identifier: Array<Identifier> = [];

	/**
	 *
	 *  Id of the contact during which the service is provided. Only used when the Service is emitted
	 *  outside of its contact
	 */
	contactId: string | undefined = undefined;

	subContactIds: Array<string> | undefined = undefined;

	/**
	 *
	 *  List of IDs of all plans of actions (healthcare approaches) as a part of which the Service is
	 *  provided. Only used when the Service is emitted outside of its contact
	 */
	plansOfActionIds: Array<string> | undefined = undefined;

	/**
	 *
	 *  List of IDs of all healthcare elements for which the service is provided. Only used when the
	 *  Service is emitted outside of its contact
	 */
	healthElementsIds: Array<string> | undefined = undefined;

	/**
	 *
	 *  List of Ids of all forms linked to the Service. Only used when the Service is emitted outside of
	 *  its contact.
	 */
	formIds: Array<string> | undefined = undefined;

	/**
	 *
	 *  List of Ids of all forms linked to the Service. Only used when the Service is emitted outside of
	 *  its contact.
	 */
	secretForeignKeys: Array<string> | undefined = [];

	/**
	 *
	 *  The public patient key, encrypted here for separate Crypto Actors.
	 */
	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The delegations giving access to connected healthcare information.
	 */
	delegations: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The contact secret encryption key used to encrypt the secured properties (like services for
	 *  example), encrypted for separate Crypto Actors.
	 */
	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  Description / Unambiguous qualification (LOINC code) of the type of information contained in the
	 *  service. Could be a code to qualify temperature, complaint, diagnostic, ...
	 */
	label: string | undefined = undefined;

	/**
	 *
	 *  Used for sorting services inside an upper object (A contact, a transaction, a FHIR bundle, ...)
	 */
	index: number | undefined = undefined;

	/**
	 *
	 *  Information contained in the service. Content is localized, using ISO language code as key
	 */
	content: { [ key: string ]: EncryptedContent } = {};

	/**
	 *
	 *  Information contained in the service. Content is localized, using ISO language code as key
	 */
	textIndexes: { [ key: string ]: string } = {};

	/**
	 *
	 *  The date (YYYYMMDDhhmmss) when the Service is noted to have started and also closes on the same
	 *  date
	 */
	valueDate: number | undefined = undefined;

	/**
	 *
	 *  The date (YYYYMMDDhhmmss) of the start of the Service
	 */
	openingDate: number | undefined = undefined;

	/**
	 *
	 *  The date (YYYYMMDDhhmmss) marking the end of the Service
	 */
	closingDate: number | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) of creation of the service, will be filled automatically if
	 *  missing. Not enforced by the application server.
	 */
	created: number | undefined = undefined;

	/**
	 *
	 *  The date (unix epoch in ms) of the latest modification of the service, will be filled
	 *  automatically if missing. Not enforced by the application server.
	 */
	modified: number | undefined = undefined;

	endOfLife: number | undefined = undefined;

	/**
	 *
	 *  The id of the User that has created this service, if absent, falls back on the contact's author
	 */
	author: string | undefined = undefined;

	/**
	 *
	 *  The id of the HealthcareParty that is responsible for this service, if absent, falls back on the
	 *  contact's responsible
	 */
	responsible: string | undefined = undefined;

	/**
	 *
	 *  Text, comments on the Service provided
	 */
	comment: string | undefined = undefined;

	/**
	 *
	 *  List of invoicing codes
	 */
	invoicingCodes: Array<string> = [];

	/**
	 *
	 *  Comments - Notes recorded by a HCP about this service
	 */
	notes: Array<Annotation> = [];

	/**
	 *
	 *  Links towards related services (possibly in other contacts)
	 */
	qualifiedLinks: { [ key in LinkQualification ]?: { [ key: string ]: string } } = {};

	/**
	 *
	 *  Links towards related services (possibly in other contacts)
	 */
	codes: Array<CodeStub> = [];

	tags: Array<CodeStub> = [];

	encryptedSelf: Base64String | undefined = undefined;

	securityMetadata: SecurityMetadata | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedService>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		this.id = partial.id ?? randomUuid();
		if ('transactionId' in partial) this.transactionId = partial.transactionId;
		if ('identifier' in partial && partial.identifier !== undefined) this.identifier = partial.identifier;
		if ('contactId' in partial) this.contactId = partial.contactId;
		if ('subContactIds' in partial) this.subContactIds = partial.subContactIds;
		if ('plansOfActionIds' in partial) this.plansOfActionIds = partial.plansOfActionIds;
		if ('healthElementsIds' in partial) this.healthElementsIds = partial.healthElementsIds;
		if ('formIds' in partial) this.formIds = partial.formIds;
		if ('secretForeignKeys' in partial) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('label' in partial) this.label = partial.label;
		if ('index' in partial) this.index = partial.index;
		if ('content' in partial && partial.content !== undefined) this.content = partial.content;
		if ('textIndexes' in partial && partial.textIndexes !== undefined) this.textIndexes = partial.textIndexes;
		if ('valueDate' in partial) this.valueDate = partial.valueDate;
		if ('openingDate' in partial) this.openingDate = partial.openingDate;
		if ('closingDate' in partial) this.closingDate = partial.closingDate;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('comment' in partial) this.comment = partial.comment;
		if ('invoicingCodes' in partial && partial.invoicingCodes !== undefined) this.invoicingCodes = partial.invoicingCodes;
		if ('notes' in partial && partial.notes !== undefined) this.notes = partial.notes;
		if ('qualifiedLinks' in partial && partial.qualifiedLinks !== undefined) this.qualifiedLinks = partial.qualifiedLinks;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.transactionId != undefined) res['transactionId'] = this.transactionId
		res['identifier'] = this.identifier.map((x0) => x0.toJSON() )
		if (this.contactId != undefined) res['contactId'] = this.contactId
		if (this.subContactIds != undefined) res['subContactIds'] = this.subContactIds.map((x0) => x0 )
		if (this.plansOfActionIds != undefined) res['plansOfActionIds'] = this.plansOfActionIds.map((x0) => x0 )
		if (this.healthElementsIds != undefined) res['healthElementsIds'] = this.healthElementsIds.map((x0) => x0 )
		if (this.formIds != undefined) res['formIds'] = this.formIds.map((x0) => x0 )
		if (this.secretForeignKeys != undefined) res['secretForeignKeys'] = this.secretForeignKeys.map((x0) => x0 )
		res['cryptedForeignKeys'] = Object.fromEntries(Object.entries(this.cryptedForeignKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['delegations'] = Object.fromEntries(Object.entries(this.delegations).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['encryptionKeys'] = Object.fromEntries(Object.entries(this.encryptionKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		if (this.label != undefined) res['label'] = this.label
		if (this.index != undefined) res['index'] = this.index
		res['content'] = Object.fromEntries(Object.entries(this.content).map(([k0, v0]) => [k0, v0.toJSON()]))
		res['textIndexes'] = Object.fromEntries(Object.entries(this.textIndexes).map(([k0, v0]) => [k0, v0]))
		if (this.valueDate != undefined) res['valueDate'] = this.valueDate
		if (this.openingDate != undefined) res['openingDate'] = this.openingDate
		if (this.closingDate != undefined) res['closingDate'] = this.closingDate
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		if (this.comment != undefined) res['comment'] = this.comment
		res['invoicingCodes'] = this.invoicingCodes.map((x0) => x0 )
		res['notes'] = this.notes.map((x0) => x0.toJSON() )
		res['qualifiedLinks'] = Object.fromEntries(Object.entries(this.qualifiedLinks).map(([k0, v0]) => [k0, Object.fromEntries(Object.entries(v0).map(([k1, v1]) => [k1, v1]))]))
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		if (this.securityMetadata != undefined) res['securityMetadata'] = this.securityMetadata.toJSON()
		res['isEncrypted'] = true
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedService']): EncryptedService {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedService`)
		const res = new EncryptedService({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			transactionId: expectString(extractEntry(jCpy, 'transactionId', false, path), true, [...path, ".transactionId"]),
			identifier: expectArray(extractEntry(jCpy, 'identifier', false, path), false, [...path, ".identifier"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Identifier.fromJSON)),
			contactId: expectString(extractEntry(jCpy, 'contactId', false, path), true, [...path, ".contactId"]),
			subContactIds: expectArray(extractEntry(jCpy, 'subContactIds', false, path), true, [...path, ".subContactIds"], (x0, p0) => expectString(x0, false, p0)),
			plansOfActionIds: expectArray(extractEntry(jCpy, 'plansOfActionIds', false, path), true, [...path, ".plansOfActionIds"], (x0, p0) => expectString(x0, false, p0)),
			healthElementsIds: expectArray(extractEntry(jCpy, 'healthElementsIds', false, path), true, [...path, ".healthElementsIds"], (x0, p0) => expectString(x0, false, p0)),
			formIds: expectArray(extractEntry(jCpy, 'formIds', false, path), true, [...path, ".formIds"], (x0, p0) => expectString(x0, false, p0)),
			secretForeignKeys: expectArray(extractEntry(jCpy, 'secretForeignKeys', false, path), true, [...path, ".secretForeignKeys"], (x0, p0) => expectString(x0, false, p0)),
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
			label: expectString(extractEntry(jCpy, 'label', false, path), true, [...path, ".label"]),
			index: expectNumber(extractEntry(jCpy, 'index', false, path), true, true, [...path, ".index"]),
			content: expectMap(
				extractEntry(jCpy, 'content', false, path),
				false,
				[...path, ".content"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectObject(v0, false, ignoreUnknownKeys, p0, EncryptedContent.fromJSON)
			),
			textIndexes: expectMap(
				extractEntry(jCpy, 'textIndexes', false, path),
				false,
				[...path, ".textIndexes"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			valueDate: expectNumber(extractEntry(jCpy, 'valueDate', false, path), true, true, [...path, ".valueDate"]),
			openingDate: expectNumber(extractEntry(jCpy, 'openingDate', false, path), true, true, [...path, ".openingDate"]),
			closingDate: expectNumber(extractEntry(jCpy, 'closingDate', false, path), true, true, [...path, ".closingDate"]),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			endOfLife: expectNumber(extractEntry(jCpy, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			comment: expectString(extractEntry(jCpy, 'comment', false, path), true, [...path, ".comment"]),
			invoicingCodes: expectArray(extractEntry(jCpy, 'invoicingCodes', false, path), false, [...path, ".invoicingCodes"], (x0, p0) => expectString(x0, false, p0)),
			notes: expectArray(extractEntry(jCpy, 'notes', false, path), false, [...path, ".notes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Annotation.fromJSON)),
			qualifiedLinks: expectMap(
				extractEntry(jCpy, 'qualifiedLinks', false, path),
				false,
				[...path, ".qualifiedLinks"],
				(k0, p0) => expectStringEnum(k0, false, p0, LinkQualification, 'LinkQualification'),
				(v0, p0) => expectMap(
					v0,
					false,
					p0,
					(k1, p1) => expectString(k1, false, p1),
					(v1, p1) => expectString(v1, false, p1)
				)
			),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
			securityMetadata: expectObject(extractEntry(jCpy, 'securityMetadata', false, path), true, ignoreUnknownKeys, [...path, ".securityMetadata"], SecurityMetadata.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedService at path ${path.join("")}: ${unused}`)}
		return res
	}

}
