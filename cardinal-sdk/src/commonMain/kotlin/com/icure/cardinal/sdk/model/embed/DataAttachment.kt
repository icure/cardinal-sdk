package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 * Represents a data attachment that can be stored either as a CouchDB attachment or via object
 * storage.
 * /
 */
@Serializable
public data class DataAttachment(
	/**
	 * The identifier of the attachment if stored as a CouchDB attachment.
	 */
	public val couchDbAttachmentId: String? = null,
	/**
	 * The identifier of the attachment if stored using the object storage service.
	 */
	public val objectStoreAttachmentId: String? = null,
	/**
	 * The Uniform Type Identifiers of the attachment, ordered by priority.
	 */
	@param:DefaultValue("emptyList()")
	public val utis: List<String> = emptyList(),
)
