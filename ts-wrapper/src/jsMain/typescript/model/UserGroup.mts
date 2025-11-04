// auto-generated file
import {expectArray, expectString} from '../internal/JsonDecodeUtils.mjs';
import {Group} from './Group.mjs';


export class UserGroup {

	groupId: string | undefined = undefined;

	groupName: string | undefined = undefined;

	groupsHierarchy: Array<Group> = [];

	userId: string | undefined = undefined;

	login: string | undefined = undefined;

	name: string | undefined = undefined;

	email: string | undefined = undefined;

	phone: string | undefined = undefined;

	patientId: string | undefined = undefined;

	healthcarePartyId: string | undefined = undefined;

	deviceId: string | undefined = undefined;

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

	toJSON(): any {
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

	static fromJSON(json: any, path: Array<string> = ['UserGroup']): UserGroup {
		return new UserGroup({
			groupId: expectString(json.groupId, true, [...path, ".groupId"]),
			groupName: expectString(json.groupName, true, [...path, ".groupName"]),
			groupsHierarchy: expectArray(json.groupsHierarchy, false, [...path, ".groupsHierarchy"], (x0, p0) => Group.fromJSON(x0, p0)),
			userId: expectString(json.userId, true, [...path, ".userId"]),
			login: expectString(json.login, true, [...path, ".login"]),
			name: expectString(json.name, true, [...path, ".name"]),
			email: expectString(json.email, true, [...path, ".email"]),
			phone: expectString(json.phone, true, [...path, ".phone"]),
			patientId: expectString(json.patientId, true, [...path, ".patientId"]),
			healthcarePartyId: expectString(json.healthcarePartyId, true, [...path, ".healthcarePartyId"]),
			deviceId: expectString(json.deviceId, true, [...path, ".deviceId"]),
			nameOfParentOfTopmostGroupInHierarchy: expectString(json.nameOfParentOfTopmostGroupInHierarchy, true, [...path, ".nameOfParentOfTopmostGroupInHierarchy"]),
		})
	}

}
