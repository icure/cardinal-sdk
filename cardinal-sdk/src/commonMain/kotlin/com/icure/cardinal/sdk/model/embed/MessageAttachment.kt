package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 * Represents an attachment associated with a message, specifying its location type and document
 * identifiers.
 * /
 */
@Serializable
public data class MessageAttachment(
	/**
	 * The location type of the attachment (annex or body).
	 */
	public val type: DocumentLocation? = null,
	/**
	 * The list of document identifiers for this attachment.
	 */
	@param:DefaultValue("emptyList()")
	public val ids: List<String> = emptyList(),
)
