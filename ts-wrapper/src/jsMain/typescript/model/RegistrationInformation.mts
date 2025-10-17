// auto-generated file

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

}
