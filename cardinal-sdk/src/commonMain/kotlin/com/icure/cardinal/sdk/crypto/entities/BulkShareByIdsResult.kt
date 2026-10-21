package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.Serializable

/**
 * Outcome of a "share by ids" bulk operation: sharing many already-existing entities (retrieved server-side by id)
 * with one or more delegates, using the same share options for the whole batch.
 *
 * For every entity id that was found (i.e. not in [notFoundIds]) and every delegate the operation was called with,
 * that (entity id, delegate) pair is accounted for in exactly one place: as a successful request under that entity id
 * in [successfulRequestsByEntityId], as a delegate under that entity id in [unmodifiedDelegatesByEntityId], or as an
 * entry in [shareErrors] - never in more than one of these, and never in none of them.
 */
@Serializable
data class BulkShareByIdsResult(
	/**
	 * Ids passed to the operation that did not correspond to any entity the current user could read (the id doesn't
	 * exist, belongs to an entity of a different type, or the current user has no read access to it). These ids
	 * never appear in any of the other fields below.
	 */
	val notFoundIds: Set<String>,
	/**
	 * For each entity id, the requests that were actually sent for that entity and succeeded, one per delegate. An
	 * entity id with no successful request to report is simply absent from this map - it never appears with an empty
	 * set.
	 *
	 * In addition to the requested delegates this may contain requests for delegates the operation was not called
	 * with, recognisable by a [ShareRequestPurpose.Migration] purpose: see [shareErrors] for what those are.
	 */
	val successfulRequestsByEntityId: Map<String, Set<SuccessfulRequestDetails>>,
	/**
	 * For each entity id, the delegates for which no update request had to be sent at all, because that delegate
	 * already had access to everything requested with a sufficient access level. This is tracked per delegate, not
	 * per entity: if an entity was shared with two delegates and only one of them already had everything, only that
	 * delegate ends up here - the other one ends up under [successfulRequestsByEntityId] or in [shareErrors]
	 * instead. An entity id with no unmodified delegate to report is simply absent from this map - it never appears
	 * with an empty set.
	 */
	val unmodifiedDelegatesByEntityId: Map<String, Set<EntityReferenceInGroup>>,
	/**
	 * Details on the (entity, delegate) pairs for which the share request failed - see [FailedRequestDetails] for
	 * the distinction between a [FailedRequestDetails.ResolutionFailed] (the requested share options couldn't be
	 * satisfied locally, e.g. [ShareMetadataBehaviour.Required] was asked for something unavailable) and a
	 * [FailedRequestDetails.RequestRejected] (a well-formed request was sent and the server rejected it).
	 *
	 * In addition to the requested delegates this may contain entries for delegates the operation was not called
	 * with: those are the internal requests the sdk piggybacks on a share to migrate the legacy delegations of the
	 * current data owner hierarchy, and they carry a [ShareRequestPurpose.Migration] purpose. A failure of such a
	 * request means the migration didn't happen, not that the requested sharing didn't (the requested sharing of a
	 * delegate that was not requested was, by definition, not requested). When a requested delegate is also a data
	 * owner whose legacy delegations need to be migrated the two are done by a single request, whose purpose is
	 * [ShareRequestPurpose.RequestedShareAndMigration]: a failure of that one does mean the requested sharing
	 * failed.
	 */
	val shareErrors: List<FailedRequestDetails>
)

/**
 * Details about a single (entity, delegate) share-or-metadata-update request that was sent and succeeded, returned as
 * part of the success map of a bulk-share operation (e.g. [BulkShareByIdsResult.successfulRequestsByEntityId]).
 */
@Serializable
data class SuccessfulRequestDetails(
	/**
	 * The delegate this request shared with, or updated the delegation of.
	 */
	val delegateReference: EntityReferenceInGroup,
	/**
	 * What this request was for. Most callers can ignore this field: it is [ShareRequestPurpose.RequestedShare] for a
	 * plain share, and the two other values only tell you that the sdk also had (or only had) to migrate the legacy
	 * delegations of that data owner along the way.
	 */
	val purpose: ShareRequestPurpose
)

/**
 * Builds a [BulkShareByIdsResult] out of the lower-level, entity-level-only [MinimalBulkShareResult], recovering a
 * precise per-(entity, delegate) breakdown of what was left unmodified: [MinimalBulkShareResult.unmodifiedEntitiesIds]
 * only tells us that literally none of an entity's delegates needed anything, so whenever at least one delegate of
 * an entity did need a request, the delegates that didn't are otherwise invisible - neither successful, errored, nor
 * counted as unmodified. Since we always know the full set of ([foundIds] x [delegateReferences]) pairs requested,
 * we can recover exactly which of them are missing from both [MinimalBulkShareResult.successfulUpdates] and
 * [MinimalBulkShareResult.updateErrors] and classify them as unmodified too.
 */
@InternalIcureApi
internal fun MinimalBulkShareResult.toBulkShareByIdsResult(
	requestedIds: Set<String>,
	foundIds: Set<String>,
	delegateReferences: Set<EntityReferenceInGroup>
): BulkShareByIdsResult {
	val successfulPairs = successfulUpdates.mapTo(mutableSetOf()) { it.entityId to it.delegateReference }
	val failedPairs = updateErrors.mapTo(mutableSetOf()) { it.entityId to it.delegateReference }
	val unmodifiedPairs = foundIds.flatMapTo(mutableSetOf()) { entityId ->
		delegateReferences.mapNotNull { delegateReference ->
			(entityId to delegateReference).takeIf { it !in successfulPairs && it !in failedPairs }
		}
	}
	return BulkShareByIdsResult(
		notFoundIds = requestedIds - foundIds,
		successfulRequestsByEntityId = successfulUpdates.groupBy(
			{ it.entityId },
			{ SuccessfulRequestDetails(delegateReference = it.delegateReference, purpose = it.purpose) }
		).mapValues { it.value.toSet() },
		unmodifiedDelegatesByEntityId = unmodifiedPairs
			.groupBy({ (entityId, _) -> entityId }, { (_, delegateReference) -> delegateReference })
			.mapValues { it.value.toSet() },
		shareErrors = updateErrors
	)
}
