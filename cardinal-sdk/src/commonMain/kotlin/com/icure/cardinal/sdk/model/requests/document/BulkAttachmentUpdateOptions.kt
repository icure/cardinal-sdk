// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.requests.document

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

/**
 *
 *  Options for performing a bulk update of document attachments in a single request.
 *  Allows specifying metadata for new or updated attachments and keys of attachments to delete.
 */
@Serializable
data class BulkAttachmentUpdateOptions(
	/**
	 * Metadata for attachments to add or update, keyed by attachment key (the document id for the main
	 * attachment).
	 */
	@param:DefaultValue("emptyMap()")
	public val updateAttachmentsMetadata: Map<String, AttachmentMetadata> = emptyMap(),
	/**
	 * Keys of attachments to delete (use the document id for the main attachment).
	 */
	@param:DefaultValue("emptySet()")
	public val deleteAttachments: Set<String> = emptySet(),
) {
	/**
	 *
	 *  Metadata describing a single attachment within a bulk update operation.
	 */
	@Serializable
	public data class AttachmentMetadata(
		/**
		 * The Uniform Type Identifiers for the attachment, ordered by priority; each UTI must be unique.
		 */
		@param:DefaultValue("emptyList()")
		public val utis: List<String> = emptyList(),
		/**
		 * Whether the attachment data is encrypted.
		 */
		public val dataIsEncrypted: Boolean? = null,
	)
	// region BulkAttachmentUpdateOptions-BulkAttachmentUpdateOptions

	// endregion
}
