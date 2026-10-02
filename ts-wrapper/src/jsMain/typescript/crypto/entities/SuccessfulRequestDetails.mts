// auto-generated file
import {EntityReferenceInGroup} from '../../model/EntityReferenceInGroup.mjs';
import {ShareRequestPurpose} from './ShareRequestPurpose.mjs';


/**
 *
 *  Details about a single (entity, delegate) share-or-metadata-update request that was sent and succeeded, returned as
 *  part of the success map of a bulk-share operation (e.g. [BulkShareByIdsResult.successfulRequestsByEntityId]).
 */
export class SuccessfulRequestDetails {

	/**
	 *
	 *  The delegate this request shared with, or updated the delegation of.
	 */
	delegateReference: EntityReferenceInGroup;

	/**
	 *
	 *  What this request was for. Most callers can ignore this field: it is [ShareRequestPurpose.RequestedShare] for a
	 *  plain share, and the two other values only tell you that the sdk also had (or only had) to migrate the legacy
	 *  delegations of that data owner along the way.
	 */
	purpose: ShareRequestPurpose;

	constructor(partial: Partial<SuccessfulRequestDetails> & Pick<SuccessfulRequestDetails, "delegateReference" | "purpose">) {
		this.delegateReference = partial.delegateReference;
		this.purpose = partial.purpose;
	}

}
