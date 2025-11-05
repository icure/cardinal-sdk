// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectObject, expectString, expectStringEnum, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {CalendarItem as CalendarItem_} from './CalendarItem.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {Address, DecryptedAddress, EncryptedAddress} from './embed/Address.mjs';
import {CalendarItemTag, DecryptedCalendarItemTag, EncryptedCalendarItemTag} from './embed/CalendarItemTag.mjs';
import {Delegation} from './embed/Delegation.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {FlowItem} from './embed/FlowItem.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';
import {Base64String} from './specializations/Base64String.mjs';


export interface CalendarItem extends StoredDocument, ICureDocument<string>, HasEncryptionMetadata, Encryptable {

	title: string | undefined;

	calendarItemTypeId: string | undefined;

	masterCalendarItemId: string | undefined;

	patientId: string | undefined;

	important: boolean | undefined;

	homeVisit: boolean | undefined;

	phoneNumber: string | undefined;

	placeId: string | undefined;

	address: Address | undefined;

	addressText: string | undefined;

	startTime: number | undefined;

	endTime: number | undefined;

	confirmationTime: number | undefined;

	cancellationTimestamp: number | undefined;

	confirmationId: string | undefined;

	duration: number | undefined;

	allDay: boolean | undefined;

	details: string | undefined;

	wasMigrated: boolean | undefined;

	agendaId: string | undefined;

	resourceGroup: CodeStub | undefined;

	availabilitiesAssignmentStrategy: CalendarItem.AvailabilitiesAssignmentStrategy | undefined;

	hcpId: string | undefined;

	recurrenceId: string | undefined;

	meetingTags: Array<CalendarItemTag>;

	flowItem: FlowItem | undefined;

	readonly isEncrypted: boolean;

}

export class DecryptedCalendarItem {

	id: string;

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

	title: string | undefined = undefined;

	calendarItemTypeId: string | undefined = undefined;

	masterCalendarItemId: string | undefined = undefined;

	patientId: string | undefined = undefined;

	important: boolean | undefined = undefined;

	homeVisit: boolean | undefined = undefined;

	phoneNumber: string | undefined = undefined;

	placeId: string | undefined = undefined;

	address: DecryptedAddress | undefined = undefined;

	addressText: string | undefined = undefined;

	startTime: number | undefined = undefined;

	endTime: number | undefined = undefined;

	confirmationTime: number | undefined = undefined;

	cancellationTimestamp: number | undefined = undefined;

	confirmationId: string | undefined = undefined;

	duration: number | undefined = undefined;

	allDay: boolean | undefined = undefined;

	details: string | undefined = undefined;

	wasMigrated: boolean | undefined = undefined;

	agendaId: string | undefined = undefined;

	resourceGroup: CodeStub | undefined = undefined;

	availabilitiesAssignmentStrategy: CalendarItem_.AvailabilitiesAssignmentStrategy | undefined = undefined;

	hcpId: string | undefined = undefined;

	recurrenceId: string | undefined = undefined;

	meetingTags: Array<DecryptedCalendarItemTag> = [];

	flowItem: FlowItem | undefined = undefined;

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

	securityMetadata: SecurityMetadata | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedCalendarItem>) {
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
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('title' in partial) this.title = partial.title;
		if ('calendarItemTypeId' in partial) this.calendarItemTypeId = partial.calendarItemTypeId;
		if ('masterCalendarItemId' in partial) this.masterCalendarItemId = partial.masterCalendarItemId;
		if ('patientId' in partial) this.patientId = partial.patientId;
		if ('important' in partial) this.important = partial.important;
		if ('homeVisit' in partial) this.homeVisit = partial.homeVisit;
		if ('phoneNumber' in partial) this.phoneNumber = partial.phoneNumber;
		if ('placeId' in partial) this.placeId = partial.placeId;
		if ('address' in partial) this.address = partial.address;
		if ('addressText' in partial) this.addressText = partial.addressText;
		if ('startTime' in partial) this.startTime = partial.startTime;
		if ('endTime' in partial) this.endTime = partial.endTime;
		if ('confirmationTime' in partial) this.confirmationTime = partial.confirmationTime;
		if ('cancellationTimestamp' in partial) this.cancellationTimestamp = partial.cancellationTimestamp;
		if ('confirmationId' in partial) this.confirmationId = partial.confirmationId;
		if ('duration' in partial) this.duration = partial.duration;
		if ('allDay' in partial) this.allDay = partial.allDay;
		if ('details' in partial) this.details = partial.details;
		if ('wasMigrated' in partial) this.wasMigrated = partial.wasMigrated;
		if ('agendaId' in partial) this.agendaId = partial.agendaId;
		if ('resourceGroup' in partial) this.resourceGroup = partial.resourceGroup;
		if ('availabilitiesAssignmentStrategy' in partial) this.availabilitiesAssignmentStrategy = partial.availabilitiesAssignmentStrategy;
		if ('hcpId' in partial) this.hcpId = partial.hcpId;
		if ('recurrenceId' in partial) this.recurrenceId = partial.recurrenceId;
		if ('meetingTags' in partial && partial.meetingTags !== undefined) this.meetingTags = partial.meetingTags;
		if ('flowItem' in partial) this.flowItem = partial.flowItem;
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
		if (this.title != undefined) res['title'] = this.title
		if (this.calendarItemTypeId != undefined) res['calendarItemTypeId'] = this.calendarItemTypeId
		if (this.masterCalendarItemId != undefined) res['masterCalendarItemId'] = this.masterCalendarItemId
		if (this.patientId != undefined) res['patientId'] = this.patientId
		if (this.important != undefined) res['important'] = this.important
		if (this.homeVisit != undefined) res['homeVisit'] = this.homeVisit
		if (this.phoneNumber != undefined) res['phoneNumber'] = this.phoneNumber
		if (this.placeId != undefined) res['placeId'] = this.placeId
		if (this.address != undefined) res['address'] = this.address.toJSON()
		if (this.addressText != undefined) res['addressText'] = this.addressText
		if (this.startTime != undefined) res['startTime'] = this.startTime
		if (this.endTime != undefined) res['endTime'] = this.endTime
		if (this.confirmationTime != undefined) res['confirmationTime'] = this.confirmationTime
		if (this.cancellationTimestamp != undefined) res['cancellationTimestamp'] = this.cancellationTimestamp
		if (this.confirmationId != undefined) res['confirmationId'] = this.confirmationId
		if (this.duration != undefined) res['duration'] = this.duration
		if (this.allDay != undefined) res['allDay'] = this.allDay
		if (this.details != undefined) res['details'] = this.details
		if (this.wasMigrated != undefined) res['wasMigrated'] = this.wasMigrated
		if (this.agendaId != undefined) res['agendaId'] = this.agendaId
		if (this.resourceGroup != undefined) res['resourceGroup'] = this.resourceGroup.toJSON()
		if (this.availabilitiesAssignmentStrategy != undefined) res['availabilitiesAssignmentStrategy'] = this.availabilitiesAssignmentStrategy
		if (this.hcpId != undefined) res['hcpId'] = this.hcpId
		if (this.recurrenceId != undefined) res['recurrenceId'] = this.recurrenceId
		res['meetingTags'] = this.meetingTags.map((x0) => x0.toJSON() )
		if (this.flowItem != undefined) res['flowItem'] = this.flowItem.toJSON()
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
			path: Array<string> = ['DecryptedCalendarItem']): DecryptedCalendarItem {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false`)
		const res = new DecryptedCalendarItem({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			medicalLocationId: expectString(extractEntry(jCpy, 'medicalLocationId', false, path), true, [...path, ".medicalLocationId"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			endOfLife: expectNumber(extractEntry(jCpy, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			title: expectString(extractEntry(jCpy, 'title', false, path), true, [...path, ".title"]),
			calendarItemTypeId: expectString(extractEntry(jCpy, 'calendarItemTypeId', false, path), true, [...path, ".calendarItemTypeId"]),
			masterCalendarItemId: expectString(extractEntry(jCpy, 'masterCalendarItemId', false, path), true, [...path, ".masterCalendarItemId"]),
			patientId: expectString(extractEntry(jCpy, 'patientId', false, path), true, [...path, ".patientId"]),
			important: expectBoolean(extractEntry(jCpy, 'important', false, path), true, [...path, ".important"]),
			homeVisit: expectBoolean(extractEntry(jCpy, 'homeVisit', false, path), true, [...path, ".homeVisit"]),
			phoneNumber: expectString(extractEntry(jCpy, 'phoneNumber', false, path), true, [...path, ".phoneNumber"]),
			placeId: expectString(extractEntry(jCpy, 'placeId', false, path), true, [...path, ".placeId"]),
			address: expectObject(extractEntry(jCpy, 'address', false, path), true, ignoreUnknownKeys, [...path, ".address"], DecryptedAddress.fromJSON),
			addressText: expectString(extractEntry(jCpy, 'addressText', false, path), true, [...path, ".addressText"]),
			startTime: expectNumber(extractEntry(jCpy, 'startTime', false, path), true, true, [...path, ".startTime"]),
			endTime: expectNumber(extractEntry(jCpy, 'endTime', false, path), true, true, [...path, ".endTime"]),
			confirmationTime: expectNumber(extractEntry(jCpy, 'confirmationTime', false, path), true, true, [...path, ".confirmationTime"]),
			cancellationTimestamp: expectNumber(extractEntry(jCpy, 'cancellationTimestamp', false, path), true, true, [...path, ".cancellationTimestamp"]),
			confirmationId: expectString(extractEntry(jCpy, 'confirmationId', false, path), true, [...path, ".confirmationId"]),
			duration: expectNumber(extractEntry(jCpy, 'duration', false, path), true, true, [...path, ".duration"]),
			allDay: expectBoolean(extractEntry(jCpy, 'allDay', false, path), true, [...path, ".allDay"]),
			details: expectString(extractEntry(jCpy, 'details', false, path), true, [...path, ".details"]),
			wasMigrated: expectBoolean(extractEntry(jCpy, 'wasMigrated', false, path), true, [...path, ".wasMigrated"]),
			agendaId: expectString(extractEntry(jCpy, 'agendaId', false, path), true, [...path, ".agendaId"]),
			resourceGroup: expectObject(extractEntry(jCpy, 'resourceGroup', false, path), true, ignoreUnknownKeys, [...path, ".resourceGroup"], CodeStub.fromJSON),
			availabilitiesAssignmentStrategy: expectStringEnum(extractEntry(jCpy, 'availabilitiesAssignmentStrategy', false, path), true, [...path, ".availabilitiesAssignmentStrategy"], CalendarItem_.AvailabilitiesAssignmentStrategy, 'CalendarItem.AvailabilitiesAssignmentStrategy'),
			hcpId: expectString(extractEntry(jCpy, 'hcpId', false, path), true, [...path, ".hcpId"]),
			recurrenceId: expectString(extractEntry(jCpy, 'recurrenceId', false, path), true, [...path, ".recurrenceId"]),
			meetingTags: expectArray(extractEntry(jCpy, 'meetingTags', false, path), false, [...path, ".meetingTags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedCalendarItemTag.fromJSON)),
			flowItem: expectObject(extractEntry(jCpy, 'flowItem', false, path), true, ignoreUnknownKeys, [...path, ".flowItem"], FlowItem.fromJSON),
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
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), false, [...path, ".encryptedSelf"]),
			securityMetadata: expectObject(extractEntry(jCpy, 'securityMetadata', false, path), true, ignoreUnknownKeys, [...path, ".securityMetadata"], SecurityMetadata.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedCalendarItem at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export class EncryptedCalendarItem {

	id: string;

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

	title: string | undefined = undefined;

	calendarItemTypeId: string | undefined = undefined;

	masterCalendarItemId: string | undefined = undefined;

	patientId: string | undefined = undefined;

	important: boolean | undefined = undefined;

	homeVisit: boolean | undefined = undefined;

	phoneNumber: string | undefined = undefined;

	placeId: string | undefined = undefined;

	address: EncryptedAddress | undefined = undefined;

	addressText: string | undefined = undefined;

	startTime: number | undefined = undefined;

	endTime: number | undefined = undefined;

	confirmationTime: number | undefined = undefined;

	cancellationTimestamp: number | undefined = undefined;

	confirmationId: string | undefined = undefined;

	duration: number | undefined = undefined;

	allDay: boolean | undefined = undefined;

	details: string | undefined = undefined;

	wasMigrated: boolean | undefined = undefined;

	agendaId: string | undefined = undefined;

	resourceGroup: CodeStub | undefined = undefined;

	availabilitiesAssignmentStrategy: CalendarItem_.AvailabilitiesAssignmentStrategy | undefined = undefined;

	hcpId: string | undefined = undefined;

	recurrenceId: string | undefined = undefined;

	meetingTags: Array<EncryptedCalendarItemTag> = [];

	flowItem: FlowItem | undefined = undefined;

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

	securityMetadata: SecurityMetadata | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedCalendarItem>) {
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
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('title' in partial) this.title = partial.title;
		if ('calendarItemTypeId' in partial) this.calendarItemTypeId = partial.calendarItemTypeId;
		if ('masterCalendarItemId' in partial) this.masterCalendarItemId = partial.masterCalendarItemId;
		if ('patientId' in partial) this.patientId = partial.patientId;
		if ('important' in partial) this.important = partial.important;
		if ('homeVisit' in partial) this.homeVisit = partial.homeVisit;
		if ('phoneNumber' in partial) this.phoneNumber = partial.phoneNumber;
		if ('placeId' in partial) this.placeId = partial.placeId;
		if ('address' in partial) this.address = partial.address;
		if ('addressText' in partial) this.addressText = partial.addressText;
		if ('startTime' in partial) this.startTime = partial.startTime;
		if ('endTime' in partial) this.endTime = partial.endTime;
		if ('confirmationTime' in partial) this.confirmationTime = partial.confirmationTime;
		if ('cancellationTimestamp' in partial) this.cancellationTimestamp = partial.cancellationTimestamp;
		if ('confirmationId' in partial) this.confirmationId = partial.confirmationId;
		if ('duration' in partial) this.duration = partial.duration;
		if ('allDay' in partial) this.allDay = partial.allDay;
		if ('details' in partial) this.details = partial.details;
		if ('wasMigrated' in partial) this.wasMigrated = partial.wasMigrated;
		if ('agendaId' in partial) this.agendaId = partial.agendaId;
		if ('resourceGroup' in partial) this.resourceGroup = partial.resourceGroup;
		if ('availabilitiesAssignmentStrategy' in partial) this.availabilitiesAssignmentStrategy = partial.availabilitiesAssignmentStrategy;
		if ('hcpId' in partial) this.hcpId = partial.hcpId;
		if ('recurrenceId' in partial) this.recurrenceId = partial.recurrenceId;
		if ('meetingTags' in partial && partial.meetingTags !== undefined) this.meetingTags = partial.meetingTags;
		if ('flowItem' in partial) this.flowItem = partial.flowItem;
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
		if (this.title != undefined) res['title'] = this.title
		if (this.calendarItemTypeId != undefined) res['calendarItemTypeId'] = this.calendarItemTypeId
		if (this.masterCalendarItemId != undefined) res['masterCalendarItemId'] = this.masterCalendarItemId
		if (this.patientId != undefined) res['patientId'] = this.patientId
		if (this.important != undefined) res['important'] = this.important
		if (this.homeVisit != undefined) res['homeVisit'] = this.homeVisit
		if (this.phoneNumber != undefined) res['phoneNumber'] = this.phoneNumber
		if (this.placeId != undefined) res['placeId'] = this.placeId
		if (this.address != undefined) res['address'] = this.address.toJSON()
		if (this.addressText != undefined) res['addressText'] = this.addressText
		if (this.startTime != undefined) res['startTime'] = this.startTime
		if (this.endTime != undefined) res['endTime'] = this.endTime
		if (this.confirmationTime != undefined) res['confirmationTime'] = this.confirmationTime
		if (this.cancellationTimestamp != undefined) res['cancellationTimestamp'] = this.cancellationTimestamp
		if (this.confirmationId != undefined) res['confirmationId'] = this.confirmationId
		if (this.duration != undefined) res['duration'] = this.duration
		if (this.allDay != undefined) res['allDay'] = this.allDay
		if (this.details != undefined) res['details'] = this.details
		if (this.wasMigrated != undefined) res['wasMigrated'] = this.wasMigrated
		if (this.agendaId != undefined) res['agendaId'] = this.agendaId
		if (this.resourceGroup != undefined) res['resourceGroup'] = this.resourceGroup.toJSON()
		if (this.availabilitiesAssignmentStrategy != undefined) res['availabilitiesAssignmentStrategy'] = this.availabilitiesAssignmentStrategy
		if (this.hcpId != undefined) res['hcpId'] = this.hcpId
		if (this.recurrenceId != undefined) res['recurrenceId'] = this.recurrenceId
		res['meetingTags'] = this.meetingTags.map((x0) => x0.toJSON() )
		if (this.flowItem != undefined) res['flowItem'] = this.flowItem.toJSON()
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
			path: Array<string> = ['EncryptedCalendarItem']): EncryptedCalendarItem {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true`)
		const res = new EncryptedCalendarItem({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			medicalLocationId: expectString(extractEntry(jCpy, 'medicalLocationId', false, path), true, [...path, ".medicalLocationId"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			endOfLife: expectNumber(extractEntry(jCpy, 'endOfLife', false, path), true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			title: expectString(extractEntry(jCpy, 'title', false, path), true, [...path, ".title"]),
			calendarItemTypeId: expectString(extractEntry(jCpy, 'calendarItemTypeId', false, path), true, [...path, ".calendarItemTypeId"]),
			masterCalendarItemId: expectString(extractEntry(jCpy, 'masterCalendarItemId', false, path), true, [...path, ".masterCalendarItemId"]),
			patientId: expectString(extractEntry(jCpy, 'patientId', false, path), true, [...path, ".patientId"]),
			important: expectBoolean(extractEntry(jCpy, 'important', false, path), true, [...path, ".important"]),
			homeVisit: expectBoolean(extractEntry(jCpy, 'homeVisit', false, path), true, [...path, ".homeVisit"]),
			phoneNumber: expectString(extractEntry(jCpy, 'phoneNumber', false, path), true, [...path, ".phoneNumber"]),
			placeId: expectString(extractEntry(jCpy, 'placeId', false, path), true, [...path, ".placeId"]),
			address: expectObject(extractEntry(jCpy, 'address', false, path), true, ignoreUnknownKeys, [...path, ".address"], EncryptedAddress.fromJSON),
			addressText: expectString(extractEntry(jCpy, 'addressText', false, path), true, [...path, ".addressText"]),
			startTime: expectNumber(extractEntry(jCpy, 'startTime', false, path), true, true, [...path, ".startTime"]),
			endTime: expectNumber(extractEntry(jCpy, 'endTime', false, path), true, true, [...path, ".endTime"]),
			confirmationTime: expectNumber(extractEntry(jCpy, 'confirmationTime', false, path), true, true, [...path, ".confirmationTime"]),
			cancellationTimestamp: expectNumber(extractEntry(jCpy, 'cancellationTimestamp', false, path), true, true, [...path, ".cancellationTimestamp"]),
			confirmationId: expectString(extractEntry(jCpy, 'confirmationId', false, path), true, [...path, ".confirmationId"]),
			duration: expectNumber(extractEntry(jCpy, 'duration', false, path), true, true, [...path, ".duration"]),
			allDay: expectBoolean(extractEntry(jCpy, 'allDay', false, path), true, [...path, ".allDay"]),
			details: expectString(extractEntry(jCpy, 'details', false, path), true, [...path, ".details"]),
			wasMigrated: expectBoolean(extractEntry(jCpy, 'wasMigrated', false, path), true, [...path, ".wasMigrated"]),
			agendaId: expectString(extractEntry(jCpy, 'agendaId', false, path), true, [...path, ".agendaId"]),
			resourceGroup: expectObject(extractEntry(jCpy, 'resourceGroup', false, path), true, ignoreUnknownKeys, [...path, ".resourceGroup"], CodeStub.fromJSON),
			availabilitiesAssignmentStrategy: expectStringEnum(extractEntry(jCpy, 'availabilitiesAssignmentStrategy', false, path), true, [...path, ".availabilitiesAssignmentStrategy"], CalendarItem_.AvailabilitiesAssignmentStrategy, 'CalendarItem.AvailabilitiesAssignmentStrategy'),
			hcpId: expectString(extractEntry(jCpy, 'hcpId', false, path), true, [...path, ".hcpId"]),
			recurrenceId: expectString(extractEntry(jCpy, 'recurrenceId', false, path), true, [...path, ".recurrenceId"]),
			meetingTags: expectArray(extractEntry(jCpy, 'meetingTags', false, path), false, [...path, ".meetingTags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, EncryptedCalendarItemTag.fromJSON)),
			flowItem: expectObject(extractEntry(jCpy, 'flowItem', false, path), true, ignoreUnknownKeys, [...path, ".flowItem"], FlowItem.fromJSON),
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
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), false, [...path, ".encryptedSelf"]),
			securityMetadata: expectObject(extractEntry(jCpy, 'securityMetadata', false, path), true, ignoreUnknownKeys, [...path, ".securityMetadata"], SecurityMetadata.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedCalendarItem at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export namespace CalendarItem {

	export enum AvailabilitiesAssignmentStrategy {
		Strict = "Strict",
		Loose = "Loose"
	}

}
