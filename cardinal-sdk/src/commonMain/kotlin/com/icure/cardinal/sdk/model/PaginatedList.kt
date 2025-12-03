package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.collections.List

@Serializable
public data class PaginatedList<T>(
	@DefaultValue("emptyList()")
	public val rows: List<T> = emptyList(),
	public val nextKeyPair: PaginatedDocumentKeyIdPair? = null,
)
