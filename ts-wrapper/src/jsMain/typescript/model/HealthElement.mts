// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectString, expectStringEnum, requireEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
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


export interface HealthElement extends StoredDocument, ICureDocument<string>, HasEncryptionMetadata, Encryptable {

	identifiers: Array<Identifier>;

	healthElementId: string | undefined;

	valueDate: number | undefined;

	openingDate: number | undefined;

	closingDate: number | undefined;

	descr: string | undefined;

	note: string | undefined;

	notes: Array<Annotation>;

	relevant: boolean;

	idOpeningContact: string | undefined;

	idClosingContact: string | undefined;

	idService: string | undefined;

	status: number;

	laterality: Laterality | undefined;

	plansOfAction: Array<PlanOfAction>;

	episodes: Array<Episode>;

	careTeam: Array<CareTeamMember>;

	readonly isEncrypted: boolean;

}

export class DecryptedHealthElement {

	id: string;

	identifiers: Array<Identifier> = [];

	rev: string | undefined = undefined;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	medicalLocationId: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	endOfLife: number | undefined = undefined;

	deletionDate: number | undefined = undefined;

	healthElementId: string | undefined = undefined;

	valueDate: number | undefined = undefined;

	openingDate: number | undefined = undefined;

	closingDate: number | undefined = undefined;

	descr: string | undefined = undefined;

	note: string | undefined = undefined;

	notes: Array<Annotation> = [];

	relevant: boolean = true;

	idOpeningContact: string | undefined = undefined;

	idClosingContact: string | undefined = undefined;

	idService: string | undefined = undefined;

	status: number = 0;

	laterality: Laterality | undefined = undefined;

	plansOfAction: Array<DecryptedPlanOfAction> = [];

	episodes: Array<DecryptedEpisode> = [];

	careTeam: Array<DecryptedCareTeamMember> = [];

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

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
		if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
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
		if ('status' in partial && partial.status !== undefined) this.status = partial.status;
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

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		res['identifiers'] = this.identifiers.map((x0) => x0.toJSON() )
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		if (this.medicalLocationId != undefined) res['medicalLocationId'] = this.medicalLocationId
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
		res['status'] = this.status
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
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['DecryptedHealthElement']): DecryptedHealthElement {
		return new DecryptedHealthElement({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			identifiers: expectArray(json.identifiers, false, [...path, ".identifiers"], (x0, p0) => Identifier.fromJSON(x0, p0)),
			rev: expectString(json.rev, true, [...path, ".rev"]),
			created: expectNumber(json.created, true, true, [...path, ".created"]),
			modified: expectNumber(json.modified, true, true, [...path, ".modified"]),
			author: expectString(json.author, true, [...path, ".author"]),
			responsible: expectString(json.responsible, true, [...path, ".responsible"]),
			medicalLocationId: expectString(json.medicalLocationId, true, [...path, ".medicalLocationId"]),
			tags: expectArray(json.tags, false, [...path, ".tags"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			codes: expectArray(json.codes, false, [...path, ".codes"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			endOfLife: expectNumber(json.endOfLife, true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(json.deletionDate, true, true, [...path, ".deletionDate"]),
			healthElementId: expectString(json.healthElementId, true, [...path, ".healthElementId"]),
			valueDate: expectNumber(json.valueDate, true, true, [...path, ".valueDate"]),
			openingDate: expectNumber(json.openingDate, true, true, [...path, ".openingDate"]),
			closingDate: expectNumber(json.closingDate, true, true, [...path, ".closingDate"]),
			descr: expectString(json.descr, true, [...path, ".descr"]),
			note: expectString(json.note, true, [...path, ".note"]),
			notes: expectArray(json.notes, false, [...path, ".notes"], (x0, p0) => Annotation.fromJSON(x0, p0)),
			relevant: expectBoolean(json.relevant, false, [...path, ".relevant"]),
			idOpeningContact: expectString(json.idOpeningContact, true, [...path, ".idOpeningContact"]),
			idClosingContact: expectString(json.idClosingContact, true, [...path, ".idClosingContact"]),
			idService: expectString(json.idService, true, [...path, ".idService"]),
			status: expectNumber(json.status, false, true, [...path, ".status"]),
			laterality: expectStringEnum(json.laterality, true, [...path, ".laterality"], Laterality, 'Laterality'),
			plansOfAction: expectArray(json.plansOfAction, false, [...path, ".plansOfAction"], (x0, p0) => DecryptedPlanOfAction.fromJSON(x0, p0)),
			episodes: expectArray(json.episodes, false, [...path, ".episodes"], (x0, p0) => DecryptedEpisode.fromJSON(x0, p0)),
			careTeam: expectArray(json.careTeam, false, [...path, ".careTeam"], (x0, p0) => DecryptedCareTeamMember.fromJSON(x0, p0)),
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
		})
	}

}

export class EncryptedHealthElement {

	id: string;

	identifiers: Array<Identifier> = [];

	rev: string | undefined = undefined;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	medicalLocationId: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	endOfLife: number | undefined = undefined;

	deletionDate: number | undefined = undefined;

	healthElementId: string | undefined = undefined;

	valueDate: number | undefined = undefined;

	openingDate: number | undefined = undefined;

	closingDate: number | undefined = undefined;

	descr: string | undefined = undefined;

	note: string | undefined = undefined;

	notes: Array<Annotation> = [];

	relevant: boolean = true;

	idOpeningContact: string | undefined = undefined;

	idClosingContact: string | undefined = undefined;

	idService: string | undefined = undefined;

	status: number = 0;

	laterality: Laterality | undefined = undefined;

	plansOfAction: Array<EncryptedPlanOfAction> = [];

	episodes: Array<EncryptedEpisode> = [];

	careTeam: Array<EncryptedCareTeamMember> = [];

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

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
		if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
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
		if ('status' in partial && partial.status !== undefined) this.status = partial.status;
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

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		res['identifiers'] = this.identifiers.map((x0) => x0.toJSON() )
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		if (this.medicalLocationId != undefined) res['medicalLocationId'] = this.medicalLocationId
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
		res['status'] = this.status
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
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['EncryptedHealthElement']): EncryptedHealthElement {
		return new EncryptedHealthElement({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			identifiers: expectArray(json.identifiers, false, [...path, ".identifiers"], (x0, p0) => Identifier.fromJSON(x0, p0)),
			rev: expectString(json.rev, true, [...path, ".rev"]),
			created: expectNumber(json.created, true, true, [...path, ".created"]),
			modified: expectNumber(json.modified, true, true, [...path, ".modified"]),
			author: expectString(json.author, true, [...path, ".author"]),
			responsible: expectString(json.responsible, true, [...path, ".responsible"]),
			medicalLocationId: expectString(json.medicalLocationId, true, [...path, ".medicalLocationId"]),
			tags: expectArray(json.tags, false, [...path, ".tags"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			codes: expectArray(json.codes, false, [...path, ".codes"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			endOfLife: expectNumber(json.endOfLife, true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(json.deletionDate, true, true, [...path, ".deletionDate"]),
			healthElementId: expectString(json.healthElementId, true, [...path, ".healthElementId"]),
			valueDate: expectNumber(json.valueDate, true, true, [...path, ".valueDate"]),
			openingDate: expectNumber(json.openingDate, true, true, [...path, ".openingDate"]),
			closingDate: expectNumber(json.closingDate, true, true, [...path, ".closingDate"]),
			descr: expectString(json.descr, true, [...path, ".descr"]),
			note: expectString(json.note, true, [...path, ".note"]),
			notes: expectArray(json.notes, false, [...path, ".notes"], (x0, p0) => Annotation.fromJSON(x0, p0)),
			relevant: expectBoolean(json.relevant, false, [...path, ".relevant"]),
			idOpeningContact: expectString(json.idOpeningContact, true, [...path, ".idOpeningContact"]),
			idClosingContact: expectString(json.idClosingContact, true, [...path, ".idClosingContact"]),
			idService: expectString(json.idService, true, [...path, ".idService"]),
			status: expectNumber(json.status, false, true, [...path, ".status"]),
			laterality: expectStringEnum(json.laterality, true, [...path, ".laterality"], Laterality, 'Laterality'),
			plansOfAction: expectArray(json.plansOfAction, false, [...path, ".plansOfAction"], (x0, p0) => EncryptedPlanOfAction.fromJSON(x0, p0)),
			episodes: expectArray(json.episodes, false, [...path, ".episodes"], (x0, p0) => EncryptedEpisode.fromJSON(x0, p0)),
			careTeam: expectArray(json.careTeam, false, [...path, ".careTeam"], (x0, p0) => EncryptedCareTeamMember.fromJSON(x0, p0)),
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
		})
	}

}
