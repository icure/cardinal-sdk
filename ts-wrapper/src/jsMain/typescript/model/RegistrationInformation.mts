// auto-generated file
import {expectArray, expectString, requireEntry} from '../internal/JsonDecodeUtils.mjs';


export class RegistrationInformation {

	applicationId: string | undefined = undefined;

	firstName: string | undefined = undefined;

	lastName: string | undefined = undefined;

	companyName: string | undefined = undefined;

	emailAddress: string;

	userOptions: string | undefined = undefined;

	userRoles: Array<string> = [];

	minimumKrakenVersion: string | undefined = undefined;

	cluster: string | undefined = undefined;

	constructor(partial: Partial<RegistrationInformation> & Pick<RegistrationInformation, "emailAddress">) {
		if ('applicationId' in partial) this.applicationId = partial.applicationId;
		if ('firstName' in partial) this.firstName = partial.firstName;
		if ('lastName' in partial) this.lastName = partial.lastName;
		if ('companyName' in partial) this.companyName = partial.companyName;
		this.emailAddress = partial.emailAddress;
		if ('userOptions' in partial) this.userOptions = partial.userOptions;
		if ('userRoles' in partial && partial.userRoles !== undefined) this.userRoles = partial.userRoles;
		if ('minimumKrakenVersion' in partial) this.minimumKrakenVersion = partial.minimumKrakenVersion;
		if ('cluster' in partial) this.cluster = partial.cluster;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.applicationId != undefined) res['applicationId'] = this.applicationId
		if (this.firstName != undefined) res['firstName'] = this.firstName
		if (this.lastName != undefined) res['lastName'] = this.lastName
		if (this.companyName != undefined) res['companyName'] = this.companyName
		res['emailAddress'] = this.emailAddress
		if (this.userOptions != undefined) res['userOptions'] = this.userOptions
		res['userRoles'] = this.userRoles.map((x0) => x0 )
		if (this.minimumKrakenVersion != undefined) res['minimumKrakenVersion'] = this.minimumKrakenVersion
		if (this.cluster != undefined) res['cluster'] = this.cluster
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['RegistrationInformation']): RegistrationInformation {
		return new RegistrationInformation({
			applicationId: expectString(json.applicationId, true, [...path, ".applicationId"]),
			firstName: expectString(json.firstName, true, [...path, ".firstName"]),
			lastName: expectString(json.lastName, true, [...path, ".lastName"]),
			companyName: expectString(json.companyName, true, [...path, ".companyName"]),
			emailAddress: expectString(requireEntry(json.emailAddress, 'emailAddress', path), false, [...path, ".emailAddress"]),
			userOptions: expectString(json.userOptions, true, [...path, ".userOptions"]),
			userRoles: expectArray(json.userRoles, false, [...path, ".userRoles"], (x0, p0) => expectString(x0, false, p0)),
			minimumKrakenVersion: expectString(json.minimumKrakenVersion, true, [...path, ".minimumKrakenVersion"]),
			cluster: expectString(json.cluster, true, [...path, ".cluster"]),
		})
	}

}
