package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 *
 *  DTO wrapping a list of identifier-revision pairs, used for bulk operations on versioned
 * entities.
 */
@Serializable
public data class ListOfIdsAndRev(
	/**
	 * The list of identifier-revision pairs.
	 */
	public val ids: List<IdWithRev>,
)
