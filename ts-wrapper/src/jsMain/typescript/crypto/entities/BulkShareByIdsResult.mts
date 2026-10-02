// auto-generated file
import {EntityReferenceInGroup} from '../../model/EntityReferenceInGroup.mjs';
import {FailedRequestDetails} from './FailedRequestDetails.mjs';
import {SuccessfulRequestDetails} from './SuccessfulRequestDetails.mjs';


/**
 *
 *  Outcome of a "share by ids" bulk operation: sharing many already-existing entities (retrieved server-side by id)
 *  with one or more delegates, using the same share options for the whole batch.
 *
 *  For every entity id that was found (i.e. not in [notFoundIds]) and every delegate the operation was called with,
 *  that (entity id, delegate) pair is accounted for in exactly one place: as a successful request under that entity id
 *  in [successfulRequestsByEntityId], as a delegate under that entity id in [unmodifiedDelegatesByEntityId], or as an
 *  entry in [shareErrors] - never in more than one of these, and never in none of them.
 */
export class BulkShareByIdsResult {

	/**
	 *
	 *  Ids passed to the operation that did not correspond to any entity the current user could read (the id doesn't
	 *  exist, belongs to an entity of a different type, or the current user has no read access to it). These ids
	 *  never appear in any of the other fields below.
	 */
	notFoundIds: Array<string>;

	/**
	 *
	 *  For each entity id, the requests that were actually sent for that entity and succeeded, one per delegate. An
	 *  entity id with no successful request to report is simply absent from this map - it never appears with an empty
	 *  set.
	 *
	 *  In addition to the requested delegates this may contain requests for delegates the operation was not called
	 *  with, recognisable by a [ShareRequestPurpose.Migration] purpose: see [shareErrors] for what those are.
	 */
	successfulRequestsByEntityId: { [ key: string ]: Array<SuccessfulRequestDetails> };

	/**
	 *
	 *  For each entity id, the delegates for which no update request had to be sent at all, because that delegate
	 *  already had access to everything requested with a sufficient access level. This is tracked per delegate, not
	 *  per entity: if an entity was shared with two delegates and only one of them already had everything, only that
	 *  delegate ends up here - the other one ends up under [successfulRequestsByEntityId] or in [shareErrors]
	 *  instead. An entity id with no unmodified delegate to report is simply absent from this map - it never appears
	 *  with an empty set.
	 */
	unmodifiedDelegatesByEntityId: { [ key: string ]: Array<EntityReferenceInGroup> };

	/**
	 *
	 *  Details on the (entity, delegate) pairs for which the share request failed - see [FailedRequestDetails] for
	 *  the distinction between a [FailedRequestDetails.ResolutionFailed] (the requested share options couldn't be
	 *  satisfied locally, e.g. [ShareMetadataBehaviour.Required] was asked for something unavailable) and a
	 *  [FailedRequestDetails.RequestRejected] (a well-formed request was sent and the server rejected it).
	 *
	 *  In addition to the requested delegates this may contain entries for delegates the operation was not called
	 *  with: those are the internal requests the sdk piggybacks on a share to migrate the legacy delegations of the
	 *  current data owner hierarchy, and they carry a [ShareRequestPurpose.Migration] purpose. A failure of such a
	 *  request means the migration didn't happen, not that the requested sharing didn't (the requested sharing of a
	 *  delegate that was not requested was, by definition, not requested). When a requested delegate is also a data
	 *  owner whose legacy delegations need to be migrated the two are done by a single request, whose purpose is
	 *  [ShareRequestPurpose.RequestedShareAndMigration]: a failure of that one does mean the requested sharing
	 *  failed.
	 */
	shareErrors: Array<FailedRequestDetails>;

	constructor(partial: Partial<BulkShareByIdsResult> & Pick<BulkShareByIdsResult, "notFoundIds" | "successfulRequestsByEntityId" | "unmodifiedDelegatesByEntityId" | "shareErrors">) {
		this.notFoundIds = partial.notFoundIds;
		this.successfulRequestsByEntityId = partial.successfulRequestsByEntityId;
		this.unmodifiedDelegatesByEntityId = partial.unmodifiedDelegatesByEntityId;
		this.shareErrors = partial.shareErrors;
	}

}
