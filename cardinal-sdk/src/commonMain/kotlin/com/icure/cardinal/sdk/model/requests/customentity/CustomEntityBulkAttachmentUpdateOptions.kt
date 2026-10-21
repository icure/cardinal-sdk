// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.requests.customentity

import com.icure.cardinal.sdk.model.requests.document.BulkAttachmentUpdateOptions
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

/**
 *
 *  Options for performing a bulk update of custom entity attachments in a single request.
 *  Allows specifying metadata for new or updated attachments and keys of attachments to delete.
 */
@Serializable
data class CustomEntityBulkAttachmentUpdateOptions(
	/**
	 * Metadata for attachments to add or update, keyed by attachment key.
	 */
	@param:DefaultValue("emptyMap()")
	public val updateAttachmentsMetadata: Map<String, BulkAttachmentUpdateOptions.AttachmentMetadata> = emptyMap(),
	/**
	 * Keys of attachments to delete.
	 */
	@param:DefaultValue("emptySet()")
	public val deleteAttachments: Set<String> = emptySet(),
) {
	// region CustomEntityBulkAttachmentUpdateOptions-CustomEntityBulkAttachmentUpdateOptions

	// endregion
}
