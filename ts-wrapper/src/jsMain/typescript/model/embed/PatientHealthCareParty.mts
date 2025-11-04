// auto-generated file
import {expectArray, expectBoolean, expectMap, expectString, expectStringEnum} from '../../internal/JsonDecodeUtils.mjs';
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

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.type != undefined) res['type'] = this.type
		if (this.healthcarePartyId != undefined) res['healthcarePartyId'] = this.healthcarePartyId
		res['sendFormats'] = Object.fromEntries(Object.entries(this.sendFormats).map(([k0, v0]) => [k0, v0]))
		res['referralPeriods'] = this.referralPeriods.map((x0) => x0.toJSON() )
		res['referral'] = this.referral
		if (this.properties != undefined) res['properties'] = this.properties.map((x0) => x0.toJSON() )
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['DecryptedPatientHealthCareParty']): DecryptedPatientHealthCareParty {
		return new DecryptedPatientHealthCareParty({
			type: expectStringEnum(json.type, true, [...path, ".type"], PatientHealthCarePartyType, 'PatientHealthCarePartyType'),
			healthcarePartyId: expectString(json.healthcarePartyId, true, [...path, ".healthcarePartyId"]),
			sendFormats: expectMap(
				json.sendFormats,
				false,
				[...path, ".sendFormats"],
				(k0, p0) => expectStringEnum(k0, false, p0, TelecomType, 'TelecomType'),
				(v0, p0) => expectString(v0, false, p0)
			),
			referralPeriods: expectArray(json.referralPeriods, false, [...path, ".referralPeriods"], (x0, p0) => ReferralPeriod.fromJSON(x0, p0)),
			referral: expectBoolean(json.referral, false, [...path, ".referral"]),
			properties: expectArray(json.properties, true, [...path, ".properties"], (x0, p0) => DecryptedPropertyStub.fromJSON(x0, p0)),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
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

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.type != undefined) res['type'] = this.type
		if (this.healthcarePartyId != undefined) res['healthcarePartyId'] = this.healthcarePartyId
		res['sendFormats'] = Object.fromEntries(Object.entries(this.sendFormats).map(([k0, v0]) => [k0, v0]))
		res['referralPeriods'] = this.referralPeriods.map((x0) => x0.toJSON() )
		res['referral'] = this.referral
		if (this.properties != undefined) res['properties'] = this.properties.map((x0) => x0.toJSON() )
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['EncryptedPatientHealthCareParty']): EncryptedPatientHealthCareParty {
		return new EncryptedPatientHealthCareParty({
			type: expectStringEnum(json.type, true, [...path, ".type"], PatientHealthCarePartyType, 'PatientHealthCarePartyType'),
			healthcarePartyId: expectString(json.healthcarePartyId, true, [...path, ".healthcarePartyId"]),
			sendFormats: expectMap(
				json.sendFormats,
				false,
				[...path, ".sendFormats"],
				(k0, p0) => expectStringEnum(k0, false, p0, TelecomType, 'TelecomType'),
				(v0, p0) => expectString(v0, false, p0)
			),
			referralPeriods: expectArray(json.referralPeriods, false, [...path, ".referralPeriods"], (x0, p0) => ReferralPeriod.fromJSON(x0, p0)),
			referral: expectBoolean(json.referral, false, [...path, ".referral"]),
			properties: expectArray(json.properties, true, [...path, ".properties"], (x0, p0) => EncryptedPropertyStub.fromJSON(x0, p0)),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
	}

}
