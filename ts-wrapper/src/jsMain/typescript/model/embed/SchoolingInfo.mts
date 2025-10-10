// auto-generated file
import {CodeStub} from '../base/CodeStub.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';


export interface SchoolingInfo extends Encryptable {

	startDate: number | undefined;

	endDate: number | undefined;

	school: string | undefined;

	typeOfEducation: CodeStub | undefined;

	readonly isEncrypted: boolean;

}

export class DecryptedSchoolingInfo {

	startDate: number | undefined = undefined;

	endDate: number | undefined = undefined;

	school: string | undefined = undefined;

	typeOfEducation: CodeStub | undefined = undefined;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedSchoolingInfo>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		if ('startDate' in partial) this.startDate = partial.startDate;
		if ('endDate' in partial) this.endDate = partial.endDate;
		if ('school' in partial) this.school = partial.school;
		if ('typeOfEducation' in partial) this.typeOfEducation = partial.typeOfEducation;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

}

export class EncryptedSchoolingInfo {

	startDate: number | undefined = undefined;

	endDate: number | undefined = undefined;

	school: string | undefined = undefined;

	typeOfEducation: CodeStub | undefined = undefined;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedSchoolingInfo>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		if ('startDate' in partial) this.startDate = partial.startDate;
		if ('endDate' in partial) this.endDate = partial.endDate;
		if ('school' in partial) this.school = partial.school;
		if ('typeOfEducation' in partial) this.typeOfEducation = partial.typeOfEducation;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

}
