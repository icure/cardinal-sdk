// auto-generated file
import {expectString, expectStringEnum} from '../../internal/JsonDecodeUtils.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';
import {TelecomType} from './TelecomType.mjs';


export interface Telecom extends Encryptable {

	telecomType: TelecomType | undefined;

	telecomNumber: string | undefined;

	telecomDescription: string | undefined;

	readonly isEncrypted: boolean;

}

export class DecryptedTelecom {

	telecomType: TelecomType | undefined = undefined;

	telecomNumber: string | undefined = undefined;

	telecomDescription: string | undefined = undefined;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedTelecom>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		if ('telecomType' in partial) this.telecomType = partial.telecomType;
		if ('telecomNumber' in partial) this.telecomNumber = partial.telecomNumber;
		if ('telecomDescription' in partial) this.telecomDescription = partial.telecomDescription;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.telecomType != undefined) res['telecomType'] = this.telecomType
		if (this.telecomNumber != undefined) res['telecomNumber'] = this.telecomNumber
		if (this.telecomDescription != undefined) res['telecomDescription'] = this.telecomDescription
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['DecryptedTelecom']): DecryptedTelecom {
		return new DecryptedTelecom({
			telecomType: expectStringEnum(json.telecomType, true, [...path, ".telecomType"], TelecomType, 'TelecomType'),
			telecomNumber: expectString(json.telecomNumber, true, [...path, ".telecomNumber"]),
			telecomDescription: expectString(json.telecomDescription, true, [...path, ".telecomDescription"]),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
	}

}

export class EncryptedTelecom {

	telecomType: TelecomType | undefined = undefined;

	telecomNumber: string | undefined = undefined;

	telecomDescription: string | undefined = undefined;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedTelecom>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		if ('telecomType' in partial) this.telecomType = partial.telecomType;
		if ('telecomNumber' in partial) this.telecomNumber = partial.telecomNumber;
		if ('telecomDescription' in partial) this.telecomDescription = partial.telecomDescription;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.telecomType != undefined) res['telecomType'] = this.telecomType
		if (this.telecomNumber != undefined) res['telecomNumber'] = this.telecomNumber
		if (this.telecomDescription != undefined) res['telecomDescription'] = this.telecomDescription
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['EncryptedTelecom']): EncryptedTelecom {
		return new EncryptedTelecom({
			telecomType: expectStringEnum(json.telecomType, true, [...path, ".telecomType"], TelecomType, 'TelecomType'),
			telecomNumber: expectString(json.telecomNumber, true, [...path, ".telecomNumber"]),
			telecomDescription: expectString(json.telecomDescription, true, [...path, ".telecomDescription"]),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
	}

}
