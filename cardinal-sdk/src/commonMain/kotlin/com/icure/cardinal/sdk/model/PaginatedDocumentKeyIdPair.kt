package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlin.String

@Serializable
public data class PaginatedDocumentKeyIdPair(
	public val startKey: JsonElement? = null,
	public val startKeyDocId: String? = null,
)
