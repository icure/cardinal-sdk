// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectString, expectStringEnum, requireEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {DecryptedPropertyStub} from './PropertyStub.mjs';
import {Identifier} from './base/Identifier.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {DelegationTag} from './embed/DelegationTag.mjs';
import {UsersStatus} from './enums/UsersStatus.mjs';
import {UsersType} from './enums/UsersType.mjs';
import {AuthenticationToken} from './security/AuthenticationToken.mjs';
import {LoginIdentifier} from './security/LoginIdentifier.mjs';
import {Permission} from './security/Permission.mjs';


export class User implements StoredDocument {

	id: string;

	rev: string | undefined = undefined;

	deletionDate: number | undefined = undefined;

	created: number | undefined = undefined;

	identifier: Array<Identifier> = [];

	name: string | undefined = undefined;

	properties: Array<DecryptedPropertyStub> = [];

	permissions: Array<Permission> = [];

	roles: Array<string> = [];

	type: UsersType | undefined = undefined;

	status: UsersStatus | undefined = undefined;

	login: string | undefined = undefined;

	passwordHash: string | undefined = undefined;

	groupId: string | undefined = undefined;

	healthcarePartyId: string | undefined = undefined;

	patientId: string | undefined = undefined;

	deviceId: string | undefined = undefined;

	autoDelegations: { [ key in DelegationTag ]?: Array<string> } = {};

	createdDate: number | undefined = undefined;

	termsOfUseDate: number | undefined = undefined;

	email: string | undefined = undefined;

	mobilePhone: string | undefined = undefined;

	applicationTokens: { [ key: string ]: string } = {};

	authenticationTokens: { [ key: string ]: AuthenticationToken } = {};

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
		if ('type' in partial) this.type = partial.type;
		if ('status' in partial) this.status = partial.status;
		if ('login' in partial) this.login = partial.login;
		if ('passwordHash' in partial) this.passwordHash = partial.passwordHash;
		if ('groupId' in partial) this.groupId = partial.groupId;
		if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
		if ('patientId' in partial) this.patientId = partial.patientId;
		if ('deviceId' in partial) this.deviceId = partial.deviceId;
		if ('autoDelegations' in partial && partial.autoDelegations !== undefined) this.autoDelegations = partial.autoDelegations;
		if ('createdDate' in partial) this.createdDate = partial.createdDate;
		if ('termsOfUseDate' in partial) this.termsOfUseDate = partial.termsOfUseDate;
		if ('email' in partial) this.email = partial.email;
		if ('mobilePhone' in partial) this.mobilePhone = partial.mobilePhone;
		if ('applicationTokens' in partial && partial.applicationTokens !== undefined) this.applicationTokens = partial.applicationTokens;
		if ('authenticationTokens' in partial && partial.authenticationTokens !== undefined) this.authenticationTokens = partial.authenticationTokens;
		if ('systemMetadata' in partial) this.systemMetadata = partial.systemMetadata;
	}

	toJSON(): any {
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
		if (this.type != undefined) res['type'] = this.type
		if (this.status != undefined) res['status'] = this.status
		if (this.login != undefined) res['login'] = this.login
		if (this.passwordHash != undefined) res['passwordHash'] = this.passwordHash
		if (this.groupId != undefined) res['groupId'] = this.groupId
		if (this.healthcarePartyId != undefined) res['healthcarePartyId'] = this.healthcarePartyId
		if (this.patientId != undefined) res['patientId'] = this.patientId
		if (this.deviceId != undefined) res['deviceId'] = this.deviceId
		res['autoDelegations'] = Object.fromEntries(Object.entries(this.autoDelegations).map(([k0, v0]) => [k0, v0.map((x1) => x1 )]))
		if (this.createdDate != undefined) res['createdDate'] = this.createdDate
		if (this.termsOfUseDate != undefined) res['termsOfUseDate'] = this.termsOfUseDate
		if (this.email != undefined) res['email'] = this.email
		if (this.mobilePhone != undefined) res['mobilePhone'] = this.mobilePhone
		res['applicationTokens'] = Object.fromEntries(Object.entries(this.applicationTokens).map(([k0, v0]) => [k0, v0]))
		res['authenticationTokens'] = Object.fromEntries(Object.entries(this.authenticationTokens).map(([k0, v0]) => [k0, v0.toJSON()]))
		if (this.systemMetadata != undefined) res['systemMetadata'] = this.systemMetadata.toJSON()
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['User']): User {
		return new User({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			rev: expectString(json.rev, true, [...path, ".rev"]),
			deletionDate: expectNumber(json.deletionDate, true, true, [...path, ".deletionDate"]),
			created: expectNumber(json.created, true, true, [...path, ".created"]),
			identifier: expectArray(json.identifier, false, [...path, ".identifier"], (x0, p0) => Identifier.fromJSON(x0, p0)),
			name: expectString(json.name, true, [...path, ".name"]),
			properties: expectArray(json.properties, false, [...path, ".properties"], (x0, p0) => DecryptedPropertyStub.fromJSON(x0, p0)),
			permissions: expectArray(json.permissions, false, [...path, ".permissions"], (x0, p0) => Permission.fromJSON(x0, p0)),
			roles: expectArray(json.roles, false, [...path, ".roles"], (x0, p0) => expectString(x0, false, p0)),
			type: expectStringEnum(json.type, true, [...path, ".type"], UsersType, 'UsersType'),
			status: expectStringEnum(json.status, true, [...path, ".status"], UsersStatus, 'UsersStatus'),
			login: expectString(json.login, true, [...path, ".login"]),
			passwordHash: expectString(json.passwordHash, true, [...path, ".passwordHash"]),
			groupId: expectString(json.groupId, true, [...path, ".groupId"]),
			healthcarePartyId: expectString(json.healthcarePartyId, true, [...path, ".healthcarePartyId"]),
			patientId: expectString(json.patientId, true, [...path, ".patientId"]),
			deviceId: expectString(json.deviceId, true, [...path, ".deviceId"]),
			autoDelegations: expectMap(
				json.autoDelegations,
				false,
				[...path, ".autoDelegations"],
				(k0, p0) => expectStringEnum(k0, false, p0, DelegationTag, 'DelegationTag'),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectString(x1, false, p1))
			),
			createdDate: expectNumber(json.createdDate, true, true, [...path, ".createdDate"]),
			termsOfUseDate: expectNumber(json.termsOfUseDate, true, true, [...path, ".termsOfUseDate"]),
			email: expectString(json.email, true, [...path, ".email"]),
			mobilePhone: expectString(json.mobilePhone, true, [...path, ".mobilePhone"]),
			applicationTokens: expectMap(
				json.applicationTokens,
				false,
				[...path, ".applicationTokens"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			authenticationTokens: expectMap(
				json.authenticationTokens,
				false,
				[...path, ".authenticationTokens"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => AuthenticationToken.fromJSON(v0, p0)
			),
			systemMetadata: User.SystemMetadata.fromJSON(json.systemMetadata, [...path, ".systemMetadata"]),
		})
	}

}

export namespace User {

	export class SystemMetadata {

		roles: Array<string>;

		isAdmin: boolean;

		inheritsRoles: boolean;

		loginIdentifiers: Array<LoginIdentifier> = [];

		constructor(partial: Partial<SystemMetadata> & Pick<SystemMetadata, "roles" | "isAdmin" | "inheritsRoles">) {
			this.roles = partial.roles;
			this.isAdmin = partial.isAdmin;
			this.inheritsRoles = partial.inheritsRoles;
			if ('loginIdentifiers' in partial && partial.loginIdentifiers !== undefined) this.loginIdentifiers = partial.loginIdentifiers;
		}

		toJSON(): any {
			const res: { [k: string]: any } = {}
			res['roles'] = this.roles.map((x0) => x0 )
			res['isAdmin'] = this.isAdmin
			res['inheritsRoles'] = this.inheritsRoles
			res['loginIdentifiers'] = this.loginIdentifiers.map((x0) => x0.toJSON() )
			return res
		}

		static fromJSON(json: any, path: Array<string> = ['SystemMetadata']): SystemMetadata {
			return new SystemMetadata({
				roles: expectArray(requireEntry(json.roles, 'roles', path), false, [...path, ".roles"], (x0, p0) => expectString(x0, false, p0)),
				isAdmin: expectBoolean(requireEntry(json.isAdmin, 'isAdmin', path), false, [...path, ".isAdmin"]),
				inheritsRoles: expectBoolean(requireEntry(json.inheritsRoles, 'inheritsRoles', path), false, [...path, ".inheritsRoles"]),
				loginIdentifiers: expectArray(json.loginIdentifiers, false, [...path, ".loginIdentifiers"], (x0, p0) => LoginIdentifier.fromJSON(x0, p0)),
			})
		}

	}

}
