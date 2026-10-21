// auto-generated file
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {ShareMetadataBehaviour} from './ShareMetadataBehaviour.mjs';
import {SharedSecretIdsSource} from './SharedSecretIdsSource.mjs';


/**
 *
 *  A non-sensitive summary of a share request the sdk built out of the share options provided by the caller: what was
 *  asked for each kind of metadata and how much of it the request was carrying, but never the metadata itself -
 *  sharing a secret id or an encryption key means putting the actual value in the request, and those values must not
 *  end up in an error object that callers routinely log.
 *
 *  The counts are those of the resolved request, before the sdk dropped from it whatever the delegate can already
 *  access anyway (see [FailedRequestDetails.RequestRejected.requestSummary] for when you get one of these).
 */
export class ShareRequestSummary {

	/**
	 *
	 *  The permissions that were requested for the delegate.
	 */
	requestedPermissions: RequestedPermission;

	/**
	 *
	 *  Where the secret ids of the request came from.
	 */
	secretIdsSource: SharedSecretIdsSource;

	/**
	 *
	 *  How many secret ids the request was carrying.
	 */
	sharedSecretIdsCount: number;

	/**
	 *
	 *  The behaviour that was requested for the encryption key.
	 */
	encryptionKeysBehaviour: ShareMetadataBehaviour;

	/**
	 *
	 *  How many encryption keys the request was carrying.
	 */
	sharedEncryptionKeysCount: number;

	/**
	 *
	 *  The behaviour that was requested for the owning entity ids.
	 */
	owningEntityIdsBehaviour: ShareMetadataBehaviour;

	/**
	 *
	 *  How many owning entity ids the request was carrying.
	 */
	sharedOwningEntityIdsCount: number;

	constructor(partial: Partial<ShareRequestSummary> & Pick<ShareRequestSummary, "requestedPermissions" | "secretIdsSource" | "sharedSecretIdsCount" | "encryptionKeysBehaviour" | "sharedEncryptionKeysCount" | "owningEntityIdsBehaviour" | "sharedOwningEntityIdsCount">) {
		this.requestedPermissions = partial.requestedPermissions;
		this.secretIdsSource = partial.secretIdsSource;
		this.sharedSecretIdsCount = partial.sharedSecretIdsCount;
		this.encryptionKeysBehaviour = partial.encryptionKeysBehaviour;
		this.sharedEncryptionKeysCount = partial.sharedEncryptionKeysCount;
		this.owningEntityIdsBehaviour = partial.owningEntityIdsBehaviour;
		this.sharedOwningEntityIdsCount = partial.sharedOwningEntityIdsCount;
	}

}
