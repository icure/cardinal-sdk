// auto-generated file
import {expectArray, expectNumber, expectObject, expectString, expectStringEnum, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {DecryptedPropertyStub} from './PropertyStub.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {FrontEndMigrationStatus} from './embed/FrontEndMigrationStatus.mjs';


/**
 *
 *  Represents a front-end migration task. A front-end migration tracks the progress of data
 *  migration operations
 *  initiated from the front-end application.
 *  /
 */
export class FrontEndMigration implements StoredDocument {

	/**
	 *
	 *  The unique identifier of the front-end migration.
	 */
	id: string;

	/**
	 *
	 *  The revision of the front-end migration in the database, used for conflict management /
	 *  optimistic locking.
	 */
	rev: string | undefined = undefined;

	/**
	 *
	 *  Hard delete (unix epoch in ms) timestamp of the object.
	 */
	deletionDate: number | undefined = undefined;

	/**
	 *
	 *  The name of the migration.
	 */
	name: string | undefined = undefined;

	/**
	 *
	 *  The start date (unix epoch in ms) of the migration.
	 */
	startDate: number | undefined = undefined;

	/**
	 *
	 *  The end date (unix epoch in ms) of the migration.
	 */
	endDate: number | undefined = undefined;

	/**
	 *
	 *  The current status of the migration.
	 */
	status: FrontEndMigrationStatus | undefined = undefined;

	/**
	 *
	 *  Logs produced during the migration process.
	 */
	logs: string | undefined = undefined;

	/**
	 *
	 *  The id of the user that initiated the migration.
	 */
	userId: string | undefined = undefined;

	/**
	 *
	 *  The start key used for pagination during migration.
	 */
	startKey: string | undefined = undefined;

	/**
	 *
	 *  The start key document id used for pagination during migration.
	 */
	startKeyDocId: string | undefined = undefined;

	/**
	 *
	 *  The number of items processed during the migration.
	 */
	processCount: number | undefined = undefined;

	/**
	 *
	 *  Extra properties for the front-end migration. Those properties are typed (see class Property).
	 */
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

	toJSON(): object {
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
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			name: expectString(extractEntry(jCpy, 'name', false, path), true, [...path, ".name"]),
			startDate: expectNumber(extractEntry(jCpy, 'startDate', false, path), true, true, [...path, ".startDate"]),
			endDate: expectNumber(extractEntry(jCpy, 'endDate', false, path), true, true, [...path, ".endDate"]),
			status: expectStringEnum(extractEntry(jCpy, 'status', false, path), true, [...path, ".status"], FrontEndMigrationStatus, 'FrontEndMigrationStatus'),
			logs: expectString(extractEntry(jCpy, 'logs', false, path), true, [...path, ".logs"]),
			userId: expectString(extractEntry(jCpy, 'userId', false, path), true, [...path, ".userId"]),
			startKey: expectString(extractEntry(jCpy, 'startKey', false, path), true, [...path, ".startKey"]),
			startKeyDocId: expectString(extractEntry(jCpy, 'startKeyDocId', false, path), true, [...path, ".startKeyDocId"]),
			processCount: expectNumber(extractEntry(jCpy, 'processCount', false, path), true, true, [...path, ".processCount"]),
			properties: expectArray(extractEntry(jCpy, 'properties', false, path), false, [...path, ".properties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedPropertyStub.fromJSON)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object FrontEndMigration at path ${path.join("")}: ${unused}`)}
		return res
	}

}
