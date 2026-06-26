// auto-generated file
import {expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';
import {PartnershipStatus} from './PartnershipStatus.mjs';
import {PartnershipType} from './PartnershipType.mjs';


/**
 *
 *  Represents a relationship between a patient and another person (contact person or another
 *  patient).
 *  /
 */
export interface Partnership extends Encryptable {

	/**
	 *
	 *  The type of relationship (from CD-CONTACT-PERSON codes).
	 */
	type: PartnershipType | undefined;

	/**
	 *
	 *  The status of the relationship.
	 */
	status: PartnershipStatus | undefined;

	/**
	 *
	 *  The UUID of the contact person or patient in this relationship.
	 */
	partnerId: string | undefined;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

/**
 *
 *  Represents a relationship between a patient and another person (contact person or another
 *  patient).
 *  /
 */
export class DecryptedPartnership {

	/**
	 *
	 *  The type of relationship (from CD-CONTACT-PERSON codes).
	 */
	type: PartnershipType | undefined = undefined;

	/**
	 *
	 *  The status of the relationship.
	 */
	status: PartnershipStatus | undefined = undefined;

	/**
	 *
	 *  The UUID of the contact person or patient in this relationship.
	 */
	partnerId: string | undefined = undefined;

	/**
	 *
	 *  Deprecated. Description of the relationship from the other person to this patient.
	 */
	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedPartnership>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		if ('type' in partial) this.type = partial.type;
		if ('status' in partial) this.status = partial.status;
		if ('partnerId' in partial) this.partnerId = partial.partnerId;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.type != undefined) res['type'] = this.type
		if (this.status != undefined) res['status'] = this.status
		if (this.partnerId != undefined) res['partnerId'] = this.partnerId
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = false
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedPartnership']): DecryptedPartnership {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedPartnership`)
		const res = new DecryptedPartnership({
			type: expectStringEnum(extractEntry(jCpy, 'type', false, path), true, [...path, ".type"], PartnershipType, 'PartnershipType'),
			status: expectStringEnum(extractEntry(jCpy, 'status', false, path), true, [...path, ".status"], PartnershipStatus, 'PartnershipStatus'),
			partnerId: expectString(extractEntry(jCpy, 'partnerId', false, path), true, [...path, ".partnerId"]),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedPartnership at path ${path.join("")}: ${unused}`)}
		return res
	}

}

/**
 *
 *  Represents a relationship between a patient and another person (contact person or another
 *  patient).
 *  /
 */
export class EncryptedPartnership {

	/**
	 *
	 *  The type of relationship (from CD-CONTACT-PERSON codes).
	 */
	type: PartnershipType | undefined = undefined;

	/**
	 *
	 *  The status of the relationship.
	 */
	status: PartnershipStatus | undefined = undefined;

	/**
	 *
	 *  The UUID of the contact person or patient in this relationship.
	 */
	partnerId: string | undefined = undefined;

	/**
	 *
	 *  Deprecated. Description of the relationship from the other person to this patient.
	 */
	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedPartnership>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		if ('type' in partial) this.type = partial.type;
		if ('status' in partial) this.status = partial.status;
		if ('partnerId' in partial) this.partnerId = partial.partnerId;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.type != undefined) res['type'] = this.type
		if (this.status != undefined) res['status'] = this.status
		if (this.partnerId != undefined) res['partnerId'] = this.partnerId
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = true
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedPartnership']): EncryptedPartnership {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedPartnership`)
		const res = new EncryptedPartnership({
			type: expectStringEnum(extractEntry(jCpy, 'type', false, path), true, [...path, ".type"], PartnershipType, 'PartnershipType'),
			status: expectStringEnum(extractEntry(jCpy, 'status', false, path), true, [...path, ".status"], PartnershipStatus, 'PartnershipStatus'),
			partnerId: expectString(extractEntry(jCpy, 'partnerId', false, path), true, [...path, ".partnerId"]),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedPartnership at path ${path.join("")}: ${unused}`)}
		return res
	}

}
