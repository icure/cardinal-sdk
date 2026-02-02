package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class PaginatedList<T>(
	@param:DefaultValue("emptyList()")
	public val rows: List<T> = emptyList(),
	public val nextKeyPair: PaginatedDocumentKeyIdPair? = null,
) {
	// region PaginatedList-PaginatedList
inline fun <Q> map(mapper: (T) -> Q): PaginatedList<Q> = PaginatedList(
		rows = rows.map { mapper(it) },
		nextKeyPair = nextKeyPair
	)
	// endregion
}
