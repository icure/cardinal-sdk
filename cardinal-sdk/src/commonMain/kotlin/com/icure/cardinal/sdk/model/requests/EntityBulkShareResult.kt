package com.icure.cardinal.sdk.model.requests

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.Map

@Serializable
public data class EntityBulkShareResult<T>(
	public val updatedEntity: T? = null,
	public val entityId: String,
	public val entityRev: String? = null,
	@DefaultValue("emptyMap()")
	public val rejectedRequests: Map<String, RejectedShareOrMetadataUpdateRequest> = emptyMap(),
) {
	@Serializable
	public data class RejectedShareOrMetadataUpdateRequest(
		public val code: Int,
		@DefaultValue("false")
		public val shouldRetry: Boolean = false,
		public val reason: String,
	)
}
