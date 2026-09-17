// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter

import com.icure.cardinal.sdk.model.dao.KeyComponent
import com.icure.cardinal.sdk.model.dao.RangeQueryParameters
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String
import kotlin.collections.List

@Serializable
data class GenericByRangeCustomFilter(
	public val viewName: String,
	public val startKey: List<KeyComponent>?,
	public val startDocumentId: String?,
	public val limit: Int,
	public val nonRangeKeyComponents: List<List<KeyComponent>>,
	public val range: RangeQueryParameters,
) : CustomFilter {
	// region GenericByRangeCustomFilter-GenericByRangeCustomFilter

	// endregion
}
