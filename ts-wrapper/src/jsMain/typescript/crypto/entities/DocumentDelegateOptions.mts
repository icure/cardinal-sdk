// auto-generated file
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';


export class DocumentDelegateOptions {

	accessLevel: AccessLevel;

	shareEncryptionKey: boolean = false;

	shareSecretId: boolean = false;

	/**
	 *
	 *  Specifies if the id of the message linked to the document (if any) should be shared with the delegate
	 */
	shareMessageId: boolean = false;

	constructor(partial: Partial<DocumentDelegateOptions> & Pick<DocumentDelegateOptions, "accessLevel">) {
		this.accessLevel = partial.accessLevel;
		if ('shareEncryptionKey' in partial && partial.shareEncryptionKey !== undefined) this.shareEncryptionKey = partial.shareEncryptionKey;
		if ('shareSecretId' in partial && partial.shareSecretId !== undefined) this.shareSecretId = partial.shareSecretId;
		if ('shareMessageId' in partial && partial.shareMessageId !== undefined) this.shareMessageId = partial.shareMessageId;
	}

}
