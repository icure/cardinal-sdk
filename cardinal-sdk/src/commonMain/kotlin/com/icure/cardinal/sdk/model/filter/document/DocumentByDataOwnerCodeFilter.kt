package com.icure.cardinal.sdk.model.filter.document

import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches documents by data owner and code.
 * /
 */
@SerialName("DocumentByDataOwnerCodeFilter")
@Serializable
public data class DocumentByDataOwnerCodeFilter(
	/**
	 * The identifier of the data owner.
	 */
	public val dataOwnerId: String,
	/**
	 * The type of the code to match.
	 */
	public val codeType: String,
	/**
	 * The code value to match.
	 */
	public val codeCode: String? = null,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Document>
