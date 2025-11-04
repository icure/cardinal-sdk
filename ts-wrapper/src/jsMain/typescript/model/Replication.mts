// auto-generated file
import {expectArray, expectNumber, expectString, requireEntry} from '../internal/JsonDecodeUtils.mjs';
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

	static fromJSON(json: any, path: Array<string> = ['Replication']): Replication {
		return new Replication({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			rev: expectString(json.rev, true, [...path, ".rev"]),
			deletionDate: expectNumber(json.deletionDate, true, true, [...path, ".deletionDate"]),
			name: expectString(json.name, true, [...path, ".name"]),
			context: expectString(json.context, true, [...path, ".context"]),
			databaseSynchronizations: expectArray(json.databaseSynchronizations, false, [...path, ".databaseSynchronizations"], (x0, p0) => DatabaseSynchronization.fromJSON(x0, p0)),
		})
	}

}
