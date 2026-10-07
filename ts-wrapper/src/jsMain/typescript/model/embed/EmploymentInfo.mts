// auto-generated file
import {expectNumber, expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {CodeStub} from '../base/CodeStub.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Employer} from './Employer.mjs';
import {Encryptable} from './Encryptable.mjs';


/**
 *
 *  Represents employment information for a patient, including the period, profession type, and employer details.
 *  /
 */
export interface EmploymentInfo extends Encryptable {

	/**
	 *
	 *  The start date (unix epoch in ms) of the employment.
	 */
	startDate: number | undefined;

	/**
	 *
	 *  The end date (unix epoch in ms) of the employment.
	 */
	endDate: number | undefined;

	/**
	 *
	 *  A code describing the profession type.
	 */
	professionType: CodeStub | undefined;

	/**
	 *
	 *  The employer details.
	 */
	employer: Employer | undefined;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

/**
 *
 *  Represents employment information for a patient, including the period, profession type, and employer details.
 *  /
 */
export class DecryptedEmploymentInfo {

	/**
	 *
	 *  The start date (unix epoch in ms) of the employment.
	 */
	startDate: number | undefined = undefined;

	/**
	 *
	 *  The end date (unix epoch in ms) of the employment.
	 */
	endDate: number | undefined = undefined;

	/**
	 *
	 *  A code describing the profession type.
	 */
	professionType: CodeStub | undefined = undefined;

	/**
	 *
	 *  The employer details.
	 */
	employer: Employer | undefined = undefined;

	/**
	 *
	 *  The base64-encoded encrypted content of this employment info.
	 */
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

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.startDate != undefined) res['startDate'] = this.startDate
		if (this.endDate != undefined) res['endDate'] = this.endDate
		if (this.professionType != undefined) res['professionType'] = this.professionType.toJSON()
		if (this.employer != undefined) res['employer'] = this.employer.toJSON()
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = false
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedEmploymentInfo']): DecryptedEmploymentInfo {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedEmploymentInfo`)
		const res = new DecryptedEmploymentInfo({
			startDate: expectNumber(extractEntry(jCpy, 'startDate', false, path), true, true, [...path, ".startDate"]),
			endDate: expectNumber(extractEntry(jCpy, 'endDate', false, path), true, true, [...path, ".endDate"]),
			professionType: expectObject(extractEntry(jCpy, 'professionType', false, path), true, ignoreUnknownKeys, [...path, ".professionType"], CodeStub.fromJSON),
			employer: expectObject(extractEntry(jCpy, 'employer', false, path), true, ignoreUnknownKeys, [...path, ".employer"], Employer.fromJSON),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedEmploymentInfo at path ${path.join("")}: ${unused}`)}
		return res
	}

}

/**
 *
 *  Represents employment information for a patient, including the period, profession type, and employer details.
 *  /
 */
export class EncryptedEmploymentInfo {

	/**
	 *
	 *  The start date (unix epoch in ms) of the employment.
	 */
	startDate: number | undefined = undefined;

	/**
	 *
	 *  The end date (unix epoch in ms) of the employment.
	 */
	endDate: number | undefined = undefined;

	/**
	 *
	 *  A code describing the profession type.
	 */
	professionType: CodeStub | undefined = undefined;

	/**
	 *
	 *  The employer details.
	 */
	employer: Employer | undefined = undefined;

	/**
	 *
	 *  The base64-encoded encrypted content of this employment info.
	 */
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

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.startDate != undefined) res['startDate'] = this.startDate
		if (this.endDate != undefined) res['endDate'] = this.endDate
		if (this.professionType != undefined) res['professionType'] = this.professionType.toJSON()
		if (this.employer != undefined) res['employer'] = this.employer.toJSON()
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = true
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedEmploymentInfo']): EncryptedEmploymentInfo {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedEmploymentInfo`)
		const res = new EncryptedEmploymentInfo({
			startDate: expectNumber(extractEntry(jCpy, 'startDate', false, path), true, true, [...path, ".startDate"]),
			endDate: expectNumber(extractEntry(jCpy, 'endDate', false, path), true, true, [...path, ".endDate"]),
			professionType: expectObject(extractEntry(jCpy, 'professionType', false, path), true, ignoreUnknownKeys, [...path, ".professionType"], CodeStub.fromJSON),
			employer: expectObject(extractEntry(jCpy, 'employer', false, path), true, ignoreUnknownKeys, [...path, ".employer"], Employer.fromJSON),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedEmploymentInfo at path ${path.join("")}: ${unused}`)}
		return res
	}

}
