// auto-generated file
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

}
