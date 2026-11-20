package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.utils.InternalIcureApi

@InternalIcureApi
data class MinimalBulkShareResult(
	val successfulUpdates: Set<MinimalRequestDetails>,
	val unmodifiedEntitiesIds: Set<String>,
	val updateErrors: List<FailedRequestDetails>
) {
	data class MinimalRequestDetails(
		val delegateReference: EntityReferenceInGroup,
		val entityId: String,
		val purpose: ShareRequestPurpose
	)
}