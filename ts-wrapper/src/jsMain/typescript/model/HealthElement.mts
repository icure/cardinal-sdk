// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectObject, expectString, expectStringEnum, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
import {HasEndOfLife} from './base/HasEndOfLife.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {Identifier} from './base/Identifier.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {Annotation} from './embed/Annotation.mjs';
import {CareTeamMember, DecryptedCareTeamMember, EncryptedCareTeamMember} from './embed/CareTeamMember.mjs';
import {Delegation} from './embed/Delegation.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {DecryptedEpisode, EncryptedEpisode, Episode} from './embed/Episode.mjs';
import {Laterality} from './embed/Laterality.mjs';
import {DecryptedPlanOfAction, EncryptedPlanOfAction, PlanOfAction} from './embed/PlanOfAction.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';
import {Base64String} from './specializations/Base64String.mjs';


/**
 *
 *  Represents a healthcare element. A healthcare element is a patient-centric representation of a
 *  healthcare problem
 *  that evolves over time in its name/label and characteristics. It is a central element in the
 *  organisation of the
 *  electronic health record, used to filter and link medical data in a meaningful way.
 *  /
 */
export interface HealthElement extends StoredDocument, ICureDocument<string>, HasEncryptionMetadata, Encryptable, HasEndOfLife {

	/**
	 *
	 *  The identifiers of the healthcare element.
	 */
	identifiers: Array<Identifier>;

	/**
	 *
	 *  The logical id of the healthcare element, used to link together different versions of the same
	 *  healthcare element.
	 */
	healthElementId: string | undefined;

	/**
	 *
	 *  The date (unix epoch in ms) when the healthcare element is noted to have started and also closes
	 *  on the same date.
	 */
	valueDate: number | undefined;

	/**
	 *
	 *  The date (unix epoch in ms) of the start of the healthcare element.
	 */
	openingDate: number | undefined;

	/**
	 *
	 *  The date (unix epoch in ms) marking the end of the healthcare element.
	 */
	closingDate: number | undefined;

	/**
	 *
	 *  Description of the healthcare element.
	 */
	descr: string | undefined;

	/**
	 *
	 *  A text note (can be confidential, encrypted by default).
	 */
	note: string | undefined;

	/**
	 *
	 *  Localized text annotations for the healthcare element.
	 */
	notes: Array<Annotation>;

	/**
	 *
	 *  Whether the healthcare element is relevant or not.
	 */
	relevant: boolean;

	/**
	 *
	 *  Id of the opening contact when the healthcare element was created.
	 */
	idOpeningContact: string | undefined;

	/**
	 *
	 *  Id of the closing contact for the healthcare element.
	 */
	idClosingContact: string | undefined;

	/**
	 *
	 *  Id of the service when a service is used to create a healthcare element.
	 */
	idService: string | undefined;

	/**
	 *
	 *  Left or right dominance/preference.
	 */
	laterality: Laterality | undefined;

	/**
	 *
	 *  List of healthcare approaches.
	 */
	plansOfAction: Array<PlanOfAction>;

	/**
	 *
	 *  List of episodes of occurrences of the healthcare element.
	 */
	episodes: Array<Episode>;

	/**
	 *
	 *  List of care team members assigned for the healthcare element.
	 */
	careTeam: Array<CareTeamMember>;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

/**
 *
 *  Represents a healthcare element. A healthcare element is a patient-centric representation of a
 *  healthcare problem
 *  that evolves over time in its name/label and characteristics. It is a central element in the
 *  organisation of the
 *  electronic health record, used to filter and link medical data in a meaningful way.
 *  /
 */
export class DecryptedHealthElement {

	/**
	 *
	 *  The Id of the healthcare element. We encourage using either a v4 UUID or a HL7 Id.
	 */
	id: string;

	/**
	 *
	 *  The identifiers of the healthcare element.
	 */
	identifiers: Array<Identifier> = [];

	/**
	 *
	 *  The revision of the healthcare element in the database, used for conflict management /
	 *  optimistic locking.
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
	 *  The id of the User that created this healthcare element.
	 */
	author: string | undefined = undefined;

	/**
	 *
	 *  The id of the HealthcareParty that is responsible for this healthcare element.
	 */
	responsible: string | undefined = undefined;

	/**
	 *
	 *  Tags that qualify the healthcare element as being member of a certain class.
	 */
	tags: Array<CodeStub> = [];

	/**
	 *
	 *  Codes that identify or qualify this particular healthcare element.
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
	 *  The logical id of the healthcare element, used to link together different versions of the same
	 *  healthcare element.
	 */
	healthElementId: string | undefined = undefined;

	/**
	 *
	 *  The date (unix epoch in ms) when the healthcare element is noted to have started and also closes
	 *  on the same date.
	 */
	valueDate: number | undefined = undefined;

	/**
	 *
	 *  The date (unix epoch in ms) of the start of the healthcare element.
	 */
	openingDate: number | undefined = undefined;

	/**
	 *
	 *  The date (unix epoch in ms) marking the end of the healthcare element.
	 */
	closingDate: number | undefined = undefined;

	/**
	 *
	 *  Description of the healthcare element.
	 */
	descr: string | undefined = undefined;

	/**
	 *
	 *  A text note (can be confidential, encrypted by default).
	 */
	note: string | undefined = undefined;

	/**
	 *
	 *  Localized text annotations for the healthcare element.
	 */
	notes: Array<Annotation> = [];

	/**
	 *
	 *  Whether the healthcare element is relevant or not.
	 */
	relevant: boolean = true;

	/**
	 *
	 *  Id of the opening contact when the healthcare element was created.
	 */
	idOpeningContact: string | undefined = undefined;

	/**
	 *
	 *  Id of the closing contact for the healthcare element.
	 */
	idClosingContact: string | undefined = undefined;

	/**
	 *
	 *  Id of the service when a service is used to create a healthcare element.
	 */
	idService: string | undefined = undefined;

	/**
	 *
	 *  Left or right dominance/preference.
	 */
	laterality: Laterality | undefined = undefined;

	/**
	 *
	 *  List of healthcare approaches.
	 */
	plansOfAction: Array<DecryptedPlanOfAction> = [];

	/**
	 *
	 *  List of episodes of occurrences of the healthcare element.
	 */
	episodes: Array<DecryptedEpisode> = [];

	/**
	 *
	 *  List of care team members assigned for the healthcare element.
	 */
	careTeam: Array<DecryptedCareTeamMember> = [];

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

	constructor(partial: Partial<DecryptedHealthElement>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		this.id = partial.id ?? randomUuid();
		if ('identifiers' in partial && partial.identifiers !== undefined) this.identifiers = partial.identifiers;
		if ('rev' in partial) this.rev = partial.rev;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('healthElementId' in partial) this.healthElementId = partial.healthElementId;
		if ('valueDate' in partial) this.valueDate = partial.valueDate;
		if ('openingDate' in partial) this.openingDate = partial.openingDate;
		if ('closingDate' in partial) this.closingDate = partial.closingDate;
		if ('descr' in partial) this.descr = partial.descr;
		if ('note' in partial) this.note = partial.note;
		if ('notes' in partial && partial.notes !== undefined) this.notes = partial.notes;
		if ('relevant' in partial && partial.relevant !== undefined) this.relevant = partial.relevant;
		if ('idOpeningContact' in partial) this.idOpeningContact = partial.idOpeningContact;
		if ('idClosingContact' in partial) this.idClosingContact = partial.idClosingContact;
		if ('idService' in partial) this.idService = partial.idService;
		if ('laterality' in partial) this.laterality = partial.laterality;
		if ('plansOfAction' in partial && partial.plansOfAction !== undefined) this.plansOfAction = partial.plansOfAction;
		if ('episodes' in partial && partial.episodes !== undefined) this.episodes = partial.episodes;
		if ('careTeam' in partial && partial.careTeam !== undefined) this.careTeam = partial.careTeam;
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
		res['identifiers'] = this.identifiers.map((x0) => x0.toJSON() )
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.healthElementId != undefined) res['healthElementId'] = this.healthElementId
		if (this.valueDate != undefined) res['valueDate'] = this.valueDate
		if (this.openingDate != undefined) res['openingDate'] = this.openingDate
		if (this.closingDate != undefined) res['closingDate'] = this.closingDate
		if (this.descr != undefined) res['descr'] = this.descr
		if (this.note != undefined) res['note'] = this.note
		res['notes'] = this.notes.map((x0) => x0.toJSON() )
		res['relevant'] = this.relevant
		if (this.idOpeningContact != undefined) res['idOpeningContact'] = this.idOpeningContact
		if (this.idClosingContact != undefined) res['idClosingContact'] = this.idClosingContact
		if (this.idService != undefined) res['idService'] = this.idService
		if (this.laterality != undefined) res['laterality'] = this.laterality
		res['plansOfAction'] = this.plansOfAction.map((x0) => x0.toJSON() )
		res['episodes'] = this.episodes.map((x0) => x0.toJSON() )
		res['careTeam'] = this.careTeam.map((x0) => x0.toJSON() )
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
			path: Array<string> = ['DecryptedHealthElement']): DecryptedHealthElement {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedHealthElement`)
		const res = new DecryptedHealthElement({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			identifiers: expectArray(extractEntry(jCpy, 'identifiers', false, path), false, [...path, ".identifiers"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Identifier.fromJSON)),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			endOfLife: expectNumber(extractEntry(jCpy, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			healthElementId: expectString(extractEntry(jCpy, 'healthElementId', false, path), true, [...path, ".healthElementId"]),
			valueDate: expectNumber(extractEntry(jCpy, 'valueDate', false, path), true, true, [...path, ".valueDate"]),
			openingDate: expectNumber(extractEntry(jCpy, 'openingDate', false, path), true, true, [...path, ".openingDate"]),
			closingDate: expectNumber(extractEntry(jCpy, 'closingDate', false, path), true, true, [...path, ".closingDate"]),
			descr: expectString(extractEntry(jCpy, 'descr', false, path), true, [...path, ".descr"]),
			note: expectString(extractEntry(jCpy, 'note', false, path), true, [...path, ".note"]),
			notes: expectArray(extractEntry(jCpy, 'notes', false, path), false, [...path, ".notes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Annotation.fromJSON)),
			relevant: expectBoolean(extractEntry(jCpy, 'relevant', false, path), false, [...path, ".relevant"]),
			idOpeningContact: expectString(extractEntry(jCpy, 'idOpeningContact', false, path), true, [...path, ".idOpeningContact"]),
			idClosingContact: expectString(extractEntry(jCpy, 'idClosingContact', false, path), true, [...path, ".idClosingContact"]),
			idService: expectString(extractEntry(jCpy, 'idService', false, path), true, [...path, ".idService"]),
			laterality: expectStringEnum(extractEntry(jCpy, 'laterality', false, path), true, [...path, ".laterality"], Laterality, 'Laterality'),
			plansOfAction: expectArray(extractEntry(jCpy, 'plansOfAction', false, path), false, [...path, ".plansOfAction"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedPlanOfAction.fromJSON)),
			episodes: expectArray(extractEntry(jCpy, 'episodes', false, path), false, [...path, ".episodes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedEpisode.fromJSON)),
			careTeam: expectArray(extractEntry(jCpy, 'careTeam', false, path), false, [...path, ".careTeam"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedCareTeamMember.fromJSON)),
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
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedHealthElement at path ${path.join("")}: ${unused}`)}
		return res
	}

}

/**
 *
 *  Represents a healthcare element. A healthcare element is a patient-centric representation of a
 *  healthcare problem
 *  that evolves over time in its name/label and characteristics. It is a central element in the
 *  organisation of the
 *  electronic health record, used to filter and link medical data in a meaningful way.
 *  /
 */
export class EncryptedHealthElement {

	/**
	 *
	 *  The Id of the healthcare element. We encourage using either a v4 UUID or a HL7 Id.
	 */
	id: string;

	/**
	 *
	 *  The identifiers of the healthcare element.
	 */
	identifiers: Array<Identifier> = [];

	/**
	 *
	 *  The revision of the healthcare element in the database, used for conflict management /
	 *  optimistic locking.
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
	 *  The id of the User that created this healthcare element.
	 */
	author: string | undefined = undefined;

	/**
	 *
	 *  The id of the HealthcareParty that is responsible for this healthcare element.
	 */
	responsible: string | undefined = undefined;

	/**
	 *
	 *  Tags that qualify the healthcare element as being member of a certain class.
	 */
	tags: Array<CodeStub> = [];

	/**
	 *
	 *  Codes that identify or qualify this particular healthcare element.
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
	 *  The logical id of the healthcare element, used to link together different versions of the same
	 *  healthcare element.
	 */
	healthElementId: string | undefined = undefined;

	/**
	 *
	 *  The date (unix epoch in ms) when the healthcare element is noted to have started and also closes
	 *  on the same date.
	 */
	valueDate: number | undefined = undefined;

	/**
	 *
	 *  The date (unix epoch in ms) of the start of the healthcare element.
	 */
	openingDate: number | undefined = undefined;

	/**
	 *
	 *  The date (unix epoch in ms) marking the end of the healthcare element.
	 */
	closingDate: number | undefined = undefined;

	/**
	 *
	 *  Description of the healthcare element.
	 */
	descr: string | undefined = undefined;

	/**
	 *
	 *  A text note (can be confidential, encrypted by default).
	 */
	note: string | undefined = undefined;

	/**
	 *
	 *  Localized text annotations for the healthcare element.
	 */
	notes: Array<Annotation> = [];

	/**
	 *
	 *  Whether the healthcare element is relevant or not.
	 */
	relevant: boolean = true;

	/**
	 *
	 *  Id of the opening contact when the healthcare element was created.
	 */
	idOpeningContact: string | undefined = undefined;

	/**
	 *
	 *  Id of the closing contact for the healthcare element.
	 */
	idClosingContact: string | undefined = undefined;

	/**
	 *
	 *  Id of the service when a service is used to create a healthcare element.
	 */
	idService: string | undefined = undefined;

	/**
	 *
	 *  Left or right dominance/preference.
	 */
	laterality: Laterality | undefined = undefined;

	/**
	 *
	 *  List of healthcare approaches.
	 */
	plansOfAction: Array<EncryptedPlanOfAction> = [];

	/**
	 *
	 *  List of episodes of occurrences of the healthcare element.
	 */
	episodes: Array<EncryptedEpisode> = [];

	/**
	 *
	 *  List of care team members assigned for the healthcare element.
	 */
	careTeam: Array<EncryptedCareTeamMember> = [];

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

	constructor(partial: Partial<EncryptedHealthElement>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		this.id = partial.id ?? randomUuid();
		if ('identifiers' in partial && partial.identifiers !== undefined) this.identifiers = partial.identifiers;
		if ('rev' in partial) this.rev = partial.rev;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('healthElementId' in partial) this.healthElementId = partial.healthElementId;
		if ('valueDate' in partial) this.valueDate = partial.valueDate;
		if ('openingDate' in partial) this.openingDate = partial.openingDate;
		if ('closingDate' in partial) this.closingDate = partial.closingDate;
		if ('descr' in partial) this.descr = partial.descr;
		if ('note' in partial) this.note = partial.note;
		if ('notes' in partial && partial.notes !== undefined) this.notes = partial.notes;
		if ('relevant' in partial && partial.relevant !== undefined) this.relevant = partial.relevant;
		if ('idOpeningContact' in partial) this.idOpeningContact = partial.idOpeningContact;
		if ('idClosingContact' in partial) this.idClosingContact = partial.idClosingContact;
		if ('idService' in partial) this.idService = partial.idService;
		if ('laterality' in partial) this.laterality = partial.laterality;
		if ('plansOfAction' in partial && partial.plansOfAction !== undefined) this.plansOfAction = partial.plansOfAction;
		if ('episodes' in partial && partial.episodes !== undefined) this.episodes = partial.episodes;
		if ('careTeam' in partial && partial.careTeam !== undefined) this.careTeam = partial.careTeam;
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
		res['identifiers'] = this.identifiers.map((x0) => x0.toJSON() )
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.healthElementId != undefined) res['healthElementId'] = this.healthElementId
		if (this.valueDate != undefined) res['valueDate'] = this.valueDate
		if (this.openingDate != undefined) res['openingDate'] = this.openingDate
		if (this.closingDate != undefined) res['closingDate'] = this.closingDate
		if (this.descr != undefined) res['descr'] = this.descr
		if (this.note != undefined) res['note'] = this.note
		res['notes'] = this.notes.map((x0) => x0.toJSON() )
		res['relevant'] = this.relevant
		if (this.idOpeningContact != undefined) res['idOpeningContact'] = this.idOpeningContact
		if (this.idClosingContact != undefined) res['idClosingContact'] = this.idClosingContact
		if (this.idService != undefined) res['idService'] = this.idService
		if (this.laterality != undefined) res['laterality'] = this.laterality
		res['plansOfAction'] = this.plansOfAction.map((x0) => x0.toJSON() )
		res['episodes'] = this.episodes.map((x0) => x0.toJSON() )
		res['careTeam'] = this.careTeam.map((x0) => x0.toJSON() )
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
			path: Array<string> = ['EncryptedHealthElement']): EncryptedHealthElement {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedHealthElement`)
		const res = new EncryptedHealthElement({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			identifiers: expectArray(extractEntry(jCpy, 'identifiers', false, path), false, [...path, ".identifiers"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Identifier.fromJSON)),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			endOfLife: expectNumber(extractEntry(jCpy, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			healthElementId: expectString(extractEntry(jCpy, 'healthElementId', false, path), true, [...path, ".healthElementId"]),
			valueDate: expectNumber(extractEntry(jCpy, 'valueDate', false, path), true, true, [...path, ".valueDate"]),
			openingDate: expectNumber(extractEntry(jCpy, 'openingDate', false, path), true, true, [...path, ".openingDate"]),
			closingDate: expectNumber(extractEntry(jCpy, 'closingDate', false, path), true, true, [...path, ".closingDate"]),
			descr: expectString(extractEntry(jCpy, 'descr', false, path), true, [...path, ".descr"]),
			note: expectString(extractEntry(jCpy, 'note', false, path), true, [...path, ".note"]),
			notes: expectArray(extractEntry(jCpy, 'notes', false, path), false, [...path, ".notes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Annotation.fromJSON)),
			relevant: expectBoolean(extractEntry(jCpy, 'relevant', false, path), false, [...path, ".relevant"]),
			idOpeningContact: expectString(extractEntry(jCpy, 'idOpeningContact', false, path), true, [...path, ".idOpeningContact"]),
			idClosingContact: expectString(extractEntry(jCpy, 'idClosingContact', false, path), true, [...path, ".idClosingContact"]),
			idService: expectString(extractEntry(jCpy, 'idService', false, path), true, [...path, ".idService"]),
			laterality: expectStringEnum(extractEntry(jCpy, 'laterality', false, path), true, [...path, ".laterality"], Laterality, 'Laterality'),
			plansOfAction: expectArray(extractEntry(jCpy, 'plansOfAction', false, path), false, [...path, ".plansOfAction"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, EncryptedPlanOfAction.fromJSON)),
			episodes: expectArray(extractEntry(jCpy, 'episodes', false, path), false, [...path, ".episodes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, EncryptedEpisode.fromJSON)),
			careTeam: expectArray(extractEntry(jCpy, 'careTeam', false, path), false, [...path, ".careTeam"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, EncryptedCareTeamMember.fromJSON)),
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
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedHealthElement at path ${path.join("")}: ${unused}`)}
		return res
	}

}
