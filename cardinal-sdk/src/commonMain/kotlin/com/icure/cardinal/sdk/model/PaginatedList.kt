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
public data class PaginatedList<T>(
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
)
