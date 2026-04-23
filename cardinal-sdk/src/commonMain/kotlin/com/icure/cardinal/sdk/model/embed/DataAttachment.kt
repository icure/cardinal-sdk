// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
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
	/**
	 *
	 *  Algorithm used on the CLIENT SIDE to compress the data attachment.
	 *  Null means that the document was not compressed because the tried algorithms could not actually
	 * compress the data
	 *  (because for example it was an already compressed format) or no algorithms were tried.
	 */
	public val compressionAlgorithm: String? = null,
	/**
	 *
	 *  A string used by the SDK to mark which compression algorithms were tried.
	 *  Null means that no compression algorithms were tried.
	 *  If an SDK reads some data that is not compressed, if this value indicates that the data was
	 * created with an older
	 *  version of the SDK then the SDK may try to use any newly available algorithms to compress the
	 * data.
	 */
	public val triedCompressionAlgorithmsVersion: String? = null,
	/**
	 *
	 *  Value computed by the backend, the actual size of the data stored for the attachment, in bytes.
	 */
	public val storedDataSize: Long? = null,
	/**
	 *
	 *  Value provided by the client, the real size of the data after it has been decrypted and
	 * decompressed, in bytes.
	 *  This value is not used or verified by the backend.
	 */
	public val realDataSize: Long? = null,
) {
	// region DataAttachment-DataAttachment

	// endregion
}
