// auto-generated file
import {expectNumber, expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';
import {MembershipType} from './MembershipType.mjs';


export interface CareTeamMembership extends Encryptable {

	startDate: number | undefined;

	endDate: number | undefined;

	careTeamMemberId: string | undefined;

	membershipType: MembershipType | undefined;

	readonly isEncrypted: boolean;

}

export class DecryptedCareTeamMembership {

	startDate: number | undefined = undefined;

	endDate: number | undefined = undefined;

	careTeamMemberId: string | undefined = undefined;

	membershipType: MembershipType | undefined = undefined;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedCareTeamMembership>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		if ('startDate' in partial) this.startDate = partial.startDate;
		if ('endDate' in partial) this.endDate = partial.endDate;
		if ('careTeamMemberId' in partial) this.careTeamMemberId = partial.careTeamMemberId;
		if ('membershipType' in partial) this.membershipType = partial.membershipType;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.startDate != undefined) res['startDate'] = this.startDate
		if (this.endDate != undefined) res['endDate'] = this.endDate
		if (this.careTeamMemberId != undefined) res['careTeamMemberId'] = this.careTeamMemberId
		if (this.membershipType != undefined) res['membershipType'] = this.membershipType
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = false
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedCareTeamMembership']): DecryptedCareTeamMembership {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false`)
		const res = new DecryptedCareTeamMembership({
			startDate: expectNumber(extractEntry(jCpy, 'startDate', false, path), true, true, [...path, ".startDate"]),
			endDate: expectNumber(extractEntry(jCpy, 'endDate', false, path), true, true, [...path, ".endDate"]),
			careTeamMemberId: expectString(extractEntry(jCpy, 'careTeamMemberId', false, path), true, [...path, ".careTeamMemberId"]),
			membershipType: expectStringEnum(extractEntry(jCpy, 'membershipType', false, path), true, [...path, ".membershipType"], MembershipType, 'MembershipType'),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedCareTeamMembership at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export class EncryptedCareTeamMembership {

	startDate: number | undefined = undefined;

	endDate: number | undefined = undefined;

	careTeamMemberId: string | undefined = undefined;

	membershipType: MembershipType | undefined = undefined;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedCareTeamMembership>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		if ('startDate' in partial) this.startDate = partial.startDate;
		if ('endDate' in partial) this.endDate = partial.endDate;
		if ('careTeamMemberId' in partial) this.careTeamMemberId = partial.careTeamMemberId;
		if ('membershipType' in partial) this.membershipType = partial.membershipType;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.startDate != undefined) res['startDate'] = this.startDate
		if (this.endDate != undefined) res['endDate'] = this.endDate
		if (this.careTeamMemberId != undefined) res['careTeamMemberId'] = this.careTeamMemberId
		if (this.membershipType != undefined) res['membershipType'] = this.membershipType
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = true
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedCareTeamMembership']): EncryptedCareTeamMembership {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true`)
		const res = new EncryptedCareTeamMembership({
			startDate: expectNumber(extractEntry(jCpy, 'startDate', false, path), true, true, [...path, ".startDate"]),
			endDate: expectNumber(extractEntry(jCpy, 'endDate', false, path), true, true, [...path, ".endDate"]),
			careTeamMemberId: expectString(extractEntry(jCpy, 'careTeamMemberId', false, path), true, [...path, ".careTeamMemberId"]),
			membershipType: expectStringEnum(extractEntry(jCpy, 'membershipType', false, path), true, [...path, ".membershipType"], MembershipType, 'MembershipType'),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedCareTeamMembership at path ${path.join("")}: ${unused}`)}
		return res
	}

}
