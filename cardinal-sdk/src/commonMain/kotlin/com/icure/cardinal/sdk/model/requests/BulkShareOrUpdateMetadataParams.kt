package com.icure.cardinal.sdk.model.requests

import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

@Serializable
public data class BulkShareOrUpdateMetadataParams(
	public val requestsByEntityId: Map<String, EntityRequestInformation>,
) {
	@Serializable
	public data class EntityRequestInformation(
		public val requests: Map<String, EntityShareOrMetadataUpdateRequest>,
		public val potentialParentDelegations: Set<SecureDelegationKeyString>,
	)
}
