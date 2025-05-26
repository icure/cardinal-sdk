package com.icure.cardinal.sdk.model.filter.document

import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.embed.DocumentType
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("DocumentByTypeDataOwnerPatientFilter")
@Serializable
data class DocumentByTypeDataOwnerPatientFilter(
	public val dataOwnerId: String,
	public val documentType: DocumentType,
	public val secretPatientKeys: Set<String>,
	override val desc: String? = null,
) : AbstractFilter<Document> {
	public val dtoSerialName: String
	// region DocumentByTypeDataOwnerPatientFilter-DocumentByTypeDataOwnerPatientFilter

	// endregion
}
