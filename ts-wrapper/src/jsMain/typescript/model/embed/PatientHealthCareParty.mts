// auto-generated file
import {expectArray, expectBoolean, expectMap, expectObject, expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {DecryptedPropertyStub, EncryptedPropertyStub, PropertyStub} from '../PropertyStub.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';
import {PatientHealthCarePartyType} from './PatientHealthCarePartyType.mjs';
import {ReferralPeriod} from './ReferralPeriod.mjs';
import {TelecomType} from './TelecomType.mjs';


export interface PatientHealthCareParty extends Encryptable {

	type: PatientHealthCarePartyType | undefined;

	healthcarePartyId: string | undefined;

	sendFormats: { [ key in TelecomType ]?: string };

	referralPeriods: Array<ReferralPeriod>;

	referral: boolean;

	properties: Array<PropertyStub> | undefined;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

export class DecryptedPatientHealthCareParty {

	type: PatientHealthCarePartyType | undefined = undefined;

	healthcarePartyId: string | undefined = undefined;

	sendFormats: { [ key in TelecomType ]?: string } = {};

	referralPeriods: Array<ReferralPeriod> = [];

	referral: boolean = false;

	properties: Array<DecryptedPropertyStub> | undefined = undefined;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedPatientHealthCareParty>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		if ('type' in partial) this.type = partial.type;
		if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
		if ('sendFormats' in partial && partial.sendFormats !== undefined) this.sendFormats = partial.sendFormats;
		if ('referralPeriods' in partial && partial.referralPeriods !== undefined) this.referralPeriods = partial.referralPeriods;
		if ('referral' in partial && partial.referral !== undefined) this.referral = partial.referral;
		if ('properties' in partial) this.properties = partial.properties;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.type != undefined) res['type'] = this.type
		if (this.healthcarePartyId != undefined) res['healthcarePartyId'] = this.healthcarePartyId
		res['sendFormats'] = Object.fromEntries(Object.entries(this.sendFormats).map(([k0, v0]) => [k0, v0]))
		res['referralPeriods'] = this.referralPeriods.map((x0) => x0.toJSON() )
		res['referral'] = this.referral
		if (this.properties != undefined) res['properties'] = this.properties.map((x0) => x0.toJSON() )
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = false
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedPatientHealthCareParty']): DecryptedPatientHealthCareParty {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedPatientHealthCareParty`)
		const res = new DecryptedPatientHealthCareParty({
			type: expectStringEnum(extractEntry(jCpy, 'type', false, path), true, [...path, ".type"], PatientHealthCarePartyType, 'PatientHealthCarePartyType'),
			healthcarePartyId: expectString(extractEntry(jCpy, 'healthcarePartyId', false, path), true, [...path, ".healthcarePartyId"]),
			sendFormats: expectMap(
				extractEntry(jCpy, 'sendFormats', false, path),
				false,
				[...path, ".sendFormats"],
				(k0, p0) => expectStringEnum(k0, false, p0, TelecomType, 'TelecomType'),
				(v0, p0) => expectString(v0, false, p0)
			),
			referralPeriods: expectArray(extractEntry(jCpy, 'referralPeriods', false, path), false, [...path, ".referralPeriods"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, ReferralPeriod.fromJSON)),
			referral: expectBoolean(extractEntry(jCpy, 'referral', false, path), false, [...path, ".referral"]),
			properties: expectArray(extractEntry(jCpy, 'properties', false, path), true, [...path, ".properties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedPropertyStub.fromJSON)),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedPatientHealthCareParty at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export class EncryptedPatientHealthCareParty {

	type: PatientHealthCarePartyType | undefined = undefined;

	healthcarePartyId: string | undefined = undefined;

	sendFormats: { [ key in TelecomType ]?: string } = {};

	referralPeriods: Array<ReferralPeriod> = [];

	referral: boolean = false;

	properties: Array<EncryptedPropertyStub> | undefined = undefined;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedPatientHealthCareParty>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		if ('type' in partial) this.type = partial.type;
		if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
		if ('sendFormats' in partial && partial.sendFormats !== undefined) this.sendFormats = partial.sendFormats;
		if ('referralPeriods' in partial && partial.referralPeriods !== undefined) this.referralPeriods = partial.referralPeriods;
		if ('referral' in partial && partial.referral !== undefined) this.referral = partial.referral;
		if ('properties' in partial) this.properties = partial.properties;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.type != undefined) res['type'] = this.type
		if (this.healthcarePartyId != undefined) res['healthcarePartyId'] = this.healthcarePartyId
		res['sendFormats'] = Object.fromEntries(Object.entries(this.sendFormats).map(([k0, v0]) => [k0, v0]))
		res['referralPeriods'] = this.referralPeriods.map((x0) => x0.toJSON() )
		res['referral'] = this.referral
		if (this.properties != undefined) res['properties'] = this.properties.map((x0) => x0.toJSON() )
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = true
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedPatientHealthCareParty']): EncryptedPatientHealthCareParty {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedPatientHealthCareParty`)
		const res = new EncryptedPatientHealthCareParty({
			type: expectStringEnum(extractEntry(jCpy, 'type', false, path), true, [...path, ".type"], PatientHealthCarePartyType, 'PatientHealthCarePartyType'),
			healthcarePartyId: expectString(extractEntry(jCpy, 'healthcarePartyId', false, path), true, [...path, ".healthcarePartyId"]),
			sendFormats: expectMap(
				extractEntry(jCpy, 'sendFormats', false, path),
				false,
				[...path, ".sendFormats"],
				(k0, p0) => expectStringEnum(k0, false, p0, TelecomType, 'TelecomType'),
				(v0, p0) => expectString(v0, false, p0)
			),
			referralPeriods: expectArray(extractEntry(jCpy, 'referralPeriods', false, path), false, [...path, ".referralPeriods"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, ReferralPeriod.fromJSON)),
			referral: expectBoolean(extractEntry(jCpy, 'referral', false, path), false, [...path, ".referral"]),
			properties: expectArray(extractEntry(jCpy, 'properties', false, path), true, [...path, ".properties"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, EncryptedPropertyStub.fromJSON)),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedPatientHealthCareParty at path ${path.join("")}: ${unused}`)}
		return res
	}

}
