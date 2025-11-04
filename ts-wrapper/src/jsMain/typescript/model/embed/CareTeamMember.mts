// auto-generated file
import {expectString, expectStringEnum, requireEntry} from '../../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../../utils/Id.mjs';
import {CodeStub} from '../base/CodeStub.mjs';
import {Identifiable} from '../base/Identifiable.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {CareTeamMemberType} from './CareTeamMemberType.mjs';
import {Encryptable} from './Encryptable.mjs';


export interface CareTeamMember extends Encryptable, Identifiable<string> {

	careTeamMemberType: CareTeamMemberType | undefined;

	healthcarePartyId: string | undefined;

	quality: CodeStub | undefined;

	readonly isEncrypted: boolean;

}

export class DecryptedCareTeamMember {

	id: string;

	careTeamMemberType: CareTeamMemberType | undefined = undefined;

	healthcarePartyId: string | undefined = undefined;

	quality: CodeStub | undefined = undefined;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedCareTeamMember>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		this.id = partial.id ?? randomUuid();
		if ('careTeamMemberType' in partial) this.careTeamMemberType = partial.careTeamMemberType;
		if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
		if ('quality' in partial) this.quality = partial.quality;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.careTeamMemberType != undefined) res['careTeamMemberType'] = this.careTeamMemberType
		if (this.healthcarePartyId != undefined) res['healthcarePartyId'] = this.healthcarePartyId
		if (this.quality != undefined) res['quality'] = this.quality.toJSON()
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['DecryptedCareTeamMember']): DecryptedCareTeamMember {
		return new DecryptedCareTeamMember({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			careTeamMemberType: expectStringEnum(json.careTeamMemberType, true, [...path, ".careTeamMemberType"], CareTeamMemberType, 'CareTeamMemberType'),
			healthcarePartyId: expectString(json.healthcarePartyId, true, [...path, ".healthcarePartyId"]),
			quality: CodeStub.fromJSON(json.quality, [...path, ".quality"]),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
	}

}

export class EncryptedCareTeamMember {

	id: string;

	careTeamMemberType: CareTeamMemberType | undefined = undefined;

	healthcarePartyId: string | undefined = undefined;

	quality: CodeStub | undefined = undefined;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedCareTeamMember>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		this.id = partial.id ?? randomUuid();
		if ('careTeamMemberType' in partial) this.careTeamMemberType = partial.careTeamMemberType;
		if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
		if ('quality' in partial) this.quality = partial.quality;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.careTeamMemberType != undefined) res['careTeamMemberType'] = this.careTeamMemberType
		if (this.healthcarePartyId != undefined) res['healthcarePartyId'] = this.healthcarePartyId
		if (this.quality != undefined) res['quality'] = this.quality.toJSON()
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['EncryptedCareTeamMember']): EncryptedCareTeamMember {
		return new EncryptedCareTeamMember({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			careTeamMemberType: expectStringEnum(json.careTeamMemberType, true, [...path, ".careTeamMemberType"], CareTeamMemberType, 'CareTeamMemberType'),
			healthcarePartyId: expectString(json.healthcarePartyId, true, [...path, ".healthcarePartyId"]),
			quality: CodeStub.fromJSON(json.quality, [...path, ".quality"]),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
	}

}
