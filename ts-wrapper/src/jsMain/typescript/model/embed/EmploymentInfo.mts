// auto-generated file
import {CodeStub} from '../base/CodeStub.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Employer} from './Employer.mjs';
import {Encryptable} from './Encryptable.mjs';


export interface EmploymentInfo extends Encryptable {

	startDate: number | undefined;

	endDate: number | undefined;

	professionType: CodeStub | undefined;

	employer: Employer | undefined;

	readonly isEncrypted: boolean;

}

export class DecryptedEmploymentInfo {

	startDate: number | undefined = undefined;

	endDate: number | undefined = undefined;

	professionType: CodeStub | undefined = undefined;

	employer: Employer | undefined = undefined;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedEmploymentInfo>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		if ('startDate' in partial) this.startDate = partial.startDate;
		if ('endDate' in partial) this.endDate = partial.endDate;
		if ('professionType' in partial) this.professionType = partial.professionType;
		if ('employer' in partial) this.employer = partial.employer;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

}

export class EncryptedEmploymentInfo {

	startDate: number | undefined = undefined;

	endDate: number | undefined = undefined;

	professionType: CodeStub | undefined = undefined;

	employer: Employer | undefined = undefined;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedEmploymentInfo>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		if ('startDate' in partial) this.startDate = partial.startDate;
		if ('endDate' in partial) this.endDate = partial.endDate;
		if ('professionType' in partial) this.professionType = partial.professionType;
		if ('employer' in partial) this.employer = partial.employer;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

}
