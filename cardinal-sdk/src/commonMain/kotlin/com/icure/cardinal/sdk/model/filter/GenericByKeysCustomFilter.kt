// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter

import com.icure.cardinal.sdk.model.dao.KeyComponent
import com.icure.cardinal.sdk.model.dao.ValueFilterParameters
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String
import kotlin.collections.List

@Serializable
@SerialName("byKeys")
data class GenericByKeysCustomFilter(
	public val viewName: String,
	public val startKey: List<KeyComponent>?,
	public val startDocumentId: String?,
	public val limit: Int,
	public val keyComponents: List<List<KeyComponent>>,
	public val valueFilterParameters: ValueFilterParameters? = null,
) : CustomFilter {
	// region GenericByKeysCustomFilter-GenericByKeysCustomFilter

	// endregion
}
