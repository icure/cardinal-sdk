// auto-generated file
import {expectNumber, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';


/**
 *
 *  Represents a tag associated with a calendar item, carrying metadata about who tagged it and when.
 *  /
 */
export interface CalendarItemTag extends Encryptable {

	/**
	 *
	 *  The code identifying this tag.
	 */
	code: string | undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) when the tag was applied.
	 */
	date: number | undefined;

	/**
	 *
	 *  The identifier of the user who applied the tag.
	 */
	userId: string | undefined;

	/**
	 *
	 *  The display name of the user who applied the tag.
	 */
	userName: string | undefined;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

/**
 *
 *  Represents a tag associated with a calendar item, carrying metadata about who tagged it and when.
 *  /
 */
export class DecryptedCalendarItemTag {

	/**
	 *
	 *  The code identifying this tag.
	 */
	code: string | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) when the tag was applied.
	 */
	date: number | undefined = undefined;

	/**
	 *
	 *  The identifier of the user who applied the tag.
	 */
	userId: string | undefined = undefined;

	/**
	 *
	 *  The display name of the user who applied the tag.
	 */
	userName: string | undefined = undefined;

	/**
	 *
	 *  The base64-encoded encrypted content of this tag.
	 */
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

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.code != undefined) res['code'] = this.code
		if (this.date != undefined) res['date'] = this.date
		if (this.userId != undefined) res['userId'] = this.userId
		if (this.userName != undefined) res['userName'] = this.userName
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = false
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedCalendarItemTag']): DecryptedCalendarItemTag {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedCalendarItemTag`)
		const res = new DecryptedCalendarItemTag({
			code: expectString(extractEntry(jCpy, 'code', false, path), true, [...path, ".code"]),
			date: expectNumber(extractEntry(jCpy, 'date', false, path), true, true, [...path, ".date"]),
			userId: expectString(extractEntry(jCpy, 'userId', false, path), true, [...path, ".userId"]),
			userName: expectString(extractEntry(jCpy, 'userName', false, path), true, [...path, ".userName"]),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedCalendarItemTag at path ${path.join("")}: ${unused}`)}
		return res
	}

}

/**
 *
 *  Represents a tag associated with a calendar item, carrying metadata about who tagged it and when.
 *  /
 */
export class EncryptedCalendarItemTag {

	/**
	 *
	 *  The code identifying this tag.
	 */
	code: string | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) when the tag was applied.
	 */
	date: number | undefined = undefined;

	/**
	 *
	 *  The identifier of the user who applied the tag.
	 */
	userId: string | undefined = undefined;

	/**
	 *
	 *  The display name of the user who applied the tag.
	 */
	userName: string | undefined = undefined;

	/**
	 *
	 *  The base64-encoded encrypted content of this tag.
	 */
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

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.code != undefined) res['code'] = this.code
		if (this.date != undefined) res['date'] = this.date
		if (this.userId != undefined) res['userId'] = this.userId
		if (this.userName != undefined) res['userName'] = this.userName
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = true
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedCalendarItemTag']): EncryptedCalendarItemTag {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedCalendarItemTag`)
		const res = new EncryptedCalendarItemTag({
			code: expectString(extractEntry(jCpy, 'code', false, path), true, [...path, ".code"]),
			date: expectNumber(extractEntry(jCpy, 'date', false, path), true, true, [...path, ".date"]),
			userId: expectString(extractEntry(jCpy, 'userId', false, path), true, [...path, ".userId"]),
			userName: expectString(extractEntry(jCpy, 'userName', false, path), true, [...path, ".userName"]),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedCalendarItemTag at path ${path.join("")}: ${unused}`)}
		return res
	}

}
