package com.icure.cardinal.sdk.model.filter.document

import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("DocumentByDataOwnerCodeFilter")
@Serializable
data class DocumentByDataOwnerCodeFilter(
	public val dataOwnerId: String,
	public val codeType: String,
	public val codeCode: String? = null,
	override val desc: String? = null,
) : AbstractFilter<Document> {
	// region DocumentByDataOwnerCodeFilter-DocumentByDataOwnerCodeFilter
	// endregion
}
