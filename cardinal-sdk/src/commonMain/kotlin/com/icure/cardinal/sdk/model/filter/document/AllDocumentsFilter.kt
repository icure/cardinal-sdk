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
public data class AllDocumentsFilter(
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Document>, Filter.AllFilter<Document>
