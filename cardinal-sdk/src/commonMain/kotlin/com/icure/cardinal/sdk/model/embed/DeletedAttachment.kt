package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

/**
 * Represents metadata about an attachment that has been deleted, preserving its former storage
 * identifiers and deletion time.
 * /
 */
@Serializable
public data class DeletedAttachment(
	/**
	 * The former CouchDB attachment identifier, if the attachment was stored as a CouchDB attachment.
	 */
	public val couchDbAttachmentId: String? = null,
	/**
	 * The former object storage identifier, if the attachment was stored using the object storage
	 * service.
	 */
	public val objectStoreAttachmentId: String? = null,
	/**
	 * The key the attachment was associated to, or null for main attachments.
	 */
	public val key: String? = null,
	/**
	 * The timestamp (unix epoch in ms) when the attachment was deleted.
	 */
	public val deletionTime: Long? = null,
)
