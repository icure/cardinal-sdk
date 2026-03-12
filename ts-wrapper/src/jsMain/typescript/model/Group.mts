// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectObject, expectString, expectStringEnum, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {DecryptedPropertyStub} from './PropertyStub.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasTags} from './base/HasTags.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {AuthenticationClass} from './embed/AuthenticationClass.mjs';
import {UserType} from './embed/UserType.mjs';
import {ExternalJwtConfig} from './security/ExternalJwtConfig.mjs';
import {OperationToken} from './security/OperationToken.mjs';


/**
 *
 *  Represents a group in the iCure platform. A group corresponds to a practice, hospital, or
 *  organization
 *  that contains its own set of databases and users.
 *  /
 */
export class Group implements StoredDocument, HasTags {

	/**
	 *
	 *  The id of the group. We encourage using either a v4 UUID or a HL7 Id.
	 */
	id: string;

	/**
	 *
	 *  The revision of the group in the database, used for conflict management / optimistic locking.
	 */
	rev: string | undefined = undefined;

	/**
	 *
	 *  Hard delete (unix epoch in ms) timestamp of the object.
	 */
	deletionDate: number | undefined = undefined;

	/**
	 *
	 *  Tags that qualify the group as being member of a certain class.
	 */
	tags: Array<CodeStub> = [];

	/**
	 *
	 *  Tags that are publicly visible for the group.
	 */
	publicTags: Array<CodeStub> = [];

	/**
	 *
	 *  Username for the group.
	 */
	name: string | undefined = undefined;

	/**
	 *
	 *  Password for the group access.
	 */
	password: string | undefined = undefined;

	/**
	 *
	 *  List of servers accessible to the group.
	 */
	servers: Array<string> | undefined = undefined;

	/**
	 *
	 *  Whether the group has a super admin permission.
	 */
	superAdmin: boolean = false;

	/**
	 *
	 *  Extra properties for the group. Those properties are typed (see class Property).
	 */
	properties: Array<DecryptedPropertyStub> = [];

	/**
	 *
	 *  The default roles for each user type, if not otherwise specified on the user.
	 */
	defaultUserRoles: { [ key in UserType ]?: Array<string> } = {};

	/**
	 *
	 *  Single-used token to perform specific operations.
	 */
	operationTokens: { [ key: string ]: OperationToken } = {};

	/**
	 *
	 *  List of entities that have to be collected from a shared database.
	 */
	sharedEntities: { [ key: string ]: string } = {};

	/**
	 *
	 *  Minimum version of Kraken required to access API.
	 */
	minimumKrakenVersion: string | undefined = undefined;

	/**
	 *
	 *  Verified public keys that can be used to allow log in with external JWTs.
	 */
	externalJwtConfig: { [ key: string ]: ExternalJwtConfig } = {};

	/**
	 *
	 *  The minimum authentication class required for elevated privileges.
	 */
	minimumAuthenticationClassForElevatedPrivileges: AuthenticationClass;

	/**
	 *
	 *  The id of the parent super group, if any.
	 */
	superGroup: string | undefined = undefined;

	/**
	 *
	 *  A user-chosen identifier for the applications for which this group holds data.
	 */
	projectId: string | undefined = undefined;

	templates: Group.TemplatesConfiguration | undefined = undefined;

	constructor(partial: Partial<Group> & Pick<Group, "minimumAuthenticationClassForElevatedPrivileges">) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('publicTags' in partial && partial.publicTags !== undefined) this.publicTags = partial.publicTags;
		if ('name' in partial) this.name = partial.name;
		if ('password' in partial) this.password = partial.password;
		if ('servers' in partial) this.servers = partial.servers;
		if ('superAdmin' in partial && partial.superAdmin !== undefined) this.superAdmin = partial.superAdmin;
		if ('properties' in partial && partial.properties !== undefined) this.properties = partial.properties;
		if ('defaultUserRoles' in partial && partial.defaultUserRoles !== undefined) this.defaultUserRoles = partial.defaultUserRoles;
		if ('operationTokens' in partial && partial.operationTokens !== undefined) this.operationTokens = partial.operationTokens;
		if ('sharedEntities' in partial && partial.sharedEntities !== undefined) this.sharedEntities = partial.sharedEntities;
		if ('minimumKrakenVersion' in partial) this.minimumKrakenVersion = partial.minimumKrakenVersion;
		if ('externalJwtConfig' in partial && partial.externalJwtConfig !== undefined) this.externalJwtConfig = partial.externalJwtConfig;
		this.minimumAuthenticationClassForElevatedPrivileges = partial.minimumAuthenticationClassForElevatedPrivileges;
		if ('superGroup' in partial) this.superGroup = partial.superGroup;
		if ('projectId' in partial) this.projectId = partial.projectId;
		if ('templates' in partial) this.templates = partial.templates;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['publicTags'] = this.publicTags.map((x0) => x0.toJSON() )
		if (this.name != undefined) res['name'] = this.name
		if (this.password != undefined) res['password'] = this.password
		if (this.servers != undefined) res['servers'] = this.servers.map((x0) => x0 )
		res['superAdmin'] = this.superAdmin
		res['properties'] = this.properties.map((x0) => x0.toJSON() )
		res['defaultUserRoles'] = Object.fromEntries(Object.entries(this.defaultUserRoles).map(([k0, v0]) => [k0, v0.map((x1) => x1 )]))
		res['operationTokens'] = Object.fromEntries(Object.entries(this.operationTokens).map(([k0, v0]) => [k0, v0.toJSON()]))
		res['sharedEntities'] = Object.fromEntries(Object.entries(this.sharedEntities).map(([k0, v0]) => [k0, v0]))
		if (this.minimumKrakenVersion != undefined) res['minimumKrakenVersion'] = this.minimumKrakenVersion
		res['externalJwtConfig'] = Object.fromEntries(Object.entries(this.externalJwtConfig).map(([k0, v0]) => [k0, v0.toJSON()]))
		res['minimumAuthenticationClassForElevatedPrivileges'] = this.minimumAuthenticationClassForElevatedPrivileges
		if (this.superGroup != undefined) res['superGroup'] = this.superGroup
		if (this.projectId != undefined) res['projectId'] = this.projectId
		if (this.templates != undefined) res['templates'] = this.templates.toJSON()
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Group']): Group {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Group({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			publicTags: expectArray(extractEntry(jCpy, 'publicTags', false, path), false, [...path, ".publicTags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			name: expectString(extractEntry(jCpy, 'name', false, path), true, [...path, ".name"]),
			password: expectString(extractEntry(jCpy, 'password', false, path), true, [...path, ".password"]),
			servers: expectArray(extractEntry(jCpy, 'servers', false, path), true, [...path, ".servers"], (x0, p0) => expectString(x0, false, p0)),
			superAdmin: expectBoolean(extractEntry(jCpy, 'superAdmin', false, path), false, [...path, ".superAdmin"]),
			properties: expectArray(extractEntry(jCpy, 'properties', false, path), false, [...path, ".properties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedPropertyStub.fromJSON)),
			defaultUserRoles: expectMap(
				extractEntry(jCpy, 'defaultUserRoles', false, path),
				false,
				[...path, ".defaultUserRoles"],
				(k0, p0) => expectStringEnum(k0, false, p0, UserType, 'UserType'),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectString(x1, false, p1))
			),
			operationTokens: expectMap(
				extractEntry(jCpy, 'operationTokens', false, path),
				false,
				[...path, ".operationTokens"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectObject(v0, false, ignoreUnknownKeys, p0, OperationToken.fromJSON)
			),
			sharedEntities: expectMap(
				extractEntry(jCpy, 'sharedEntities', false, path),
				false,
				[...path, ".sharedEntities"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			minimumKrakenVersion: expectString(extractEntry(jCpy, 'minimumKrakenVersion', false, path), true, [...path, ".minimumKrakenVersion"]),
			externalJwtConfig: expectMap(
				extractEntry(jCpy, 'externalJwtConfig', false, path),
				false,
				[...path, ".externalJwtConfig"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectObject(v0, false, ignoreUnknownKeys, p0, ExternalJwtConfig.fromJSON)
			),
			minimumAuthenticationClassForElevatedPrivileges: expectStringEnum(extractEntry(jCpy, 'minimumAuthenticationClassForElevatedPrivileges', true, path), false, [...path, ".minimumAuthenticationClassForElevatedPrivileges"], AuthenticationClass, 'AuthenticationClass'),
			superGroup: expectString(extractEntry(jCpy, 'superGroup', false, path), true, [...path, ".superGroup"]),
			projectId: expectString(extractEntry(jCpy, 'projectId', false, path), true, [...path, ".projectId"]),
			templates: expectObject(extractEntry(jCpy, 'templates', false, path), true, ignoreUnknownKeys, [...path, ".templates"], Group.TemplatesConfiguration.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Group at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export namespace Group {

	export class TemplatesConfiguration {

		specId: string;

		emailSender: string | undefined = undefined;

		smsSender: string | undefined = undefined;

		emailVerificationTemplateId: string | undefined = undefined;

		mobilePhoneVerificationTemplateId: string | undefined = undefined;

		existingEmailNotificationTemplateId: string | undefined = undefined;

		existingMobilePhoneNotificationTemplateId: string | undefined = undefined;

		constructor(partial: Partial<TemplatesConfiguration> & Pick<TemplatesConfiguration, "specId">) {
			this.specId = partial.specId;
			if ('emailSender' in partial) this.emailSender = partial.emailSender;
			if ('smsSender' in partial) this.smsSender = partial.smsSender;
			if ('emailVerificationTemplateId' in partial) this.emailVerificationTemplateId = partial.emailVerificationTemplateId;
			if ('mobilePhoneVerificationTemplateId' in partial) this.mobilePhoneVerificationTemplateId = partial.mobilePhoneVerificationTemplateId;
			if ('existingEmailNotificationTemplateId' in partial) this.existingEmailNotificationTemplateId = partial.existingEmailNotificationTemplateId;
			if ('existingMobilePhoneNotificationTemplateId' in partial) this.existingMobilePhoneNotificationTemplateId = partial.existingMobilePhoneNotificationTemplateId;
		}

		toJSON(): object {
			const res: { [k: string]: any } = {}
			res['specId'] = this.specId
			if (this.emailSender != undefined) res['emailSender'] = this.emailSender
			if (this.smsSender != undefined) res['smsSender'] = this.smsSender
			if (this.emailVerificationTemplateId != undefined) res['emailVerificationTemplateId'] = this.emailVerificationTemplateId
			if (this.mobilePhoneVerificationTemplateId != undefined) res['mobilePhoneVerificationTemplateId'] = this.mobilePhoneVerificationTemplateId
			if (this.existingEmailNotificationTemplateId != undefined) res['existingEmailNotificationTemplateId'] = this.existingEmailNotificationTemplateId
			if (this.existingMobilePhoneNotificationTemplateId != undefined) res['existingMobilePhoneNotificationTemplateId'] = this.existingMobilePhoneNotificationTemplateId
			return res
		}

		static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
				path: Array<string> = ['TemplatesConfiguration']): TemplatesConfiguration {
			if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
			const jCpy = { ...json }
			const res = new TemplatesConfiguration({
				specId: expectString(extractEntry(jCpy, 'specId', true, path), false, [...path, ".specId"]),
				emailSender: expectString(extractEntry(jCpy, 'emailSender', false, path), true, [...path, ".emailSender"]),
				smsSender: expectString(extractEntry(jCpy, 'smsSender', false, path), true, [...path, ".smsSender"]),
				emailVerificationTemplateId: expectString(extractEntry(jCpy, 'emailVerificationTemplateId', false, path), true, [...path, ".emailVerificationTemplateId"]),
				mobilePhoneVerificationTemplateId: expectString(extractEntry(jCpy, 'mobilePhoneVerificationTemplateId', false, path), true, [...path, ".mobilePhoneVerificationTemplateId"]),
				existingEmailNotificationTemplateId: expectString(extractEntry(jCpy, 'existingEmailNotificationTemplateId', false, path), true, [...path, ".existingEmailNotificationTemplateId"]),
				existingMobilePhoneNotificationTemplateId: expectString(extractEntry(jCpy, 'existingMobilePhoneNotificationTemplateId', false, path), true, [...path, ".existingMobilePhoneNotificationTemplateId"]),
			})
			if (!ignoreUnknownKeys) {
				const unused = Object.keys(jCpy)
				if (unused.length > 0) throw new Error(`Unexpected key(s) for json object TemplatesConfiguration at path ${path.join("")}: ${unused}`)}
			return res
		}

	}

}
