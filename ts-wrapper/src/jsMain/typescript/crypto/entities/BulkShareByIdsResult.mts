// auto-generated file
import {FailedRequestDetails} from './FailedRequestDetails.mjs';


/**
 *
 *  Outcome of a "share by ids" bulk operation: sharing many already-existing entities (retrieved server-side by id)
 *  with one or more delegates, using the same share options for the whole batch.
 *
 *  For every entity id that was found (i.e. not in [notFoundIds]) and every delegate the operation was called with,
 *  that (entity id, delegate id) pair is accounted for in exactly one place: as a delegate id under that entity id in
 *  [successfulDelegateIdsByEntityId], as a delegate id under that entity id in [unmodifiedDelegateIdsByEntityId], or
 *  as an entry in [shareErrors] - never in more than one of these, and never in none of them.
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
	 *  For each entity id, the ids of the delegates for which a share request was actually sent and succeeded. An
	 *  entity id with no successful delegate to report is simply absent from this map - it never appears with an
	 *  empty set.
	 */
	successfulDelegateIdsByEntityId: { [ key: string ]: Array<string> };

	/**
	 *
	 *  For each entity id, the ids of the delegates for which no update request had to be sent at all, because that
	 *  delegate already had access to everything requested with a sufficient access level. This is tracked per
	 *  delegate, not per entity: if an entity was shared with two delegates and only one of them already had
	 *  everything, only that delegate's id ends up here - the other one ends up under
	 *  [successfulDelegateIdsByEntityId] or in [shareErrors] instead. An entity id with no unmodified delegate to
	 *  report is simply absent from this map - it never appears with an empty set.
	 */
	unmodifiedDelegateIdsByEntityId: { [ key: string ]: Array<string> };

	/**
	 *
	 *  Details on the (entity, delegate) pairs for which the share request failed - see [FailedRequestDetails] for
	 *  the distinction between a [FailedRequestDetails.ResolutionFailed] (the requested share options couldn't be
	 *  satisfied locally, e.g. [ShareMetadataBehaviour.Required] was asked for something unavailable) and a
	 *  [FailedRequestDetails.RequestRejected] (a well-formed request was sent and the server rejected it).
	 */
	shareErrors: Array<FailedRequestDetails>;

	constructor(partial: Partial<BulkShareByIdsResult> & Pick<BulkShareByIdsResult, "notFoundIds" | "successfulDelegateIdsByEntityId" | "unmodifiedDelegateIdsByEntityId" | "shareErrors">) {
		this.notFoundIds = partial.notFoundIds;
		this.successfulDelegateIdsByEntityId = partial.successfulDelegateIdsByEntityId;
		this.unmodifiedDelegateIdsByEntityId = partial.unmodifiedDelegateIdsByEntityId;
		this.shareErrors = partial.shareErrors;
	}

}
