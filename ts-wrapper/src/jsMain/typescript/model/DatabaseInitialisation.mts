// auto-generated file
import {expectArray, expectObject, expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {HealthcareParty} from './HealthcareParty.mjs';
import {Replication} from './Replication.mjs';
import {User} from './User.mjs';


export class DatabaseInitialisation {

	users: Array<User> | undefined = [];

	healthcareParties: Array<HealthcareParty> | undefined = [];

	replication: Replication | undefined = undefined;

	minimumKrakenVersion: string | undefined = undefined;

	constructor(partial: Partial<DatabaseInitialisation>) {
		if ('users' in partial) this.users = partial.users;
		if ('healthcareParties' in partial) this.healthcareParties = partial.healthcareParties;
		if ('replication' in partial) this.replication = partial.replication;
		if ('minimumKrakenVersion' in partial) this.minimumKrakenVersion = partial.minimumKrakenVersion;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.users != undefined) res['users'] = this.users.map((x0) => x0.toJSON() )
		if (this.healthcareParties != undefined) res['healthcareParties'] = this.healthcareParties.map((x0) => x0.toJSON() )
		if (this.replication != undefined) res['replication'] = this.replication.toJSON()
		if (this.minimumKrakenVersion != undefined) res['minimumKrakenVersion'] = this.minimumKrakenVersion
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DatabaseInitialisation']): DatabaseInitialisation {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new DatabaseInitialisation({
			users: expectArray(extractEntry(jCpy, 'users', false, path), true, [...path, ".users"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, User.fromJSON)),
			healthcareParties: expectArray(extractEntry(jCpy, 'healthcareParties', false, path), true, [...path, ".healthcareParties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, HealthcareParty.fromJSON)),
			replication: expectObject(extractEntry(jCpy, 'replication', false, path), true, ignoreUnknownKeys, [...path, ".replication"], Replication.fromJSON),
			minimumKrakenVersion: expectString(extractEntry(jCpy, 'minimumKrakenVersion', false, path), true, [...path, ".minimumKrakenVersion"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DatabaseInitialisation at path ${path.join("")}: ${unused}`)}
		return res
	}

}
