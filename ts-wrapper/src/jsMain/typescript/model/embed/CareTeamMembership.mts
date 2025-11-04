// auto-generated file
import {expectNumber, expectString, expectStringEnum} from '../../internal/JsonDecodeUtils.mjs';
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
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['DecryptedCareTeamMembership']): DecryptedCareTeamMembership {
		return new DecryptedCareTeamMembership({
			startDate: expectNumber(json.startDate, true, true, [...path, ".startDate"]),
			endDate: expectNumber(json.endDate, true, true, [...path, ".endDate"]),
			careTeamMemberId: expectString(json.careTeamMemberId, true, [...path, ".careTeamMemberId"]),
			membershipType: expectStringEnum(json.membershipType, true, [...path, ".membershipType"], MembershipType, 'MembershipType'),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
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
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['EncryptedCareTeamMembership']): EncryptedCareTeamMembership {
		return new EncryptedCareTeamMembership({
			startDate: expectNumber(json.startDate, true, true, [...path, ".startDate"]),
			endDate: expectNumber(json.endDate, true, true, [...path, ".endDate"]),
			careTeamMemberId: expectString(json.careTeamMemberId, true, [...path, ".careTeamMemberId"]),
			membershipType: expectStringEnum(json.membershipType, true, [...path, ".membershipType"], MembershipType, 'MembershipType'),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
	}

}
