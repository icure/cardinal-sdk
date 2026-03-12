// auto-generated file
import {expectArray, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';


/**
 *
 *  Represents information about a financial institution, including bank account details and proxy
 *  account configuration.
 *  /
 */
export interface FinancialInstitutionInformation extends Encryptable {

	/**
	 *
	 *  The name of the financial institution.
	 */
	name: string | undefined;

	/**
	 *
	 *  The key identifying this financial institution information entry.
	 */
	key: string | undefined;

	/**
	 *
	 *  The bank account number (e.g., IBAN).
	 */
	bankAccount: string | undefined;

	/**
	 *
	 *  The BIC/SWIFT code of the bank.
	 */
	bic: string | undefined;

	/**
	 *
	 *  The proxy bank account number.
	 */
	proxyBankAccount: string | undefined;

	/**
	 *
	 *  The BIC/SWIFT code for the proxy bank.
	 */
	proxyBic: string | undefined;

	/**
	 *
	 *  Set of insurance or healthcare party identifiers that prefer this financial institution.
	 */
	preferredFiiForPartners: Array<string>;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

/**
 *
 *  Represents information about a financial institution, including bank account details and proxy
 *  account configuration.
 *  /
 */
export class DecryptedFinancialInstitutionInformation {

	/**
	 *
	 *  The name of the financial institution.
	 */
	name: string | undefined = undefined;

	/**
	 *
	 *  The key identifying this financial institution information entry.
	 */
	key: string | undefined = undefined;

	/**
	 *
	 *  The bank account number (e.g., IBAN).
	 */
	bankAccount: string | undefined = undefined;

	/**
	 *
	 *  The BIC/SWIFT code of the bank.
	 */
	bic: string | undefined = undefined;

	/**
	 *
	 *  The proxy bank account number.
	 */
	proxyBankAccount: string | undefined = undefined;

	/**
	 *
	 *  The BIC/SWIFT code for the proxy bank.
	 */
	proxyBic: string | undefined = undefined;

	/**
	 *
	 *  Set of insurance or healthcare party identifiers that prefer this financial institution.
	 */
	preferredFiiForPartners: Array<string> = [];

	/**
	 *
	 *  The base64-encoded encrypted content.
	 */
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

/**
 *
 *  Represents information about a financial institution, including bank account details and proxy
 *  account configuration.
 *  /
 */
export class EncryptedFinancialInstitutionInformation {

	/**
	 *
	 *  The name of the financial institution.
	 */
	name: string | undefined = undefined;

	/**
	 *
	 *  The key identifying this financial institution information entry.
	 */
	key: string | undefined = undefined;

	/**
	 *
	 *  The bank account number (e.g., IBAN).
	 */
	bankAccount: string | undefined = undefined;

	/**
	 *
	 *  The BIC/SWIFT code of the bank.
	 */
	bic: string | undefined = undefined;

	/**
	 *
	 *  The proxy bank account number.
	 */
	proxyBankAccount: string | undefined = undefined;

	/**
	 *
	 *  The BIC/SWIFT code for the proxy bank.
	 */
	proxyBic: string | undefined = undefined;

	/**
	 *
	 *  Set of insurance or healthcare party identifiers that prefer this financial institution.
	 */
	preferredFiiForPartners: Array<string> = [];

	/**
	 *
	 *  The base64-encoded encrypted content.
	 */
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
