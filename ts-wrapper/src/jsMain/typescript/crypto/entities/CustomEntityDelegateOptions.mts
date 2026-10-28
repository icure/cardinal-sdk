// auto-generated file
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';


export class CustomEntityDelegateOptions {

	accessLevel: AccessLevel;

	shareEncryptionKey: boolean = false;

	shareSecretId: boolean = false;

	/**
	 *
	 *  Specifies if the id of the entity owning the custom entity (if any) should be shared with the delegate
	 */
	shareOwningEntityId: boolean = false;

	constructor(partial: Partial<CustomEntityDelegateOptions> & Pick<CustomEntityDelegateOptions, "accessLevel">) {
		this.accessLevel = partial.accessLevel;
		if ('shareEncryptionKey' in partial && partial.shareEncryptionKey !== undefined) this.shareEncryptionKey = partial.shareEncryptionKey;
		if ('shareSecretId' in partial && partial.shareSecretId !== undefined) this.shareSecretId = partial.shareSecretId;
		if ('shareOwningEntityId' in partial && partial.shareOwningEntityId !== undefined) this.shareOwningEntityId = partial.shareOwningEntityId;
	}

}
