// auto-generated file
import {expectArray, expectNumber, expectObject, expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {Identifiable} from './base/Identifiable.mjs';
import {Named} from './base/Named.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {DatabaseSynchronization} from './embed/DatabaseSynchronization.mjs';


export class Replication implements StoredDocument, Identifiable<string>, Named {

	id: string;

	rev: string | undefined = undefined;

	deletionDate: number | undefined = undefined;

	name: string | undefined = undefined;

	context: string | undefined = undefined;

	databaseSynchronizations: Array<DatabaseSynchronization> = [];

	constructor(partial: Partial<Replication>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('name' in partial) this.name = partial.name;
		if ('context' in partial) this.context = partial.context;
		if ('databaseSynchronizations' in partial && partial.databaseSynchronizations !== undefined) this.databaseSynchronizations = partial.databaseSynchronizations;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.name != undefined) res['name'] = this.name
		if (this.context != undefined) res['context'] = this.context
		res['databaseSynchronizations'] = this.databaseSynchronizations.map((x0) => x0.toJSON() )
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Replication']): Replication {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Replication({
			id: expectString(extractEntry(jCpy.id, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy.rev, 'rev', false, path), true, [...path, ".rev"]),
			deletionDate: expectNumber(extractEntry(jCpy.deletionDate, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			name: expectString(extractEntry(jCpy.name, 'name', false, path), true, [...path, ".name"]),
			context: expectString(extractEntry(jCpy.context, 'context', false, path), true, [...path, ".context"]),
			databaseSynchronizations: expectArray(extractEntry(jCpy.databaseSynchronizations, 'databaseSynchronizations', false, path), false, [...path, ".databaseSynchronizations"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DatabaseSynchronization.fromJSON)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Replication at path ${path.join("")}: ${unused}`)}
		return res
	}

}
