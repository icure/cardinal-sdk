// auto-generated file
import {expectObject, expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../../utils/Id.mjs';
import {CodeStub} from '../base/CodeStub.mjs';
import {Identifiable} from '../base/Identifiable.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {CareTeamMemberType} from './CareTeamMemberType.mjs';
import {Encryptable} from './Encryptable.mjs';


/**
 *
 *  Represents a member of a care team involved in a patient's care, linking a healthcare party with
 *  their role.
 *  /
 */
export interface CareTeamMember extends Encryptable, Identifiable<string> {

	/**
	 *
	 *  The type of care team member (physician, specialist, or other).
	 */
	careTeamMemberType: CareTeamMemberType | undefined;

	/**
	 *
	 *  The identifier of the associated healthcare party.
	 */
	healthcarePartyId: string | undefined;

	/**
	 *
	 *  A code describing the quality or qualification of this care team member.
	 */
	quality: CodeStub | undefined;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

/**
 *
 *  Represents a member of a care team involved in a patient's care, linking a healthcare party with
 *  their role.
 *  /
 */
export class DecryptedCareTeamMember {

	/**
	 *
	 *  The unique identifier of this care team member.
	 */
	id: string;

	/**
	 *
	 *  The type of care team member (physician, specialist, or other).
	 */
	careTeamMemberType: CareTeamMemberType | undefined = undefined;

	/**
	 *
	 *  The identifier of the associated healthcare party.
	 */
	healthcarePartyId: string | undefined = undefined;

	/**
	 *
	 *  A code describing the quality or qualification of this care team member.
	 */
	quality: CodeStub | undefined = undefined;

	/**
	 *
	 *  The base64-encoded encrypted content of this care team member.
	 */
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

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.careTeamMemberType != undefined) res['careTeamMemberType'] = this.careTeamMemberType
		if (this.healthcarePartyId != undefined) res['healthcarePartyId'] = this.healthcarePartyId
		if (this.quality != undefined) res['quality'] = this.quality.toJSON()
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = false
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedCareTeamMember']): DecryptedCareTeamMember {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedCareTeamMember`)
		const res = new DecryptedCareTeamMember({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			careTeamMemberType: expectStringEnum(extractEntry(jCpy, 'careTeamMemberType', false, path), true, [...path, ".careTeamMemberType"], CareTeamMemberType, 'CareTeamMemberType'),
			healthcarePartyId: expectString(extractEntry(jCpy, 'healthcarePartyId', false, path), true, [...path, ".healthcarePartyId"]),
			quality: expectObject(extractEntry(jCpy, 'quality', false, path), true, ignoreUnknownKeys, [...path, ".quality"], CodeStub.fromJSON),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedCareTeamMember at path ${path.join("")}: ${unused}`)}
		return res
	}

}

/**
 *
 *  Represents a member of a care team involved in a patient's care, linking a healthcare party with
 *  their role.
 *  /
 */
export class EncryptedCareTeamMember {

	/**
	 *
	 *  The unique identifier of this care team member.
	 */
	id: string;

	/**
	 *
	 *  The type of care team member (physician, specialist, or other).
	 */
	careTeamMemberType: CareTeamMemberType | undefined = undefined;

	/**
	 *
	 *  The identifier of the associated healthcare party.
	 */
	healthcarePartyId: string | undefined = undefined;

	/**
	 *
	 *  A code describing the quality or qualification of this care team member.
	 */
	quality: CodeStub | undefined = undefined;

	/**
	 *
	 *  The base64-encoded encrypted content of this care team member.
	 */
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

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.careTeamMemberType != undefined) res['careTeamMemberType'] = this.careTeamMemberType
		if (this.healthcarePartyId != undefined) res['healthcarePartyId'] = this.healthcarePartyId
		if (this.quality != undefined) res['quality'] = this.quality.toJSON()
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = true
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedCareTeamMember']): EncryptedCareTeamMember {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedCareTeamMember`)
		const res = new EncryptedCareTeamMember({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			careTeamMemberType: expectStringEnum(extractEntry(jCpy, 'careTeamMemberType', false, path), true, [...path, ".careTeamMemberType"], CareTeamMemberType, 'CareTeamMemberType'),
			healthcarePartyId: expectString(extractEntry(jCpy, 'healthcarePartyId', false, path), true, [...path, ".healthcarePartyId"]),
			quality: expectObject(extractEntry(jCpy, 'quality', false, path), true, ignoreUnknownKeys, [...path, ".quality"], CodeStub.fromJSON),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedCareTeamMember at path ${path.join("")}: ${unused}`)}
		return res
	}

}
