// auto-generated file
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {SecretIdShareOptions} from './SecretIdShareOptions.mjs';
import {ShareMetadataBehaviour} from './ShareMetadataBehaviour.mjs';


export class CustomEntityShareOptions {

	requestedPermissions: RequestedPermission = RequestedPermission.MaxWrite;

	shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable;

	/**
	 *
	 *  Specifies if the id of the entity owning the custom entity (if any) should be shared with the delegate
	 */
	shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable;

	shareSecretIds: SecretIdShareOptions = new SecretIdShareOptions.AllAvailable({});

	constructor(partial: Partial<CustomEntityShareOptions>) {
		if ('requestedPermissions' in partial && partial.requestedPermissions !== undefined) this.requestedPermissions = partial.requestedPermissions;
		if ('shareEncryptionKey' in partial && partial.shareEncryptionKey !== undefined) this.shareEncryptionKey = partial.shareEncryptionKey;
		if ('shareOwningEntityIds' in partial && partial.shareOwningEntityIds !== undefined) this.shareOwningEntityIds = partial.shareOwningEntityIds;
		if ('shareSecretIds' in partial && partial.shareSecretIds !== undefined) this.shareSecretIds = partial.shareSecretIds;
	}

}
