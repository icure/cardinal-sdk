// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectObject, expectString, expectStringEnum, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {DecryptedPropertyStub} from './PropertyStub.mjs';
import {Identifier} from './base/Identifier.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {DelegationTag} from './embed/DelegationTag.mjs';
import {UsersStatus} from './enums/UsersStatus.mjs';
import {AuthenticationToken} from './security/AuthenticationToken.mjs';
import {LoginIdentifier} from './security/LoginIdentifier.mjs';
import {Permission} from './security/Permission.mjs';


/**
 *
 *  Represents a user that can log in to the iCure platform. A user can be linked to a healthcare
 *  party,
 *  a patient, or a device, and holds authentication credentials, roles, and permissions.
 *  /
 */
export class User implements StoredDocument {

	/**
	 *
	 *  The Id of the user. We encourage using either a v4 UUID or a HL7 Id.
	 */
	id: string;

	/**
	 *
	 *  The revision of the user in the database, used for conflict management / optimistic locking.
	 */
	rev: string | undefined = undefined;

	/**
	 *
	 *  Hard delete (unix epoch in ms) timestamp of the object.
	 */
	deletionDate: number | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) of creation.
	 */
	created: number | undefined = undefined;

	/**
	 *
	 *  The identifiers of the user.
	 */
	identifier: Array<Identifier> = [];

	/**
	 *
	 *  Last name of the user.
	 */
	name: string | undefined = undefined;

	/**
	 *
	 *  Extra properties for the user. Those properties are typed (see class Property).
	 */
	properties: Array<DecryptedPropertyStub> = [];

	/**
	 *
	 *  Local permissions specified for the user.
	 */
	permissions: Array<Permission> = [];

	/**
	 *
	 *  Local roles specified for the user.
	 */
	roles: Array<string> = [];

	/**
	 *
	 *  State of user's activeness: 'Active', 'Disabled' or 'Registering'.
	 */
	status: UsersStatus | undefined = undefined;

	/**
	 *
	 *  Username for this user. We encourage using an email address.
	 */
	login: string | undefined = undefined;

	/**
	 *
	 *  Hashed version of the password (BCrypt is used for hashing).
	 */
	passwordHash: string | undefined = undefined;

	/**
	 *
	 *  The id of the group (practice/hospital) the user is member of.
	 */
	groupId: string | undefined = undefined;

	/**
	 *
	 *  Id of the healthcare party if the user is a healthcare party.
	 */
	healthcarePartyId: string | undefined = undefined;

	/**
	 *
	 *  Id of the patient if the user is a patient.
	 */
	patientId: string | undefined = undefined;

	/**
	 *
	 *  Id of the device if the user is a device.
	 */
	deviceId: string | undefined = undefined;

	/**
	 *
	 *  Delegations that are automatically generated client side when a new database object is created
	 *  by this user.
	 */
	autoDelegations: { [ key in DelegationTag ]?: Array<string> } = {};

	/**
	 *
	 *  The timestamp (unix epoch in ms) of the latest validation of the terms of use.
	 */
	termsOfUseDate: number | undefined = undefined;

	/**
	 *
	 *  Email address of the user (used for token exchange or password recovery).
	 */
	email: string | undefined = undefined;

	/**
	 *
	 *  Mobile phone of the user (used for token exchange or password recovery).
	 */
	mobilePhone: string | undefined = undefined;

	/**
	 *
	 *  Encrypted and time-limited authentication tokens used for inter-applications authentication.
	 */
	authenticationTokens: { [ key: string ]: AuthenticationToken } = {};

	/**
	 *
	 *  Metadata used to enrich the user with information from the cloud environment.
	 */
	systemMetadata: User.SystemMetadata | undefined = undefined;

	constructor(partial: Partial<User>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('created' in partial) this.created = partial.created;
		if ('identifier' in partial && partial.identifier !== undefined) this.identifier = partial.identifier;
		if ('name' in partial) this.name = partial.name;
		if ('properties' in partial && partial.properties !== undefined) this.properties = partial.properties;
		if ('permissions' in partial && partial.permissions !== undefined) this.permissions = partial.permissions;
		if ('roles' in partial && partial.roles !== undefined) this.roles = partial.roles;
		if ('status' in partial) this.status = partial.status;
		if ('login' in partial) this.login = partial.login;
		if ('passwordHash' in partial) this.passwordHash = partial.passwordHash;
		if ('groupId' in partial) this.groupId = partial.groupId;
		if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
		if ('patientId' in partial) this.patientId = partial.patientId;
		if ('deviceId' in partial) this.deviceId = partial.deviceId;
		if ('autoDelegations' in partial && partial.autoDelegations !== undefined) this.autoDelegations = partial.autoDelegations;
		if ('termsOfUseDate' in partial) this.termsOfUseDate = partial.termsOfUseDate;
		if ('email' in partial) this.email = partial.email;
		if ('mobilePhone' in partial) this.mobilePhone = partial.mobilePhone;
		if ('authenticationTokens' in partial && partial.authenticationTokens !== undefined) this.authenticationTokens = partial.authenticationTokens;
		if ('systemMetadata' in partial) this.systemMetadata = partial.systemMetadata;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.created != undefined) res['created'] = this.created
		res['identifier'] = this.identifier.map((x0) => x0.toJSON() )
		if (this.name != undefined) res['name'] = this.name
		res['properties'] = this.properties.map((x0) => x0.toJSON() )
		res['permissions'] = this.permissions.map((x0) => x0.toJSON() )
		res['roles'] = this.roles.map((x0) => x0 )
		if (this.status != undefined) res['status'] = this.status
		if (this.login != undefined) res['login'] = this.login
		if (this.passwordHash != undefined) res['passwordHash'] = this.passwordHash
		if (this.groupId != undefined) res['groupId'] = this.groupId
		if (this.healthcarePartyId != undefined) res['healthcarePartyId'] = this.healthcarePartyId
		if (this.patientId != undefined) res['patientId'] = this.patientId
		if (this.deviceId != undefined) res['deviceId'] = this.deviceId
		res['autoDelegations'] = Object.fromEntries(Object.entries(this.autoDelegations).map(([k0, v0]) => [k0, v0.map((x1) => x1 )]))
		if (this.termsOfUseDate != undefined) res['termsOfUseDate'] = this.termsOfUseDate
		if (this.email != undefined) res['email'] = this.email
		if (this.mobilePhone != undefined) res['mobilePhone'] = this.mobilePhone
		res['authenticationTokens'] = Object.fromEntries(Object.entries(this.authenticationTokens).map(([k0, v0]) => [k0, v0.toJSON()]))
		if (this.systemMetadata != undefined) res['systemMetadata'] = this.systemMetadata.toJSON()
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['User']): User {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new User({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			identifier: expectArray(extractEntry(jCpy, 'identifier', false, path), false, [...path, ".identifier"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Identifier.fromJSON)),
			name: expectString(extractEntry(jCpy, 'name', false, path), true, [...path, ".name"]),
			properties: expectArray(extractEntry(jCpy, 'properties', false, path), false, [...path, ".properties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedPropertyStub.fromJSON)),
			permissions: expectArray(extractEntry(jCpy, 'permissions', false, path), false, [...path, ".permissions"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Permission.fromJSON)),
			roles: expectArray(extractEntry(jCpy, 'roles', false, path), false, [...path, ".roles"], (x0, p0) => expectString(x0, false, p0)),
			status: expectStringEnum(extractEntry(jCpy, 'status', false, path), true, [...path, ".status"], UsersStatus, 'UsersStatus'),
			login: expectString(extractEntry(jCpy, 'login', false, path), true, [...path, ".login"]),
			passwordHash: expectString(extractEntry(jCpy, 'passwordHash', false, path), true, [...path, ".passwordHash"]),
			groupId: expectString(extractEntry(jCpy, 'groupId', false, path), true, [...path, ".groupId"]),
			healthcarePartyId: expectString(extractEntry(jCpy, 'healthcarePartyId', false, path), true, [...path, ".healthcarePartyId"]),
			patientId: expectString(extractEntry(jCpy, 'patientId', false, path), true, [...path, ".patientId"]),
			deviceId: expectString(extractEntry(jCpy, 'deviceId', false, path), true, [...path, ".deviceId"]),
			autoDelegations: expectMap(
				extractEntry(jCpy, 'autoDelegations', false, path),
				false,
				[...path, ".autoDelegations"],
				(k0, p0) => expectStringEnum(k0, false, p0, DelegationTag, 'DelegationTag'),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectString(x1, false, p1))
			),
			termsOfUseDate: expectNumber(extractEntry(jCpy, 'termsOfUseDate', false, path), true, true, [...path, ".termsOfUseDate"]),
			email: expectString(extractEntry(jCpy, 'email', false, path), true, [...path, ".email"]),
			mobilePhone: expectString(extractEntry(jCpy, 'mobilePhone', false, path), true, [...path, ".mobilePhone"]),
			authenticationTokens: expectMap(
				extractEntry(jCpy, 'authenticationTokens', false, path),
				false,
				[...path, ".authenticationTokens"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectObject(v0, false, ignoreUnknownKeys, p0, AuthenticationToken.fromJSON)
			),
			systemMetadata: expectObject(extractEntry(jCpy, 'systemMetadata', false, path), true, ignoreUnknownKeys, [...path, ".systemMetadata"], User.SystemMetadata.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object User at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export namespace User {

	export class SystemMetadata {

		roles: Array<string>;

		isAdmin: boolean;

		inheritsRoles: boolean;

		loginIdentifiers: Array<LoginIdentifier> = [];

		verifiedEmail: boolean | undefined = undefined;

		verifiedMobilePhone: boolean | undefined = undefined;

		constructor(partial: Partial<SystemMetadata> & Pick<SystemMetadata, "roles" | "isAdmin" | "inheritsRoles">) {
			this.roles = partial.roles;
			this.isAdmin = partial.isAdmin;
			this.inheritsRoles = partial.inheritsRoles;
			if ('loginIdentifiers' in partial && partial.loginIdentifiers !== undefined) this.loginIdentifiers = partial.loginIdentifiers;
			if ('verifiedEmail' in partial) this.verifiedEmail = partial.verifiedEmail;
			if ('verifiedMobilePhone' in partial) this.verifiedMobilePhone = partial.verifiedMobilePhone;
		}

		toJSON(): object {
			const res: { [k: string]: any } = {}
			res['roles'] = this.roles.map((x0) => x0 )
			res['isAdmin'] = this.isAdmin
			res['inheritsRoles'] = this.inheritsRoles
			res['loginIdentifiers'] = this.loginIdentifiers.map((x0) => x0.toJSON() )
			if (this.verifiedEmail != undefined) res['verifiedEmail'] = this.verifiedEmail
			if (this.verifiedMobilePhone != undefined) res['verifiedMobilePhone'] = this.verifiedMobilePhone
			return res
		}

		static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
				path: Array<string> = ['SystemMetadata']): SystemMetadata {
			if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
			const jCpy = { ...json }
			const res = new SystemMetadata({
				roles: expectArray(extractEntry(jCpy, 'roles', true, path), false, [...path, ".roles"], (x0, p0) => expectString(x0, false, p0)),
				isAdmin: expectBoolean(extractEntry(jCpy, 'isAdmin', true, path), false, [...path, ".isAdmin"]),
				inheritsRoles: expectBoolean(extractEntry(jCpy, 'inheritsRoles', true, path), false, [...path, ".inheritsRoles"]),
				loginIdentifiers: expectArray(extractEntry(jCpy, 'loginIdentifiers', false, path), false, [...path, ".loginIdentifiers"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, LoginIdentifier.fromJSON)),
				verifiedEmail: expectBoolean(extractEntry(jCpy, 'verifiedEmail', false, path), true, [...path, ".verifiedEmail"]),
				verifiedMobilePhone: expectBoolean(extractEntry(jCpy, 'verifiedMobilePhone', false, path), true, [...path, ".verifiedMobilePhone"]),
			})
			if (!ignoreUnknownKeys) {
				const unused = Object.keys(jCpy)
				if (unused.length > 0) throw new Error(`Unexpected key(s) for json object SystemMetadata at path ${path.join("")}: ${unused}`)}
			return res
		}

	}

}
