package com.icure.cardinal.sdk.model.filter.document

import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("DocumentByDataOwnerCodeFilter")
@Serializable
public data class DocumentByDataOwnerCodeFilter(
	public val dataOwnerId: String,
	public val codeType: String,
	public val codeCode: String? = null,
	override val desc: String? = null,
) : AbstractFilter<Document>
