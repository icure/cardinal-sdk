// auto-generated file
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';


export class InvoiceDelegateOptions {

	accessLevel: AccessLevel;

	shareEncryptionKey: boolean = false;

	shareSecretId: boolean = false;

	/**
	 *
	 *  Specifies if the id of the patient linked to the invoice should be shared with the delegate
	 */
	sharePatientId: boolean = false;

	constructor(partial: Partial<InvoiceDelegateOptions> & Pick<InvoiceDelegateOptions, "accessLevel">) {
		this.accessLevel = partial.accessLevel;
		if ('shareEncryptionKey' in partial && partial.shareEncryptionKey !== undefined) this.shareEncryptionKey = partial.shareEncryptionKey;
		if ('shareSecretId' in partial && partial.shareSecretId !== undefined) this.shareSecretId = partial.shareSecretId;
		if ('sharePatientId' in partial && partial.sharePatientId !== undefined) this.sharePatientId = partial.sharePatientId;
	}

}
