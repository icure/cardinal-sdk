package com.icure.cardinal.sdk.model.requests

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class EntityBulkShareResult<T>(
	public val updatedEntity: T? = null,
	public val entityId: String,
	public val entityRev: String? = null,
	@param:DefaultValue("emptyMap()")
	public val rejectedRequests: Map<String, RejectedShareOrMetadataUpdateRequest> = emptyMap(),
) {
	@Serializable
	public data class RejectedShareOrMetadataUpdateRequest(
		public val code: Int,
		@param:DefaultValue("false")
		public val shouldRetry: Boolean = false,
		public val reason: String,
	)
	// region EntityBulkShareResult-EntityBulkShareResult
inline fun <O>map(mapper: (T) -> O): EntityBulkShareResult<O> = EntityBulkShareResult(
		updatedEntity = updatedEntity?.let { mapper(it) },
		entityId = entityId,
		entityRev = entityRev,
		rejectedRequests = rejectedRequests
	)
	// endregion
}
