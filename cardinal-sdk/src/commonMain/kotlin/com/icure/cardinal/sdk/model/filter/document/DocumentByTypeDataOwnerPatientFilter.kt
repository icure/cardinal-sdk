package com.icure.cardinal.sdk.model.filter.document

import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.embed.DocumentType
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

@SerialName("DocumentByTypeDataOwnerPatientFilter")
@Serializable
public data class DocumentByTypeDataOwnerPatientFilter(
	public val dataOwnerId: String,
	public val documentType: DocumentType,
	public val secretPatientKeys: Set<String>,
	override val desc: String? = null,
) : AbstractFilter<Document>
