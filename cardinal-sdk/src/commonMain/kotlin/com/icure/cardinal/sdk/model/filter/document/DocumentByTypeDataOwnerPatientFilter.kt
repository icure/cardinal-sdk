package com.icure.cardinal.sdk.model.filter.document

import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.embed.DocumentType
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

/**
 * Filter that matches documents by document type, data owner, and patient.
 * /
 */
@SerialName("DocumentByTypeDataOwnerPatientFilter")
@Serializable
public data class DocumentByTypeDataOwnerPatientFilter(
	/**
	 * The identifier of the data owner.
	 */
	public val dataOwnerId: String,
	/**
	 * The type of document to match.
	 */
	public val documentType: DocumentType,
	/**
	 * The set of secret patient keys used for secure delegation matching.
	 */
	public val secretPatientKeys: Set<String>,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<Document>
