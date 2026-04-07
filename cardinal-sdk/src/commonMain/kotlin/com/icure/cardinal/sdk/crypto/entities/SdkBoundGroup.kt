package com.icure.cardinal.sdk.crypto.entities

import com.icure.utils.InternalIcureApi
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract
import kotlin.jvm.JvmInline

@JvmInline
@InternalIcureApi
value class SdkBoundGroup(
	val groupId: String
)

@InternalIcureApi
@OptIn(ExperimentalContracts::class)
fun SdkBoundGroup?.resolve(groupId: String?): String? {
	contract {
		returnsNotNull() implies (this@resolve != null)
	}
	return when {
		this == null -> {
			require(groupId == null) {
				"Can't use in-group methods on kraken-lite"
			}
			null
		}

		this.groupId == groupId ->
			null

		else ->
			groupId
	}
}

/**
 * Converts a set of data owner IDs belonging to this SDK's bound group into the reference strings
 * as they appear inside entities that live in [entityGroupId].
 *
 * When [entityGroupId] is the same group as this bound group (or there is no bound group), the IDs
 * are returned as-is. When the entities live in a different group, each ID is prefixed with this
 * SDK's own group ID (e.g. "myGroupId/dataOwnerId"), because that is how the current user's
 * delegator/delegate references are stored in foreign entities.
 */
@InternalIcureApi
fun SdkBoundGroup?.selfIdsAsReferenceStringsForEntityGroup(entityGroupId: String?, selfIds: Set<String>): Set<String> =
	if (resolve(entityGroupId) != null)
		selfIds.mapTo(mutableSetOf()) { "$groupId/$it" } // safe: contract on resolve guarantees this != null
	else
		selfIds
