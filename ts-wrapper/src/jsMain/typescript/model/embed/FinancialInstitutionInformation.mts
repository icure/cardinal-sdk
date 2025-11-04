// auto-generated file
import {expectArray, expectString} from '../../internal/JsonDecodeUtils.mjs';
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

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.name != undefined) res['name'] = this.name
		if (this.key != undefined) res['key'] = this.key
		if (this.bankAccount != undefined) res['bankAccount'] = this.bankAccount
		if (this.bic != undefined) res['bic'] = this.bic
		if (this.proxyBankAccount != undefined) res['proxyBankAccount'] = this.proxyBankAccount
		if (this.proxyBic != undefined) res['proxyBic'] = this.proxyBic
		res['preferredFiiForPartners'] = this.preferredFiiForPartners.map((x0) => x0 )
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['DecryptedFinancialInstitutionInformation']): DecryptedFinancialInstitutionInformation {
		return new DecryptedFinancialInstitutionInformation({
			name: expectString(json.name, true, [...path, ".name"]),
			key: expectString(json.key, true, [...path, ".key"]),
			bankAccount: expectString(json.bankAccount, true, [...path, ".bankAccount"]),
			bic: expectString(json.bic, true, [...path, ".bic"]),
			proxyBankAccount: expectString(json.proxyBankAccount, true, [...path, ".proxyBankAccount"]),
			proxyBic: expectString(json.proxyBic, true, [...path, ".proxyBic"]),
			preferredFiiForPartners: expectArray(json.preferredFiiForPartners, false, [...path, ".preferredFiiForPartners"], (x0, p0) => expectString(x0, false, p0)),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
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

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.name != undefined) res['name'] = this.name
		if (this.key != undefined) res['key'] = this.key
		if (this.bankAccount != undefined) res['bankAccount'] = this.bankAccount
		if (this.bic != undefined) res['bic'] = this.bic
		if (this.proxyBankAccount != undefined) res['proxyBankAccount'] = this.proxyBankAccount
		if (this.proxyBic != undefined) res['proxyBic'] = this.proxyBic
		res['preferredFiiForPartners'] = this.preferredFiiForPartners.map((x0) => x0 )
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['EncryptedFinancialInstitutionInformation']): EncryptedFinancialInstitutionInformation {
		return new EncryptedFinancialInstitutionInformation({
			name: expectString(json.name, true, [...path, ".name"]),
			key: expectString(json.key, true, [...path, ".key"]),
			bankAccount: expectString(json.bankAccount, true, [...path, ".bankAccount"]),
			bic: expectString(json.bic, true, [...path, ".bic"]),
			proxyBankAccount: expectString(json.proxyBankAccount, true, [...path, ".proxyBankAccount"]),
			proxyBic: expectString(json.proxyBic, true, [...path, ".proxyBic"]),
			preferredFiiForPartners: expectArray(json.preferredFiiForPartners, false, [...path, ".preferredFiiForPartners"], (x0, p0) => expectString(x0, false, p0)),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
	}

}
