package com.icure.cardinal.sdk.crypto.entities

import com.icure.utils.InternalIcureApi
import kotlinx.serialization.Serializable

/**
 * Outcome of a "share by ids" bulk operation: sharing many already-existing entities (retrieved server-side by id)
 * with one or more delegates, using the same share options for the whole batch.
 *
 * For every entity id that was found (i.e. not in [notFoundIds]) and every delegate the operation was called with,
 * that (entity id, delegate id) pair is accounted for in exactly one place: as a delegate id under that entity id in
 * [successfulDelegateIdsByEntityId], as a delegate id under that entity id in [unmodifiedDelegateIdsByEntityId], or
 * as an entry in [shareErrors] - never in more than one of these, and never in none of them.
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
	 * For each entity id, the ids of the delegates for which a share request was actually sent and succeeded. An
	 * entity id with no successful delegate to report is simply absent from this map - it never appears with an
	 * empty set.
	 */
	val successfulDelegateIdsByEntityId: Map<String, Set<String>>,
	/**
	 * For each entity id, the ids of the delegates for which no update request had to be sent at all, because that
	 * delegate already had access to everything requested with a sufficient access level. This is tracked per
	 * delegate, not per entity: if an entity was shared with two delegates and only one of them already had
	 * everything, only that delegate's id ends up here - the other one ends up under
	 * [successfulDelegateIdsByEntityId] or in [shareErrors] instead. An entity id with no unmodified delegate to
	 * report is simply absent from this map - it never appears with an empty set.
	 */
	val unmodifiedDelegateIdsByEntityId: Map<String, Set<String>>,
	/**
	 * Details on the (entity, delegate) pairs for which the share request failed - see [FailedRequestDetails] for
	 * the distinction between a [FailedRequestDetails.ResolutionFailed] (the requested share options couldn't be
	 * satisfied locally, e.g. [ShareMetadataBehaviour.Required] was asked for something unavailable) and a
	 * [FailedRequestDetails.RequestRejected] (a well-formed request was sent and the server rejected it).
	 */
	val shareErrors: List<FailedRequestDetails>
)

/**
 * Builds a [BulkShareByIdsResult] out of the lower-level, entity-level-only [MinimalBulkShareResult], recovering a
 * precise per-(entity, delegate) breakdown of what was left unmodified: [MinimalBulkShareResult.unmodifiedEntitiesIds]
 * only tells us that literally none of an entity's delegates needed anything, so whenever at least one delegate of
 * an entity did need a request, the delegates that didn't are otherwise invisible - neither successful, errored, nor
 * counted as unmodified. Since we always know the full set of ([foundIds] x [delegateIds]) pairs that were requested,
 * we can recover exactly which of them are missing from both [MinimalBulkShareResult.successfulUpdates] and
 * [MinimalBulkShareResult.updateErrors] and classify them as unmodified too.
 */
@InternalIcureApi
internal fun MinimalBulkShareResult.toBulkShareByIdsResult(
	requestedIds: Set<String>,
	foundIds: Set<String>,
	delegateIds: Set<String>
): BulkShareByIdsResult {
	fun groupDelegateIdsByEntityId(pairs: Set<Pair<String, String>>): Map<String, Set<String>> =
		pairs.groupBy({ (entityId, _) -> entityId }, { (_, delegateId) -> delegateId }).mapValues { it.value.toSet() }

	val successfulPairs = successfulUpdates.mapTo(mutableSetOf()) { it.entityId to it.delegateId }
	val failedPairs = updateErrors.mapTo(mutableSetOf()) { it.entityId to it.delegateReference.entityId }
	val unmodifiedPairs = foundIds.flatMapTo(mutableSetOf()) { entityId ->
		delegateIds.mapNotNull { delegateId ->
			(entityId to delegateId).takeIf { it !in successfulPairs && it !in failedPairs }
		}
	}
	return BulkShareByIdsResult(
		notFoundIds = requestedIds - foundIds,
		successfulDelegateIdsByEntityId = groupDelegateIdsByEntityId(successfulPairs),
		unmodifiedDelegateIdsByEntityId = groupDelegateIdsByEntityId(unmodifiedPairs),
		shareErrors = updateErrors
	)
}
