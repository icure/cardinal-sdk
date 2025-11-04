// auto-generated file
import {expectArray, expectString} from '../internal/JsonDecodeUtils.mjs';
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

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.users != undefined) res['users'] = this.users.map((x0) => x0.toJSON() )
		if (this.healthcareParties != undefined) res['healthcareParties'] = this.healthcareParties.map((x0) => x0.toJSON() )
		if (this.replication != undefined) res['replication'] = this.replication.toJSON()
		if (this.minimumKrakenVersion != undefined) res['minimumKrakenVersion'] = this.minimumKrakenVersion
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['DatabaseInitialisation']): DatabaseInitialisation {
		return new DatabaseInitialisation({
			users: expectArray(json.users, true, [...path, ".users"], (x0, p0) => User.fromJSON(x0, p0)),
			healthcareParties: expectArray(json.healthcareParties, true, [...path, ".healthcareParties"], (x0, p0) => HealthcareParty.fromJSON(x0, p0)),
			replication: Replication.fromJSON(json.replication, [...path, ".replication"]),
			minimumKrakenVersion: expectString(json.minimumKrakenVersion, true, [...path, ".minimumKrakenVersion"]),
		})
	}

}
