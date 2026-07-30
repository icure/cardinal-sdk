// auto-generated file
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';


export class RelatedPersonDelegateOptions {

	accessLevel: AccessLevel;

	shareEncryptionKey: boolean = false;

	shareSecretId: boolean = false;

	constructor(partial: Partial<RelatedPersonDelegateOptions> & Pick<RelatedPersonDelegateOptions, "accessLevel">) {
		this.accessLevel = partial.accessLevel;
		if ('shareEncryptionKey' in partial && partial.shareEncryptionKey !== undefined) this.shareEncryptionKey = partial.shareEncryptionKey;
		if ('shareSecretId' in partial && partial.shareSecretId !== undefined) this.shareSecretId = partial.shareSecretId;
	}

}
