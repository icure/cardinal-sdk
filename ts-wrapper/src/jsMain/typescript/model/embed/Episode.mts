// auto-generated file
import {expectNumber, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../../utils/Id.mjs';
import {Identifiable} from '../base/Identifiable.mjs';
import {Named} from '../base/Named.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';


export interface Episode extends Encryptable, Identifiable<string>, Named {

	comment: string | undefined;

	startDate: number | undefined;

	endDate: number | undefined;

	readonly isEncrypted: boolean;

}

export class DecryptedEpisode {

	id: string;

	name: string | undefined = undefined;

	comment: string | undefined = undefined;

	startDate: number | undefined = undefined;

	endDate: number | undefined = undefined;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedEpisode>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		this.id = partial.id ?? randomUuid();
		if ('name' in partial) this.name = partial.name;
		if ('comment' in partial) this.comment = partial.comment;
		if ('startDate' in partial) this.startDate = partial.startDate;
		if ('endDate' in partial) this.endDate = partial.endDate;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.name != undefined) res['name'] = this.name
		if (this.comment != undefined) res['comment'] = this.comment
		if (this.startDate != undefined) res['startDate'] = this.startDate
		if (this.endDate != undefined) res['endDate'] = this.endDate
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = false
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedEpisode']): DecryptedEpisode {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false`)
		const res = new DecryptedEpisode({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			name: expectString(extractEntry(jCpy, 'name', false, path), true, [...path, ".name"]),
			comment: expectString(extractEntry(jCpy, 'comment', false, path), true, [...path, ".comment"]),
			startDate: expectNumber(extractEntry(jCpy, 'startDate', false, path), true, true, [...path, ".startDate"]),
			endDate: expectNumber(extractEntry(jCpy, 'endDate', false, path), true, true, [...path, ".endDate"]),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedEpisode at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export class EncryptedEpisode {

	id: string;

	name: string | undefined = undefined;

	comment: string | undefined = undefined;

	startDate: number | undefined = undefined;

	endDate: number | undefined = undefined;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedEpisode>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		this.id = partial.id ?? randomUuid();
		if ('name' in partial) this.name = partial.name;
		if ('comment' in partial) this.comment = partial.comment;
		if ('startDate' in partial) this.startDate = partial.startDate;
		if ('endDate' in partial) this.endDate = partial.endDate;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.name != undefined) res['name'] = this.name
		if (this.comment != undefined) res['comment'] = this.comment
		if (this.startDate != undefined) res['startDate'] = this.startDate
		if (this.endDate != undefined) res['endDate'] = this.endDate
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = true
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedEpisode']): EncryptedEpisode {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true`)
		const res = new EncryptedEpisode({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			name: expectString(extractEntry(jCpy, 'name', false, path), true, [...path, ".name"]),
			comment: expectString(extractEntry(jCpy, 'comment', false, path), true, [...path, ".comment"]),
			startDate: expectNumber(extractEntry(jCpy, 'startDate', false, path), true, true, [...path, ".startDate"]),
			endDate: expectNumber(extractEntry(jCpy, 'endDate', false, path), true, true, [...path, ".endDate"]),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedEpisode at path ${path.join("")}: ${unused}`)}
		return res
	}

}
