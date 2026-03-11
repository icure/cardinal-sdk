// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
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
data class IndexingInfo(
	/**
	 * A map of indexing statuses, keyed by view name, where the value represents the indexing progress
	 * percentage.
	 */
	public val statuses: Map<String, Int>? = null,
) {
	// region IndexingInfo-IndexingInfo

	// endregion
}
