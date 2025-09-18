package com.icure.cardinal.sdk.model.filter.document

import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("AllDocumentsFilter")
@Serializable
public data class AllDocumentsFilter(
	override val desc: String? = null,
) : AbstractFilter<Document>, Filter.AllFilter<Document>
