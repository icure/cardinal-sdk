// auto-generated file
import {expectArray, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';


export interface FinancialInstitutionInformation extends Encryptable {

	name: string | undefined;

	key: string | undefined;

	bankAccount: string | undefined;

	bic: string | undefined;

	proxyBankAccount: string | undefined;

	proxyBic: string | undefined;

	preferredFiiForPartners: Array<string>;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

export class DecryptedFinancialInstitutionInformation {

	name: string | undefined = undefined;

	key: string | undefined = undefined;

	bankAccount: string | undefined = undefined;

	bic: string | undefined = undefined;

	proxyBankAccount: string | undefined = undefined;

	proxyBic: string | undefined = undefined;

	preferredFiiForPartners: Array<string> = [];

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedFinancialInstitutionInformation>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		if ('name' in partial) this.name = partial.name;
		if ('key' in partial) this.key = partial.key;
		if ('bankAccount' in partial) this.bankAccount = partial.bankAccount;
		if ('bic' in partial) this.bic = partial.bic;
		if ('proxyBankAccount' in partial) this.proxyBankAccount = partial.proxyBankAccount;
		if ('proxyBic' in partial) this.proxyBic = partial.proxyBic;
		if ('preferredFiiForPartners' in partial && partial.preferredFiiForPartners !== undefined) this.preferredFiiForPartners = partial.preferredFiiForPartners;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.name != undefined) res['name'] = this.name
		if (this.key != undefined) res['key'] = this.key
		if (this.bankAccount != undefined) res['bankAccount'] = this.bankAccount
		if (this.bic != undefined) res['bic'] = this.bic
		if (this.proxyBankAccount != undefined) res['proxyBankAccount'] = this.proxyBankAccount
		if (this.proxyBic != undefined) res['proxyBic'] = this.proxyBic
		res['preferredFiiForPartners'] = this.preferredFiiForPartners.map((x0) => x0 )
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = false
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedFinancialInstitutionInformation']): DecryptedFinancialInstitutionInformation {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedFinancialInstitutionInformation`)
		const res = new DecryptedFinancialInstitutionInformation({
			name: expectString(extractEntry(jCpy, 'name', false, path), true, [...path, ".name"]),
			key: expectString(extractEntry(jCpy, 'key', false, path), true, [...path, ".key"]),
			bankAccount: expectString(extractEntry(jCpy, 'bankAccount', false, path), true, [...path, ".bankAccount"]),
			bic: expectString(extractEntry(jCpy, 'bic', false, path), true, [...path, ".bic"]),
			proxyBankAccount: expectString(extractEntry(jCpy, 'proxyBankAccount', false, path), true, [...path, ".proxyBankAccount"]),
			proxyBic: expectString(extractEntry(jCpy, 'proxyBic', false, path), true, [...path, ".proxyBic"]),
			preferredFiiForPartners: expectArray(extractEntry(jCpy, 'preferredFiiForPartners', false, path), false, [...path, ".preferredFiiForPartners"], (x0, p0) => expectString(x0, false, p0)),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedFinancialInstitutionInformation at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export class EncryptedFinancialInstitutionInformation {

	name: string | undefined = undefined;

	key: string | undefined = undefined;

	bankAccount: string | undefined = undefined;

	bic: string | undefined = undefined;

	proxyBankAccount: string | undefined = undefined;

	proxyBic: string | undefined = undefined;

	preferredFiiForPartners: Array<string> = [];

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedFinancialInstitutionInformation>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		if ('name' in partial) this.name = partial.name;
		if ('key' in partial) this.key = partial.key;
		if ('bankAccount' in partial) this.bankAccount = partial.bankAccount;
		if ('bic' in partial) this.bic = partial.bic;
		if ('proxyBankAccount' in partial) this.proxyBankAccount = partial.proxyBankAccount;
		if ('proxyBic' in partial) this.proxyBic = partial.proxyBic;
		if ('preferredFiiForPartners' in partial && partial.preferredFiiForPartners !== undefined) this.preferredFiiForPartners = partial.preferredFiiForPartners;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.name != undefined) res['name'] = this.name
		if (this.key != undefined) res['key'] = this.key
		if (this.bankAccount != undefined) res['bankAccount'] = this.bankAccount
		if (this.bic != undefined) res['bic'] = this.bic
		if (this.proxyBankAccount != undefined) res['proxyBankAccount'] = this.proxyBankAccount
		if (this.proxyBic != undefined) res['proxyBic'] = this.proxyBic
		res['preferredFiiForPartners'] = this.preferredFiiForPartners.map((x0) => x0 )
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = true
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedFinancialInstitutionInformation']): EncryptedFinancialInstitutionInformation {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedFinancialInstitutionInformation`)
		const res = new EncryptedFinancialInstitutionInformation({
			name: expectString(extractEntry(jCpy, 'name', false, path), true, [...path, ".name"]),
			key: expectString(extractEntry(jCpy, 'key', false, path), true, [...path, ".key"]),
			bankAccount: expectString(extractEntry(jCpy, 'bankAccount', false, path), true, [...path, ".bankAccount"]),
			bic: expectString(extractEntry(jCpy, 'bic', false, path), true, [...path, ".bic"]),
			proxyBankAccount: expectString(extractEntry(jCpy, 'proxyBankAccount', false, path), true, [...path, ".proxyBankAccount"]),
			proxyBic: expectString(extractEntry(jCpy, 'proxyBic', false, path), true, [...path, ".proxyBic"]),
			preferredFiiForPartners: expectArray(extractEntry(jCpy, 'preferredFiiForPartners', false, path), false, [...path, ".preferredFiiForPartners"], (x0, p0) => expectString(x0, false, p0)),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedFinancialInstitutionInformation at path ${path.join("")}: ${unused}`)}
		return res
	}

}
