package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

/**
 * Represents an appendix attached to an agreement, referencing a specific document and its location
 * within a structured path.
 * /
 */
@Serializable
public data class AgreementAppendix(
	/**
	 * The sequence number of the document.
	 */
	public val docSeq: Int? = null,
	/**
	 * The sequence number of the verse within the document.
	 */
	public val verseSeq: Int? = null,
	/**
	 * The identifier of the linked document.
	 */
	public val documentId: String? = null,
	/**
	 * The path to the appendix content.
	 */
	public val path: String? = null,
)
