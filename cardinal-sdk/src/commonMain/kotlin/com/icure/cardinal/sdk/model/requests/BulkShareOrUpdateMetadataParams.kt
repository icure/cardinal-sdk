// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.requests

import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

@Serializable
data class BulkShareOrUpdateMetadataParams(
	public val requestsByEntityId: Map<String, EntityRequestInformation>,
) {
	@Serializable
	public data class EntityRequestInformation(
		public val requests: Map<String, EntityShareOrMetadataUpdateRequest>,
		/**
		 *
		 *  Which delegations can be parents to any newly requested non-root delegations. Some may be
		 * ignored in order to
		 *  simplify the delegation graph, or if the requested permission is root.
		 */
		public val potentialParentDelegations: Set<SecureDelegationKeyString>,
	)
  // region BulkShareOrUpdateMetadataParams-BulkShareOrUpdateMetadataParams

  // endregion
}
