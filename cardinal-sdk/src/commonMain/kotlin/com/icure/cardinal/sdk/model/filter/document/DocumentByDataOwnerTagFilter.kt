package com.icure.cardinal.sdk.model.filter.document

import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("DocumentByDataOwnerTagFilter")
@Serializable
public data class DocumentByDataOwnerTagFilter(
	public val dataOwnerId: String,
	public val tagType: String,
	public val tagCode: String? = null,
	override val desc: String? = null,
) : AbstractFilter<Document>
