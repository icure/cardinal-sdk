// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 * Generic DTO representing a paginated list of results. Contains the current page of rows
 * and a key pair for fetching the next page.
 *
 * @param T The type of elements in the paginated list.
 * /
 */
@Serializable
data class PaginatedList<T>(
	/**
	 * The list of results for the current page.
	 */
	@param:DefaultValue("emptyList()")
	public val rows: List<T> = emptyList(),
	/**
	 * The key-document ID pair to use for fetching the next page of results, or null if this is the
	 * last page.
	 */
	public val nextKeyPair: PaginatedDocumentKeyIdPair? = null,
) {
	// region PaginatedList-PaginatedList
inline fun <Q> map(mapper: (T) -> Q): PaginatedList<Q> = PaginatedList(
		rows = rows.map { mapper(it) },
		nextKeyPair = nextKeyPair
	)
	// endregion
}
