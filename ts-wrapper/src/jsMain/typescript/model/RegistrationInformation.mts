// auto-generated file
import {expectArray, expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';


/**
 *
 *  DTO containing the information required to register a new user and group in the iCure platform.
 *  /
 */
export class RegistrationInformation {

	/**
	 *
	 *  The identifier of the application or project for this registration.
	 */
	projectId: string | undefined = undefined;

	/**
	 *
	 *  The first name of the person registering.
	 */
	firstName: string | undefined = undefined;

	/**
	 *
	 *  The last name of the person registering.
	 */
	lastName: string | undefined = undefined;

	/**
	 *
	 *  The name of the company or organization.
	 */
	companyName: string | undefined = undefined;

	/**
	 *
	 *  The email address of the person registering.
	 */
	emailAddress: string;

	/**
	 *
	 *  Additional user options serialized as a string.
	 */
	userOptions: string | undefined = undefined;

	/**
	 *
	 *  The set of roles to assign to the newly created user.
	 */
	userRoles: Array<string> = [];

	/**
	 *
	 *  The minimum required Kraken version for this registration.
	 */
	minimumKrakenVersion: string | undefined = undefined;

	/**
	 *
	 *  The target cluster for the registration.
	 */
	cluster: string | undefined = undefined;

	constructor(partial: Partial<RegistrationInformation> & Pick<RegistrationInformation, "emailAddress">) {
		if ('projectId' in partial) this.projectId = partial.projectId;
		if ('firstName' in partial) this.firstName = partial.firstName;
		if ('lastName' in partial) this.lastName = partial.lastName;
		if ('companyName' in partial) this.companyName = partial.companyName;
		this.emailAddress = partial.emailAddress;
		if ('userOptions' in partial) this.userOptions = partial.userOptions;
		if ('userRoles' in partial && partial.userRoles !== undefined) this.userRoles = partial.userRoles;
		if ('minimumKrakenVersion' in partial) this.minimumKrakenVersion = partial.minimumKrakenVersion;
		if ('cluster' in partial) this.cluster = partial.cluster;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.projectId != undefined) res['projectId'] = this.projectId
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

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['RegistrationInformation']): RegistrationInformation {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new RegistrationInformation({
			projectId: expectString(extractEntry(jCpy, 'projectId', false, path), true, [...path, ".projectId"]),
			firstName: expectString(extractEntry(jCpy, 'firstName', false, path), true, [...path, ".firstName"]),
			lastName: expectString(extractEntry(jCpy, 'lastName', false, path), true, [...path, ".lastName"]),
			companyName: expectString(extractEntry(jCpy, 'companyName', false, path), true, [...path, ".companyName"]),
			emailAddress: expectString(extractEntry(jCpy, 'emailAddress', true, path), false, [...path, ".emailAddress"]),
			userOptions: expectString(extractEntry(jCpy, 'userOptions', false, path), true, [...path, ".userOptions"]),
			userRoles: expectArray(extractEntry(jCpy, 'userRoles', false, path), false, [...path, ".userRoles"], (x0, p0) => expectString(x0, false, p0)),
			minimumKrakenVersion: expectString(extractEntry(jCpy, 'minimumKrakenVersion', false, path), true, [...path, ".minimumKrakenVersion"]),
			cluster: expectString(extractEntry(jCpy, 'cluster', false, path), true, [...path, ".cluster"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object RegistrationInformation at path ${path.join("")}: ${unused}`)}
		return res
	}

}
