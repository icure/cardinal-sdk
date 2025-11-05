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


export class Group implements StoredDocument, HasTags {

	id: string;

	rev: string | undefined = undefined;

	deletionDate: number | undefined = undefined;

	tags: Array<CodeStub> = [];

	publicTags: Array<CodeStub> = [];

	name: string | undefined = undefined;

	password: string | undefined = undefined;

	servers: Array<string> | undefined = undefined;

	superAdmin: boolean = false;

	properties: Array<DecryptedPropertyStub> = [];

	defaultUserRoles: { [ key in UserType ]?: Array<string> } = {};

	operationTokens: { [ key: string ]: OperationToken } = {};

	sharedEntities: { [ key: string ]: string } = {};

	minimumKrakenVersion: string | undefined = undefined;

	externalJwtConfig: { [ key: string ]: ExternalJwtConfig } = {};

	minimumAuthenticationClassForElevatedPrivileges: AuthenticationClass;

	superGroup: string | undefined = undefined;

	applicationId: string | undefined = undefined;

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
		if ('applicationId' in partial) this.applicationId = partial.applicationId;
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
		if (this.applicationId != undefined) res['applicationId'] = this.applicationId
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
			applicationId: expectString(extractEntry(jCpy, 'applicationId', false, path), true, [...path, ".applicationId"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Group at path ${path.join("")}: ${unused}`)}
		return res
	}

}
