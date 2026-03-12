// auto-generated file
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {SecretIdShareOptions} from './SecretIdShareOptions.mjs';
import {ShareMetadataBehaviour} from './ShareMetadataBehaviour.mjs';


export class DocumentShareOptions {

	requestedPermissions: RequestedPermission = RequestedPermission.MaxWrite;

	shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable;

	/**
	 *
	 *  Specifies if the id of the message linked to the document (if any) should be shared with the delegate
	 */
	shareMessageId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable;

	shareSecretIds: SecretIdShareOptions = new SecretIdShareOptions.AllAvailable({});

	constructor(partial: Partial<DocumentShareOptions>) {
		if ('requestedPermissions' in partial && partial.requestedPermissions !== undefined) this.requestedPermissions = partial.requestedPermissions;
		if ('shareEncryptionKey' in partial && partial.shareEncryptionKey !== undefined) this.shareEncryptionKey = partial.shareEncryptionKey;
		if ('shareMessageId' in partial && partial.shareMessageId !== undefined) this.shareMessageId = partial.shareMessageId;
		if ('shareSecretIds' in partial && partial.shareSecretIds !== undefined) this.shareSecretIds = partial.shareSecretIds;
	}

}
