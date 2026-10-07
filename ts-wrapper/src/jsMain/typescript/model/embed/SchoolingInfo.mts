// auto-generated file
import {expectNumber, expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {CodeStub} from '../base/CodeStub.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';


/**
 *
 *  Represents schooling information for a patient, including the period, school name, and type of education.
 *  /
 */
export interface SchoolingInfo extends Encryptable {

	/**
	 *
	 *  The start date (unix epoch in ms) of the schooling period.
	 */
	startDate: number | undefined;

	/**
	 *
	 *  The end date (unix epoch in ms) of the schooling period.
	 */
	endDate: number | undefined;

	/**
	 *
	 *  The name of the school.
	 */
	school: string | undefined;

	/**
	 *
	 *  A code describing the type of education.
	 */
	typeOfEducation: CodeStub | undefined;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

/**
 *
 *  Represents schooling information for a patient, including the period, school name, and type of education.
 *  /
 */
export class DecryptedSchoolingInfo {

	/**
	 *
	 *  The start date (unix epoch in ms) of the schooling period.
	 */
	startDate: number | undefined = undefined;

	/**
	 *
	 *  The end date (unix epoch in ms) of the schooling period.
	 */
	endDate: number | undefined = undefined;

	/**
	 *
	 *  The name of the school.
	 */
	school: string | undefined = undefined;

	/**
	 *
	 *  A code describing the type of education.
	 */
	typeOfEducation: CodeStub | undefined = undefined;

	/**
	 *
	 *  The base64-encoded encrypted content of this schooling info.
	 */
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

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.startDate != undefined) res['startDate'] = this.startDate
		if (this.endDate != undefined) res['endDate'] = this.endDate
		if (this.school != undefined) res['school'] = this.school
		if (this.typeOfEducation != undefined) res['typeOfEducation'] = this.typeOfEducation.toJSON()
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = false
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedSchoolingInfo']): DecryptedSchoolingInfo {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedSchoolingInfo`)
		const res = new DecryptedSchoolingInfo({
			startDate: expectNumber(extractEntry(jCpy, 'startDate', false, path), true, true, [...path, ".startDate"]),
			endDate: expectNumber(extractEntry(jCpy, 'endDate', false, path), true, true, [...path, ".endDate"]),
			school: expectString(extractEntry(jCpy, 'school', false, path), true, [...path, ".school"]),
			typeOfEducation: expectObject(extractEntry(jCpy, 'typeOfEducation', false, path), true, ignoreUnknownKeys, [...path, ".typeOfEducation"], CodeStub.fromJSON),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedSchoolingInfo at path ${path.join("")}: ${unused}`)}
		return res
	}

}

/**
 *
 *  Represents schooling information for a patient, including the period, school name, and type of education.
 *  /
 */
export class EncryptedSchoolingInfo {

	/**
	 *
	 *  The start date (unix epoch in ms) of the schooling period.
	 */
	startDate: number | undefined = undefined;

	/**
	 *
	 *  The end date (unix epoch in ms) of the schooling period.
	 */
	endDate: number | undefined = undefined;

	/**
	 *
	 *  The name of the school.
	 */
	school: string | undefined = undefined;

	/**
	 *
	 *  A code describing the type of education.
	 */
	typeOfEducation: CodeStub | undefined = undefined;

	/**
	 *
	 *  The base64-encoded encrypted content of this schooling info.
	 */
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

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.startDate != undefined) res['startDate'] = this.startDate
		if (this.endDate != undefined) res['endDate'] = this.endDate
		if (this.school != undefined) res['school'] = this.school
		if (this.typeOfEducation != undefined) res['typeOfEducation'] = this.typeOfEducation.toJSON()
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = true
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedSchoolingInfo']): EncryptedSchoolingInfo {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedSchoolingInfo`)
		const res = new EncryptedSchoolingInfo({
			startDate: expectNumber(extractEntry(jCpy, 'startDate', false, path), true, true, [...path, ".startDate"]),
			endDate: expectNumber(extractEntry(jCpy, 'endDate', false, path), true, true, [...path, ".endDate"]),
			school: expectString(extractEntry(jCpy, 'school', false, path), true, [...path, ".school"]),
			typeOfEducation: expectObject(extractEntry(jCpy, 'typeOfEducation', false, path), true, ignoreUnknownKeys, [...path, ".typeOfEducation"], CodeStub.fromJSON),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedSchoolingInfo at path ${path.join("")}: ${unused}`)}
		return res
	}

}
