package com.icure.cardinal.sdk.model.requests

import kotlinx.serialization.Serializable

@Serializable
public data class EntityShareOrMetadataUpdateRequest(
	public val share: EntityShareRequest? = null,
	public val update: EntitySharedMetadataUpdateRequest? = null,
)
