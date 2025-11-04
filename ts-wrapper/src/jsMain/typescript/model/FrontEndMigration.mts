// auto-generated file
import {expectArray, expectNumber, expectObject, expectString, expectStringEnum, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {DecryptedPropertyStub} from './PropertyStub.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {FrontEndMigrationStatus} from './embed/FrontEndMigrationStatus.mjs';


export class FrontEndMigration implements StoredDocument {

	id: string;

	rev: string | undefined = undefined;

	deletionDate: number | undefined = undefined;

	name: string | undefined = undefined;

	startDate: number | undefined = undefined;

	endDate: number | undefined = undefined;

	status: FrontEndMigrationStatus | undefined = undefined;

	logs: string | undefined = undefined;

	userId: string | undefined = undefined;

	startKey: string | undefined = undefined;

	startKeyDocId: string | undefined = undefined;

	processCount: number | undefined = undefined;

	properties: Array<DecryptedPropertyStub> = [];

	constructor(partial: Partial<FrontEndMigration>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('name' in partial) this.name = partial.name;
		if ('startDate' in partial) this.startDate = partial.startDate;
		if ('endDate' in partial) this.endDate = partial.endDate;
		if ('status' in partial) this.status = partial.status;
		if ('logs' in partial) this.logs = partial.logs;
		if ('userId' in partial) this.userId = partial.userId;
		if ('startKey' in partial) this.startKey = partial.startKey;
		if ('startKeyDocId' in partial) this.startKeyDocId = partial.startKeyDocId;
		if ('processCount' in partial) this.processCount = partial.processCount;
		if ('properties' in partial && partial.properties !== undefined) this.properties = partial.properties;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.name != undefined) res['name'] = this.name
		if (this.startDate != undefined) res['startDate'] = this.startDate
		if (this.endDate != undefined) res['endDate'] = this.endDate
		if (this.status != undefined) res['status'] = this.status
		if (this.logs != undefined) res['logs'] = this.logs
		if (this.userId != undefined) res['userId'] = this.userId
		if (this.startKey != undefined) res['startKey'] = this.startKey
		if (this.startKeyDocId != undefined) res['startKeyDocId'] = this.startKeyDocId
		if (this.processCount != undefined) res['processCount'] = this.processCount
		res['properties'] = this.properties.map((x0) => x0.toJSON() )
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['FrontEndMigration']): FrontEndMigration {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new FrontEndMigration({
			id: expectString(extractEntry(jCpy.id, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy.rev, 'rev', false, path), true, [...path, ".rev"]),
			deletionDate: expectNumber(extractEntry(jCpy.deletionDate, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			name: expectString(extractEntry(jCpy.name, 'name', false, path), true, [...path, ".name"]),
			startDate: expectNumber(extractEntry(jCpy.startDate, 'startDate', false, path), true, true, [...path, ".startDate"]),
			endDate: expectNumber(extractEntry(jCpy.endDate, 'endDate', false, path), true, true, [...path, ".endDate"]),
			status: expectStringEnum(extractEntry(jCpy.status, 'status', false, path), true, [...path, ".status"], FrontEndMigrationStatus, 'FrontEndMigrationStatus'),
			logs: expectString(extractEntry(jCpy.logs, 'logs', false, path), true, [...path, ".logs"]),
			userId: expectString(extractEntry(jCpy.userId, 'userId', false, path), true, [...path, ".userId"]),
			startKey: expectString(extractEntry(jCpy.startKey, 'startKey', false, path), true, [...path, ".startKey"]),
			startKeyDocId: expectString(extractEntry(jCpy.startKeyDocId, 'startKeyDocId', false, path), true, [...path, ".startKeyDocId"]),
			processCount: expectNumber(extractEntry(jCpy.processCount, 'processCount', false, path), true, true, [...path, ".processCount"]),
			properties: expectArray(extractEntry(jCpy.properties, 'properties', false, path), false, [...path, ".properties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedPropertyStub.fromJSON)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object FrontEndMigration at path ${path.join("")}: ${unused}`)}
		return res
	}

}
