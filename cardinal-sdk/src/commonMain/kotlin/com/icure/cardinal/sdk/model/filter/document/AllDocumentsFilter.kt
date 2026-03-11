// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.document

import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches all documents without any filtering criteria.
 * /
 */
@SerialName("AllDocumentsFilter")
@Serializable
data class AllDocumentsFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Document>, Filter.AllFilter<Document> {
	// region AllDocumentsFilter-AllDocumentsFilter

	// endregion
}
