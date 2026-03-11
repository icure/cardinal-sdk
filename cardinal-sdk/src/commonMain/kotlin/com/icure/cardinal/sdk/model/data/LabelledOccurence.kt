package com.icure.cardinal.sdk.model.`data`

import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

/**
 * Data transfer object representing a labelled occurrence count, typically used for aggregation
 * results.
 * /
 */
@Serializable
public data class LabelledOccurence(
	/**
	 * The label identifying what is being counted.
	 */
	public val label: String,
	/**
	 * The number of occurrences for this label.
	 */
	public val occurence: Long,
)
