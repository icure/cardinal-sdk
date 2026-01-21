package com.icure.cardinal.sdk.model.filter.document

import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("DocumentByDataOwnerTagFilter")
@Serializable
data class DocumentByDataOwnerTagFilter(
	dataOwnerId: String,
	tagType: String,
	tagCode: String? = null,
	desc: String? = null,
) : AbstractFilter<Document> {
	// region DocumentByDataOwnerTagFilter-DocumentByDataOwnerTagFilter

	// endregion
}
