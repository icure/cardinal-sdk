package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String
import kotlin.collections.Map

/**
 *
 *  DTO providing information about the current indexing status of the database views.
 */
@Serializable
public data class IndexingInfo(
	/**
	 * A map of indexing statuses, keyed by view name, where the value represents the indexing progress
	 * percentage.
	 */
	public val statuses: Map<String, Int>? = null,
)
