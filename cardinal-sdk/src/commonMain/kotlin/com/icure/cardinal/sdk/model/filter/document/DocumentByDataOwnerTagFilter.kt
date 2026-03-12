// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.document

import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches documents by data owner and tag.
 * /
 */
@SerialName("DocumentByDataOwnerTagFilter")
@Serializable
data class DocumentByDataOwnerTagFilter(
	/**
	 * The identifier of the data owner.
	 */
	public val dataOwnerId: String,
	/**
	 * The type of the tag to match.
	 */
	public val tagType: String,
	/**
	 * The tag code value to match.
	 */
	public val tagCode: String? = null,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Document> {
	// region DocumentByDataOwnerTagFilter-DocumentByDataOwnerTagFilter

	// endregion
}
