// auto-generated file
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';


export class AccessLogDelegateOptions {

	accessLevel: AccessLevel;

	shareEncryptionKey: boolean = false;

	shareSecretId: boolean = false;

	/**
	 *
	 *  Specifies if the id of the patient linked to the access log should be shared with the delegate
	 */
	sharePatientId: boolean = false;

	constructor(partial: Partial<AccessLogDelegateOptions> & Pick<AccessLogDelegateOptions, "accessLevel">) {
		this.accessLevel = partial.accessLevel;
		if ('shareEncryptionKey' in partial && partial.shareEncryptionKey !== undefined) this.shareEncryptionKey = partial.shareEncryptionKey;
		if ('shareSecretId' in partial && partial.shareSecretId !== undefined) this.shareSecretId = partial.shareSecretId;
		if ('sharePatientId' in partial && partial.sharePatientId !== undefined) this.sharePatientId = partial.sharePatientId;
	}

}
