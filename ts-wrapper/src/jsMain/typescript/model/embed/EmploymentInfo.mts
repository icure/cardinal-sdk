// auto-generated file
import {expectNumber, expectString} from '../../internal/JsonDecodeUtils.mjs';
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

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.startDate != undefined) res['startDate'] = this.startDate
		if (this.endDate != undefined) res['endDate'] = this.endDate
		if (this.professionType != undefined) res['professionType'] = this.professionType.toJSON()
		if (this.employer != undefined) res['employer'] = this.employer.toJSON()
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['DecryptedEmploymentInfo']): DecryptedEmploymentInfo {
		return new DecryptedEmploymentInfo({
			startDate: expectNumber(json.startDate, true, true, [...path, ".startDate"]),
			endDate: expectNumber(json.endDate, true, true, [...path, ".endDate"]),
			professionType: CodeStub.fromJSON(json.professionType, [...path, ".professionType"]),
			employer: Employer.fromJSON(json.employer, [...path, ".employer"]),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
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

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.startDate != undefined) res['startDate'] = this.startDate
		if (this.endDate != undefined) res['endDate'] = this.endDate
		if (this.professionType != undefined) res['professionType'] = this.professionType.toJSON()
		if (this.employer != undefined) res['employer'] = this.employer.toJSON()
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['EncryptedEmploymentInfo']): EncryptedEmploymentInfo {
		return new EncryptedEmploymentInfo({
			startDate: expectNumber(json.startDate, true, true, [...path, ".startDate"]),
			endDate: expectNumber(json.endDate, true, true, [...path, ".endDate"]),
			professionType: CodeStub.fromJSON(json.professionType, [...path, ".professionType"]),
			employer: Employer.fromJSON(json.employer, [...path, ".employer"]),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
	}

}
