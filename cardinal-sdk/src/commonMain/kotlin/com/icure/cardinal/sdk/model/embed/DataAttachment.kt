// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
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
data class DataAttachment(
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
) {
	// region DataAttachment-DataAttachment

	// endregion
}
