// auto-generated file
import {expectArray, expectObject, expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {Group} from './Group.mjs';


/**
 *
 *
 *   DTO representing a user within the context of a specific group, including the group hierarchy
 *   and the user's associated data owner identifiers.
 */
export class UserGroup {

	/**
	 *
	 *  The identifier of the group this user belongs to.
	 */
	groupId: string | undefined = undefined;

	/**
	 *
	 *  The name of the group this user belongs to.
	 */
	groupName: string | undefined = undefined;

	/**
	 *
	 *  The list of groups forming the hierarchy from the topmost group down to this group.
	 */
	groupsHierarchy: Array<Group> = [];

	/**
	 *
	 *  The identifier of the user.
	 */
	userId: string | undefined = undefined;

	/**
	 *
	 *  The login identifier of the user.
	 */
	login: string | undefined = undefined;

	/**
	 *
	 *  The display name of the user.
	 */
	name: string | undefined = undefined;

	/**
	 *
	 *  The email address of the user.
	 */
	email: string | undefined = undefined;

	/**
	 *
	 *  The phone number of the user.
	 */
	phone: string | undefined = undefined;

	/**
	 *
	 *  The identifier of the patient linked to this user, if any.
	 */
	patientId: string | undefined = undefined;

	/**
	 *
	 *  The identifier of the healthcare party linked to this user, if any.
	 */
	healthcarePartyId: string | undefined = undefined;

	/**
	 *
	 *  The identifier of the device linked to this user, if any.
	 */
	deviceId: string | undefined = undefined;

	/**
	 *
	 *  The name of the parent group of the topmost group in the hierarchy.
	 */
	nameOfParentOfTopmostGroupInHierarchy: string | undefined = undefined;

	constructor(partial: Partial<UserGroup>) {
		if ('groupId' in partial) this.groupId = partial.groupId;
		if ('groupName' in partial) this.groupName = partial.groupName;
		if ('groupsHierarchy' in partial && partial.groupsHierarchy !== undefined) this.groupsHierarchy = partial.groupsHierarchy;
		if ('userId' in partial) this.userId = partial.userId;
		if ('login' in partial) this.login = partial.login;
		if ('name' in partial) this.name = partial.name;
		if ('email' in partial) this.email = partial.email;
		if ('phone' in partial) this.phone = partial.phone;
		if ('patientId' in partial) this.patientId = partial.patientId;
		if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
		if ('deviceId' in partial) this.deviceId = partial.deviceId;
		if ('nameOfParentOfTopmostGroupInHierarchy' in partial) this.nameOfParentOfTopmostGroupInHierarchy = partial.nameOfParentOfTopmostGroupInHierarchy;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.groupId != undefined) res['groupId'] = this.groupId
		if (this.groupName != undefined) res['groupName'] = this.groupName
		res['groupsHierarchy'] = this.groupsHierarchy.map((x0) => x0.toJSON() )
		if (this.userId != undefined) res['userId'] = this.userId
		if (this.login != undefined) res['login'] = this.login
		if (this.name != undefined) res['name'] = this.name
		if (this.email != undefined) res['email'] = this.email
		if (this.phone != undefined) res['phone'] = this.phone
		if (this.patientId != undefined) res['patientId'] = this.patientId
		if (this.healthcarePartyId != undefined) res['healthcarePartyId'] = this.healthcarePartyId
		if (this.deviceId != undefined) res['deviceId'] = this.deviceId
		if (this.nameOfParentOfTopmostGroupInHierarchy != undefined) res['nameOfParentOfTopmostGroupInHierarchy'] = this.nameOfParentOfTopmostGroupInHierarchy
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['UserGroup']): UserGroup {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new UserGroup({
			groupId: expectString(extractEntry(jCpy, 'groupId', false, path), true, [...path, ".groupId"]),
			groupName: expectString(extractEntry(jCpy, 'groupName', false, path), true, [...path, ".groupName"]),
			groupsHierarchy: expectArray(extractEntry(jCpy, 'groupsHierarchy', false, path), false, [...path, ".groupsHierarchy"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Group.fromJSON)),
			userId: expectString(extractEntry(jCpy, 'userId', false, path), true, [...path, ".userId"]),
			login: expectString(extractEntry(jCpy, 'login', false, path), true, [...path, ".login"]),
			name: expectString(extractEntry(jCpy, 'name', false, path), true, [...path, ".name"]),
			email: expectString(extractEntry(jCpy, 'email', false, path), true, [...path, ".email"]),
			phone: expectString(extractEntry(jCpy, 'phone', false, path), true, [...path, ".phone"]),
			patientId: expectString(extractEntry(jCpy, 'patientId', false, path), true, [...path, ".patientId"]),
			healthcarePartyId: expectString(extractEntry(jCpy, 'healthcarePartyId', false, path), true, [...path, ".healthcarePartyId"]),
			deviceId: expectString(extractEntry(jCpy, 'deviceId', false, path), true, [...path, ".deviceId"]),
			nameOfParentOfTopmostGroupInHierarchy: expectString(extractEntry(jCpy, 'nameOfParentOfTopmostGroupInHierarchy', false, path), true, [...path, ".nameOfParentOfTopmostGroupInHierarchy"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object UserGroup at path ${path.join("")}: ${unused}`)}
		return res
	}

}
