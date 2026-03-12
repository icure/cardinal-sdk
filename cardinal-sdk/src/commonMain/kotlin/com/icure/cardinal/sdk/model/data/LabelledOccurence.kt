// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
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
data class LabelledOccurence(
	/**
	 * The label identifying what is being counted.
	 */
	public val label: String,
	/**
	 * The number of occurrences for this label.
	 */
	public val occurence: Long,
) {
	// region LabelledOccurence-LabelledOccurence

	// endregion
}
