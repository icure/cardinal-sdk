// auto-generated file
import {expectNumber, expectString} from '../../internal/JsonDecodeUtils.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';


export interface CalendarItemTag extends Encryptable {

	code: string | undefined;

	date: number | undefined;

	userId: string | undefined;

	userName: string | undefined;

	readonly isEncrypted: boolean;

}

export class DecryptedCalendarItemTag {

	code: string | undefined = undefined;

	date: number | undefined = undefined;

	userId: string | undefined = undefined;

	userName: string | undefined = undefined;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedCalendarItemTag>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		if ('code' in partial) this.code = partial.code;
		if ('date' in partial) this.date = partial.date;
		if ('userId' in partial) this.userId = partial.userId;
		if ('userName' in partial) this.userName = partial.userName;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.code != undefined) res['code'] = this.code
		if (this.date != undefined) res['date'] = this.date
		if (this.userId != undefined) res['userId'] = this.userId
		if (this.userName != undefined) res['userName'] = this.userName
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['DecryptedCalendarItemTag']): DecryptedCalendarItemTag {
		return new DecryptedCalendarItemTag({
			code: expectString(json.code, true, [...path, ".code"]),
			date: expectNumber(json.date, true, true, [...path, ".date"]),
			userId: expectString(json.userId, true, [...path, ".userId"]),
			userName: expectString(json.userName, true, [...path, ".userName"]),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
	}

}

export class EncryptedCalendarItemTag {

	code: string | undefined = undefined;

	date: number | undefined = undefined;

	userId: string | undefined = undefined;

	userName: string | undefined = undefined;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedCalendarItemTag>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		if ('code' in partial) this.code = partial.code;
		if ('date' in partial) this.date = partial.date;
		if ('userId' in partial) this.userId = partial.userId;
		if ('userName' in partial) this.userName = partial.userName;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.code != undefined) res['code'] = this.code
		if (this.date != undefined) res['date'] = this.date
		if (this.userId != undefined) res['userId'] = this.userId
		if (this.userName != undefined) res['userName'] = this.userName
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['EncryptedCalendarItemTag']): EncryptedCalendarItemTag {
		return new EncryptedCalendarItemTag({
			code: expectString(json.code, true, [...path, ".code"]),
			date: expectNumber(json.date, true, true, [...path, ".date"]),
			userId: expectString(json.userId, true, [...path, ".userId"]),
			userName: expectString(json.userName, true, [...path, ".userName"]),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
	}

}
